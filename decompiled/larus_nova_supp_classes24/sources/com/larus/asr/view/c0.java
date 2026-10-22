package com.larus.asr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
import com.larus.common_ui.blur.BlurView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c0 extends AnimatorListenerAdapter {
    public final /* synthetic */ BlurView a;

    public c0(BlurCircleWithAmplitude r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationCancel(r3);
        FLogger.a.i("ChatSpeaker", "[playShowBlurAnim] onAnimationCancel");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        BlurCircleWithAmplitude r4 = this.a;
        if ((r4 instanceof BlurCircleWithAmplitude) == false) goto L5;
        BlurCircleWithAmplitude r5 = r4;
    L6:
        if (r5 == null) goto L8;
        r5.e();
    L8:
        FLogger.a.i("ChatSpeaker", "[playShowBlurAnim] onAnimationEnd");
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationStart(r3);
        FLogger.a.i("ChatSpeaker", "[playShowBlurAnim] onAnimationStart");
    }
}
