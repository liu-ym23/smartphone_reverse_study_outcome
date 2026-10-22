package com.bytedance.ai.infra.thread_pool;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends PThreadScheduledThreadPoolExecutor {
    public c(d r10) {
        super(1, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void afterExecute(Runnable r1, Throwable r10) {
        super/*java.util.concurrent.ScheduledThreadPoolExecutor*/.afterExecute(r1, r10);
        c5.c.a(r1, r10);
    }
}
