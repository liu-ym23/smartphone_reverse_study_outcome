package com.obric.aikernel.phx.sdk.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {181, 186, 194}, m = "getMainProcessIpcBinding$sdk_release", n = {"this", "timeoutMs", "totalBudgetMs", "deadlineMs", "this", "serviceConnector", "timeoutMs", "totalBudgetMs", "this"}, s = {"L$0", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0", "J$1", "L$0"})
final class AIKernelApi$getMainProcessIpcBinding$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$getMainProcessIpcBinding$1(AIKernelApi r3, Continuation<? super AIKernelApi$getMainProcessIpcBinding$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMainProcessIpcBinding$sdk_release(0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
