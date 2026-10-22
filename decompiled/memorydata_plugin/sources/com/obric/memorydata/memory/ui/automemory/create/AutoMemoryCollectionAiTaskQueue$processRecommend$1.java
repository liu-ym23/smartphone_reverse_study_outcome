package com.obric.memorydata.memory.ui.automemory.create;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCollectionAiTaskQueue", f = "AutoMemoryCollectionAiTaskQueue.kt", i = {0, 0, 0, 0, 0}, l = {216, 241}, m = "processRecommend", n = {"this", "task", "rule", "candidates", "labelToPkg"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class AutoMemoryCollectionAiTaskQueue$processRecommend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutoMemoryCollectionAiTaskQueue this$0;

    AutoMemoryCollectionAiTaskQueue$processRecommend$1(AutoMemoryCollectionAiTaskQueue r3, Continuation<? super AutoMemoryCollectionAiTaskQueue$processRecommend$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return AutoMemoryCollectionAiTaskQueue.c(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
