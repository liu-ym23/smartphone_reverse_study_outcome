package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f1 {
    public static void a(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L12;
    L7:
        r0.put("to_status", r4);     // Catch: JSONException -> L5
    L10:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("click_dark_mode_button");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FontAndThemeEventHelper", "error in FontAndThemeEventHelper mobClickDarkModeButton " + e.getLocalizedMessage());
        goto L10
    L12:
        r0.put("current_page", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L12;
    L7:
        r0.put("dark_mode_setting", r3);     // Catch: JSONException -> L5
        r0.put("text_size_setting", r4);     // Catch: JSONException -> L5
    L10:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("confirm_background_setting");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FontAndThemeEventHelper", "error in FontAndThemeEventHelper mobConfirmBackgroundSetting " + e.getLocalizedMessage());
        goto L10
    L12:
        r0.put("current_page", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
