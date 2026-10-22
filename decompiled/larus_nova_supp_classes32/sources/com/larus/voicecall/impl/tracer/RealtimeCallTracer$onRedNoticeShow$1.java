package com.larus.voicecall.impl.tracer;

import com.larus.audio.call.RealtimeCallParam;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$onRedNoticeShow$1", f = "RealtimeCallTracer.kt", i = {}, l = {385}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallTracer$onRedNoticeShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $errCode;
    final /* synthetic */ String $errMsg;
    final /* synthetic */ int $subErrorCode;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$onRedNoticeShow$1(RealtimeCallTracer r1, int r2, String r3, int r4, Continuation<? super RealtimeCallTracer$onRedNoticeShow$1> r5) {
        this.this$0 = r1;
        this.$errCode = r2;
        this.$errMsg = r3;
        this.$subErrorCode = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RealtimeCallTracer$onRedNoticeShow$1(this.this$0, this.$errCode, this.$errMsg, this.$subErrorCode, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
    L11:
        RealtimeCallTracer r1 = this.this$0;
        if (r1.p0.contains(r1.f0) == true) goto L14;
        RealtimeCallTracer r3 = this.this$0;
        r3.p0.add(r3.f0);
        RealtimeCallTracer r4 = this.this$0;
        int r5 = this.$errCode;
        String r6 = this.$errMsg;
        Integer r7 = Boxing.boxInt(this.$subErrorCode);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        JSONObject r8 = new JSONObject();
        r4.v0(r8);
        r8.put("enter_method", r4.y0());
        r8.put("bot_id", ((RealtimeCallParam) r4.b.invoke()).o.h);
        r8.put("task_id", r4.f0);
        r8.put("call_id", ((RealtimeCallParam) r4.b.invoke()).e);
        r8.put("room_id", ((RealtimeCallParam) r4.b.invoke()).d);
        r8.put("conversation_id", ((RealtimeCallParam) r4.b.invoke()).o.c);
        r8.put("speaker_id", ((RealtimeCallParam) r4.b.invoke()).o.d);
        r8.put("speak_name", ((RealtimeCallParam) r4.b.invoke()).o.g);
        if (r4.K <= 0) goto L18;
        int r9 = 1;
    L19:
        r8.put("is_bot_hello_triggered", r9);
        r8.put("error_code", r4.P);
        String r10 = r4.Q;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r8, "jsonObject");
        if (r10 != null) goto L90;
        String r16 = r6;
        Integer r17 = r7;
    L26:
        boolean r11 = false;
    L54:
        String r12 = "other";
        if (r11 == false) goto L67;
        int r13 = r4.P;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r13 != (-3)) goto L59;
        r12 = "ERROR_SAMI_SESSION_ERROR";
    L66:
        r8.put("error_msg", r12);
    L68:
        r8.put("is_v3", r4.W);
        if (r4.n <= 0) goto L71;
        boolean r14 = true;
    L72:
        r8.put("is_session_started", r14);
        RealtimeCallTracer.C0((RealtimeCallParam) r4.b.invoke(), r8);
        r4.w0(r8);
        String r15 = "0";
        if (((RealtimeCallParam) r4.b.invoke()).p.q == false) goto L75;
    L78:
        Object r18 = "1";
    L79:
        r8.put("is_continuous_speak", r18);
        if (((RealtimeCallParam) r4.b.invoke()).b == false) goto L82;
        r15 = "1";
    L82:
        r8.put("is_obric_continuous_talk", r15);
        r8.put("detail_error_message", r4.Q);
        r8.put("vui_error_code", r5);
        r8.put("vui_error_msg", r16);
        r8.put("rtc_sub_error_code", r17);
        com.larus.platform.service.o.a.reportEvent("realtime_red_notice_show", r8);
        com.larus.platform.service.g.a.monitorEventForSlardar("realtime_red_notice_show", r8, null, null);
        return Unit.INSTANCE;
    L75:
        if (((RealtimeCallParam) r4.b.invoke()).a == true) goto L78;
        r18 = "0";
        goto L79
    L71:
        r14 = false;
        goto L72
    L59:
        if (r13 != (-2)) goto L61;
        r12 = "ERROR_RECORD_START_FAILED";
        goto L66
    L61:
        if (r13 != (-1)) goto L66;
        r12 = "ERROR_NETWORK_FAILED";
        goto L66
    L67:
        r8.put("error_msg", "other");
        r8.put("sub_err_msg", r4.Q);
        goto L68
    L90:
        String r20 = StringsKt.removePrefix(StringsKt.removePrefix(r10, "error: sami WebSocketStateChanged:"), "error: ");     // Catch: Throwable -> L50
        r16 = r6;
        r17 = r7;
    L48:
        th = th;
    L52:
        r11 = false;
    L53:
        FLogger r21 = FLogger.a;
        r21.e("RealtimeCallTracer", "parseErrorMsg err. msg=" + th.getMessage(), th);
        r21.e("RealtimeCallTracer", "parseErrorMsg err. server_info=".concat(r10));
        goto L54
    L25:
        if (StringsKt.startsWith$default(r8.toString(), "{", false, 2, null) == false) goto L26;
        JSONObject r22 = new JSONObject(r20);     // Catch: Throwable -> L48
        if (r22.has("statusCode") == false) goto L31;
        r8.put("sub_err_code", r22.get("statusCode"));     // Catch: Throwable -> L48
    L31:
        if (r22.has("statusText") == true) goto L84;
        r11 = false;
    L86:
    L46:
        th = th;
        goto L53
    L39:
        if (r22.has(LynxResourceModule.CODE_KEY) == false) goto L41;
        r8.put("sub_err_code", r22.get(LynxResourceModule.CODE_KEY));     // Catch: Throwable -> L46
    L41:
        if (r22.has("message") == false) goto L54;
        r8.put("sub_err_msg", r22.get("message"));     // Catch: Throwable -> L35
        r11 = true;
    L35:
        th = th;
        r11 = true;
        goto L53
    L84:
        r8.put("sub_err_msg", r22.get("statusText"));     // Catch: Throwable -> L35
        r11 = true;
    L50:
        th = th;
        r16 = r6;
        r17 = r7;
        goto L52
    L18:
        r9 = 0;
        goto L19
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        this.label = 1;
        if (DelayKt.delay(300, this) != r0) goto L11;
        return r0;
    }
}
