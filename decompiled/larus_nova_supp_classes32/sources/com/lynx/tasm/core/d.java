package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements Runnable {
    public final /* synthetic */ LynxEngineProxy a;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r0 = this.a;     // Catch: Throwable -> L4
        LynxEngineProxy.a(r0, r0.a);     // Catch: Throwable -> L4
        this.a.a = 0;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(LynxEngineProxy r1) {
        this.a = r1;
    }
}
