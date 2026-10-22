package com.obric.assistant.wakeup.statistics.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.assistant.wakeup.statistics.impl.WakeupLatencyTrackImpl$reportAttemptDropped$1", f = "WakeupLatencyTrackImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WakeupLatencyTrackImpl$reportAttemptDropped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $prevScene;
    final /* synthetic */ String $prevSession;
    final /* synthetic */ String $stage;
    private /* synthetic */ Object L$0;
    int label;

    public WakeupLatencyTrackImpl$reportAttemptDropped$1(String r1, String r2, String r3, Continuation<? super WakeupLatencyTrackImpl$reportAttemptDropped$1> r4) {
        this.$prevScene = r1;
        this.$prevSession = r2;
        this.$stage = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        WakeupLatencyTrackImpl$reportAttemptDropped$1 r0 = new WakeupLatencyTrackImpl$reportAttemptDropped$1(this.$prevScene, this.$prevSession, this.$stage, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        String r11 = this.$prevScene;
        String r2 = this.$prevSession;
        String r3 = this.$stage;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L7
        r5.put("scene", r11);     // Catch: Throwable -> L7
        r5.put("session_type", r2);     // Catch: Throwable -> L7
        r5.put("drop_stage", r3);     // Catch: Throwable -> L7
        FLogger.a.i("WakeupLatencyTrackImpl", "reportAttemptDropped scene=" + r11 + ", session=" + r2 + ", stage=" + r3);     // Catch: Throwable -> L7
        by7.a r12 = new by7.a("wakeup_attempt_dropped");     // Catch: Throwable -> L7
        r12.a.merge(new TrackParams().merge(r5));     // Catch: Throwable -> L7
        r12.b();     // Catch: Throwable -> L7
        g.a.monitorEventForSlardar("wakeup_attempt_dropped", r5, null, null);     // Catch: Throwable -> L7
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
