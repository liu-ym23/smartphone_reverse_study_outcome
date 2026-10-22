package com.bytedance.android.ec.core.hybrid.prefetch;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements Runnable {
    public final /* synthetic */ String a;

    public r(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NativePrefetchUtil.a.remove(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
