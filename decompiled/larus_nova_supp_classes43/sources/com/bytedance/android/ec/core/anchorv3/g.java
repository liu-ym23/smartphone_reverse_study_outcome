package com.bytedance.android.ec.core.anchorv3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements Runnable {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
