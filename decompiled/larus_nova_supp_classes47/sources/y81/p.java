package y81;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ l b;

    public p(ValueAnimator r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "<anonymous parameter 0>");
        Object r5 = this.a.getAnimatedValue();
        if (r5 == null) goto L9;
        float r6 = ((Float) r5).floatValue();
        ViewGroup r0 = this.b.l;
        if (r0 == null) goto L10;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = (int) (UtilityKotlinExtentionsKt.h(52) * r6);
        r0.setLayoutParams(r1);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
