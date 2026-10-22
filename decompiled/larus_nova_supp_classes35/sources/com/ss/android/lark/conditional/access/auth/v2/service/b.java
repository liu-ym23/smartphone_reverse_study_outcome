package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.Timer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ FileAuthMonitor.UpdateTrigger b;

    public b(a r1, FileAuthMonitor.UpdateTrigger r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (this.a.e == null) goto L5;
        ArrayList<String> r0 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.a("SecurityPolicy_BatchValidateService", "Full validate meet frequency control", true);
    L5:
        ArrayList<String> r1 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_BatchValidateService", "Full validate from: " + this.b, true);
        Timer r2 = this.a.e;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        a.b r3 = this.a.f;
        if (r3 == null) goto L11;
        r3.cancel();
    L11:
        a r4 = this.a;
        a r5 = this.a;
        r4.f = new a.b(r5, this.b, r5.e());
        a r6 = this.a;     // Catch: Exception -> L14
        PthreadTimer r7 = new PthreadTimer("BatchValidateService$batchValidate$1");     // Catch: Exception -> L14
        a r8 = this.a;     // Catch: Exception -> L14
        r7.schedule(r8.f, r8.d);     // Catch: Exception -> L14
        r6.e = r7;     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        ScsLogger.c("SecurityPolicy_BatchValidateService", "Full validate timer schedule task failed");
        EnsureManager.ensureNotReachHere(e, "Full validate timer schedule task failed");
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
