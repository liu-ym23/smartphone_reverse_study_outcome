package com.bytedance.badger.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements ThreadFactory {
    public final String a;
    public final AtomicInteger b;

    public l() {
        this.b = new AtomicInteger(1);
        this.a = "Badger-IO";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r4) {
        return new PthreadThreadV2(r4, this.a + "-" + this.b.getAndIncrement());
    }
}
