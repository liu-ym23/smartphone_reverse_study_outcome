package com.bytedance.android.ec.core.imagex;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Runnable {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirstScreenStatistic.S.getClass();     // Catch: Throwable -> L4
        FirstScreenStatistic.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
