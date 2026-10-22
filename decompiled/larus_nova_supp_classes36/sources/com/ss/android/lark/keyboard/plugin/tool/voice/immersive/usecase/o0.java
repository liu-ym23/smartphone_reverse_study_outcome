package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o0 implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ VoiceImeWrapperUseCase b;
    public final /* synthetic */ View c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        TypeIntrinsics.asMutableCollection(this.b.b()).remove(r2);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        this.a.setTranslationY(0.0f);
        TypeIntrinsics.asMutableCollection(this.b.b()).remove(r3);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.c.setVisibility(0);
    }

    public o0(View r1, VoiceImeWrapperUseCase r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
