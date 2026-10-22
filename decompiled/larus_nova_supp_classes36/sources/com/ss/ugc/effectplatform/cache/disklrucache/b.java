package com.ss.ugc.effectplatform.cache.disklrucache;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ a.c b;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.j(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r1, a.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
