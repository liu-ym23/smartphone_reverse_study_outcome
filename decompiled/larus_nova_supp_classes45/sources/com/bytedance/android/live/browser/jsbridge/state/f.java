package com.bytedance.android.live.browser.jsbridge.state;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Runnable {
    public final /* synthetic */ StateObserver.a a;
    public final /* synthetic */ String b;

    public f(StateObserver.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b.decrementAndGet();     // Catch: Throwable -> L6
        AtomicInteger r0 = this.a.a.get(this.b);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.decrementAndGet();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
