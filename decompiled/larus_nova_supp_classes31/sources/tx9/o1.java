package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o1 {
    public static void a(String r3, Long r4, Long r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L15;
    L7:
        if (r4 == null) goto L9;
        r0.put("badge_count", r4.longValue());     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L13;
        r0.put("read_badge_count", r5.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("L0Part1ChatBotEventHelper", "error in L0Part1ChatBotEventHelper inputStateException " + e.getLocalizedMessage());
    L13:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("dev_log_chat_red_dot_show_exception");
        r7.a.merge(r6);
        r7.b();
        return;
    L15:
        r0.put("conversation_id", r3);     // Catch: JSONException -> L5
        goto L7
    }
}
