package up9;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.j2;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface g0 extends j0 {

    public interface a {
        void a(Context r1, MediaListAdapterV2 r2);

        void b(LifecycleOwner r1, BottomSheetViewModel r2, LarusFragmentMediaListBinding r3);

        vp9.m c(Context r1, b r2);
    }

    public interface b {
        void a(op9.d r1, int r2, ClickType r3);
    }

    a c();

    MediaListAdapterV2 n(Context r1, int r2, int r3, j2 r4);

    void onDestroyView();
}
