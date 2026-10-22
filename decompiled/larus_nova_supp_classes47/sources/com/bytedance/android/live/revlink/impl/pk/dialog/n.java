package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PkRandomMatchDialogV2 a;

    public n(PkRandomMatchDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r0 = this.a.m;
        if (r0 == null) goto L11;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L10;
        r1.height = ((Integer) r3).intValue();
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        View r4 = this.a.m;
        if (r4 == null) goto L15;
        r4.requestLayout();
        return;
    }
}
