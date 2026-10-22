package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n {
    public static void h(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("edit_way", "new_guidance_to_edit_notification");     // Catch: JSONException -> L5
        r0.put("click_from", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("create_bot_guidance_click");
        r1.a.merge(r5);
        r1.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_guidance_click " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L13;
    L7:
        if (r4 == null) goto L11;
        r0.put("create_way", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_choose_page_download_board_show " + e.getLocalizedMessage());
    L11:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("bot_image_ai_choose_page_download_board_show");
        r6.a.merge(r5);
        r6.b();
        return;
    L13:
        r0.put("creation_id", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L14;
    L7:
        r0.put("click_from", r3);     // Catch: JSONException -> L5
        if (r4 == null) goto L12;
        r0.put("create_way", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_choose_page_download_board_click " + e.getLocalizedMessage());
    L12:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("bot_image_ai_choose_page_download_board_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L14:
        r0.put("creation_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void d(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L15;
    L7:
        if (r3 == null) goto L9;
        r0.put("create_way", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L13;
        r0.put("enter_method", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_upload_adjust_page_enter " + e.getLocalizedMessage());
    L13:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("bot_image_upload_adjust_page_enter");
        r6.a.merge(r5);
        r6.b();
        return;
    L15:
        r0.put("creation_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L14;
    L7:
        r0.put("click_from", r3);     // Catch: JSONException -> L5
        if (r4 == null) goto L12;
        r0.put("create_way", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_add_image_method_sheet_click " + e.getLocalizedMessage());
    L12:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("create_bot_add_image_method_sheet_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L14:
        r0.put("creation_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r2, String r3, String r4, TraceFragment r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L18;
    L7:
        if (r3 == null) goto L9;
        r0.put("create_way", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L13;
        r0.put("enter_method", r4);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_upload_adjust_page_confirm " + e.getLocalizedMessage());
    L13:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("bot_image_upload_adjust_page_confirm");
        if (r5 == null) goto L16;
        r7.b = r5;
    L16:
        r7.a.merge(r6);
        r7.b();
        return;
    L18:
        r0.put("creation_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void e(String r2, String r3, String r4, TraceFragment r5, int r6) {
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
        JSONObject r0 = new JSONObject();
    L16:
        if ((r6 & 16) == 0) goto L18;
        r5 = null;
    L18:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L34;
    L23:
        if (r3 == null) goto L25;
        r0.put("click_from", r3);     // Catch: JSONException -> L21
    L25:
        if (r4 == null) goto L29;
        r0.put("create_way", r4);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_add_bot_image_entrance_click " + e.getLocalizedMessage());
    L29:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("create_bot_add_bot_image_entrance_click");
        if (r5 == null) goto L32;
        r8.b = r5;
    L32:
        r8.a.merge(r7);
        r8.b();
        return;
    L34:
        r0.put("creation_id", r2);     // Catch: JSONException -> L21
        goto L23
    L14:
        r0 = null;
        goto L16
    }

    public static void g(String r2, String r3, String r4, TraceFragment r5, int r6) {
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
        JSONObject r0 = new JSONObject();
    L16:
        if ((r6 & 16) == 0) goto L18;
        r5 = null;
    L18:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L34;
    L23:
        if (r3 == null) goto L25;
        r0.put("click_from", r3);     // Catch: JSONException -> L21
    L25:
        if (r4 == null) goto L29;
        r0.put("create_way", r4);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_add_image_method_sheet_show " + e.getLocalizedMessage());
    L29:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("create_bot_add_image_method_sheet_show");
        if (r5 == null) goto L32;
        r8.b = r5;
    L32:
        r8.a.merge(r7);
        r8.b();
        return;
    L34:
        r0.put("creation_id", r2);     // Catch: JSONException -> L21
        goto L23
    L14:
        r0 = null;
        goto L16
    }
}
