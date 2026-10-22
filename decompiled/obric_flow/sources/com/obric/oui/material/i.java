package com.obric.oui.material;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OMaterialDrawable f13661b;

    public /* synthetic */ i(OMaterialDrawable r5, int r10) {
        this.f13660a = r10;
        this.f13661b = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        int r10 = this.f13660a;
        OMaterialDrawable r11 = this.f13661b;
        switch(r10) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        OMaterialDrawable.b(r11, r5);
        return;
    L6:
        OMaterialDrawable.d(r11, r5);
    }
}
