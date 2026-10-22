package com.larus.dora.impl.dynamic;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ DoraDynamicFragment a;

    public k0(DoraDynamicFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DslCardAdapter r0 = this.a.h;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.E2();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
