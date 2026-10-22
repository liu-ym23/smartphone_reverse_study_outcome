package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l1 {
    public static void a(String r15, String r16, String r17, String r18, Long r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, JSONObject r28, int r29) {
        Object r2 = null;
        if ((r29 & 1) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r29 & 2) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r29 & 4) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r29 & 8) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r29 & 16) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r29 & 32) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r29 & 64) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r29 & 128) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r29 & 256) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r29 & 512) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((r29 & 4096) != 0) goto L55;
        r2 = r27;
    L55:
        if ((r29 & 8192) == 0) goto L57;
        JSONObject r14 = new JSONObject();
    L58:
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r1 != null) goto L91;
    L63:
        if (r3 == null) goto L65;
        r14.put("conversation_id", r3);     // Catch: JSONException -> L61
    L65:
        if (r11 == null) goto L67;
        r14.put("entity_id", r11);     // Catch: JSONException -> L61
    L67:
        if (r10 == null) goto L69;
        r14.put("bcm_id", r10);     // Catch: JSONException -> L61
    L69:
        if (r4 == null) goto L71;
        r14.put("current_page", r4);     // Catch: JSONException -> L61
    L71:
        if (r5 == null) goto L73;
        r14.put("message_id", r5);     // Catch: JSONException -> L61
    L73:
        if (r6 == null) goto L75;
        r14.put("position", r6.longValue());     // Catch: JSONException -> L61
    L75:
        if (r7 == null) goto L77;
        r14.put("text", r7);     // Catch: JSONException -> L61
    L77:
        if (r13 == null) goto L79;
        r14.put("url", r13);     // Catch: JSONException -> L61
    L79:
        if (r2 == null) goto L81;
        r14.put("doc_id", r2);     // Catch: JSONException -> L61
    L81:
        if (r8 == null) goto L83;
        r14.put("baike_id", r8);     // Catch: JSONException -> L61
    L83:
        if (r9 == null) goto L85;
        r14.put("link_type", r9);     // Catch: JSONException -> L61
    L85:
        if (r12 == null) goto L89;
        r14.put("agent_id", r12);     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        FLogger.a.e("HighlightEventHelper", "error in HighlightEventHelper highlightWordShow " + e.getLocalizedMessage());
    L89:
        TrackParams r0 = new TrackParams().merge(r14);
        by7.a r30 = new by7.a("highlight_word_show");
        r30.a.merge(r0);
        r30.b();
        return;
    L91:
        r14.put("bot_id", r1);     // Catch: JSONException -> L61
        goto L63
    L57:
        r14 = r28;
        goto L58
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
