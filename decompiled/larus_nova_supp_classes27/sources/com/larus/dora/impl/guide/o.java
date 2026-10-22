package com.larus.dora.impl.guide;

import com.larus.dora.impl.databinding.LarusDoraGuideBindDeviceDialogBinding;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ DoraBindGuide.BindBottomSheetDialogFragment a;

    public /* synthetic */ o(DoraBindGuide.BindBottomSheetDialogFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraBindGuide.BindBottomSheetDialogFragment r0 = this.a;
        LarusDoraGuideBindDeviceDialogBinding r1 = r0.f;
        if (r1 == null) goto L13;
        DoraBindGuide.BindBottomSheetDialogFragment.Phase r2 = r0.e;
        int r3 = DoraBindGuide.BindBottomSheetDialogFragment.b.a[r2.ordinal()];
        if (r3 != 1) goto L7;
        ImageLoaderKt.u(r1.b, "https://p3-starweave-source.byteimg.com/h/user_guide/image_dora_h_bind_guide_avatar_v1.png", "dora_user_guide");
        r1.f.setText(2131902195);
        r1.e.setText(2131902194);
        r1.d.setText(2131902193);
        return;
    L7:
        if (r3 != 2) goto L10;
        ImageLoaderKt.u(r1.b, "https://p3-starweave-source.byteimg.com/h/user_guide/image_dora_h_bind_guide_fail_avatar.png", "dora_user_guide");
        r1.f.setText(2131902192);
        r1.e.setText(2131902191);
        r1.d.setText(2131902190);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
