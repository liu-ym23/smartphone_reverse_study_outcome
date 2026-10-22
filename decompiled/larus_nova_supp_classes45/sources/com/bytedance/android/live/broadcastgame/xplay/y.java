package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.h5.LinkMicGameApi;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ long a;

    public y(long r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("XplayGamePlugin", new Object[]{"on game_start success"});
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L7;
        com.bytedance.android.live.liveinteract.utils.n r2 = r1.getLinkMicGameTraceUtils();
        if (r2 == null) goto L7;
        r2.a(true, "game_start_api", 0, "logId: " + ((ExtraResponse) r8).logId + ", response: " + ((LinkMicGameApi.a) ((ExtraResponse) r8).data));
    L7:
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L12;
        com.bytedance.android.live.liveinteract.utils.l r4 = r3.getLinkMicGameFullLinkMonitor();
        if (r4 == null) goto L12;
        com.bytedance.android.live.liveinteract.utils.l.a.c(r4, LinkMonitorData.StartDanmuGameApi, System.currentTimeMillis() - this.a, ((ExtraResponse) r8).logId);
    L12:
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L17;
        com.bytedance.android.live.liveinteract.utils.m r6 = r5.getLinkMicGameLogUtils();
        if (r6 == null) goto L17;
        r6.g();
    L17:
        xs2.b.a().post(new d10.e(((LinkMicGameApi.a) ((ExtraResponse) r8).data).a()));
        InteractGameContext r9 = InteractGameContext.Companion.getContext();
        if (r9 == null) goto L23;
        com.bytedance.live.datacontext.m<Boolean> r11 = r9.isXPlayGameSessionRunning();
        if (r11 == null) goto L24;
        r11.setValue(Boolean.TRUE);
        return;
    L24:
        return;
    }
}
