package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements Animation.AnimationListener {
    public final /* synthetic */ LiveBeautySecondLevelFragment a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public p(LiveBeautySecondLevelFragment r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        LiveBeautySecondLevelFragment r3 = this.a;
        int r0 = LiveBeautySecondLevelFragment.C;
        r3.U90();
    }
}
