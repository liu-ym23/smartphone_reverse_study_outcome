package com.larus.voice_setting.voice.base;

import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.RecommendFrom;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.bean.RequestType;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.b4;
import tx9.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g1 implements p2a.d {
    public static final g1 a = null;

    static {
        a = new g1();
    }

    public g1() {
    }

    public static void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("enter_from", r3);
        r1.put("current_page", r3);
        Unit r4 = Unit.INSTANCE;
        r0.reportEvent("click_delete_own_voice", r1);
    }

    public static void b(String r3, SpeakerVoice r4) {
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        if (r4 != null) goto L5;
        return;
    L5:
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("enter_from", r3);
        r1.put("voice_id", r4.getId());
        r1.put("speaker_id", r4.getStyleId());
        r1.put("speaker_name", r4.getName());
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("click_change_own_voice_name", r1);
    }

    public static void f(SpeakerVoice r24, RecommendFrom r25, Integer r26) {
        if (r24 != null) goto L6;
        return;
    L6:
        if (r24.getBestMatch() == false) goto L8;
        String r5 = "1";
    L10:
        if (r24.getPrivateStatus() != 1) goto L12;
        String r6 = "1";
    L13:
        String r9 = r24.getId();
        if (r24.isUgcVoice() == false) goto L16;
        String r1 = "self_create";
    L17:
        String r10 = r1;
        if (r25 == null) goto L23;
        String r2 = r25.a;
        if (r2 == null) goto L23;
        String r7 = r2;
    L24:
        if (r25 == null) goto L29;
        String r0 = r25.b;
        if (r0 == null) goto L29;
        String r8 = r0;
    L30:
        String r15 = r24.getName();
        q1.a(r26, r5, r6, r7, r8, r9, r10, null, null, null, r24.getStyleId(), r15, null, null, null, null, null, null, null, 2093952);
        return;
    L29:
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L23:
        r7 = NameKeys.UnloadStrategy_No_Strategy;
        goto L24
    L16:
        r1 = LynxUIWebView.DEFAULT;
        goto L17
    L12:
        r6 = "0";
        goto L13
    L8:
        r5 = "0";
        goto L10
    }

    public static void e(SpeakerVoice r5, boolean r6, boolean r7, boolean r8) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = r5.getId();
        String r1 = "1";
        if (r8 == false) goto L7;
        Object r9 = "1";
    L8:
        if (r7 == false) goto L10;
        Object r10 = "1";
    L12:
        if (r5.getPrivateStatus() != 1) goto L14;
        Object r3 = "1";
    L15:
        if (r6 == true) goto L18;
        r1 = "0";
    L18:
        String r11 = r5.getStyleId();
        String r12 = r5.getName();
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        r2.put("is_default_avatar", r9);     // Catch: JSONException -> L27
        r2.put("is_default_name", r10);     // Catch: JSONException -> L27
        r2.put("is_public", r3);     // Catch: JSONException -> L27
        r2.put("success", r1);     // Catch: JSONException -> L27
        if (r0 == null) goto L22;
        r2.put("voice_id", r0);     // Catch: JSONException -> L27
    L22:
        if (r11 == null) goto L24;
        r2.put("speaker_id", r11);     // Catch: JSONException -> L27
    L24:
        if (r12 == null) goto L29;
        r2.put("speaker_name", r12);     // Catch: JSONException -> L27
    L29:
        TrackParams r13 = new TrackParams().merge(r2);
        by7.a r14 = new by7.a("edit_own_voice_complete");
        r14.a.merge(r13);
        r14.b();
        return;
    L27:
        e = move-exception;
        FLogger.a.e("EditEventHelper", "error in EditEventHelper editOwnVoiceComplete " + e.getLocalizedMessage());
        goto L29
    L14:
        r3 = "0";
        goto L15
    L10:
        r10 = "0";
        goto L12
    L7:
        r9 = "0";
        goto L8
    }

    public static void h(SpeakerVoice r1, String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        if (r1 != null) goto L5;
        return;
    L5:
        r4.put("enter_from", r2);
        r4.put("voice_id", r1.getId());
        if (r1.getPrivateStatus() != 1) goto L8;
        String r5 = "1";
    L9:
        r4.put("is_public", r5);
        r4.put("speaker_id", r1.getStyleId());
        r4.put("speaker_name", r1.getName());
        r4.put("voice_create_id", b4.a);
        r4.put("enter_method", r3);
        com.larus.platform.service.o.a.reportEvent("record_own_voice_complete", r4);
        com.larus.platform.service.g.a.monitorEventForSlardar("record_own_voice_complete", r4, null, null);
        return;
    L8:
        r5 = "0";
        goto L9
    }

    public static void c(String r7, TraceFragment r8, String r9, JSONObject r10, String r11) {
        Intrinsics.checkNotNullParameter(r7, "enterFrom");
        Intrinsics.checkNotNullParameter(r8, "node");
        Intrinsics.checkNotNullParameter(r9, "previousPage");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        tx9.c0.m("bot_setting", "bot_voice_change", r7, r9, r11, r10, r8);
    }

    public static void g(long r4, RequestType r6, int r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "requestType");
        Intrinsics.checkNotNullParameter(RiskPreferenceSettings.SMART_BALANCE, "recommendType");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        r2.put("time", r4);
        r2.put("request_type", r6.getType());
        r2.put("success", r7);
        if (r8 == false) goto L5;
        String r5 = "1";
    L6:
        r2.put("preload", r5);
        r2.put("recommend_type", RiskPreferenceSettings.SMART_BALANCE);
        r2.put("is_main_bot", r9 ? 1 : 0);
        Unit r10 = Unit.INSTANCE;
        r0.reportEvent("recommend_request_load_time", r2);
        return;
    L5:
        r5 = "0";
        goto L6
    }

    public static void i(SpeakerVoice r16, RecommendFrom r17, String r18, String r19, by7.e r20, String r21, String r22, Boolean r23) {
        if (r16 != null) goto L6;
        return;
    L6:
        if (r16.getPrivateStatus() != 1) goto L8;
        String r6 = "1";
    L9:
        String r7 = r16.getId();
        if (Intrinsics.areEqual(r19, "tts_disabled") == false) goto L12;
        String r8 = "chat";
    L14:
        if (r16.isUgcVoice() == false) goto L16;
        String r9 = "self_create";
    L17:
        String r10 = NameKeys.UnloadStrategy_No_Strategy;
        if (r17 == null) goto L21;
        String r11 = r17.a;
        if (r11 == null) goto L21;
    L22:
        if (r17 == null) goto L27;
        String r0 = r17.b;
        if (r0 == null) goto L27;
        r10 = r0;
    L27:
        String r1 = r16.getName();
        String r12 = r16.getStyleId();
        String r13 = r16.getStyleId();
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        if (r18 != null) goto L59;
    L30:
        r14.put("is_public", r6);     // Catch: JSONException -> L52
        if (r8 == null) goto L33;
        r14.put("previous_page", r8);     // Catch: JSONException -> L52
    L33:
        r14.put("recommend_from", r11);     // Catch: JSONException -> L52
        r14.put("req_id", r10);     // Catch: JSONException -> L52
        if (r7 == null) goto L36;
        r14.put("voice_id", r7);     // Catch: JSONException -> L52
    L36:
        r14.put("voice_type", r9);     // Catch: JSONException -> L52
        if (r19 == null) goto L39;
        r14.put("enter_method", r19);     // Catch: JSONException -> L52
    L39:
        if (r12 == null) goto L41;
        r14.put("speaker_id", r12);     // Catch: JSONException -> L52
    L41:
        if (r1 == null) goto L43;
        r14.put("speaker_name", r1);     // Catch: JSONException -> L52
    L43:
        if (r21 == null) goto L45;
        r14.put("scene", r21);     // Catch: JSONException -> L52
    L45:
        if (r13 == null) goto L47;
        r14.put("to_tts_speaker", r13);     // Catch: JSONException -> L52
    L47:
        if (r22 == null) goto L49;
        r14.put("bot_id", r22);     // Catch: JSONException -> L52
    L49:
        if (r23 == null) goto L54;
        r14.put("is_best_match", r23.booleanValue() ? 1 : 0);     // Catch: JSONException -> L52
    L52:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper voiceCellShow " + e.getLocalizedMessage());
    L54:
        TrackParams r2 = new TrackParams().merge(r14);
        by7.a r3 = new by7.a("voice_cell_show");
        if (r20 == null) goto L57;
        r3.b = r20;
    L57:
        r3.a.merge(r2);
        r3.b();
        return;
    L59:
        r14.put("click_from", r18);     // Catch: JSONException -> L52
    L21:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
        goto L22
    L16:
        r9 = LynxUIWebView.DEFAULT;
        goto L17
    L12:
        r8 = null;
        goto L14
    L8:
        r6 = "0";
        goto L9
    }

    @Override // p2a.d
    public final void a(SpeakerVoice r19, String r20, boolean r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, Float r29, Float r30, Integer r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, ouc.d0 r40) {
        Intrinsics.checkNotNullParameter(r40, LynxResourceModule.PARAMS_KEY);
        JSONObject r15 = new JSONObject(r40.toString());
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        if (r20 == null) goto L5;
        r15.put("bot_id", r20);
    L5:
        if (r22 == null) goto L8;
        r15.put("enter_from", r22);
    L8:
        if (r19 != null) goto L10;
    L30:
        r15.put("if_auto", r21 ? 1 : 0);
        if (r26 == null) goto L33;
        r15.put("recommend_from", r26);
    L33:
        if (r27 == null) goto L35;
        r15.put("req_id", r27);
    L35:
        if (r34 == null) goto L37;
        r15.put("click_position", r34);
    L37:
        if (r36 == null) goto L39;
        r15.put("tab_name", r36);
    L39:
        if (r35 == null) goto L41;
        r15.put("enter_method", r35);
    L41:
        if (r28 == null) goto L43;
        r15.put("voice_remix_id", r28);
    L43:
        if (r31 == null) goto L45;
        r15.put("voice_origin_cnt", r31.intValue());
    L45:
        if (r32 == null) goto L47;
        r15.put("if_voice_ratio_default", r32);
    L47:
        if (r33 == null) goto L49;
        r15.put("is_best_match", r33);
    L49:
        if (r29 == null) goto L51;
        r15.put("voice_pitch", r29);
    L51:
        if (r30 == null) goto L53;
        r15.put("voice_speed", r30);
    L53:
        if (r25 == null) goto L56;
        r15.put("click_from", r25);
    L56:
        if (r23 == null) goto L59;
        r15.put("current_page", r23);
    L59:
        if (r24 == null) goto L62;
        r15.put("previous_page", r24);
    L62:
        if (r37 == null) goto L65;
        r15.put("scene", r37);
    L65:
        if (r38 == null) goto L68;
        r15.put("from_voice_id", r38);
    L68:
        if (r39 == null) goto L70;
        r15.put("success", r39);
    L70:
        Unit r0 = Unit.INSTANCE;
        r3.reportEvent("change_voice", r15);
        return;
    L10:
        if (r19.isUgcVoice() == false) goto L12;
        String r1 = "self_create";
    L13:
        r15.put("voice_type", r1);
        r15.put("voice_id", r19.getId());
        r15.put("to_tts_speaker", r19.getStyleId());
        if (r19.getPrivateStatus() != 1) goto L16;
        Object r2 = "1";
    L17:
        r15.put("is_public", r2);
        if (r19.getBestMatch() == false) goto L20;
        Object r4 = "1";
    L21:
        r15.put("is_best_match", r4);
        List r5 = r19.getMixVoiceList();
        if (r5 == null) goto L24;
        int r6 = r5.size();
    L26:
        if (r6 <= 1) goto L28;
        String r7 = "mixed voice";
    L29:
        r15.put("speaker_name", r7);
        r15.put("speaker_id", r19.getStyleId());
        r15.put("speaker_name", r19.getName());
        goto L30
    L28:
        r7 = r19.getName();
        goto L29
    L24:
        r6 = 0;
        goto L26
    L20:
        r4 = "0";
        goto L21
    L16:
        r2 = "0";
        goto L17
    L12:
        r1 = LynxUIWebView.DEFAULT;
        goto L13
    }
}
