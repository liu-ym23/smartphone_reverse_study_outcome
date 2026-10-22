package tx9;

import android.text.TextUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.platform.api.creation.TplTagType;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a1 {
    public static String a = "";
    public static String b = "";

    public static void d(String r2, String r3, String r4, String r5, int r6) {
        JSONObject r1 = null;
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r6 & 16) == 0) goto L17;
        r1 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L32;
    L22:
        if (r3 == null) goto L24;
        r1.put("enter_method", r3);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L26;
        r1.put("previous_page", r4);     // Catch: JSONException -> L20
    L26:
        if (r5 == null) goto L30;
        r1.put(TplTagType.STYLE, r5);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("EnterEventHelper", "error in EnterEventHelper enterVideoPlayer " + e.getLocalizedMessage());
    L30:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r8 = new by7.a("enter_video_player");
        r8.a.merge(r7);
        r8.b();
        return;
    L32:
        r1.put("current_page", r2);     // Catch: JSONException -> L20
        goto L22
    }

    public static void b(String r17, String r18, String r19, String r20, String r21, Integer r22, String r23, String r24, String r25, String r26, Integer r27, JSONObject r28, Long r29, String r30, Long r31, int r32) {
        Long r2 = null;
        if ((r32 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r32 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r32 & 32) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r32 & 64) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r32 & 2048) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r32 & 4096) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r32 & 8192) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r32 & 16384) == 0) goto L41;
        String r11 = null;
    L43:
        if ((32768 & r32) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((65536 & r32) == 0) goto L49;
        JSONObject r13 = new JSONObject();
    L51:
        if ((262144 & r32) == 0) goto L53;
        Long r14 = null;
    L55:
        if ((524288 & r32) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r32 & 1048576) != 0) goto L62;
        r2 = r31;
    L62:
        Intrinsics.checkNotNullParameter(r13, "params");
        if (r1 != null) goto L102;
    L67:
        if (r3 == null) goto L69;
        r13.put("call_id", r3);     // Catch: JSONException -> L65
    L69:
        if (r4 == null) goto L71;
        r13.put("conversation_id", r4);     // Catch: JSONException -> L65
    L71:
        if (r5 == null) goto L73;
        r13.put("fail_reason", r5);     // Catch: JSONException -> L65
    L73:
        if (r6 == null) goto L80;
        r13.put("success", r6);     // Catch: JSONException -> L65
        if (Intrinsics.areEqual(r6, "1") == true) goto L78;
        r13.put("status", 1);     // Catch: JSONException -> L65
        goto L80
    L78:
        r13.put("status", 0);     // Catch: JSONException -> L65
    L80:
        if (r7 == null) goto L82;
        r13.put("session_status", r7.intValue());     // Catch: JSONException -> L65
    L82:
        if (r8 == null) goto L84;
        r13.put("enter_method", r8);     // Catch: JSONException -> L65
    L84:
        if (r9 == null) goto L86;
        r13.put("voice_id", r9);     // Catch: JSONException -> L65
    L86:
        if (r10 == null) goto L88;
        r13.put("speaker_id", r10);     // Catch: JSONException -> L65
    L88:
        if (r11 == null) goto L90;
        r13.put("speaker_name", r11);     // Catch: JSONException -> L65
    L90:
        if (r12 == null) goto L92;
        r13.put("error_code", r12.intValue());     // Catch: JSONException -> L65
    L92:
        if (r14 == null) goto L94;
        r13.put("duration", r14.longValue());     // Catch: JSONException -> L65
    L94:
        if (r15 == null) goto L96;
        r13.put("scene", r15);     // Catch: JSONException -> L65
    L96:
        if (r2 == null) goto L100;
        r13.put("pseudo_duration", r2.longValue());     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.a.e("EnterEventHelper", "error in EnterEventHelper enterCallStatus " + e.getLocalizedMessage());
    L100:
        TrackParams r0 = new TrackParams().merge(r13);
        by7.a r16 = new by7.a("flow_vui_conversation_start");
        r16.a.merge(r0);
        r16.b();
        return;
    L102:
        r13.put("bot_id", r1);     // Catch: JSONException -> L65
        goto L67
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }

    public static void a(String r25, String r26, String r27, String r28, String r29, Integer r30, String r31, String r32, String r33, String r34, String r35, Integer r36, String r37, JSONObject r38, Long r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, Long r47, int r48) {
        if ((r48 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r48 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r48 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r48 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r48 & 32) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r48 & 64) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r48 & 2048) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r48 & 4096) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r48 & 8192) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r48 & 16384) == 0) goto L41;
        String r11 = null;
    L43:
        if ((32768 & r48) == 0) goto L45;
        String r12 = null;
    L47:
        if ((65536 & r48) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((131072 & r48) == 0) goto L53;
        String r14 = null;
    L55:
        if ((262144 & r48) == 0) goto L57;
        JSONObject r15 = new JSONObject();
    L59:
        if ((r48 & 1048576) == 0) goto L61;
        Long r16 = 0L;
    L63:
        if ((r48 & 2097152) == 0) goto L65;
        String r2 = null;
    L67:
        if ((r48 & 4194304) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r48 & 8388608) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r48 & 16777216) == 0) goto L77;
        String r21 = null;
    L79:
        if ((r48 & 33554432) == 0) goto L81;
        String r22 = null;
    L83:
        if ((r48 & 67108864) == 0) goto L85;
        String r23 = null;
    L87:
        if ((r48 & 134217728) == 0) goto L89;
        String r24 = null;
    L91:
        if ((r48 & 268435456) == 0) goto L93;
        Long r210 = null;
    L94:
        Intrinsics.checkNotNullParameter(r15, "params");
        if (r1 != null) goto L151;
    L99:
        if (r3 == null) goto L101;
        r15.put("call_id", r3);     // Catch: JSONException -> L97
    L101:
        if (r4 == null) goto L103;
        r15.put("conversation_id", r4);     // Catch: JSONException -> L97
    L103:
        if (r5 == null) goto L105;
        r15.put("fail_reason", r5);     // Catch: JSONException -> L97
    L105:
        if (r6 == null) goto L107;
        r15.put("success", r6);     // Catch: JSONException -> L97
    L107:
        if (r7 == null) goto L109;
        r15.put("session_status", r7.intValue());     // Catch: JSONException -> L97
    L109:
        if (r8 == null) goto L111;
        r15.put("enter_method", r8);     // Catch: JSONException -> L97
    L111:
        if (r9 == null) goto L113;
        r15.put("current_page", r9);     // Catch: JSONException -> L97
    L113:
        if (r10 == null) goto L115;
        r15.put("voice_id", r10);     // Catch: JSONException -> L97
    L115:
        if (r11 == null) goto L117;
        r15.put("speaker_id", r11);     // Catch: JSONException -> L97
    L117:
        if (r12 == null) goto L119;
        r15.put("speaker_name", r12);     // Catch: JSONException -> L97
    L119:
        if (r13 == null) goto L121;
        r15.put("error_code", r13.intValue());     // Catch: JSONException -> L97
    L121:
        if (r16 == null) goto L123;
        r15.put("duration", r16.longValue());     // Catch: JSONException -> L97
    L123:
        if (r14 == null) goto L125;
        r15.put("is_immersive_background", r14);     // Catch: JSONException -> L97
    L125:
        if (r2 == null) goto L127;
        r15.put("is_continuous_speak", r2);     // Catch: JSONException -> L97
    L127:
        String r0 = r19;
        if (r0 == null) goto L130;
        r15.put("is_obric_continuous_talk", r0);     // Catch: JSONException -> L97
    L130:
        String r17 = r20;
        if (r17 == null) goto L133;
        r15.put("avatar", r17);     // Catch: JSONException -> L97
    L133:
        String r18 = r21;
        if (r18 == null) goto L136;
        r15.put("chat_type", r18);     // Catch: JSONException -> L97
    L136:
        String r49 = r22;
        if (r49 == null) goto L139;
        r15.put("action_bar_key", r49);     // Catch: JSONException -> L97
    L139:
        String r50 = r23;
        if (r50 == null) goto L142;
        r15.put("action_bar_item_id", r50);     // Catch: JSONException -> L97
    L142:
        String r51 = r24;
        if (r51 == null) goto L145;
        r15.put("call_scene", r51);     // Catch: JSONException -> L97
    L145:
        if (r210 == null) goto L149;
        r15.put("pseudo_duration", r210.longValue());     // Catch: JSONException -> L97
    L97:
        e = move-exception;
        FLogger.a.e("EnterEventHelper", "error in EnterEventHelper enterCallStatus " + e.getLocalizedMessage());
    L149:
        TrackParams r52 = new TrackParams().merge(r15);
        by7.a r53 = new by7.a("enter_call_status");
        r53.a.merge(r52);
        r53.b();
        com.larus.platform.service.g.a.monitorEventForSlardar("enter_call_status", r53.c(), null, null);
        return;
    L151:
        r15.put("bot_id", r1);     // Catch: JSONException -> L97
        goto L99
    L93:
        r210 = r47;
        goto L94
    L89:
        r24 = r46;
        goto L91
    L85:
        r23 = r45;
        goto L87
    L81:
        r22 = r44;
        goto L83
    L77:
        r21 = r43;
        goto L79
    L73:
        r20 = r42;
        goto L75
    L69:
        r19 = r41;
        goto L71
    L65:
        r2 = r40;
        goto L67
    L61:
        r16 = r39;
        goto L63
    L57:
        r15 = r38;
        goto L59
    L53:
        r14 = r37;
        goto L55
    L49:
        r13 = r36;
        goto L51
    L45:
        r12 = r35;
        goto L47
    L41:
        r11 = r34;
        goto L43
    L37:
        r10 = r33;
        goto L39
    L33:
        r9 = r32;
        goto L35
    L29:
        r8 = r31;
        goto L31
    L25:
        r7 = r30;
        goto L27
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r28;
        goto L19
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r25;
        goto L7
    }

    public static void c(String r43, Integer r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, Long r56, String r57, String r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, String r69, String r70, String r71, String r72, String r73, String r74, String r75, String r76, Integer r77, String r78, String r79, String r80, String r81, String r82, String r83, String r84, Integer r85, JSONObject r86, by7.e r87, String r88, String r89, String r90, String r91, String r92, String r93, Boolean r94, int r95, int r96, int r97) {
        if ((r95 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r95 & 8) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r95 & 16) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r95 & 32) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r95 & 64) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r95 & 128) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r95 & 256) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r95 & 512) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r95 & 1024) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r95 & 2048) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r95 & 16384) == 0) goto L45;
        String r13 = null;
    L47:
        if ((32768 & r95) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r95 & 65536) == 0) goto L53;
        String r17 = null;
    L55:
        if ((r95 & 131072) == 0) goto L57;
        Long r18 = null;
    L59:
        if ((r95 & 262144) == 0) goto L61;
        String r21 = null;
    L63:
        if ((r95 & 524288) == 0) goto L65;
        String r23 = null;
    L67:
        if ((r95 & 1048576) == 0) goto L69;
        String r25 = null;
    L71:
        if ((r95 & 16777216) == 0) goto L73;
        String r27 = null;
    L75:
        if ((r95 & 33554432) == 0) goto L77;
        String r29 = null;
    L79:
        if ((r95 & 67108864) == 0) goto L81;
        String r31 = null;
    L83:
        if ((r95 & Integer.MIN_VALUE) == 0) goto L85;
        String r0 = null;
    L87:
        if ((r96 & 1) == 0) goto L89;
        String r33 = null;
    L91:
        if ((r96 & 2) == 0) goto L93;
        String r34 = null;
    L95:
        if ((r96 & 4) == 0) goto L97;
        String r35 = null;
    L99:
        if ((r96 & 8) == 0) goto L101;
        String r36 = null;
    L103:
        if ((r96 & 16) == 0) goto L105;
        String r37 = "0";
    L107:
        if ((r96 & 32) == 0) goto L109;
        String r410 = "1";
    L111:
        if ((r96 & 64) == 0) goto L113;
        String r38 = null;
    L115:
        if ((r96 & 128) == 0) goto L117;
        String r3 = null;
    L119:
        if ((r96 & 256) == 0) goto L121;
        String r15 = null;
    L122:
        String r411 = r3;
        if ((r96 & 512) == 0) goto L125;
        String r16 = null;
    L126:
        String r412 = r16;
        if ((r96 & 1024) == 0) goto L129;
        String r19 = null;
    L130:
        String r413 = r19;
        if ((r96 & 2048) == 0) goto L133;
        String r20 = null;
    L134:
        String r414 = r20;
        if ((r96 & 4096) == 0) goto L137;
        String r22 = null;
    L138:
        String r415 = r22;
        if ((r96 & 8192) == 0) goto L141;
        Integer r24 = null;
    L142:
        Integer r510 = r24;
        if ((r96 & 16384) == 0) goto L145;
        String r26 = null;
    L146:
        String r416 = r15;
        if ((r96 & 65536) == 0) goto L149;
        String r110 = null;
    L150:
        String r511 = r0;
        if ((r96 & 131072) == 0) goto L153;
        String r1 = null;
    L155:
        if ((r96 & 262144) == 0) goto L157;
        String r40 = null;
    L159:
        if ((r96 & 524288) == 0) goto L161;
        String r512 = "";
    L163:
        if ((r96 & 1048576) == 0) goto L165;
        String r28 = "";
    L166:
        String r513 = r14;
        if ((r96 & 2097152) == 0) goto L169;
        String r111 = "";
    L171:
        if ((r96 & 4194304) == 0) goto L173;
        Integer r210 = null;
    L175:
        if ((r96 & 8388608) == 0) goto L177;
        JSONObject r112 = new JSONObject();
    L179:
        if ((r96 & 16777216) == 0) goto L181;
        by7.e r41 = null;
    L183:
        if ((r96 & 33554432) == 0) goto L185;
        String r514 = "";
    L187:
        if ((r96 & 67108864) == 0) goto L189;
        Object r113 = "";
    L191:
        if ((r96 & 134217728) == 0) goto L193;
        Object r114 = "";
    L195:
        if ((r96 & 268435456) == 0) goto L197;
        String r515 = null;
    L199:
        if ((r96 & 536870912) == 0) goto L201;
        String r516 = null;
    L203:
        if ((r96 & 1073741824) == 0) goto L205;
        String r517 = null;
    L207:
        if ((r96 & Integer.MIN_VALUE) == 0) goto L209;
        String r30 = null;
    L211:
        if ((r97 & 2) == 0) goto L213;
        String r518 = null;
    L215:
        if ((r97 & 4) == 0) goto L217;
        Boolean r211 = null;
    L218:
        String r212 = r10;
        Intrinsics.checkNotNullParameter(r28, "presentationId");
        Intrinsics.checkNotNullParameter(r111, "resourceId");
        Intrinsics.checkNotNullParameter(r112, "params");
        r112.putOpt("is_associated", r114);     // Catch: JSONException -> L241
        r112.putOpt("template_page_type", r1);     // Catch: JSONException -> L241
        r112.putOpt("action_bar_key", null);     // Catch: JSONException -> L241
        if (r113 == null) goto L222;
        r112.put("lottery_round_type", r113);     // Catch: JSONException -> L241
    L222:
        if (r26 == null) goto L224;
        r112.put("action_bar_template_id", r26);     // Catch: JSONException -> L241
    L224:
        if (r110 == null) goto L226;
        r112.put("action_bar_template_type", r110);     // Catch: JSONException -> L241
    L226:
        r112.putOpt("template_page_type", r1);     // Catch: JSONException -> L241
        if (r2 == null) goto L229;
        r112.put("bot_id", r2);     // Catch: JSONException -> L241
    L229:
        if (r4 == null) goto L231;
        r112.put("bot_type", r4.intValue());     // Catch: JSONException -> L241
    L231:
        if (r5 == null) goto L233;
        r112.put("bot_position", r5);     // Catch: JSONException -> L241
    L233:
        if (r6 == null) goto L235;
        r112.put("chat_type", r6);     // Catch: JSONException -> L241
    L235:
        if (r7 == null) goto L237;
        r112.put("conversation_id", r7);     // Catch: JSONException -> L241
    L237:
        if (r8 == null) goto L239;
        r112.put("current_page", r8);     // Catch: JSONException -> L241
        a = r8;     // Catch: JSONException -> L241
    L239:
        if (r212 == null) goto L243;
        r112.put("enter_from", r212);     // Catch: JSONException -> L241
    L243:
        if (r11 == 0) goto L245;
        r112.put("enter_method", r11);     // Catch: JSONException -> L241
    L245:
        if (r12 == 0) goto L247;
        r112.put("group_type", r12);     // Catch: JSONException -> L241
    L247:
        if (r13 == 0) goto L249;
        r112.put("is_from_ug", r13);     // Catch: JSONException -> L241
    L249:
        if (r513 == null) goto L251;
        r112.put("is_immersive_background", r513);     // Catch: JSONException -> L241
    L251:
        String r32 = r17;
        if (r32 == null) goto L254;
        r112.put("is_immersive_background_dynamic", r32);     // Catch: JSONException -> L241
    L254:
        if (r18 == null) goto L256;
        r112.put("is_tts", r18.longValue());     // Catch: JSONException -> L241
    L256:
        String r39 = r21;
        if (r39 == null) goto L259;
        r112.put("landing_tab", r39);     // Catch: JSONException -> L241
    L259:
        String r42 = r23;
        if (r42 == null) goto L262;
        r112.put("page", r42);     // Catch: JSONException -> L241
    L262:
        String r98 = r25;
        if (r98 == null) goto L265;
        r112.put("previous_page", r98);     // Catch: JSONException -> L241
        b = r98;     // Catch: JSONException -> L241
    L265:
        String r99 = r27;
        if (r99 == null) goto L268;
        r112.put("recommend_from", r99);     // Catch: JSONException -> L241
    L268:
        String r100 = r35;
        if (r100 == null) goto L271;
        r112.put("open_method", r100);     // Catch: JSONException -> L241
    L271:
        String r101 = r29;
        if (r101 == null) goto L274;
        r112.put("req_id", r101);     // Catch: JSONException -> L241
    L274:
        String r102 = r31;
        if (r102 == null) goto L277;
        r112.put("request_id", r102);     // Catch: JSONException -> L241
    L277:
        if (r9 == 0) goto L279;
        r112.put("current_tab", r9);     // Catch: JSONException -> L241
    L279:
        if (r511 == null) goto L281;
        r112.put("create_way", r511);     // Catch: JSONException -> L241
    L281:
        String r103 = r33;
        if (r103 == null) goto L284;
        r112.put("from_activity_name", r103);     // Catch: JSONException -> L241
    L284:
        String r104 = r34;
        if (r104 == null) goto L287;
        r112.put("from_activity_module", r104);     // Catch: JSONException -> L241
    L287:
        String r105 = r36;
        if (r105 == null) goto L290;
        r112.put("item_id", r105);     // Catch: JSONException -> L241
    L290:
        String r106 = r37;
        if (r106 == null) goto L294;
        r112.put("is_call_bot", r106);     // Catch: JSONException -> L241
    L294:
        if (com.larus.utils.o0.d(r410) == false) goto L296;
        r112.put("is_having_content", r410);     // Catch: JSONException -> L241
    L296:
        String r107 = r38;
        if (r107 == null) goto L299;
        r112.put("from_notice_type", r107);     // Catch: JSONException -> L241
    L299:
        if (r416 == null) goto L301;
        r112.put("input_function", r416);     // Catch: JSONException -> L241
    L301:
        if (r412 == null) goto L303;
        r112.put("message_id", r412);     // Catch: JSONException -> L241
    L303:
        if (r413 == null) goto L305;
        r112.put("deep_research_id", r413);     // Catch: JSONException -> L241
    L305:
        r112.putOpt("outer_link_source", r411);     // Catch: JSONException -> L241
        if (r414 == null) goto L308;
        r112.put("page_token", r414);     // Catch: JSONException -> L241
    L308:
        if (r415 == null) goto L310;
        r112.put("artifact_meta_id", r415);     // Catch: JSONException -> L241
    L310:
        if (r510 == null) goto L313;
        r112.put("artifact_type", r510.toString());     // Catch: JSONException -> L241
    L313:
        if (com.larus.utils.o0.d(r512) == false) goto L316;
        r112.put("aippt_task_id", r512);     // Catch: JSONException -> L241
    L316:
        if (com.larus.utils.o0.d(r28) == false) goto L319;
        r112.put("presentation_id", r28);     // Catch: JSONException -> L241
    L319:
        if (com.larus.utils.o0.d(r111) == false) goto L321;
        r112.put("resource_id", r111);     // Catch: JSONException -> L241
    L321:
        if (r210 == null) goto L323;
        r112.put("resource_type", r210.toString());     // Catch: JSONException -> L241
    L323:
        String r108 = r40;
        if (r108 == null) goto L327;
        r112.put("previous_camera_tab_name", r108);     // Catch: JSONException -> L241
    L327:
        if (com.larus.utils.o0.d(r514) == false) goto L330;
        r112.put("trigger_app", r514);     // Catch: JSONException -> L241
    L330:
        if (com.larus.utils.o0.d(r515) == false) goto L333;
        r112.put("collection_id", r515);     // Catch: JSONException -> L241
    L333:
        if (com.larus.utils.o0.d(r516) == false) goto L336;
        r112.put("collection_name", r516);     // Catch: JSONException -> L241
    L336:
        if (com.larus.utils.o0.d(r517) == false) goto L339;
        r112.put("content_type", r517);     // Catch: JSONException -> L241
    L339:
        if (com.larus.utils.o0.d(r30) == false) goto L342;
        r112.put("content_sec_type", r30);     // Catch: JSONException -> L241
    L342:
        if (com.larus.utils.o0.d(null) == false) goto L344;
        r112.put("artifact_create_method", null);     // Catch: JSONException -> L241
    L344:
        if (r211 == null) goto L351;
        if (r211.booleanValue() == false) goto L348;
        int r109 = 1;
    L349:
        r112.put("is_has_replica", r109);     // Catch: JSONException -> L241
        goto L351
    L348:
        r109 = 0;
    L351:
        if (com.larus.utils.o0.d(r518) == false) goto L355;
        r112.put("click_from", r518);     // Catch: JSONException -> L241
    L355:
        TrackParams r115 = new TrackParams().merge(r112);
        by7.a r116 = new by7.a("enter_page");
        by7.e r117 = r41;
        if (r117 == null) goto L358;
        r116.b = r117;
    L358:
        r116.a.merge(r115);
        r116.b();
        if (TextUtils.equals(r8, "chat") == false) goto L365;
        com.larus.platform.service.g.a.monitorEventForSlardar("enter_page", r112, new JSONObject(), null);
        return;
    L365:
        return;
    L241:
        e = move-exception;
        FLogger.a.e("EnterEventHelper", "error in EnterEventHelper enterPage " + e.getLocalizedMessage());
        goto L355
    L217:
        r211 = r94;
        goto L218
    L213:
        r518 = r93;
        goto L215
    L209:
        r30 = r92;
        goto L211
    L205:
        r517 = r91;
        goto L207
    L201:
        r516 = r90;
        goto L203
    L197:
        r515 = r89;
        goto L199
    L193:
        r114 = null;
        goto L195
    L189:
        r113 = null;
        goto L191
    L185:
        r514 = r88;
        goto L187
    L181:
        r41 = r87;
        goto L183
    L177:
        r112 = r86;
        goto L179
    L173:
        r210 = r85;
        goto L175
    L169:
        r111 = r84;
        goto L171
    L165:
        r28 = r83;
        goto L166
    L161:
        r512 = r82;
        goto L163
    L157:
        r40 = r81;
        goto L159
    L153:
        r1 = r80;
        goto L155
    L149:
        r110 = r79;
        goto L150
    L145:
        r26 = r78;
        goto L146
    L141:
        r24 = r77;
        goto L142
    L137:
        r22 = r76;
        goto L138
    L133:
        r20 = r75;
        goto L134
    L129:
        r19 = r74;
        goto L130
    L125:
        r16 = r73;
        goto L126
    L121:
        r15 = r72;
        goto L122
    L117:
        r3 = r71;
        goto L119
    L113:
        r38 = r70;
        goto L115
    L109:
        r410 = r69;
        goto L111
    L105:
        r37 = r68;
        goto L107
    L101:
        r36 = r67;
        goto L103
    L97:
        r35 = r66;
        goto L99
    L93:
        r34 = r65;
        goto L95
    L89:
        r33 = r64;
        goto L91
    L85:
        r0 = r63;
        goto L87
    L81:
        r31 = r62;
        goto L83
    L77:
        r29 = r61;
        goto L79
    L73:
        r27 = r60;
        goto L75
    L69:
        r25 = r59;
        goto L71
    L65:
        r23 = r58;
        goto L67
    L61:
        r21 = r57;
        goto L63
    L57:
        r18 = r56;
        goto L59
    L53:
        r17 = r55;
        goto L55
    L49:
        r14 = r54;
        goto L51
    L45:
        r13 = r53;
        goto L47
    L41:
        r12 = r52;
        goto L43
    L37:
        r11 = r51;
        goto L39
    L33:
        r10 = r50;
        goto L35
    L29:
        r9 = r49;
        goto L31
    L25:
        r8 = r48;
        goto L27
    L21:
        r7 = r47;
        goto L23
    L17:
        r6 = r46;
        goto L19
    L13:
        r5 = r45;
        goto L15
    L9:
        r4 = r44;
        goto L11
    L5:
        r2 = r43;
        goto L7
    }
}
