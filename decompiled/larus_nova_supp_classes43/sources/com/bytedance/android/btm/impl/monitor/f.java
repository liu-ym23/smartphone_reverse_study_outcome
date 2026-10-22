package com.bytedance.android.btm.impl.monitor;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements Runnable {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ String b;

    public f(Function0 r1) {
        this.a = r1;
        this.b = "btm_error";
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = String.valueOf(this.a.invoke());     // Catch: Throwable -> L7
        BtmHostDependManager r1 = BtmHostDependManager.F;     // Catch: Throwable -> L7
        r1.getClass();     // Catch: Throwable -> L7
        zc.f r10 = (zc.f) BtmHostDependManager.j.getValue(r1, BtmHostDependManager.a[8]);     // Catch: Throwable -> L7
        if (r10 == null) goto L5;
        r10.e(this.b, r0);     // Catch: Throwable -> L7
    L5:
        g r11 = g.a;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
