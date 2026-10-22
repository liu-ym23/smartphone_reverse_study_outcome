package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.FilePreviewFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b1 {
    public static void d(String r2, String r3, String r4, String r5, FilePreviewFragment r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("bot_id", r2);     // Catch: JSONException -> L5
        r0.putOpt("export_id", r4);     // Catch: JSONException -> L5
        r0.putOpt("click_from", r5);     // Catch: JSONException -> L5
        r0.putOpt("file_type", r3);     // Catch: JSONException -> L5
    L7:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("exporting_file_preview_click");
        r8.b = r6;
        r8.a.merge(r7);
        r8.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportingFilePreviewClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, by7.e r9, int r10) {
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
        if ((r10 & 256) == 0) goto L26;
        JSONObject r0 = new JSONObject();
    L28:
        if ((r10 & 512) == 0) goto L30;
        r9 = null;
    L30:
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("bot_id", r2);     // Catch: JSONException -> L33
        r0.putOpt("chat_type", r3);     // Catch: JSONException -> L33
        r0.putOpt("export_action_id", r4);     // Catch: JSONException -> L33
        r0.putOpt("page_token", r5);     // Catch: JSONException -> L33
        r0.putOpt("artifact_meta_id", r7);     // Catch: JSONException -> L33
        r0.putOpt("resource_type", r8);     // Catch: JSONException -> L33
        r0.putOpt("show_from", r6);     // Catch: JSONException -> L33
    L35:
        TrackParams r11 = new TrackParams().merge(r0);
        by7.a r12 = new by7.a("export_panel_show");
        if (r9 == null) goto L38;
        r12.b = r9;
    L38:
        r12.a.merge(r11);
        r12.b();
        return;
    L33:
        e = move-exception;
        FLogger.a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportPanelShow " + e.getLocalizedMessage());
        goto L35
    L26:
        r0 = null;
        goto L28
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Integer r11, String r12, String r13, by7.e r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r15 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r15 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r15 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r15 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r15 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r15 & 1024) == 0) goto L36;
        r12 = null;
    L36:
        if ((r15 & 2048) == 0) goto L39;
        r13 = null;
    L39:
        if ((r15 & 4096) == 0) goto L41;
        JSONObject r0 = new JSONObject();
    L43:
        if ((r15 & 8192) == 0) goto L45;
        r14 = null;
    L45:
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("bot_id", r2);     // Catch: JSONException -> L48
        r0.putOpt("chat_type", r3);     // Catch: JSONException -> L48
        r0.putOpt("show_from", r4);     // Catch: JSONException -> L48
        r0.putOpt("export_action_id", r5);     // Catch: JSONException -> L48
        r0.putOpt("message_id_list", r6);     // Catch: JSONException -> L48
        r0.putOpt("deep_research_id", r7);     // Catch: JSONException -> L48
        r0.putOpt("click_module", r8);     // Catch: JSONException -> L48
        r0.putOpt("page_token", r9);     // Catch: JSONException -> L48
        r0.putOpt("artifact_meta_id", r10);     // Catch: JSONException -> L48
        r0.putOpt("resource_type", r11);     // Catch: JSONException -> L48
        r0.putOpt("file_type", r12);     // Catch: JSONException -> L48
        r0.putOpt("current_page", r13);     // Catch: JSONException -> L48
    L50:
        TrackParams r16 = new TrackParams().merge(r0);
        by7.a r17 = new by7.a("export_panel_element_show");
        if (r14 == null) goto L53;
        r17.b = r14;
    L53:
        r17.a.merge(r16);
        r17.b();
        return;
    L48:
        e = move-exception;
        FLogger.a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportPanelElementShow " + e.getLocalizedMessage());
        goto L50
    L41:
        r0 = null;
        goto L43
    }

    public static void a(String r17, String r18, Integer r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, Integer r28, String r29, by7.e r30, int r31) {
        by7.e r2 = null;
        if ((r31 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r31 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r31 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r31 & 16384) == 0) goto L57;
        JSONObject r15 = new JSONObject();
    L59:
        if ((r31 & 32768) != 0) goto L62;
        r2 = r30;
    L62:
        Intrinsics.checkNotNullParameter(r15, "params");
        r15.putOpt("bot_id", r1);     // Catch: JSONException -> L65
        r15.putOpt("chat_type", r3);     // Catch: JSONException -> L65
        r15.putOpt("export_action_id", r6);     // Catch: JSONException -> L65
        r15.putOpt("click_from", r7);     // Catch: JSONException -> L65
        r15.putOpt("export_msg_cnt", r4);     // Catch: JSONException -> L65
        r15.putOpt("file_type", r5);     // Catch: JSONException -> L65
        r15.putOpt("message_id_list", r8);     // Catch: JSONException -> L65
        r15.putOpt("click_module", r10);     // Catch: JSONException -> L65
        r15.putOpt("deep_research_id", r9);     // Catch: JSONException -> L65
        r15.putOpt("page_token", r11);     // Catch: JSONException -> L65
        r15.putOpt("artifact_meta_id", r12);     // Catch: JSONException -> L65
        r15.putOpt("resource_type", r13);     // Catch: JSONException -> L65
        r15.putOpt("show_from", r14);     // Catch: JSONException -> L65
    L67:
        TrackParams r0 = new TrackParams().merge(r15);
        by7.a r16 = new by7.a("export_panel_element_click");
        if (r2 == null) goto L70;
        r16.b = r2;
    L70:
        r16.a.merge(r0);
        r16.b();
        return;
    L65:
        e = move-exception;
        FLogger.a.e("ExportFileEventHelper", "error in ExportFileEventHelper mobExportPanelElementClick " + e.getLocalizedMessage());
        goto L67
    L57:
        r15 = null;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
