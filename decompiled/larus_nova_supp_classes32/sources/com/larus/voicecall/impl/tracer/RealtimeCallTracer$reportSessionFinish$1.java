package com.larus.voicecall.impl.tracer;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$reportSessionFinish$1", f = "RealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallTracer$reportSessionFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $connectTime;
    final /* synthetic */ int $helloArrived;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ long $totalSessionTime;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$reportSessionFinish$1(RealtimeCallTracer r1, RealtimeCallParam r2, long r3, long r5, int r7, Continuation<? super RealtimeCallTracer$reportSessionFinish$1> r8) {
        this.this$0 = r1;
        this.$params = r2;
        this.$connectTime = r3;
        this.$totalSessionTime = r5;
        this.$helloArrived = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new RealtimeCallTracer$reportSessionFinish$1(this.this$0, this.$params, this.$connectTime, this.$totalSessionTime, this.$helloArrived, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L48;
        ResultKt.throwOnFailure(r19);
        RealtimeCallTracer r0 = this.this$0;
        RealtimeCallParam r2 = this.$params;
        long r3 = this.$connectTime;
        long r5 = this.$totalSessionTime;
        int r7 = this.$helloArrived;
        Long r8 = Boxing.boxLong(r0.o);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        String r10 = r2.o.h;
        String r11 = r2.e;
        RealtimeCallParam.d r12 = r2.l;
        String r13 = r12.c;
        long r14 = r0.k;
        String r15 = r12.a;
        boolean r1 = r2.p.t;
        JSONObject r9 = new JSONObject();
        r0.v0(r9);
        RealtimeCallTracer.C0((RealtimeCallParam) r0.b.invoke(), r9);
        r0.w0(r9);
        r9.put("enter_method", r2.p.i);
        r9.put("enter_from", r2.p.c);
        r9.put("page_created_duration_timeline_ms", HttpExtKt.p(r0.N));
        if (r0.O == false) goto L7;
        String r4 = "direct";
    L8:
        r9.put("connect_type", r4);
        r9.put("is_bot_hello_enable", r7);
        String r16 = "0";
        if (r2.p.q == false) goto L11;
    L14:
        Object r6 = "1";
    L15:
        r9.put("is_continuous_speak", r6);
        if (r2.b == false) goto L18;
        r16 = "1";
    L18:
        r9.put("is_obric_continuous_talk", r16);
        Long r17 = Long.valueOf(r3);
        Long r18 = Long.valueOf(r14);
        Long r20 = 0L;
        Long r21 = 0L;
        Long r22 = Long.valueOf(r5);
        Integer r23 = Integer.valueOf(r1 ? 1 : 0);
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        if (r10 != null) goto L49;
    L23:
        if (r11 == null) goto L25;
        r9.put("call_id", r11);     // Catch: JSONException -> L21
    L25:
        if (r17 == null) goto L27;
        r9.put("connect", r17.longValue());     // Catch: JSONException -> L21
    L27:
        if (r13 == null) goto L29;
        r9.put("conversation_id", r13);     // Catch: JSONException -> L21
    L29:
        if (r18 == null) goto L31;
        r9.put("create_call", r18.longValue());     // Catch: JSONException -> L21
    L31:
        if (r20 == null) goto L33;
        r9.put("download_model", r20.longValue());     // Catch: JSONException -> L21
    L33:
        if (r21 == null) goto L35;
        r9.put("init_model", r21.longValue());     // Catch: JSONException -> L21
    L35:
        if (r15 == null) goto L37;
        r9.put("task_id", r15);     // Catch: JSONException -> L21
    L37:
        if (r22 == null) goto L39;
        r9.put("total", r22.longValue());     // Catch: JSONException -> L21
    L39:
        if (r23 == null) goto L41;
        r9.put("vlm_open", r23.intValue());     // Catch: JSONException -> L21
    L41:
        if (r8 == null) goto L45;
        r9.put("pseudo_duration", r8.longValue());     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallStartTime " + e.getLocalizedMessage());
    L45:
        TrackParams r24 = new TrackParams().merge(r9);
        by7.a r25 = new by7.a("realtime_call_start_time");
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracerReporterKt$mobCallStartTimeEvent$2$1(r9, null), 2, null);
        Unit r26 = Unit.INSTANCE;
        r25.a.merge(r24);
        r25.b();
        return Unit.INSTANCE;
    L49:
        r9.put("bot_id", r10);     // Catch: JSONException -> L21
        goto L23
    L11:
        if (r2.a == true) goto L14;
        r6 = "0";
        goto L15
    L7:
        r4 = "after_get_permission";
        goto L8
    L48:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
