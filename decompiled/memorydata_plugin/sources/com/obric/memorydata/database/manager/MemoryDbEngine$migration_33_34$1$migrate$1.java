package com.obric.memorydata.database.manager;

import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.ew;
import com.obric.memorydata.database.legacy.entity.EpisodicMemoryEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.manager.MemoryDbEngine$migration_33_34$1$migrate$1", f = "MemoryDbEngine.kt", i = {}, l = {694}, m = "invokeSuspend", n = {}, s = {})
final class MemoryDbEngine$migration_33_34$1$migrate$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    MemoryDbEngine$migration_33_34$1$migrate$1(Continuation<? super MemoryDbEngine$migration_33_34$1$migrate$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryDbEngine$migration_33_34$1$migrate$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryDbEngine$migration_33_34$1$migrate$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryDbEngine$migration_33_34$1$migrate$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getEpisodicMemoryDao$database_obricRelease().queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        EpisodicMemoryEntityOld r16 = (EpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r14.next(), EpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin");
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().insert(new ew(0, System.currentTimeMillis(), 1, r16.getEntityId(), 0, 17, null));
        goto L13
    L15:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().getProactivePortraitMemory(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r17.hasNext() == false) goto L20;
        RawMemoryEntity r18 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r17.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().insert(new ew(0, System.currentTimeMillis(), 2, r18.getEntityId(), 0, 17, null));
        goto L17
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(60000, r19) != r0) goto L11;
        return r0;
    }
}
