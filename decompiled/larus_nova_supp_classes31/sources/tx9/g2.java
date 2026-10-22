package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g2 {
    public static void d(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("enter_method", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_switch_account_enter");
        r1.a.merge(r5);
        r1.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper click_switch_account_enter " + e.getLocalizedMessage());
        goto L7
    }

    public static void a(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r3);     // Catch: JSONException -> L5
        r0.put("account_type", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("account_invalid_toast_show");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper account_invalid_toast_show " + e.getLocalizedMessage());
        goto L7
    }

    public static void e(String r3, String r4, String r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("click_from", r3);     // Catch: JSONException -> L7
        r1.put("current_page", "account_switch");     // Catch: JSONException -> L7
        r1.put("account_type", r4);     // Catch: JSONException -> L7
        if (r5 == null) goto L9;
        r1.put("account_id", r5);     // Catch: JSONException -> L7
    L9:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("confirm_relogin_account");
        r7.a.merge(r6);
        r7.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper confirm_relogin_account " + e.getLocalizedMessage());
        goto L9
    }

    public static void f(String r3, String r4, String r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("click_from", r3);     // Catch: JSONException -> L7
        r1.put("current_page", "account_switch");     // Catch: JSONException -> L7
        r1.put("account_type", r4);     // Catch: JSONException -> L7
        if (r5 == null) goto L9;
        r1.put("account_id", r5);     // Catch: JSONException -> L7
    L9:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("confirm_remove_account");
        r7.a.merge(r6);
        r7.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper confirm_remove_account " + e.getLocalizedMessage());
        goto L9
    }

    public static void b(String r2, String r3, String r4, by7.e r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        JSONObject r0 = new JSONObject();
    L16:
        if ((r6 & 16) == 0) goto L18;
        r5 = null;
    L18:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L34;
    L23:
        if (r3 == null) goto L25;
        r0.put("account_id", r3);     // Catch: JSONException -> L21
    L25:
        if (r4 == null) goto L29;
        r0.put("enter_method", r4);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper account_show " + e.getLocalizedMessage());
    L29:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("account_show");
        if (r5 == null) goto L32;
        r8.b = r5;
    L32:
        r8.a.merge(r7);
        r8.b();
        return;
    L34:
        r0.put("account_type", r2);     // Catch: JSONException -> L21
        goto L23
    L14:
        r0 = null;
        goto L16
    }

    public static void h(String r2, String r3, String r4, String r5, int r6) {
        JSONObject r1 = null;
        if ((r6 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((r6 & 32) == 0) goto L17;
        r1 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L32;
    L22:
        if (r3 == null) goto L24;
        r1.put("success", r3);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L26;
        r1.put("err_code", r4);     // Catch: JSONException -> L20
    L26:
        if (r5 == null) goto L30;
        r1.put("err_tips", r5);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper switch_account_result " + e.getLocalizedMessage());
    L30:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r8 = new by7.a("switch_account_result");
        r8.a.merge(r7);
        r8.b();
        return;
    L32:
        r1.put("enter_method", r2);     // Catch: JSONException -> L20
        goto L22
    }

    public static void g(String r3, String r4, String r5, String r6, String r7, int r8) {
        JSONObject r1 = null;
        if ((r8 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r8 & 2) == 0) goto L10;
        r3 = null;
    L10:
        if ((r8 & 4) == 0) goto L13;
        r4 = null;
    L13:
        if ((r8 & 8) == 0) goto L16;
        r5 = null;
    L16:
        if ((r8 & 16) == 0) goto L19;
        r6 = null;
    L19:
        if ((r8 & 32) == 0) goto L22;
        r7 = null;
    L22:
        if ((r8 & 64) == 0) goto L24;
        r1 = new JSONObject();
    L24:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r0 != null) goto L43;
    L29:
        if (r3 == null) goto L31;
        r1.put("account_type", r3);     // Catch: JSONException -> L27
    L31:
        if (r4 == null) goto L33;
        r1.put("account_id", r4);     // Catch: JSONException -> L27
    L33:
        if (r5 == null) goto L35;
        r1.put("success", r5);     // Catch: JSONException -> L27
    L35:
        if (r6 == null) goto L37;
        r1.put("err_code", r6);     // Catch: JSONException -> L27
    L37:
        if (r7 == null) goto L41;
        r1.put("err_tips", r7);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper remove_account_result " + e.getLocalizedMessage());
    L41:
        TrackParams r9 = new TrackParams().merge(r1);
        by7.a r10 = new by7.a("remove_account_result");
        r10.a.merge(r9);
        r10.b();
        return;
    L43:
        r1.put("current_page", r0);     // Catch: JSONException -> L27
        goto L29
    L5:
        r0 = "account_switch";
        goto L7
    }

    public static void c(String r2, String r3, String r4, String r5, String r6, JSONObject r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r7, "params");
        if (r2 != null) goto L37;
    L25:
        if (r3 == null) goto L27;
        r7.put("click_from", r3);     // Catch: JSONException -> L23
    L27:
        if (r4 == null) goto L29;
        r7.put("switch_account_id", r4);     // Catch: JSONException -> L23
    L29:
        if (r5 == null) goto L31;
        r7.put("account_type", r5);     // Catch: JSONException -> L23
    L31:
        if (r6 == null) goto L35;
        r7.put("enter_method", r6);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper click_switch_account " + e.getLocalizedMessage());
    L35:
        TrackParams r9 = new TrackParams().merge(r7);
        by7.a r10 = new by7.a("click_switch_account");
        r10.a.merge(r9);
        r10.b();
        return;
    L37:
        r7.put("current_page", r2);     // Catch: JSONException -> L23
        goto L25
    }
}
