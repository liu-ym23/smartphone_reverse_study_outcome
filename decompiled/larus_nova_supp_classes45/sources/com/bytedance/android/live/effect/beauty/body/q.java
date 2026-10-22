package com.bytedance.android.live.effect.beauty.body;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements Animation.AnimationListener {
    public final /* synthetic */ LiveBodyBeautyListFragment a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public q(LiveBodyBeautyListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        LiveBodyBeautyListFragment r3 = this.a;
        int r0 = LiveBodyBeautyListFragment.y;
        r3.T90();
    }
}
