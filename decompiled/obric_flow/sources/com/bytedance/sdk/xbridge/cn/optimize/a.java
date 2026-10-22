package com.bytedance.sdk.xbridge.cn.optimize;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ThreadFactory {
    public static final AtomicInteger d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f7352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f7353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7354c;

    static {
        d = new AtomicInteger(1);
    }

    public a() {
        Intrinsics.checkNotNullParameter("bdx_bridge_serial_executors", "factoryTag");
        this.f7353b = new AtomicInteger(1);
        SecurityManager r5 = System.getSecurityManager();
        if (r5 == null) goto L5;
        ThreadGroup r10 = r5.getThreadGroup();
    L6:
        this.f7352a = r10;
        this.f7354c = "bdx_bridge_serial_executors-" + d.getAndIncrement() + "-Thread-";
        return;
    L5:
        r10 = Thread.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        Thread r5 = new Thread(this.f7352a, r10, this.f7354c + this.f7353b.getAndIncrement(), 0);
        if (r5.isDaemon() == false) goto L6;
        r5.setDaemon(false);
    L6:
        if (r5.getPriority() == 5) goto L8;
        r5.setPriority(5);
    L8:
        return r5;
    }
}
