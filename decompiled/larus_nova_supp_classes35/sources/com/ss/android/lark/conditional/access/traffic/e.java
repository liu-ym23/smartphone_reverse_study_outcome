package com.ss.android.lark.conditional.access.traffic;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Runnable {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, Integer> r0 = com.ss.android.lark.conditional.access.nopermission.manager.a.a;     // Catch: Throwable -> L4
        com.ss.android.lark.conditional.access.nopermission.manager.a.c(RegulateDispatcher.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
