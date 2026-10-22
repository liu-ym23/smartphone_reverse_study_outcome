package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p1 {
    public static void a(String r4) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("service_name", "list_loader");     // Catch: JSONException -> L5
        r1.put("drive_scene", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r0 = new by7.a("drive_get_service");
        r0.a.merge(r5);
        r0.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobDriveGetService " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r4) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("service_name", "list_loader");     // Catch: JSONException -> L7
        if (r4 == null) goto L9;
        r1.put("drive_scene", r4);     // Catch: JSONException -> L7
    L9:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r0 = new by7.a("drive_get_service_failed");
        r0.a.merge(r5);
        r0.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobDriveGetServiceFailed " + e.getLocalizedMessage());
        goto L9
    }

    public static void c(String r4) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "upload_file");     // Catch: JSONException -> L5
        r1.put("button_name", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r0 = new by7.a("file_choose_page_button_click");
        r0.a.merge(r5);
        r0.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobFileChoosePageButtonClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void d(String r1, String r2, Boolean r3, String r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r1 != null) goto L22;
    L7:
        if (r2 == null) goto L9;
        r6.put("collection_name", r2);     // Catch: JSONException -> L5
    L9:
        if (r3 != null) goto L11;
    L15:
        r6.put("upload_type", r4);     // Catch: JSONException -> L5
        if (r5 == null) goto L20;
        r6.put("upload_file_sec_type", r5);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobUploadStatus " + e.getLocalizedMessage());
    L20:
        TrackParams r7 = new TrackParams().merge(r6);
        by7.a r8 = new by7.a("upload_status");
        r8.a.merge(r7);
        r8.b();
        return;
    L11:
        if (r3.booleanValue() == false) goto L13;
        String r9 = "1";
    L14:
        r6.put("success", r9);     // Catch: JSONException -> L5
        goto L15
    L13:
        r9 = "0";
        goto L14
    L22:
        r6.put("collection_id", r1);     // Catch: JSONException -> L5
        goto L7
    }
}
