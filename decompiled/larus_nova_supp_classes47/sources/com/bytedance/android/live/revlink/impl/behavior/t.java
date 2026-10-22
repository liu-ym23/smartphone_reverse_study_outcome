package com.bytedance.android.live.revlink.impl.behavior;

import android.widget.PopupWindow;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements PopupWindow.OnDismissListener {
    public final /* synthetic */ ToolbarPkBehavior a;
    public final /* synthetic */ zr2.e b;

    public t(ToolbarPkBehavior r1, zr2.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        int r0 = this.b.h;
        if (r0 != 12) goto L5;
    L6:
        this.a.w = false;
    L7:
        LottieAnimationView r1 = this.a.m;
        if (r1 == null) goto L13;
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 0) goto L14;
        LottieAnimationView r2 = this.a.m;
        Intrinsics.checkNotNull(r2);
        r2.setVisibility(8);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0 != 13) goto L7;
        goto L6
    }
}
