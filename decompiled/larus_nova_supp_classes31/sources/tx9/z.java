package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z {
    public static void b(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L18;
    L7:
        if (r4 == null) goto L11;
        boolean r1 = true;
        if (com.larus.utils.o0.d(r4) != true) goto L11;
    L12:
        if (r1 == false) goto L16;
        r0.put("request_id", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ChatListChangeRecommendEventHelper", "error in ChatListChangeRecommendEventHelper mobChatListChangeRecommendBot " + e.getLocalizedMessage());
    L16:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("chat_list_rec_duplicate");
        r6.a.merge(r5);
        r6.b();
        return;
    L11:
        r1 = false;
        goto L12
    L18:
        r0.put("bot_id", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L32;
    L7:
        r0.put("chat_type", r3);     // Catch: JSONException -> L5
        if (r4 == null) goto L10;
        r0.put("click_from", r4);     // Catch: JSONException -> L5
    L10:
        if (r5 == null) goto L12;
        r0.put("current_page", r5);     // Catch: JSONException -> L5
    L12:
        if (r6 == null) goto L14;
        r0.put("is_call_bot", r6);     // Catch: JSONException -> L5
    L14:
        boolean r9 = false;
        if (r7 != null) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L22;
        r0.put("recommend_from", r7);     // Catch: JSONException -> L5
    L22:
        if (r8 != null) goto L24;
    L26:
        if (r9 == false) goto L30;
        r0.put("req_id", r8);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ChatListChangeRecommendEventHelper", "error in ChatListChangeRecommendEventHelper mobChatListChangeRecommendBot " + e.getLocalizedMessage());
    L30:
        TrackParams r11 = new TrackParams().merge(r0);
        by7.a r12 = new by7.a("chat_list_change_recommend_bot");
        r12.a.merge(r11);
        r12.b();
        return;
    L24:
        if (com.larus.utils.o0.d(r8) != true) goto L26;
        r9 = true;
        goto L26
    L17:
        if (com.larus.utils.o0.d(r7) != true) goto L19;
        r10 = true;
        goto L20
    L32:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
