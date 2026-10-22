package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements Runnable {
    public final /* synthetic */ com.lynx.tasm.event.a a;
    public final /* synthetic */ LynxEngineProxy b;

    public final void a() {
        if (this.b.a != 0) goto L6;
        LLog.e("LynxEngineProxy", "SendCustomEvent failed since mNativePtr is null");
        return;
    L6:
        j7a.a r0 = j7a.a.a;
        Map<String, Object> r1 = this.a.b();
        r0.getClass();
        ByteBuffer r7 = j7a.a.b(r1);
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        String r9 = this.a.c();
        LynxEngineProxy r2 = this.b;
        LynxEngineProxy.h(r2, r2.a, this.a.getName(), this.a.getTag(), r7, r8, r9);
        return;
    L9:
        r8 = r7.position();
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(LynxEngineProxy r1, com.lynx.tasm.event.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
