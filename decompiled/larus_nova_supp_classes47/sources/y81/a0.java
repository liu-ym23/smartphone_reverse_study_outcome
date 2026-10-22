package y81;

import android.animation.ValueAnimator;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ l b;

    public a0(ValueAnimator r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Object r5 = this.a.getAnimatedValue();
        if (r5 == null) goto L7;
        int r6 = ((Integer) r5).intValue();
        l r0 = this.b;
        l.k(r0, r0.l, ColorProtector.parseColor("#26000000"), r6);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
