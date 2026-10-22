package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ e.a a;
    public final /* synthetic */ FrameLayout b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
        super.onAnimationCancel(r1);
        e.a r2 = this.a;
        if (r2 != null) goto L5;
        return;
    L5:
        ((DialogAnimationLayout.a) r2).a();
        e.a(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        super.onAnimationEnd(r1);
        e.a r2 = this.a;
        if (r2 != null) goto L5;
        return;
    L5:
        ((DialogAnimationLayout.a) r2).a();
        e.a(this.b);
    }

    public c(DialogAnimationLayout.a r1, DialogAnimationLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
