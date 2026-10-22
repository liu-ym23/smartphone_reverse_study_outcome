package com.obric.matrixpro.sdk.deviceinfoclient;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements Runnable {
    public final /* synthetic */ a.InterfaceC0042a a;

    public c(a.InterfaceC0042a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onError("Cursor无有效数据");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
