package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n1 {
    public static void b(String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r4 != null) goto L23;
    L7:
        r2.put("is_immersive_background", "1");     // Catch: JSONException -> L5
        if (r5 == null) goto L10;
        r2.put("recommend_from", r5);     // Catch: JSONException -> L5
    L10:
        r2.put("click_from", r6);     // Catch: JSONException -> L5
        if (r7 == null) goto L13;
        r2.put("req_id", r7);     // Catch: JSONException -> L5
    L13:
        r2.put("current_page", "chat");     // Catch: JSONException -> L5
        if (r8 == null) goto L16;
        r2.put("previous_page", r8);     // Catch: JSONException -> L5
    L16:
        r2.put("chat_type", r9);     // Catch: JSONException -> L5
        if (r10 == null) goto L21;
        r2.put("conversation_id", r10);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ImmersiveEventHelper", "error in ImmersiveEventHelper mobClickChatHistoryEntrance " + e.getLocalizedMessage());
    L21:
        TrackParams r11 = new TrackParams().merge(r2);
        by7.a r12 = new by7.a("show_chat_history_entrance");
        r12.a.merge(r11);
        r12.b();
        return;
    L23:
        r2.put("bot_id", r4);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.put("to_status", r4);     // Catch: JSONException -> L19
        if (r5 == null) goto L6;
        r2.put("bot_id", r5);     // Catch: JSONException -> L19
    L6:
        r2.put("is_immersive_background", "1");     // Catch: JSONException -> L19
        if (r6 == null) goto L9;
        r2.put("recommend_from", r6);     // Catch: JSONException -> L19
    L9:
        r2.put("click_from", r7);     // Catch: JSONException -> L19
        if (r8 == null) goto L12;
        r2.put("req_id", r8);     // Catch: JSONException -> L19
    L12:
        r2.put("current_page", "chat");     // Catch: JSONException -> L19
        if (r9 == null) goto L15;
        r2.put("previous_page", r9);     // Catch: JSONException -> L19
    L15:
        r2.put("chat_type", r10);     // Catch: JSONException -> L19
        if (r11 == null) goto L21;
        r2.put("conversation_id", r11);     // Catch: JSONException -> L19
    L21:
        TrackParams r12 = new TrackParams().merge(r2);
        by7.a r13 = new by7.a("click_chat_history_entrance");
        r13.a.merge(r12);
        r13.b();
        return;
    L19:
        e = move-exception;
        FLogger.a.e("ImmersiveEventHelper", "error in ImmersiveEventHelper mobClickChatHistoryEntrance " + e.getLocalizedMessage());
        goto L21
    }
}
