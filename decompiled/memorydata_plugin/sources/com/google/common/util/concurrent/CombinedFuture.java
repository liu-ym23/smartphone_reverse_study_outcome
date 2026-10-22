package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CombinedFuture<V>.CombinedFutureInterruptibleTask<?> f4809b;

    private final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<l<V>> {
        private final e<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        AsyncCallableInterruptibleTask(CombinedFuture r3, e<V> r4, Executor r5) {
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
            Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3, r7);
            this.callable = (e) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), e.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        l<V> runInterruptibly() {
            return (l) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable), l.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* bridge */ /* synthetic */ Object runInterruptibly() {
            return runInterruptibly();
        }

        void setValue(l<V> r3) {
            l<? extends V> r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
            this.this$0.a(r4);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        /* synthetic */ void setValue(Object r3) {
            setValue((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    private final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        CallableInterruptibleTask(CombinedFuture r3, Callable<V> r4, Executor r5) {
            Callable r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
            Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r3, r7);
            this.callable = (Callable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), Callable.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        V runInterruptibly() {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        void setValue(V r1) {
            this.this$0.a(r1);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    private abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;

        CombinedFutureInterruptibleTask(CombinedFuture r3, Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.listenerExecutor = (Executor) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Executor.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void afterRanInterruptiblyFailure(Throwable r3) {
            CombinedFuture.a(this.this$0, null);
            if (ZeusTransformUtils.instanceOf(r3, ExecutionException.class) == false) goto L6;
            CombinedFuture r2 = this.this$0;
            r3 = ((ExecutionException) ZeusTransformUtils.preCheckCast(r3, ExecutionException.class, "com.obric.memorydata.plugin")).getCause();
        L5:
            r2.a(r3);
            return;
        L6:
            boolean r0 = ZeusTransformUtils.instanceOf(r3, CancellationException.class);
            r2 = this.this$0;
            if (r0 == false) goto L5;
            r2.cancel(false);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void afterRanInterruptiblySuccess(T r3) {
            CombinedFuture.a(this.this$0, null);
            setValue(r3);
        }

        final void execute() {
            this.listenerExecutor.execute(this);     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            this.this$0.a(e);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return this.this$0.isDone();
        }

        abstract void setValue(T r1);
    }

    static /* synthetic */ CombinedFutureInterruptibleTask a(CombinedFuture r0, CombinedFutureInterruptibleTask r1) {
        r0.f4809b = r1;
        return r1;
    }

    @Override // com.google.common.util.concurrent.a
    public void a() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> r0 = this.f4809b;
        if (r0 == null) goto L6;
        r0.interruptTask();
        return;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void a(AggregateFuture.ReleaseResourcesReason r2) {
        super.a(r2);
        if (r2 != AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) goto L6;
        this.f4809b = null;
        return;
    }
}
