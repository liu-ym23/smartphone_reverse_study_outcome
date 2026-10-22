package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList<String> r0 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_BatchValidateService", "network type change validate", false);
        Map<String, i> r1 = this.a.a.i();
        List<PolicyModel> r3 = this.a.g;
        ArrayList r4 = new ArrayList();
        Iterator r5 = ((ArrayList) r3).iterator();
    L3:
        boolean r6 = true;
        if (r5.hasNext() == false) goto L14;
        Object r7 = r5.next();
        i r8 = r1.get(((PolicyModel) r7).getTaskId());
        if (r8 != null) goto L8;
    L10:
        r6 = false;
    L11:
        if (r6 == false) goto L3;
        r4.add(r7);
        goto L3
    L8:
        if (r8.a != true) goto L10;
    L14:
        if (this.a.e == null) goto L17;
        ArrayList<String> r2 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_BatchValidateService", "networkTypeChange validate meet frequency control", true);
        return;
    L17:
        ArrayList<String> r9 = com.ss.android.lark.conditional.access.utils.c.a;
        StringBuilder r10 = new StringBuilder("Full validate from: ");
        FileAuthMonitor.UpdateTrigger r11 = FileAuthMonitor.UpdateTrigger.NetworkChange;
        r10.append(r11);
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_BatchValidateService", r10.toString(), true);
        Timer r12 = this.a.e;
        if (r12 == null) goto L20;
        r12.cancel();
    L20:
        a.b r13 = this.a.f;
        if (r13 == null) goto L23;
        r13.cancel();
    L23:
        a r14 = this.a;
        r14.f = new a.b(this.a, r11, r4);
        a r15 = this.a;     // Catch: Exception -> L26
        PthreadTimer r16 = new PthreadTimer("BatchValidateService$networkTypeChangeValidate$1");     // Catch: Exception -> L26
        a r17 = this.a;     // Catch: Exception -> L26
        r16.schedule(r17.f, r17.d);     // Catch: Exception -> L26
        r15.e = r16;     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "Network change validate timer schedule task failed");
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
