package nz9;

import by7.e;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static void a(Integer r3, String r4, String r5, Boolean r6) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.putOpt("click_position", r3);     // Catch: JSONException -> L7
        r1.putOpt("current_page", r4);     // Catch: JSONException -> L7
        r1.putOpt("click_from", r5);     // Catch: JSONException -> L7
        r1.putOpt("panel_type", "create_button_panel");     // Catch: JSONException -> L7
        if (r6 == null) goto L9;
        r1.putOpt("is_function_available", Integer.valueOf(r6.booleanValue() ? 1 : 0));     // Catch: JSONException -> L7
    L9:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r8 = new by7.a("click_create_panel");
        r8.a.merge(r7);
        r8.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobImageEditFunctionClick " + e.getLocalizedMessage());
        goto L9
    }

    public static void d(Integer r2, String r3, String r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r6 & 16) == 0) goto L17;
        JSONObject r7 = new JSONObject();
    L18:
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.putOpt("position", r2);     // Catch: JSONException -> L21
        r7.putOpt("current_page", r3);     // Catch: JSONException -> L21
        r7.putOpt("schema_name", r4);     // Catch: JSONException -> L21
        r7.putOpt("panel_type", r5);     // Catch: JSONException -> L21
    L23:
        TrackParams r8 = new TrackParams().merge(r7);
        by7.a r9 = new by7.a("show_create_panel_cell");
        r9.a.merge(r8);
        r9.b();
        return;
    L21:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobImageEditFunctionClick " + e.getLocalizedMessage());
        goto L23
    L17:
        r7 = null;
        goto L18
    }

    public static /* synthetic */ void c(String r11, Integer r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19) {
        b(r11, r12, r13, r14, r15, r16, r17, r18, new JSONObject(), null, r19);
    }

    public static final void b(String r1, Integer r2, String r3, String r4, String r5, String r6, String r7, String r8, JSONObject r9, e r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        r9.putOpt("ai_generate_tab_id", r6);     // Catch: JSONException -> L7
        r9.putOpt("ai_generate_tab_name", r8);     // Catch: JSONException -> L7
        r9.putOpt("ai_generate_tab_type", r7);     // Catch: JSONException -> L7
        r9.putOpt("bot_id", r11);     // Catch: JSONException -> L7
        r9.putOpt("leave_reason", r1);     // Catch: JSONException -> L7
        r9.putOpt("stay_duration", r2);     // Catch: JSONException -> L7
        r9.putOpt("action_bar_template_id", r4);     // Catch: JSONException -> L7
        r9.putOpt("action_bar_template_type", r5);     // Catch: JSONException -> L7
        if (r3 == null) goto L9;
        r9.put("enter_method", r3);     // Catch: JSONException -> L7
    L9:
        TrackParams r12 = new TrackParams().merge(r9);
        by7.a r13 = new by7.a("leave_image_generate_page");
        if (r10 == null) goto L12;
        r13.b = r10;
    L12:
        r13.a.merge(r12);
        r13.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("InstructionHitPoints", "error in mobLeaveImageGeneratePage " + e.getLocalizedMessage());
        goto L9
    }
}
