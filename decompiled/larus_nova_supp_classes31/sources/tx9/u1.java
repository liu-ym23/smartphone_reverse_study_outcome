package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u1 {
    public static void a(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9, JSONObject r10, by7.e r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = new JSONObject();
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = null;
    L32:
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r2 != null) goto L68;
    L37:
        if (r3 == null) goto L39;
        r10.put("chat_type", r3);     // Catch: JSONException -> L35
    L39:
        if (r4 == null) goto L41;
        r10.put("current_page", r4);     // Catch: JSONException -> L35
    L41:
        if (r6 == null) goto L43;
        r10.put("is_call_bot", r6);     // Catch: JSONException -> L35
    L43:
        boolean r13 = false;
        if (r5 != null) goto L46;
    L48:
        boolean r14 = false;
    L49:
        if (r14 == false) goto L51;
        r10.put("recommend_from", r5);     // Catch: JSONException -> L35
    L51:
        if (r7 != null) goto L53;
    L55:
        if (r13 == false) goto L57;
        r10.put("req_id", r7);     // Catch: JSONException -> L35
    L57:
        if (r8 == null) goto L59;
        r10.put("is_navigation_sidebar", r8);     // Catch: JSONException -> L35
    L59:
        if (r9 == null) goto L63;
        r10.put("red_dot_cnt", r9.intValue());     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.a.e("LongPressBotListEventHelper", "error in LongPressBotListEventHelper mobLongPressBotListChat " + e.getLocalizedMessage());
    L63:
        TrackParams r15 = new TrackParams().merge(r10);
        by7.a r16 = new by7.a("long_press_bot_list");
        if (r11 == null) goto L66;
        r16.b = r11;
    L66:
        r16.a.merge(r15);
        r16.b();
        return;
    L53:
        if (com.larus.utils.o0.d(r7) != true) goto L55;
        r13 = true;
        goto L55
    L46:
        if (com.larus.utils.o0.d(r5) != true) goto L48;
        r14 = true;
        goto L49
    L68:
        r10.put("bot_id", r2);     // Catch: JSONException -> L35
        goto L37
    }
}
