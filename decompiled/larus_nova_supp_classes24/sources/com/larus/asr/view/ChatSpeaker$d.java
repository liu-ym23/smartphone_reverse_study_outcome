package com.larus.asr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ChatSpeaker$d extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewPropertyAnimator a;
    public final /* synthetic */ Function0<Unit> b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.setListener(null);
        this.b.invoke();
    }

    public ChatSpeaker$d(ViewPropertyAnimator r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
