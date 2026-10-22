package com.larus.dora.impl.imu;

import com.larus.dora.api.awareness.IAwarenessEventReporter;
import g49.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.imu.DoraImuDataManager$reportAwarenessEvent$1", f = "DoraImuDataManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraImuDataManager$reportAwarenessEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ IAwarenessEventReporter $reporter;
    final /* synthetic */ long $timestamp;
    final /* synthetic */ int $value;
    private /* synthetic */ Object L$0;
    int label;

    public DoraImuDataManager$reportAwarenessEvent$1(String r1, int r2, long r3, IAwarenessEventReporter r5, Continuation<? super DoraImuDataManager$reportAwarenessEvent$1> r6) {
        this.$key = r1;
        this.$value = r2;
        this.$timestamp = r3;
        this.$reporter = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        DoraImuDataManager$reportAwarenessEvent$1 r7 = new DoraImuDataManager$reportAwarenessEvent$1(this.$key, this.$value, this.$timestamp, this.$reporter, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        String r10 = this.$key;
        int r2 = this.$value;
        long r3 = this.$timestamp;
        IAwarenessEventReporter r5 = this.$reporter;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        d.d("DoraImuDataManager", "本地感知事件上报，key=" + r10 + ", value=" + r2 + ", timestamp=" + r3);     // Catch: Throwable -> L7
        r5.a(r10, Boxing.boxInt(r2), r3);     // Catch: Throwable -> L7
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r1 = this.$key;
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L16;
        if ((r12 instanceof CancellationException) == true) goto L14;
        d.c("DoraImuDataManager", "本地感知事件上报失败，key=" + r1, r12);
        goto L16
    L14:
        throw r12;
    L16:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
