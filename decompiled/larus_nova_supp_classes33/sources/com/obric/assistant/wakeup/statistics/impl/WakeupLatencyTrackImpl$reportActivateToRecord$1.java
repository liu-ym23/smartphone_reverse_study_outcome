package com.obric.assistant.wakeup.statistics.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
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
@DebugMetadata(c = "com.obric.assistant.wakeup.statistics.impl.WakeupLatencyTrackImpl$reportActivateToRecord$1", f = "WakeupLatencyTrackImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WakeupLatencyTrackImpl$reportActivateToRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $durationMs;
    final /* synthetic */ WakeupLatencyTrackImpl.a $trace;
    final /* synthetic */ long $userUnlockElapsedMs;
    private /* synthetic */ Object L$0;
    int label;

    public WakeupLatencyTrackImpl$reportActivateToRecord$1(long r1, WakeupLatencyTrackImpl.a r3, long r4, Continuation<? super WakeupLatencyTrackImpl$reportActivateToRecord$1> r6) {
        this.$durationMs = r1;
        this.$trace = r3;
        this.$userUnlockElapsedMs = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        WakeupLatencyTrackImpl$reportActivateToRecord$1 r7 = new WakeupLatencyTrackImpl$reportActivateToRecord$1(this.$durationMs, this.$trace, this.$userUnlockElapsedMs, r10);
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
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        long r1 = this.$durationMs;
        WakeupLatencyTrackImpl.a r10 = this.$trace;
        long r3 = this.$userUnlockElapsedMs;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L7
        r6.put("duration_ms", r1);     // Catch: Throwable -> L7
        r6.put("obric_launch_method", r10.b);     // Catch: Throwable -> L7
        r6.put("main_process_ready", r10.c);     // Catch: Throwable -> L7
        r6.put("user_unlock_elapsed_ms", r3);     // Catch: Throwable -> L7
        by7.a r11 = new by7.a("activate_to_record");     // Catch: Throwable -> L7
        TrackParams r2 = new TrackParams().merge(r6);     // Catch: Throwable -> L7
        r11.a.merge(r2);     // Catch: Throwable -> L7
        r11.b();     // Catch: Throwable -> L7
        g.a.monitorEventForSlardar("activate_to_record", r6, null, null);     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
