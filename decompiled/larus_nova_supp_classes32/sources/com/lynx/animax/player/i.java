package com.lynx.animax.player;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ h b;

    @Override // java.lang.Runnable
    public final void run() {
        h r0 = this.b;     // Catch: Throwable -> L7
        String r1 = this.a;     // Catch: Throwable -> L7
        r0.f++;     // Catch: Throwable -> L7
        r0.h = false;     // Catch: Throwable -> L7
        if (r0.e == false) goto L5;
        r0.a(r1);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        r0.e = true;     // Catch: Throwable -> L7
        r0.b(r1);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public i(h r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
