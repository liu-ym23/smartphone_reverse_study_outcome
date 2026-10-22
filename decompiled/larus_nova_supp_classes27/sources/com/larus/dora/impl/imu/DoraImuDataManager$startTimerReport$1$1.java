package com.larus.dora.impl.imu;

import g49.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.imu.DoraImuDataManager$startTimerReport$1$1", f = "DoraImuDataManager.kt", i = {}, l = {613}, m = "invokeSuspend", n = {}, s = {})
final class DoraImuDataManager$startTimerReport$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraImuDataManager$startTimerReport$1$1(Continuation<? super DoraImuDataManager$startTimerReport$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraImuDataManager$startTimerReport$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002b -> B:27:0x002e). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7 CancellationException -> L17
        DoraImuDataManager$startTimerReport$1$1 r9 = this;
    L27:
        d.d("DoraImuDataManager", "Periodic report triggered");     // Catch: CancellationException -> L17 Throwable -> L19
        DoraImuDataManager.a.getClass();     // Catch: CancellationException -> L17 Throwable -> L19
        DoraImuDataManager.e();     // Catch: CancellationException -> L17 Throwable -> L19
    L12:
        r9.label = 1;     // Catch: CancellationException -> L17 Throwable -> L19
        if (DelayKt.delay(300000, r9) != r0) goto L27;
        return r0;
    L19:
        th = move-exception;
        Object r6 = r0;
        DoraImuDataManager$startTimerReport$1$1 r2 = r9;
        Throwable th = th;
        Object r3 = r6;
    L21:
        d.c("DoraImuDataManager", "Timer report coroutine exception", th);
        r9 = r2;
        r0 = r3;
    L7:
        th = th;
        r3 = r0;
        r2 = this;
    L17:
        e = move-exception;
        d.d("DoraImuDataManager", "Timer report coroutine cancelled");
        throw e;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
        r9 = this;
        goto L12
    }
}
