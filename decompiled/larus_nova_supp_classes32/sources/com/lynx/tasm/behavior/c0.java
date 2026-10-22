package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ d0 a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.v.clear();     // Catch: Throwable -> L4
        this.a.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c0(d0 r1) {
        this.a = r1;
    }
}
