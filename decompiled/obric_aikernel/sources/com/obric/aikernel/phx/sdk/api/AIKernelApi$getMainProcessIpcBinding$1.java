package com.obric.aikernel.phx.sdk.api;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {180, 185, 193}, m = "getMainProcessIpcBinding$sdk_release", n = {"this", "timeoutMs", "totalBudgetMs", "deadlineMs", "this", "serviceConnector", "timeoutMs", "totalBudgetMs", "this"}, s = {"L$0", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0", "J$1", "L$0"})
final class AIKernelApi$getMainProcessIpcBinding$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$getMainProcessIpcBinding$1(AIKernelApi r10, Continuation<? super AIKernelApi$getMainProcessIpcBinding$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(0, this);
    }
}
