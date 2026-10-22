package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k1 {
    public static void a(String r2, String r3, String r4, String r5, Integer r6, String r7, by7.e r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        JSONObject r0 = new JSONObject();
    L25:
        if ((r9 & 128) == 0) goto L27;
        r8 = null;
    L27:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L49;
    L32:
        if (r3 == null) goto L34;
        r0.put("click_from", r3);     // Catch: JSONException -> L30
    L34:
        if (r4 == null) goto L36;
        r0.put("current_page", r4);     // Catch: JSONException -> L30
    L36:
        if (r5 == null) goto L38;
        r0.put("chat_type", r5);     // Catch: JSONException -> L30
    L38:
        if (r6 == null) goto L40;
        r0.put("bot_type", r6.intValue());     // Catch: JSONException -> L30
    L40:
        if (r7 == null) goto L44;
        r0.put("is_navigation_sidebar", r7);     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        FLogger.a.e("HideChatEventHelper", "error in HideChatEventHelper hideChat " + e.getLocalizedMessage());
    L44:
        TrackParams r10 = new TrackParams().merge(r0);
        by7.a r11 = new by7.a("hide_chat");
        if (r8 == null) goto L47;
        r11.b = r8;
    L47:
        r11.a.merge(r10);
        r11.b();
        return;
    L49:
        r0.put("bot_id", r2);     // Catch: JSONException -> L30
        goto L32
    L23:
        r0 = null;
        goto L25
    }
}
