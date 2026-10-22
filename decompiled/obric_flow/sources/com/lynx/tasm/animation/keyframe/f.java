package com.lynx.tasm.animation.keyframe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10099a;

    public /* synthetic */ f(int r5) {
        this.f10099a = r5;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        switch(this.f10099a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onAnimationStart(r5);
        r5.cancel();
        return;
    L6:
        super.onAnimationStart(r5);
        r5.cancel();
    }
}
