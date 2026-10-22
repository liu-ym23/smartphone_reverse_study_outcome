package com.larus.dora.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import b59.b;
import com.larus.common.apphost.AppHost;
import com.larus.push.api.IPushService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import kotlin.collections.CollectionsKt;
import ms9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraPreWakeUpTask$b implements b {
    public DoraPreWakeUpTask$b() {
    }

    @Override // b59.b
    public final void c(byte[] r1) {
    }

    @Override // b59.b
    public final void d(int r8) {
        if (r8 != 3) goto L14;
        d.d("DoraPreWakeUpTask", "play done");
        int r9 = DoraPreWakeUpTask.d;
        AppHost.Companion r10 = AppHost.a;
        if (r10.a().isAppBackground() == false) goto L11;
        DoraPreWakeUpTask.p = true;
        Activity r0 = (Activity) CollectionsKt.lastOrNull(r10.a().g());
        if (r0 == null) goto L12;
        Class<?> r1 = r0.getClass();
        Intent r2 = new Intent(r10.getApplication(), r1);
        r2.addFlags(131072);
        IPushService r3 = (IPushService) ServiceManager.get().getService(IPushService.class);
        if (r3 == null) goto L12;
        Application r11 = r10.getApplication();
        int r4 = com.larus.utils.j0.a;
        r3.b(r11, r2, new a(com.larus.utils.j0.d(2131902577), com.larus.utils.j0.d(2131902576), "", 33553267));
    L12:
        DoraPreWakeUpTask.r = false;
        return;
    L11:
        DoraPreWakeUpTask.Companion.d();
        goto L12
    }
}
