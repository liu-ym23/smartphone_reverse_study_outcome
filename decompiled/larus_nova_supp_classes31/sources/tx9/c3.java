package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.trace.RealtimeCallEntry;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c3 {
    public static void c(RealtimeCallEntry r2) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        JSONObject r0 = new JSONObject();
        r0.put("entrance", r2.getTrackName());
        TrackParams r3 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("voicecall_entrance_show");
        r1.a.merge(r3);
        r1.b();
    }

    public static final void a(String r2, long r3) {
        JSONObject r0 = new JSONObject();
        if (r2 == null) goto L5;
        r0.put("message_id", r2);
    L5:
        r0.put("asr_tail_time", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r5 = new by7.a("vui_asr_tail_info");
        r5.a.merge(r4);
        r5.b();
    }

    public static void g(Long r4, Long r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r4 != null) goto L13;
    L7:
        if (r5 == null) goto L11;
        r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r5.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallSettingsResponseErrorFix " + e.getLocalizedMessage());
    L11:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("realtime_call_settings_response_error_fix");
        r7.a.merge(r6);
        r7.b();
        return;
    L13:
        r0.put("enable", r4.longValue());     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r2, String r3, Long r4, String r5, by7.e r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 32) == 0) goto L17;
        JSONObject r0 = new JSONObject();
    L19:
        if ((r7 & 64) == 0) goto L21;
        r6 = null;
    L21:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L39;
    L26:
        if (r3 == null) goto L28;
        r0.put("position", r3);     // Catch: JSONException -> L24
    L28:
        if (r4 == null) goto L30;
        r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r4.longValue());     // Catch: JSONException -> L24
    L30:
        if (r5 == null) goto L34;
        r0.put("red_dot", r5);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallEntranceShow " + e.getLocalizedMessage());
    L34:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("realtime_call_entrance_show");
        if (r6 == null) goto L37;
        r9.b = r6;
    L37:
        r9.a.merge(r8);
        r9.b();
        return;
    L39:
        r0.put("bot_id", r2);     // Catch: JSONException -> L24
        goto L26
    L17:
        r0 = null;
        goto L19
    }

    public static void e(String r19, String r20, String r21, Long r22, String r23, Long r24, Long r25, Long r26, String r27, Long r28, String r29, String r30, Long r31, String r32, Integer r33, String r34, JSONObject r35, Integer r36, int r37) {
        if ((r37 & 2) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r37 & 4) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r37 & 8) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r37 & 16) == 0) goto L17;
        Long r5 = null;
    L19:
        if ((r37 & 32) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r37 & 64) == 0) goto L25;
        Long r7 = null;
    L27:
        if ((r37 & 128) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r37 & 256) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r37 & 512) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r37 & 1024) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r37 & 2048) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r37 & 4096) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((r37 & 8192) == 0) goto L53;
        Long r14 = null;
    L55:
        if ((r37 & 16384) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r37 & 262144) == 0) goto L61;
        Integer r16 = null;
    L63:
        if ((r37 & 524288) == 0) goto L65;
        Object r2 = null;
    L67:
        if ((r37 & 2097152) == 0) goto L69;
        JSONObject r17 = new JSONObject();
    L71:
        if ((r37 & 8388608) == 0) goto L73;
        Integer r18 = null;
    L74:
        Intrinsics.checkNotNullParameter(r17, "params");
        if (r1 != null) goto L115;
    L79:
        if (r3 == null) goto L81;
        r17.put("call_id", r3);     // Catch: JSONException -> L77
    L81:
        if (r4 == null) goto L83;
        r17.put("conversation_id", r4);     // Catch: JSONException -> L77
    L83:
        if (r5 == null) goto L85;
        r17.put("error_code", r5.longValue());     // Catch: JSONException -> L77
    L85:
        if (r6 == null) goto L87;
        r17.put("error_msg", r6);     // Catch: JSONException -> L77
    L87:
        if (r7 == null) goto L89;
        r17.put("from_status", r7.longValue());     // Catch: JSONException -> L77
    L89:
        if (r8 == null) goto L91;
        r17.put("is_ai_in_motion", r8.longValue());     // Catch: JSONException -> L77
    L91:
        if (r9 == null) goto L93;
        r17.put("is_mock_chat", r9.longValue());     // Catch: JSONException -> L77
    L93:
        if (r10 == null) goto L95;
        r17.put("llm_model", r10);     // Catch: JSONException -> L77
    L95:
        if (r11 == null) goto L97;
        r17.put("pre_query", r11.longValue());     // Catch: JSONException -> L77
    L97:
        if (r12 == null) goto L99;
        r17.put("scene", r12);     // Catch: JSONException -> L77
    L99:
        if (r13 == null) goto L101;
        r17.put("task_id", r13);     // Catch: JSONException -> L77
    L101:
        if (r14 == null) goto L103;
        r17.put("user_interrupt", r14.longValue());     // Catch: JSONException -> L77
    L103:
        if (r15 == null) goto L105;
        r17.put("voice_style", r15);     // Catch: JSONException -> L77
    L105:
        if (r16 == null) goto L107;
        r17.put("is_session_started", r16.intValue());     // Catch: JSONException -> L77
    L107:
        if (r2 == 0) goto L109;
        r17.put("biz_scene", r2);     // Catch: JSONException -> L77
    L109:
        if (r18 == null) goto L113;
        r17.put("is_dora_si", r18.intValue());     // Catch: JSONException -> L77
    L77:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallError " + e.getLocalizedMessage());
    L113:
        TrackParams r0 = new TrackParams().merge(r17);
        by7.a r38 = new by7.a("flow_vui_error_report");
        r38.a.merge(r0);
        r38.b();
        return;
    L115:
        r17.put("bot_id", r1);     // Catch: JSONException -> L77
        goto L79
    L73:
        r18 = r36;
        goto L74
    L69:
        r17 = r35;
        goto L71
    L65:
        r2 = r34;
        goto L67
    L61:
        r16 = r33;
        goto L63
    L57:
        r15 = r32;
        goto L59
    L53:
        r14 = r31;
        goto L55
    L49:
        r13 = r30;
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }

    public static void d(String r26, String r27, String r28, String r29, Long r30, String r31, Integer r32, String r33, String r34, Long r35, Long r36, Long r37, String r38, Long r39, String r40, String r41, Long r42, String r43, Integer r44, Integer r45, Integer r46, Integer r47, String r48, String r49, Integer r50, Integer r51, Integer r52, JSONObject r53, int r54) {
        if ((r54 & 2) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r54 & 4) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r54 & 8) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r54 & 16) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r54 & 32) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r54 & 64) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r54 & 128) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r54 & 256) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r54 & 512) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r54 & 1024) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r54 & 2048) == 0) goto L45;
        Long r12 = null;
    L47:
        if ((r54 & 4096) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((r54 & 8192) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((r54 & 16384) == 0) goto L57;
        Long r15 = null;
    L59:
        if ((r54 & 32768) == 0) goto L61;
        Object r2 = null;
    L62:
        Object r210 = r10;
        if ((r54 & 65536) == 0) goto L65;
        Object r16 = null;
    L67:
        if ((r54 & 131072) == 0) goto L69;
        Long r17 = null;
    L70:
        Object r211 = r9;
        if ((r54 & 262144) == 0) goto L73;
        Object r18 = null;
    L75:
        if ((r54 & 524288) == 0) goto L77;
        Integer r19 = null;
    L79:
        if ((r54 & 1048576) == 0) goto L81;
        Integer r110 = null;
    L83:
        if ((r54 & 2097152) == 0) goto L85;
        Integer r20 = null;
    L87:
        if ((r54 & 4194304) == 0) goto L89;
        Integer r21 = null;
    L90:
        Integer r212 = r8;
        if ((r54 & 8388608) == 0) goto L93;
        Object r22 = null;
    L95:
        if ((r54 & 16777216) == 0) goto L97;
        Object r23 = null;
    L99:
        if ((r54 & 33554432) == 0) goto L101;
        Integer r24 = null;
    L103:
        if ((r54 & 67108864) == 0) goto L105;
        Integer r25 = null;
    L107:
        if ((r54 & 134217728) == 0) goto L109;
        Integer r111 = null;
    L111:
        if ((r54 & 268435456) == 0) goto L113;
        JSONObject r55 = new JSONObject();
    L114:
        Intrinsics.checkNotNullParameter(r55, "params");
        if (r1 != null) goto L176;
    L119:
        if (r3 == null) goto L121;
        r55.put("call_id", r3);     // Catch: JSONException -> L117
    L121:
        if (r4 == null) goto L123;
        r55.put("room_id", r4);     // Catch: JSONException -> L117
    L123:
        if (r5 == null) goto L125;
        r55.put("conversation_id", r5);     // Catch: JSONException -> L117
    L125:
        if (r6 == null) goto L127;
        r55.put("error_code", r6.longValue());     // Catch: JSONException -> L117
    L127:
        if (r7 == null) goto L129;
        r55.put("error_msg", r7);     // Catch: JSONException -> L117
    L129:
        if (r11 == null) goto L131;
        r55.put("from_status", r11.longValue());     // Catch: JSONException -> L117
    L131:
        if (r12 == null) goto L133;
        r55.put("is_ai_in_motion", r12.longValue());     // Catch: JSONException -> L117
    L133:
        if (r13 == null) goto L135;
        r55.put("is_mock_chat", r13.longValue());     // Catch: JSONException -> L117
    L135:
        if (r14 == null) goto L137;
        r55.put("llm_model", r14);     // Catch: JSONException -> L117
    L137:
        if (r15 == null) goto L139;
        r55.put("pre_query", r15.longValue());     // Catch: JSONException -> L117
    L139:
        if (r2 == null) goto L141;
        r55.put("scene", r2);     // Catch: JSONException -> L117
    L141:
        if (r16 == null) goto L143;
        r55.put("task_id", r16);     // Catch: JSONException -> L117
    L143:
        if (r17 == null) goto L145;
        r55.put("user_interrupt", r17.longValue());     // Catch: JSONException -> L117
    L145:
        if (r18 == null) goto L147;
        r55.put("voice_style", r18);     // Catch: JSONException -> L117
    L147:
        if (r19 == null) goto L149;
        r55.put("is_ai_motion_support", r19.intValue());     // Catch: JSONException -> L117
    L149:
        if (r110 == null) goto L151;
        r55.put("is_avatar_can_drive", r110.intValue());     // Catch: JSONException -> L117
    L151:
        if (r20 == null) goto L153;
        r55.put("is_algorithm_model_downloaded", r20.intValue());     // Catch: JSONException -> L117
    L153:
        if (r21 == null) goto L155;
        r55.put("is_session_started", r21.intValue());     // Catch: JSONException -> L117
    L155:
        if (r22 == 0) goto L157;
        r55.put("biz_scene", r22);     // Catch: JSONException -> L117
    L157:
        Object r0 = r23;
        if (r0 == null) goto L160;
        r55.put("dora_mode", r0);     // Catch: JSONException -> L117
    L160:
        if (r24 == null) goto L162;
        r55.put("is_rtc", r24.intValue());     // Catch: JSONException -> L117
    L162:
        if (r25 == null) goto L164;
        r55.put("is_dora_si", r25.intValue());     // Catch: JSONException -> L117
    L164:
        if (r111 == null) goto L166;
        r55.put("av_session_type", r111.intValue());     // Catch: JSONException -> L117
    L166:
        if (r212 == null) goto L168;
        r55.put("sub_error_code", r212.intValue());     // Catch: JSONException -> L117
    L168:
        if (r211 == null) goto L170;
        r55.put("sub_error_msg", r211);     // Catch: JSONException -> L117
    L170:
        if (r210 == null) goto L174;
        r55.put("sub_extra_info", r210);     // Catch: JSONException -> L117
    L117:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallError " + e.getLocalizedMessage());
    L174:
        TrackParams r56 = new TrackParams().merge(r55);
        by7.a r57 = new by7.a("realtime_call_error");
        r57.a.merge(r56);
        r57.b();
        return;
    L176:
        r55.put("bot_id", r1);     // Catch: JSONException -> L117
        goto L119
    L113:
        r55 = r53;
        goto L114
    L109:
        r111 = r52;
        goto L111
    L105:
        r25 = r51;
        goto L107
    L101:
        r24 = r50;
        goto L103
    L97:
        r23 = r49;
        goto L99
    L93:
        r22 = r48;
        goto L95
    L89:
        r21 = r47;
        goto L90
    L85:
        r20 = r46;
        goto L87
    L81:
        r110 = r45;
        goto L83
    L77:
        r19 = r44;
        goto L79
    L73:
        r18 = r43;
        goto L75
    L69:
        r17 = r42;
        goto L70
    L65:
        r16 = r41;
        goto L67
    L61:
        r2 = r40;
        goto L62
    L57:
        r15 = r39;
        goto L59
    L53:
        r14 = r38;
        goto L55
    L49:
        r13 = r37;
        goto L51
    L45:
        r12 = r36;
        goto L47
    L41:
        r11 = r35;
        goto L43
    L37:
        r10 = r34;
        goto L39
    L33:
        r9 = r33;
        goto L35
    L29:
        r8 = r32;
        goto L31
    L25:
        r7 = r31;
        goto L27
    L21:
        r6 = r30;
        goto L23
    L17:
        r5 = r29;
        goto L19
    L13:
        r4 = r28;
        goto L15
    L9:
        r3 = r27;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }

    public static void f(Long r29, String r30, String r31, String r32, Long r33, Long r34, Long r35, Long r36, String r37, Long r38, String r39, Long r40, Long r41, Long r42, String r43, Long r44, String r45, Integer r46, Integer r47, Integer r48, String r49, String r50, String r51, String r52, Integer r53, Integer r54, JSONObject r55, String r56, int r57) {
        if ((r57 & 2) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r57 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r57 & 16) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r57 & 32) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r57 & 64) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r57 & 128) == 0) goto L25;
        Long r7 = null;
    L27:
        if ((r57 & 256) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r57 & 512) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r57 & 1024) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r57 & 4096) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r57 & 8192) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r57 & 16384) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((32768 & r57) == 0) goto L53;
        Long r14 = null;
    L55:
        if ((65536 & r57) == 0) goto L57;
        Long r15 = null;
    L59:
        if ((r57 & 131072) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r57 & 262144) == 0) goto L65;
        Long r17 = null;
    L67:
        if ((r57 & 524288) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r57 & 1048576) == 0) goto L73;
        Integer r18 = null;
    L75:
        if ((r57 & 2097152) == 0) goto L77;
        Integer r20 = null;
    L79:
        if ((r57 & 4194304) == 0) goto L81;
        Integer r21 = null;
    L83:
        if ((r57 & 8388608) == 0) goto L85;
        String r23 = "call";
    L87:
        if ((r57 & 16777216) == 0) goto L89;
        String r24 = null;
    L91:
        if ((r57 & 33554432) == 0) goto L93;
        String r16 = null;
    L95:
        if ((r57 & 67108864) == 0) goto L97;
        String r110 = null;
    L99:
        if ((r57 & 134217728) == 0) goto L101;
        Integer r26 = null;
    L103:
        if ((r57 & 268435456) == 0) goto L105;
        Integer r27 = null;
    L107:
        if ((r57 & 536870912) == 0) goto L109;
        JSONObject r111 = new JSONObject();
    L111:
        if ((r57 & Integer.MIN_VALUE) == 0) goto L113;
        String r310 = null;
    L114:
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r110 != null) goto L178;
    L119:
        if (r16 == null) goto L121;
        r111.put("query_id", r16);     // Catch: JSONException -> L117
    L121:
        if (r1 == null) goto L123;
        r111.put("asr_tail", r1.longValue());     // Catch: JSONException -> L117
    L123:
        if (r3 == null) goto L125;
        r111.put("bot_id", r3);     // Catch: JSONException -> L117
    L125:
        if (r4 == null) goto L127;
        r111.put("call_id", r4);     // Catch: JSONException -> L117
    L127:
        if (r5 == null) goto L129;
        r111.put("conversation_id", r5);     // Catch: JSONException -> L117
    L129:
        if (r6 == null) goto L131;
        r111.put("if_proactive", r6.longValue());     // Catch: JSONException -> L117
    L131:
        if (r7 == null) goto L133;
        r111.put("is_ai_in_motion", r7.longValue());     // Catch: JSONException -> L117
    L133:
        if (r8 == null) goto L135;
        r111.put("is_mock_chat", r8.longValue());     // Catch: JSONException -> L117
    L135:
        if (r9 == null) goto L137;
        r111.put("llm", r9.longValue());     // Catch: JSONException -> L117
    L137:
        if (r10 == null) goto L139;
        r111.put("llm_model", r10);     // Catch: JSONException -> L117
    L139:
        if (r11 == null) goto L141;
        r111.put("pre_query", r11.longValue());     // Catch: JSONException -> L117
    L141:
        if (r12 == null) goto L143;
        r111.put("task_id", r12);     // Catch: JSONException -> L117
    L143:
        if (r13 == null) goto L145;
        r111.put("total", r13.longValue());     // Catch: JSONException -> L117
    L145:
        if (r14 == 0) goto L147;
        r111.put("tts_delay", r14.longValue());     // Catch: JSONException -> L117
    L147:
        if (r14 == 0) goto L149;
        r111.put("appease_play_duration", r15);     // Catch: JSONException -> L117
    L149:
        if (r14 == 0) goto L151;
        r111.put("comfortScene", r2);     // Catch: JSONException -> L117
    L151:
        if (r17 == null) goto L153;
        r111.put("user_interrupt", r17.longValue());     // Catch: JSONException -> L117
    L153:
        String r0 = r19;
        if (r0 == null) goto L156;
        r111.put("voice_style", r0);     // Catch: JSONException -> L117
    L156:
        if (r18 == null) goto L158;
        r111.put("is_ai_motion_support", r18.intValue());     // Catch: JSONException -> L117
    L158:
        if (r20 == null) goto L160;
        r111.put("is_avatar_can_drive", r20.intValue());     // Catch: JSONException -> L117
    L160:
        if (r21 == null) goto L162;
        r111.put("is_algorithm_model_downloaded", r21.intValue());     // Catch: JSONException -> L117
    L162:
        String r22 = r23;
        if (r22 == null) goto L165;
        r111.put("scene", r22);     // Catch: JSONException -> L117
    L165:
        String r25 = r24;
        if (r25 == null) goto L168;
        r111.put("dora_mode", r25);     // Catch: JSONException -> L117
    L168:
        if (r310 == null) goto L170;
        r111.put("call_scene", r310);     // Catch: JSONException -> L117
    L170:
        if (r26 == null) goto L172;
        r111.put("is_rtc", r26.intValue());     // Catch: JSONException -> L117
    L172:
        if (r27 == null) goto L176;
        r111.put("is_dora_si", r27.intValue());     // Catch: JSONException -> L117
    L117:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper realtimeCallMessage " + e.getLocalizedMessage());
    L176:
        TrackParams r28 = new TrackParams().merge(r111);
        by7.a r58 = new by7.a("realtime_call_message");
        r58.a.merge(r28);
        r58.b();
        return;
    L178:
        r111.put("reply_id", r110);     // Catch: JSONException -> L117
        goto L119
    L113:
        r310 = r56;
        goto L114
    L109:
        r111 = r55;
        goto L111
    L105:
        r27 = r54;
        goto L107
    L101:
        r26 = r53;
        goto L103
    L97:
        r110 = r52;
        goto L99
    L93:
        r16 = r51;
        goto L95
    L89:
        r24 = r50;
        goto L91
    L85:
        r23 = r49;
        goto L87
    L81:
        r21 = r48;
        goto L83
    L77:
        r20 = r47;
        goto L79
    L73:
        r18 = r46;
        goto L75
    L69:
        r19 = r45;
        goto L71
    L65:
        r17 = r44;
        goto L67
    L61:
        r2 = r43;
        goto L63
    L57:
        r15 = r42;
        goto L59
    L53:
        r14 = r41;
        goto L55
    L49:
        r13 = r40;
        goto L51
    L45:
        r12 = r39;
        goto L47
    L41:
        r11 = r38;
        goto L43
    L37:
        r10 = r37;
        goto L39
    L33:
        r9 = r36;
        goto L35
    L29:
        r8 = r35;
        goto L31
    L25:
        r7 = r34;
        goto L27
    L21:
        r6 = r33;
        goto L23
    L17:
        r5 = r32;
        goto L19
    L13:
        r4 = r31;
        goto L15
    L9:
        r3 = r30;
        goto L11
    L5:
        r1 = r29;
        goto L7
    }
}
