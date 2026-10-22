package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
final class TrustedListenableFutureTask$TrustedFutureInterruptibleTask extends InterruptibleTask<Object> {
    private final Callable<Object> callable;
    final /* synthetic */ d1 this$0;

    public TrustedListenableFutureTask$TrustedFutureInterruptibleTask(d1 r5, Callable<Object> r10) {
        r10.getClass();
        this.callable = r10;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public void afterRanInterruptiblyFailure(Throwable r5) {
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public void afterRanInterruptiblySuccess(Object r5) {
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public final boolean isDone() {
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public Object runInterruptibly() throws Exception {
        return this.callable.call();
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public String toPendingString() {
        return this.callable.toString();
    }
}
