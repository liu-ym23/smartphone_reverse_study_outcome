package com.lynx.animax.player;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements Runnable {
    public final /* synthetic */ h a;

    @Override // java.lang.Runnable
    public final void run() {
        h r0 = this.a;     // Catch: Throwable -> L8
        boolean r1 = true;
        r0.g = true;     // Catch: Throwable -> L8
        if (r0.f > 0) goto L6;
        r1 = false;
    L6:
        r0.h = r1;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public j(h r1) {
        this.a = r1;
    }
}
