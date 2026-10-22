package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ long a;

    public d0(long r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        ALogger.e("XplayGlobalService", "getInteractEntranceItem failed", r8);
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.live.liveinteract.utils.n r1 = r0.getLinkMicGameTraceUtils();
        if (r1 == null) goto L10;
        int r2 = com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r8);
        String r3 = r8.toString();
        if (r3 != null) goto L9;
        r3 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L9:
        r1.a(true, "/webcast/anchor_mount/interact_entrance/target_cell/", r2, r3);
    L10:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L16;
        com.bytedance.android.live.liveinteract.utils.l r5 = r4.getLinkMicGameFullLinkMonitor();
        if (r5 == null) goto L17;
        com.bytedance.android.live.liveinteract.utils.l.a.b(r5, LinkMonitorData.InteractEntranceTargetCellApi, System.currentTimeMillis() - this.a, r8);
        return;
    L17:
        return;
    }
}
