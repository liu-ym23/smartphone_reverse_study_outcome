package w5;

import android.animation.ValueAnimator;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomSheetBehavior a;

    public b(BottomSheetBehavior r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        ((Float) r1.getAnimatedValue()).floatValue();
        this.a.getClass();
    }
}
