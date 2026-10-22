package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q2 {
    public static void a(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter("setting", "currentPage");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("current_page", "setting");     // Catch: JSONException -> L5
        r0.put("click_from", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_contact_setting");
        r1.a.merge(r5);
        r1.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("NotifySettingsEventHelper", "error in NotifySettingsEventHelper mobClickContactSetting " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "clickFrom");
        Intrinsics.checkNotNullParameter(r4, "toStatus");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("click_from", r3);     // Catch: JSONException -> L5
        r0.put("to_status", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("click_notify_auth_switch");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("NotifySettingsEventHelper", "error in NotifySettingsEventHelper mobClickNotifyAuthSwitch " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "settingType");
        Intrinsics.checkNotNullParameter(r3, "clickFrom");
        Intrinsics.checkNotNullParameter(r4, "toStatus");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("setting_type", r2);     // Catch: JSONException -> L5
        r0.put("click_from", r3);     // Catch: JSONException -> L5
        r0.put("to_status", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("click_contact_setting_switch");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("NotifySettingsEventHelper", "error in NotifySettingsEventHelper mobClickContactSettingSwitch " + e.getLocalizedMessage());
        goto L7
    }
}
