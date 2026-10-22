package com.obric.oui.orecyclerview.widget;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f13837a;

    public k(l r5) {
        this.f13837a = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        int r10 = (int) (((Float) r5.getAnimatedValue()).floatValue() * 255.0f);
        l r11 = this.f13837a;
        r11.f13848c.setAlpha(r10);
        r11.d.setAlpha(r10);
        r11.s.invalidate();
    }
}
