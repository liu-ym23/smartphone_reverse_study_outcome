package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w {
    public static void a(String r3, String r4, String r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "user_case_detail");     // Catch: JSONException -> L9
        r1.put("button_name", r3);     // Catch: JSONException -> L9
        if (r4 == null) goto L6;
        r1.put("user_case_reco_request_id", r4);     // Catch: JSONException -> L9
    L6:
        if (r5 == null) goto L11;
        r1.put("user_case_item_id", r5);     // Catch: JSONException -> L9
    L11:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("click_button");
        r7.a.merge(r6);
        r7.b();
        return;
    L9:
        e = move-exception;
        FLogger.a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseButtonClick " + e.getLocalizedMessage());
        goto L11
    }

    public static void b(String r3, String r4, String r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "user_case_detail");     // Catch: JSONException -> L9
        r1.put("button_name", r3);     // Catch: JSONException -> L9
        if (r4 == null) goto L6;
        r1.put("user_case_reco_request_id", r4);     // Catch: JSONException -> L9
    L6:
        if (r5 == null) goto L11;
        r1.put("user_case_item_id", r5);     // Catch: JSONException -> L9
    L11:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("show_button");
        r7.a.merge(r6);
        r7.b();
        return;
    L9:
        e = move-exception;
        FLogger.a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseButtonShow " + e.getLocalizedMessage());
        goto L11
    }

    public static void c(String r3, String r4, boolean r5, int r6, String r7, String r8) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", r3);     // Catch: JSONException -> L13
        r1.put("cell_type", "user_case");     // Catch: JSONException -> L13
        r1.put("recommend_from", r4);     // Catch: JSONException -> L13
        if (r5 == false) goto L6;
        String r9 = "1";
    L7:
        r1.put("is_set_grey", r9);     // Catch: JSONException -> L13
        r1.put("index", r6);     // Catch: JSONException -> L13
        if (r7 == null) goto L10;
        r1.put("user_case_reco_request_id", r7);     // Catch: JSONException -> L13
    L10:
        if (r8 == null) goto L15;
        r1.put("user_case_item_id", r8);     // Catch: JSONException -> L13
    L15:
        TrackParams r10 = new TrackParams().merge(r1);
        by7.a r11 = new by7.a("list_cell_click");
        r11.a.merge(r10);
        r11.b();
        return;
    L6:
        r9 = "0";
    L13:
        e = move-exception;
        FLogger.a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseListElementClick " + e.getLocalizedMessage());
        goto L15
    }

    public static void d(String r3, String r4, boolean r5, int r6, String r7, String r8) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r3 != null) goto L23;
    L7:
        r1.put("cell_type", "user_case");     // Catch: JSONException -> L5
        if (r4 == null) goto L11;
        r1.put("recommend_from", r4);     // Catch: JSONException -> L5
    L11:
        if (r5 == false) goto L13;
        String r9 = "1";
    L14:
        r1.put("is_set_grey", r9);     // Catch: JSONException -> L5
        r1.put("index", r6);     // Catch: JSONException -> L5
        if (r7 == null) goto L17;
        r1.put("user_case_reco_request_id", r7);     // Catch: JSONException -> L5
    L17:
        if (r8 == null) goto L21;
        r1.put("user_case_item_id", r8);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseListElementShow " + e.getLocalizedMessage());
    L21:
        TrackParams r10 = new TrackParams().merge(r1);
        by7.a r11 = new by7.a("list_cell_show");
        r11.a.merge(r10);
        r11.b();
        return;
    L13:
        r9 = "0";
        goto L14
    L23:
        r1.put("current_page", r3);     // Catch: JSONException -> L5
        goto L7
    }
}
