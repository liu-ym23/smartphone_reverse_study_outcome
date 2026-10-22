package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends vb6.a {
    public final /* synthetic */ LinkMicGameWidget a;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.xplay.f b;

    public final void H1() {
        ALogger.i("LinkMicGameWidget", "onXplayInstanceCreate -> joinChannel success");
        LinkMicGameWidget r0 = this.a;
        if (r0.t == true) goto L6;
        LinkMicGameWidget.xq(r0, this.b, false);
        return;
    }

    public k(LinkMicGameWidget r1, com.bytedance.android.live.broadcastgame.api.xplay.f r2) {
        this.a = r1;
        this.b = r2;
    }
}
