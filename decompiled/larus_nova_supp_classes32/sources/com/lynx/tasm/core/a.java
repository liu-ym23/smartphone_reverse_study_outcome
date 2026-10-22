package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ LynxEngineProxy b;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r0 = this.b;     // Catch: Throwable -> L7
        long r1 = r0.a;     // Catch: Throwable -> L7
        if (r1 != 0) goto L5;
        LLog.e("LynxEngineProxy", "startEventCapture failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.b(r0, r1, this.a);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public a(LynxEngineProxy r1, long r2) {
        this.b = r1;
        this.a = r2;
    }
}
