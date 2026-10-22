package com.bytedance.android.live.lynx.ui;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements Animator.AnimatorListener {
    public final /* synthetic */ LynxLottieView a;

    public j(LynxLottieView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        LynxLottieView r6 = this.a;
        LottieAnimationView r0 = LynxLottieView.M(r6);
        if (r0 == null) goto L5;
        int r1 = r0.getFrame();
    L6:
        LottieComposition r2 = LynxLottieView.M(this.a).getComposition();
        if (r2 == null) goto L9;
        float r3 = r2.getDurationFrames();
    L10:
        LynxLottieView.N(r6, "cancel", r1, (int) r3, this.a.h);
        return;
    L9:
        r3 = 0.0f;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        LottieAnimationView r6 = LynxLottieView.M(this.a);
        if (r6 == null) goto L9;
        LynxLottieView r0 = this.a;
        boolean r1 = r0.a;
        LottieAnimationView r2 = LynxLottieView.M(r0);
        if (r1 == false) goto L7;
        float r3 = r2.getMaxFrame();
    L8:
        r6.setFrame((int) r3);
        goto L9
    L7:
        r3 = r2.getMinFrame();
    L9:
        LynxLottieView r7 = this.a;
        LottieAnimationView r4 = LynxLottieView.M(r7);
        if (r4 == null) goto L12;
        int r8 = r4.getFrame();
    L13:
        LottieComposition r9 = LynxLottieView.M(this.a).getComposition();
        if (r9 == null) goto L16;
        float r10 = r9.getDurationFrames();
    L17:
        LynxLottieView.N(r7, "completion", r8, (int) r10, this.a.h);
        return;
    L16:
        r10 = 0.0f;
        goto L17
    L12:
        r8 = 0;
        goto L13
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        LynxLottieView r6 = this.a;
        r6.h++;
        LottieAnimationView r0 = LynxLottieView.M(r6);
        if (r0 == null) goto L5;
        int r1 = r0.getFrame();
    L6:
        LottieComposition r2 = LynxLottieView.M(this.a).getComposition();
        if (r2 == null) goto L9;
        float r3 = r2.getDurationFrames();
    L10:
        LynxLottieView.N(r6, "repeat", r1, (int) r3, this.a.h);
        return;
    L9:
        r3 = 0.0f;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        LynxLottieView r6 = this.a;
        int r0 = 0;
        r6.h = 0;
        LottieAnimationView r1 = LynxLottieView.M(r6);
        if (r1 == null) goto L5;
        r0 = r1.getFrame();
    L5:
        LottieComposition r2 = LynxLottieView.M(this.a).getComposition();
        if (r2 == null) goto L8;
        float r3 = r2.getDurationFrames();
    L9:
        LynxLottieView.N(r6, "start", r0, (int) r3, this.a.h);
        return;
    L8:
        r3 = 0.0f;
        goto L9
    }
}
