package com.ss.ugc.effectplatform;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k$a implements Runnable {
    public final /* synthetic */ Runnable a;

    public k$a(Runnable r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.run();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
