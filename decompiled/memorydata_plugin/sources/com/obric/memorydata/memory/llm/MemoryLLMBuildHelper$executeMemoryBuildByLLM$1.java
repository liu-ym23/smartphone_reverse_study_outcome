package com.obric.memorydata.memory.llm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.MemoryLLMBuildHelper", f = "MemoryLLMBuildHelper.kt", i = {0, 0}, l = {102}, m = "executeMemoryBuildByLLM", n = {"trackingEvent", "isDebug"}, s = {"L$0", "Z$0"})
final class MemoryLLMBuildHelper$executeMemoryBuildByLLM$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    MemoryLLMBuildHelper$executeMemoryBuildByLLM$1(d r3, Continuation<? super MemoryLLMBuildHelper$executeMemoryBuildByLLM$1> r4) {
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
