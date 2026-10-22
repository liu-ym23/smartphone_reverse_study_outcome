package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
class k<V> implements l<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final l<?> f4864a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f4865b = null;
    private final V c;

    static final class a<V> extends com.google.common.util.concurrent.a.i<V> {
        a(Throwable r1) {
            a(r1);
        }
    }

    static {
        f4864a = new k(null);
        f4865b = Logger.getLogger(k.class.getName());
    }

    k(V r1) {
        this.c = r1;
    }

    @Override // com.google.common.util.concurrent.l
    public void addListener(Runnable r5, Executor r6) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4, "Runnable was null.");
        com.google.common.base.n.a(r7, "Executor was null.");
        r7.execute(r4);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        f4865b.log(Level.SEVERE, "RuntimeException while executing runnable " + r4 + " with executor " + r7, e);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r1) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.c;
    }

    @Override // java.util.concurrent.Future
    public V get(long r1, TimeUnit r3) {
        com.google.common.base.n.a(r3);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.c + "]]";
    }
}
