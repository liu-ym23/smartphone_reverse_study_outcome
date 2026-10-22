package com.bytedance.android.live.effect.avadjust;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements Animation.AnimationListener {
    public final /* synthetic */ LiveColorAdjustFragment a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public k(LiveColorAdjustFragment r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        LiveColorAdjustFragment r3 = this.a;
        int r0 = LiveColorAdjustFragment.r;
        r3.T90();
    }
}
