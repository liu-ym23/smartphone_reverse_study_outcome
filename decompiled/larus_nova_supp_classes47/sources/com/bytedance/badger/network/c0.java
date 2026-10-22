package com.bytedance.badger.network;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ b b;

    public c0(Function0 r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        z0 r1 = d0.a;     // Catch: Throwable -> L7
        d0.e(this.b, th, "uploadThread - execution failed");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
