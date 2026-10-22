package com.larus.asr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b0 extends AnimatorListenerAdapter {
    public b0() {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationCancel(r3);
        FLogger.a.i("ChatSpeaker", "[playHideBlurAnim] onAnimationCancel");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationEnd(r3);
        FLogger.a.i("ChatSpeaker", "[playHideBlurAnim] onAnimationEnd");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationStart(r3);
        FLogger.a.i("ChatSpeaker", "[playHideBlurAnim] onAnimationStart");
    }
}
