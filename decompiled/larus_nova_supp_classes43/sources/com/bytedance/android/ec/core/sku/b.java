package com.bytedance.android.ec.core.sku;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CommonMarqueeView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public b(CommonMarqueeView r1, View r10, View r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r10) {
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L10;
        int r12 = ((Integer) r11).intValue();
        if (this.a.a == false) goto L7;
        this.b.setTranslationY(-r12);
        this.c.setTranslationY((this.b.getHeight() + this.a.b) - r12);
        return;
    L7:
        this.b.setTranslationX(-r12);
        this.c.setTranslationX((this.b.getWidth() + this.a.b) - r12);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
