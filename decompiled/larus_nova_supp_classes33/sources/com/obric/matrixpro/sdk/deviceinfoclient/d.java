package com.obric.matrixpro.sdk.deviceinfoclient;

import android.os.HandlerThread;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a.InterfaceC0042a c;

    public d(String r1, String r2, a.InterfaceC0042a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;     // Catch: Throwable -> L15
        if (r0 == null) goto L5;
        this.c.onError(r0);     // Catch: Throwable -> L15
    L20:
        return;
    L5:
        String r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L8;
    L13:
        this.c.onError("OSDID为空或列索引异常");     // Catch: Throwable -> L15
        goto L20
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        HandlerThread r3 = a.a;     // Catch: Throwable -> L15
        String r4 = this.b;     // Catch: Throwable -> L15
        this.c.onSuccess(r4);     // Catch: Throwable -> L15
        goto L20
    L10:
        r2 = false;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
