package com.larus.voicecall.impl.tracer;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.performance.IObricMemoryReportSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracerReporterKt$reportEndCall$3", f = "RealtimeCallTracerReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallTracerReporterKt$reportEndCall$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $backgroundDuration;
    final /* synthetic */ String $bgModeSnapshot;
    final /* synthetic */ String $endMethod;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ IRealtimeCallTracer.EnterCallSessionStatus $sessionStatus;
    final /* synthetic */ RealtimeCallTracer $this_reportEndCall;
    final /* synthetic */ Ref.LongRef $totalSessionTime;
    final /* synthetic */ boolean $useBgModeSnapshot;
    int label;

    public RealtimeCallTracerReporterKt$reportEndCall$3(RealtimeCallTracer r1, RealtimeCallParam r2, Ref.LongRef r3, IRealtimeCallTracer.EnterCallSessionStatus r4, String r5, long r6, boolean r8, String r9, Continuation<? super RealtimeCallTracerReporterKt$reportEndCall$3> r10) {
        this.$this_reportEndCall = r1;
        this.$params = r2;
        this.$totalSessionTime = r3;
        this.$sessionStatus = r4;
        this.$endMethod = r5;
        this.$backgroundDuration = r6;
        this.$useBgModeSnapshot = r8;
        this.$bgModeSnapshot = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new RealtimeCallTracerReporterKt$reportEndCall$3(this.$this_reportEndCall, this.$params, this.$totalSessionTime, this.$sessionStatus, this.$endMethod, this.$backgroundDuration, this.$useBgModeSnapshot, this.$bgModeSnapshot, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r39) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L104;
        ResultKt.throwOnFailure(r39);
        this.$this_reportEndCall.getClass();
        RealtimeCallTracer r0 = this.$this_reportEndCall;
        long r2 = r0.F;
        r0.F = 0;
        r0.A0(IRealtimeCallTracer.TotalTimeType.VIDEO_SHARE_START_TIME);
        RealtimeCallTracer r1 = this.$this_reportEndCall;
        if (r1.h <= 0) goto L7;
        long r6 = r1.g;
        long r8 = SystemClock.elapsedRealtime();
        RealtimeCallTracer r10 = this.$this_reportEndCall;
        r1.g = r6 + (r8 - r10.h);
        r10.h = 0;
    L7:
        RealtimeCallTracer r3 = this.$this_reportEndCall;
        long r7 = r3.C;
        RealtimeCallParam r9 = this.$params;
        RealtimeCallParam.p r11 = r9.o;
        String r12 = r11.h;
        String r13 = r9.e;
        RealtimeCallParam.d r14 = r9.l;
        String r15 = r14.a;
        String r16 = r14.c;
        long r17 = this.$totalSessionTime.element;
        String r4 = r11.f;
        String r5 = r11.d;
        String r18 = r11.g;
        String r19 = r9.w;
        long r20 = r3.x;
        long r21 = r3.z;
        long r22 = r3.B;
        IRealtimeCallTracer.EnterCallSessionStatus r23 = this.$sessionStatus;
        if (r23 == null) goto L10;
        Integer r24 = Boxing.boxInt(r23.getValue());
    L11:
        String r25 = this.$params.p.i;
        long r26 = w.b;
        long r27 = z0.c(w.c);
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r28 = RealtimeCallUtil.l;
        if (r28 == null) goto L16;
        SceneModel r29 = r28.a;
        if (r29 == null) goto L16;
        String r30 = r29.getKey();
    L17:
        JSONObject r110 = new JSONObject();
        String r210 = r30;
        RealtimeCallParam r31 = this.$params;
        RealtimeCallTracer r111 = this.$this_reportEndCall;
        long r112 = this.$backgroundDuration;
        boolean r32 = this.$useBgModeSnapshot;
        String r33 = this.$bgModeSnapshot;
        RealtimeCallParam.c r34 = r31.p.o;
        if (r34 == null) goto L20;
        String r35 = r34.a;
    L21:
        r110.put("action_bar_item_id", r35);
        RealtimeCallParam.c r36 = r31.p.o;
        if (r36 == null) goto L24;
        String r37 = r36.d;
    L25:
        r110.put("action_bar_key", r37);
        r110.put("video_call_duration", r111.d0);
        r110.put("sharescreen_duration", r111.e0);
        r110.put("session_unavailable_times", r111.f);
        r110.put("session_unavailable_duration", r111.g);
        r110.put("current_state", r111.d);
        r110.put("current_connect_state", r111.c.toString());
        r110.put("background_duration", r112);
        r111.c.toString();
        if (r32 == false) goto L29;
        String r38 = r33;
    L35:
        r111.v0(r110);
        r111.B0(r110);
        if (r32 == false) goto L38;
        RealtimeCallTracer.C0((RealtimeCallParam) r111.b.invoke(), r110);
        r111.w0(r110);
        r110.put("call_background_mode", r38);
    L39:
        String r40 = "0";
        if (r31.p.q == false) goto L42;
    L45:
        Object r41 = "1";
    L46:
        r110.put("is_continuous_speak", r41);
        if (r31.b == false) goto L49;
        r40 = "1";
    L49:
        r110.put("is_obric_continuous_talk", r40);
        RealtimeCallTracerReporterKt.a(r110, r31.r);
        String r42 = this.$params.p.g;
        Long r43 = Boxing.boxLong(r7);
        Long r44 = Boxing.boxLong(r17);
        Long r45 = Boxing.boxLong(0);
        Long r46 = Boxing.boxLong(r20);
        Long r47 = Boxing.boxLong(r22);
        Long r48 = Boxing.boxLong(r2);
        String r49 = this.$endMethod;
        Long r50 = Boxing.boxLong(r26);
        Long r113 = Boxing.boxLong(r27);
        Intrinsics.checkNotNullParameter(r110, LynxResourceModule.PARAMS_KEY);
        if (r43 != null) goto L105;
    L54:
        if (r12 == null) goto L56;
        r110.put("bot_id", r12);     // Catch: JSONException -> L52
    L56:
        if (r13 == null) goto L58;
        r110.put("call_id", r13);     // Catch: JSONException -> L52
    L58:
        if (r16 == null) goto L60;
        r110.put("conversation_id", r16);     // Catch: JSONException -> L52
    L60:
        if (r44 == null) goto L62;
        r110.put("duration", r44.longValue());     // Catch: JSONException -> L52
    L62:
        if (r45 == null) goto L64;
        r110.put("no_model_on_startup", r45.longValue());     // Catch: JSONException -> L52
    L64:
        if (r46 == null) goto L66;
        r110.put("pause_duration", r46.longValue());     // Catch: JSONException -> L52
    L66:
        if (r47 == null) goto L68;
        r110.put("question_cnt", r47.longValue());     // Catch: JSONException -> L52
    L68:
        if (r15 == 0) goto L70;
        r110.put("task_id", r15);     // Catch: JSONException -> L52
    L70:
        if (r25 == null) goto L72;
        r110.put("enter_method", r25);     // Catch: JSONException -> L52
    L72:
        if (r48 == null) goto L74;
        r110.put("user_speaking_duration", r48.longValue());     // Catch: JSONException -> L52
    L74:
        if (r24 == null) goto L76;
        r110.put("session_status", r24.intValue());     // Catch: JSONException -> L52
    L76:
        if (r4 == null) goto L78;
        r110.put("voice_id", r4);     // Catch: JSONException -> L52
    L78:
        if (r5 == null) goto L80;
        r110.put("speaker_id", r5);     // Catch: JSONException -> L52
    L80:
        if (r18 == null) goto L82;
        r110.put("speaker_name", r18);     // Catch: JSONException -> L52
    L82:
        r110.put("mute_duration", r21);     // Catch: JSONException -> L52
        if (r49 != null) goto L85;
        r49 = "abnormal_exit";
    L85:
        r110.put("end_method", r49);     // Catch: JSONException -> L52
        if (r50 == null) goto L88;
        r110.put("subtitle_duration", r50.longValue());     // Catch: JSONException -> L52
    L88:
        if (r113 == null) goto L90;
        r110.put("is_turn_on_subtitles", r113.longValue());     // Catch: JSONException -> L52
    L90:
        if (r42 == null) goto L92;
        r110.put("chat_type", r42);     // Catch: JSONException -> L52
    L92:
        if (r19 == null) goto L94;
        r110.put("is_immersive_background", r19);     // Catch: JSONException -> L52
    L94:
        if (r210 == null) goto L98;
        r110.put("call_scene", r210);     // Catch: JSONException -> L52
    L52:
        e = move-exception;
        FLogger.a.e("EndEventHelper", "error in EndEventHelper endCall " + e.getLocalizedMessage());
    L98:
        TrackParams r51 = new TrackParams().merge(r110);
        by7.a r52 = new by7.a("end_call");
        r52.a.merge(r51);
        r52.b();
        IObricMemoryReportSPIService r53 = (IObricMemoryReportSPIService) ServiceManager.get().getService(IObricMemoryReportSPIService.class);
        if (r53 == null) goto L102;
        r53.a(NameKeys.UnloadStrategy_No_Strategy, false);
    L102:
        return Unit.INSTANCE;
    L105:
        r110.put("answer_cnt", r43.longValue());     // Catch: JSONException -> L52
        goto L54
    L42:
        if (r31.a == true) goto L45;
        r41 = "0";
        goto L46
    L38:
        r110.put("call_background_mode", r38);
        RealtimeCallTracer.C0((RealtimeCallParam) r111.b.invoke(), r110);
        r111.w0(r110);
        goto L39
    L29:
        if (r111.i == false) goto L32;
        r38 = "screen_share";
        goto L35
    L32:
        if (r111.j == false) goto L34;
        r38 = "video_call";
        goto L35
    L34:
        r38 = "others";
        goto L35
    L24:
        r37 = null;
        goto L25
    L20:
        r35 = null;
    L16:
        r30 = null;
        goto L17
    L10:
        r24 = null;
        goto L11
    L104:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
