package com.bytedance.android.livesdk.chatroom.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g3 extends AnimatorListenerAdapter {
    public final /* synthetic */ RoomTopRightBannerEvent a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g b;

    public g3(RoomTopRightBannerEvent r1, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1, boolean r2) {
        if (this.a.getStatus() != 1) goto L5;
        this.b.Yb(8);
        return;
    L5:
        this.b.Yb(0);
    }
}
