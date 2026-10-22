package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s {
    public static void c(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("authorize_result", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("calendar_system_authorize_result");
        r1.a.merge(r5);
        r1.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("CalendarEventHelper", "error in CalendarEventHelper showButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        r4.put("popup_type", r2);     // Catch: JSONException -> L5
        r4.put("action", r3);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("calendar_popup_show");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("CalendarEventHelper", "error in CalendarEventHelper showButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void a(String r1, String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        r4.put("popup_type", r1);     // Catch: JSONException -> L8
        if (r2 == null) goto L6;
        r4.put("action", r2);     // Catch: JSONException -> L8
    L6:
        r4.put("click_button", r3);     // Catch: JSONException -> L8
    L10:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("calendar_popup_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L8:
        e = move-exception;
        FLogger.a.e("CalendarEventHelper", "error in CalendarEventHelper showButton " + e.getLocalizedMessage());
        goto L10
    }
}
