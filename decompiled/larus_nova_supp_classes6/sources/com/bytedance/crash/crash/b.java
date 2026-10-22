package com.bytedance.crash.crash;

import com.bytedance.crash.monitor.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ a b;
    public final /* synthetic */ List c;
    public final /* synthetic */ c d;

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = 0;
    L12:
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    L4:
        if (r0 >= this.a.size()) goto L15;
        c r1 = this.d;     // Catch: Throwable -> L7
        CrashSummary r2 = (CrashSummary) ListProtector.get(this.a, r0);     // Catch: Throwable -> L7
        a r3 = this.b;     // Catch: Throwable -> L7
        File r4 = (File) ListProtector.get(this.c, r0);     // Catch: Throwable -> L7
        r1.getClass();     // Catch: Throwable -> L7
        c.b(r2, r3, r4);     // Catch: Throwable -> L7
        r0 = r0 + 1;
        goto L12
    }

    public b(c r1, List r2, a r3, List r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
