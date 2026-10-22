package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static void c(String r2) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("click_method", r2);
        TrackParams r3 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_logoutall_confirm");
        r1.a.merge(r3);
        r1.b();
    }

    public static void e(String r2) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("click_method", r2);
        TrackParams r3 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_setting_logout");
        r1.a.merge(r3);
        r1.b();
    }

    public static void b(Boolean r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r3 != null) goto L14;
    L12:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("add_shortcut_result");
        r6.a.merge(r5);
        r6.b();
        return;
    L14:
    L10:
        e = move-exception;
        FLogger.a.e("AddEventHelper", "error in AddEventHelper confirm un add Friend " + e.getLocalizedMessage());
        goto L12
    L5:
        if (r3.booleanValue() == false) goto L7;
        int r7 = 1;
    L8:
        r4.put("success", r7);     // Catch: JSONException -> L10
        goto L12
    L7:
        r7 = 0;
        goto L8
    }

    public static void d(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("click_method", r2);
        r0.put("cancel_logout_page", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r5 = new by7.a("click_logout_cancel");
        r5.a.merge(r4);
        r5.b();
    }

    public static void f(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("click_method", r2);
        r0.put("click_logout", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r5 = new by7.a("click_logout_confirm");
        r5.a.merge(r4);
        r5.b();
    }

    public static final JSONObject a(String r2, String r3, String r4, Boolean r5, Boolean r6) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L20
        if (r2 == null) goto L5;
        r0.put("current_page", r2);     // Catch: JSONException -> L20
    L5:
        if (r3 == null) goto L7;
        r0.put("bot_id", r3);     // Catch: JSONException -> L20
    L7:
        r0.put("chat_type", r4);     // Catch: JSONException -> L20
        int r7 = 0;
        if (r5 != null) goto L10;
    L14:
        if (r6 != null) goto L16;
    L19:
        return r0;
    L16:
        if (r6.booleanValue() == false) goto L18;
        r7 = 1;
    L18:
        r0.put("if_can_upload_pic", r7);     // Catch: JSONException -> L20
        goto L19
    L10:
        if (r5.booleanValue() == false) goto L12;
        int r8 = 1;
    L13:
        r0.put("if_has_voice", r8);     // Catch: JSONException -> L20
        goto L14
    L12:
        r8 = 0;
    L20:
        e = move-exception;
        FLogger.a.e("AddEventHelper", "error in AddEventHelper confirm un add Friend " + e.getLocalizedMessage());
        return null;
    }
}
