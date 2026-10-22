package com.bytedance.android.live.lynx.ui;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import com.airbnb.lottie.LottieComposition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LynxLottieView a;

    public k(LynxLottieView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r7, "animation");
        LottieComposition r0 = LynxLottieView.M(this.a).getComposition();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r7.getAnimatedValue() == null) goto L23;
        LynxLottieView r1 = this.a;     // Catch: Exception -> L18
        float r2 = r0.getDurationFrames();     // Catch: Exception -> L18
        Object r8 = r7.getAnimatedValue();     // Catch: Exception -> L18
        if (r8 == null) goto L17;
        r1.f = (int) (r2 * ((Float) r8).floatValue());     // Catch: Exception -> L18
        this.a.g = (int) r0.getDurationFrames();     // Catch: Exception -> L18
        LynxLottieView r9 = this.a;     // Catch: Exception -> L18
        int r3 = r9.f;     // Catch: Exception -> L18
        int r4 = r9.g;     // Catch: Exception -> L18
        int r5 = (int) ((r3 / r4) * 100);     // Catch: Exception -> L18
        if (r3 == 0) goto L15;
        if (r3 == r4) goto L15;
        if (r9.j == r5) goto L24;
        long r6 = SystemClock.uptimeMillis();     // Catch: Exception -> L18
        LynxLottieView r10 = this.a;     // Catch: Exception -> L18
        if ((r6 - r10.k) >= (1000 / r10.e)) goto L15;
        return;
    L24:
        return;
    L15:
        LynxLottieView r11 = this.a;     // Catch: Exception -> L18
        LynxLottieView.N(r11, "update", r11.f, r11.g, r11.h);     // Catch: Exception -> L18
        LynxLottieView r12 = this.a;     // Catch: Exception -> L18
        r12.j = r5;     // Catch: Exception -> L18
        r12.k = SystemClock.uptimeMillis();     // Catch: Exception -> L18
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        return;
    }
}
