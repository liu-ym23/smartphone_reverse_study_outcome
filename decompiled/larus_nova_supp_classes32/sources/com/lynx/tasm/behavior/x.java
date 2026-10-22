package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.core.JSProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ JavaOnlyMap c;
    public final /* synthetic */ d0 d;

    @Override // java.lang.Runnable
    public final void run() {
        JSProxy r0 = this.d.x.get();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.c(this.a, this.b, this.c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public x(d0 r1, int r2, int r3, JavaOnlyMap r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
