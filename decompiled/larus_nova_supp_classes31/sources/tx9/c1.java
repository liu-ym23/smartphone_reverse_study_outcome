package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c1 {
    public static void a(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, Long r26, String r27, String r28, String r29, String r30, String r31, String r32, JSONObject r33, by7.e r34, int r35) {
        if ((r35 & 1) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r35 & 2) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r35 & 8) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r35 & 64) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r35 & 128) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r35 & 256) == 0) goto L37;
        Long r10 = null;
    L39:
        if ((r35 & 512) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r35 & 16384) == 0) goto L61;
        Object r2 = null;
    L63:
        if ((r35 & 32768) == 0) goto L65;
        JSONObject r16 = new JSONObject();
    L67:
        if ((r35 & 65536) == 0) goto L69;
        by7.e r17 = null;
    L70:
        Intrinsics.checkNotNullParameter(r16, "params");
        if (r1 != null) goto L110;
    L75:
        if (r3 == null) goto L77;
        r16.put("conversation_id", r3);     // Catch: JSONException -> L73
    L77:
        if (r4 == null) goto L79;
        r16.put("bot_id", r4);     // Catch: JSONException -> L73
    L79:
        if (r6 == null) goto L81;
        r16.put("voice_id", r6);     // Catch: JSONException -> L73
    L81:
        if (r7 == null) goto L83;
        r16.put("to_tts_speaker", r7);     // Catch: JSONException -> L73
    L83:
        if (r5 == null) goto L85;
        r16.put("chat_type", r5);     // Catch: JSONException -> L73
    L85:
        if (r8 == null) goto L87;
        r16.put("start_method", r8);     // Catch: JSONException -> L73
    L87:
        if (r9 == null) goto L89;
        r16.put("end_method", r9);     // Catch: JSONException -> L73
    L89:
        if (r10 == null) goto L91;
        r16.put("duration", r10.longValue());     // Catch: JSONException -> L73
    L91:
        if (r11 == null) goto L93;
        r16.put("speaker_id", r11);     // Catch: JSONException -> L73
    L93:
        if (r12 == null) goto L95;
        r16.put("speaker_name", r12);     // Catch: JSONException -> L73
    L95:
        if (r13 == null) goto L97;
        r16.put("intention_dialect", r13);     // Catch: JSONException -> L73
    L97:
        if (r14 == null) goto L99;
        r16.put("tts_dialect", r14);     // Catch: JSONException -> L73
    L99:
        if (r15 == null) goto L101;
        r16.put("is_deep_thinking", r15);     // Catch: JSONException -> L73
    L101:
        if (r2 == 0) goto L105;
        r16.put("is_simultaneous_interpretation", r2);     // Catch: JSONException -> L73
    L73:
        e = move-exception;
        FLogger.a.e("FinishEventHelper", "error in FinishEventHelper finishTTS " + e.getLocalizedMessage());
    L105:
        TrackParams r0 = new TrackParams().merge(r16);
        by7.a r36 = new by7.a("finish_tts");
        by7.e r37 = r17;
        if (r37 == null) goto L108;
        r36.b = r37;
    L108:
        r36.a.merge(r0);
        r36.b();
        return;
    L110:
        r16.put("message_id", r1);     // Catch: JSONException -> L73
        goto L75
    L69:
        r17 = r34;
        goto L70
    L65:
        r16 = r33;
        goto L67
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
