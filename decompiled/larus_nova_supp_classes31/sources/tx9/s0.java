package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s0 {
    public static void a(String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, JSONObject r38, by7.e r39, String r40, String r41, Integer r42, String r43, String r44, String r45, String r46, String r47, Integer r48, Integer r49, boolean r50, String r51, String r52, String r53, String r54, int r55, int r56) {
        if ((r55 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r55 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r55 & 64) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r55 & 128) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r55 & 4096) == 0) goto L21;
        String r7 = null;
    L23:
        if ((524288 & r55) == 0) goto L25;
        String r8 = null;
    L27:
        if ((1048576 & r55) == 0) goto L29;
        String r9 = null;
    L31:
        if ((2097152 & r55) == 0) goto L33;
        String r10 = null;
    L35:
        if ((4194304 & r55) == 0) goto L37;
        String r11 = null;
    L39:
        if ((8388608 & r55) == 0) goto L41;
        String r12 = null;
    L43:
        if ((16777216 & r55) == 0) goto L45;
        JSONObject r13 = new JSONObject();
    L47:
        if ((33554432 & r55) == 0) goto L49;
        by7.e r14 = null;
    L51:
        if ((67108864 & r55) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r55 & 134217728) == 0) goto L57;
        String r3 = null;
    L59:
        if ((r55 & 268435456) == 0) goto L61;
        Integer r17 = null;
    L62:
        by7.e r210 = r14;
        if ((r55 & 536870912) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r55 & 1073741824) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r55 & Integer.MIN_VALUE) == 0) goto L73;
        String r0 = null;
    L75:
        if ((r56 & 1) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r56 & 2) == 0) goto L81;
        String r21 = null;
    L83:
        if ((r56 & 4) == 0) goto L85;
        Integer r18 = null;
    L87:
        if ((r56 & 8) == 0) goto L89;
        Integer r22 = null;
    L91:
        if ((r56 & 16) == 0) goto L93;
        boolean r23 = false;
    L95:
        if ((r56 & 32) == 0) goto L97;
        String r26 = null;
    L99:
        if ((r56 & 64) == 0) goto L101;
        String r27 = null;
    L102:
        String r211 = r0;
        if ((r56 & 128) == 0) goto L105;
        String r1 = null;
    L107:
        if ((r56 & 256) == 0) goto L109;
        String r310 = null;
    L110:
        Intrinsics.checkNotNullParameter(r13, "params");
        if (r2 != null) goto L190;
    L115:
        if (r4 == null) goto L117;
        r13.put("click_from", r4);     // Catch: JSONException -> L113
    L117:
        if (r5 == null) goto L119;
        r13.put("is_immersive_background", r5);     // Catch: JSONException -> L113
    L119:
        if (r6 == null) goto L121;
        r13.put("message_id", r6);     // Catch: JSONException -> L113
    L121:
        if (r7 == null) goto L123;
        r13.put("recommend_from", r7);     // Catch: JSONException -> L113
    L123:
        if (r8 == null) goto L125;
        r13.put("message_is_interrupted", r8);     // Catch: JSONException -> L113
    L125:
        if (r9 == null) goto L127;
        r13.put("is_call_bot", r9);     // Catch: JSONException -> L113
    L127:
        if (r10 == null) goto L129;
        r13.put("agent_id", r10);     // Catch: JSONException -> L113
    L129:
        if (r11 == null) goto L131;
        r13.put("user_case_item_id", r11);     // Catch: JSONException -> L113
    L131:
        if (r12 == null) goto L133;
        r13.put("user_case_reco_request_id", r12);     // Catch: JSONException -> L113
    L133:
        int r24 = 1;
        if (r15 != null) goto L136;
    L141:
        if (r3 != null) goto L143;
    L148:
        if (r17 == null) goto L150;
        r13.put("artifact_type", r17.intValue());     // Catch: JSONException -> L113
    L150:
        if (r18 == null) goto L152;
        r13.put("is_float_chat", r18.intValue());     // Catch: JSONException -> L113
    L152:
        if (r22 == null) goto L154;
        r13.put("float_chat_shown_pct", r22.intValue());     // Catch: JSONException -> L113
    L154:
        if (r16 == null) goto L156;
        r13.put("aippt_task_id", r16);     // Catch: JSONException -> L113
    L156:
        String r25 = r19;
        if (r25 == null) goto L159;
        r13.put("presentation_id", r25);     // Catch: JSONException -> L113
    L159:
        if (r211 == null) goto L161;
        r13.put("resource_id", r211);     // Catch: JSONException -> L113
    L161:
        String r57 = r20;
        if (r57 == null) goto L164;
        r13.put("resource_type", r57);     // Catch: JSONException -> L113
    L164:
        String r58 = r21;
        if (r58 == null) goto L168;
        r13.put("canvas_type", r58);     // Catch: JSONException -> L113
    L168:
        if (r23 == true) goto L171;
        r24 = 0;
    L171:
        r13.put("is_with_ai_doc", r24);     // Catch: JSONException -> L113
        String r59 = r26;
        if (r59 == null) goto L174;
        r13.put("click_module", r59);     // Catch: JSONException -> L113
    L174:
        String r60 = r27;
        if (r60 == null) goto L178;
        r13.put("call_id", r60);     // Catch: JSONException -> L113
    L178:
        if (com.larus.utils.o0.d(r1) == false) goto L181;
        r13.put("spreadsheet_id", r1);     // Catch: JSONException -> L113
    L181:
        if (com.larus.utils.o0.d(r310) == false) goto L185;
        r13.put("base_id", r310);     // Catch: JSONException -> L113
    L113:
        e = move-exception;
        FLogger.a.e("DislikeEventHelper", "error in DislikeEventHelper dislike " + e.getLocalizedMessage());
    L185:
        TrackParams r61 = new TrackParams().merge(r13);
        by7.a r62 = new by7.a("dislike");
        if (r210 == null) goto L188;
        r62.b = r210;
    L188:
        r62.a.merge(r61);
        r62.b();
        return;
    L143:
        if (r3.length() <= 0) goto L145;
        boolean r63 = true;
    L146:
        if (r63 == false) goto L148;
        r13.put("artifact_meta_id", r3);     // Catch: JSONException -> L113
        goto L148
    L145:
        r63 = false;
        goto L146
    L136:
        if (r15.length() <= 0) goto L138;
        boolean r64 = true;
    L139:
        if (r64 == false) goto L141;
        r13.put("page_token", r15);     // Catch: JSONException -> L113
        goto L141
    L138:
        r64 = false;
        goto L139
    L190:
        r13.put("bot_id", r2);     // Catch: JSONException -> L113
        goto L115
    L109:
        r310 = r54;
        goto L110
    L105:
        r1 = r53;
        goto L107
    L101:
        r27 = r52;
        goto L102
    L97:
        r26 = r51;
        goto L99
    L93:
        r23 = r50;
        goto L95
    L89:
        r22 = r49;
        goto L91
    L85:
        r18 = r48;
        goto L87
    L81:
        r21 = r47;
        goto L83
    L77:
        r20 = r46;
        goto L79
    L73:
        r0 = r45;
        goto L75
    L69:
        r19 = r44;
        goto L71
    L65:
        r16 = r43;
        goto L67
    L61:
        r17 = r42;
        goto L62
    L57:
        r3 = r41;
        goto L59
    L53:
        r15 = r40;
        goto L55
    L49:
        r14 = r39;
        goto L51
    L45:
        r13 = r38;
        goto L47
    L41:
        r12 = r37;
        goto L43
    L37:
        r11 = r36;
        goto L39
    L33:
        r10 = r35;
        goto L35
    L29:
        r9 = r34;
        goto L31
    L25:
        r8 = r33;
        goto L27
    L21:
        r7 = r32;
        goto L23
    L17:
        r6 = r31;
        goto L19
    L13:
        r5 = r30;
        goto L15
    L9:
        r4 = r29;
        goto L11
    L5:
        r2 = r28;
        goto L7
    }
}
