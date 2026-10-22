package com.bytedance.ai.monitor.auth;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.security.SecureRandom;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements j {
    public final /* synthetic */ AppletAuthTaskMonitor.Session a;

    public b(AppletAuthTaskMonitor.Session r1) {
        this.a = r1;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        SecureRandom r0 = AppletAuthTaskMonitor.a;
        AppletAuthTaskMonitor.d(r10, this.a, null);
        r10.e("start_ts", this.a.c);
    }
}
