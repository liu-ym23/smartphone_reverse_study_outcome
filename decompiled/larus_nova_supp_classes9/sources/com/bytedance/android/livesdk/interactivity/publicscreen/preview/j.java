package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ ZoomableControllerImp b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
        this.b.q.removeAllUpdateListeners();
        this.b.q.removeAllListeners();
        Runnable r2 = this.a;
        if (r2 == null) goto L6;
        r2.run();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        this.b.q.removeAllUpdateListeners();
        this.b.q.removeAllListeners();
        Runnable r2 = this.a;
        if (r2 == null) goto L6;
        r2.run();
        return;
    }

    public j(ZoomableControllerImp r1, Runnable r2) {
        this.b = r1;
        this.a = r2;
    }
}
