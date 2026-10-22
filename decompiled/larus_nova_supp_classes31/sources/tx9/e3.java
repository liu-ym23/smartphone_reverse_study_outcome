package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e3 {
    public static void a(Long r4, Long r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "bot_list_discover");     // Catch: JSONException -> L9
        r1.put("recommend_from", "bot_list_discover");     // Catch: JSONException -> L9
        if (r4 == null) goto L6;
        r1.put("success", r4.longValue());     // Catch: JSONException -> L9
    L6:
        if (r5 == null) goto L11;
        r1.put("empty_data", r5.longValue());     // Catch: JSONException -> L9
    L11:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("refresh_bot_result");
        r7.a.merge(r6);
        r7.b();
        return;
    L9:
        e = move-exception;
        FLogger.a.e("RefreshEventHelper", "error in RefreshEventHelper refreshBotResult " + e.getLocalizedMessage());
        goto L11
    }
}
