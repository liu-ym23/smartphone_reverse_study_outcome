package com.lynx.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.lynx.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ SmartRefreshLayout.i a;

    public a(SmartRefreshLayout.i r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.a.T1.d(RefreshState.TwoLevel);
    }
}
