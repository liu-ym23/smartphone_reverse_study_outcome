package com.bytedance.android.livesdk.chatroom.widget;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements Animation.AnimationListener {
    public final /* synthetic */ CountDownView.a a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public q(CountDownView.a r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        this.a.e.setVisibility(8);
    }
}
