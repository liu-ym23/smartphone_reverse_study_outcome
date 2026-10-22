package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$getMemoryListByDate$1$1$1", f = "ScreenObservationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScreenObservationViewModel$getMemoryListByDate$1$1$1 extends SuspendLambda implements Function2<EpisodicMemoryEntity, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ScreenObservationViewModel $this_run;
    /* synthetic */ Object L$0;
    int label;

    ScreenObservationViewModel$getMemoryListByDate$1$1$1(ScreenObservationViewModel r3, Continuation<? super ScreenObservationViewModel$getMemoryListByDate$1$1$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_run = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        ScreenObservationViewModel$getMemoryListByDate$1$1$1 r0 = new ScreenObservationViewModel$getMemoryListByDate$1$1$1(this.$this_run, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(EpisodicMemoryEntity r3, Continuation<? super Boolean> r4) {
        return ((ScreenObservationViewModel$getMemoryListByDate$1$1$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScreenObservationViewModel$getMemoryListByDate$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(EpisodicMemoryEntity r3, Continuation<? super Boolean> r4) {
        return invoke2((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return Boxing.boxBoolean(!ScreenObservationViewModel.access$getCachedData$p(this.$this_run).contains(Boxing.boxLong(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(this.L$0, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getId())));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
