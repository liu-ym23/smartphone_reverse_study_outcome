package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ContextAwarenessTimelineViewModel$timeline$2$1 extends AdaptedFunctionReference implements SuspendFunction, Function2<t, Continuation<? super com.obric.memorydata.memory.ui.data.a>, Object> {
    public static final ContextAwarenessTimelineViewModel$timeline$2$1 INSTANCE = null;

    static {
        INSTANCE = new ContextAwarenessTimelineViewModel$timeline$2$1();
    }

    ContextAwarenessTimelineViewModel$timeline$2$1() {
        super(2, t.class, "toMemoryItem", "toMemoryItem()Lcom/obric/memorydata/memory/ui/data/MemoryItem;", 4);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(t r2, Continuation<? super com.obric.memorydata.memory.ui.data.a> r3) {
        return ContextAwarenessTimelineViewModel.access$timeline$lambda$2$toMemoryItem(r2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(t r3, Continuation<? super com.obric.memorydata.memory.ui.data.a> r4) {
        return invoke2((t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
