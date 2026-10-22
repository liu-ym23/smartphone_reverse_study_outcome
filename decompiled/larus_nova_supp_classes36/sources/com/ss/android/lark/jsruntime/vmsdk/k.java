package com.ss.android.lark.jsruntime.vmsdk;

import com.bytedance.vmsdk.worker.JsWorker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;

    public k(j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r0 = this.a;     // Catch: Throwable -> L6
        JsWorker r1 = r0.c;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.evaluateJavaScript(this.b, r0.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
