package com.bytedance.android.annie.resource;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ForestLoader.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
