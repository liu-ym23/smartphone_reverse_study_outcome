package c91;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public k(a r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        View r0 = this.a.b;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        r0.setAlpha(((Float) r3).floatValue());
        this.a.b.requestLayout();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
