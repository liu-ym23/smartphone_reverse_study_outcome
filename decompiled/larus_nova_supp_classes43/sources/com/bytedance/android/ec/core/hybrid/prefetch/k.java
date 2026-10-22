package com.bytedance.android.ec.core.hybrid.prefetch;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements Runnable {
    public final /* synthetic */ Job a;

    public k(Job r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Job.DefaultImpls.cancel$default(this.a, null, 1, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
