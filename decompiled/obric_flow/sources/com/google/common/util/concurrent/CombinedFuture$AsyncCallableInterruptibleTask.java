package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class CombinedFuture$AsyncCallableInterruptibleTask extends CombinedFuture$CombinedFutureInterruptibleTask<w0> {
    private final r callable;
    final /* synthetic */ f0 this$0;

    public CombinedFuture$AsyncCallableInterruptibleTask(f0 r5, r r10, Executor r11) {
        super(r5, r11);
        r10.getClass();
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public /* bridge */ /* synthetic */ Object runInterruptibly() throws Exception {
        return runInterruptibly();
    }

    @Override // com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask
    public /* bridge */ /* synthetic */ void setValue(w0 r5) {
        setValue2(r5);
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public String toPendingString() {
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public w0 runInterruptibly() throws Exception {
        throw null;
    }

    /* JADX INFO: renamed from: setValue, reason: avoid collision after fix types in other method */
    public void setValue2(w0 r5) {
        throw null;
    }
}
