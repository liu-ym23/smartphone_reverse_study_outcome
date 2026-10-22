package com.bytedance.lego.init.config;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class TaskConfig$a implements ThreadFactory {
    public final AtomicInteger a;

    public TaskConfig$a() {
        this.a = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r4) {
        return new PthreadThreadV2(r4, "AA InitThread#" + this.a.getAndIncrement());
    }
}
