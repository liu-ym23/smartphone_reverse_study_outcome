package com.obric.memorydata.memory.ui.list;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListViewModel$Companion$transformToMemoryItemEntity$2", f = "MemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryListViewModel$Companion$transformToMemoryItemEntity$2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super List<? extends com.obric.memorydata.memory.ui.data.a.h>>, Object> {
    final /* synthetic */ long $currentTimestamp;
    final /* synthetic */ RawMemoryEntity $this_transformToMemoryItemEntity;
    int label;

    MemoryListViewModel$Companion$transformToMemoryItemEntity$2(RawMemoryEntity r3, long r4, Continuation<? super MemoryListViewModel$Companion$transformToMemoryItemEntity$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_transformToMemoryItemEntity = r3;
        this.$currentTimestamp = r4;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryListViewModel$Companion$transformToMemoryItemEntity$2(this.$this_transformToMemoryItemEntity, this.$currentTimestamp, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super List<? extends com.obric.memorydata.memory.ui.data.a.h>> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super List<com.obric.memorydata.memory.ui.data.a.h>> r4) {
        return ((MemoryListViewModel$Companion$transformToMemoryItemEntity$2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryListViewModel$Companion$transformToMemoryItemEntity$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r10);
        MemoryEntity r2 = com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity(this.$this_transformToMemoryItemEntity);
        RunLog.INSTANCE.debug("MemoryListViewModel", "MemoryEntity: " + r2);
        if (r2 == null) goto L9;
        List r9 = CollectionsKt.listOf(new com.obric.memorydata.memory.ui.data.a.h(r2, MemoryListViewModel.a.a(MemoryListViewModel.Companion, r2, this.$currentTimestamp), false, null, null, 24, null));
        if (r9 == null) goto L9;
        return r9;
    L9:
        return CollectionsKt.emptyList();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
