package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j1 {
    public static void c(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L12;
    L7:
        r0.put("button_name", r4);     // Catch: JSONException -> L5
    L10:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("health_dialog_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("HealthBotEventHelper", "error in HealthBotEventHelper mobHealthDialogClick " + e.getLocalizedMessage());
        goto L10
    L12:
        r0.put("bot_id", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L14;
    L7:
        if (r3 == null) goto L9;
        r0.put("notice_name", r3);     // Catch: JSONException -> L5
    L9:
        r0.put("current_page", r4);     // Catch: JSONException -> L5
    L12:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("health_agreement_and_notice_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("HealthBotEventHelper", "error in HealthBotEventHelper mobHealthAgreementAndNoticeClick " + e.getLocalizedMessage());
        goto L12
    L14:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L14;
    L7:
        if (r3 == null) goto L9;
        r0.put("notice_name", r3);     // Catch: JSONException -> L5
    L9:
        r0.put("show_from", r4);     // Catch: JSONException -> L5
    L12:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("health_agreement_and_notice_h5_page_show");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("HealthBotEventHelper", "error in HealthBotEventHelper mobHealthAgreementAndNoticeH5PageShow " + e.getLocalizedMessage());
        goto L12
    L14:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
