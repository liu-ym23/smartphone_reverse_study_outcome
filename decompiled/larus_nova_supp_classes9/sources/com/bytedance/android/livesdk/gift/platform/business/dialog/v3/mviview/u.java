package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements Animator.AnimatorListener {
    public final /* synthetic */ GiftMVIPanelView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    public u(GiftMVIPanelView r1) {
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
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ViewGroup r4 = this.a.t();
        if (r4 == null) goto L5;
        r4.setVisibility(0);
    L5:
        ViewGroup r5 = this.a.s;
        if (r5 == null) goto L8;
        r5.setVisibility(0);
    L8:
        ViewGroup r6 = this.a.M;
        if (r6 == null) goto L11;
        r6.setVisibility(0);
    L11:
        GiftMVIPanelView r7 = this.a;
        ViewGroup r1 = r7.M;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r7.y.getVisibility() != 0) goto L16;
        float r8 = com.bytedance.android.live.revenue.common.i.a(36);
    L17:
        r1.setTranslationY(r8);
        return;
    L16:
        r8 = com.bytedance.android.live.revenue.common.i.a(0);
        goto L17
    }
}
