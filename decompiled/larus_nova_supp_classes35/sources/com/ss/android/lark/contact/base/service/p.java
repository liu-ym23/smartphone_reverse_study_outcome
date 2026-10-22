package com.ss.android.lark.contact.base.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.base.entity.ExternalContact;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements Runnable {
    public final /* synthetic */ com.ss.android.lark.contact.base.entity.a a;
    public final /* synthetic */ q b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.b.b).iterator();     // Catch: Throwable -> L9
    L4:
        if (r0.hasNext() == false) goto L21;
        q.b r1 = (q.b) r0.next();     // Catch: Throwable -> L9
        r1.a();     // Catch: Throwable -> L9
        if ((r1 instanceof q.c) == false) goto L4;
        ((q.c) r1).b(this.a);     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }

    public p(q r1, ExternalContact r2, com.ss.android.lark.contact.base.entity.a r3) {
        this.b = r1;
        this.a = r3;
    }
}
