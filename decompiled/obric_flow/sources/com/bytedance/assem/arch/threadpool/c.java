package com.bytedance.assem.arch.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ThreadFactory {
    public static final AtomicInteger d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f3944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f3945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3946c;

    static {
        d = new AtomicInteger(1);
    }

    public c() {
        this.f3945b = new AtomicInteger(1);
        SecurityManager r5 = System.getSecurityManager();
        if (r5 == null) goto L5;
        ThreadGroup r10 = r5.getThreadGroup();
    L6:
        this.f3944a = r10;
        this.f3946c = "pool-assem-core-" + d.getAndIncrement() + "-thread-";
        return;
    L5:
        r10 = Thread.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r10) {
        Thread r11 = new Thread(this.f3944a, r10, this.f3946c + this.f3945b.getAndIncrement(), 0);
        if (r11.isDaemon() == false) goto L6;
        r11.setDaemon(false);
    L6:
        if (r11.getPriority() == 5) goto L8;
        r11.setPriority(5);
    L8:
        return r11;
    }
}
