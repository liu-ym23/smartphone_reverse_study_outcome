package com.ss.android.lark.chat.cot.detail;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements Runnable {
    public final /* synthetic */ c a;

    public i(c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CotStepExposureTracker r0 = this.a.n;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
