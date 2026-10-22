package com.obric.memorydata.recommend.ui.list;

import com.bytedance.obric.memory.model.MemoryData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/obric/memory/model/MemoryData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.MemoryListViewModel$getMemoryList$2$1$1", f = "MemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryListViewModel$getMemoryList$2$1$1 extends SuspendLambda implements Function2<MemoryData, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MemoryListViewModel $this_run;
    /* synthetic */ Object L$0;
    int label;

    MemoryListViewModel$getMemoryList$2$1$1(MemoryListViewModel r3, Continuation<? super MemoryListViewModel$getMemoryList$2$1$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_run = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        MemoryListViewModel$getMemoryList$2$1$1 r0 = new MemoryListViewModel$getMemoryList$2$1$1(this.$this_run, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MemoryData r3, Continuation<? super Boolean> r4) {
        return ((MemoryListViewModel$getMemoryList$2$1$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryListViewModel$getMemoryList$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(MemoryData r3, Continuation<? super Boolean> r4) {
        return invoke2((MemoryData) ZeusTransformUtils.preCheckCast(r3, MemoryData.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return Boxing.boxBoolean(!MemoryListViewModel.access$getCachedData$p(this.$this_run).contains(Boxing.boxLong(((MemoryData) ZeusTransformUtils.preCheckCast(this.L$0, MemoryData.class, "com.obric.memorydata.plugin")).id)));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
