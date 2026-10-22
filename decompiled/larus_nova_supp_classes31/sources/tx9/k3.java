package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k3 {
    public static void a(Long r2, String r3, String r4, Long r5, String r6, String r7, JSONObject r8, int r9) {
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
        if ((r9 & 32) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 64) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 128) == 0) goto L23;
        r8 = new JSONObject();
    L23:
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r2 != null) goto L42;
    L28:
        if (r3 == null) goto L30;
        r8.put("from_call_scene", r3);     // Catch: JSONException -> L26
    L30:
        if (r4 == null) goto L32;
        r8.put("to_call_scene", r4);     // Catch: JSONException -> L26
    L32:
        if (r5 == null) goto L34;
        r8.put("is_subtitles_mode", r5.longValue());     // Catch: JSONException -> L26
    L34:
        if (r6 == null) goto L36;
        r8.put("conversation_id", r6);     // Catch: JSONException -> L26
    L36:
        if (r7 == null) goto L40;
        r8.put("click_from", r7);     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        FLogger.a.e("SelectEventHelper", "error in SelectEventHelper mobSelectCallScene " + e.getLocalizedMessage());
    L40:
        TrackParams r10 = new TrackParams().merge(r8);
        by7.a r11 = new by7.a("select_call_scene");
        r11.a.merge(r10);
        r11.b();
        return;
    L42:
        r8.put("duration", r2.longValue());     // Catch: JSONException -> L26
        goto L28
    }
}
