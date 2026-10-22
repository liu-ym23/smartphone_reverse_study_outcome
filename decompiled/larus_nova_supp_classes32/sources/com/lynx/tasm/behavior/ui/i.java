package com.lynx.tasm.behavior.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements Runnable {
    public final /* synthetic */ h a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();     // Catch: Throwable -> L4
        this.a.v.clear();     // Catch: Throwable -> L4
        h r0 = this.a;     // Catch: Throwable -> L4
        r0.q(r0.x, "disexposure");     // Catch: Throwable -> L4
        this.a.x.clear();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(h r1) {
        this.a = r1;
    }
}
