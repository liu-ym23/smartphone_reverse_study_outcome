package com.obric.audio.continuous_talk;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricBackTraceLogServiceImpl$TracerImpl$scheduleDelayedReport$1", f = "ObricBackTraceLogServiceImpl.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
final class ObricBackTraceLogServiceImpl$TracerImpl$scheduleDelayedReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricBackTraceLogServiceImpl.b this$0;

    public ObricBackTraceLogServiceImpl$TracerImpl$scheduleDelayedReport$1(ObricBackTraceLogServiceImpl.b r1, Continuation<? super ObricBackTraceLogServiceImpl$TracerImpl$scheduleDelayedReport$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricBackTraceLogServiceImpl$TracerImpl$scheduleDelayedReport$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        ObricBackTraceLogServiceImpl.b r16 = this.this$0;
        long r2 = r16.a;
        long r3 = r16.b;
        long r5 = r16.c;
        long r7 = r16.d;
        long r9 = r16.e;
        JSONObject r11 = new JSONObject();
        r11.put("scene", r16.i);
        r11.put("record_start_time", r2);
        r11.put("aec_first_frame_duration", r3 - r2);
        r11.put("record_total_duration", r5 - r2);
        if (r7 > 0) goto L14;
    L16:
        r11.put("asr_first_frame", -1);
    L18:
        if (r9 > 0) goto L20;
    L22:
        r11.put("aec_init", -1);
    L23:
        r11.put("history_length_ms", r16.f);
        r11.put("expected_history_bytes", r16.g);
        r11.put("accumulated_read_bytes", r16.h);
        ObricBackTraceLogServiceImpl.b r17 = this.this$0;
        if (r17.j.compareAndSet(false, true) == true) goto L32;
    L30:
        this.this$0.j();
        return Unit.INSTANCE;
    L32:
        by7.a r4 = new by7.a("backtrace_trace_duration");     // Catch: Throwable -> L28
        r4.a.merge(new TrackParams().merge(r11));     // Catch: Throwable -> L28
        r4.b();     // Catch: Throwable -> L28
        FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] report scene=" + r17.i + ", category=" + r11);     // Catch: Throwable -> L28
        com.larus.platform.service.g.a.monitorEventForSlardar("backtrace_trace_duration", r11, null, null);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        FLogger.a.e("IObricBackTraceLogService", "[backtrace_trace] report failed: " + th.getMessage(), th);
        goto L30
    L20:
        if (r2 <= 0) goto L22;
        r11.put("aec_init", r9 - r2);
        goto L23
    L14:
        if (r2 <= 0) goto L16;
        r11.put("asr_first_frame", r7 - r2);
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        this.label = 1;
        if (DelayKt.delay(4000, this) != r0) goto L11;
        return r0;
    }
}
