package com.larksuite.common_selection;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ boolean b;

    public l(i r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.m();     // Catch: Throwable -> L6
        if (this.b == false) goto L9;
        this.a.k();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
