package com.bytedance.android.livesdk.chatroom.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class e3 implements Runnable {
    public final /* synthetic */ RoomTopRightBannerEvent a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g d;

    public /* synthetic */ e3(RoomTopRightBannerEvent r1, View r2, boolean r3, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomTopRightBannerEvent r6 = this.a;
        View r0 = this.b;
        boolean r3 = this.c;
        com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.g r7 = this.d;
        AnimatorSet r8 = new AnimatorSet();
        r8.setDuration(r6.getAnimationTime());
        int r1 = r6.getStatus();
        if (r1 != 0) goto L5;
        int r2 = com.bytedance.android.live.core.utils.s1.f(109.0f);
    L9:
        int r4 = r2;
    L10:
        Animator r5 = i3.f(r0, r6, r4, r3, r6.getAnimationTime());
        if (r5 == null) goto L14;
        r7.Yb(8);
        r8.play(r5);
        r8.setDuration(r6.getAnimationTime());
        r8.setInterpolator(new AccelerateInterpolator());
        r8.addListener(new g3(r6, r7));
        r8.start();
        return;
    L14:
        return;
    L5:
        if (r1 == 1) goto L7;
        r4 = 0;
        goto L10
    L7:
        r2 = -com.bytedance.android.live.core.utils.s1.f(109.0f);
        goto L9
    }
}
