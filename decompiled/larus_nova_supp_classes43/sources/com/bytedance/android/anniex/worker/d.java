package com.bytedance.android.anniex.worker;

import android.app.Application;
import com.bytedance.ies.bullet.service.base.m0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Runnable {
    public d(String r1, Application r10) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        s26.d r0 = s26.d.c;     // Catch: Throwable -> L6
        m0 r1 = s26.d.c.c(m0.class);     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.a0();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
