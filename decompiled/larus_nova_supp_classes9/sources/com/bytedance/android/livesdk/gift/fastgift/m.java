package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends o12.b {
    public final /* synthetic */ FastGiftViewV3 a;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public m(FastGiftViewV3 r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "animation");
        this.a.A.notifyRecommendFinished();
        this.a.m();
        FastGiftViewV3 r9 = this.a;
        AnimatorSet r10 = r9.u;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        r9.u = new AnimatorSet();
        View r11 = r9.findViewById(2131372147);
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r11, "scaleX", new float[]{0.2f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r11, "scaleY", new float[]{0.2f, 1.0f});
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r11, "alpha", new float[]{0.2f, 1.0f});
        AnimatorSet r3 = r9.u;
        if (r3 == null) goto L8;
        r3.playTogether(new Animator[]{r1, r2, r13});
    L8:
        AnimatorSet r14 = r9.u;
        if (r14 == null) goto L11;
        r14.setDuration(200);
    L11:
        AnimatorSet r15 = r9.u;
        if (r15 == null) goto L14;
        r15.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L14:
        AnimatorSet r16 = r9.u;
        if (r16 == null) goto L18;
        r16.start();
        return;
    }
}
