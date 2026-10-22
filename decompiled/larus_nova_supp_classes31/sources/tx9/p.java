package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public static void a(String r2, String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L18;
    L7:
        if (r3 == null) goto L9;
        r0.put("chat_type", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L11;
        r0.put("current_page", r4);     // Catch: JSONException -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("req_id", r5);     // Catch: JSONException -> L5
    L13:
        r0.put("recommend_from", r6);     // Catch: JSONException -> L5
    L16:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("bot_feedback_banner_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("BotFeedbackHelper", "error in mobBotFeedbackBannerShow " + e.getLocalizedMessage());
        goto L16
    L18:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
