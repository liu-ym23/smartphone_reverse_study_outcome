package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements Runnable {
    public final /* synthetic */ ForsetiChainFragment a;
    public final /* synthetic */ boolean b;

    public o(ForsetiChainFragment r1) {
        this.a = r1;
        this.b = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.ca0().k(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
