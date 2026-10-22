package com.larus.voicecall.impl.tracer;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$reportSessionFinishV2$1", f = "RealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallTracer$reportSessionFinishV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $connectTime;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ long $totalSessionTime;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$reportSessionFinishV2$1(RealtimeCallTracer r1, RealtimeCallParam r2, int r3, String r4, long r5, long r7, Continuation<? super RealtimeCallTracer$reportSessionFinishV2$1> r9) {
        this.this$0 = r1;
        this.$params = r2;
        this.$errorCode = r3;
        this.$errorMsg = r4;
        this.$totalSessionTime = r5;
        this.$connectTime = r7;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new RealtimeCallTracer$reportSessionFinishV2$1(this.this$0, this.$params, this.$errorCode, this.$errorMsg, this.$totalSessionTime, this.$connectTime, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r18);
        RealtimeCallTracer r0 = this.this$0;
        RealtimeCallParam r2 = this.$params;
        int r3 = this.$errorCode;
        String r4 = this.$errorMsg;
        long r5 = this.$totalSessionTime;
        long r7 = this.$connectTime;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        String r11 = r2.o.h;
        String r12 = r2.e;
        RealtimeCallParam.d r13 = r2.l;
        String r14 = r13.c;
        long r15 = r0.k;
        String r16 = r13.a;
        String r6 = r2.k.t;
        RealtimeCallParam r1 = (RealtimeCallParam) r0.b.invoke();
        JSONObject r8 = new JSONObject();
        r0.v0(r8);
        RealtimeCallTracer.C0(r1, r8);
        Long r9 = Long.valueOf(r7);
        Long r10 = Long.valueOf(r15);
        Long r17 = 0L;
        Long r19 = 0L;
        Long r20 = Long.valueOf(r5);
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (r11 != null) goto L37;
    L9:
        if (r12 == null) goto L11;
        r8.put("call_id", r12);     // Catch: JSONException -> L7
    L11:
        if (r9 == null) goto L13;
        r8.put("connect", r9.longValue());     // Catch: JSONException -> L7
    L13:
        if (r14 == null) goto L15;
        r8.put("conversation_id", r14);     // Catch: JSONException -> L7
    L15:
        if (r10 == null) goto L17;
        r8.put("create_call", r10.longValue());     // Catch: JSONException -> L7
    L17:
        if (r17 == null) goto L19;
        r8.put("download_model", r17.longValue());     // Catch: JSONException -> L7
    L19:
        if (r19 == null) goto L21;
        r8.put("init_model", r19.longValue());     // Catch: JSONException -> L7
    L21:
        if (r16 == null) goto L23;
        r8.put("task_id", r16);     // Catch: JSONException -> L7
    L23:
        if (r20 == null) goto L26;
        r8.put("total", r20.longValue());     // Catch: JSONException -> L7
    L26:
        if (r3 == 0) goto L28;
        r8.put("status", 1);     // Catch: JSONException -> L7
    L30:
        r8.put("error_code", r3);     // Catch: JSONException -> L7
        r8.put("error_msg", r4);     // Catch: JSONException -> L7
        r8.put("scene", r6);     // Catch: JSONException -> L7
    L33:
        TrackParams r21 = new TrackParams().merge(r8);
        by7.a r22 = new by7.a("flow_vui_conversation_end");
        r22.a.merge(r21);
        r22.b();
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallStartTime " + e.getLocalizedMessage());
        goto L33
    L28:
        r8.put("status", 0);     // Catch: JSONException -> L7
        goto L30
    L37:
        r8.put("bot_id", r11);     // Catch: JSONException -> L7
        goto L9
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
