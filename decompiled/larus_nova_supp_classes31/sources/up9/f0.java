package up9;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class f0 implements g0.a {
    public final MediaGalleryUIConfig a;

    @Override // up9.g0.a
    public void b(LifecycleOwner r1, BottomSheetViewModel r2, LarusFragmentMediaListBinding r3) {
        Intrinsics.checkNotNullParameter(r1, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "binding");
    }

    public f0(MediaTab r2, MediaGalleryUIConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "curMediaTab");
        Intrinsics.checkNotNullParameter(r3, "uiConfig");
        this.a = r3;
    }

    @Override // up9.g0.a
    public final void a(Context r3, MediaListAdapterV2 r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        boolean r5 = kp9.b.a.c(r3, this.a.g);
        r4.g = r5;
        r4.A2(r5);
    }

    @Override // up9.g0.a
    public final vp9.m c(Context r4, g0.b r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "selectionState");
        RoundingParams r0 = RoundingParams.fromCornersRadius(0.0f);
        r0.setBorder(ContextCompat.getColor(r4, v19.c.b(2130972086, r4, 2131103159)), i5.b());
        Intrinsics.checkNotNull(r0);
        return new vp9.m(r0, -1, r5 instanceof k0 ? 1 : 0, this.a.y);
    }
}
