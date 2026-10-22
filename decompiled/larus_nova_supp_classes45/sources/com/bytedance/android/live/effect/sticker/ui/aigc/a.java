package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AigcTaskPanel a;

    public a(AigcTaskPanel r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        AigcTaskPanel r0 = this.a;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        AigcTaskPanel.S5(r0, ((Float) r3).floatValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
