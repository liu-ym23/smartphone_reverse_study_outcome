package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y3 {
    public static void b(String r3, String r4, Integer r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r3 != null) goto L14;
    L7:
        r1.put("error_message", r4);     // Catch: JSONException -> L5
        r1.put("message_type", "multi_file");     // Catch: JSONException -> L5
        if (r5 == null) goto L12;
        r1.put("file_cnt", r5.intValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("UploadEventHelper", "error in UploadEventHelper uploadMultiAttachmentWholeProblem " + e.getLocalizedMessage());
    L12:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("upload_multi_attachment_whole_problem");
        r7.a.merge(r6);
        r7.b();
        return;
    L14:
        r1.put("bot_id", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, Integer r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, Integer r62, String r63, String r64, String r65, String r66, String r67, Long r68, String r69, String r70, String r71, String r72, Integer r73, String r74, Integer r75, String r76, String r77, String r78, String r79, String r80, String r81, String r82, String r83, int r84, int r85) {
        if ((r84 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r84 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r84 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r84 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r84 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r84 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r84 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r84 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r84 & 256) == 0) goto L37;
        Integer r11 = null;
    L39:
        if ((r84 & 512) == 0) goto L41;
        JSONObject r12 = new JSONObject();
    L43:
        if ((r84 & 2048) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r84 & 4096) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r84 & 8192) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r84 & 16384) == 0) goto L57;
        String r3 = null;
    L59:
        if ((r84 & 32768) == 0) goto L61;
        String r18 = null;
    L63:
        if ((r84 & 65536) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r84 & 131072) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r84 & 262144) == 0) goto L73;
        String r19 = null;
    L74:
        String r310 = r5;
        if ((r84 & 524288) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r84 & 1048576) == 0) goto L81;
        String r22 = null;
    L83:
        if ((r84 & 2097152) == 0) goto L85;
        String r23 = null;
    L87:
        if ((r84 & 4194304) == 0) goto L89;
        String r24 = "-1";
    L91:
        if ((r84 & 8388608) == 0) goto L93;
        String r26 = "0";
    L95:
        if ((r84 & 16777216) == 0) goto L97;
        String r27 = "0";
    L99:
        if ((r84 & 33554432) == 0) goto L101;
        Integer r21 = null;
    L103:
        if ((r84 & 67108864) == 0) goto L105;
        String r28 = null;
    L107:
        if ((r84 & 134217728) == 0) goto L109;
        String r29 = null;
    L111:
        if ((r84 & 268435456) == 0) goto L113;
        String r30 = null;
    L115:
        if ((r84 & 536870912) == 0) goto L117;
        String r31 = null;
    L119:
        if ((r84 & Integer.MIN_VALUE) == 0) goto L121;
        String r0 = null;
    L122:
        String r410 = r20;
        if ((r85 & 1) == 0) goto L125;
        Long r25 = null;
    L127:
        if ((r85 & 2) == 0) goto L129;
        String r32 = null;
    L131:
        if ((r85 & 4) == 0) goto L133;
        String r33 = null;
    L135:
        if ((r85 & 8) == 0) goto L137;
        String r34 = null;
    L139:
        if ((r85 & 16) == 0) goto L141;
        String r35 = null;
    L143:
        if ((r85 & 32) == 0) goto L145;
        Integer r210 = null;
    L147:
        if ((r85 & 64) == 0) goto L149;
        String r37 = null;
    L150:
        String r411 = r19;
        if ((r85 & 128) == 0) goto L153;
        Integer r110 = null;
    L154:
        Integer r412 = r110;
        if ((r85 & 256) == 0) goto L157;
        String r111 = null;
    L158:
        String r413 = r111;
        if ((r85 & 512) == 0) goto L161;
        String r112 = null;
    L162:
        String r414 = r14;
        if ((r85 & 1024) == 0) goto L165;
        String r113 = null;
    L166:
        String r415 = r13;
        if ((r85 & 2048) == 0) goto L169;
        String r114 = null;
    L170:
        Integer r416 = r11;
        if ((r85 & 4096) == 0) goto L173;
        String r115 = null;
    L174:
        String r417 = r115;
        if ((r85 & 8192) == 0) goto L177;
        String r116 = null;
    L178:
        String r36 = r10;
        if ((r85 & 16384) == 0) goto L181;
        String r117 = null;
    L183:
        if ((r85 & 32768) == 0) goto L185;
        String r1 = null;
    L186:
        String r38 = r8;
        Intrinsics.checkNotNullParameter(r12, "params");
        r12.putOpt("spring_guide_card_id", r112);     // Catch: JSONException -> L349
        r12.putOpt("action_bar_key", r16);     // Catch: JSONException -> L349
        r12.putOpt("duration", r25);     // Catch: JSONException -> L349
        r12.putOpt("upload_from", r113);     // Catch: JSONException -> L349
        r12.putOpt("upload_way", r114);     // Catch: JSONException -> L349
        r12.putOpt("upload_file_size", r116);     // Catch: JSONException -> L349
        if (r0 != null) goto L191;
        r0 = "";
    L191:
        r12.putOpt("message_id", r0);     // Catch: JSONException -> L349
        boolean r86 = true;
        if (r117 != null) goto L194;
    L196:
        r117 = null;
    L197:
        r12.putOpt("display_type", r117);     // Catch: JSONException -> L349
        if (r1 != null) goto L200;
    L202:
        r1 = null;
    L203:
        r12.putOpt("agent_type", r1);     // Catch: JSONException -> L349
        r12.putOpt("cited_message_id", "");     // Catch: JSONException -> L349
        if (r2 == null) goto L206;
        r12.put("bot_id", r2);     // Catch: JSONException -> L349
    L206:
        if (r4 == null) goto L208;
        r12.put("current_page", r4);     // Catch: JSONException -> L349
    L208:
        if (r6 == null) goto L210;
        r12.put("error_message", r6);     // Catch: JSONException -> L349
    L210:
        if (r7 == null) goto L213;
        r12.put("message_type", r7);     // Catch: JSONException -> L349
    L213:
        if (r38 != null) goto L215;
        String r87 = "";
    L216:
        r12.putOpt("message_type_detail", r87);     // Catch: JSONException -> L349
        if (r9 == 0) goto L219;
        r12.put("success", r9);     // Catch: JSONException -> L349
    L219:
        if (r36 == null) goto L221;
        r12.put("uri", r36);     // Catch: JSONException -> L349
    L221:
        if (r416 == null) goto L224;
        r12.put("is_multi_file", r416.intValue());     // Catch: JSONException -> L349
    L224:
        if (r415 != null) goto L226;
    L229:
        boolean r88 = true;
    L230:
        if (r88 == true) goto L232;
        r12.put("click_from", r415);     // Catch: JSONException -> L349
    L232:
        if (r414 != null) goto L234;
    L237:
        boolean r89 = true;
    L238:
        if (r89 == true) goto L240;
        r12.put("action_bar_template_name", r414);     // Catch: JSONException -> L349
    L240:
        if (r411 != null) goto L242;
    L245:
        boolean r90 = true;
    L246:
        if (r90 == true) goto L248;
        r12.put("is_multi_choose_mode", r411);     // Catch: JSONException -> L349
    L248:
        if (r410 != null) goto L250;
    L253:
        boolean r91 = true;
    L254:
        if (r91 == true) goto L256;
        r12.put("chat_type", r410);     // Catch: JSONException -> L349
    L256:
        String r92 = r22;
        if (r92 != null) goto L259;
    L262:
        boolean r93 = true;
    L263:
        if (r93 == true) goto L265;
        r12.put("previous_page", r92);     // Catch: JSONException -> L349
    L265:
        String r94 = r23;
        if (r94 != null) goto L268;
    L271:
        boolean r95 = true;
    L272:
        if (r95 == true) goto L274;
        r12.put("content_source", r94);     // Catch: JSONException -> L349
    L274:
        String r96 = r24;
        if (r96 != null) goto L277;
    L280:
        boolean r97 = true;
    L281:
        if (r97 == true) goto L283;
        r12.put("if_edu_intention", r96);     // Catch: JSONException -> L349
    L283:
        String r98 = r26;
        if (r98 != null) goto L286;
    L289:
        boolean r99 = true;
    L290:
        if (r99 == true) goto L292;
        r12.put("is_crop", r98);     // Catch: JSONException -> L349
    L292:
        String r100 = r27;
        if (r100 != null) goto L295;
    L298:
        boolean r101 = true;
    L299:
        if (r101 == true) goto L301;
        r12.put("is_mark", r100);     // Catch: JSONException -> L349
    L301:
        if (r21 == null) goto L303;
        r12.put("is_ai_doc", r21.intValue());     // Catch: JSONException -> L349
    L303:
        String r102 = r28;
        if (r102 == null) goto L310;
        if (r102.length() == 0) goto L310;
        r86 = false;
    L310:
        if (r86 == false) goto L312;
        r12.put("cited_from_user_type", "no_cite");     // Catch: JSONException -> L349
    L313:
        String r103 = r29;
        if (r103 == null) goto L316;
        r12.put("cited_message_id", r103);     // Catch: JSONException -> L349
    L316:
        if (r310 == null) goto L318;
        r12.put("template_page_type", r310);     // Catch: JSONException -> L349
    L318:
        String r104 = r30;
        if (r104 == null) goto L321;
        r12.put("from_template_id", r104);     // Catch: JSONException -> L349
    L321:
        String r105 = r31;
        if (r105 == null) goto L324;
        r12.put("from_template_sub_type", r105);     // Catch: JSONException -> L349
    L324:
        String r106 = r32;
        if (r106 == null) goto L327;
        r12.put("template_rec_req_id", r106);     // Catch: JSONException -> L349
    L327:
        String r107 = r33;
        if (r107 == null) goto L330;
        r12.put("canvas_type", r107);     // Catch: JSONException -> L349
    L330:
        String r108 = r34;
        if (r108 == null) goto L333;
        r12.put("presentation_id", r108);     // Catch: JSONException -> L349
    L333:
        String r109 = r35;
        if (r109 == null) goto L336;
        r12.put("resource_id", r109);     // Catch: JSONException -> L349
    L336:
        if (r210 == null) goto L338;
        r12.put("resource_type", r210.intValue());     // Catch: JSONException -> L349
    L338:
        String r118 = r37;
        if (r118 == null) goto L341;
        r12.put("artifact_meta_id", r118);     // Catch: JSONException -> L349
    L341:
        if (r412 == null) goto L343;
        r12.put("artifact_type", r412.intValue());     // Catch: JSONException -> L349
    L343:
        if (r413 == null) goto L345;
        r12.put("aippt_task_id", r413);     // Catch: JSONException -> L349
    L345:
        if (r417 == null) goto L347;
        r12.put("clarify_id", r417);     // Catch: JSONException -> L349
    L347:
        r12.putOpt("enter_method", r17);     // Catch: JSONException -> L349
        r12.putOpt("action_bar_template_id", r15);     // Catch: JSONException -> L349
        r12.putOpt("action_bar_template_type", r3);     // Catch: JSONException -> L349
        r12.putOpt("action_bar_item_id", r18);     // Catch: JSONException -> L349
    L351:
        TrackParams r119 = new TrackParams().merge(r12);
        by7.a r120 = new by7.a("upload_attachment_status");
        r120.a.merge(r119);
        r120.b();
        return;
    L312:
        r12.put("cited_from_user_type", r102);     // Catch: JSONException -> L349
        goto L313
    L295:
        if (r100.length() == 0) goto L298;
        r101 = false;
        goto L299
    L286:
        if (r98.length() == 0) goto L289;
        r99 = false;
        goto L290
    L277:
        if (r96.length() == 0) goto L280;
        r97 = false;
        goto L281
    L268:
        if (r94.length() == 0) goto L271;
        r95 = false;
        goto L272
    L259:
        if (r92.length() == 0) goto L262;
        r93 = false;
        goto L263
    L250:
        if (r410.length() == 0) goto L253;
        r91 = false;
        goto L254
    L242:
        if (r411.length() == 0) goto L245;
        r90 = false;
        goto L246
    L234:
        if (r414.length() == 0) goto L237;
        r89 = false;
        goto L238
    L226:
        if (r415.length() == 0) goto L229;
        r88 = false;
        goto L230
    L215:
        r87 = r38;
        goto L216
    L200:
        if ((!StringsKt.isBlank(r1)) == false) goto L202;
    L194:
        if ((!StringsKt.isBlank(r117)) == false) goto L196;
    L349:
        e = move-exception;
        FLogger.a.e("UploadEventHelper", "error in UploadEventHelper uploadAttachmentStatus " + e.getLocalizedMessage());
        goto L351
    L185:
        r1 = r83;
        goto L186
    L181:
        r117 = r82;
        goto L183
    L177:
        r116 = r81;
        goto L178
    L173:
        r115 = r80;
        goto L174
    L169:
        r114 = r79;
        goto L170
    L165:
        r113 = r78;
        goto L166
    L161:
        r112 = r77;
        goto L162
    L157:
        r111 = r76;
        goto L158
    L153:
        r110 = r75;
        goto L154
    L149:
        r37 = r74;
        goto L150
    L145:
        r210 = r73;
        goto L147
    L141:
        r35 = r72;
        goto L143
    L137:
        r34 = r71;
        goto L139
    L133:
        r33 = r70;
        goto L135
    L129:
        r32 = r69;
        goto L131
    L125:
        r25 = r68;
        goto L127
    L121:
        r0 = r67;
        goto L122
    L117:
        r31 = r66;
        goto L119
    L113:
        r30 = r65;
        goto L115
    L109:
        r29 = r64;
        goto L111
    L105:
        r28 = r63;
        goto L107
    L101:
        r21 = r62;
        goto L103
    L97:
        r27 = r61;
        goto L99
    L93:
        r26 = r60;
        goto L95
    L89:
        r24 = r59;
        goto L91
    L85:
        r23 = r58;
        goto L87
    L81:
        r22 = r57;
        goto L83
    L77:
        r20 = r56;
        goto L79
    L73:
        r19 = r55;
        goto L74
    L69:
        r17 = r54;
        goto L71
    L65:
        r16 = r53;
        goto L67
    L61:
        r18 = r52;
        goto L63
    L57:
        r3 = r51;
        goto L59
    L53:
        r15 = r50;
        goto L55
    L49:
        r14 = r49;
        goto L51
    L45:
        r13 = r48;
        goto L47
    L41:
        r12 = null;
        goto L43
    L37:
        r11 = r47;
        goto L39
    L33:
        r10 = r46;
        goto L35
    L29:
        r9 = r45;
        goto L31
    L25:
        r8 = r44;
        goto L27
    L21:
        r7 = r43;
        goto L23
    L17:
        r6 = r42;
        goto L19
    L13:
        r5 = r41;
        goto L15
    L9:
        r4 = r40;
        goto L11
    L5:
        r2 = r39;
        goto L7
    }
}
