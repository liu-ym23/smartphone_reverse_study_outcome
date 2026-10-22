package com.bytedance.badger.network;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0 implements ThreadFactory {
    public final AtomicInteger a;

    public r0() {
        this.a = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r4) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r4, "BadgerRetry-" + this.a.incrementAndGet());
        r0.setDaemon(true);
        return r0;
    }
}
