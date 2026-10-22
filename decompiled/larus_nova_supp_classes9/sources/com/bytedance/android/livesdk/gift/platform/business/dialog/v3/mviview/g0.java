package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 implements Animator.AnimatorListener {
    public final /* synthetic */ GiftMVIPanelView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    public g0(GiftMVIPanelView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ViewGroup r4 = this.a.t();
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        ViewGroup r5 = this.a.s;
        if (r5 == null) goto L8;
        r5.setVisibility(4);
    L8:
        FrameLayout r6 = this.a.t;
        if (r6 == null) goto L11;
        r6.setVisibility(8);
    L11:
        ViewGroup r7 = this.a.s();
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        ViewGroup r8 = this.a.M;
        if (r8 == null) goto L18;
        r8.setVisibility(8);
    L18:
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().e() == true) goto L22;
        FrameLayout r9 = this.a.w;
        if (r9 == null) goto L22;
        r9.setVisibility(8);
    L22:
        ViewGroup r10 = this.a.M;
        if (r10 == null) goto L25;
        r10.setAlpha(1.0f);
    L25:
        ViewGroup r11 = this.a.M;
        if (r11 == null) goto L28;
        r11.setTranslationY(com.bytedance.android.live.revenue.common.i.a(52));
    L28:
        this.a.F = false;
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
