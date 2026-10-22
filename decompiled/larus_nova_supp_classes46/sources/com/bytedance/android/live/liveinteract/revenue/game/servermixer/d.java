package com.bytedance.android.live.liveinteract.revenue.game.servermixer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.utils.l;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import jc1.k;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;

    public d(int r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r4 = (Throwable) r8;
        StringBuilder r9 = new StringBuilder("xplay_init_callback_result, failed, lodId = ");
        qi0.d r0 = qi0.d.a;
        r9.append(qi0.d.b(r4));
        ALogger.e("XplayRTCManager", r9.toString());
        r0.a(true, "xplay_init_callback_result", -1, "initStatus: " + this.a + ", lodId = " + qi0.d.b(r4));
        IInteractService r10 = (IInteractService) k.f(IInteractService.class);
        if (r10 == null) goto L8;
        l r1 = r10.getLinkMicGameFullLinkMonitor();
        if (r1 == null) goto L9;
        LinkMonitorData r2 = LinkMonitorData.XplayInitCallBack;
        long r3 = System.currentTimeMillis() - this.b;
        HashMap r5 = new HashMap();
        r5.put("xplay_init_callback_status", Integer.valueOf(this.a));
        Unit r11 = Unit.INSTANCE;
        r1.a(r2, r3, r4, r5);
        return;
    L9:
        return;
    }
}
