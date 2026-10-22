package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.model.e0;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AnchorPluginRuntime a;

    public a(AnchorPluginRuntime r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.g("game/start发送成功", "AnchorPluginRuntime");
        AnchorPluginRuntime r1 = this.a;
        r1.y = ((e0) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r8)).data).a();
        int r9 = InteractGameLocalStatusUtils.a;
        InteractGameLocalStatusUtils.c("play_id", String.valueOf(this.a.y));
        IInteractGameMonitorService.b.a((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class), 0, this.a.s(), this.a.y, null, 24);
    }
}
