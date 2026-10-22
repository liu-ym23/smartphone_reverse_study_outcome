package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.DefaultContextAwarenessTimelinePageRepository", f = "ContextAwarenessTimelineRepository.kt", i = {0, 0, 0, 0, 1}, l = {394, 402}, m = "querySelectionMetaInfo", n = {"this", "dayRange", "audioIds", "withSpecifiedRange", "screenMetaInfo"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0"})
final class DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ y this$0;

    DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1(y r3, Continuation<? super DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
