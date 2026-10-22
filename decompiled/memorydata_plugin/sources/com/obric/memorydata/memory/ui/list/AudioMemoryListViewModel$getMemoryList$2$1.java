package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$AudioEntity;", "rawAuditoryRecording", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$getMemoryList$2$1", f = "AudioMemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioMemoryListViewModel$getMemoryList$2$1 extends SuspendLambda implements Function2<fj, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a.C0539a>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    AudioMemoryListViewModel$getMemoryList$2$1(Continuation<? super AudioMemoryListViewModel$getMemoryList$2$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        AudioMemoryListViewModel$getMemoryList$2$1 r4 = new AudioMemoryListViewModel$getMemoryList$2$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(fj r3, Continuation<? super Iterable<com.obric.memorydata.memory.ui.data.a.C0539a>> r4) {
        return ((AudioMemoryListViewModel$getMemoryList$2$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AudioMemoryListViewModel$getMemoryList$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(fj r3, Continuation<? super Iterable<? extends com.obric.memorydata.memory.ui.data.a.C0539a>> r4) {
        return invoke2((fj) ZeusTransformUtils.preCheckCast(r3, fj.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        fj r1 = (fj) ZeusTransformUtils.preCheckCast(this.L$0, fj.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("AudioMemoryListViewModel", "rawAuditoryRecording: " + r1);
        return CollectionsKt.listOf(new com.obric.memorydata.memory.ui.data.a.C0539a(r1, false, null, 4, null));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
