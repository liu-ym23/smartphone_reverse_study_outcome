package com.bytedance.android.livesdk.interactivity.notifications;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ LiveRoomNotifyWidget.c a;

    public a(LiveRoomNotifyWidget.c r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        super.onAnimationEnd(r3);
        UIUtils.setViewVisibility(this.a.n.a, 8);
        LiveRoomNotifyWidget r4 = this.a.n;
        UIUtils.updateLayoutMargin(((Widget) r4).containerView, -3, r4.m, -3, -3);
        PlatformMessageHelper.INSTANCE.onMessageFinish();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
        super.onAnimationStart(r1);
        AnimatorSet r2 = this.a.n.g;
        if (r2 == null) goto L5;
        r2.cancel();
    L5:
        AnimatorSet r3 = this.a.n.h;
        if (r3 == null) goto L8;
        r3.cancel();
    L8:
        AnimatorSet r4 = this.a.n.i;
        if (r4 == null) goto L12;
        r4.cancel();
        return;
    }
}
