package com.obric.memorydata.database.account_split;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.account_split.PersonalDbSplitMigrator$ensureMigrationJobStarted$3", f = "PersonalDbSplitMigrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalDbSplitMigrator$ensureMigrationJobStarted$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    PersonalDbSplitMigrator$ensureMigrationJobStarted$3(Continuation<? super PersonalDbSplitMigrator$ensureMigrationJobStarted$3> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersonalDbSplitMigrator$ensureMigrationJobStarted$3((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PersonalDbSplitMigrator$ensureMigrationJobStarted$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalDbSplitMigrator$ensureMigrationJobStarted$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        v.f8832a.c();     // Catch: Exception -> L7 CancellationException -> L11
    L10:
        return Unit.INSTANCE;
    L11:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("db_iso_PersonalDbSplitMigrator", "personal sql split migration failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Unit r4 = (Unit) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a(null, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(e), Function0.class, "com.obric.memorydata.plugin"), 1, null), Unit.class, "com.obric.memorydata.plugin");
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
