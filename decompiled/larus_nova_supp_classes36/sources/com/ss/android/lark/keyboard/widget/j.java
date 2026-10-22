package com.ss.android.lark.keyboard.widget;

import android.animation.ValueAnimator;
import android.view.animation.PathInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ RoundedIconTextView a;

    public j(RoundedIconTextView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        RoundedIconTextView r0 = this.a;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) r4).floatValue();
        PathInterpolator r1 = RoundedIconTextView.F;
        r0.b(r5);
    }
}
