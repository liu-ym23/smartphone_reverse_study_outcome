package com.obric.matrixpro.sdk.deviceinfoclient;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements Runnable {
    public final /* synthetic */ a.InterfaceC0042a a;

    public b(a.InterfaceC0042a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onError("查询失败：Cursor为空");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
