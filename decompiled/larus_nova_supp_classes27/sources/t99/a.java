package t99;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static void a(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r3 != null) goto L10;
    L8:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("complete_dislike_reason");
        r6.a.merge(r5);
        r6.b();
        return;
    L10:
        r4.put("scene", r3);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.a.e("FlowFeedbackTracer", "error in mobCompleteDislikeReason " + e.getLocalizedMessage());
        goto L8
    }

    public static void c(String r2, String r3, String r4, JSONObject r5, int r6) {
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
        r5 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r2 != null) goto L27;
    L19:
        if (r3 == null) goto L21;
        r5.put("call_id", r3);     // Catch: JSONException -> L17
    L21:
        if (r4 == null) goto L25;
        r5.put("message_id", r4);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        FLogger.a.e("FlowFeedbackTracer", "error in mobFeedbackPopupShow " + e.getLocalizedMessage());
    L25:
        TrackParams r7 = new TrackParams().merge(r5);
        by7.a r8 = new by7.a("feedback_popup_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L27:
        r5.put("scene", r2);     // Catch: JSONException -> L17
        goto L19
    }

    public static void b(String r2, String r3, String r4, String r5, JSONObject r6, int r7) {
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
        if (r5 != null) goto L32;
    L22:
        if (r2 == null) goto L24;
        r6.put("scene", r2);     // Catch: JSONException -> L20
    L24:
        if (r3 == null) goto L26;
        r6.put("call_id", r3);     // Catch: JSONException -> L20
    L26:
        if (r4 == null) goto L30;
        r6.put("message_id", r4);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("FlowFeedbackTracer", "error in mobFeedbackPopupClick " + e.getLocalizedMessage());
    L30:
        TrackParams r8 = new TrackParams().merge(r6);
        by7.a r9 = new by7.a("feedback_popup_click");
        r9.a.merge(r8);
        r9.b();
        return;
    L32:
        r6.put("click_from", r5);     // Catch: JSONException -> L20
        goto L22
    }
}
