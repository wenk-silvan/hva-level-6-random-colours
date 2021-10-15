package nl.hva.madlevel6task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import nl.hva.madlevel6task1.databinding.FragmentColorBinding

class ColorFragment : Fragment() {
    private var _binding: FragmentColorBinding? = null
    private val binding get() = _binding!!
    private val colors: List<ColorItem> = arrayListOf()
    private val colorAdapter = ColorAdapter(colors, ::onColorClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentColorBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        binding.rvColors.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvColors.adapter = colorAdapter
    }

    private fun onColorClick(colorItem: ColorItem) {
        Snackbar.make(binding.rvColors, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG)
            .show()
    }
}