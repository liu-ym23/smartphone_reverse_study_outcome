package com.bytedance.android.chunkstreamprediction.network;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ChunkStreamDefaultThreadExecutor extends PThreadPoolExecutor {
    public static final Lazy<ChunkStreamDefaultThreadExecutor> d = null;
    public static final int e = 0;
    public final ThreadGroup a;
    public final AtomicInteger b;
    public final String c;

    public static final class a {
    }

    static {
        d = LazyKt.lazy(ChunkStreamDefaultThreadExecutor$Companion$instance$2.INSTANCE);
        e = Runtime.getRuntime().availableProcessors() + 1;
    }

    public ChunkStreamDefaultThreadExecutor() {
        int r10 = e;
        super(r10, r10, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ChunkStreamDefaultThreadExecutor"));
        SecurityManager r0 = System.getSecurityManager();
        if (r0 == null) goto L5;
        ThreadGroup r1 = r0.getThreadGroup();
    L6:
        this.a = r1;
        this.b = new AtomicInteger(1);
        this.c = "chunkstream-pool-thread-";
        setThreadFactory(new f(this));
        return;
    L5:
        r1 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }
}
