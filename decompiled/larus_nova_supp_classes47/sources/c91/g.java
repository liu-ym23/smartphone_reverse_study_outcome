package c91;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public g(a r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        ViewGroup.LayoutParams r0 = this.a.a.getLayoutParams();
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        r0.width = ((Integer) r3).intValue();
        this.a.a.requestLayout();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
