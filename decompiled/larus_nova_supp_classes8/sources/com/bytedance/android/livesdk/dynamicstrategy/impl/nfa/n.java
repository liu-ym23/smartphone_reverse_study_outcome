package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements Runnable {
    public final String a;
    public final long b;
    public final j c;
    public final k d;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.b);     // Catch: Throwable -> L4
        this.d.a(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(String r2, long r3, j r5, k r6) {
        Intrinsics.checkNotNullParameter(r2, "runnableName");
        Intrinsics.checkNotNullParameter(r5, "runnable");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
