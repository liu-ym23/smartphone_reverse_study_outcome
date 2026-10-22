package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements Runnable {
    public final /* synthetic */ n a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(n r1) {
        this.a = r1;
    }
}
