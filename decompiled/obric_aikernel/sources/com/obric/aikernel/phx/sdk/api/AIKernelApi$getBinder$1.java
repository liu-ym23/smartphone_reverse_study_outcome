package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.model_preset.impl.ipc.PresetDecryptIPCProvider;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {156, 161, 170}, m = PresetDecryptIPCProvider.METHOD_GET_BINDER, n = {"this", "timeoutMs", "totalBudgetMs", "deadlineMs", "this", "serviceConnector", "timeoutMs", "totalBudgetMs", "this"}, s = {"L$0", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0", "J$1", "L$0"})
final class AIKernelApi$getBinder$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$getBinder$1(AIKernelApi r10, Continuation<? super AIKernelApi$getBinder$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(0, this);
    }
}
