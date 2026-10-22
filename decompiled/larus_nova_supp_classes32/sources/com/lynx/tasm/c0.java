package com.lynx.tasm;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxEvent;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ EventEmitter.LynxEventType a;
    public final /* synthetic */ LynxEvent b;
    public final /* synthetic */ b0 c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<EventEmitter.c> r0 = this.c.f.iterator();     // Catch: Throwable -> L14
    L3:
        if (r0.hasNext() == false) goto L29;
        EventEmitter.c r1 = r0.next();     // Catch: Throwable -> L14
        if ((r1 instanceof com.lynx.tasm.behavior.d0) == false) goto L12;
        LynxContext r2 = ((com.lynx.tasm.behavior.d0) r1).getContext();     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        if (r2.getEnableNewIntersectionObserver() == true) goto L3;
    L12:
        r1.a(this.a, this.b);     // Catch: Throwable -> L14
        goto L3
    L29:
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L18;
        return;
    L18:
        throw th;
    }

    public c0(b0 r1, EventEmitter.LynxEventType r2, com.lynx.tasm.event.a r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
