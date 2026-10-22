package com.volcengine.zeus.plugin.preinstall;

import com.volcengine.zeus.log.ZeusLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.volcengine.zeus.plugin.preinstall.PreInstallTask$Companion$scheduledExpiredDataCleanup$1", f = "PreInstallTask.kt", i = {0, 1, 3}, l = {267, 278, 97, 289}, m = "invokeSuspend", n = {"$this$withLock$iv", "$this$withLock$iv", "$this$withLock$iv"}, s = {"L$0", "L$0", "L$0"})
public final class PreInstallTask$Companion$scheduledExpiredDataCleanup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public PreInstallTask$Companion$scheduledExpiredDataCleanup$1(Continuation r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "completion");
        return new PreInstallTask$Companion$scheduledExpiredDataCleanup$1(r2);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        a r2 = (a) this.L$0;
        ResultKt.throwOnFailure(r14);
    L55:
        ZeusLogger.i("ZeusPreInstallTask", "scheduledExpiredDataCleanup: cleanup data got lock");     // Catch: Throwable -> L50
        PreInstallTask.i.getClass();     // Catch: Throwable -> L50
        PreInstallTask.Companion.a();     // Catch: Throwable -> L50
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L50
        r2.unlock(null);
        return Unit.INSTANCE;
    L50:
        th = move-exception;
        r2.unlock(null);
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r14);
    L43:
        ZeusLogger.i("ZeusPreInstallTask", "scheduledExpiredDataCleanup: cleanup data try get lock");
        PreInstallTask.i.getClass();
        a r16 = PreInstallTask.e;
        this.L$0 = r16;
        this.label = 4;
        if (r16.a(null, this) != r0) goto L46;
        return r0;
    L46:
        r2 = r16;
        goto L55
    L12:
        a r3 = (a) this.L$0;
        ResultKt.throwOnFailure(r14);
    L57:
        ZeusLogger.i("ZeusPreInstallTask", "clean pre install data when version code larger than host version");     // Catch: Throwable -> L35
        PreInstallTask.i.getClass();     // Catch: Throwable -> L35
        PreInstallTask.Companion.a();     // Catch: Throwable -> L35
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r3.unlock(null);
        return Unit.INSTANCE;
    L35:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L13:
        a r4 = (a) this.L$0;
        ResultKt.throwOnFailure(r14);
    L53:
        ZeusLogger.i("ZeusPreInstallTask", "clean pre install data to resume no cache issue");     // Catch: Throwable -> L23
        PreInstallTask.i.getClass();     // Catch: Throwable -> L23
        PreInstallTask.Companion.a();     // Catch: Throwable -> L23
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r4.unlock(null);
        return Unit.INSTANCE;
    L23:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L14:
        ResultKt.throwOnFailure(r14);
        long r8 = ZeusPreInstallSpUtil.a().getLong("pre_install_time", -1);
        int r19 = ZeusPreInstallSpUtil.a().getInt("host_version", -1);
        StringBuilder r5 = new StringBuilder("scheduledExpiredDataCleanup: preInstallTime = ");
        r5.append(r8);
        r5.append(", hostVersion = ");
        r5.append(r19);
        r5.append(", curVersionCode = ");
        PreInstallTask.i.getClass();
        Lazy r10 = PreInstallTask.h;
        r5.append(((Number) r10.getValue()).intValue());
        ZeusLogger.i("ZeusPreInstallTask", r5.toString());
        if (r8 > 0) goto L27;
        a r110 = PreInstallTask.e;
        this.L$0 = r110;
        this.label = 1;
        if (r110.a(null, this) != r0) goto L19;
        return r0;
    L19:
        r4 = r110;
        goto L53
    L27:
        if (((Number) r10.getValue()).intValue() <= r19) goto L38;
        a r111 = PreInstallTask.e;
        this.L$0 = r111;
        this.label = 2;
        if (r111.a(null, this) != r0) goto L31;
        return r0;
    L31:
        r3 = r111;
        goto L57
    L38:
        long r9 = (r8 + ((long) 172800000)) - System.currentTimeMillis();
        ZeusLogger.i("ZeusPreInstallTask", "scheduledExpiredDataCleanup: leftTimeMS = " + r9 + " ms");
        if (r9 <= 0) goto L43;
        this.label = 3;
        if (DelayKt.delay(r9, this) != r0) goto L43;
        return r0;
    }
}
