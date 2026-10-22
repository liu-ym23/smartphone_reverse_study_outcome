package com.larksuite.framework.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i extends p {
    public static final int l = 0;
    public static i m;
    public long h;
    public long i;
    public long j;
    public final AtomicInteger k;

    static {
        l = Runtime.getRuntime().availableProcessors();
        m = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(boolean r6) {
        if (r6 == false) goto L4;
        int r7 = this.k.incrementAndGet();
    L5:
        int r0 = getCorePoolSize();
        int r1 = getMaximumPoolSize();
        int r2 = r0 * 2;
        if (r7 > (r2 + 1)) goto L8;
    L11:
        if (r0 > 1) goto L13;
        return;
    L13:
        if (r7 > (r2 - 1)) goto L17;
        setMaximumPoolSize(r1 - 1);
        setCorePoolSize(r0 - 1);
        return;
    L17:
        return;
    L8:
        if (r0 >= l) goto L11;
        setCorePoolSize(r0 + 1);
        setMaximumPoolSize(r1 + 1);
        return;
    L4:
        r7 = this.k.decrementAndGet();
        goto L5
    }

    public i(String r9, BlockingQueue<Runnable> r10, n r11) {
        super(r9, 1, 2, 30, r10, r11);
        this.h = 1000;
        this.i = 5000;
        this.j = 5000;
        this.k = new AtomicInteger(0);
        this.b = this.a + "-SerialExecutor";
    }
}
