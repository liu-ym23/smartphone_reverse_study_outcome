package com.obric.memorydata.memory.memoryentity;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.memoryentity.MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1", f = "MemoryEntityViewPageDataManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends MemoryEntity>>, Object> {
    final /* synthetic */ List<EpisodicMemoryEntity> $episodicMemoryEntities;
    int label;

    MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1(List<EpisodicMemoryEntity> r3, Continuation<? super MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1> r4) {
        List<EpisodicMemoryEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$episodicMemoryEntities = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1(this.$episodicMemoryEntities, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends MemoryEntity>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<? extends MemoryEntity>> r4) {
        return ((MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this.$episodicMemoryEntities, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        AppEntity r1 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r6.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (ZeusTransformUtils.instanceOf(r1, MemoryEntity.class) == false) goto L10;
        MemoryEntity r2 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin");
    L11:
        if (r2 == null) goto L6;
        r5.add(r2);
        goto L6
    L10:
        r2 = null;
        goto L11
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
