package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ long a;

    public x(long r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.i(r8, "XplayGamePlugin", "on game_start fail");
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L7;
        com.bytedance.android.live.liveinteract.utils.m r2 = r1.getLinkMicGameLogUtils();
        if (r2 == null) goto L7;
        r2.f(false, "game_start_failed", String.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r8)), com.bytedance.android.livesdk.utils.o1.a(r8));
    L7:
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L15;
        com.bytedance.android.live.liveinteract.utils.n r4 = r3.getLinkMicGameTraceUtils();
        if (r4 == null) goto L15;
        int r5 = com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r8);
        String r6 = com.bytedance.android.livesdk.utils.o1.a(r8);
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r4.a(true, "game_start_api", r5, r6);
    L15:
        IInteractService r9 = jc1.k.f(IInteractService.class);
        if (r9 == null) goto L20;
        com.bytedance.android.live.liveinteract.utils.l r11 = r9.getLinkMicGameFullLinkMonitor();
        if (r11 == null) goto L20;
        com.bytedance.android.live.liveinteract.utils.l.a.b(r11, LinkMonitorData.StartDanmuGameApi, System.currentTimeMillis() - this.a, r8);
    L20:
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 == null) goto L24;
        r12.broadcastGameStartError();
        return;
    }
}
