package com.ss.android.lark.forseti.widget;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ForsetiNormalChainDraggingView a;

    public b(ForsetiNormalChainDraggingView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ForsetiNormalChainDraggingView r0 = this.a;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r0.f = ((Float) r4).floatValue();
        this.a.invalidate();
    }
}
