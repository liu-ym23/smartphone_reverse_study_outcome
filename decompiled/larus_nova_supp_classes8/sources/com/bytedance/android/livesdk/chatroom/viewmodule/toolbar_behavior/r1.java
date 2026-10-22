package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r1 extends AnimatorListenerAdapter {
    public final /* synthetic */ PortraitToolbarMoreBehavior a;

    public r1(PortraitToolbarMoreBehavior r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        LottieAnimationView r4 = this.a.M;
        if (r4 == null) goto L5;
        r4.clearAnimation();
        this.a.M.setBackgroundResource(0);
        PortraitToolbarMoreBehavior r5 = this.a;
        r5.M.setImageResource(r5.v());
        this.a.M.removeAllAnimatorListeners();
    L5:
        PortraitToolbarMoreBehavior r6 = this.a;
        r6.T = false;
        if (r6.O == false) goto L10;
        TextView r7 = r6.N;
        if (r7 == null) goto L10;
        r7.setText(2131914887);
    L10:
        this.a.o();
    }
}
