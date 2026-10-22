package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "before", "after"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$timeline$2$2", f = "ContextAwarenessTimelineViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ContextAwarenessTimelineViewModel$timeline$2$2 extends SuspendLambda implements Function3<com.obric.memorydata.memory.ui.data.a, com.obric.memorydata.memory.ui.data.a, Continuation<? super com.obric.memorydata.memory.ui.data.a>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ContextAwarenessTimelineViewModel this$0;

    ContextAwarenessTimelineViewModel$timeline$2$2(ContextAwarenessTimelineViewModel r3, Continuation<? super ContextAwarenessTimelineViewModel$timeline$2$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(3, r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.obric.memorydata.memory.ui.data.a r3, com.obric.memorydata.memory.ui.data.a r4, Continuation<? super com.obric.memorydata.memory.ui.data.a> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ContextAwarenessTimelineViewModel$timeline$2$2 r0 = new ContextAwarenessTimelineViewModel$timeline$2$2(this.this$0, r6);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(com.obric.memorydata.memory.ui.data.a r3, com.obric.memorydata.memory.ui.data.a r4, Continuation<? super com.obric.memorydata.memory.ui.data.a> r5) {
        return invoke2((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        com.obric.memorydata.memory.ui.data.a r5 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.data.a r0 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(this.L$1, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        return ContextAwarenessTimelineViewModel.access$createTimeLine(this.this$0, r5, r0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
