package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ LynxEngineProxy d;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r0 = this.d;     // Catch: Throwable -> L7
        long r1 = r0.a;     // Catch: Throwable -> L7
        if (r1 != 0) goto L5;
        LLog.e("LynxEngineProxy", "OnPseudoStatusChanged failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.j(r0, r1, this.a, this.b, this.c);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public j(LynxEngineProxy r1, int r2, int r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
