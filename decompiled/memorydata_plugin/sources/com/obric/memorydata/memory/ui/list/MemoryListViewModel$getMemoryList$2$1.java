package com.obric.memorydata.memory.ui.list;

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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "before", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "after"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListViewModel$getMemoryList$2$1", f = "MemoryListViewModel.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
final class MemoryListViewModel$getMemoryList$2$1 extends SuspendLambda implements Function3<com.obric.memorydata.memory.ui.data.a.h, com.obric.memorydata.memory.ui.data.a.h, Continuation<? super com.obric.memorydata.memory.ui.data.a>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MemoryListViewModel this$0;

    MemoryListViewModel$getMemoryList$2$1(MemoryListViewModel r3, Continuation<? super MemoryListViewModel$getMemoryList$2$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(3, r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.obric.memorydata.memory.ui.data.a.h r3, com.obric.memorydata.memory.ui.data.a.h r4, Continuation<? super com.obric.memorydata.memory.ui.data.a> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        MemoryListViewModel$getMemoryList$2$1 r0 = new MemoryListViewModel$getMemoryList$2$1(this.this$0, r6);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(com.obric.memorydata.memory.ui.data.a.h r3, com.obric.memorydata.memory.ui.data.a.h r4, Continuation<? super com.obric.memorydata.memory.ui.data.a> r5) {
        return invoke2((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.obric.memorydata.memory.ui.data.a.h r8 = (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.data.a.h r2 = (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(this.L$1, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin");
        MemoryListViewModel r4 = this.this$0;
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 1;
        r7 = MemoryListViewModel.access$generateMemoryItemTime(r4, r8, r2, r3);
        if (r7 != r0) goto L11;
        return r0;
    }
}
