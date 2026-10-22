package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k0 {
    public static void a(String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, Boolean r29, String r30, String r31, String r32, String r33, JSONObject r34, by7.e r35, String r36, Integer r37, int r38) {
        if ((r38 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r38 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r38 & 8) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r38 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r38 & 32) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r38 & 64) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r38 & 128) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r38 & 256) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r38 & 512) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r38 & 1024) == 0) goto L41;
        Boolean r11 = Boolean.TRUE;
    L43:
        if ((r38 & 2048) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r38 & 4096) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r38 & 8192) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r38 & 16384) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r38 & 32768) == 0) goto L61;
        JSONObject r2 = new JSONObject();
    L63:
        if ((r38 & 65536) == 0) goto L65;
        by7.e r18 = null;
    L67:
        if ((r38 & 131072) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r38 & 524288) == 0) goto L73;
        Integer r16 = null;
    L74:
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r1 != null) goto L121;
    L79:
        if (r3 == null) goto L81;
        r2.put("click_from", r3);     // Catch: JSONException -> L77
    L81:
        if (r4 == null) goto L83;
        r2.put("conversation_id", r4);     // Catch: JSONException -> L77
    L83:
        if (r5 == null) goto L85;
        r2.put("current_page", r5);     // Catch: JSONException -> L77
    L85:
        if (r6 == null) goto L87;
        r2.put("previous_page", r6);     // Catch: JSONException -> L77
    L87:
        if (r7 == null) goto L89;
        r2.put("previous_module", r7);     // Catch: JSONException -> L77
    L89:
        if (r8 == null) goto L91;
        r2.put("user_type", r8);     // Catch: JSONException -> L77
    L91:
        if (r9 == null) goto L93;
        r2.put("click_module", r9);     // Catch: JSONException -> L77
    L93:
        if (r10 == null) goto L95;
        r2.put("message_id", r10);     // Catch: JSONException -> L77
    L95:
        if (r11 != null) goto L97;
    L101:
        if (r12 == null) goto L103;
        r2.put("chat_type", r12);     // Catch: JSONException -> L77
    L103:
        if (r13 == null) goto L105;
        r2.put("recommend_from", r13);     // Catch: JSONException -> L77
    L105:
        if (r14 == null) goto L107;
        r2.put("user_case_item_id", r14);     // Catch: JSONException -> L77
    L107:
        if (r15 == null) goto L109;
        r2.put("user_case_reco_request_id", r15);     // Catch: JSONException -> L77
    L109:
        String r0 = r19;
        if (r0 == null) goto L112;
        r2.put("page_token", r0);     // Catch: JSONException -> L77
    L112:
        if (r16 == null) goto L116;
        r2.put("resource_type", r16.intValue());     // Catch: JSONException -> L77
    L77:
        e = move-exception;
        FLogger.a.e("CreateEventHelper", "error in CreateEventHelper createNewChat " + e.getLocalizedMessage());
    L116:
        TrackParams r17 = new TrackParams().merge(r2);
        by7.a r39 = new by7.a("create_new_chat");
        by7.e r40 = r18;
        if (r40 == null) goto L119;
        r39.b = r40;
    L119:
        r39.a.merge(r17);
        r39.b();
        return;
    L97:
        if (r11.booleanValue() == false) goto L99;
        int r41 = 1;
    L100:
        r2.put("success", r41);     // Catch: JSONException -> L77
        goto L101
    L99:
        r41 = 0;
        goto L100
    L121:
        r2.put("bot_id", r1);     // Catch: JSONException -> L77
        goto L79
    L73:
        r16 = r37;
        goto L74
    L69:
        r19 = r36;
        goto L71
    L65:
        r18 = r35;
        goto L67
    L61:
        r2 = r34;
        goto L63
    L57:
        r15 = r33;
        goto L59
    L53:
        r14 = r32;
        goto L55
    L49:
        r13 = r31;
        goto L51
    L45:
        r12 = r30;
        goto L47
    L41:
        r11 = r29;
        goto L43
    L37:
        r10 = r28;
        goto L39
    L33:
        r9 = r27;
        goto L35
    L29:
        r8 = r26;
        goto L31
    L25:
        r7 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
