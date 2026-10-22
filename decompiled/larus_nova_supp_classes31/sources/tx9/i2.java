package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i2 {
    public static void a(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("enter_method", r3);     // Catch: JSONException -> L5
        r0.put("to_status", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("my_info_tab_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("MyEventHelper", "error in MyEventHelper myInfoTabClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r2, String r3, String r4, Integer r5, String r6, Integer r7, String r8, String r9, String r10, int r11) {
        JSONObject r1 = null;
        if ((r11 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r11 & 512) == 0) goto L32;
        r1 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L57;
    L37:
        if (r3 == null) goto L39;
        r1.put("position_name", r3);     // Catch: JSONException -> L35
    L39:
        if (r4 == null) goto L41;
        r1.put("tab_name", r4);     // Catch: JSONException -> L35
    L41:
        if (r5 == null) goto L43;
        r1.put("position", r5.toString());     // Catch: JSONException -> L35
    L43:
        if (r6 == null) goto L45;
        r1.put("collect_id", r6);     // Catch: JSONException -> L35
    L45:
        if (r7 == null) goto L47;
        r1.put("collection_type_id", r7.intValue());     // Catch: JSONException -> L35
    L47:
        if (r8 == null) goto L49;
        r1.put("conversation_id", r8);     // Catch: JSONException -> L35
    L49:
        if (r9 == null) goto L51;
        r1.put("bot_id", r9);     // Catch: JSONException -> L35
    L51:
        if (r10 == null) goto L55;
        r1.put("message_id", r10);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.a.e("MyEventHelper", "error in MyEventHelper myInfoTabElementShow " + e.getLocalizedMessage());
    L55:
        TrackParams r12 = new TrackParams().merge(r1);
        by7.a r13 = new by7.a("my_info_tab_element_show");
        r13.a.merge(r12);
        r13.b();
        return;
    L57:
        r1.put("current_page", r2);     // Catch: JSONException -> L35
        goto L37
    }
}
