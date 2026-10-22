package com.bytedance.android.live.core.monitor.trace;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Runnable {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        TraceMonitor.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
