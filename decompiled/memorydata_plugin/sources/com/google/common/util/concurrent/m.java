package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class m<V> extends FutureTask<V> implements l<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f4866a;

    m(Callable<V> r3) {
        super((Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin"));
        this.f4866a = new f();
    }

    public static <V> m<V> a(Callable<V> r2) {
        return new m((Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.util.concurrent.l
    public void addListener(Runnable r3, Executor r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        this.f4866a.a(r5, r6);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.f4866a.a();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public V get(long r6, TimeUnit r8) {
        long r0 = r8.toNanos(r6);
        if (r0 > 2147483647999999999L) goto L7;
        return (V) super.get(r6, r8);
    L7:
        return (V) super.get(Math.min(r0, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }
}
