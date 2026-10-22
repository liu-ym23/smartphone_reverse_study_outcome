package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.livesdk.gift.fastgift.di.FastGiftAnimationCreator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y extends o12.b {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ py.k b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        FastGiftViewV3 r11 = this.a;
        r11.C = this.b;
        r11.m();
        FastGiftViewV3 r13 = this.a;
        if (r13.r != null) goto L5;
        View r0 = r13.a(2131372145);
        Lazy r1 = FastGiftAnimationCreator.a;
        Intrinsics.checkNotNullParameter(r0, "target");
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r0, "scaleX", new float[]{0.0f, 1.0f});
        r2.setDuration(300);
        r2.setStartDelay(1700);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0, "scaleY", new float[]{0.0f, 1.0f});
        r3.setDuration(300);
        r3.setStartDelay(1700);
        AnimatorSet r4 = new AnimatorSet();
        r4.playTogether(new Animator[]{r2, r3});
        r13.r = r4;
    L5:
        AnimatorSet r14 = r13.r;
        if (r14 == null) goto L9;
        r14.start();
        return;
    }

    public y(FastGiftViewV3 r1, py.k r2) {
        this.a = r1;
        this.b = r2;
    }
}
