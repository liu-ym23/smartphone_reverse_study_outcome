package com.lynx.tasm.ui.image;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements Runnable {
    public final /* synthetic */ h a;

    @Override // java.lang.Runnable
    public final void run() {
        h r0 = this.a;     // Catch: Throwable -> L6
        if (r0.u == false) goto L9;
        r0.u = false;     // Catch: Throwable -> L6
        r0.A.d();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public k(h r1) {
        this.a = r1;
    }
}
