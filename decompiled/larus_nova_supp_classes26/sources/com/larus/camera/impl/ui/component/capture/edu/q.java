package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q implements Animator.AnimatorListener {
    public final /* synthetic */ Ref.ObjectRef a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public q(Ref.ObjectRef r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        ((Function0) this.a.element).invoke();
        Ref.ObjectRef r3 = this.a;
        r3.element = p.a;
    }
}
