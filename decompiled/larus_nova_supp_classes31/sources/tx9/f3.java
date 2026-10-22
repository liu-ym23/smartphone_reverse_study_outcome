package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f3 {
    public static void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        TrackParams r3 = new TrackParams().merge(r2);
        by7.a r0 = new by7.a("chat_list_not_bot_cell_remove");
        r0.a.merge(r3);
        r0.b();
    }

    public static void a(String r2, String r3, String r4, String r5, String r6, JSONObject r7, String r8, String r9, String r10, String r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = new JSONObject();
    L21:
        if ((r13 & 128) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 256) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 512) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 1024) == 0) goto L33;
        r11 = null;
    L33:
        if ((r13 & 2048) == 0) goto L35;
        r12 = null;
    L35:
        Intrinsics.checkNotNullParameter(r7, "params");
        if (r2 != null) goto L72;
    L40:
        if (r3 == null) goto L42;
        r7.put("conversation_id", r3);     // Catch: JSONException -> L38
    L42:
        if (r4 == null) goto L44;
        r7.put("chat_type", r4);     // Catch: JSONException -> L38
    L44:
        if (r5 == null) goto L46;
        r7.put("click_from", r5);     // Catch: JSONException -> L38
    L46:
        if (r6 == null) goto L48;
        r7.put("current_page", r6);     // Catch: JSONException -> L38
    L48:
        if (r9 == null) goto L50;
        r7.put("is_call_bot", r9);     // Catch: JSONException -> L38
    L50:
        boolean r14 = false;
        if (r8 != null) goto L53;
    L55:
        boolean r15 = false;
    L56:
        if (r15 == false) goto L58;
        r7.put("recommend_from", r8);     // Catch: JSONException -> L38
    L58:
        if (r10 != null) goto L60;
    L62:
        if (r14 == false) goto L64;
        r7.put("request_id", r10);     // Catch: JSONException -> L38
    L64:
        if (r11 == null) goto L66;
        r7.put("is_navigation_sidebar", r11);     // Catch: JSONException -> L38
    L66:
        if (r12 == null) goto L70;
        r7.put("chat_status", r12);     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.a.e("RemoveEventHelper", "error in RemoveEventHelper removeChat " + e.getLocalizedMessage());
    L70:
        TrackParams r16 = new TrackParams().merge(r7);
        by7.a r17 = new by7.a("remove_chat");
        r17.a.merge(r16);
        r17.b();
        return;
    L60:
        if (com.larus.utils.o0.d(r10) != true) goto L62;
        r14 = true;
        goto L62
    L53:
        if (com.larus.utils.o0.d(r8) != true) goto L55;
        r15 = true;
        goto L56
    L72:
        r7.put("bot_id", r2);     // Catch: JSONException -> L38
        goto L40
    }
}
