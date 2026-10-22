package com.bytedance.android.live.effect.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ AdjustPercentBar a;

    public b(AdjustPercentBar r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        this.a.A = true;
        super.onAnimationEnd(r3);
    }
}
