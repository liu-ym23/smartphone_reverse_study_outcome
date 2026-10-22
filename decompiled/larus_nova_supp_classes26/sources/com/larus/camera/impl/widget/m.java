package com.larus.camera.impl.widget;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m implements Animator.AnimatorListener {
    public final /* synthetic */ EduPreviewLoadingView a;
    public final /* synthetic */ EduPreviewLoadingView b;
    public final /* synthetic */ EduPreviewLoadingView c;

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

    public m(EduPreviewLoadingView r1, EduPreviewLoadingView r2, EduPreviewLoadingView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
