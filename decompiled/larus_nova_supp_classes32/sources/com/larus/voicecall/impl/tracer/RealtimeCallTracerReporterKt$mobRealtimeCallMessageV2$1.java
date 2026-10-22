package com.larus.voicecall.impl.tracer;

import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracerReporterKt$mobRealtimeCallMessageV2$1", f = "RealtimeCallTracerReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallTracerReporterKt$mobRealtimeCallMessageV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $params;
    int label;

    public RealtimeCallTracerReporterKt$mobRealtimeCallMessageV2$1(JSONObject r1, Continuation<? super RealtimeCallTracerReporterKt$mobRealtimeCallMessageV2$1> r2) {
        this.$params = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallTracerReporterKt$mobRealtimeCallMessageV2$1(this.$params, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        JSONObject r4 = this.$params;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        f2a.c r1 = com.larus.voicecall.impl.utils.d.a.b("track event: realtime_call_message_v2");     // Catch: Throwable -> L7
        r1.d(f2a.e.a(r4));     // Catch: Throwable -> L7
        r1.c.f = "auto_test";     // Catch: Throwable -> L7
        f2a.c.c(r1, null, 15);     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
