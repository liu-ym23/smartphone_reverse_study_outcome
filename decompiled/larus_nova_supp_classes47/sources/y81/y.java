package y81;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ l b;
    public final /* synthetic */ Ref.IntRef c;

    public y(ValueAnimator r1, l r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r7, "<anonymous parameter 0>");
        Object r8 = this.a.getAnimatedValue();
        if (r8 == null) goto L19;
        float r9 = ((Float) r8).floatValue();
        ViewGroup r0 = this.b.l;
        if (r0 == null) goto L9;
        float r3 = 52;
        if (this.c.element <= UtilityKotlinExtentionsKt.h(r3)) goto L9;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.width = ((int) ((this.c.element - UtilityKotlinExtentionsKt.h(r3)) * r9)) + ((int) UtilityKotlinExtentionsKt.h(r3));
        r0.setLayoutParams(r2);
    L9:
        RelativeLayout r1 = this.b.t;
        if (r1 == null) goto L14;
        float r4 = 52;
        if (this.c.element <= UtilityKotlinExtentionsKt.h(r4)) goto L14;
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        r5.width = ((int) ((this.c.element - UtilityKotlinExtentionsKt.h(r4)) * (1 - r9))) + 1;
        r1.setLayoutParams(r5);
    L14:
        l r6 = this.b;
        float r10 = 3 * r9;
        r6.r(r6.q, r10);
        TextSwitcher r12 = this.b.p;
        if (r12 == null) goto L20;
        r12.setAlpha(r10);
        return;
    L20:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
