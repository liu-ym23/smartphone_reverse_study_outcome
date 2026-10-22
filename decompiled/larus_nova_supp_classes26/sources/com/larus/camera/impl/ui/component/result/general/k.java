package com.larus.camera.impl.ui.component.result.general;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements Animator.AnimatorListener {
    public final /* synthetic */ ResultDetectAnimationView a;
    public final /* synthetic */ ResultDetectAnimationView b;
    public final /* synthetic */ ResultDetectAnimationView c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        this.b.setImageBitmap(null);
        this.b.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.setImageBitmap(null);
        this.a.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.c.setVisibility(0);
    }

    public k(ResultDetectAnimationView r1, ResultDetectAnimationView r2, ResultDetectAnimationView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
