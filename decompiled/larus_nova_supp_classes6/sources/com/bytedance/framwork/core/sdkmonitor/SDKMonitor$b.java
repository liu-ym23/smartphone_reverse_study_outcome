package com.bytedance.framwork.core.sdkmonitor;

import by5.e;
import com.larus.apm.impl.protector.RunnableProtector;
import fy5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SDKMonitor$b implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        e r1 = e.a.a;     // Catch: Throwable -> L14
        monitor-enter(r1);     // Catch: Throwable -> L14
        r1.b();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw null;     // Catch: Throwable -> L15
    L29:
        throw null;     // Catch: Throwable -> L15
    L7:
        th = move-exception;
        c.c("forceReport", th);     // Catch: Throwable -> L11
    L26:
        throw null;     // Catch: Throwable -> L15
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        throw null;     // Catch: Throwable -> L15
    L28:
        throw null;     // Catch: Throwable -> L15
    L27:
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L19;
        return;
    L19:
        throw th;
    }

    public SDKMonitor$b() {
    }
}
