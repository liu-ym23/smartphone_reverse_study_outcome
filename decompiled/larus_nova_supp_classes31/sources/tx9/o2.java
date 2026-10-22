package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o2 {
    public static void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        TrackParams r3 = new TrackParams().merge(r2);
        by7.a r0 = new by7.a("click_broadcast_news_play");
        r0.a.merge(r3);
        r0.b();
    }

    public static void a(Long r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r3 != null) goto L10;
    L8:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("click_broadcast_news_pause");
        r6.a.merge(r5);
        r6.b();
        return;
    L10:
        r4.put("duration", r3.longValue());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.a.e("NewsEventHelper", "error in NewsEventHelper clickBroadcastNewsPause " + e.getLocalizedMessage());
        goto L8
    }
}
