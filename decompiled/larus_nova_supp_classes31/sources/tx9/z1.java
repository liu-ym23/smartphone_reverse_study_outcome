package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z1 {
    public static void a(String r2, String r3, String r4, Boolean r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L20;
    L7:
        if (r3 == null) goto L9;
        r0.put("message_id", r3);     // Catch: JSONException -> L5
    L9:
        if (r5 != null) goto L11;
    L15:
        r0.put("action", r4);     // Catch: JSONException -> L5
    L18:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("dev_message_negative_report");
        r7.a.merge(r6);
        r7.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("MessageEventHelper", "error in MessageEventHelper mobDevMessageReportResult " + e.getLocalizedMessage());
        goto L18
    L11:
        if (r5.booleanValue() == false) goto L13;
        int r8 = 1;
    L14:
        r0.put("success", r8);     // Catch: JSONException -> L5
        goto L15
    L13:
        r8 = 0;
        goto L14
    L20:
        r0.put("conversation_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r16, Integer r17, String r18, String r19, String r20, Long r21, String r22, String r23, String r24, Long r25, String r26, String r27, Map r28, JSONObject r29, int r30) {
        Map r2 = null;
        if ((r30 & 1) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        Long r7 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((r30 & 4096) != 0) goto L55;
        r2 = r28;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        JSONObject r14 = new JSONObject();
    L58:
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r2 != null) goto L94;
    L66:
        if (r1 == null) goto L68;
        r14.put("bot_id", r1);     // Catch: JSONException -> L64
    L68:
        if (r3 == null) goto L70;
        r14.put("bot_type", r3.intValue());     // Catch: JSONException -> L64
    L70:
        if (r4 == null) goto L72;
        r14.put("click_from", r4);     // Catch: JSONException -> L64
    L72:
        if (r5 == null) goto L74;
        r14.put("conversation_id", r5);     // Catch: JSONException -> L64
    L74:
        if (r6 == null) goto L76;
        r14.put("is_onboarding", r6);     // Catch: JSONException -> L64
    L76:
        if (r7 == null) goto L78;
        r14.put("is_read", r7.longValue());     // Catch: JSONException -> L64
    L78:
        if (r8 == null) goto L80;
        r14.put("message_id", r8);     // Catch: JSONException -> L64
    L80:
        if (r9 == null) goto L82;
        r14.put("message_type", r9);     // Catch: JSONException -> L64
    L82:
        if (r10 == null) goto L84;
        r14.put("user_type", r10);     // Catch: JSONException -> L64
    L84:
        if (r11 == null) goto L86;
        r14.put("voice_id", r11.longValue());     // Catch: JSONException -> L64
    L86:
        if (r12 == null) goto L88;
        r14.put("speaker_id", r12);     // Catch: JSONException -> L64
    L88:
        if (r13 == null) goto L92;
        r14.put("speaker_name", r13);     // Catch: JSONException -> L64
    L64:
        e = move-exception;
        FLogger.a.e("MessageEventHelper", "error in MessageEventHelper messageDelete " + e.getLocalizedMessage());
    L92:
        TrackParams r0 = new TrackParams().merge(r14);
        by7.a r15 = new by7.a("message_delete");
        r15.a.merge(r0);
        r15.b();
        return;
    L94:
        Iterator r31 = r2.entrySet().iterator();     // Catch: JSONException -> L64
    L62:
        if (r31.hasNext() == false) goto L66;
        Map.Entry r32 = (Map.Entry) r31.next();     // Catch: JSONException -> L64
        r14.put((String) r32.getKey(), r32.getValue());     // Catch: JSONException -> L64
        goto L62
    L57:
        r14 = r29;
        goto L58
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }

    public static void c(String r18, Integer r19, String r20, String r21, String r22, String r23, Long r24, String r25, String r26, String r27, String r28, Long r29, String r30, String r31, Map r32, JSONObject r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        Map r16 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        JSONObject r2 = new JSONObject();
    L66:
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r16 != null) goto L107;
    L74:
        Object r110 = r15;
        if (r1 == null) goto L77;
        r2.put("bot_id", r1);     // Catch: JSONException -> L72
    L77:
        if (r3 == null) goto L79;
        r2.put("bot_type", r3.intValue());     // Catch: JSONException -> L72
    L79:
        if (r4 == null) goto L81;
        r2.put("click_from", r4);     // Catch: JSONException -> L72
    L81:
        if (r5 == null) goto L83;
        r2.put("conversation_id", r5);     // Catch: JSONException -> L72
    L83:
        if (r6 == null) goto L85;
        r2.put("error", r6);     // Catch: JSONException -> L72
    L85:
        if (r7 == null) goto L87;
        r2.put("is_onboarding", r7);     // Catch: JSONException -> L72
    L87:
        if (r8 == null) goto L89;
        r2.put("is_read", r8.longValue());     // Catch: JSONException -> L72
    L89:
        if (r9 == null) goto L91;
        r2.put("is_success", r9);     // Catch: JSONException -> L72
    L91:
        if (r10 == null) goto L93;
        r2.put("message_id", r10);     // Catch: JSONException -> L72
    L93:
        if (r11 == null) goto L95;
        r2.put("message_type", r11);     // Catch: JSONException -> L72
    L95:
        if (r12 == null) goto L97;
        r2.put("user_type", r12);     // Catch: JSONException -> L72
    L97:
        if (r13 == null) goto L99;
        r2.put("voice_id", r13.longValue());     // Catch: JSONException -> L72
    L99:
        if (r14 == null) goto L101;
        r2.put("speaker_id", r14);     // Catch: JSONException -> L72
    L101:
        if (r110 == null) goto L105;
        r2.put("speaker_name", r110);     // Catch: JSONException -> L72
    L72:
        e = move-exception;
        FLogger.a.e("MessageEventHelper", "error in MessageEventHelper messageDeleteResult " + e.getLocalizedMessage());
    L105:
        TrackParams r0 = new TrackParams().merge(r2);
        by7.a r17 = new by7.a("message_delete_result");
        r17.a.merge(r0);
        r17.b();
        return;
    L107:
        Iterator r35 = r16.entrySet().iterator();     // Catch: JSONException -> L72
    L70:
        if (r35.hasNext() == false) goto L74;
        Map.Entry r111 = (Map.Entry) r35.next();     // Catch: JSONException -> L72
        r2.put((String) r111.getKey(), r111.getValue());     // Catch: JSONException -> L72
        r35 = r35;
        r15 = r15;
        goto L70
    L65:
        r2 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
