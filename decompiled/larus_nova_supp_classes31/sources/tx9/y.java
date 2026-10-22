package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y {
    public static void a(int r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "errMsg");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("err_no", r3);     // Catch: JSONException -> L5
        r0.put("error_msg", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("chat_bottom_tab_result");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ChatEventHelper", "error in ChatEventHelper enterChatWithBottomTabResult " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(Long r4, String r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "chat_list");     // Catch: JSONException -> L8
        if (r4 == null) goto L6;
        r1.put("position", r4.longValue());     // Catch: JSONException -> L8
    L6:
        r1.put("position_name", r5);     // Catch: JSONException -> L8
    L10:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("chat_plus_element_show");
        r7.a.merge(r6);
        r7.b();
        return;
    L8:
        e = move-exception;
        FLogger.a.e("ChatEventHelper", "error in ChatEventHelper chatPlusElementShow " + e.getLocalizedMessage());
        goto L10
    }
}
