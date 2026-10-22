package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 implements Animator.AnimatorListener {
    public final /* synthetic */ GiftMVIPanelView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    public e0(GiftMVIPanelView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        FrameLayout r4 = this.a.y;
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        ViewGroup r5 = this.a.t();
        if (r5 == null) goto L8;
        r5.setVisibility(8);
    L8:
        ViewGroup r6 = this.a.s;
        if (r6 == null) goto L11;
        r6.setVisibility(8);
    L11:
        FrameLayout r7 = this.a.t;
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        ViewGroup r8 = this.a.u();
        if (r8 == null) goto L17;
        r8.setVisibility(8);
    L17:
        ViewGroup r9 = this.a.u();
        if (r9 == null) goto L20;
        r9.setAlpha(1.0f);
    L20:
        ViewGroup r10 = this.a.u();
        ViewGroup.LayoutParams r0 = null;
        if (r10 == null) goto L23;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L25:
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L28;
        r0 = r11;
    L28:
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r1 == null) goto L36;
        ((ViewGroup.MarginLayoutParams) r1).topMargin = (int) com.bytedance.android.live.revenue.common.i.a(52);
        ViewGroup r13 = this.a.u();
        if (r13 == null) goto L33;
        r13.setLayoutParams(r1);
    L33:
        ViewGroup r14 = this.a.u();
        if (r14 == null) goto L36;
        r14.requestLayout();
    L36:
        this.a.E = false;
        return;
    L23:
        r11 = null;
        goto L25
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        FrameLayout r3 = this.a.z;
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        View r4 = this.a.A;
        if (r4 == null) goto L9;
        r4.setVisibility(0);
        return;
    }
}
