package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q1 {
    public static void a(Integer r22, String r23, String r24, String r25, String r26, String r27, String r28, Long r29, String r30, String r31, String r32, String r33, String r34, Boolean r35, String r36, String r37, String r38, String r39, String r40, int r41) {
        if ((r41 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r41 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r41 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r41 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r41 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r41 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r41 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r41 & 128) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r41 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r41 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r41 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r41 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r41 & 8192) == 0) goto L57;
        JSONObject r15 = new JSONObject();
    L59:
        if ((r41 & 32768) == 0) goto L61;
        Boolean r16 = null;
    L63:
        if ((r41 & 65536) == 0) goto L65;
        String r2 = null;
    L67:
        if ((r41 & 131072) == 0) goto L69;
        String r19 = null;
    L71:
        if ((r41 & 262144) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r41 & 524288) == 0) goto L77;
        String r21 = null;
    L79:
        if ((r41 & 1048576) == 0) goto L81;
        String r210 = null;
    L82:
        Intrinsics.checkNotNullParameter(r15, "params");
        if (r1 != null) goto L130;
    L87:
        if (r3 == null) goto L89;
        r15.put("is_best_match", r3);     // Catch: JSONException -> L85
    L89:
        if (r4 == null) goto L91;
        r15.put("is_public", r4);     // Catch: JSONException -> L85
    L91:
        if (r5 == null) goto L93;
        r15.put("recommend_from", r5);     // Catch: JSONException -> L85
    L93:
        if (r6 == null) goto L95;
        r15.put("req_id", r6);     // Catch: JSONException -> L85
    L95:
        if (r7 == null) goto L97;
        r15.put("voice_id", r7);     // Catch: JSONException -> L85
    L97:
        if (r8 == null) goto L99;
        r15.put("voice_type", r8);     // Catch: JSONException -> L85
    L99:
        if (r10 == null) goto L101;
        r15.put("voice_remix_id", r10);     // Catch: JSONException -> L85
    L101:
        if (r11 == null) goto L103;
        r15.put("method", r11);     // Catch: JSONException -> L85
    L103:
        if (r14 == null) goto L105;
        r15.put("if_mix_voice", r14);     // Catch: JSONException -> L85
    L105:
        if (r9 == null) goto L107;
        r15.put("duration", r9.longValue());     // Catch: JSONException -> L85
    L107:
        if (r12 == null) goto L109;
        r15.put("speaker_id", r12);     // Catch: JSONException -> L85
    L109:
        if (r13 == null) goto L111;
        r15.put("speaker_name", r13);     // Catch: JSONException -> L85
    L111:
        if (r16 == null) goto L113;
        r15.put("if_voice_change", r16.booleanValue() ? 1 : 0);     // Catch: JSONException -> L85
    L113:
        if (r2 == null) goto L115;
        r15.put("scene", r2);     // Catch: JSONException -> L85
    L115:
        String r0 = r19;
        if (r0 == null) goto L118;
        r15.put("click_from", r0);     // Catch: JSONException -> L85
    L118:
        String r17 = r20;
        if (r17 == null) goto L121;
        r15.put("from_voice_id", r17);     // Catch: JSONException -> L85
    L121:
        String r18 = r21;
        if (r18 == null) goto L124;
        r15.put("to_tts_speaker", r18);     // Catch: JSONException -> L85
    L124:
        if (r210 == null) goto L128;
        r15.put("bot_id", r210);     // Catch: JSONException -> L85
    L85:
        e = move-exception;
        FLogger.a.e("LeaveEventHelper", "error in LeaveEventHelper leaveChangeVoicePage " + e.getLocalizedMessage());
    L128:
        TrackParams r42 = new TrackParams().merge(r15);
        by7.a r43 = new by7.a("leave_change_voice_page");
        r43.a.merge(r42);
        r43.b();
        return;
    L130:
        r15.put("change_voice_cnt", r1.intValue());     // Catch: JSONException -> L85
        goto L87
    L81:
        r210 = r40;
        goto L82
    L77:
        r21 = r39;
        goto L79
    L73:
        r20 = r38;
        goto L75
    L69:
        r19 = r37;
        goto L71
    L65:
        r2 = r36;
        goto L67
    L61:
        r16 = r35;
        goto L63
    L57:
        r15 = null;
        goto L59
    L53:
        r14 = r34;
        goto L55
    L49:
        r13 = r33;
        goto L51
    L45:
        r12 = r32;
        goto L47
    L41:
        r11 = r31;
        goto L43
    L37:
        r10 = r30;
        goto L39
    L33:
        r9 = r29;
        goto L35
    L29:
        r8 = r28;
        goto L31
    L25:
        r7 = r27;
        goto L27
    L21:
        r6 = r26;
        goto L23
    L17:
        r5 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }
}
