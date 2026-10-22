package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e1 {
    public static void a(String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, JSONObject r34, by7.e r35, int r36) {
        if ((r36 & 2) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r36 & 4) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r36 & 8) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r36 & 32) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r36 & 64) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r36 & 128) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r36 & 256) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r36 & 2048) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r36 & 4096) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r36 & 8192) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((32768 & r36) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((65536 & r36) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((131072 & r36) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((524288 & r36) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r36 & 1048576) == 0) goto L61;
        Object r2 = null;
    L63:
        if ((r36 & 2097152) == 0) goto L65;
        JSONObject r16 = new JSONObject();
    L67:
        if ((r36 & 4194304) == 0) goto L69;
        by7.e r18 = null;
    L70:
        Intrinsics.checkNotNullParameter(r16, "params");
        if (r1 != null) goto L110;
    L75:
        if (r3 == null) goto L77;
        r16.put("chat_type", r3);     // Catch: JSONException -> L73
    L77:
        if (r4 == null) goto L79;
        r16.put("click_from", r4);     // Catch: JSONException -> L73
    L79:
        if (r5 == null) goto L81;
        r16.put("discover_page_bot_type", r5);     // Catch: JSONException -> L73
    L81:
        if (r6 == null) goto L83;
        r16.put("enter_method", r6);     // Catch: JSONException -> L73
    L83:
        if (r7 == null) goto L85;
        r16.put("is_immersive_background", r7);     // Catch: JSONException -> L73
    L85:
        if (r8 == null) goto L87;
        r16.put("previous_page", r8);     // Catch: JSONException -> L73
    L87:
        if (r9 == null) goto L89;
        r16.put("rank", r9);     // Catch: JSONException -> L73
    L89:
        if (r10 == null) goto L91;
        r16.put("recommend_from", r10);     // Catch: JSONException -> L73
    L91:
        if (r11 == null) goto L93;
        r16.put("req_id", r11);     // Catch: JSONException -> L73
    L93:
        if (r12 == null) goto L95;
        r16.put("search_id", r12);     // Catch: JSONException -> L73
    L95:
        if (r13 == null) goto L97;
        r16.put("search_request_id", r13);     // Catch: JSONException -> L73
    L97:
        if (r14 == null) goto L99;
        r16.put("search_result_id", r14);     // Catch: JSONException -> L73
    L99:
        if (r15 == null) goto L101;
        r16.put("group_type", r15);     // Catch: JSONException -> L73
    L101:
        if (r2 == 0) goto L105;
        r16.put("item_id", r2);     // Catch: JSONException -> L73
    L73:
        e = move-exception;
        FLogger.a.e("FollowEventHelper", "error in FollowEventHelper followBot " + e.getLocalizedMessage());
    L105:
        TrackParams r0 = new TrackParams().merge(r16);
        by7.a r17 = new by7.a("follow_bot");
        by7.e r37 = r18;
        if (r37 == null) goto L108;
        r17.b = r37;
    L108:
        r17.a.merge(r0);
        r17.b();
        return;
    L110:
        r16.put("bot_id", r1);     // Catch: JSONException -> L73
        goto L75
    L69:
        r18 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r2 = r33;
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
}
