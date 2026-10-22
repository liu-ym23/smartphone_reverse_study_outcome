package com.larksuite.common_selection;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k implements Runnable {
    public final /* synthetic */ i a;

    public k(i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.p.getAndSet(false) == false) goto L9;
        this.a.m();     // Catch: Throwable -> L6
        return;
    }
}
