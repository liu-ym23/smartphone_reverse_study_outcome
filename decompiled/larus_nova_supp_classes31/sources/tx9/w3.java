package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w3 {
    public static void a(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, by7.e r30, int r31) {
        by7.e r2 = null;
        if ((r31 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r31 & 128) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r31 & 256) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r31 & 512) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r31 & 2048) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r31 & 4096) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r31 & 8192) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r31 & 16384) == 0) goto L49;
        String r13 = null;
    L51:
        if ((32768 & r31) == 0) goto L53;
        String r14 = null;
    L55:
        if ((65536 & r31) == 0) goto L57;
        JSONObject r15 = new JSONObject();
    L59:
        if ((r31 & 131072) != 0) goto L62;
        r2 = r30;
    L62:
        Intrinsics.checkNotNullParameter(r15, "params");
        if (r1 != null) goto L98;
    L67:
        if (r3 == null) goto L69;
        r15.put("click_from", r3);     // Catch: JSONException -> L65
    L69:
        if (r4 == null) goto L71;
        r15.put("current_page", r4);     // Catch: JSONException -> L65
    L71:
        if (r5 == null) goto L73;
        r15.put("is_immersive_background", r5);     // Catch: JSONException -> L65
    L73:
        if (r6 == null) goto L75;
        r15.put("previous_page", r6);     // Catch: JSONException -> L65
    L75:
        if (r7 == null) goto L77;
        r15.put("rank", r7);     // Catch: JSONException -> L65
    L77:
        if (r8 == null) goto L79;
        r15.put("recommend_from", r8);     // Catch: JSONException -> L65
    L79:
        if (r9 == null) goto L81;
        r15.put("req_id", r9);     // Catch: JSONException -> L65
    L81:
        if (r10 == null) goto L83;
        r15.put("search_id", r10);     // Catch: JSONException -> L65
    L83:
        if (r11 == null) goto L85;
        r15.put("search_request_id", r11);     // Catch: JSONException -> L65
    L85:
        if (r12 == null) goto L87;
        r15.put("search_result_id", r12);     // Catch: JSONException -> L65
    L87:
        if (r13 == null) goto L89;
        r15.put("is_call_bot", r13);     // Catch: JSONException -> L65
    L89:
        if (r14 == null) goto L93;
        r15.put("is_navigation_sidebar", r14);     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.a.e("UnfollowEventHelper", "error in UnfollowEventHelper unfollowBot " + e.getLocalizedMessage());
    L93:
        TrackParams r0 = new TrackParams().merge(r15);
        by7.a r16 = new by7.a("unfollow_bot");
        if (r2 == null) goto L96;
        r16.b = r2;
    L96:
        r16.a.merge(r0);
        r16.b();
        return;
    L98:
        r15.put("bot_id", r1);     // Catch: JSONException -> L65
        goto L67
    L57:
        r15 = null;
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
}
