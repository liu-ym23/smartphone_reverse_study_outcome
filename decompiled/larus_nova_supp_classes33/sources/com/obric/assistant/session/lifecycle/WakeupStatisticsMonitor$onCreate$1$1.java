package com.obric.assistant.session.lifecycle;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.utils.s;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.lifecycle.WakeupStatisticsMonitor$onCreate$1$1", f = "BaseSessionLifecycleImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupStatisticsMonitor$onCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ JSONObject $payload;
    int label;

    public WakeupStatisticsMonitor$onCreate$1$1(String r1, JSONObject r2, Continuation<? super WakeupStatisticsMonitor$onCreate$1$1> r3) {
        this.$key = r1;
        this.$payload = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WakeupStatisticsMonitor$onCreate$1$1(this.$key, this.$payload, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r9);
        WakeupStatisticsMonitor r10 = WakeupStatisticsMonitor.b;
        String r0 = this.$key;
        JSONObject r7 = this.$payload;
        r10.getClass();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        Lazy r12 = s.a;     // Catch: Throwable -> L7
        Object r13 = Result.constructor-impl(s.d(r0, r7.optLong("wakeup_stage1_duration"), r7.optLong("wakeup_stage2_duration"), r7.optLong("wakeup_stage3_duration"), r7));     // Catch: Throwable -> L7
    L9:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L13;
        FLogger.a.w(WakeupStatisticsMonitor.b.c(), "reportWakeupDurationPb failed", r14);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
