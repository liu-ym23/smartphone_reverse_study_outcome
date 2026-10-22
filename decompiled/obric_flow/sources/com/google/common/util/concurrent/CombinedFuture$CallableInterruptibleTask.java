package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class CombinedFuture$CallableInterruptibleTask extends CombinedFuture$CombinedFutureInterruptibleTask<Object> {
    private final Callable<Object> callable;
    final /* synthetic */ f0 this$0;

    public CombinedFuture$CallableInterruptibleTask(f0 r5, Callable<Object> r10, Executor r11) {
        super(r5, r11);
        r10.getClass();
        this.callable = r10;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public Object runInterruptibly() throws Exception {
        return this.callable.call();
    }

    @Override // com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask
    public void setValue(Object r5) {
        throw null;
    }

    @Override // com.google.common.util.concurrent.InterruptibleTask
    public String toPendingString() {
        return this.callable.toString();
    }
}
