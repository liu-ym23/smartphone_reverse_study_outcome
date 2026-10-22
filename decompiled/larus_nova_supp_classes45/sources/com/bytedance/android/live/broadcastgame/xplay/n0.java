package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n0<T> implements Consumer {
    public final /* synthetic */ XplayMainService a;

    public n0(XplayMainService r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        Unit r13 = (Unit) r12;
        XplayLog.c("XplayMainService", "retry clicked");
        XplayMonitorSession r14 = this.a.l;
        r14.getClass();
        r14.a = System.currentTimeMillis();
        r14.b = null;
        ((LinkedHashMap) r14.d).clear();
        r14.c++;
        if (r14.e.f != XplayScene.TalkRoom) goto L9;
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 == null) goto L9;
        com.bytedance.android.live.liveinteract.utils.l r0 = r15.getLinkMicGameFullLinkMonitor();
        if (r0 == null) goto L9;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r0, LinkMonitorData.ClickStartDanmuGameButton, null, null, 0, null, null, "retry", null, null, 446);
    L9:
        this.a.c();
    }
}
