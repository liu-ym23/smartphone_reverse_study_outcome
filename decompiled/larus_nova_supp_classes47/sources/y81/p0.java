package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import com.bytedance.android.live.base.model.message.a4;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 extends AnimatorListenerAdapter {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ Ref.IntRef b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationCancel(r2);
        d0 r3 = this.a;
        r3.c0 = false;
        r3.h();
    }

    public p0(d0 r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        d0 r7 = this.a;
        r7.c0 = false;
        TextSwitcher r8 = r7.q;
        if (r8 == null) goto L5;
        r8.setCurrentText("");
    L5:
        d0.v(this.a.D, 1.0f);
        View r9 = this.a.J;
        if (r9 == null) goto L8;
        r9.setVisibility(0);
    L8:
        tlc.d r10 = this.a.e;
        Long r0 = null;
        if ((r10 instanceof a4) == true) goto L11;
        r10 = null;
    L11:
        a4 r12 = (a4) r10;
        if (r12 == null) goto L14;
        r0 = r12.getStatus();
    L14:
        long r13 = BizStatus.NEW_ORDER.getValue();
        if (r0 != null) goto L18;
    L19:
        this.a.m();
    L32:
        if (this.a.o() == false) goto L34;
        this.a.q();
        return;
    L34:
        this.a.h();
        RelativeLayout r14 = this.a.D;
        if (r14 == null) goto L41;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L42;
        r15.width = -2;
        return;
    L42:
        return;
    L41:
        return;
    L18:
        if (r0.longValue() != r13) goto L19;
        int r16 = e0.b[this.a.A.ordinal()];
        if (r16 != 1) goto L23;
        d0 r17 = this.a;
        d0.s(r17.o, r17.T);
    L27:
        d0 r18 = this.a;
        if (r18.X <= 0) goto L30;
        d0.s(r18.n, r18.U);
        d0 r19 = this.a;
        r19.p((int) r19.X);
        goto L32
    L30:
        d0.s(r18.Q, r18.U);
        goto L32
    L23:
        if (r16 == 2) goto L25;
        d0 r20 = this.a;
        d0.s(r20.o, r20.T);
        goto L27
    L25:
        d0 r22 = this.a;
        d0.s(r22.p, r22.T);
        goto L27
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        Ref.IntRef r3 = this.b;
        ViewGroup r4 = this.a.k;
        if (r4 == null) goto L5;
        int r5 = r4.getWidth();
    L6:
        r3.element = r5;
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
