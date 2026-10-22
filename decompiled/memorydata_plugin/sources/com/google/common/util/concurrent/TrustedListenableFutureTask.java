package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes2.dex */
class TrustedListenableFutureTask<V> extends g.a<V> implements RunnableFuture<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile InterruptibleTask<?> f4830b;

    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<l<V>> {
        private final e<V> callable;
        final /* synthetic */ TrustedListenableFutureTask this$0;

        TrustedFutureInterruptibleAsyncTask(TrustedListenableFutureTask r3, e<V> r4) {
            e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.callable = (e) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), e.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptiblyFailure(Throwable r1) {
            this.this$0.a(r1);
        }

        void afterRanInterruptiblySuccess(l<V> r3) {
            l<? extends V> r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
            this.this$0.a(r4);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* synthetic */ void afterRanInterruptiblySuccess(Object r3) {
            afterRanInterruptiblySuccess((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return this.this$0.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        l<V> runInterruptibly() {
            return (l) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable), l.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* bridge */ /* synthetic */ Object runInterruptibly() {
            return runInterruptibly();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ TrustedListenableFutureTask this$0;

        TrustedFutureInterruptibleTask(TrustedListenableFutureTask r3, Callable<V> r4) {
            Callable r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.callable = (Callable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Callable.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptiblyFailure(Throwable r1) {
            this.this$0.a(r1);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptiblySuccess(V r1) {
            this.this$0.a(r1);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return this.this$0.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        V runInterruptibly() {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    @Override // com.google.common.util.concurrent.a
    public void c() {
        super.c();
        if (b() == false) goto L7;
        InterruptibleTask<?> r0 = this.f4830b;
        if (r0 == null) goto L7;
        r0.interruptTask();
    L7:
        this.f4830b = null;
    }

    @Override // com.google.common.util.concurrent.a
    public String e() {
        InterruptibleTask<?> r0 = this.f4830b;
        if (r0 == null) goto L7;
        return "task=[" + r0 + "]";
    L7:
        return super.e();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> r0 = this.f4830b;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        this.f4830b = null;
    }
}
