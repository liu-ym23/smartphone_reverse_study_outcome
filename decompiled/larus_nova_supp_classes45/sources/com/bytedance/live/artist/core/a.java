package com.bytedance.live.artist.core;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements ThreadFactory {
    public final ThreadGroup a;
    public final AtomicInteger b;
    public final String c;

    public a() {
        this.b = new AtomicInteger(1);
        SecurityManager r0 = System.getSecurityManager();
        if (r0 == null) goto L5;
        ThreadGroup r1 = r0.getThreadGroup();
    L6:
        this.a = r1;
        this.c = "artist-core-thread-";
        return;
    L5:
        r1 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        PthreadThreadV2 r6 = new PthreadThreadV2(this.a, r8, this.c + this.b.getAndIncrement(), 0);
        if (r6.isDaemon() == false) goto L6;
        r6.setDaemon(false);
    L6:
        if (r6.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r6, 5);
    L8:
        return r6;
    }
}
