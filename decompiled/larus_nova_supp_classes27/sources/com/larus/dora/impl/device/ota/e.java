package com.larus.dora.impl.device.ota;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
    }

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    public static void b(boolean r4) {
        g49.d.d("DoraOTAManagement", "[TEST] onOTAFinished isSuccess: " + r4);
        if (r4 == true) goto L5;
        g49.d.a("DoraOTAManagement", "[TEST] start upload alog");
        FLogger.a.uploadAllLog("OTA-Autotest", new c());
    L5:
        g49.d.a("DoraOTAManagement", "[TEST] scheduleNextOtaTest after 300s");
        ((ScheduledExecutorService) b.getValue()).schedule(new d(), 300000, TimeUnit.MILLISECONDS);
    }
}
