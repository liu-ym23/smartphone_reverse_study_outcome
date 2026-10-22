package com.obric.matrixpro.sdk.deviceinfoclient;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements Runnable {
    public final /* synthetic */ a.InterfaceC0042a a;
    public final /* synthetic */ Exception b;

    public e(a.InterfaceC0042a r1, Exception r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.InterfaceC0042a r0 = this.a;     // Catch: Throwable -> L7
        String r1 = this.b.getMessage();     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        r1 = "未知异常";
    L5:
        r0.onError("获取失败：".concat(r1));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
