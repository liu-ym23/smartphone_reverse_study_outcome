package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f0 {
    public static void b(String r1, String r2, String r3, String r4, String r5, JSONObject r6, by7.e r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r1 != null) goto L21;
    L7:
        if (r2 == null) goto L9;
        r6.put("is_immersive_background", r2);     // Catch: JSONException -> L5
    L9:
        if (r3 == null) goto L11;
        r6.put("recommend_from", r3);     // Catch: JSONException -> L5
    L11:
        if (r4 == null) goto L13;
        r6.put("req_id", r4);     // Catch: JSONException -> L5
    L13:
        r6.put("is_call_bot", r5);     // Catch: JSONException -> L5
    L16:
        TrackParams r8 = new TrackParams().merge(r6);
        by7.a r9 = new by7.a("complete_report_bot_reason");
        if (r7 == null) goto L19;
        r9.b = r7;
    L19:
        r9.a.merge(r8);
        r9.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("CompleteEventHelper", "error in CompleteEventHelper completeReportBotReason " + e.getLocalizedMessage());
        goto L16
    L21:
        r6.put("bot_id", r1);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r1, String r2, String r3, String r4, String r5, String r6, String r7, JSONObject r8, by7.e r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r1 != null) goto L25;
    L7:
        if (r2 == null) goto L9;
        r8.put("is_immersive_background", r2);     // Catch: JSONException -> L5
    L9:
        if (r3 == null) goto L11;
        r8.put("recommend_from", r3);     // Catch: JSONException -> L5
    L11:
        if (r4 == null) goto L13;
        r8.put("req_id", r4);     // Catch: JSONException -> L5
    L13:
        r8.put("is_call_bot", r5);     // Catch: JSONException -> L5
        if (r6 == null) goto L16;
        r8.put("user_case_item_id", r6);     // Catch: JSONException -> L5
    L16:
        if (r7 == null) goto L20;
        r8.put("user_case_reco_request_id", r7);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("CompleteEventHelper", "error in CompleteEventHelper completeReportReason " + e.getLocalizedMessage());
    L20:
        TrackParams r10 = new TrackParams().merge(r8);
        by7.a r11 = new by7.a("complete_report_reason");
        if (r9 == null) goto L23;
        r11.b = r9;
    L23:
        r11.a.merge(r10);
        r11.b();
        return;
    L25:
        r8.put("bot_id", r1);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, Boolean r47, Integer r48, Boolean r49, String r50, String r51, String r52, Boolean r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, Boolean r63, Boolean r64, Integer r65, String r66, String r67, Boolean r68, Boolean r69, by7.e r70, int r71, int r72) {
        if ((r71 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r71 & 8) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r71 & 16) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r71 & 32) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r71 & 64) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r71 & 128) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r71 & 256) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r71 & 512) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r71 & 1024) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r71 & 2048) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r71 & 4096) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r71 & 8192) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r71 & 16384) == 0) goto L53;
        Boolean r14 = null;
    L55:
        if ((32768 & r71) == 0) goto L57;
        Integer r15 = null;
    L59:
        if ((r71 & 65536) == 0) goto L61;
        Boolean r16 = null;
    L63:
        if ((r71 & 131072) == 0) goto L65;
        String r2 = null;
    L67:
        if ((r71 & 262144) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r71 & 524288) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r71 & 1048576) == 0) goto L77;
        Boolean r18 = null;
    L79:
        if ((r71 & 2097152) == 0) goto L81;
        String r22 = null;
    L83:
        if ((r71 & 4194304) == 0) goto L85;
        String r23 = null;
    L87:
        if ((r71 & 8388608) == 0) goto L89;
        String r24 = null;
    L91:
        if ((r71 & 16777216) == 0) goto L93;
        String r25 = null;
    L95:
        if ((r71 & 33554432) == 0) goto L97;
        String r26 = null;
    L99:
        if ((r71 & 67108864) == 0) goto L101;
        String r27 = null;
    L103:
        if ((r71 & 134217728) == 0) goto L105;
        String r310 = null;
    L107:
        if ((r71 & 268435456) == 0) goto L109;
        String r311 = null;
    L111:
        if ((r71 & 536870912) == 0) goto L113;
        String r312 = null;
    L115:
        if ((r71 & 1073741824) == 0) goto L117;
        Boolean r21 = null;
    L119:
        if ((r71 & Integer.MIN_VALUE) == 0) goto L121;
        Boolean r0 = null;
    L123:
        if ((r72 & 1) == 0) goto L125;
        Integer r28 = null;
    L127:
        if ((r72 & 2) == 0) goto L129;
        String r30 = null;
    L131:
        if ((r72 & 4) == 0) goto L133;
        String r31 = null;
    L135:
        if ((r72 & 8) == 0) goto L137;
        Boolean r29 = null;
    L139:
        if ((r72 & 16) == 0) goto L141;
        Boolean r32 = null;
    L143:
        if ((r72 & 32) == 0) goto L145;
        JSONObject r17 = new JSONObject();
    L147:
        if ((r72 & 64) == 0) goto L149;
        by7.e r34 = null;
    L150:
        Intrinsics.checkNotNullParameter(r17, "params");
        if (r12 != null) goto L264;
    L155:
        if (r13 == null) goto L157;
        r17.put("creation_id", r13);     // Catch: JSONException -> L153
    L157:
        String r33 = "0";
        if (r14 != null) goto L160;
    L164:
        if (r15 == null) goto L166;
        r17.put("sp_cnt", r15.intValue());     // Catch: JSONException -> L153
    L166:
        if (r16 != null) goto L168;
    L172:
        if (r1 == null) goto L174;
        r17.put("bot_id", r1);     // Catch: JSONException -> L153
    L174:
        if (r3 == null) goto L176;
        r17.put("enter_from", r3);     // Catch: JSONException -> L153
    L176:
        if (r4 == null) goto L178;
        r17.put("enter_method", r4);     // Catch: JSONException -> L153
    L178:
        if (r5 == null) goto L180;
        r17.put("if_allow_search", r5);     // Catch: JSONException -> L153
    L180:
        if (r6 == null) goto L182;
        r17.put("if_auto_filled", r6);     // Catch: JSONException -> L153
    L182:
        if (r7 == null) goto L184;
        r17.put("if_generate_picture", r7);     // Catch: JSONException -> L153
    L184:
        if (r8 == null) goto L186;
        r17.put("if_has_voice", r8);     // Catch: JSONException -> L153
    L186:
        if (r9 == null) goto L188;
        r17.put("if_system_prompt_added", r9);     // Catch: JSONException -> L153
    L188:
        if (r10 == null) goto L190;
        r17.put("previous_page", r10);     // Catch: JSONException -> L153
    L190:
        if (r11 == null) goto L192;
        r17.put("profile_photo_type", r11);     // Catch: JSONException -> L153
    L192:
        if (r2 == 0) goto L194;
        r17.put("from_activity_name", r2);     // Catch: JSONException -> L153
    L194:
        String r73 = r19;
        if (r73 == null) goto L197;
        r17.put("from_activity_module", r73);     // Catch: JSONException -> L153
    L197:
        String r74 = r20;
        if (r74 == null) goto L200;
        r17.put("image_type", r74);     // Catch: JSONException -> L153
    L200:
        if (r18 != null) goto L202;
    L206:
        String r75 = r22;
        if (r75 == null) goto L209;
        r17.put("voice_id", r75);     // Catch: JSONException -> L153
    L209:
        String r76 = r23;
        if (r76 == null) goto L213;
        r17.put("voice_type", r76);     // Catch: JSONException -> L153
    L213:
        if (com.larus.utils.o0.d(r310) == false) goto L216;
        r17.put("suggested_prompt_add_type", r310);     // Catch: JSONException -> L153
    L216:
        if (com.larus.utils.o0.d(r311) == false) goto L219;
        r17.put("bio_add_type", r311);     // Catch: JSONException -> L153
    L219:
        if (com.larus.utils.o0.d(r312) == false) goto L221;
        r17.put("onboarding_add_type", r312);     // Catch: JSONException -> L153
    L221:
        if (r21 != null) goto L223;
    L227:
        if (r0 != 0) goto L229;
    L233:
        if (r28 == null) goto L235;
        r17.put("polish_cnt", String.valueOf(r28.intValue()));     // Catch: JSONException -> L153
    L235:
        String r77 = r30;
        if (r77 == null) goto L238;
        r17.put("polish_status", r77);     // Catch: JSONException -> L153
    L238:
        String r78 = r31;
        if (r78 == null) goto L241;
        r17.put("private_status", r78);     // Catch: JSONException -> L153
    L241:
        if (r29 == null) goto L249;
        boolean r79 = r29.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r77, "1") == false) goto L249;
        if (r79 == false) goto L247;
        Object r80 = "1";
    L248:
        r17.put("if_polish_use_internet", r80);     // Catch: JSONException -> L153
        goto L249
    L247:
        r80 = "0";
    L249:
        if (r32 == null) goto L256;
        boolean r81 = r32.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r6, "1") == false) goto L256;
        if (r81 == false) goto L255;
        r33 = "1";
    L255:
        r17.put("if_auto_fill_use_internet", r33);     // Catch: JSONException -> L153
    L256:
        r17.putOpt("name_add_type", r24).putOpt("sp_add_type", r25).putOpt("profile_photo_add_type", r26).putOpt("voice_add_type", r27);     // Catch: JSONException -> L153
    L259:
        TrackParams r82 = new TrackParams().merge(r17);
        by7.a r83 = new by7.a("complete_create_new_bot");
        by7.e r84 = r34;
        if (r84 == null) goto L262;
        r83.b = r84;
    L262:
        r83.a.merge(r82);
        r83.b();
        return;
    L153:
        e = move-exception;
        FLogger.a.e("CompleteEventHelper", "error in CompleteEventHelper completeCreateNewBot " + e.getLocalizedMessage());
        goto L259
    L229:
        if (r0.booleanValue() == false) goto L231;
        Object r85 = "1";
    L232:
        r17.put("if_polish", r85);     // Catch: JSONException -> L153
        goto L233
    L231:
        r85 = "0";
        goto L232
    L223:
        if (r21.booleanValue() == false) goto L225;
        Object r86 = "1";
    L226:
        r17.put("if_has_bio", r86);     // Catch: JSONException -> L153
        goto L227
    L225:
        r86 = "0";
        goto L226
    L202:
        if (r18.booleanValue() == false) goto L204;
        Object r87 = "1";
    L205:
        r17.put("background_status", r87);     // Catch: JSONException -> L153
        goto L206
    L204:
        r87 = "0";
        goto L205
    L168:
        if (r16.booleanValue() == false) goto L170;
        Object r110 = "1";
    L171:
        r17.put("sp_status", r110);     // Catch: JSONException -> L153
        goto L172
    L170:
        r110 = "0";
        goto L171
    L160:
        if (r14.booleanValue() == false) goto L162;
        Object r111 = "1";
    L163:
        r17.put("if_has_onboarding", r111);     // Catch: JSONException -> L153
        goto L164
    L162:
        r111 = "0";
        goto L163
    L264:
        r17.put("create_way", r12);     // Catch: JSONException -> L153
        goto L155
    L149:
        r34 = r70;
        goto L150
    L145:
        r17 = null;
        goto L147
    L141:
        r32 = r69;
        goto L143
    L137:
        r29 = r68;
        goto L139
    L133:
        r31 = r67;
        goto L135
    L129:
        r30 = r66;
        goto L131
    L125:
        r28 = r65;
        goto L127
    L121:
        r0 = r64;
        goto L123
    L117:
        r21 = r63;
        goto L119
    L113:
        r312 = r62;
        goto L115
    L109:
        r311 = r61;
        goto L111
    L105:
        r310 = r60;
        goto L107
    L101:
        r27 = r59;
        goto L103
    L97:
        r26 = r58;
        goto L99
    L93:
        r25 = r57;
        goto L95
    L89:
        r24 = r56;
        goto L91
    L85:
        r23 = r55;
        goto L87
    L81:
        r22 = r54;
        goto L83
    L77:
        r18 = r53;
        goto L79
    L73:
        r20 = r52;
        goto L75
    L69:
        r19 = r51;
        goto L71
    L65:
        r2 = r50;
        goto L67
    L61:
        r16 = r49;
        goto L63
    L57:
        r15 = r48;
        goto L59
    L53:
        r14 = r47;
        goto L55
    L49:
        r13 = r46;
        goto L51
    L45:
        r12 = r45;
        goto L47
    L41:
        r11 = r44;
        goto L43
    L37:
        r10 = r43;
        goto L39
    L33:
        r9 = r42;
        goto L35
    L29:
        r8 = r41;
        goto L31
    L25:
        r7 = r40;
        goto L27
    L21:
        r6 = r39;
        goto L23
    L17:
        r5 = r38;
        goto L19
    L13:
        r4 = r37;
        goto L15
    L9:
        r3 = r36;
        goto L11
    L5:
        r1 = r35;
        goto L7
    }
}
