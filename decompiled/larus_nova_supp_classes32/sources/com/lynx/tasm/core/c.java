package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ long b;
    public final /* synthetic */ LynxEngineProxy c;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r0 = this.c;     // Catch: Throwable -> L7
        long r1 = r0.a;     // Catch: Throwable -> L7
        if (r1 != 0) goto L5;
        LLog.e("LynxEngineProxy", "startEventFire failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.d(r0, r1, this.a, this.b);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public c(LynxEngineProxy r1, boolean r2, long r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
