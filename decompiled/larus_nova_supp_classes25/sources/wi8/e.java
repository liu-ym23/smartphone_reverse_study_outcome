package wi8;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.n2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public e() {
    }

    public static /* synthetic */ void b(boolean r13, String r14, boolean r15, String r16, String r17, boolean r18, boolean r19, String r20, String r21, by7.e r22, int r23) {
        if ((r23 & 256) == 0) goto L5;
        String r9 = "click_tts_button";
    L6:
        a(r13, r14, r15, r16, r17, r18, r19, r20, r9, null, null, r22);
        return;
    L5:
        r9 = r21;
        goto L6
    }

    public static void a(boolean r20, String r21, boolean r22, String r23, String r24, boolean r25, boolean r26, String r27, String r28, Long r29, Long r30, by7.e r31) {
        Intrinsics.checkNotNullParameter(r21, "botId");
        Intrinsics.checkNotNullParameter(r23, "conversationId");
        Intrinsics.checkNotNullParameter(r24, "chatType");
        String r6 = r28;
        Intrinsics.checkNotNullParameter(r6, "ttsOpenMethod");
        long r7 = -1;
        if (r22 == false) goto L5;
        long r11 = -1;
    L8:
        if (r22 == true) goto L11;
        r7 = 1 - r11;
    L11:
        String r5 = "1";
        if (r25 == false) goto L14;
        Object r14 = "1";
    L15:
        if (r30 == null) goto L17;
        long r15 = r30.longValue();
    L18:
        Long r16 = Long.valueOf(r15);
        if (r29 == null) goto L21;
        r7 = r29.longValue();
    L21:
        Long r8 = Long.valueOf(r7);
        Long r9 = 1L;
        Boolean r10 = Boolean.valueOf(r26);
        Integer r18 = Integer.valueOf(n2.a());
        if (r30 == null) goto L25;
        r11 = r30.longValue();
    L25:
        if (r11 == 1) goto L28;
        r6 = "";
    L28:
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r12, "params");
        r12.put("bot_id", r21);     // Catch: JSONException -> L55
        if (r16 == null) goto L33;
        r12.put("status", r16.longValue());     // Catch: JSONException -> L55
    L33:
        if (r8 == null) goto L35;
        r12.put("from_status", r8.longValue());     // Catch: JSONException -> L55
    L35:
        r12.put("conversation_id", r23);     // Catch: JSONException -> L55
        if (r9 == null) goto L38;
        r12.put("bot_cnt", r9.longValue());     // Catch: JSONException -> L55
    L38:
        r12.put("group_type", "private");     // Catch: JSONException -> L55
        if (r24 == null) goto L41;
        r12.put("chat_type", r24);     // Catch: JSONException -> L55
    L41:
        r12.put("is_message_generating", r14);     // Catch: JSONException -> L55
        if (r27 == null) goto L44;
        r12.put("enter_method", r27);     // Catch: JSONException -> L55
    L44:
        if (r18 == null) goto L46;
        r12.put("tts_speaker_volume", r18.intValue());     // Catch: JSONException -> L55
    L46:
        if (r6 == null) goto L48;
        r12.put("tts_open_method", r6);     // Catch: JSONException -> L55
    L48:
        if (r10 != null) goto L50;
    L57:
        TrackParams r0 = new TrackParams().merge(r12);
        by7.a r1 = new by7.a("click_tts_switch");
        if (r31 == null) goto L60;
        r1.b = r31;
    L60:
        r1.a.merge(r0);
        r1.b();
        g.a.monitorEventForSlardar("click_tts_switch", r1.c(), null, null);
        return;
    L50:
        if (r10.booleanValue() == true) goto L53;
        r5 = "0";
    L53:
        r12.put("is_thinking_generating", r5);     // Catch: JSONException -> L55
    L55:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickTtsSwitch " + e.getLocalizedMessage());
        goto L57
    L17:
        r15 = r11;
        goto L18
    L14:
        r14 = "0";
        goto L15
    L5:
        if (r20 == false) goto L7;
        r11 = 1;
        goto L8
    L7:
        r11 = 0;
        goto L8
    }
}
