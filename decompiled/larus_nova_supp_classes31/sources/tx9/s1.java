package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s1 {
    public static void c(String r2) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (com.larus.utils.o0.d(r2) == false) goto L5;
        r0.put("current_page", r2);
    L5:
        TrackParams r3 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("login_error_toast");
        r1.a.merge(r3);
        r1.b();
    }

    public static void e(String r2, String r3, String r4, by7.e r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("current_page", r2);     // Catch: JSONException -> L5
        r0.put("previous_page", r3);     // Catch: JSONException -> L5
        r0.put("guide_type", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("show_login_guide");
        if (r5 == null) goto L10;
        r7.b = r5;
    L10:
        r7.a.merge(r6);
        r7.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("LoginEventHelper", "error in LoginEventHelper showLoginGuide " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r2, String r3, String r4, String r5, by7.e r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        JSONObject r0 = new JSONObject();
    L19:
        if ((r7 & 32) == 0) goto L21;
        r6 = null;
    L21:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L39;
    L26:
        if (r3 == null) goto L28;
        r0.put("previous_page", r3);     // Catch: JSONException -> L24
    L28:
        if (r4 == null) goto L30;
        r0.put("guide_type", r4);     // Catch: JSONException -> L24
    L30:
        if (r5 == null) goto L34;
        r0.put("click_from", r5);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.a.e("LoginEventHelper", "error in LoginEventHelper clickLoginGuide " + e.getLocalizedMessage());
    L34:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("click_login_guide");
        if (r6 == null) goto L37;
        r9.b = r6;
    L37:
        r9.a.merge(r8);
        r9.b();
        return;
    L39:
        r0.put("current_page", r2);     // Catch: JSONException -> L24
        goto L26
    L17:
        r0 = null;
        goto L19
    }

    public static void d(String r2, String r3, Long r4, String r5, JSONObject r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r2 != null) goto L32;
    L22:
        if (r3 == null) goto L24;
        r6.put("previous_page", r3);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L26;
        r6.put("position", r4.longValue());     // Catch: JSONException -> L20
    L26:
        if (r5 == null) goto L30;
        r6.put("type", r5);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("LoginEventHelper", "error in LoginEventHelper loginTypeShow " + e.getLocalizedMessage());
    L30:
        TrackParams r8 = new TrackParams().merge(r6);
        by7.a r9 = new by7.a("login_type_show");
        r9.a.merge(r8);
        r9.b();
        return;
    L32:
        r6.put("current_page", r2);     // Catch: JSONException -> L20
        goto L22
    }

    public static void a(String r3, String r4, boolean r5, String r6, String r7, String r8, String r9, by7.e r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r11 & 128) == 0) goto L17;
        JSONObject r0 = new JSONObject();
    L19:
        if ((r11 & 256) == 0) goto L21;
        r10 = null;
    L21:
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L45;
    L26:
        if (r4 == null) goto L29;
        r0.put("previous_page", r4);     // Catch: JSONException -> L24
    L29:
        if (r5 == false) goto L31;
        int r12 = 1;
    L32:
        r0.put("success", String.valueOf(r12));     // Catch: JSONException -> L24
        if (r6 == null) goto L35;
        r0.put("result", r6);     // Catch: JSONException -> L24
    L35:
        if (r7 == null) goto L37;
        r0.put("bind_fail_step", r7);     // Catch: JSONException -> L24
    L37:
        r0.put("type", r8);     // Catch: JSONException -> L24
        r0.put("scene", r9);     // Catch: JSONException -> L24
    L40:
        TrackParams r13 = new TrackParams().merge(r0);
        by7.a r14 = new by7.a("bind_with_account");
        if (r10 == null) goto L43;
        r14.b = r10;
    L43:
        r14.a.merge(r13);
        r14.b();
        return;
    L24:
        e = move-exception;
        FLogger.a.e("LoginEventHelper", "error in LoginEventHelper clickLoginGuide " + e.getLocalizedMessage());
        goto L40
    L31:
        r12 = 0;
        goto L32
    L45:
        r0.put("current_page", r3);     // Catch: JSONException -> L24
        goto L26
    L17:
        r0 = null;
        goto L19
    }
}
