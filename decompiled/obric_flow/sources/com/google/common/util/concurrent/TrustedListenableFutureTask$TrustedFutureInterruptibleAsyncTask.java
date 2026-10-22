package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
final class TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<w0> {
    private final r callable;
    final /* synthetic */ d1 this$0;

    public TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask(d1 r5, r r10) {
        r10.getClass();
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public void afterRanInterruptiblyFailure(Throwable r5) {
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public /* bridge */ /* synthetic */ void afterRanInterruptiblySuccess(w0 r5) {
        afterRanInterruptiblySuccess2(r5);
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public final boolean isDone() {
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public /* bridge */ /* synthetic */ w0 runInterruptibly() throws Exception {
        return runInterruptibly();
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public String toPendingString() {
        throw null;
    }

    /* JADX INFO: renamed from: afterRanInterruptiblySuccess, reason: avoid collision after fix types in other method */
    public void afterRanInterruptiblySuccess2(w0 r5) {
        throw null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.common.util.concurrent.InterruptibleTask
    public w0 runInterruptibly() throws Exception {
        throw null;
    }
}
