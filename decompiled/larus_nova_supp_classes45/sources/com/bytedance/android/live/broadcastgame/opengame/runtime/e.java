package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        com.bytedance.android.live.broadcastgame.opengame.t r0 = this.a.getPluginInfo();
        com.bytedance.android.live.broadcastgame.opengame.network.model.m.a r1 = (com.bytedance.android.live.broadcastgame.opengame.network.model.m.a) ((ExtraResponse) r6).data;
        boolean r2 = false;
        if (r1 == null) goto L9;
        com.bytedance.android.live.broadcastgame.opengame.network.model.a r3 = r1.info;
        if (r3 == null) goto L9;
        boolean r4 = true;
        if (r3.collectStatus != 1) goto L9;
    L10:
        r0.c = r4;
        com.bytedance.android.live.broadcastgame.opengame.t r7 = this.a.getPluginInfo();
        com.bytedance.android.live.broadcastgame.opengame.network.model.a r8 = ((com.bytedance.android.live.broadcastgame.opengame.network.model.m.a) ((ExtraResponse) r6).data).info;
        if (r8 == null) goto L13;
        r2 = r8.canStartByAudience;
    L13:
        r7.e = r2;
        return;
    L9:
        r4 = false;
        goto L10
    }
}
