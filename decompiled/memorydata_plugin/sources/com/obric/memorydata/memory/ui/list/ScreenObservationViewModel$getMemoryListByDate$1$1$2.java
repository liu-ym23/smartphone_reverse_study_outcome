package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;", "it", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$getMemoryListByDate$1$1$2", f = "ScreenObservationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScreenObservationViewModel$getMemoryListByDate$1$1$2 extends SuspendLambda implements Function2<EpisodicMemoryEntity, Continuation<? super com.obric.memorydata.memory.ui.data.a.i>, Object> {
    /* synthetic */ Object L$0;
    int label;

    ScreenObservationViewModel$getMemoryListByDate$1$1$2(Continuation<? super ScreenObservationViewModel$getMemoryListByDate$1$1$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ScreenObservationViewModel$getMemoryListByDate$1$1$2 r4 = new ScreenObservationViewModel$getMemoryListByDate$1$1$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(EpisodicMemoryEntity r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.i> r4) {
        return ((ScreenObservationViewModel$getMemoryListByDate$1$1$2) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScreenObservationViewModel$getMemoryListByDate$1$1$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(EpisodicMemoryEntity r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.i> r4) {
        return invoke2((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return new com.obric.memorydata.memory.ui.data.a.i((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(this.L$0, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"), null, 2, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
