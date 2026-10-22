package com.obric.assistant.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c6 extends AnimatorListenerAdapter {
    public final /* synthetic */ OrionChatWindowComponent a;
    public final /* synthetic */ ViewGroup b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        if (this.a.Q == false) goto L5;
        float r6 = 0.0f;
    L6:
        FLogger.a.i("OrionWindowStyleComponent", "speakArea appear animation end, voiceVisible=" + this.a.Q + ", targetScale=" + r6);
        this.b.setScaleX(r6);
        this.b.setScaleY(r6);
        this.b.setAlpha(1.0f);
        return;
    L5:
        r6 = 1.0f;
        goto L6
    }

    public c6(OrionChatWindowComponent r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }
}
