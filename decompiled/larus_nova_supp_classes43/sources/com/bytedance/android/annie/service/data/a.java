package com.bytedance.android.annie.service.data;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ DataProviderService.ImitateRedisEngine a;
    public final /* synthetic */ String b;

    public a(DataProviderService.ImitateRedisEngine r1, String r10) {
        this.a = r1;
        this.b = r10;
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
