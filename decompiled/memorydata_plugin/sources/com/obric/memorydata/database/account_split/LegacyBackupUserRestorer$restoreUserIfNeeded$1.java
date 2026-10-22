package com.obric.memorydata.database.account_split;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.account_split.LegacyBackupUserRestorer$restoreUserIfNeeded$1", f = "LegacyBackupUserRestorer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LegacyBackupUserRestorer$restoreUserIfNeeded$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onFinished;
    final /* synthetic */ String $userId;
    int label;

    LegacyBackupUserRestorer$restoreUserIfNeeded$1(String r3, Function1<? super Boolean, Unit> r4, Continuation<? super LegacyBackupUserRestorer$restoreUserIfNeeded$1> r5) {
        Function1<Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$userId = r3;
        this.$onFinished = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new LegacyBackupUserRestorer$restoreUserIfNeeded$1(this.$userId, this.$onFinished, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((LegacyBackupUserRestorer$restoreUserIfNeeded$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), LegacyBackupUserRestorer$restoreUserIfNeeded$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r8);
        boolean r9 = false;
        r9 = LegacyBackupUserRestorer.a(LegacyBackupUserRestorer.f8803a, this.$userId);     // Catch: Throwable -> L9 Exception -> L11 CancellationException -> L18
        Function1<Boolean, Unit> r7 = this.$onFinished;
        if (r7 == null) goto L17;
    L8:
        r7.invoke(Boxing.boxBoolean(r9));
    L17:
        return Unit.INSTANCE;
    L9:
        th = move-exception;
        Function1<Boolean, Unit> r10 = this.$onFinished;
        if (r10 == null) goto L23;
        r10.invoke(Boxing.boxBoolean(false));
    L23:
        throw th;
    L18:
        e = move-exception;
        throw e;     // Catch: Throwable -> L9
    L11:
        e = move-exception;
        RunLog.INSTANCE.error("db_iso_LegacyBackupUserRestorer", "restore failed, userId=" + com.obric.memorydata.utils.q.f13259a.b(this.$userId), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
        Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a(null, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(e), Function0.class, "com.obric.memorydata.plugin"), 1, null), Unit.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        r7 = this.$onFinished;
        if (r7 == null) goto L17;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
