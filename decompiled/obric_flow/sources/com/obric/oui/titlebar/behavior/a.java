package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.oui.titlebar.OUnitedTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f14857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f14858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseBehavior f14859c;

    public a(BaseBehavior r5, CoordinatorLayout r10, OUnitedTitleBar r11) {
        this.f14859c = r5;
        this.f14857a = r10;
        this.f14858b = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        int r10 = ((Integer) r5.getAnimatedValue()).intValue();
        this.f14859c.setHeaderTopBottomOffset(this.f14857a, this.f14858b, r10);
    }
}
