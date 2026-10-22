package com.obric.oui.titlebar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar.Behavior f6654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f6655b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f6656m;

    public a(OUnitedTitleBar.Behavior r8, CoordinatorLayout r10, OUnitedTitleBar r11) {
        this.f6654a = r8;
        this.f6655b = r10;
        this.f6656m = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        i.f(r8, "animation");
        Object r10 = r8.getAnimatedValue();
        if (r10 == null) goto L7;
        int r11 = ((Integer) r10).intValue();
        CoordinatorLayout r12 = this.f6655b;
        OUnitedTitleBar r13 = this.f6656m;
        this.f6654a.J(r12, r13, r11);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
