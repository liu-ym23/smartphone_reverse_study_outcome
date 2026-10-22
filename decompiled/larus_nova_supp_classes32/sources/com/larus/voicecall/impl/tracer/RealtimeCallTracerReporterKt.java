package com.larus.voicecall.impl.tracer;

import android.app.KeyguardManager;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallTracerReporterKt {
    public static final String b() {
        AppHost.Companion r0 = AppHost.a;
        Object r1 = r0.getApplication().getSystemService("keyguard");
        if ((r1 instanceof KeyguardManager) == false) goto L5;
        KeyguardManager r2 = (KeyguardManager) r1;
    L6:
        boolean r3 = false;
        if (r2 != null) goto L9;
    L11:
        if (r3 == false) goto L14;
        return "lock_screen";
    L14:
        if (r0.a().isAppBackground() == false) goto L16;
        return "did_enter_background";
    L16:
        return "app";
    L9:
        if (r2.isKeyguardLocked() != true) goto L11;
        r3 = true;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static final void e(RealtimeCallTracer r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Long r1 = Long.valueOf(r13.G);
        if (r1.longValue() <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        long r3 = r1.longValue();
    L13:
        JSONObject r6 = new JSONObject();
        r13.v0(r6);
        r6.put("call_id", ((RealtimeCallParam) r13.b.invoke()).e);
        r6.put("server_cost_time", r13.A);
        r6.put("intercept_type", ((RealtimeCallParam) r13.b.invoke()).l.h);
        r6.put("duration", r3 - r13.p);
        r6.put("duration_v2", r3 - r13.k0);
        r6.put("asr_end_to_first_txt_pkg_duration", r13.V - r13.p);
        r6.put("asr_end_to_first_tts_data_pkg_duration", r13.r - r13.p);
        long r7 = r13.r;
        if (r7 > 0) goto L16;
    L18:
        r6.put("scene", r13.z0());
        Iterator r4 = MapsKt.toMap(r13.Y).entrySet().iterator();
    L20:
        if (r4.hasNext() == false) goto L22;
        Map.Entry r5 = (Map.Entry) r4.next();
        r6.put((String) r5.getKey(), r5.getValue());
        goto L20
    L22:
        RealtimeCallTracer.C0((RealtimeCallParam) r13.b.invoke(), r6);
        r13.w0(r6);
        String r8 = "0";
        if (((RealtimeCallParam) r13.b.invoke()).p.q == false) goto L25;
    L28:
        Object r9 = "1";
    L29:
        r6.put("is_continuous_speak", r9);
        if (((RealtimeCallParam) r13.b.invoke()).b == false) goto L32;
        r8 = "1";
    L32:
        r6.put("is_obric_continuous_talk", r8);
        r6.put("enter_method", ((RealtimeCallParam) r13.b.invoke()).p.i);
        r6.put("reply_id", r13.U);
        r6.put("question_id", r13.T);
        r6.put("llm_model", ((RealtimeCallParam) r13.b.invoke()).i);
        r6.put("pre_query", ((RealtimeCallParam) r13.b.invoke()).l.m ? 1 : 0);
        r6.put("modal_type", u.a(r13));
        r13.w0(r6);
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r13.p = -1;
        com.larus.platform.service.o.a.reportEvent("realtime_call_message_v2", r6);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeCallTracerReporterKt$mobRealtimeCallMessageV2$1(r6, null), 2, null);
        return;
    L25:
        if (((RealtimeCallParam) r13.b.invoke()).a == true) goto L28;
        r9 = "0";
        goto L29
    L16:
        if (r3 < r7) goto L18;
        r6.put("tts_first_data_pkg_to_play_start", r3 - r7);
        goto L18
    L12:
        r3 = System.currentTimeMillis();
        goto L13
    L5:
        r2 = false;
        goto L7
    }

    public static final void a(JSONObject r2, ouc.d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "originTrackParams");
        Intrinsics.checkNotNullParameter(r3, "newParams");
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r4.next();
        r2.put((String) r0.getKey(), r0.getValue());
        goto L4
    }

    public static final void d(RealtimeCallTracer r7, RealtimeCallParam r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "toStatus");
        InstanceCallState.Companion.getClass();
        String r11 = InstanceCallState.a.a(r9);
        String r1 = r8.o.h;
        String r2 = r8.e;
        String r3 = r8.l.c;
        String r4 = r8.w;
        String r5 = r8.p.g;
        JSONObject r6 = new JSONObject();
        r7.v0(r6);
        RealtimeCallTracer.C0(r8, r6);
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        r6.put("bot_from_status", r11);     // Catch: JSONException -> L16
        if (r1 == null) goto L6;
        r6.put("bot_id", r1);     // Catch: JSONException -> L16
    L6:
        if (r2 == null) goto L8;
        r6.put("call_id", r2);     // Catch: JSONException -> L16
    L8:
        if (r3 == null) goto L10;
        r6.put("conversation_id", r3);     // Catch: JSONException -> L16
    L10:
        r6.put("to_status", r10);     // Catch: JSONException -> L16
        if (r4 == null) goto L13;
        r6.put("is_immersive_background", r4);     // Catch: JSONException -> L16
    L13:
        if (r5 == null) goto L18;
        r6.put("chat_type", r5);     // Catch: JSONException -> L16
    L18:
        TrackParams r12 = new TrackParams().merge(r6);
        by7.a r13 = new by7.a("pause_call");
        r13.a.merge(r12);
        r13.b();
        return;
    L16:
        e = move-exception;
        FLogger.a.e("PauseEventHelper", "error in PauseEventHelper pauseCall " + e.getLocalizedMessage());
        goto L18
    }

    public static final void c(RealtimeCallTracer r20, String r21, String r22, String r23, int r24, boolean r25, String r26, String r27, String r28, boolean r29, boolean r30, String r31, String r32, RealtimeCallParam.c r33, String r34) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        InstanceCallState.Companion.getClass();
        String r9 = InstanceCallState.a.a(r24);
        if (r20.r >= 0) goto L5;
        long r10 = -1;
    L6:
        if (r25 == false) goto L8;
        String r12 = "speak";
    L9:
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r13 = RealtimeCallUtil.l;
        if (r13 == null) goto L14;
        SceneModel r14 = r13.a;
        if (r14 == null) goto L14;
        String r15 = r14.getKey();
    L15:
        boolean r16 = RealtimeCallUtil.J;
        if (r16 == false) goto L21;
        if (RealtimeCallUtil.l == null) goto L21;
        Object r210 = RiskPreferenceSettings.SMART_BALANCE;
    L26:
        String r17 = RealtimeCallUtil.I;
        if (r20.i == false) goto L30;
        String r18 = "screen_share";
    L33:
        String r19 = r18;
        JSONObject r110 = new JSONObject();
        if (r33 == null) goto L36;
        String r111 = r33.a;
    L37:
        r110.put("action_bar_item_id", r111);
        if (r33 == null) goto L40;
        String r7 = r33.d;
    L41:
        r110.put("action_bar_key", r7);
        r20.B0(r110);
        Iterator r8 = ((LinkedHashMap) r20.Y).entrySet().iterator();
    L43:
        if (r8.hasNext() == false) goto L45;
        Map.Entry r11 = (Map.Entry) r8.next();
        r110.put((String) r11.getKey(), r11.getValue());
        goto L43
    L45:
        if (r34 != null) goto L47;
        String r35 = NameKeys.UnloadStrategy_No_Strategy;
    L48:
        r110.put("speaker_id", r35);
        String r36 = "0";
        if (r29 == false) goto L51;
        Object r37 = "1";
    L52:
        r110.put("is_continuous_speak", r37);
        if (r30 == false) goto L55;
        r36 = "1";
    L55:
        r110.put("is_obric_continuous_talk", r36);
        RealtimeCallParam r38 = (RealtimeCallParam) r20.b.invoke();
        r20.v0(r110);
        RealtimeCallTracer.C0(r38, r110);
        r20.w0(r110);
        r110.put("enter_method", r31);
        Long r0 = Long.valueOf(r10);
        Integer r39 = Integer.valueOf(r16 ? 1 : 0);
        Intrinsics.checkNotNullParameter(r110, LynxResourceModule.PARAMS_KEY);
        r110.put("bot_from_status", r9);     // Catch: JSONException -> L85
        if (r21 == null) goto L59;
        r110.put("bot_id", r21);     // Catch: JSONException -> L85
    L59:
        if (r0 == null) goto L61;
        r110.put("bot_speak_duration", r0.longValue());     // Catch: JSONException -> L85
    L61:
        if (r23 == null) goto L63;
        r110.put("call_id", r23);     // Catch: JSONException -> L85
    L63:
        if (r22 == null) goto L65;
        r110.put("conversation_id", r22);     // Catch: JSONException -> L85
    L65:
        r110.put("break_method", r12);     // Catch: JSONException -> L85
        if (r26 == null) goto L68;
        r110.put("asr_task_id", r26);     // Catch: JSONException -> L85
    L68:
        if (r27 == null) goto L70;
        r110.put("tts_task_id", r27);     // Catch: JSONException -> L85
    L70:
        if (r28 == null) goto L73;
        r110.put("is_immersive_background", r28);     // Catch: JSONException -> L85
    L73:
        if (r32 == null) goto L75;
        r110.put("chat_type", r32);     // Catch: JSONException -> L85
    L75:
        if (r15 == 0) goto L77;
        r110.put("call_scene", r15);     // Catch: JSONException -> L85
    L77:
        if (r39 == null) goto L79;
        r110.put("is_realtime_call_hello", r39.intValue());     // Catch: JSONException -> L85
    L79:
        if (r17 == null) goto L81;
        r110.put("realtime_call_hello_tech_type", r17);     // Catch: JSONException -> L85
    L81:
        if (r210 == null) goto L83;
        r110.put("realtime_call_hello_type", r210);     // Catch: JSONException -> L85
    L83:
        r110.put("call_background_mode", r19);     // Catch: JSONException -> L85
    L87:
        TrackParams r1 = new TrackParams().merge(r110);
        by7.a r2 = new by7.a("break_call");
        r2.a.merge(r1);
        r2.b();
        return;
    L85:
        e = move-exception;
        FLogger.a.e("BreakEventHelper", "error in BreakEventHelper breakCall " + e.getLocalizedMessage());
        goto L87
    L51:
        r37 = "0";
        goto L52
    L47:
        r35 = r34;
        goto L48
    L40:
        r7 = null;
        goto L41
    L36:
        r111 = null;
        goto L37
    L30:
        if (r20.j == false) goto L32;
        r18 = "video_call";
        goto L33
    L32:
        r18 = "others";
    L21:
        if (RealtimeCallUtil.J == true) goto L23;
    L25:
        r210 = null;
        goto L26
    L23:
        if (RealtimeCallUtil.l != null) goto L25;
        r210 = "1";
    L14:
        r15 = null;
        goto L15
    L8:
        r12 = "manual";
        goto L9
    L5:
        r10 = System.currentTimeMillis() - r20.r;
        goto L6
    }
}
