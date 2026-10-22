package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ AudioPopupWindowImpl b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        Function0 r2 = this.a;
        if (r2 == null) goto L5;
        r2.invoke();
    L5:
        this.b.a();
    }

    public b(Function0 r1, AudioPopupWindowImpl r2) {
        this.a = r1;
        this.b = r2;
    }
}
