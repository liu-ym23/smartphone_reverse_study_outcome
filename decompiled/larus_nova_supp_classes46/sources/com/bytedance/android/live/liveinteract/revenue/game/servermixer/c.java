package com.bytedance.android.live.liveinteract.revenue.game.servermixer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.utils.l;
import com.bytedance.android.live.network.response.e;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import jc1.k;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;

    public c(int r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        e r9 = (e) r8;
        ALogger.i("XplayRTCManager", "xplay_init_callback_result, success");
        qi0.d.a.a(true, "xplay_init_callback_result", 0, "initStatus: " + this.a + ", lodId = " + r9.logId);
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L8;
        l r1 = r0.getLinkMicGameFullLinkMonitor();
        if (r1 == null) goto L9;
        LinkMonitorData r2 = LinkMonitorData.XplayInitCallBack;
        long r3 = System.currentTimeMillis() - this.b;
        String r5 = r9.logId;
        HashMap r6 = new HashMap();
        r6.put("xplay_init_callback_status", Integer.valueOf(this.a));
        Unit r10 = Unit.INSTANCE;
        r1.c(r2, r3, r5, r6);
        return;
    L9:
        return;
    }
}
