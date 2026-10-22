package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.RecommendMemoryRepository", f = "RecommendMemoryRepository.kt", i = {0}, l = {168}, m = "onScreenMemoryOpenStatusChange", n = {"isEnable"}, s = {"Z$0"})
final class RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ bd this$0;

    RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1(bd r3, Continuation<? super RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
