package com.lynx.animax.player;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ h b;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.b.m == null) goto L9;
        this.a.run();     // Catch: Throwable -> L6
        return;
    }

    public k(h r1, Runnable r2) {
        this.b = r1;
        this.a = r2;
    }
}
