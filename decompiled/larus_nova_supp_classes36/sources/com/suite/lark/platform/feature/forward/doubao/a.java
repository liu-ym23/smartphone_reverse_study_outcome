package com.suite.lark.platform.feature.forward.doubao;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DoubaoForwardConfirmFragment a;

    public a(DoubaoForwardConfirmFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animator");
        DoubaoForwardConfirmFragment r0 = this.a;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        int r5 = ((Integer) r4).intValue();
        int r1 = DoubaoForwardConfirmFragment.v;
        r0.Y90(r5);
    }
}
