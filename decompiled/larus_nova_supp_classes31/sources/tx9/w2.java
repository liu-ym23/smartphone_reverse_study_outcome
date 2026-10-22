package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w2 {
    public static void d(String r2, String r3, int r4) {
        JSONObject r1 = null;
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r1 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L22;
    L16:
        if (r3 == null) goto L20;
        r1.put("to_status", r3);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.a.e("PopupEventHelper", "error in PopupEventHelper popupVoiceEditFunctionClick " + e.getLocalizedMessage());
    L20:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r6 = new by7.a("popup_voice_edit_function_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L22:
        r1.put("click_from", r2);     // Catch: JSONException -> L14
        goto L16
    }

    public static void c(String r2, String r3, JSONObject r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r2 != null) goto L23;
    L16:
        if (r3 == null) goto L18;
        r4.put("enter_method", r3);     // Catch: JSONException -> L14
    L18:
        r4.put("voice_create_id", b4.a);     // Catch: JSONException -> L14
    L21:
        TrackParams r6 = new TrackParams().merge(r4);
        by7.a r7 = new by7.a("popup_voice_create_confirm_show");
        r7.a.merge(r6);
        r7.b();
        return;
    L14:
        e = move-exception;
        FLogger.a.e("PopupEventHelper", "error in PopupEventHelper popupVoiceCreateConfirmShow " + e.getLocalizedMessage());
        goto L21
    L23:
        r4.put("previous_page", r2);     // Catch: JSONException -> L14
        goto L16
    }

    public static void b(String r2, String r3, String r4, JSONObject r5, int r6) {
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
        if (r2 != null) goto L28;
    L19:
        if (r3 == null) goto L21;
        r5.put("previous_page", r3);     // Catch: JSONException -> L17
    L21:
        if (r4 == null) goto L23;
        r5.put("enter_method", r4);     // Catch: JSONException -> L17
    L23:
        r5.put("voice_create_id", b4.a);     // Catch: JSONException -> L17
    L26:
        TrackParams r7 = new TrackParams().merge(r5);
        by7.a r8 = new by7.a("popup_record_test_show");
        r8.a.merge(r7);
        r8.b();
        return;
    L17:
        e = move-exception;
        FLogger.a.e("PopupEventHelper", "error in PopupEventHelper popupRecordTestShow " + e.getLocalizedMessage());
        goto L26
    L28:
        r5.put("page_status", r2);     // Catch: JSONException -> L17
        goto L19
    }

    public static void a(String r4, Long r5, String r6, String r7, String r8, JSONObject r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & 32) == 0) goto L20;
        r9 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r4 != null) goto L38;
    L25:
        if (r5 == null) goto L27;
        r9.put("click_position", r5.longValue());     // Catch: JSONException -> L23
    L27:
        if (r6 == null) goto L29;
        r9.put("page_status", r6);     // Catch: JSONException -> L23
    L29:
        if (r7 == null) goto L31;
        r9.put("previous_page", r7);     // Catch: JSONException -> L23
    L31:
        if (r8 == null) goto L33;
        r9.put("enter_method", r8);     // Catch: JSONException -> L23
    L33:
        r9.put("voice_create_id", b4.a);     // Catch: JSONException -> L23
    L36:
        TrackParams r11 = new TrackParams().merge(r9);
        by7.a r12 = new by7.a("popup_record_test_function_click");
        r12.a.merge(r11);
        r12.b();
        com.larus.platform.service.g.a.monitorEventForSlardar("popup_record_test_function_click", r12.c(), null, null);
        return;
    L23:
        e = move-exception;
        FLogger.a.e("PopupEventHelper", "error in PopupEventHelper popupRecordTestFunctionClick " + e.getLocalizedMessage());
        goto L36
    L38:
        r9.put("click_from", r4);     // Catch: JSONException -> L23
        goto L25
    }

    public static void e(String r2, Long r3, String r4, String r5, String r6, JSONObject r7, int r8) {
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
        r7.put("click_position", r3.longValue());     // Catch: JSONException -> L23
    L27:
        if (r4 == null) goto L29;
        r7.put("previous_page", r4);     // Catch: JSONException -> L23
    L29:
        if (r5 == null) goto L31;
        r7.put("enter_method", r5);     // Catch: JSONException -> L23
    L31:
        if (r6 == null) goto L35;
        r7.put("voice_create_id", r6);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("PopupEventHelper", "error in PopupEventHelper popupVoiceRecordFunctionClick " + e.getLocalizedMessage());
    L35:
        TrackParams r9 = new TrackParams().merge(r7);
        by7.a r10 = new by7.a("popup_voice_record_function_click");
        r10.a.merge(r9);
        r10.b();
        return;
    L37:
        r7.put("click_from", r2);     // Catch: JSONException -> L23
        goto L25
    }
}
