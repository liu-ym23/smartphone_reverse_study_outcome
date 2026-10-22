package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements Animator.AnimatorListener {
    public final /* synthetic */ GiftMVIPanelView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    public w(GiftMVIPanelView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        FrameLayout r3 = this.a.z;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        View r4 = this.a.A;
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        FrameLayout r5 = this.a.y;
        if (r5 == null) goto L5;
        r5.setVisibility(0);
    L5:
        ViewGroup r6 = this.a.t();
        if (r6 == null) goto L8;
        r6.setVisibility(0);
    L8:
        ViewGroup r7 = this.a.s;
        if (r7 == null) goto L11;
        r7.setVisibility(0);
    L11:
        FrameLayout r8 = this.a.t;
        if (r8 == null) goto L14;
        r8.setVisibility(0);
    L14:
        ViewGroup r9 = this.a.u();
        if (r9 == null) goto L17;
        r9.setVisibility(0);
    L17:
        ViewGroup r10 = this.a.u();
        if (r10 == null) goto L20;
        r10.setAlpha(0.0f);
    L20:
        FrameLayout r11 = this.a.o;
        if (r11 == null) goto L23;
        r11.setTranslationY(0.0f);
    L23:
        ViewGroup r13 = this.a.u();
        ViewGroup.LayoutParams r1 = null;
        if (r13 == null) goto L26;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L28:
        if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L31;
        r1 = r14;
    L31:
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        if (r2 == null) goto L40;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = 0;
        ViewGroup r15 = this.a.u();
        if (r15 == null) goto L36;
        r15.setLayoutParams(r2);
    L36:
        ViewGroup r16 = this.a.u();
        if (r16 == null) goto L41;
        r16.requestLayout();
        return;
    L41:
        return;
    L40:
        return;
    L26:
        r14 = null;
        goto L28
    }
}
