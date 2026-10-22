package up9;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 implements g0.a {
    public final MediaTab a;
    public final MediaGalleryUIConfig b;
    public final wp9.g c;

    public e0(MediaTab r2, MediaGalleryUIConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "curMediaTab");
        Intrinsics.checkNotNullParameter(r3, "uiConfig");
        this.a = r2;
        this.b = r3;
        this.c = new wp9.g();
    }

    @Override // up9.g0.a
    public final void a(Context r3, MediaListAdapterV2 r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        r4.g = kp9.b.a.c(r3, this.b.g);
    }

    @Override // up9.g0.a
    public final vp9.m c(Context r6, g0.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "selectionState");
        if (this.a != CollectionsKt.first(this.b.a)) goto L13;
        RoundingParams r0 = RoundingParams.fromCornersRadius(i5.h());
        r0.setBorder(ContextCompat.getColor(r6, v19.c.b(2130972086, r6, 2131103159)), i5.b());
        int r1 = 0;
        if (this.b.p == true) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L12;
        r1 = 2;
    L12:
        Intrinsics.checkNotNull(r0);
        return new vp9.m(r0, -1, r1, this.b.y);
    L7:
        if ((r7 instanceof k0) == false) goto L9;
        r8 = true;
        goto L10
    L13:
        RoundingParams r2 = RoundingParams.fromCornersRadius(0.0f);
        r2.setBorder(ContextCompat.getColor(r6, v19.c.b(2130972086, r6, 2131103159)), i5.b());
        Intrinsics.checkNotNull(r2);
        return new vp9.m(r2, -1, r7 instanceof k0 ? 1 : 0, this.b.y);
    }

    @Override // up9.g0.a
    public final void b(final LifecycleOwner r10, BottomSheetViewModel r11, final LarusFragmentMediaListBinding r12) {
        Intrinsics.checkNotNullParameter(r10, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "binding");
        final MediaGalleryUIConfig r8 = this.b;
        Integer r0 = r8.o;
        if (r0 == null) goto L14;
        int r1 = r0.intValue();
        Integer r2 = r8.l;
        if (r2 == null) goto L15;
        int r3 = r2.intValue();
        Integer r4 = r8.m;
        if (r4 == null) goto L16;
        int r5 = r4.intValue();
        int r6 = r8.n;
        final wp9.e r7 = new wp9.e(r6, r1);
        final wp9.e r9 = new wp9.e(r6, 0);
        final wp9.e r13 = new wp9.e(r3, r5);
        if (r11 == null) goto L17;
        MutableLiveData<Float> r14 = r11.getOnSlide();
        if (r14 == null) goto L18;
        r14.observe(r10, new h0(new c0(r10, this, r12, r13, r9, r7, r8)));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
