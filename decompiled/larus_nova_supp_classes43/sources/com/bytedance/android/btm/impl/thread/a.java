package com.bytedance.android.btm.impl.thread;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements ThreadFactory {
    public final AtomicInteger a;
    public final String b;

    public a(String r1) {
        this.b = r1;
        this.a = new AtomicInteger();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r10) {
        PthreadThreadV2 r1 = new PthreadThreadV2(r10, "btm-" + this.b + '-' + this.a.incrementAndGet());
        if (r1.isDaemon() == false) goto L6;
        r1.setDaemon(false);
    L6:
        if (r1.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r1, 5);
    L8:
        return r1;
    }
}
