package com.ss.android.lark.contact.base.service;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ q b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.b.a).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((f9b.a) r0.next()).a(this.a);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public o(q r1, List r2) {
        this.b = r1;
        this.a = r2;
    }
}
