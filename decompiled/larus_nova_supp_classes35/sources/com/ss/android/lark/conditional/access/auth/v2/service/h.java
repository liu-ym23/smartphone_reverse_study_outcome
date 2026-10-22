package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Runnable {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    public final void a() {
        f r0 = this.a;
        r0.getClass();
        ArrayList<String> r1 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_DelayCleanupService", "Clean up triggered", true);
        if (r0.e() >= 1) goto L6;
        com.ss.android.lark.conditional.access.utils.c.a("SecurityPolicy_DelayCleanupService", "IP Config point < 1， return", true);
        return;
    L6:
        if (r0.b != null) goto L15;
        r0.b = new PthreadTimer("DelayCleanupService");
        f.a r6 = new f.a(r0);
        r0.c = r6;
        PthreadTimer r5 = r0.b;     // Catch: Exception -> L12
        if (r5 == null) goto L14;
        long r9 = r0.e;     // Catch: Exception -> L12
        r5.schedule(r6, r9, r9);     // Catch: Exception -> L12
    L14:
        ArrayList<String> r2 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_DelayCleanupService", "clean timer is null, start new timer  " + r0.b, true);
    L12:
        e = move-exception;
        r0.b = null;
        EnsureManager.ensureNotReachHere(e, "Cleanup timer schedule task failed");
    L15:
        long r3 = System.currentTimeMillis();
        Iterator<Map.Entry<String, i>> r4 = r0.d.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L33;
        i r7 = r4.next().getValue();
        if (r7.a == false) goto L17;
        if (r7.b != null) goto L17;
        r7.b = Long.valueOf(r3);
        goto L17
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
