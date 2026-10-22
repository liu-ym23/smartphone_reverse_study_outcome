package com.obric.memorydata.memory.llm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2", f = "MemoryLLMBuildHelperV2.kt", i = {}, l = {159}, m = "executeMemoryBuildByLLM", n = {}, s = {})
final class MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryLLMBuildHelperV2 this$0;

    MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1(MemoryLLMBuildHelperV2 r3, Continuation<? super MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
