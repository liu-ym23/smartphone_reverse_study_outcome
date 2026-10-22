package com.larus.avlink;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.dora.api.IDoraService;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.DoraRealtimeCallTracer$reportDoraRealtimeCallError$1", f = "DoraRealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraRealtimeCallTracer$reportDoraRealtimeCallError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ JSONObject $extraParams;
    final /* synthetic */ long $fromStatus;
    final /* synthetic */ RealtimeCallParam $params;
    int label;
    final /* synthetic */ DoraRealtimeCallTracer this$0;

    public DoraRealtimeCallTracer$reportDoraRealtimeCallError$1(DoraRealtimeCallTracer r1, int r2, String r3, long r4, RealtimeCallParam r6, JSONObject r7, Continuation<? super DoraRealtimeCallTracer$reportDoraRealtimeCallError$1> r8) {
        this.this$0 = r1;
        this.$errorCode = r2;
        this.$errorMsg = r3;
        this.$fromStatus = r4;
        this.$params = r6;
        this.$extraParams = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DoraRealtimeCallTracer$reportDoraRealtimeCallError$1(this.this$0, this.$errorCode, this.$errorMsg, this.$fromStatus, this.$params, this.$extraParams, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r11);
        DoraRealtimeCallTracer r12 = this.this$0;
        int r0 = this.$errorCode;
        String r1 = this.$errorMsg;
        long r2 = this.$fromStatus;
        RealtimeCallParam r4 = this.$params;
        JSONObject r5 = this.$extraParams;
        int r6 = DoraRealtimeCallTracer.u;
        r12.getClass();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<String> r8 = r5.keys();
    L6:
        if (r8.hasNext() == false) goto L8;
        String r9 = r8.next();
        r7.put(r9, r5.opt(r9));
        goto L6
    L8:
        r7.put("bot_id", r4.o.h);
        r7.put("call_id", r4.e);
        r7.put("room_id", (String) r12.q.getValue());
        r7.put("conversation_id", r4.l.c);
        r7.put("error_code", Long.valueOf(r0));
        if (r1 == null) goto L11;
        r7.put("error_msg", r1);
    L11:
        r7.put("is_ai_in_motion", 0L);
        r7.put("from_status", Long.valueOf(r2));
        r7.put("scene", r12.z0());
        r7.put("task_id", r4.l.a);
        r7.put("is_mock_chat", 0);
        r7.put("llm_model", r4.l.p);
        r7.put("user_interrupt", Long.valueOf(r4.l.h));
        r7.put("pre_query", Integer.valueOf(r4.l.m ? 1 : 0));
        r7.put("voice_style", r4.o.d);
        r7.put("is_ai_motion_support", 0);
        r7.put("is_avatar_can_drive", 0);
        r7.put("is_algorithm_model_downloaded", 0);
        r7.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(((RealtimeCallParam) r12.a.invoke()).s) ? 1 : 0));
        r7.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(((RealtimeCallParam) r12.a.invoke()).k.o, "dora_si") ? 1 : 0));
        r7.put("av_session_type", Integer.valueOf(((RealtimeCallParam) r12.a.invoke()).s.getType()));
        r7.put("dora_mode", r4.k.t);
        IDoraService r13 = this.this$0.A0();
        if (r13 == null) goto L15;
        r13.A0("flow_dora_call_error", r7);
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
