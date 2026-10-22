package com.bytedance.apm.util;

import com.bytedance.apm.k;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d implements Runnable {
    public final /* synthetic */ Throwable a;

    @Override // java.lang.Runnable
    public final void run() {
        k.b.a.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(Throwable r1) {
        this.a = r1;
    }
}
