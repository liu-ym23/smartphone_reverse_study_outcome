package up9;

import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface i0 extends j0 {
    void f(LarusFragmentMediaSelectorBinding r1);

    void g(LifecycleOwner r1, LarusFragmentMediaSelectorBinding r2, BottomSheetViewModel r3, MediaGalleryLiveDataViewModel r4);

    void h(ViewPager2 r1);

    void j(ViewPager2 r1, boolean r2, boolean r3);

    void onDestroyView();
}
