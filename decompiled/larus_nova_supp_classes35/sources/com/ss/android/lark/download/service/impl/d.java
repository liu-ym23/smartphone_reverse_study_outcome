package com.ss.android.lark.download.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.download.service.DownloadProgress;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ DownloadProgress a;
    public final /* synthetic */ e b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.b.b).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((wbb.e) r0.next()).a(this.a);     // Catch: Throwable -> L7
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

    public d(e r1, DownloadProgress r2) {
        this.b = r1;
        this.a = r2;
    }
}
