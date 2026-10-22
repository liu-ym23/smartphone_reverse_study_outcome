package com.obric.memorydata.memory.llm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2", f = "MemoryLLMBuildHelperV2.kt", i = {0, 0}, l = {718}, m = "removeRejectedMemories", n = {"logger", "context"}, s = {"L$0", "L$1"})
final class MemoryLLMBuildHelperV2$removeRejectedMemories$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryLLMBuildHelperV2 this$0;

    MemoryLLMBuildHelperV2$removeRejectedMemories$1(MemoryLLMBuildHelperV2 r3, Continuation<? super MemoryLLMBuildHelperV2$removeRejectedMemories$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return MemoryLLMBuildHelperV2.a(this.this$0, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
