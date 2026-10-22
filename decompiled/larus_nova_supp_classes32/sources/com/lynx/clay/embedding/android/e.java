package com.lynx.clay.embedding.android;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ d b;

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    L23:
        return;
    L3:
        if (this.a == this.b.g) goto L5;
        return;
    L5:
        if (this.b.e == true) goto L20;
        d r0 = this.b;     // Catch: Throwable -> L13
        if (r0.a != null) goto L9;
        return;
    L9:
        if (r0.b == null) goto L22;
        c5a.c.d(5, "ClayViewProvider", "enableMemoryPressurePolling() was not called; enabling fallback polling.");     // Catch: Throwable -> L13
        this.b.a();     // Catch: Throwable -> L13
        return;
    L22:
        return;
    }

    public e(d r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
