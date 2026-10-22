package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.event.LynxEvent;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements Runnable {
    public final /* synthetic */ LynxEvent a;
    public final /* synthetic */ LynxEngineProxy b;

    @Override // java.lang.Runnable
    public final void run() {
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (this.b.a != 0) goto L5;
        LLog.e("LynxEngineProxy", "startEventGenerate failed since mNativePtr is null");     // Catch: Throwable -> L11
        return;
    L5:
        j7a.a r0 = j7a.a.a;     // Catch: Throwable -> L11
        ArrayList<Object> r1 = this.a.getEventParams();     // Catch: Throwable -> L11
        r0.getClass();     // Catch: Throwable -> L11
        ByteBuffer r2 = j7a.a.b(r1);     // Catch: Throwable -> L11
        if (r2 != null) goto L8;
        int r3 = 0;
    L9:
        LynxEngineProxy r4 = this.b;     // Catch: Throwable -> L11
        LynxEngineProxy.l(r4, r4.a, r2, r3);     // Catch: Throwable -> L11
        return;
    L8:
        r3 = r2.position();     // Catch: Throwable -> L11
        goto L9
    }

    public l(LynxEngineProxy r1, LynxEvent r2) {
        this.b = r1;
        this.a = r2;
    }
}
