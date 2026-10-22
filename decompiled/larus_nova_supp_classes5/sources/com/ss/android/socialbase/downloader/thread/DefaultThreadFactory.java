package com.ss.android.socialbase.downloader.thread;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private final boolean ignoreStatusCheck;
    private final String threadName;
    private final AtomicInteger threadSeq;

    public DefaultThreadFactory(String r2) {
        this(r2, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        PthreadThreadV2 r1 = new PthreadThreadV2(r4, this.threadName + "-" + this.threadSeq.incrementAndGet());
        if (this.ignoreStatusCheck == false) goto L5;
    L10:
        return r1;
    L5:
        if (r1.isDaemon() == false) goto L8;
        r1.setDaemon(false);
    L8:
        if (r1.getPriority() == 5) goto L10;
        ThreadMethodProxy.setPriority(r1, 5);
        goto L10
    }

    public DefaultThreadFactory(String r2, boolean r3) {
        this.threadSeq = new AtomicInteger();
        this.threadName = r2;
        this.ignoreStatusCheck = r3;
    }
}
