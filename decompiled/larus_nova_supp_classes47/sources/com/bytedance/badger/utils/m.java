package com.bytedance.badger.utils;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public static volatile m b;
    public static final int c = 0;
    public final PThreadPoolExecutor a;

    static {
        c = Math.max(2, Runtime.getRuntime().availableProcessors() * 2);
    }

    public m() {
        l r7 = new l();
        PThreadPoolExecutor r9 = new PThreadPoolExecutor(2, c, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(DefaultConfig.MAX_CACHE_ENTRIES), r7, new ThreadPoolExecutor.CallerRunsPolicy());
        r9.allowCoreThreadTimeOut(true);
        this.a = r9;
    }

    public static m a() {
        if (b != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public final void b(Runnable r2) {
        this.a.execute(r2);     // Catch: Exception -> L4
        return;
    }
}
