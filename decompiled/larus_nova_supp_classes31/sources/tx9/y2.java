package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y2 {
    public static void a(String r3, String r4, Long r5, String r6, String r7, String r8) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "chat");     // Catch: JSONException -> L16
        if (r4 == null) goto L6;
        r1.put("message_id", r4);     // Catch: JSONException -> L16
    L6:
        if (r3 == null) goto L8;
        r1.put("reply_id", r3);     // Catch: JSONException -> L16
    L8:
        if (r5 == null) goto L10;
        r5.longValue();     // Catch: JSONException -> L16
        r1.put("position", r5.longValue());     // Catch: JSONException -> L16
    L10:
        if (r6 == null) goto L12;
        r1.put("conversation_id", r6);     // Catch: JSONException -> L16
    L12:
        if (r7 == null) goto L14;
        r1.put("bot_id", r7);     // Catch: JSONException -> L16
    L14:
        r1.put("click_position", r8);     // Catch: JSONException -> L16
    L18:
        TrackParams r9 = new TrackParams().merge(r1);
        by7.a r10 = new by7.a("prompt_survey_tab_click");
        r10.a.merge(r9);
        r10.b();
        return;
    L16:
        e = move-exception;
        FLogger.a.e("PromptEventHelper", "error in PromptEventHelper promptTabClick " + e.getLocalizedMessage());
        goto L18
    }
}
