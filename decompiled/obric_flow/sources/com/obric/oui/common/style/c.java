package com.obric.oui.common.style;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OStateGradientDrawable f12451b;

    public /* synthetic */ c(OStateGradientDrawable r5, int r10) {
        this.f12450a = r10;
        this.f12451b = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        int r10 = this.f12450a;
        OStateGradientDrawable r11 = this.f12451b;
        switch(r10) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        OStateGradientDrawable.b(r11, r5);
        return;
    L6:
        OStateGradientDrawable.a(r11, r5);
    }
}
