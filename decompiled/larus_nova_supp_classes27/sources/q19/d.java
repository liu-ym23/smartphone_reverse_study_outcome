package q19;

import android.animation.ValueAnimator;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SuperSwipeRefreshLayout a;

    public d(SuperSwipeRefreshLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        int r3 = ((Integer) r2.getAnimatedValue()).intValue() - this.a.getTargetView().getTop();
        this.a.setTargetTopAndBottomOffset(r3);
    }
}
