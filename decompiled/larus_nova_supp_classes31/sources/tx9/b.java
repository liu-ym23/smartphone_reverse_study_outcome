package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static void a(String r3, String r4) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r3 != null) goto L14;
    L7:
        r1.put("action_bar_recommend_from", "chat_action_bar");     // Catch: JSONException -> L5
        if (r4 == null) goto L12;
        r1.put("req_id", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarSlide " + e.getLocalizedMessage());
    L12:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r6 = new by7.a("action_bar_slide");
        r6.a.merge(r5);
        r6.b();
        return;
    L14:
        r1.put("bot_id", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void i(String r2, String r3, JSONObject r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r2 != null) goto L22;
    L16:
        if (r3 == null) goto L20;
        r4.put("limited_biz", r3);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper to_limited_toast_show " + e.getLocalizedMessage());
    L20:
        TrackParams r6 = new TrackParams().merge(r4);
        by7.a r7 = new by7.a("to_limited_toast_show");
        r7.a.merge(r6);
        r7.b();
        return;
    L22:
        r4.put("limited_trigger", r2);     // Catch: JSONException -> L14
        goto L16
    }

    public static void c(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L25;
    L7:
        if (r3 == null) goto L9;
        r0.put("chat_type", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L11;
        r0.put("action_bar_template_type", r4);     // Catch: JSONException -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("action_bar_template_id", r5);     // Catch: JSONException -> L5
    L13:
        if (r6 == null) goto L15;
        r0.put("action_bar_key", r6);     // Catch: JSONException -> L5
    L15:
        if (r9 == null) goto L17;
        r0.put("show_position", r9.intValue());     // Catch: JSONException -> L5
    L17:
        if (r7 == null) goto L19;
        r0.put("command_text", r7);     // Catch: JSONException -> L5
    L19:
        if (r8 == null) goto L23;
        r0.put("command_id", r8);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L23:
        TrackParams r10 = new TrackParams().merge(r0);
        by7.a r11 = new by7.a("action_bar_command_click");
        r11.a.merge(r10);
        r11.b();
        return;
    L25:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void d(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L25;
    L7:
        if (r3 == null) goto L9;
        r0.put("chat_type", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L11;
        r0.put("action_bar_template_type", r4);     // Catch: JSONException -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("action_bar_template_id", r5);     // Catch: JSONException -> L5
    L13:
        if (r6 == null) goto L15;
        r0.put("action_bar_key", r6);     // Catch: JSONException -> L5
    L15:
        if (r9 == null) goto L17;
        r0.put("show_position", r9.intValue());     // Catch: JSONException -> L5
    L17:
        if (r7 == null) goto L19;
        r0.put("command_text", r7);     // Catch: JSONException -> L5
    L19:
        if (r8 == null) goto L23;
        r0.put("command_id", r8);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L23:
        TrackParams r10 = new TrackParams().merge(r0);
        by7.a r11 = new by7.a("action_bar_command_show");
        r11.a.merge(r10);
        r11.b();
        return;
    L25:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void h(String r4, Boolean r5, String r6, String r7, Long r8, String r9, String r10, String r11, Long r12) {
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r4 != null) goto L33;
    L7:
        if (r6 == null) goto L9;
        r2.put("bot_id", r6);     // Catch: JSONException -> L5
    L9:
        if (r5 != null) goto L11;
    L15:
        if (r7 == null) goto L17;
        r2.put("req_id", r7);     // Catch: JSONException -> L5
    L17:
        r2.put("action_bar_recommend_from", "chat_action_bar");     // Catch: JSONException -> L5
        if (r8 == null) goto L20;
        r2.put("conversation_id", r8.toString());     // Catch: JSONException -> L5
    L20:
        r2.put("current_page", "chat");     // Catch: JSONException -> L5
        if (r9 == null) goto L23;
        r2.put("previous_page", r9);     // Catch: JSONException -> L5
    L23:
        if (r10 == null) goto L25;
        r2.put("leave_reason", r10);     // Catch: JSONException -> L5
    L25:
        if (r11 == null) goto L27;
        r2.put("leave_action_bar_template_id", r11);     // Catch: JSONException -> L5
    L27:
        if (r12 == null) goto L31;
        r2.put("duration", r12.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L31:
        TrackParams r13 = new TrackParams().merge(r2);
        by7.a r14 = new by7.a("leave_action_bar_board");
        r14.a.merge(r13);
        r14.b();
        return;
    L11:
        if (r5.booleanValue() == false) goto L13;
        int r15 = 1;
    L14:
        r2.put("is_red_dot", r15);     // Catch: JSONException -> L5
        goto L15
    L13:
        r15 = 0;
        goto L14
    L33:
        r2.put("show_from", r4);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, Integer r33, Integer r34, Integer r35, Long r36, Long r37, JSONObject r38, String r39, String r40, String r41, Integer r42, String r43, String r44, Boolean r45, int r46) {
        if ((r46 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r46 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r46 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r46 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r46 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r46 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r46 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r46 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r46 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r46 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r46 & 4096) == 0) goto L53;
        Long r14 = null;
    L55:
        if ((r46 & 8192) == 0) goto L57;
        Long r15 = null;
    L59:
        if ((r46 & 16384) == 0) goto L61;
        JSONObject r2 = new JSONObject();
    L63:
        if ((r46 & 65536) == 0) goto L65;
        String r18 = null;
    L67:
        if ((r46 & 131072) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r46 & 262144) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r46 & 524288) == 0) goto L77;
        Integer r17 = null;
    L79:
        if ((r46 & 1048576) == 0) goto L81;
        String r22 = null;
    L83:
        if ((r46 & 2097152) == 0) goto L85;
        String r23 = null;
    L87:
        if ((r46 & 4194304) == 0) goto L89;
        Boolean r16 = null;
    L90:
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r1 != null) goto L144;
    L95:
        if (r3 == null) goto L97;
        r2.put("chat_type", r3);     // Catch: JSONException -> L93
    L97:
        if (r4 == null) goto L99;
        r2.put("action_bar_template_type", r4);     // Catch: JSONException -> L93
    L99:
        if (r5 == null) goto L101;
        r2.put("action_bar_template_id", r5);     // Catch: JSONException -> L93
    L101:
        if (r6 == null) goto L103;
        r2.put("action_bar_key", r6);     // Catch: JSONException -> L93
    L103:
        if (r13 == null) goto L105;
        r2.put("show_position", r13.intValue());     // Catch: JSONException -> L93
    L105:
        if (r7 == null) goto L107;
        r2.put("option_label", r7);     // Catch: JSONException -> L93
    L107:
        if (r8 == null) goto L109;
        r2.put("option_sub_label", r8);     // Catch: JSONException -> L93
    L109:
        if (r9 == null) goto L111;
        r2.put("option_text", r9);     // Catch: JSONException -> L93
    L111:
        if (r10 == null) goto L113;
        r2.put("option_id", r10);     // Catch: JSONException -> L93
    L113:
        if (r11 == null) goto L115;
        r2.put("is_default", r11.intValue());     // Catch: JSONException -> L93
    L115:
        if (r12 == null) goto L117;
        r2.put("is_choose_required", r12.intValue());     // Catch: JSONException -> L93
    L117:
        if (r14 == null) goto L119;
        r2.put("action_bar_item_id", r14.longValue());     // Catch: JSONException -> L93
    L119:
        if (r15 == null) goto L121;
        r2.put("conversation_id", r15.longValue());     // Catch: JSONException -> L93
    L121:
        String r0 = r18;
        if (r0 == null) goto L124;
        r2.put("action_bar_scene", r0);     // Catch: JSONException -> L93
    L124:
        String r21 = r19;
        if (r21 == null) goto L127;
        r2.put("page_token", r21);     // Catch: JSONException -> L93
    L127:
        String r47 = r20;
        if (r47 == null) goto L130;
        r2.put("artifact_meta_id", r47);     // Catch: JSONException -> L93
    L130:
        if (r17 == null) goto L132;
        r2.put("resource_type", r17.intValue());     // Catch: JSONException -> L93
    L132:
        String r48 = r22;
        if (r48 == null) goto L135;
        r2.put("current_page", r48);     // Catch: JSONException -> L93
    L135:
        if (r16 == null) goto L137;
        r2.put("is_creation_action_bar", r16.booleanValue());     // Catch: JSONException -> L93
    L137:
        String r49 = r23;
        if (r49 == null) goto L142;
        r2.put("previous_page", r49);     // Catch: JSONException -> L93
    L93:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L142:
        TrackParams r50 = new TrackParams().merge(r2);
        by7.a r51 = new by7.a("action_bar_option_show");
        r51.a.merge(r50);
        r51.b();
        return;
    L144:
        r2.put("bot_id", r1);     // Catch: JSONException -> L93
        goto L95
    L89:
        r16 = r45;
        goto L90
    L85:
        r23 = r44;
        goto L87
    L81:
        r22 = r43;
        goto L83
    L77:
        r17 = r42;
        goto L79
    L73:
        r20 = r41;
        goto L75
    L69:
        r19 = r40;
        goto L71
    L65:
        r18 = r39;
        goto L67
    L61:
        r2 = r38;
        goto L63
    L57:
        r15 = r37;
        goto L59
    L53:
        r14 = r36;
        goto L55
    L49:
        r13 = r35;
        goto L51
    L45:
        r12 = r34;
        goto L47
    L41:
        r11 = r33;
        goto L43
    L37:
        r10 = r32;
        goto L39
    L33:
        r9 = r31;
        goto L35
    L29:
        r8 = r30;
        goto L31
    L25:
        r7 = r29;
        goto L27
    L21:
        r6 = r28;
        goto L23
    L17:
        r5 = r27;
        goto L19
    L13:
        r4 = r26;
        goto L15
    L9:
        r3 = r25;
        goto L11
    L5:
        r1 = r24;
        goto L7
    }

    public static void g(String r28, Long r29, String r30, String r31, String r32, String r33, Integer r34, String r35, Integer r36, String r37, by7.e r38, Integer r39, String r40, String r41, Boolean r42, Integer r43, Long r44, String r45, boolean r46, Integer r47, Integer r48, Integer r49, String r50, String r51, String r52, Integer r53, String r54, Boolean r55, int r56) {
        if ((r56 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r56 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r56 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r56 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r56 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r56 & 128) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r56 & 512) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r56 & 1024) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r56 & 2048) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r56 & 4096) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r56 & 8192) == 0) goto L45;
        JSONObject r12 = new JSONObject();
    L47:
        if ((r56 & 16384) == 0) goto L49;
        by7.e r13 = null;
    L51:
        if ((32768 & r56) == 0) goto L53;
        Integer r14 = null;
    L55:
        if ((65536 & r56) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r56 & 131072) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r56 & 262144) == 0) goto L65;
        Boolean r17 = null;
    L67:
        if ((r56 & 524288) == 0) goto L69;
        Integer r18 = null;
    L71:
        if ((r56 & 1048576) == 0) goto L73;
        Long r19 = null;
    L74:
        by7.e r210 = r13;
        if ((r56 & 2097152) == 0) goto L77;
        String r16 = null;
    L79:
        if ((r56 & 8388608) == 0) goto L81;
        Integer r20 = null;
    L83:
        if ((r56 & 16777216) == 0) goto L85;
        Integer r21 = null;
    L87:
        if ((r56 & 33554432) == 0) goto L89;
        Integer r22 = null;
    L91:
        if ((r56 & 67108864) == 0) goto L93;
        String r24 = null;
    L95:
        if ((r56 & 134217728) == 0) goto L97;
        String r25 = null;
    L99:
        if ((r56 & 268435456) == 0) goto L101;
        String r26 = null;
    L103:
        if ((r56 & 536870912) == 0) goto L105;
        Integer r23 = null;
    L106:
        String r211 = r16;
        if ((r56 & 1073741824) == 0) goto L109;
        String r110 = null;
    L111:
        if ((r56 & Integer.MIN_VALUE) == 0) goto L113;
        Boolean r0 = null;
    L114:
        Boolean r310 = r0;
        Intrinsics.checkNotNullParameter(r12, "params");
    L193:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarShow " + e.getLocalizedMessage());
    L195:
        TrackParams r27 = new TrackParams().merge(r12);
        by7.a r57 = new by7.a("chat_action_bar_show");
        if (r210 == null) goto L198;
        r57.b = r210;
    L198:
        r57.a.merge(r27);
        r57.b();
        String r58 = (String) TrackParams.get$default(r57.a, "current_page", null, 2, null);
        if (r58 == null) goto L201;
        r12.put("current_page", r58);
    L201:
        com.larus.platform.service.g.a.monitorEventForSlardar("chat_action_bar_show", r12, new JSONObject(), null);
        return;
    L116:
        if (Intrinsics.areEqual(r9, "coco_message_history") == false) goto L119;
        return;
    L119:
        if (Intrinsics.areEqual(r9, "coco_bot_like") == false) goto L122;
        return;
    L122:
        if (r46 == false) goto L124;
        String r212 = "1";
    L125:
        Integer r311 = r14;
        r12.put("is_tourist_mode", r212);     // Catch: JSONException -> L193
        if (r1 == null) goto L128;
        r12.put("bot_id", r1);     // Catch: JSONException -> L193
    L128:
        if (r3 == null) goto L131;
        r12.put("conversation_id", r3.longValue());     // Catch: JSONException -> L193
    L131:
        if (r4 == null) goto L133;
        r12.put("current_page", r4);     // Catch: JSONException -> L193
    L133:
        if (r5 == null) goto L135;
        r12.put("module_type", r5);     // Catch: JSONException -> L193
    L135:
        if (r6 == null) goto L137;
        r12.put("chat_type", r6);     // Catch: JSONException -> L193
    L137:
        if (r7 == null) goto L139;
        r12.put("req_id", r7);     // Catch: JSONException -> L193
    L139:
        if (r8 == null) goto L141;
        r12.put("template_name", r8.intValue());     // Catch: JSONException -> L193
        r12.put("action_bar_template_id", r8.intValue());     // Catch: JSONException -> L193
    L141:
        if (r15 == null) goto L143;
        r12.put("template_type", r15);     // Catch: JSONException -> L193
        r12.put("action_bar_template_type", r15);     // Catch: JSONException -> L193
    L143:
        if (r110 == null) goto L145;
        r12.put("template_page_type", r110);     // Catch: JSONException -> L193
    L145:
        if (r9 == null) goto L147;
        r12.put("action_name", r9);     // Catch: JSONException -> L193
        r12.put("action_bar_key", r9);     // Catch: JSONException -> L193
    L147:
        if (r10 == 0) goto L149;
        r12.put("is_switch_on", r10.intValue());     // Catch: JSONException -> L193
    L149:
        if (r11 == 0) goto L151;
        r12.put("go_to_url", r11);     // Catch: JSONException -> L193
    L151:
        int r59 = 1;
        if (r311 == null) goto L154;
        r12.put("show_position", r311.intValue() - 1);     // Catch: JSONException -> L193
    L154:
        if (r2 == 0) goto L157;
        r12.put("show_from", r2);     // Catch: JSONException -> L193
    L157:
        if (r17 != null) goto L159;
    L163:
        if (r18 == null) goto L165;
        r12.put("show_position_row", r18.intValue());     // Catch: JSONException -> L193
    L165:
        if (r19 == null) goto L167;
        r12.put("action_bar_item_id", r19.longValue());     // Catch: JSONException -> L193
    L167:
        if (r211 == null) goto L169;
        r12.put("action_bar_recommend_from", r211);     // Catch: JSONException -> L193
    L169:
        if (r20 == null) goto L171;
        r12.put("is_show_keyboard", r20.intValue());     // Catch: JSONException -> L193
    L171:
        if (r21 == null) goto L173;
        r12.put("is_replace_download", r21.intValue());     // Catch: JSONException -> L193
    L173:
        if (r22 == null) goto L175;
        r12.put("is_server_degrade", r22.intValue());     // Catch: JSONException -> L193
    L175:
        String r60 = r24;
        if (r60 == null) goto L178;
        r12.put("action_bar_scene", r60);     // Catch: JSONException -> L193
    L178:
        String r61 = r25;
        if (r61 == null) goto L181;
        r12.put("page_token", r61);     // Catch: JSONException -> L193
    L181:
        String r62 = r26;
        if (r62 == null) goto L184;
        r12.put("artifact_meta_id", r62);     // Catch: JSONException -> L193
    L184:
        if (r23 == null) goto L186;
        r12.put("resource_type", r23.intValue());     // Catch: JSONException -> L193
    L186:
        if (r310 == null) goto L195;
        r310.booleanValue();     // Catch: JSONException -> L193
        if (r310.booleanValue() == true) goto L191;
        r59 = 0;
    L191:
        r12.put("is_first_load", r59);     // Catch: JSONException -> L193
        goto L195
    L159:
        if (r17.booleanValue() == false) goto L161;
        int r63 = 1;
    L162:
        r12.put("is_red_dot", r63);     // Catch: JSONException -> L193
        goto L163
    L161:
        r63 = 0;
        goto L162
    L124:
        r212 = "0";
        goto L125
    L113:
        r0 = r55;
        goto L114
    L109:
        r110 = r54;
        goto L111
    L105:
        r23 = r53;
        goto L106
    L101:
        r26 = r52;
        goto L103
    L97:
        r25 = r51;
        goto L99
    L93:
        r24 = r50;
        goto L95
    L89:
        r22 = r49;
        goto L91
    L85:
        r21 = r48;
        goto L87
    L81:
        r20 = r47;
        goto L83
    L77:
        r16 = r45;
        goto L79
    L73:
        r19 = r44;
        goto L74
    L69:
        r18 = r43;
        goto L71
    L65:
        r17 = r42;
        goto L67
    L61:
        r2 = r41;
        goto L63
    L57:
        r15 = r40;
        goto L59
    L53:
        r14 = r39;
        goto L55
    L49:
        r13 = r38;
        goto L51
    L45:
        r12 = null;
        goto L47
    L41:
        r11 = r37;
        goto L43
    L37:
        r10 = r36;
        goto L39
    L33:
        r9 = r35;
        goto L35
    L29:
        r8 = r34;
        goto L31
    L25:
        r7 = r33;
        goto L27
    L21:
        r6 = r32;
        goto L23
    L17:
        r5 = r31;
        goto L19
    L13:
        r4 = r30;
        goto L15
    L9:
        r3 = r29;
        goto L11
    L5:
        r1 = r28;
        goto L7
    }

    public static void b(String r29, Long r30, Long r31, String r32, String r33, String r34, String r35, Integer r36, String r37, Integer r38, String r39, by7.e r40, String r41, String r42, String r43, Boolean r44, Boolean r45, Integer r46, Integer r47, Long r48, String r49, boolean r50, Integer r51, Integer r52, String r53, String r54, String r55, Integer r56, String r57, String r58, int r59, int r60) {
        if ((r59 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r59 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r59 & 4) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r59 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r59 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r59 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r59 & 256) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r59 & 1024) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r59 & 2048) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r59 & 4096) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r59 & 8192) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r59 & 16384) == 0) goto L49;
        JSONObject r13 = new JSONObject();
    L51:
        if ((32768 & r59) == 0) goto L53;
        by7.e r14 = null;
    L55:
        if ((65536 & r59) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r59 & 131072) == 0) goto L61;
        String r2 = null;
    L62:
        by7.e r210 = r14;
        if ((r59 & 262144) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r59 & 524288) == 0) goto L69;
        Boolean r17 = null;
    L71:
        if ((r59 & 1048576) == 0) goto L73;
        Boolean r18 = null;
    L75:
        if ((r59 & 2097152) == 0) goto L77;
        Integer r19 = null;
    L79:
        if ((r59 & 4194304) == 0) goto L81;
        Integer r20 = null;
    L83:
        if ((r59 & 8388608) == 0) goto L85;
        Long r21 = null;
    L87:
        if ((r59 & 16777216) == 0) goto L89;
        String r23 = null;
    L91:
        if ((r59 & 67108864) == 0) goto L93;
        Integer r22 = null;
    L95:
        if ((r59 & 134217728) == 0) goto L97;
        Integer r24 = null;
    L99:
        if ((r59 & 268435456) == 0) goto L101;
        String r26 = null;
    L103:
        if ((r59 & 536870912) == 0) goto L105;
        String r27 = null;
    L107:
        if ((r59 & 1073741824) == 0) goto L109;
        String r28 = null;
    L111:
        if ((r59 & Integer.MIN_VALUE) == 0) goto L113;
        Integer r0 = null;
    L114:
        Integer r310 = r0;
        if ((r60 & 1) == 0) goto L117;
        String r25 = null;
    L119:
        if ((r60 & 2) == 0) goto L121;
        String r311 = null;
    L122:
        Intrinsics.checkNotNullParameter(r13, "params");
    L194:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
    L196:
        TrackParams r61 = new TrackParams().merge(r13);
        by7.a r62 = new by7.a("chat_action_bar_click");
        if (r210 == null) goto L199;
        r62.b = r210;
    L199:
        r62.a.merge(r61);
        r62.b();
        return;
    L124:
        if (Intrinsics.areEqual(r10, "coco_message_history") == false) goto L127;
        return;
    L127:
        if (r50 == false) goto L129;
        String r110 = "1";
    L130:
        String r312 = r15;
        r13.put("is_tourist_mode", r110);     // Catch: JSONException -> L194
        if (r1 == null) goto L133;
        r13.put("bot_id", r1);     // Catch: JSONException -> L194
    L133:
        if (r3 == null) goto L135;
        r13.put("click_position", r3.longValue());     // Catch: JSONException -> L194
    L135:
        if (r4 == null) goto L137;
        r13.put("conversation_id", r4.longValue());     // Catch: JSONException -> L194
    L137:
        if (r5 == null) goto L139;
        r13.put("current_page", r5);     // Catch: JSONException -> L194
    L139:
        if (r6 == null) goto L141;
        r13.put("module_type", r6);     // Catch: JSONException -> L194
    L141:
        if (r7 == null) goto L143;
        r13.put("chat_type", r7);     // Catch: JSONException -> L194
    L143:
        if (r25 == null) goto L145;
        r13.put("camera_status", r25);     // Catch: JSONException -> L194
    L145:
        if (r8 == null) goto L147;
        r13.put("req_id", r8);     // Catch: JSONException -> L194
    L147:
        if (r9 == null) goto L149;
        r13.put("template_name", r9.intValue());     // Catch: JSONException -> L194
        r13.put("action_bar_template_id", r9.intValue());     // Catch: JSONException -> L194
    L149:
        if (r10 == null) goto L151;
        r13.put("action_name", r10);     // Catch: JSONException -> L194
        r13.put("action_bar_key", r10);     // Catch: JSONException -> L194
    L151:
        if (r11 == null) goto L153;
        r13.put("is_switch_on", r11.intValue());     // Catch: JSONException -> L194
    L153:
        if (r12 == null) goto L155;
        r13.put("go_to_url", r12);     // Catch: JSONException -> L194
    L155:
        if (r2 == null) goto L157;
        r13.put("show_from", r2);     // Catch: JSONException -> L194
    L157:
        if (r312 == null) goto L159;
        r13.put("template_type", r312);     // Catch: JSONException -> L194
        r13.put("action_bar_template_type", r312);     // Catch: JSONException -> L194
    L159:
        if (r311 == null) goto L161;
        r13.put("template_page_type", r311);     // Catch: JSONException -> L194
    L161:
        if (r16 == 0) goto L164;
        r13.put("click_from", r16);     // Catch: JSONException -> L194
    L164:
        if (r17 == null) goto L166;
        r13.put("is_has_replica", r17.booleanValue() ? 1 : 0);     // Catch: JSONException -> L194
    L167:
        if (r18 == null) goto L169;
        r13.put("is_red_dot", r18.booleanValue() ? 1 : 0);     // Catch: JSONException -> L194
    L169:
        if (r19 == null) goto L171;
        r13.put("show_position_row", r19.intValue());     // Catch: JSONException -> L194
    L171:
        if (r20 == null) goto L173;
        r13.put("show_position", r20.intValue() - 1);     // Catch: JSONException -> L194
    L173:
        if (r21 == null) goto L175;
        r13.put("action_bar_item_id", r21.longValue());     // Catch: JSONException -> L194
    L175:
        String r63 = r23;
        if (r63 == null) goto L178;
        r13.put("action_bar_recommend_from", r63);     // Catch: JSONException -> L194
    L178:
        if (r22 == null) goto L180;
        r13.put("is_show_keyboard", r22.intValue());     // Catch: JSONException -> L194
    L180:
        if (r24 == null) goto L182;
        r13.put("is_replace_download", r24.intValue());     // Catch: JSONException -> L194
    L182:
        String r64 = r26;
        if (r64 == null) goto L185;
        r13.put("action_bar_scene", r64);     // Catch: JSONException -> L194
    L185:
        String r65 = r27;
        if (r65 == null) goto L188;
        r13.put("page_token", r65);     // Catch: JSONException -> L194
    L188:
        String r66 = r28;
        if (r66 == null) goto L191;
        r13.put("artifact_meta_id", r66);     // Catch: JSONException -> L194
    L191:
        if (r310 == null) goto L196;
        r13.put("resource_type", r310.intValue());     // Catch: JSONException -> L194
        goto L196
    L166:
        r13.put("is_has_replica", 0);     // Catch: JSONException -> L194
        goto L167
    L129:
        r110 = "0";
        goto L130
    L121:
        r311 = r58;
        goto L122
    L117:
        r25 = r57;
        goto L119
    L113:
        r0 = r56;
        goto L114
    L109:
        r28 = r55;
        goto L111
    L105:
        r27 = r54;
        goto L107
    L101:
        r26 = r53;
        goto L103
    L97:
        r24 = r52;
        goto L99
    L93:
        r22 = r51;
        goto L95
    L89:
        r23 = r49;
        goto L91
    L85:
        r21 = r48;
        goto L87
    L81:
        r20 = r47;
        goto L83
    L77:
        r19 = r46;
        goto L79
    L73:
        r18 = r45;
        goto L75
    L69:
        r17 = r44;
        goto L71
    L65:
        r16 = r43;
        goto L67
    L61:
        r2 = r42;
        goto L62
    L57:
        r15 = r41;
        goto L59
    L53:
        r14 = r40;
        goto L55
    L49:
        r13 = null;
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

    public static void e(String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, Integer r46, Integer r47, Integer r48, String r49, String r50, Long r51, Long r52, JSONObject r53, String r54, String r55, String r56, String r57, Integer r58, String r59, String r60, Boolean r61, String r62, Boolean r63, Boolean r64, String r65, String r66, String r67, String r68, Integer r69, Integer r70, String r71, String r72, String r73, int r74, int r75) {
        if ((r74 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r74 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r74 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r74 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r74 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r74 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r74 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r74 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r74 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r74 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r74 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r74 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r74 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r74 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r74 & 16384) == 0) goto L61;
        Long r2 = null;
    L63:
        if ((r74 & 32768) == 0) goto L65;
        Long r16 = null;
    L67:
        if ((r74 & 65536) == 0) goto L69;
        JSONObject r17 = new JSONObject();
    L71:
        if ((r74 & 262144) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r74 & 524288) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r74 & 1048576) == 0) goto L81;
        String r20 = null;
    L83:
        if ((r74 & 2097152) == 0) goto L85;
        String r21 = null;
    L87:
        if ((r74 & 4194304) == 0) goto L89;
        Integer r110 = null;
    L91:
        if ((r74 & 8388608) == 0) goto L93;
        String r23 = null;
    L95:
        if ((r74 & 16777216) == 0) goto L97;
        String r24 = null;
    L99:
        if ((r74 & 33554432) == 0) goto L101;
        Boolean r22 = null;
    L103:
        if ((r74 & 67108864) == 0) goto L105;
        String r26 = null;
    L107:
        if ((r74 & 134217728) == 0) goto L109;
        Boolean r25 = null;
    L111:
        if ((r74 & 536870912) == 0) goto L113;
        Boolean r27 = null;
    L115:
        if ((r74 & 1073741824) == 0) goto L117;
        String r29 = null;
    L119:
        if ((r74 & Integer.MIN_VALUE) == 0) goto L121;
        String r0 = null;
    L123:
        if ((r75 & 1) == 0) goto L125;
        String r30 = null;
    L127:
        if ((r75 & 2) == 0) goto L129;
        String r31 = null;
    L131:
        if ((r75 & 4) == 0) goto L133;
        Integer r28 = null;
    L135:
        if ((r75 & 8) == 0) goto L137;
        Integer r32 = null;
    L139:
        if ((r75 & 16) == 0) goto L141;
        String r34 = null;
    L143:
        if ((r75 & 32) == 0) goto L145;
        String r35 = null;
    L147:
        if ((r75 & 64) == 0) goto L149;
        String r36 = null;
    L150:
        Intrinsics.checkNotNullParameter(r17, "params");
        if (r1 != null) goto L240;
    L155:
        if (r3 == null) goto L157;
        r17.put("chat_type", r3);     // Catch: JSONException -> L153
    L157:
        if (r4 == null) goto L159;
        r17.put("action_bar_template_type", r4);     // Catch: JSONException -> L153
    L159:
        if (r5 == null) goto L161;
        r17.put("action_bar_template_id", r5);     // Catch: JSONException -> L153
    L161:
        if (r6 == null) goto L163;
        r17.put("action_bar_key", r6);     // Catch: JSONException -> L153
    L163:
        if (r13 == null) goto L165;
        r17.put("show_position", r13.intValue());     // Catch: JSONException -> L153
    L165:
        if (r7 == null) goto L167;
        r17.put("option_label", r7);     // Catch: JSONException -> L153
    L167:
        if (r8 == null) goto L169;
        r17.put("option_sub_label", r8);     // Catch: JSONException -> L153
    L169:
        if (r9 == null) goto L171;
        r17.put("option_text", r9);     // Catch: JSONException -> L153
    L171:
        if (r10 == null) goto L173;
        r17.put("option_id", r10);     // Catch: JSONException -> L153
    L173:
        if (r11 == null) goto L175;
        r17.put("is_default", r11.intValue());     // Catch: JSONException -> L153
    L175:
        if (r12 == null) goto L177;
        r17.put("is_choose_required", r12.intValue());     // Catch: JSONException -> L153
    L177:
        if (r14 == null) goto L179;
        r17.put("action_type", r14);     // Catch: JSONException -> L153
    L179:
        if (r15 == null) goto L181;
        r17.put("to_status", r15);     // Catch: JSONException -> L153
    L181:
        String r33 = r18;
        if (r33 == null) goto L184;
        r17.put("option_source", r33);     // Catch: JSONException -> L153
    L184:
        if (r2 == 0) goto L186;
        r17.put("action_bar_item_id", r2.longValue());     // Catch: JSONException -> L153
    L186:
        if (r16 == null) goto L188;
        r17.put("conversation_id", r16.longValue());     // Catch: JSONException -> L153
    L188:
        String r76 = r19;
        if (r76 == null) goto L191;
        r17.put("action_bar_scene", r76);     // Catch: JSONException -> L153
    L191:
        String r77 = r20;
        if (r77 == null) goto L194;
        r17.put("page_token", r77);     // Catch: JSONException -> L153
    L194:
        String r78 = r21;
        if (r78 == null) goto L197;
        r17.put("artifact_meta_id", r78);     // Catch: JSONException -> L153
    L197:
        if (r110 == null) goto L199;
        r17.put("resource_type", r110.intValue());     // Catch: JSONException -> L153
    L199:
        String r79 = r23;
        if (r79 == null) goto L202;
        r17.put("current_page", r79);     // Catch: JSONException -> L153
    L202:
        String r80 = r24;
        if (r80 == null) goto L205;
        r17.put("previous_page", r80);     // Catch: JSONException -> L153
    L205:
        if (r22 == null) goto L207;
        r17.put("is_creation_action_bar", r22.booleanValue());     // Catch: JSONException -> L153
    L207:
        String r81 = r26;
        if (r81 == null) goto L210;
        r17.put("click_method", r81);     // Catch: JSONException -> L153
    L210:
        if (r25 == null) goto L212;
        r17.put("is_custom_model", r25.booleanValue());     // Catch: JSONException -> L153
    L212:
        if (r27 == null) goto L214;
        r17.put("is_folded", r27.booleanValue());     // Catch: JSONException -> L153
    L214:
        String r82 = r29;
        if (r82 == null) goto L217;
        r17.put("model_item_key", r82);     // Catch: JSONException -> L153
    L217:
        if (r0 == 0) goto L219;
        r17.put("click_from", r0);     // Catch: JSONException -> L153
    L219:
        String r83 = r30;
        if (r83 == null) goto L222;
        r17.put("option_type", r83);     // Catch: JSONException -> L153
    L222:
        String r84 = r31;
        if (r84 == null) goto L225;
        r17.put("mode_id", r84);     // Catch: JSONException -> L153
    L225:
        if (r28 == null) goto L227;
        r17.put("agent_mode", r28.intValue());     // Catch: JSONException -> L153
    L227:
        if (r32 == null) goto L229;
        r17.put("reasoning_effort", r32.intValue());     // Catch: JSONException -> L153
    L229:
        String r85 = r34;
        if (r85 == null) goto L232;
        r17.put("computer_type", r85);     // Catch: JSONException -> L153
    L232:
        String r86 = r35;
        if (r86 == null) goto L235;
        r17.put("computer_status", r86);     // Catch: JSONException -> L153
    L235:
        r17.putOpt("is_current_device", r36);     // Catch: JSONException -> L153
    L238:
        TrackParams r87 = new TrackParams().merge(r17);
        by7.a r88 = new by7.a("action_bar_option_click");
        r88.a.merge(r87);
        r88.b();
        return;
    L153:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarClick " + e.getLocalizedMessage());
        goto L238
    L240:
        r17.put("bot_id", r1);     // Catch: JSONException -> L153
        goto L155
    L149:
        r36 = r73;
        goto L150
    L145:
        r35 = r72;
        goto L147
    L141:
        r34 = r71;
        goto L143
    L137:
        r32 = r70;
        goto L139
    L133:
        r28 = r69;
        goto L135
    L129:
        r31 = r68;
        goto L131
    L125:
        r30 = r67;
        goto L127
    L121:
        r0 = r66;
        goto L123
    L117:
        r29 = r65;
        goto L119
    L113:
        r27 = r64;
        goto L115
    L109:
        r25 = r63;
        goto L111
    L105:
        r26 = r62;
        goto L107
    L101:
        r22 = r61;
        goto L103
    L97:
        r24 = r60;
        goto L99
    L93:
        r23 = r59;
        goto L95
    L89:
        r110 = r58;
        goto L91
    L85:
        r21 = r57;
        goto L87
    L81:
        r20 = r56;
        goto L83
    L77:
        r19 = r55;
        goto L79
    L73:
        r18 = r54;
        goto L75
    L69:
        r17 = r53;
        goto L71
    L65:
        r16 = r52;
        goto L67
    L61:
        r2 = r51;
        goto L63
    L57:
        r15 = r50;
        goto L59
    L53:
        r14 = r49;
        goto L55
    L49:
        r13 = r48;
        goto L51
    L45:
        r12 = r47;
        goto L47
    L41:
        r11 = r46;
        goto L43
    L37:
        r10 = r45;
        goto L39
    L33:
        r9 = r44;
        goto L35
    L29:
        r8 = r43;
        goto L31
    L25:
        r7 = r42;
        goto L27
    L21:
        r6 = r41;
        goto L23
    L17:
        r5 = r40;
        goto L19
    L13:
        r4 = r39;
        goto L15
    L9:
        r3 = r38;
        goto L11
    L5:
        r1 = r37;
        goto L7
    }
}
