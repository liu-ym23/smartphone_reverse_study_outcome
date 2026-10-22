package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.auth.v2.service.SecurityLabelConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements Runnable {
    public final /* synthetic */ Function1<SecurityLabelConfig, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public q(Function1<? super SecurityLabelConfig, Unit> r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.storage.kv.repo.a r0 = y.a;     // Catch: Throwable -> L8
        if (r0 == null) goto L5;
        SecurityLabelConfig r1 = (SecurityLabelConfig) r0.getJSONObject("FileAuthSecurityLabelConfig", SecurityLabelConfig.class);     // Catch: Throwable -> L8
    L6:
        this.a.invoke(r1);     // Catch: Throwable -> L8
        return;
    L5:
        r1 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
