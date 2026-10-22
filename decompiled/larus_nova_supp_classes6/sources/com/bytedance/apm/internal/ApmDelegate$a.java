package com.bytedance.apm.internal;

import b27.e;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApmDelegate$a implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        e.e();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ApmDelegate$a() {
    }
}
