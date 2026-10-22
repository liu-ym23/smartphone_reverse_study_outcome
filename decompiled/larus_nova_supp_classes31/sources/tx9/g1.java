package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g1 {
    public static void a(String r6, String r7, String r8, Function0 r9, by7.e r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r7 = null;
    L9:
        if ((r11 & 4) == 0) goto L11;
        String r0 = null;
    L13:
        if ((r11 & 8) == 0) goto L16;
        r8 = null;
    L16:
        if ((r11 & 16) == 0) goto L18;
        String r2 = null;
    L20:
        if ((r11 & 32) == 0) goto L22;
        String r3 = null;
    L24:
        if ((r11 & 64) == 0) goto L26;
        JSONObject r4 = new JSONObject();
    L28:
        if ((r11 & 128) == 0) goto L31;
        r9 = null;
    L31:
        if ((r11 & 256) == 0) goto L33;
        r10 = null;
    L33:
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r6 != null) goto L62;
    L38:
        if (r7 == null) goto L40;
        r4.put("message_id", r7);     // Catch: JSONException -> L36
    L40:
        if (r0 == null) goto L42;
        r4.put("message_type", r0);     // Catch: JSONException -> L36
    L42:
        if (r8 == null) goto L44;
        r4.put("content_type", r8);     // Catch: JSONException -> L36
    L44:
        if (r3 == null) goto L46;
        r4.put("click_from", r3);     // Catch: JSONException -> L36
    L46:
        if (r2 == null) goto L48;
        r4.put("user_type", r2);     // Catch: JSONException -> L36
    L48:
        if (r9 == null) goto L57;
        Map r12 = (Map) r9.invoke();     // Catch: JSONException -> L36
        if (r12 == null) goto L57;
        Iterator r13 = r12.entrySet().iterator();     // Catch: JSONException -> L36
    L52:
        if (r13.hasNext() == false) goto L57;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: JSONException -> L36
        r4.put((String) r14.getKey(), r14.getValue());     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        FLogger.a.e("FullScreenEventHelper", "error in FullScreenEventHelper fullScreenPreviewClick " + e.getLocalizedMessage());
    L57:
        TrackParams r15 = new TrackParams().merge(r4);
        by7.a r16 = new by7.a("full_screen_preview_click");
        if (r10 == null) goto L60;
        r16.b = r10;
    L60:
        r16.a.merge(r15);
        r16.b();
        return;
    L62:
        r4.put("bot_id", r6);     // Catch: JSONException -> L36
        goto L38
    L26:
        r4 = null;
        goto L28
    L22:
        r3 = "answer";
        goto L24
    L18:
        r2 = "bot";
        goto L20
    L11:
        r0 = "text";
        goto L13
    }
}
