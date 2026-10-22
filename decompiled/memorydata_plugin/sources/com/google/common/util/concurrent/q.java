package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface q extends p, ScheduledExecutorService {
    n<?> a(Runnable r1, long r2, long r4, TimeUnit r6);

    n<?> a(Runnable r1, long r2, TimeUnit r4);

    <V> n<V> a(Callable<V> r1, long r2, TimeUnit r4);

    n<?> b(Runnable r1, long r2, long r4, TimeUnit r6);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* synthetic */ default ScheduledFuture schedule(Runnable r3, long r4, TimeUnit r6) {
        return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* synthetic */ default ScheduledFuture schedule(Callable r3, long r4, TimeUnit r6) {
        return a((Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* synthetic */ default ScheduledFuture scheduleAtFixedRate(Runnable r8, long r9, long r11, TimeUnit r13) {
        return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin"), r9, r11, r13);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* synthetic */ default ScheduledFuture scheduleWithFixedDelay(Runnable r8, long r9, long r11, TimeUnit r13) {
        return b((Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin"), r9, r11, r13);
    }
}
