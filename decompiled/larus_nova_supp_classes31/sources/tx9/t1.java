package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t1 {
    public static void a(String r18, Long r19, String r20, String r21, String r22, Boolean r23, JSONObject r24, by7.e r25, String r26, String r27, Integer r28, String r29, String r30, Boolean r31, String r32, Map r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r34 & 64) == 0) goto L25;
        Boolean r7 = null;
    L27:
        if ((r34 & 128) == 0) goto L29;
        JSONObject r8 = new JSONObject();
    L31:
        if ((r34 & 256) == 0) goto L33;
        by7.e r9 = null;
    L35:
        if ((r34 & 512) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r34 & 1024) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r34 & 2048) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r34 & 4096) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r34 & 8192) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r34 & 16384) == 0) goto L57;
        Boolean r15 = null;
    L59:
        if ((r34 & 32768) == 0) goto L61;
        String r2 = "text";
    L63:
        if ((r34 & 65536) == 0) goto L65;
        Map r16 = null;
    L66:
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r16 != null) goto L120;
    L76:
        by7.e r110 = r9;
        r8.putOpt("content_type", r2);     // Catch: JSONException -> L111
        if (r1 == null) goto L79;
        r8.put("bot_id", r1);     // Catch: JSONException -> L111
    L79:
        if (r3 == null) goto L81;
        r8.put("conversation_id", r3.longValue());     // Catch: JSONException -> L111
    L81:
        if (r4 == null) goto L83;
        r8.put("current_page", r4);     // Catch: JSONException -> L111
    L83:
        if (r5 == null) goto L85;
        r8.put("message_from", r5);     // Catch: JSONException -> L111
    L85:
        if (r6 == null) goto L87;
        r8.put("message_id", r6);     // Catch: JSONException -> L111
    L87:
        if (r10 == null) goto L89;
        r8.put("agent_id", r10);     // Catch: JSONException -> L111
    L89:
        if (r11 == null) goto L91;
        r8.put("chat_type", r11);     // Catch: JSONException -> L111
    L91:
        if (r12 == null) goto L93;
        r8.put("bot_type", r12.intValue());     // Catch: JSONException -> L111
    L93:
        if (r13 == null) goto L95;
        r8.put("group_type", r13);     // Catch: JSONException -> L111
    L95:
        String r0 = "1";
        if (r7 != null) goto L98;
    L102:
        if (r14 == null) goto L104;
        r8.put("click_module", r14);     // Catch: JSONException -> L111
    L104:
        if (r15 != null) goto L106;
    L113:
        TrackParams r17 = new TrackParams().merge(r8);
        by7.a r35 = new by7.a("long_press_message");
        if (r110 == null) goto L116;
        r35.b = r110;
    L116:
        r35.a.merge(r17);
        r35.b();
        return;
    L106:
        if (r15.booleanValue() == true) goto L109;
        r0 = "0";
    L109:
        r8.put("is_thinking_generating", r0);     // Catch: JSONException -> L111
    L111:
        e = e;
    L112:
        FLogger.a.e("LongEventHelper", "error in LongEventHelper longPressMessage " + e.getLocalizedMessage());
        goto L113
    L98:
        if (r7.booleanValue() == false) goto L100;
        Object r36 = "1";
    L101:
        r8.put("is_message_generating", r36);     // Catch: JSONException -> L111
        goto L102
    L100:
        r36 = "0";
        goto L101
    L120:
        Iterator r37 = r16.entrySet().iterator();     // Catch: JSONException -> L74
    L70:
        if (r37.hasNext() == false) goto L76;
        Map.Entry r111 = (Map.Entry) r37.next();     // Catch: JSONException -> L74
        Iterator r112 = r37;
        r110 = r9;
        r8.put((String) r111.getKey(), r111.getValue());     // Catch: JSONException -> L111
        r37 = r112;
        r9 = r110;
    L74:
        e = e;
        r110 = r9;
        goto L112
    L65:
        r16 = r33;
        goto L66
    L61:
        r2 = r32;
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
