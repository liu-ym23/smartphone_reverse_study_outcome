package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g0 {
    public static void a(String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, by7.e r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 2) == 0) goto L8;
        String r0 = null;
    L10:
        if ((r13 & 8) == 0) goto L13;
        r5 = null;
    L13:
        if ((r13 & 128) == 0) goto L16;
        r6 = null;
    L16:
        if ((r13 & 256) == 0) goto L19;
        r7 = null;
    L19:
        if ((r13 & 512) == 0) goto L22;
        r8 = null;
    L22:
        if ((r13 & 2048) == 0) goto L25;
        r9 = null;
    L25:
        if ((r13 & 4096) == 0) goto L28;
        r10 = null;
    L28:
        if ((r13 & 8192) == 0) goto L31;
        r11 = null;
    L31:
        if ((r13 & 16384) == 0) goto L33;
        JSONObject r2 = new JSONObject();
    L35:
        if ((r13 & 32768) == 0) goto L37;
        r12 = null;
    L37:
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r4 != null) goto L65;
    L42:
        if (r0 == null) goto L44;
        r2.put("click_from", r0);     // Catch: JSONException -> L40
    L44:
        if (r5 == null) goto L46;
        r2.put("is_immersive_background", r5);     // Catch: JSONException -> L40
    L46:
        if (r6 == null) goto L48;
        r2.put("rank", r6);     // Catch: JSONException -> L40
    L48:
        if (r7 == null) goto L50;
        r2.put("recommend_from", r7);     // Catch: JSONException -> L40
    L50:
        if (r8 == null) goto L52;
        r2.put("req_id", r8);     // Catch: JSONException -> L40
    L52:
        if (r9 == null) goto L54;
        r2.put("search_id", r9);     // Catch: JSONException -> L40
    L54:
        if (r10 == null) goto L56;
        r2.put("search_request_id", r10);     // Catch: JSONException -> L40
    L56:
        if (r11 == null) goto L60;
        r2.put("search_result_id", r11);     // Catch: JSONException -> L40
    L40:
        e = move-exception;
        FLogger.a.e("ConfirmEventHelper", "error in ConfirmEventHelper confirmUnfollowBot " + e.getLocalizedMessage());
    L60:
        TrackParams r14 = new TrackParams().merge(r2);
        by7.a r15 = new by7.a("confirm_unfollow_bot");
        if (r12 == null) goto L63;
        r15.b = r12;
    L63:
        r15.a.merge(r14);
        r15.b();
        return;
    L65:
        r2.put("bot_id", r4);     // Catch: JSONException -> L40
        goto L42
    L33:
        r2 = null;
        goto L35
    L8:
        r0 = "click_check";
        goto L10
    }
}
