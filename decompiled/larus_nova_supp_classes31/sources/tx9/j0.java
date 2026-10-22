package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j0 {
    public static void a(String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, Long r48, String r49, String r50, String r51, Boolean r52, String r53, Boolean r54, String r55, String r56, String r57, Boolean r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, String r69, String r70, String r71, String r72, String r73, String r74, Map r75, String r76, String r77, String r78, JSONObject r79, by7.e r80, Function0 r81, int r82, int r83) {
        if ((r82 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r82 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r82 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r82 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r82 & 64) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r82 & 128) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r82 & 256) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r82 & 4096) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r82 & 524288) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r82 & 1048576) == 0) goto L41;
        Long r14 = null;
    L43:
        if ((r82 & 2097152) == 0) goto L45;
        String r3 = null;
    L47:
        if ((r82 & 4194304) == 0) goto L49;
        String r19 = null;
    L51:
        if ((r82 & 8388608) == 0) goto L53;
        String r20 = null;
    L55:
        if ((r82 & 16777216) == 0) goto L57;
        Boolean r18 = null;
    L59:
        if ((r82 & 33554432) == 0) goto L61;
        String r22 = null;
    L63:
        if ((r82 & 67108864) == 0) goto L65;
        Boolean r21 = null;
    L67:
        if ((r82 & 134217728) == 0) goto L69;
        String r24 = null;
    L71:
        if ((r82 & 268435456) == 0) goto L73;
        String r25 = null;
    L75:
        if ((r82 & 536870912) == 0) goto L77;
        String r26 = null;
    L79:
        if ((r82 & 1073741824) == 0) goto L81;
        Boolean r23 = null;
    L83:
        if ((r82 & Integer.MIN_VALUE) == 0) goto L85;
        String r0 = null;
    L87:
        if ((r83 & 1) == 0) goto L89;
        String r28 = null;
    L91:
        if ((r83 & 2) == 0) goto L93;
        String r29 = null;
    L95:
        if ((r83 & 4) == 0) goto L97;
        String r30 = null;
    L99:
        if ((r83 & 8) == 0) goto L101;
        String r31 = null;
    L103:
        if ((r83 & 16) == 0) goto L105;
        String r32 = null;
    L107:
        if ((r83 & 32) == 0) goto L109;
        String r33 = null;
    L111:
        if ((r83 & 64) == 0) goto L113;
        String r34 = null;
    L115:
        if ((r83 & 128) == 0) goto L117;
        String r15 = null;
    L119:
        if ((r83 & 256) == 0) goto L121;
        String r13 = null;
    L123:
        if ((r83 & 512) == 0) goto L125;
        String r11 = null;
    L126:
        String r410 = r11;
        if ((r83 & 1024) == 0) goto L129;
        String r16 = null;
    L130:
        String r411 = r16;
        if ((r83 & 2048) == 0) goto L133;
        String r17 = null;
    L134:
        String r412 = r17;
        if ((r83 & 4096) == 0) goto L137;
        String r110 = null;
    L138:
        String r413 = r110;
        if ((r83 & 8192) == 0) goto L141;
        String r111 = null;
    L142:
        String r414 = r111;
        if ((r83 & 16384) == 0) goto L145;
        String r112 = null;
    L147:
        if ((r83 & 65536) == 0) goto L149;
        Map r27 = null;
    L151:
        if ((r83 & 131072) == 0) goto L153;
        String r415 = null;
    L155:
        if ((r83 & 262144) == 0) goto L157;
        String r35 = null;
    L159:
        if ((r83 & 524288) == 0) goto L161;
        String r36 = null;
    L163:
        if ((r83 & 1048576) == 0) goto L165;
        JSONObject r113 = new JSONObject();
        int r37 = 2097152;
    L167:
        if ((r83 & r37) == 0) goto L169;
        by7.e r38 = null;
    L171:
        if ((r83 & 4194304) == 0) goto L173;
        Function0 r310 = null;
    L174:
        Intrinsics.checkNotNullParameter(r113, "params");
        if (r27 != null) goto L315;
    L182:
        String r416 = r13;
        if (r2 == null) goto L185;
        r113.put("bot_id", r2);     // Catch: JSONException -> L180
    L185:
        if (r4 == null) goto L187;
        r113.put("chat_type", r4);     // Catch: JSONException -> L180
    L187:
        if (r5 == null) goto L189;
        r113.put("click_from", r5);     // Catch: JSONException -> L180
    L189:
        if (r6 == null) goto L192;
        r113.put("current_page", r6);     // Catch: JSONException -> L180
    L192:
        if (r35 != null) goto L194;
    L197:
        boolean r84 = true;
    L199:
        if ((true ^ r84) == true) goto L202;
        r35 = null;
    L202:
        String r85 = "0";
        if (r35 != null) goto L205;
        Object r86 = "0";
    L206:
        r113.put("is_general_agent", r86);     // Catch: JSONException -> L180
        if (r36 != null) goto L209;
        r36 = "";
    L209:
        r113.put("chat_id", r36);     // Catch: JSONException -> L180
        if (r7 == null) goto L212;
        r113.put("is_immersive_background", r7);     // Catch: JSONException -> L180
    L212:
        if (r8 == null) goto L214;
        r113.put("message_id", r8);     // Catch: JSONException -> L180
    L214:
        if (r9 == null) goto L216;
        r113.put("previous_page", r9);     // Catch: JSONException -> L180
    L216:
        if (r10 == null) goto L218;
        r113.put("recommend_from", r10);     // Catch: JSONException -> L180
    L218:
        if (r12 == null) goto L220;
        r113.put("message_is_interrupted", r12);     // Catch: JSONException -> L180
    L220:
        String r1 = r19;
        if (r1 == null) goto L223;
        r113.put("conversation_id", r1);     // Catch: JSONException -> L180
    L223:
        String r87 = r20;
        if (r87 == null) goto L226;
        r113.put("section_id", r87);     // Catch: JSONException -> L180
    L226:
        if (r14 == null) goto L228;
        r113.put("with_code", r14.longValue());     // Catch: JSONException -> L180
    L228:
        if (r3 == null) goto L230;
        r113.put("code_type", r3);     // Catch: JSONException -> L180
    L230:
        String r88 = r22;
        if (r88 == null) goto L234;
        r113.put("is_call_bot", r88);     // Catch: JSONException -> L180
    L234:
        if (r18 != null) goto L236;
    L240:
        if (r21 == null) goto L242;
        r113.put("is_multiple", r21.booleanValue() ? 1 : 0);     // Catch: JSONException -> L180
    L242:
        String r89 = r24;
        if (r89 == null) goto L245;
        r113.put("user_type", r89);     // Catch: JSONException -> L180
    L245:
        String r90 = r25;
        if (r90 == null) goto L248;
        r113.put("message_type", r90);     // Catch: JSONException -> L180
    L248:
        String r91 = r26;
        if (r91 == null) goto L251;
        r113.put("click_module", r91);     // Catch: JSONException -> L180
    L251:
        if (r23 != null) goto L253;
    L256:
        if (r0 == null) goto L258;
        r113.put("deep_research_id", r0);     // Catch: JSONException -> L180
    L258:
        String r92 = r28;
        if (r92 == null) goto L261;
        r113.put("user_case_item_id", r92);     // Catch: JSONException -> L180
    L261:
        String r93 = r29;
        if (r93 == null) goto L264;
        r113.put("user_case_reco_request_id", r93);     // Catch: JSONException -> L180
    L264:
        String r94 = r30;
        if (r94 == null) goto L267;
        r113.put("select_range", r94);     // Catch: JSONException -> L180
    L267:
        String r95 = r31;
        if (r95 == null) goto L270;
        r113.put("corresponding_reply_status", r95);     // Catch: JSONException -> L180
    L270:
        String r96 = r32;
        if (r96 == null) goto L273;
        r113.put("reply_status", r96);     // Catch: JSONException -> L180
    L273:
        String r97 = r33;
        if (r97 == null) goto L276;
        r113.put("aippt_task_id", r97);     // Catch: JSONException -> L180
    L276:
        String r98 = r34;
        if (r98 == null) goto L279;
        r113.put("presentation_id", r98);     // Catch: JSONException -> L180
    L279:
        if (r15 == null) goto L281;
        r113.put("resource_id", r15);     // Catch: JSONException -> L180
    L281:
        if (r416 == null) goto L283;
        r113.put("resource_type", r416);     // Catch: JSONException -> L180
    L283:
        if (r410 == null) goto L285;
        r113.put("artifact_meta_id", r410);     // Catch: JSONException -> L180
    L285:
        if (r411 == null) goto L287;
        r113.put("artifact_type", r411);     // Catch: JSONException -> L180
    L287:
        if (r412 == null) goto L289;
        r113.put("base_id", r412);     // Catch: JSONException -> L180
    L289:
        if (r413 == null) goto L291;
        r113.put("canvas_type", r413);     // Catch: JSONException -> L180
    L291:
        if (r414 == null) goto L293;
        r113.put("content_type", r414);     // Catch: JSONException -> L180
    L293:
        if (r112 == 0) goto L296;
        r113.put("call_id", r112);     // Catch: JSONException -> L180
    L296:
        if (com.larus.utils.o0.d(null) == false) goto L299;
        r113.put("artifact_create_method", null);     // Catch: JSONException -> L180
    L299:
        if (com.larus.utils.o0.d(r415) == false) goto L301;
        r113.put("spreadsheet_id", r415);     // Catch: JSONException -> L180
    L301:
        if (r310 == null) goto L310;
        Map r99 = (Map) r310.invoke();     // Catch: JSONException -> L180
        if (r99 == null) goto L310;
        Iterator r100 = r99.entrySet().iterator();     // Catch: JSONException -> L180
    L305:
        if (r100.hasNext() == false) goto L310;
        Map.Entry r101 = (Map.Entry) r100.next();     // Catch: JSONException -> L180
        r113.put((String) r101.getKey(), r101.getValue());     // Catch: JSONException -> L180
    L180:
        e = move-exception;
        FLogger.a.e("CopyEventHelper", "error in CopyEventHelper copy " + e.getLocalizedMessage());
    L310:
        TrackParams r102 = new TrackParams().merge(r113);
        by7.a r103 = new by7.a("copy");
        by7.e r104 = r38;
        if (r104 == null) goto L313;
        r103.b = r104;
    L313:
        r103.a.merge(r102);
        r103.b();
        return;
    L253:
        if (r23.booleanValue() == false) goto L255;
        r85 = "1";
    L255:
        r113.put("is_thinking_generating", r85);     // Catch: JSONException -> L180
        goto L256
    L236:
        if (r18.booleanValue() == false) goto L238;
        Object r105 = "1";
    L239:
        r113.put("is_message_generating", r105);     // Catch: JSONException -> L180
        goto L240
    L238:
        r105 = "0";
        goto L239
    L205:
        r86 = r35;
        goto L206
    L194:
        if (r35.length() == 0) goto L197;
        r84 = false;
        goto L199
    L315:
        Iterator r106 = r27.entrySet().iterator();     // Catch: JSONException -> L180
    L178:
        if (r106.hasNext() == false) goto L182;
        Map.Entry r114 = (Map.Entry) r106.next();     // Catch: JSONException -> L180
        r113.put((String) r114.getKey(), r114.getValue());     // Catch: JSONException -> L180
        r106 = r106;
        r13 = r13;
        goto L178
    L173:
        r310 = r81;
        goto L174
    L169:
        r38 = r80;
        goto L171
    L165:
        r37 = 2097152;
        r113 = r79;
        goto L167
    L161:
        r36 = r78;
        goto L163
    L157:
        r35 = r77;
        goto L159
    L153:
        r415 = r76;
        goto L155
    L149:
        r27 = r75;
        goto L151
    L145:
        r112 = r74;
        goto L147
    L141:
        r111 = r73;
        goto L142
    L137:
        r110 = r72;
        goto L138
    L133:
        r17 = r71;
        goto L134
    L129:
        r16 = r70;
        goto L130
    L125:
        r11 = r69;
        goto L126
    L121:
        r13 = r68;
        goto L123
    L117:
        r15 = r67;
        goto L119
    L113:
        r34 = r66;
        goto L115
    L109:
        r33 = r65;
        goto L111
    L105:
        r32 = r64;
        goto L107
    L101:
        r31 = r63;
        goto L103
    L97:
        r30 = r62;
        goto L99
    L93:
        r29 = r61;
        goto L95
    L89:
        r28 = r60;
        goto L91
    L85:
        r0 = r59;
        goto L87
    L81:
        r23 = r58;
        goto L83
    L77:
        r26 = r57;
        goto L79
    L73:
        r25 = r56;
        goto L75
    L69:
        r24 = r55;
        goto L71
    L65:
        r21 = r54;
        goto L67
    L61:
        r22 = r53;
        goto L63
    L57:
        r18 = r52;
        goto L59
    L53:
        r20 = r51;
        goto L55
    L49:
        r19 = r50;
        goto L51
    L45:
        r3 = r49;
        goto L47
    L41:
        r14 = r48;
        goto L43
    L37:
        r12 = r47;
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
