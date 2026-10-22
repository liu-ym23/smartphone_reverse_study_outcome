package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w0 {
    public static final void a() {
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "chat");     // Catch: JSONException -> L5
    L7:
        TrackParams r0 = new TrackParams().merge(r1);
        by7.a r2 = new by7.a("account_risk_toast");
        r2.a.merge(r0);
        r2.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper mobSdkVideoAuthStatus " + e.getLocalizedMessage());
        goto L7
    }

    public static final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "status");
        JSONObject r1 = new JSONObject();
        r1.put("status", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r0 = new by7.a("sdk_video_auth_status");
        r0.a.merge(r5);
        r0.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper mobSdkVideoAuthStatus " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r2, String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L19;
    L7:
        if (r4 == null) goto L9;
        r0.put("scene", r4);     // Catch: JSONException -> L5
    L9:
        if (r2 == null) goto L11;
        r0.put("enter_method", r2);     // Catch: JSONException -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("message_id", r5);     // Catch: JSONException -> L5
    L13:
        if (r6 == null) goto L17;
        r0.put("sec_enter_method", r6);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper showDouyinAuthorizeWindow " + e.getLocalizedMessage());
    L17:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("authorize_dialog_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L19:
        r0.put("content_type", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L20;
    L7:
        if (r4 == null) goto L9;
        r0.put("scene", r4);     // Catch: JSONException -> L5
    L9:
        if (r2 == null) goto L11;
        r0.put("enter_method", r2);     // Catch: JSONException -> L5
    L11:
        r0.put("content_action", r5);     // Catch: JSONException -> L5
        if (r6 == null) goto L14;
        r0.put("message_id", r6);     // Catch: JSONException -> L5
    L14:
        if (r7 == null) goto L18;
        r0.put("sec_enter_method", r7);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper showDouyinAuthorizeWindow " + e.getLocalizedMessage());
    L18:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("authorize_dialog_click");
        r9.a.merge(r8);
        r9.b();
        return;
    L20:
        r0.put("content_type", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(String r2, String r3, String r4, String r5, String r6, String r7, String r8, JSONObject r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = new JSONObject();
    L26:
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r2 != null) goto L50;
    L31:
        if (r3 == null) goto L33;
        r9.put("page_type", r3);     // Catch: JSONException -> L29
    L33:
        if (r4 == null) goto L35;
        r9.put("enter_method", r4);     // Catch: JSONException -> L29
    L35:
        if (r5 == null) goto L37;
        r9.put("message_id", r5);     // Catch: JSONException -> L29
    L37:
        if (r6 == null) goto L39;
        r9.put("sec_enter_method", r6);     // Catch: JSONException -> L29
    L39:
        if (r8 == null) goto L41;
        r9.put("action", r8);     // Catch: JSONException -> L29
    L41:
        if (r7 == null) goto L46;
        r9.put("bot_id", r7);     // Catch: JSONException -> L29
    L29:
        e = move-exception;
        FLogger.a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper showDouyinAuthorizeWindow " + e.getLocalizedMessage());
    L46:
        if (r9.has("scene") == true) goto L48;
        r9.put("scene", "unknown");
    L48:
        TrackParams r11 = new TrackParams().merge(r9);
        by7.a r12 = new by7.a("show_douyin_authorize_window");
        r12.a.merge(r11);
        r12.b();
        return;
    L50:
        r9.put("scene", r2);     // Catch: JSONException -> L29
        goto L31
    }

    public static void d(String r2, String r3, String r4, int r5, String r6, String r7, String r8, String r9, String r10, String r11, JSONObject r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 16) == 0) goto L15;
        r6 = null;
    L15:
        if ((r13 & 32) == 0) goto L18;
        r7 = null;
    L18:
        if ((r13 & 64) == 0) goto L21;
        r8 = null;
    L21:
        if ((r13 & 128) == 0) goto L24;
        r9 = null;
    L24:
        if ((r13 & 256) == 0) goto L27;
        r10 = null;
    L27:
        if ((r13 & 512) == 0) goto L30;
        r11 = null;
    L30:
        if ((r13 & 1024) == 0) goto L32;
        r12 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r2 != null) goto L67;
    L37:
        if (r3 == null) goto L39;
        r12.put("page_type", r3);     // Catch: JSONException -> L35
    L39:
        if (r4 == null) goto L41;
        r12.put("enter_method", r4);     // Catch: JSONException -> L35
    L41:
        r12.put("is_success", r5);     // Catch: JSONException -> L35
        if (r6 != null) goto L44;
    L47:
        boolean r14 = true;
    L48:
        if (r14 == true) goto L50;
        r12.put("scopes", r6);     // Catch: JSONException -> L35
    L50:
        if (r7 == null) goto L52;
        r12.put("message_id", r7);     // Catch: JSONException -> L35
    L52:
        if (r8 == null) goto L54;
        r12.put("sec_enter_method", r8);     // Catch: JSONException -> L35
    L54:
        if (r11 == null) goto L56;
        r12.put("action", r11);     // Catch: JSONException -> L35
    L56:
        if (r10 == null) goto L58;
        r12.put("bot_id", r10);     // Catch: JSONException -> L35
    L58:
        if (r9 == null) goto L63;
        r12.put("authorize_scopes", r9);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper douyinAuthorizeWindowResult " + e.getLocalizedMessage());
    L63:
        if (r12.has("scene") == true) goto L65;
        r12.put("scene", "unknown");
    L65:
        TrackParams r15 = new TrackParams().merge(r12);
        by7.a r16 = new by7.a("douyin_authorize_window_result");
        r16.a.merge(r15);
        r16.b();
        return;
    L44:
        if (StringsKt.isBlank(r6) == true) goto L47;
        r14 = false;
        goto L48
    L67:
        r12.put("scene", r2);     // Catch: JSONException -> L35
        goto L37
    }
}
