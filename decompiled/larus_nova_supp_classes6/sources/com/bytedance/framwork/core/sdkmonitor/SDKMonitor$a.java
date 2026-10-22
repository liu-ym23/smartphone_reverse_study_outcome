package com.bytedance.framwork.core.sdkmonitor;

import by5.e;
import com.larus.apm.impl.protector.RunnableProtector;
import fy5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SDKMonitor$a implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        e r0 = e.a.a;     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        r0.b();     // Catch: Throwable -> L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L6:
        th = move-exception;
        c.c("forceReport", th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }

    public SDKMonitor$a() {
    }
}
