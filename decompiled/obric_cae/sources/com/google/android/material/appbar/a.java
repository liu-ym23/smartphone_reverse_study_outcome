package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f4316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f4317b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f4318m;

    public a(AppBarLayout.BaseBehavior r8, CoordinatorLayout r10, AppBarLayout r11) {
        this.f4318m = r8;
        this.f4316a = r10;
        this.f4317b = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        int r10 = ((Integer) r8.getAnimatedValue()).intValue();
        CoordinatorLayout r11 = this.f4316a;
        AppBarLayout r12 = this.f4317b;
        this.f4318m.H(r11, r12, r10);
    }
}
