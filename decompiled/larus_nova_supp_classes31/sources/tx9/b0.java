package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 {
    public static void a(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, long r12, JSONObject r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r15 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r15 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r15 & 128) == 0) goto L27;
        r10 = null;
    L27:
        if ((r15 & 256) == 0) goto L30;
        r11 = null;
    L30:
        if ((r15 & 512) == 0) goto L33;
        r12 = 0;
    L33:
        if ((r15 & 1024) == 0) goto L35;
        r14 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r3 != null) goto L63;
    L40:
        if (r4 == null) goto L42;
        r14.put("current_page", r4);     // Catch: JSONException -> L38
    L42:
        if (r5 == null) goto L44;
        r14.put("click_from", r5);     // Catch: JSONException -> L38
    L44:
        if (r6 == null) goto L46;
        r14.put("message_id", r6);     // Catch: JSONException -> L38
    L46:
        if (r7 == null) goto L48;
        r14.put("section_id", r7);     // Catch: JSONException -> L38
    L48:
        if (r8 == null) goto L50;
        r14.put("bot_id", r8);     // Catch: JSONException -> L38
    L50:
        if (r9 == null) goto L52;
        r14.put("conversation_id", r9);     // Catch: JSONException -> L38
    L52:
        if (r10 == null) goto L54;
        r14.put("chat_type", r10);     // Catch: JSONException -> L38
    L54:
        if (r11 == null) goto L57;
        r14.put("is_immersive_background", r11);     // Catch: JSONException -> L38
    L57:
        if (r12 < 0) goto L61;
        r14.put("duration", r12);     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.a.e("ClickButtonEventHelper", "error in ClickButtonEventHelper " + e.getLocalizedMessage());
    L61:
        TrackParams r13 = new TrackParams().merge(r14);
        by7.a r16 = new by7.a("click_button");
        r16.a.merge(r13);
        r16.b();
        return;
    L63:
        r14.put("button_name", r3);     // Catch: JSONException -> L38
        goto L40
    }
}
