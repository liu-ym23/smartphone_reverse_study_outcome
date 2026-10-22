package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t {
    public static void a(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L15;
    L7:
        if (r3 == null) goto L9;
        r0.put("chat_type", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L13;
        r0.put("bot_id", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("CallEventHelper", "error in CallEventHelper mobCallSceneBoardShow " + e.getLocalizedMessage());
    L13:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("call_scene_board_show");
        r6.a.merge(r5);
        r6.b();
        return;
    L15:
        r0.put("conversation_id", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
