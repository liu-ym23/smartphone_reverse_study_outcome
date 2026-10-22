package com.bytedance.crash.dumper;

import com.bytedance.crash.npth_repair.monitor.SignalMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n {
    public static void a(File r2) {
        String r3 = new PolarisFileWrapper(r2, "signal_monitor.txt").getAbsolutePath();     // Catch: Throwable -> L17
        boolean r0 = nh4.a.g;     // Catch: Throwable -> L17
        monitor-enter(nh4.a.class);     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L5:
        if ((nh4.a.e.a.d & 4) == 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        SignalMonitor.b().a(r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(nh4.a.class);     // Catch: Throwable -> L17
        return;
    L7:
        r1 = false;
    }
}
