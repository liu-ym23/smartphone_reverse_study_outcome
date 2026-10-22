package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.impl.paramcheck.checker.d;
import com.bytedance.android.btm.api.inner.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BcmParamsChecker$checkReal$2 implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ a b;

    public BcmParamsChecker$checkReal$2(c r1, a r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        final com.bytedance.android.bcm.impl.paramcheck.checker.b r0 = new com.bytedance.android.bcm.impl.paramcheck.checker.b();
        CopyOnWriteArrayList r1 = BcmParamsChecker.b;
        c r10 = this.a;
        a r11 = this.b;
        Iterator r12 = r1.iterator();     // Catch: Throwable -> L14
    L4:
        if (r12.hasNext() == false) goto L16;
        List r13 = ((d) r12.next()).a(r10, r11, r0.b);     // Catch: Throwable -> L14
        ArrayList r14 = (ArrayList) r0.a;     // Catch: Throwable -> L14
        r14.addAll(r13);     // Catch: Throwable -> L14
        if (r0.b == true) goto L9;
    L11:
        boolean r15 = false;
    L12:
        r0.b = r15;     // Catch: Throwable -> L14
        goto L4
    L9:
        if (r13.isEmpty() == false) goto L11;
        r15 = true;
    L16:
        ALogger.d.a("ParamsChecker", false, new AnonymousClass1(this, r0));
        if (r0.b == true) goto L25;
        this.a.a(r0);
        return;
    L25:
        return;
    L14:
        th = move-exception;
        com.bytedance.android.bcm.impl.monitor.b.b(4003, "bcm params check error", null, null, th, null, 188);
        goto L16
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
