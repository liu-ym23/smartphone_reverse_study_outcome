package com.obric.assistant.frontier;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hm9.j;
import hm9.s;
import kotlin.Lazy;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements f09.a.b {
    public f() {
    }

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onAppBackground, canDisconnect()=");
        Lazy r2 = d.a;
        r1.append(d.b());
        r1.append(", mode=");
        s r3 = j.h;
        r1.append(r3.y);
        r0.i("ObricFrontierStatusMonitor", r1.toString());
        if (d.b() == true) goto L5;
        return;
    L5:
        if (r3.y != 2) goto L19;
        Job r4 = d.g;
        if (r4 != null) goto L9;
    L14:
        com.larus.im.f r5 = d.c();
        if (r5 == null) goto L20;
        r5.h("onAppBackground", false);
        return;
    L20:
        return;
    L9:
        if (r4.isActive() == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L14;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        goto L14
    }

    public final void onAppForeground() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onAppForeground, mode=");
        s r2 = j.h;
        r1.append(r2.y);
        r0.i("ObricFrontierStatusMonitor", r1.toString());
        if (r2.y != 2) goto L17;
        Job r3 = d.g;
        if (r3 != null) goto L7;
    L12:
        IObricNetworkService r4 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r4 == null) goto L15;
        r4.f(false);
    L15:
        d.a("onAppForeground");
        return;
    L7:
        if (r3.isActive() == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L12;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        goto L12
    }
}
