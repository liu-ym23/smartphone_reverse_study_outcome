package com.bytedance.android.live.livepullstream.service;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements Runnable {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = h.a;     // Catch: Throwable -> L4
        h.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
