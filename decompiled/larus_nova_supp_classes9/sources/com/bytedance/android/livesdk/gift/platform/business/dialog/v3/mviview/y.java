package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y implements Animator.AnimatorListener {
    public final /* synthetic */ GiftMVIPanelView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    public y(GiftMVIPanelView r1) {
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
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        ViewGroup r5 = this.a.M;
        if (r5 == null) goto L11;
        r5.setTranslationY(0.0f);
    L11:
        ViewGroup r6 = this.a.L;
        if (r6 == null) goto L15;
        r6.setTranslationY(0.0f);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ViewGroup r3 = this.a.t();
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        ViewGroup r4 = this.a.s;
        if (r4 == null) goto L8;
        r4.setVisibility(0);
    L8:
        FrameLayout r5 = this.a.t;
        if (r5 == null) goto L11;
        r5.setVisibility(0);
    L11:
        ViewGroup r6 = this.a.s();
        if (r6 == null) goto L14;
        r6.setVisibility(0);
    L14:
        ViewGroup r7 = this.a.M;
        if (r7 == null) goto L18;
        r7.setVisibility(0);
    L18:
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == true) goto L23;
        FrameLayout r8 = this.a.w;
        if (r8 == null) goto L24;
        r8.setVisibility(0);
        return;
    L24:
        return;
    }
}
