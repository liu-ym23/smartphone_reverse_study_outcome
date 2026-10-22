package com.obric.assistant.session.endpoint;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
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
@DebugMetadata(c = "com.obric.assistant.session.endpoint.LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1", f = "LaunchMethodReporterEndpoint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $duration;
    final /* synthetic */ JSONObject $payload;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LaunchMethodReporterEndpoint this$0;

    public LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1(JSONObject r1, int r2, LaunchMethodReporterEndpoint r3, Continuation<? super LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1> r4) {
        this.$payload = r1;
        this.$duration = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1 r0 = new LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1(this.$payload, this.$duration, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        JSONObject r8 = this.$payload;
        int r1 = this.$duration;
        LaunchMethodReporterEndpoint r2 = this.this$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r8.put("duration", r1);     // Catch: Throwable -> L7
        r2.getClass();     // Catch: Throwable -> L7
        r8.put("wakeup_from", bga.j.a());     // Catch: Throwable -> L7
        r8.put(WindowEvent.Params.LAUNCH_METHOD, r2.a.get());     // Catch: Throwable -> L7
        TrackParams r4 = new TrackParams().merge(r8);     // Catch: Throwable -> L7
        by7.a r5 = new by7.a("ai_key_press_duration");     // Catch: Throwable -> L7
        r5.a.merge(r4);     // Catch: Throwable -> L7
        r5.b();     // Catch: Throwable -> L7
        FLogger.a.i("AiIsland-SessionUtils", "reportAiKeyPressDuration duration " + r1 + ", payload " + r8);     // Catch: Throwable -> L7
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
