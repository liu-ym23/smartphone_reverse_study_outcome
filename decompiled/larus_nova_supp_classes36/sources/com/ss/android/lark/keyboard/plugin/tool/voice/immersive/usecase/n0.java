package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n0 implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;
    public final /* synthetic */ VoiceImeWrapperUseCase c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        TypeIntrinsics.asMutableCollection(this.c.b()).remove(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        this.a.setTranslationY(this.b);
        this.a.setVisibility(4);
        TypeIntrinsics.asMutableCollection(this.c.b()).remove(r3);
    }

    public n0(View r1, float r2, VoiceImeWrapperUseCase r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
