package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ NestedScrollableContainer a;

    public /* synthetic */ z0(NestedScrollableContainer r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        NestedScrollableContainer r0 = this.a;
        int r1 = NestedScrollableContainer.n;
        Intrinsics.checkNotNullParameter(r3, "it");
        r0.b();
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r0.scrollTo(0, ((Integer) r4).intValue());
    }
}
