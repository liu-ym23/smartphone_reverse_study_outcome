package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public interface p extends ExecutorService {
    l<?> a(Runnable r1);

    <T> l<T> a(Runnable r1, T r2);

    <T> l<T> a(Callable<T> r1);

    @Override // java.util.concurrent.ExecutorService
    /* synthetic */ default Future submit(Runnable r3) {
        return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.concurrent.ExecutorService
    /* synthetic */ default Future submit(Runnable r3, Object r4) {
        return a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // java.util.concurrent.ExecutorService
    /* synthetic */ default Future submit(Callable r3) {
        return a((Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin"));
    }
}
