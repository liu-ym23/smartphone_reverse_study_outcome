package com.bytedance.android.live.effect.base;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AdjustPercentBar c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        float r6 = ((Float) r5.getAnimatedValue()).floatValue();
        AdjustPercentBar r0 = this.c;
        int r1 = this.a;
        r0.v = (int) (r1 + ((this.b - r1) * r6));
        r0.invalidate();
    }

    public a(AdjustPercentBar r1, int r2, int r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
