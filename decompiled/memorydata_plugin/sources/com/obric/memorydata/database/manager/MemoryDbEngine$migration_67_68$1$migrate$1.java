package com.obric.memorydata.database.manager;

import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.dao.MemoryEntityRawDbDao;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.cq;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.fb;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.legacy.dao.an;
import com.obric.memorydata.database.legacy.dao.ap;
import com.obric.memorydata.database.legacy.dao.aq;
import com.obric.memorydata.database.legacy.entity.aa;
import com.obric.memorydata.database.legacy.entity.ac;
import com.obric.memorydata.database.legacy.entity.x;
import com.obric.memorydata.middleware.api.bridge.VectorDbBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.manager.MemoryDbEngine$migration_67_68$1$migrate$1", f = "MemoryDbEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryDbEngine$migration_67_68$1$migrate$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    MemoryDbEngine$migration_67_68$1$migrate$1(Continuation<? super MemoryDbEngine$migration_67_68$1$migrate$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryDbEngine$migration_67_68$1$migrate$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryDbEngine$migration_67_68$1$migrate$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryDbEngine$migration_67_68$1$migrate$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r45) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r45);
        MemoryEntityRawDbDao r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao();
        ap r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getSemanticMemoryDao$database_obricRelease();
        aq r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getSemanticTextCopilotDao$database_obricRelease();
        an r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveSemanticRelevantDataDao$database_obricRelease();
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.getMemoryByType(EntityType.MEMORY_INFO_COMMON), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r4.hasNext() == false) goto L20;
        RawMemoryEntity r5 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r4.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        ip r6 = iq.a(r5, 0, 1, null);
        if (r6 == null) goto L18;
        ac r15 = new ac(r6.getId(), r6.getEntityId(), r6.getCreateTime(), r6.getModifyTime(), r6.getType(), r6.getTimestamp(), r6.getPackageName(), r6.getHashCodeValue(), r6.getUuid(), r6.a(), r6.b(), r6.c(), r6.d(), r6.e(), r6.f(), r6.g(), r6.h(), r6.i(), r6.j(), r6.k(), r6.l(), r6.m(), null, null, null, null, false, 130023424, null);
        String r7 = r15.c();
        String r16 = r15.e();
        r15.a("");
        r15.b("");
        long r10 = r1.insert(r15);
        cq r17 = (cq) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryEntityTextVectorCopilotDao().queryByRawDbId(r5.getId())), cq.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L13;
        long r8 = r2.insert(new aa(0, r10, "embeddingContent", r16, false, 17, null));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDbEngine", "id " + r8 + " vectorResult " + VectorDbBridgeAPI.INSTANCE.insertVector("SemanticTextCopilot", r8, VectorDbBridgeAPI.INSTANCE.searchAndDecrypt("MemoryEntityTextVectorCopilot", String.valueOf(r17.a()))), false, 4, null);
    L14:
        r15.a(r7);
        r15.b(r16);
        fa r9 = fb.a(r5);
        if (r9 == null) goto L18;
        r3.insert(new x(r9.a(), r9.b(), r9.c(), r9.d(), r9.e(), r9.f(), r9.g(), r9.h(), r9.i(), false, 512, null));
        goto L18
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDbEngine", "migration_67_68 skip vector migrate, rawMemoryId=" + r5.getId(), null, 4, null);
    L18:
        r4 = r4;
        goto L6
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
