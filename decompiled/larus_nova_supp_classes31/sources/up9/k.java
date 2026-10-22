package up9;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k extends f0 {
    public k(MediaTab r2, MediaGalleryUIConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "curMediaTab");
        Intrinsics.checkNotNullParameter(r3, "uiConfig");
        super(r2, r3);
    }

    @Override // up9.f0, up9.g0.a
    public final void b(LifecycleOwner r2, BottomSheetViewModel r3, final LarusFragmentMediaListBinding r4) {
        Intrinsics.checkNotNullParameter(r2, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "binding");
        if (r3 == null) goto L8;
        MutableLiveData<Integer> r5 = r3.getBottomSheetOnStateChanged();
        if (r5 == null) goto L9;
        r5.observe(r2, new h0(new j(r4)));
        return;
    L9:
        return;
    }
}
