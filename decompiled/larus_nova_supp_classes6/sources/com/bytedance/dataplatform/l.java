package com.bytedance.dataplatform;

import com.larus.apm.impl.protector.RunnableProtector;
import ij4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class l implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;
    public final /* synthetic */ i c;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.h.b(this.a, this.b, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public l(i r1, String r2, a r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
