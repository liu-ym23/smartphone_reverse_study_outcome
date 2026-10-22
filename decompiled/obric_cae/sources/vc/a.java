package vc;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.obric.oui.titlebar.behavior.BaseBehavior;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f12827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f12828b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BaseBehavior f12829m;

    public a(BaseBehavior r8, CoordinatorLayout r10, OUnitedTitleBar r11) {
        this.f12829m = r8;
        this.f12827a = r10;
        this.f12828b = r11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        int r10 = ((Integer) r8.getAnimatedValue()).intValue();
        CoordinatorLayout r11 = this.f12827a;
        OUnitedTitleBar r12 = this.f12828b;
        this.f12829m.J(r11, r12, r10);
    }
}
