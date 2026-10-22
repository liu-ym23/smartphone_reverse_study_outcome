package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorPluginRuntime a;

    public b(AnchorPluginRuntime r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Throwable r5 = (Throwable) r8;
        int r9 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.i(r5, "AnchorPluginRuntime", "game/start请求");
        IInteractGameMonitorService.b.a((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class), 1, this.a.s(), 0, r5, 16);
    }
}
