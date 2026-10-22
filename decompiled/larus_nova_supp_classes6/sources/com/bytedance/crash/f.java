package com.bytedance.crash;

import com.bytedance.crash.monitor.d;
import com.bytedance.crash.monitor.k;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f implements Runnable {
    public final /* synthetic */ d a;

    @Override // java.lang.Runnable
    public final void run() {
        new com.bytedance.crash.monitor.e(this.a).c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(k r1) {
        this.a = r1;
    }
}
