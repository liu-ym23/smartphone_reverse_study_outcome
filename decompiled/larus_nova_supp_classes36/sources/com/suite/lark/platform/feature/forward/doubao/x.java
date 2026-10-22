package com.suite.lark.platform.feature.forward.doubao;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x implements Runnable {
    public final /* synthetic */ ForwardDoubaoActivity a;

    public x(ForwardDoubaoActivity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ForwardDoubaoActivity r0 = this.a;     // Catch: Throwable -> L4
        r0.o = false;     // Catch: Throwable -> L4
        r0.B1();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
