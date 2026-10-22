package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.EventEmitter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ JavaOnlyMap b;
    public final /* synthetic */ d0 c;

    @Override // java.lang.Runnable
    public final void run() {
        com.lynx.tasm.event.a r0 = new com.lynx.tasm.event.a(this.a, "intersection", this.b);     // Catch: Throwable -> L8
        LynxContext r1 = this.c.w.get();     // Catch: Throwable -> L8
        if (r1 == null) goto L11;
        EventEmitter r2 = r1.getEventEmitter();     // Catch: Throwable -> L8
        if (r2 == null) goto L15;
        r2.sendCustomEvent(r0);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public v(d0 r1, int r2, JavaOnlyMap r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
