package com.obric.assistant.frontier;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.IObricDeviceStateService;
import hm9.j;
import kotlin.Lazy;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements IObricDeviceStateService.a {
    public e() {
    }

    public final void onUserPresent() {
    }

    public final void onScreenOff() {
        Job r0 = d.g;
        if (r0 != null) goto L5;
    L10:
        d.e = true;
        Lazy r1 = d.a;
        com.larus.im.f r2 = d.c();
        if (r2 == null) goto L14;
        r2.h("onScreenOff", false);
        return;
    L14:
        return;
    L5:
        if (r0.isActive() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        goto L10
    }

    public final void onScreenOn() {
        Lazy r0 = d.a;
        boolean r1 = false;
        d.e = false;
        AppHost.Companion r2 = AppHost.a;
        if (r2.a().isAppBackground() == true) goto L5;
    L10:
        r1 = true;
    L11:
        FLogger.a.i("ObricFrontierStatusMonitor", "canConnectForObric = " + r1 + " obricAssistantDeactive = " + d.d + " isAppBackground = " + r2.a().isAppBackground() + " mode = " + j.h.y + ", screenOff = " + d.e + ' ');
        if (r1 == false) goto L23;
        Job r3 = d.g;
        if (r3 != null) goto L16;
    L21:
        d.a("onScreenOn");
        return;
    L16:
        if (r3.isActive() == true) goto L19;
        r3 = null;
    L19:
        if (r3 == null) goto L21;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        goto L21
    L23:
        return;
    L5:
        if (d.d == false) goto L10;
        if (j.h.y == 2) goto L11;
        if (d.e == true) goto L11;
        goto L10
    }
}
