package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ByteBuffer d;
    public final /* synthetic */ int e;
    public final /* synthetic */ LynxEngineProxy f;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r0 = this.f;     // Catch: Throwable -> L7
        long r1 = r0.a;     // Catch: Throwable -> L7
        if (r1 != 0) goto L5;
        LLog.e("LynxEngineProxy", "sendGestureEvent failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.i(r0, r1, this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public i(LynxEngineProxy r1, String r2, int r3, int r4, ByteBuffer r5, int r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
