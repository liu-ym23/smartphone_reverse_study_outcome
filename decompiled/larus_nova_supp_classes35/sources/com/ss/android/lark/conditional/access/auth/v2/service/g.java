package com.ss.android.lark.conditional.access.auth.v2.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements Runnable {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;     // Catch: Throwable -> L10
        r0.getClass();     // Catch: Throwable -> L10
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "cancelTimer()");     // Catch: Throwable -> L10
        PthreadTimer r1 = r0.b;     // Catch: Throwable -> L10
        if (r1 == null) goto L5;
        r1.cancel();     // Catch: Throwable -> L10
    L5:
        f.a r2 = r0.c;     // Catch: Throwable -> L10
        if (r2 == null) goto L8;
        r2.cancel();     // Catch: Throwable -> L10
    L8:
        r0.c = null;     // Catch: Throwable -> L10
        r0.b = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
