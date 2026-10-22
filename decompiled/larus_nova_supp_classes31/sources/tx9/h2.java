package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h2 {
    public static void b(String r2, String r3, Long r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("enter_method", r2);     // Catch: JSONException -> L7
        r0.put("leave_method", r3);     // Catch: JSONException -> L7
        if (r4 == null) goto L9;
        r0.put("duration", r4.toString());     // Catch: JSONException -> L7
    L9:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("leave_multi_task_manage");
        r6.a.merge(r5);
        r6.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobLeaveMultiTaskManage " + e.getLocalizedMessage());
        goto L9
    }

    public static void a(String r2, String r3, String r4, String r5, String r6, int r7) {
        JSONObject r1 = null;
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
        if ((r7 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r7 & 32) == 0) goto L20;
        r1 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L37;
    L25:
        if (r3 == null) goto L27;
        r1.put("current_page", r3);     // Catch: JSONException -> L23
    L27:
        if (r4 == null) goto L29;
        r1.put("chat_type", r4);     // Catch: JSONException -> L23
    L29:
        if (r5 == null) goto L31;
        r1.put("bot_id", r5);     // Catch: JSONException -> L23
    L31:
        if (r6 == null) goto L35;
        r1.put("bot_type", r6);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobClickMultiTaskManage " + e.getLocalizedMessage());
    L35:
        TrackParams r8 = new TrackParams().merge(r1);
        by7.a r9 = new by7.a("click_multi_task_manage");
        r9.a.merge(r8);
        r9.b();
        return;
    L37:
        r1.put("enter_method", r2);     // Catch: JSONException -> L23
        goto L25
    }

    public static void e(String r2, String r3, String r4, String r5, String r6, Integer r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L21;
    L7:
        if (r3 == null) goto L9;
        r0.put("enter_method", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L11;
        r0.put("node_type", r4);     // Catch: JSONException -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("node_title", r5);     // Catch: JSONException -> L5
    L13:
        if (r6 == null) goto L15;
        r0.put("reference_id", r6);     // Catch: JSONException -> L5
    L15:
        if (r7 == null) goto L19;
        r0.put("index", r7.toString());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobUnpinService " + e.getLocalizedMessage());
    L19:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("unpin_service");
        r9.a.merge(r8);
        r9.b();
        return;
    L21:
        r0.put("current_page", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void d(String r3, String r4, String r5, String r6, String r7, String r8, String r9, Integer r10) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "multi_task_manage");     // Catch: JSONException -> L16
        if (r3 == null) goto L6;
        r1.put("task_id", r3);     // Catch: JSONException -> L16
    L6:
        if (r4 == null) goto L8;
        r1.put("task_key", r4);     // Catch: JSONException -> L16
    L8:
        if (r5 == null) goto L10;
        r1.put("source_id", r5);     // Catch: JSONException -> L16
    L10:
        if (r6 == null) goto L12;
        r1.put("source_type", r6);     // Catch: JSONException -> L16
    L12:
        r1.put("task_title", r7);     // Catch: JSONException -> L16
        r1.put("task_type", r8);     // Catch: JSONException -> L16
        r1.put("reference_id", r9);     // Catch: JSONException -> L16
        if (r10 == null) goto L18;
        r1.put("index", r10.toString());     // Catch: JSONException -> L16
    L18:
        TrackParams r11 = new TrackParams().merge(r1);
        by7.a r12 = new by7.a("task_remove_confirm_show");
        r12.a.merge(r11);
        r12.b();
        return;
    L16:
        e = move-exception;
        FLogger.a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobTaskRemoveConfirmShow " + e.getLocalizedMessage());
        goto L18
    }

    public static void c(String r3, String r4, String r5, String r6, String r7, String r8, String r9, Integer r10, String r11) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "multi_task_manage");     // Catch: JSONException -> L17
        if (r3 == null) goto L6;
        r1.put("task_id", r3);     // Catch: JSONException -> L17
    L6:
        if (r4 == null) goto L8;
        r1.put("task_key", r4);     // Catch: JSONException -> L17
    L8:
        if (r5 == null) goto L10;
        r1.put("source_id", r5);     // Catch: JSONException -> L17
    L10:
        if (r6 == null) goto L12;
        r1.put("source_type", r6);     // Catch: JSONException -> L17
    L12:
        r1.put("task_title", r7);     // Catch: JSONException -> L17
        r1.put("task_type", r8);     // Catch: JSONException -> L17
        r1.put("reference_id", r9);     // Catch: JSONException -> L17
        if (r10 == null) goto L15;
        r1.put("index", r10.toString());     // Catch: JSONException -> L17
    L15:
        r1.put("click_from", r11);     // Catch: JSONException -> L17
    L19:
        TrackParams r12 = new TrackParams().merge(r1);
        by7.a r13 = new by7.a("task_remove_confirm_click");
        r13.a.merge(r12);
        r13.b();
        return;
    L17:
        e = move-exception;
        FLogger.a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobTaskRemoveConfirmClick " + e.getLocalizedMessage());
        goto L19
    }
}
