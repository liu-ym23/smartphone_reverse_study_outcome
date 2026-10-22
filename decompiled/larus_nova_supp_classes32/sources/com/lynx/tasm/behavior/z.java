package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ d0 b;

    public final void a() {
        Iterator<u> r0 = this.b.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        u r1 = r0.next();
        if (r1.a != this.a) goto L4;
        this.b.v.remove(r1);
        d0 r2 = this.b;
        if (r2.y == true) goto L10;
        return;
    L10:
        if (r2.v.isEmpty() == false) goto L17;
        this.b.c();
        return;
    L17:
        return;
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

    public z(d0 r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
