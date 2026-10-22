package com.obric.memorydata.memory.migration;

import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.SemanticMigrationPhase;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.migration.SemanticMigrationManager$dispatchByPhase$1", f = "SemanticMigrationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SemanticMigrationManager$dispatchByPhase$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    SemanticMigrationManager$dispatchByPhase$1(Continuation<? super SemanticMigrationManager$dispatchByPhase$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new SemanticMigrationManager$dispatchByPhase$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((SemanticMigrationManager$dispatchByPhase$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), SemanticMigrationManager$dispatchByPhase$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r7);
        SemanticMigrationPhase r6 = SemanticMigrationPhase.Companion.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticStateDao().queryText("migration_phase"));     // Catch: Exception -> L13 CancellationException -> L17
        if (r6 != SemanticMigrationPhase.UPGRADE) goto L8;
    L11:
        a.a(a.f10330a);     // Catch: Exception -> L13 CancellationException -> L17
    L16:
        return Unit.INSTANCE;
    L8:
        if (r6 == SemanticMigrationPhase.REBUILD) goto L11;
        return Unit.INSTANCE;
    L17:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SemanticMigrationManager", "dispatch failed error_class=" + e.getClass().getSimpleName(), null, 4, null);
        goto L16
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
