package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z0 {
    public static void a(boolean r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r4 != null) goto L22;
    L7:
        if (r5 == null) goto L9;
        r1.put("bot_id", r5);     // Catch: JSONException -> L5
    L9:
        if (r6 == null) goto L11;
        r1.put("conversation_id", r6);     // Catch: JSONException -> L5
    L11:
        if (r7 == null) goto L13;
        r1.put("chat_type", r7);     // Catch: JSONException -> L5
    L13:
        r1.put("edu_skill", r8);     // Catch: JSONException -> L5
        r1.put("current_page", "chat");     // Catch: JSONException -> L5
        r1.put("is_multi_question", r9);     // Catch: JSONException -> L5
    L16:
        TrackParams r10 = new TrackParams().merge(r1);
        if (r3 == false) goto L19;
        String r11 = "one_more_shoot_show";
    L20:
        by7.a r12 = new by7.a(r11);
        r12.a.merge(r10);
        r12.b();
        return;
    L19:
        r11 = "one_more_shoot_click";
    L5:
        e = move-exception;
        FLogger.a.e("EduCameraEventHelper", "error in EduCameraEventHelper mobOneMoreShotShow " + e.getLocalizedMessage());
        goto L16
    L22:
        r1.put("message_id", r4);     // Catch: JSONException -> L5
        goto L7
    }
}
