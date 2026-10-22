package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends vb6.a {
    public final /* synthetic */ LinkMicGameWidget a;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.xplay.f b;

    public final void H1() {
        ALogger.i("LinkMicGameWidget", "initXplayState, onLinkSuccess");
        if (this.b == null) goto L6;
        ALogger.i("LinkMicGameWidget", "initXplayState, onLinkSuccess -> onXplayInstanceCreate");
        com.bytedance.android.live.liveinteract.utils.l.a.a(qi0.a.j, LinkMonitorData.ClickStartDanmuGameButton, this.b.getAppId(), this.b.getGameName(), 0, null, null, "switch_scene", Integer.valueOf(XplayGuestType.DEFAULT.getGuestType()), null, 312);
        LinkMicGameWidget.xq(this.a, this.b, true);
        return;
    }

    public j(LinkMicGameWidget r1, com.bytedance.android.live.broadcastgame.api.xplay.f r2) {
        this.a = r1;
        this.b = r2;
    }
}
