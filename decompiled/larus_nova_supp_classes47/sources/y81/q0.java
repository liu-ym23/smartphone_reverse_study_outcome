package y81;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ d0 b;
    public final /* synthetic */ Ref.IntRef c;

    public q0(ValueAnimator r1, d0 r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r7, "<anonymous parameter 0>");
        Object r8 = this.a.getAnimatedValue();
        if (r8 == null) goto L26;
        float r9 = ((Float) r8).floatValue();
        ViewGroup r0 = this.b.l;
        if (r0 == null) goto L9;
        float r3 = 52;
        if (this.c.element <= UtilityKotlinExtentionsKt.h(r3)) goto L9;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.width = ((int) ((this.c.element - UtilityKotlinExtentionsKt.h(r3)) * r9)) + ((int) UtilityKotlinExtentionsKt.h(r3));
        r0.setLayoutParams(r2);
    L9:
        RelativeLayout r1 = this.b.D;
        if (r1 == null) goto L14;
        float r4 = 52;
        if (this.c.element <= UtilityKotlinExtentionsKt.h(r4)) goto L14;
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        r5.width = ((int) ((this.c.element - UtilityKotlinExtentionsKt.h(r4)) * (1 - r9))) + 1;
        r1.setLayoutParams(r5);
    L14:
        TextSwitcher r6 = this.b.q;
        if (r6 == null) goto L17;
        r6.setAlpha(3 * r9);
    L17:
        int r10 = e0.c[this.b.C.ordinal()];
        if (r10 != 1) goto L20;
        d0.v(this.b.t, 3 * r9);
        return;
    L20:
        if (r10 == 2) goto L22;
        d0.v(this.b.t, 3 * r9);
        return;
    L22:
        d0.v(this.b.s, 3 * r9);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
