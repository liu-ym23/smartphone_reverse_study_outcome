package com.obric.memorydata.database.manager;

import com.obric.memorydata.database.entity.gd;
import com.obric.memorydata.database.legacy.entity.LifelogEntityOld;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.ExceptionsKt;
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
@DebugMetadata(c = "com.obric.memorydata.database.manager.MemoryDbEngine$migration_54_55$1$migrate$1", f = "MemoryDbEngine.kt", i = {}, l = {813}, m = "invokeSuspend", n = {}, s = {})
final class MemoryDbEngine$migration_54_55$1$migrate$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    MemoryDbEngine$migration_54_55$1$migrate$1(Continuation<? super MemoryDbEngine$migration_54_55$1$migrate$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit invokeSuspend$lambda$0(Exception r9) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDbEngine", "Error during migration data processing：" + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$5() {
        List<LifelogEntityOld> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLifelogDao$database_obricRelease().queryAll();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDbEngine", "Found " + r0.size() + " lifelog entities to process", false, 4, null);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L3:
        boolean r5 = false;
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(((LifelogEntityOld) ZeusTransformUtils.preCheckCast(r4, LifelogEntityOld.class, "com.obric.memorydata.plugin")).getEntityId(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
    L9:
        r5 = true;
    L10:
        if (r5 == false) goto L3;
        r2.add(r4);
        goto L3
    L8:
        if (r7.length() != 0) goto L10;
    L12:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDbEngine", r6.size() + " entities need field updates", false, 4, null);
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        LifelogEntityOld r9 = (LifelogEntityOld) ZeusTransformUtils.preCheckCast(r8.next(), LifelogEntityOld.class, "com.obric.memorydata.plugin");
        r9.setEntityId(gd.f9146a.a());
        r9.setTimestamp(r9.getLifelog().getTimestamp());
        r9.setCreateTime(r9.getLifelog().getTimestamp());
        r9.setModifyTime(r9.getLifelog().getTimestamp());
        r9.setPackageName(AppContext.INSTANCE.getPackageName());
        r9.setUuid(UUID.randomUUID().toString());
        r9.setFullContent(r9.getLifelog().getFinalContent());
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLifelogDao$database_obricRelease().update(r9);
        RunLog.INSTANCE.debug("MemoryDbEngine", "Updated lifelog entity id=" + r9.getId() + ", entityId=" + r9.getEntityId());
        goto L14
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDbEngine", "Starting to index all " + r0.size() + " entities", false, 4, null);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast((LifelogEntityOld) ZeusTransformUtils.preCheckCast(r10.next(), LifelogEntityOld.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        goto L18
    L20:
        EntityManager.INSTANCE.launchIndexTask();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDbEngine", "Migration 54->55 completed successfully. Updated " + r6.size() + " entities, indexed " + r0.size() + " entities.", false, 4, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$1XMENeUc_yVpV4sx7BoGATEsJKY() {
        return invokeSuspend$lambda$5();
    }

    /* JADX INFO: renamed from: lambda$E6y1BBpD5K6G-2zOzMbQesreQUs, reason: not valid java name */
    public static /* synthetic */ Unit m571lambda$E6y1BBpD5K6G2zOzMbQesreQUs(Exception r0) {
        return invokeSuspend$lambda$0(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryDbEngine$migration_54_55$1$migrate$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryDbEngine$migration_54_55$1$migrate$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryDbEngine$migration_54_55$1$migrate$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        y.a($$Lambda$MemoryDbEngine$migration_54_55$1$migrate$1$E6y1BBpD5K6G2zOzMbQesreQUs.INSTANCE, $$Lambda$MemoryDbEngine$migration_54_55$1$migrate$1$1XMENeUc_yVpV4sx7BoGATEsJKY.INSTANCE);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(60000, r7) != r0) goto L11;
        return r0;
    }
}
