package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h3 {
    public static void a(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, String r9, String r10, String r11, JSONObject r12, by7.e r13, int r14) {
        if ((r14 & 512) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 1024) == 0) goto L9;
        r12 = new JSONObject();
    L9:
        if ((r14 & 2048) == 0) goto L11;
        r13 = null;
    L11:
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r2 != null) goto L39;
    L16:
        if (r3 == null) goto L18;
        r12.put("reply_id", r3);     // Catch: JSONException -> L14
    L18:
        if (r4 == null) goto L20;
        r12.put("conversation_id", r4);     // Catch: JSONException -> L14
    L20:
        if (r5 == null) goto L22;
        r12.put("bot_id", r5);     // Catch: JSONException -> L14
    L22:
        r12.put("chat_type", r6);     // Catch: JSONException -> L14
        if (r7 == null) goto L25;
        r12.put("shot_id", r7);     // Catch: JSONException -> L14
    L25:
        if (r8 == null) goto L27;
        r12.put("is_last_message", r8.intValue());     // Catch: JSONException -> L14
    L27:
        if (r9 == null) goto L29;
        r12.put("reply_status", r9);     // Catch: JSONException -> L14
    L29:
        r12.put("current_page", r10);     // Catch: JSONException -> L14
        if (r11 == null) goto L34;
        r12.put("ai_creation_message_id", r11);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.a.e("ScreenshotEventHelper", "error in ScreenshotEventHelper sami " + e.getLocalizedMessage());
    L34:
        TrackParams r15 = new TrackParams().merge(r12);
        by7.a r16 = new by7.a("screenshot");
        if (r13 == null) goto L37;
        r16.b = r13;
    L37:
        r16.a.merge(r15);
        r16.b();
        return;
    L39:
        r12.put("recent_bot_message_id", r2);     // Catch: JSONException -> L14
        goto L16
    }
}
