package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z3 {
    public static void a(String r2, String r3, String r4, Long r5, JSONObject r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r2 != null) goto L32;
    L22:
        if (r3 == null) goto L24;
        r6.put("card_type", r3);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L26;
        r6.put("message_id", r4);     // Catch: JSONException -> L20
    L26:
        if (r5 == null) goto L30;
        r6.put("position", r5.longValue());     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("VideoEventHelper", "error in VideoEventHelper videoCardShow " + e.getLocalizedMessage());
    L30:
        TrackParams r8 = new TrackParams().merge(r6);
        by7.a r9 = new by7.a("video_card_show");
        r9.a.merge(r8);
        r9.b();
        return;
    L32:
        r6.put("bot_id", r2);     // Catch: JSONException -> L20
        goto L22
    }
}
