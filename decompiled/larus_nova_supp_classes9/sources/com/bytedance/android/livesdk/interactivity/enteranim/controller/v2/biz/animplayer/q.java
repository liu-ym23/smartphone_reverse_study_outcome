package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements com.bytedance.android.live.profit.player.l {
    public final /* synthetic */ Mp4EnhancedEnterPlayer.c a;

    public final void onLoad() {
    }

    public final void onStart() {
        ((v72.c.a) this.a.g).b();
    }

    public final void onStop() {
        Mp4EnhancedEnterPlayer.c r0 = this.a;
        r0.h.invoke(r0.b, r0.c, r0.i);
    }

    public q(Mp4EnhancedEnterPlayer.c r1) {
        this.a = r1;
    }

    public final void a(Throwable r6) {
        Mp4EnhancedEnterPlayer$playAnim$2 r0 = this.a.a;
        if (r6 == null) goto L6;
        String r7 = r6.getMessage();
        if (r7 == null) goto L6;
    L7:
        Mp4EnhancedEnterPlayer.c r1 = this.a;
        r0.invoke(r7, r1.b, String.valueOf(r1.c));
        return;
    L6:
        r7 = "Mp4PlayCallbackonErrorEnd";
        goto L7
    }

    public final com.bytedance.android.live.profit.player.k b(int r3, int r4) {
        int r0 = (s1.w() - this.a.f.a) - ((int) s1.e(11.0f));
        RevenueUtils.i.getClass();
        return RevenueUtils.b.b(r3, r4, r0);
    }
}
