package com.ss.ugc.live.sdk.msg.unify;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ f b;

    public h(c r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.c.d(c.a.b.a);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.b.n, "bridge register timeout: " + this.a.a() + ", try http once");
        f r0 = this.b;
        r0.g(r0.a());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
