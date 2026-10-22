package tx9;

import android.text.TextUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 {
    public static void r() {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter("setting", "currentPage");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("current_page", "setting");
        TrackParams r1 = new TrackParams().merge(r0);
        by7.a r2 = new by7.a("click_model_service_auth_button");
        r2.a.merge(r1);
        r2.b();
    }

    public static void A(String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "desc");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("desc", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_send_error_dev");
        r1.a.merge(r4);
        r1.b();
    }

    public static void E(String r2) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 == null) goto L5;
        r0.put("permission_type", r2);
    L5:
        TrackParams r3 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_system_permission");
        r1.a.merge(r3);
        r1.b();
    }

    public static void k(String r4) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("current_page", "chat_list");     // Catch: JSONException -> L7
        if (r4 == null) goto L9;
        r1.put("enter_method", r4);     // Catch: JSONException -> L7
    L9:
        TrackParams r5 = new TrackParams().merge(r1);
        by7.a r0 = new by7.a("click_create_group_chat");
        r0.a.merge(r5);
        r0.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCreateGroupChat " + e.getLocalizedMessage());
        goto L9
    }

    public static void t(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        TrackParams r3 = new TrackParams().merge(r2);
        by7.a r0 = new by7.a("chat_list_not_bot_cell_click");
        r0.a.merge(r3);
        r0.b();
    }

    public static void v(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("to_status", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_personal_recommendation_switch");
        r1.a.merge(r5);
        r1.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickPersonalRecommendationSwitch " + e.getLocalizedMessage());
        goto L7
    }

    public static void F(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 == null) goto L5;
        r0.put("permission_type", r2);
    L5:
        r0.put("click_from", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r5 = new by7.a("system_permission_confirm_popup_click");
        r5.a.merge(r4);
        r5.b();
    }

    public static void a(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("current_page", r3);     // Catch: JSONException -> L7
        if (r4 == null) goto L9;
        r0.put("enter_method", r4);     // Catch: JSONException -> L7
    L9:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("click_add_friend");
        r6.a.merge(r5);
        r6.b();
        return;
    L7:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickAddFriend " + e.getLocalizedMessage());
        goto L9
    }

    public static void b(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "toStatus");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("to_status", r2);
        r0.put("click_from", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r5 = new by7.a("click_model_service_auth_confirm");
        r5.a.merge(r4);
        r5.b();
    }

    public static void c(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "fromStatus");
        Intrinsics.checkNotNullParameter(r3, "toStatus");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("from_status", r2);
        r0.put("to_status", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r5 = new by7.a("click_model_service_auth_status");
        r5.a.merge(r4);
        r5.b();
    }

    public static void s(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "permissionType");
        Intrinsics.checkNotNullParameter(r3, "toStatus");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("permission_type", r2);
        r0.put("to_status", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r5 = new by7.a("click_model_service_permission");
        r5.a.merge(r4);
        r5.b();
    }

    public static void y(String r4, TraceFragment r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("enter_method", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("click_search_button");
        if (r5 == null) goto L10;
        r1.b = r5;
    L10:
        r1.a.merge(r6);
        r1.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickSearchButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void B(JSONObject r2, CommonSettingFragment r3, String r4, int r5) {
        if ((32768 & r5) == 0) goto L6;
        r2 = new JSONObject();
    L6:
        if ((65536 & r5) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 131072) == 0) goto L11;
        r4 = null;
    L11:
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r4 == null) goto L15;
        r2.put("is_call_bot", r4);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickShareBot " + e.getLocalizedMessage());
    L23:
        TrackParams r6 = new TrackParams().merge(r2);
        by7.a r7 = new by7.a("click_share_bot");
        if (r3 == null) goto L26;
        r7.b = r3;
    L26:
        r7.a.merge(r6);
        r7.b();
        return;
    L15:
        if (com.larus.utils.o0.d(null) == false) goto L18;
        r2.put("user_case_item_id", null);     // Catch: JSONException -> L21
    L18:
        if (com.larus.utils.o0.d(null) == false) goto L23;
        r2.put("user_case_reco_request_id", null);     // Catch: JSONException -> L21
        goto L23
    }

    public static void p(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("enter_method", r2);     // Catch: JSONException -> L8
        if (r3 == null) goto L6;
        r0.put("tab_name", r3);     // Catch: JSONException -> L8
    L6:
        r0.put("tab_id", r4);     // Catch: JSONException -> L8
        r0.put("tab_type", r5);     // Catch: JSONException -> L8
    L10:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("click_discover_page_tab");
        r7.a.merge(r6);
        r7.b();
        return;
    L8:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickDiscoverPageTab " + e.getLocalizedMessage());
        goto L10
    }

    public static void w(String r2, JSONObject r3, by7.e r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = new JSONObject();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r2 != null) goto L22;
    L17:
        TrackParams r6 = new TrackParams().merge(r3);
        by7.a r7 = new by7.a("click_plus");
        if (r4 == null) goto L20;
        r7.b = r4;
    L20:
        r7.a.merge(r6);
        r7.b();
        return;
    L22:
        r3.put("to_status", r2);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickPlus " + e.getLocalizedMessage());
        goto L17
    }

    public static void q(String r2, String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L18;
    L7:
        if (r3 == null) goto L9;
        r0.put("conversation_id", r3);     // Catch: JSONException -> L5
    L9:
        if (r4 == null) goto L11;
        r0.put("current_page", r4);     // Catch: JSONException -> L5
    L11:
        if (r5 == null) goto L13;
        r0.put("previous_page", r5);     // Catch: JSONException -> L5
    L13:
        r0.put("button_name", r6);     // Catch: JSONException -> L5
    L16:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("click_memory_welcome_window");
        r8.a.merge(r7);
        r8.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickMemoryWelcomeWindow " + e.getLocalizedMessage());
        goto L16
    L18:
        r0.put("bot_id", r2);     // Catch: JSONException -> L5
        goto L7
    }

    public static void z(String r2, String r3, String r4, String r5, int r6) {
        JSONObject r1 = null;
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r6 & 16) == 0) goto L17;
        r1 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L32;
    L22:
        if (r3 == null) goto L24;
        r1.put("url", r3);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L26;
        r1.put("card_source", r4);     // Catch: JSONException -> L20
    L26:
        if (r5 == null) goto L30;
        r1.put("baike_id", r5);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickSearchCard " + e.getLocalizedMessage());
    L30:
        TrackParams r7 = new TrackParams().merge(r1);
        by7.a r8 = new by7.a("click_search_card");
        r8.a.merge(r7);
        r8.b();
        return;
    L32:
        r1.put("message_type", r2);     // Catch: JSONException -> L20
        goto L22
    }

    public static void d(String r2, String r3, String r4, JSONObject r5, by7.e r6, int r7) {
        if ((r7 & 128) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 256) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 16384) == 0) goto L12;
        r4 = null;
    L12:
        if ((32768 & r7) == 0) goto L15;
        r5 = new JSONObject();
    L15:
        if ((r7 & 65536) == 0) goto L17;
        r6 = null;
    L17:
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r2 != null) goto L33;
    L22:
        if (r3 == null) goto L24;
        r5.put("req_id", r3);     // Catch: JSONException -> L20
    L24:
        if (r4 == null) goto L28;
        r5.put("is_call_bot", r4);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickBotCreatorInfo " + e.getLocalizedMessage());
    L28:
        TrackParams r8 = new TrackParams().merge(r5);
        by7.a r9 = new by7.a("click_bot_creator_info");
        if (r6 == null) goto L31;
        r9.b = r6;
    L31:
        r9.a.merge(r8);
        r9.b();
        return;
    L33:
        r5.put("recommend_from", r2);     // Catch: JSONException -> L20
        goto L22
    }

    public static void f(String r2, String r3, String r4, String r5, by7.e r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 16) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 32) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 64) == 0) goto L17;
        JSONObject r0 = new JSONObject();
    L19:
        if ((r7 & 128) == 0) goto L21;
        r6 = null;
    L21:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L39;
    L26:
        if (r3 == null) goto L28;
        r0.put("enter_from", r3);     // Catch: JSONException -> L24
    L28:
        if (r5 == null) goto L30;
        r0.put("click_from", r5);     // Catch: JSONException -> L24
    L30:
        if (r4 == null) goto L34;
        r0.put("create_way", r4);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickChangeVoice " + e.getLocalizedMessage());
    L34:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("click_change_voice");
        if (r6 == null) goto L37;
        r9.b = r6;
    L37:
        r9.a.merge(r8);
        r9.b();
        return;
    L39:
        r0.put("bot_id", r2);     // Catch: JSONException -> L24
        goto L26
    L17:
        r0 = null;
        goto L19
    }

    public static void o(String r2, String r3, String r4, Boolean r5, String r6, int r7) {
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
        if (r2 != null) goto L41;
    L25:
        if (r3 == null) goto L27;
        r1.put("click_from", r3);     // Catch: JSONException -> L23
    L27:
        if (r4 == null) goto L29;
        r1.put("current_page", r4);     // Catch: JSONException -> L23
    L29:
        if (r5 != null) goto L31;
    L35:
        if (r6 == null) goto L39;
        r1.put("panel_type", r6);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickCreatePanel " + e.getLocalizedMessage());
    L39:
        TrackParams r8 = new TrackParams().merge(r1);
        by7.a r9 = new by7.a("click_create_panel");
        r9.a.merge(r8);
        r9.b();
        return;
    L31:
        if (r5.booleanValue() == false) goto L33;
        String r10 = "1";
    L34:
        r1.put("is_function_available", r10);     // Catch: JSONException -> L23
        goto L35
    L33:
        r10 = "0";
        goto L34
    L41:
        r1.put("click_position", r2);     // Catch: JSONException -> L23
        goto L25
    }

    public static final void m(String r1, String r2, String r3, String r4, String r5, JSONObject r6, by7.e r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r1 != null) goto L23;
    L7:
        if (r2 == null) goto L9;
        r6.put("current_page", r2);     // Catch: JSONException -> L5
    L9:
        if (r3 == null) goto L11;
        r6.put("enter_from", r3);     // Catch: JSONException -> L5
    L11:
        if (r4 == null) goto L13;
        r6.put("previous_page", r4);     // Catch: JSONException -> L5
    L13:
        if (r5 == null) goto L15;
        r6.put("enter_method", r5);     // Catch: JSONException -> L5
    L15:
        String r8 = b4.a;     // Catch: JSONException -> L5
        String r9 = UUID.randomUUID().toString();     // Catch: JSONException -> L5
        b4.a = r9;     // Catch: JSONException -> L5
        r6.put("voice_create_id", r9);     // Catch: JSONException -> L5
    L18:
        TrackParams r10 = new TrackParams().merge(r6);
        by7.a r11 = new by7.a("click_create_own_voice_button");
        if (r7 == null) goto L21;
        r11.b = r7;
    L21:
        r11.a.merge(r10);
        r11.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCreateOwnVoiceButton " + e.getLocalizedMessage());
        goto L18
    L23:
        r6.put("click_from", r1);     // Catch: JSONException -> L5
        goto L7
    }

    public static void J(String r2, String r3, String r4, Boolean r5, Boolean r6, Integer r7, String r8, int r9) {
        JSONObject r1 = null;
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r9 & 128) == 0) goto L26;
        JSONObject r10 = new JSONObject();
    L27:
        Intrinsics.checkNotNullParameter(r10, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L54
        if (r2 == null) goto L31;
        r10.put("button_name", r2);     // Catch: Throwable -> L54
    L31:
        if (r3 == null) goto L33;
        r10.put("creation_id", r3);     // Catch: Throwable -> L54
    L33:
        if (r4 == null) goto L35;
        r10.put("create_way", r4);     // Catch: Throwable -> L54
    L35:
        String r11 = "1";
        if (r5 != null) goto L38;
    L42:
        if (r6 != null) goto L44;
    L48:
        if (r7 == null) goto L50;
        r10.put("polish_cnt", String.valueOf(r7.intValue()));     // Catch: Throwable -> L54
    L50:
        if (r8 == null) goto L52;
        r1 = r10.put("current_page", r8);     // Catch: Throwable -> L54
    L52:
        Result.constructor-impl(r1);     // Catch: Throwable -> L54
    L56:
        TrackParams r12 = new TrackParams().merge(r10);
        by7.a r13 = new by7.a("sp_polish_click");
        r13.a.merge(r12);
        r13.b();
        return;
    L44:
        if (r6.booleanValue() == true) goto L47;
        r11 = "0";
    L47:
        r10.put("if_polish", r11);     // Catch: Throwable -> L54
        goto L48
    L38:
        if (r5.booleanValue() == false) goto L40;
        Object r14 = "1";
    L41:
        r10.put("if_auto_filled", r14);     // Catch: Throwable -> L54
        goto L42
    L40:
        r14 = "0";
    L54:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L26:
        r10 = null;
        goto L27
    }

    public static void K(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r3 != null) goto L21;
    L7:
        r1.put("chat_type", r4);     // Catch: JSONException -> L5
        r1.put("current_page", r5);     // Catch: JSONException -> L5
        r1.put("click_from", "click_button");     // Catch: JSONException -> L5
        if (r6 == null) goto L10;
        r1.put("conversation_id", r6);     // Catch: JSONException -> L5
    L10:
        r1.put("success", r7);     // Catch: JSONException -> L5
        if (r8 == null) goto L13;
        r1.put("from_activity_name", r8);     // Catch: JSONException -> L5
    L13:
        if (r9 == null) goto L15;
        r1.put("from_activity_module", r9);     // Catch: JSONException -> L5
    L15:
        if (r10 == null) goto L19;
        r1.put("previous_page", r10);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobSubscribe " + e.getLocalizedMessage());
    L19:
        TrackParams r11 = new TrackParams().merge(r1);
        by7.a r12 = new by7.a("subscribe");
        r12.a.merge(r11);
        r12.b();
        return;
    L21:
        r1.put("bot_id", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void n(String r2, String r3, String r4, String r5, String r6, JSONObject r7, CommonSettingFragment r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = new JSONObject();
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        m(r2, r3, r4, r5, r6, r7, r8);
    }

    public static void h(String r2, String r3, String r4, String r5, String r6, String r7, JSONObject r8, TraceFragment r9, int r10) {
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
        r8 = new JSONObject();
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r2 != null) goto L48;
    L31:
        if (r3 == null) goto L33;
        r8.put("current_page", r3);     // Catch: JSONException -> L29
    L33:
        if (r4 == null) goto L35;
        r8.put("group_type", r4);     // Catch: JSONException -> L29
    L35:
        if (r5 == null) goto L37;
        r8.put("is_immersive_background", r5);     // Catch: JSONException -> L29
    L37:
        if (r6 == null) goto L39;
        r8.put("recommend_from", r6);     // Catch: JSONException -> L29
    L39:
        if (r7 == null) goto L43;
        r8.put("req_id", r7);     // Catch: JSONException -> L29
    L29:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickClearMessageConfirm " + e.getLocalizedMessage());
    L43:
        TrackParams r11 = new TrackParams().merge(r8);
        by7.a r12 = new by7.a("click_clear_message_confirm");
        if (r9 == null) goto L46;
        r12.b = r9;
    L46:
        r12.a.merge(r11);
        r12.b();
        return;
    L48:
        r8.put("bot_id", r2);     // Catch: JSONException -> L29
        goto L31
    }

    public static void I(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, by7.e r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 32) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 64) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 128) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 256) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 512) == 0) goto L29;
        JSONObject r0 = new JSONObject();
    L31:
        if ((r11 & 1024) == 0) goto L33;
        r10 = null;
    L33:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L59;
    L38:
        if (r4 == null) goto L40;
        r0.put("previous_page", r4);     // Catch: JSONException -> L36
    L40:
        if (r3 == null) goto L42;
        r0.put("creation_id", r3);     // Catch: JSONException -> L36
    L42:
        if (r5 == null) goto L44;
        r0.put("create_way", r5);     // Catch: JSONException -> L36
    L44:
        if (r7 == null) goto L46;
        r0.put("type", r7);     // Catch: JSONException -> L36
    L46:
        if (r6 == null) goto L48;
        r0.put("click_from", r6);     // Catch: JSONException -> L36
    L48:
        if (r8 == null) goto L50;
        r0.put("from_activity_name", r8);     // Catch: JSONException -> L36
    L50:
        if (r9 == null) goto L54;
        r0.put("from_activity_module", r9);     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper createBotBlockWindowClick " + e.getLocalizedMessage());
    L54:
        TrackParams r12 = new TrackParams().merge(r0);
        by7.a r13 = new by7.a("create_bot_block_window_click");
        if (r10 == null) goto L57;
        r13.b = r10;
    L57:
        r13.a.merge(r12);
        r13.b();
        return;
    L59:
        r0.put("enter_method", r2);     // Catch: JSONException -> L36
        goto L38
    L29:
        r0 = null;
        goto L31
    }

    public static void l(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, by7.e r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((r11 & 32) == 0) goto L18;
        r6 = null;
    L18:
        if ((r11 & 64) == 0) goto L21;
        r7 = null;
    L21:
        if ((r11 & 128) == 0) goto L24;
        r8 = null;
    L24:
        if ((r11 & 256) == 0) goto L27;
        r9 = null;
    L27:
        if ((r11 & 512) == 0) goto L29;
        JSONObject r0 = new JSONObject();
    L31:
        if ((r11 & 1024) == 0) goto L33;
        r10 = null;
    L33:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L59;
    L38:
        if (r4 == null) goto L40;
        r0.put("enter_from", r4);     // Catch: JSONException -> L36
    L40:
        if (r5 == null) goto L42;
        r0.put("enter_method", r5);     // Catch: JSONException -> L36
    L42:
        if (r6 == null) goto L44;
        r0.put("create_way", r6);     // Catch: JSONException -> L36
    L44:
        if (r7 == null) goto L46;
        r0.put("creation_id", r7);     // Catch: JSONException -> L36
    L46:
        if (r3 == null) goto L48;
        r0.put("previous_page", r3);     // Catch: JSONException -> L36
    L48:
        if (r8 == null) goto L50;
        r0.put("from_activity_name", r8);     // Catch: JSONException -> L36
    L50:
        if (r9 == null) goto L54;
        r0.put("from_activity_module", r9);     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCreateNewBot " + e.getLocalizedMessage());
    L54:
        TrackParams r12 = new TrackParams().merge(r0);
        by7.a r13 = new by7.a("click_create_new_bot");
        if (r10 == null) goto L57;
        r13.b = r10;
    L57:
        r13.a.merge(r12);
        r13.b();
        return;
    L59:
        r0.put("current_page", r2);     // Catch: JSONException -> L36
        goto L38
    L29:
        r0 = null;
        goto L31
    }

    public static void e(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, JSONObject r13, by7.e r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r15 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((r15 & 32) == 0) goto L18;
        r6 = null;
    L18:
        if ((r15 & 64) == 0) goto L21;
        r7 = null;
    L21:
        if ((r15 & 128) == 0) goto L24;
        r8 = null;
    L24:
        if ((r15 & 2048) == 0) goto L27;
        r9 = null;
    L27:
        if ((r15 & 4096) == 0) goto L30;
        r10 = "0";
    L30:
        if ((32768 & r15) == 0) goto L33;
        r11 = null;
    L33:
        if ((65536 & r15) == 0) goto L36;
        r12 = null;
    L36:
        if ((131072 & r15) == 0) goto L39;
        r13 = new JSONObject();
    L39:
        if ((r15 & 262144) == 0) goto L41;
        r14 = null;
    L41:
        Intrinsics.checkNotNullParameter(r10, "isContinuousSpeak");
        Intrinsics.checkNotNullParameter(r13, "params");
        if (r2 != null) goto L72;
    L46:
        if (r3 == null) goto L48;
        r13.put("conversation_id", r3);     // Catch: JSONException -> L44
    L48:
        if (r4 == null) goto L50;
        r13.put("current_page", r4);     // Catch: JSONException -> L44
    L50:
        if (r7 == null) goto L52;
        r13.put("chat_type", r7);     // Catch: JSONException -> L44
    L52:
        if (r5 == null) goto L54;
        r13.put("enter_from", r5);     // Catch: JSONException -> L44
    L54:
        if (r6 == null) goto L56;
        r13.put("enter_method", r6);     // Catch: JSONException -> L44
    L56:
        if (r8 == null) goto L58;
        r13.put("red_dot", r8);     // Catch: JSONException -> L44
    L58:
        if (r9 == null) goto L60;
        r13.put("is_immersive_background", r9);     // Catch: JSONException -> L44
    L60:
        if (r11 == null) goto L62;
        r13.put("mic_status", r11);     // Catch: JSONException -> L44
    L62:
        if (r12 == null) goto L64;
        r13.put("camera_status", r12);     // Catch: JSONException -> L44
    L64:
        r13.put("is_continuous_speak", r10);     // Catch: JSONException -> L44
    L67:
        TrackParams r16 = new TrackParams().merge(r13);
        by7.a r17 = new by7.a("click_call");
        if (r14 == null) goto L70;
        r17.b = r14;
    L70:
        r17.a.merge(r16);
        r17.b();
        return;
    L44:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCall " + e.getLocalizedMessage());
        goto L67
    L72:
        r13.put("bot_id", r2);     // Catch: JSONException -> L44
        goto L46
    }

    public static void G(String r20, String r21, String r22, Long r23, Long r24, String r25, String r26, String r27, Boolean r28, String r29, String r30, Boolean r31, Boolean r32, by7.e r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Long r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r34 & 128) == 0) goto L25;
        Long r7 = null;
    L27:
        if ((r34 & 256) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r34 & 1024) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r34 & 2048) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r34 & 4096) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r34 & 8192) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r34 & 16384) == 0) goto L49;
        String r13 = null;
    L51:
        if ((32768 & r34) == 0) goto L53;
        String r14 = null;
    L55:
        if ((65536 & r34) == 0) goto L57;
        Boolean r15 = null;
    L59:
        if ((r34 & 131072) == 0) goto L61;
        Boolean r16 = null;
    L63:
        if ((r34 & 262144) == 0) goto L65;
        JSONObject r2 = new JSONObject();
    L67:
        if ((r34 & 524288) == 0) goto L69;
        by7.e r19 = null;
    L70:
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r1 != null) goto L123;
    L75:
        if (r3 == null) goto L77;
        r2.put("chat_type", r3);     // Catch: JSONException -> L73
    L77:
        if (r4 == null) goto L79;
        r2.put("click_from", r4);     // Catch: JSONException -> L73
    L79:
        if (r5 == null) goto L81;
        r2.put("conversation_id", r5.longValue());     // Catch: JSONException -> L73
    L81:
        if (r6 == null) goto L83;
        r2.put("current_page", r6);     // Catch: JSONException -> L73
    L83:
        if (r7 == null) goto L85;
        r2.put("is_onboarding", r7.longValue());     // Catch: JSONException -> L73
    L85:
        if (r8 == null) goto L87;
        r2.put("message_id", r8);     // Catch: JSONException -> L73
    L87:
        if (r9 == null) goto L89;
        r2.put("to_status", r9);     // Catch: JSONException -> L73
    L89:
        if (r10 == null) goto L91;
        r2.put("is_tts_open", r10);     // Catch: JSONException -> L73
    L91:
        String r0 = "1";
        if (r11 != null) goto L94;
    L98:
        if (r12 == null) goto L100;
        r2.put("tts_switch_enter_method", r12);     // Catch: JSONException -> L73
    L100:
        if (r13 == null) goto L102;
        r2.put("user_type", r13);     // Catch: JSONException -> L73
    L102:
        if (r14 == null) goto L104;
        r2.put("click_module", r14);     // Catch: JSONException -> L73
    L104:
        if (r15 != null) goto L106;
    L110:
        if (r16 != null) goto L112;
    L118:
        TrackParams r17 = new TrackParams().merge(r2);
        by7.a r18 = new by7.a("click_tts_play_button");
        by7.e r35 = r19;
        if (r35 == null) goto L121;
        r18.b = r35;
    L121:
        r18.a.merge(r17);
        r18.b();
        return;
    L112:
        if (r16.booleanValue() == true) goto L115;
        r0 = "0";
    L115:
        r2.put("is_simultaneous_interpretation", r0);     // Catch: JSONException -> L73
    L73:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickTtsPlayButton " + e.getLocalizedMessage());
        goto L118
    L106:
        if (r15.booleanValue() == false) goto L108;
        Object r36 = "1";
    L109:
        r2.put("is_thinking_generating", r36);     // Catch: JSONException -> L73
        goto L110
    L108:
        r36 = "0";
        goto L109
    L94:
        if (r11.booleanValue() == false) goto L96;
        Object r37 = "1";
    L97:
        r2.put("is_message_generating", r37);     // Catch: JSONException -> L73
        goto L98
    L96:
        r37 = "0";
        goto L97
    L123:
        r2.put("bot_id", r1);     // Catch: JSONException -> L73
        goto L75
    L69:
        r19 = r33;
        goto L70
    L65:
        r2 = null;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = "bot";
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = "chat";
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }

    public static void g(String r19, String r20, String r21, JSONObject r22, by7.e r23, String r24, String r25, Integer r26, String r27, String r28, String r29, String r30, String r31, Boolean r32, String r33, String r34, String r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        JSONObject r5 = new JSONObject();
    L19:
        if ((r36 & 16) == 0) goto L21;
        by7.e r6 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r36 & 128) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r36 & 256) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r36 & 512) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r36 & 1024) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r36 & 2048) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r36 & 4096) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r36 & 8192) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r36 & 16384) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r36 & 32768) == 0) goto L61;
        Boolean r16 = null;
    L63:
        if ((r36 & 65536) == 0) goto L65;
        String r2 = null;
    L67:
        if ((r36 & 131072) == 0) goto L69;
        String r17 = "text";
    L71:
        if ((r36 & 262144) == 0) goto L73;
        String r210 = null;
    L74:
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r17 != null) goto L120;
    L79:
        if (r1 == null) goto L81;
        r5.put("bot_id", r1);     // Catch: JSONException -> L77
    L81:
        if (r3 == null) goto L83;
        r5.put("conversation_id", r3);     // Catch: JSONException -> L77
    L83:
        if (r4 == null) goto L85;
        r5.put("message_id", r4);     // Catch: JSONException -> L77
    L85:
        if (r7 == null) goto L87;
        r5.put("current_page", r7);     // Catch: JSONException -> L77
    L87:
        if (r10 == null) goto L89;
        r5.put("is_onboarding", r10.intValue());     // Catch: JSONException -> L77
    L89:
        if (r11 == null) goto L91;
        r5.put("click_from", r11);     // Catch: JSONException -> L77
    L91:
        if (r9 == null) goto L93;
        r5.put("chat_type", r9);     // Catch: JSONException -> L77
    L93:
        if (r8 == null) goto L95;
        r5.put("group_type", r8);     // Catch: JSONException -> L77
    L95:
        if (r12 == null) goto L97;
        r5.put("user_type", r12);     // Catch: JSONException -> L77
    L97:
        if (r13 == null) goto L99;
        r5.put("scene", r13);     // Catch: JSONException -> L77
    L99:
        if (r14 == null) goto L101;
        r5.put("click_module", r14);     // Catch: JSONException -> L77
    L101:
        if (r15 == null) goto L103;
        r5.put("agent_id", r15);     // Catch: JSONException -> L77
    L103:
        if (r16 != null) goto L105;
    L109:
        if (r2 == null) goto L111;
        r5.put("edu_skill", r2);     // Catch: JSONException -> L77
    L111:
        if (r210 == null) goto L115;
        r5.put("select_range", r210);     // Catch: JSONException -> L77
    L77:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCiteButton " + e.getLocalizedMessage());
    L115:
        TrackParams r0 = new TrackParams().merge(r5);
        by7.a r18 = new by7.a("click_cite_button");
        if (r6 == 0) goto L118;
        r18.b = r6;
    L118:
        r18.a.merge(r0);
        r18.b();
        return;
    L105:
        if (r16.booleanValue() == false) goto L107;
        String r37 = "1";
    L108:
        r5.put("is_thinking_generating", r37);     // Catch: JSONException -> L77
        goto L109
    L107:
        r37 = "0";
        goto L108
    L120:
        r5.put("content_type", r17);     // Catch: JSONException -> L77
        goto L79
    L73:
        r210 = r35;
        goto L74
    L69:
        r17 = r34;
        goto L71
    L65:
        r2 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = "private";
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }

    public static void x(String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, Boolean r29, String r30, String r31, String r32, String r33, JSONObject r34, by7.e r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r36 & 64) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r36 & 128) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r36 & 4096) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((524288 & r36) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((1048576 & r36) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((2097152 & r36) == 0) goto L45;
        Boolean r12 = null;
    L47:
        if ((4194304 & r36) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((8388608 & r36) == 0) goto L53;
        Object r14 = null;
    L55:
        if ((16777216 & r36) == 0) goto L57;
        Object r15 = null;
    L59:
        if ((r36 & 33554432) == 0) goto L61;
        Object r2 = null;
    L63:
        if ((r36 & 67108864) == 0) goto L65;
        JSONObject r16 = new JSONObject();
    L67:
        if ((r36 & 134217728) == 0) goto L69;
        by7.e r18 = null;
    L70:
        Intrinsics.checkNotNullParameter(r16, "params");
        r16.putOpt("creation_task_id", r2);     // Catch: JSONException -> L101
        if (r12 == null) goto L74;
        String r17 = l3.f(r12);     // Catch: JSONException -> L101
    L75:
        r16.putOpt("is_deep_thinking", r17);     // Catch: JSONException -> L101
        r16.putOpt("ai_create_show_mode", r13);     // Catch: JSONException -> L101
        if (r1 == null) goto L78;
        r16.put("bot_id", r1);     // Catch: JSONException -> L101
    L78:
        if (r3 == null) goto L80;
        r16.put("chat_type", r3);     // Catch: JSONException -> L101
    L80:
        if (r4 == null) goto L82;
        r16.put("click_from", r4);     // Catch: JSONException -> L101
    L82:
        if (r5 == null) goto L84;
        r16.put("conversation_id", r5);     // Catch: JSONException -> L101
    L84:
        if (r6 == null) goto L86;
        r16.put("current_page", r6);     // Catch: JSONException -> L101
    L86:
        if (r7 == null) goto L88;
        r16.put("message_id", r7);     // Catch: JSONException -> L101
    L88:
        if (r8 == null) goto L90;
        r16.put("message_type", r8);     // Catch: JSONException -> L101
    L90:
        if (r9 == null) goto L92;
        r16.put("recommend_from", r9);     // Catch: JSONException -> L101
    L92:
        if (r11 == null) goto L94;
        r16.put("is_call_bot", r11);     // Catch: JSONException -> L101
    L94:
        if (r10 == null) goto L96;
        r16.put("message_is_interrupted", r10);     // Catch: JSONException -> L101
    L96:
        if (r14 == null) goto L98;
        r16.put("user_case_item_id", r14);     // Catch: JSONException -> L101
    L98:
        if (r15 == 0) goto L103;
        r16.put("user_case_reco_request_id", r15);     // Catch: JSONException -> L101
    L103:
        TrackParams r0 = new TrackParams().merge(r16);
        by7.a r37 = new by7.a("click_regenerate");
        by7.e r38 = r18;
        if (r38 == null) goto L106;
        r37.b = r38;
    L106:
        r37.a.merge(r0);
        r37.b();
        return;
    L74:
        r17 = null;
    L101:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickRegenerate " + e.getLocalizedMessage());
        goto L103
    L69:
        r18 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r2 = r33;
        goto L63
    L57:
        r15 = r32;
        goto L59
    L53:
        r14 = r31;
        goto L55
    L49:
        r13 = r30;
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }

    public static final void C(String r16, String r17, String r18, String r19, String r20, Long r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, JSONObject r35, by7.e r36) {
        Intrinsics.checkNotNullParameter(r35, "params");
        if (r27 != null) goto L47;
    L5:
        if (r30 == null) goto L7;
        r35.put("task_id", r30);     // Catch: JSONException -> L33
    L7:
        r35.put("soft_link_type", r26);     // Catch: JSONException -> L33
        if (r32 == null) goto L10;
        r35.put("entity_id", r32);     // Catch: JSONException -> L33
    L10:
        if (r31 == null) goto L12;
        r35.put("bcm_id", r31);     // Catch: JSONException -> L33
    L12:
        if (r16 == null) goto L14;
        r35.put("bot_id", r16);     // Catch: JSONException -> L33
    L14:
        if (r17 == null) goto L16;
        r35.put("conversation_id", r17);     // Catch: JSONException -> L33
    L16:
        r35.put("current_page", r18);     // Catch: JSONException -> L33
        r35.put("is_onboarding", r19);     // Catch: JSONException -> L33
        if (r20 == null) goto L19;
        r35.put("message_id", r20);     // Catch: JSONException -> L33
    L19:
        if (r21 == null) goto L21;
        r35.put("position", r21.longValue());     // Catch: JSONException -> L33
    L21:
        if (r22 == null) goto L23;
        r35.put("text", r22);     // Catch: JSONException -> L33
    L23:
        if (r23 == null) goto L25;
        r35.put("url", r23);     // Catch: JSONException -> L33
    L25:
        if (r34 == null) goto L27;
        r35.put("doc_id", r34);     // Catch: JSONException -> L33
    L27:
        if (r24 == null) goto L29;
        r35.put("baike_id", r24);     // Catch: JSONException -> L33
    L29:
        if (r25 == null) goto L31;
        r35.put("link_type", r25);     // Catch: JSONException -> L33
    L31:
        if (r33 == null) goto L35;
        r35.put("agent_id", r33);     // Catch: JSONException -> L33
    L35:
        if (r28 == null) goto L38;
        r35.put("msg_candidate_source", r28);     // Catch: JSONException -> L33
    L38:
        if (r29 == null) goto L42;
        r35.put("msg_group_id", r29);     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickSpecialSoftLink " + e.getLocalizedMessage());
    L42:
        TrackParams r0 = new TrackParams().merge(r35);
        by7.a r1 = new by7.a("click_special_soft_link");
        if (r36 == null) goto L45;
        r1.b = r36;
    L45:
        r1.a.merge(r0);
        r1.b();
        return;
    L47:
        r35.put("source_type", r27);     // Catch: JSONException -> L33
        goto L5
    }

    public static void H(String r23, String r24, String r25, Integer r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, int r36, String r37, String r38, Integer r39, String r40, Integer r41, String r42, String r43, String r44, String r45, int r46) {
        if ((r46 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r46 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r46 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r46 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r46 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r46 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r46 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r46 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r46 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r46 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r46 & 4096) == 0) goto L53;
        String r14 = null;
    L54:
        boolean r16 = false;
        if ((r46 & 8192) == 0) goto L57;
        int r15 = 0;
    L59:
        if ((r46 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r46 & 32768) == 0) goto L65;
        String r17 = null;
    L67:
        if ((r46 & 65536) == 0) goto L69;
        Integer r18 = null;
    L71:
        if ((r46 & 131072) == 0) goto L73;
        String r19 = null;
    L75:
        if ((r46 & 262144) == 0) goto L77;
        Integer r20 = null;
    L78:
        String r210 = r4;
        if ((r46 & 524288) == 0) goto L81;
        String r21 = null;
    L83:
        if ((r46 & 1048576) == 0) goto L85;
        String r110 = null;
    L86:
        String r211 = r110;
        if ((r46 & 2097152) == 0) goto L89;
        String r111 = null;
    L90:
        String r212 = r21;
        if ((r46 & 4194304) == 0) goto L93;
        String r22 = null;
    L95:
        if ((r46 & 8388608) == 0) goto L97;
        JSONObject r112 = new JSONObject();
    L98:
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r12 != null) goto L153;
    L103:
        if (r111 == null) goto L105;
        r112.put("spring_guide_card_id", r111);     // Catch: JSONException -> L101
    L105:
        if (r1 == null) goto L107;
        r112.put("bot_id", r1);     // Catch: JSONException -> L101
    L107:
        if (r22 == null) goto L109;
        r112.put("album_status", r22);     // Catch: JSONException -> L101
    L109:
        if (r3 == null) goto L111;
        r112.put("click_from", r3);     // Catch: JSONException -> L101
    L111:
        if (r5 == null) goto L113;
        r112.put("is_ocr", r5.intValue());     // Catch: JSONException -> L101
    L113:
        if (r6 == null) goto L115;
        r112.put("chat_type", r6);     // Catch: JSONException -> L101
    L115:
        if (r7 == null) goto L117;
        r112.put("current_page", r7);     // Catch: JSONException -> L101
    L117:
        if (r9 == null) goto L119;
        r112.put("action_bar_template_id", r9);     // Catch: JSONException -> L101
    L119:
        if (r10 == null) goto L121;
        r112.put("action_bar_template_type", r10);     // Catch: JSONException -> L101
    L121:
        if (r13 != null) goto L123;
    L124:
        r16 = true;
    L126:
        if (r16 == false) goto L128;
        r112.put("cited_from_user_type", "no_cite");     // Catch: JSONException -> L101
    L129:
        if (r14 == null) goto L131;
        r112.put("cited_message_id", r14);     // Catch: JSONException -> L101
    L131:
        if (r2 == null) goto L133;
        r112.put("presentation_id", r2);     // Catch: JSONException -> L101
    L133:
        if (r17 == null) goto L135;
        r112.put("resource_id", r17);     // Catch: JSONException -> L101
    L135:
        if (r18 == null) goto L137;
        r112.put("resource_type", r18.intValue());     // Catch: JSONException -> L101
    L137:
        if (r19 == 0) goto L139;
        r112.put("artifact_meta_id", r19);     // Catch: JSONException -> L101
    L139:
        if (r20 == null) goto L141;
        r112.put("artifact_type", r20.intValue());     // Catch: JSONException -> L101
    L141:
        if (r212 == null) goto L143;
        r112.put("aippt_task_id", r212);     // Catch: JSONException -> L101
    L143:
        if (r211 == null) goto L145;
        r112.put("canvas_type", r211);     // Catch: JSONException -> L101
    L145:
        r112.put("is_ai_doc", r15);     // Catch: JSONException -> L101
        if (r210 == null) goto L148;
        r112.put("enter_method", r210);     // Catch: JSONException -> L101
    L148:
        r112.putOpt("action_bar_item_id", r11);     // Catch: JSONException -> L101
        r112.putOpt("previous_page", r8);     // Catch: JSONException -> L101
    L151:
        TrackParams r0 = new TrackParams().merge(r112);
        by7.a r47 = new by7.a("click_upload_entrance");
        r47.a.merge(r0);
        r47.b();
        return;
    L101:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickUploadEntrance " + e.getLocalizedMessage());
        goto L151
    L128:
        r112.put("cited_from_user_type", r13);     // Catch: JSONException -> L101
        goto L129
    L123:
        if (r13.length() != 0) goto L126;
    L153:
        r112.put("action_bar_key", r12);     // Catch: JSONException -> L101
        goto L103
    L97:
        r112 = null;
        goto L98
    L93:
        r22 = r45;
        goto L95
    L89:
        r111 = r44;
        goto L90
    L85:
        r110 = r43;
        goto L86
    L81:
        r21 = r42;
        goto L83
    L77:
        r20 = r41;
        goto L78
    L73:
        r19 = r40;
        goto L75
    L69:
        r18 = r39;
        goto L71
    L65:
        r17 = r38;
        goto L67
    L61:
        r2 = r37;
        goto L63
    L57:
        r15 = r36;
        goto L59
    L53:
        r14 = r35;
        goto L54
    L49:
        r13 = r34;
        goto L51
    L45:
        r12 = r33;
        goto L47
    L41:
        r11 = r32;
        goto L43
    L37:
        r10 = r31;
        goto L39
    L33:
        r9 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }

    public static void D(String r16, String r17, Long r18, Long r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, Boolean r41) {
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r35 != null) goto L71;
    L7:
        if (r37 == null) goto L9;
        r14.put("action_bar_item_id", r37);     // Catch: JSONException -> L5
    L9:
        if (r36 == null) goto L11;
        r14.put("action_bar_template_id", r36);     // Catch: JSONException -> L5
    L11:
        if (r38 == null) goto L13;
        r14.put("action_bar_key", r38);     // Catch: JSONException -> L5
    L13:
        if (r16 == null) goto L15;
        r14.put("bot_id", r16);     // Catch: JSONException -> L5
    L15:
        if (r17 == null) goto L17;
        r14.put("chat_type", r17);     // Catch: JSONException -> L5
    L17:
        if (r18 == null) goto L19;
        r14.put("click_position", r18.longValue());     // Catch: JSONException -> L5
    L19:
        if (r19 == null) goto L21;
        r14.put("conversation_id", r19.longValue());     // Catch: JSONException -> L5
    L21:
        if (r20 == null) goto L23;
        r14.put("current_page", r20);     // Catch: JSONException -> L5
    L23:
        r14.put("enter_chat_method", r21);     // Catch: JSONException -> L5
        r14.put("group_type", "private");     // Catch: JSONException -> L5
        if (r22 == null) goto L26;
        r14.put("message_id", r22);     // Catch: JSONException -> L5
    L26:
        if (r23 == null) goto L28;
        r14.put("previous_page", r23);     // Catch: JSONException -> L5
    L28:
        if (r24 == null) goto L31;
        r14.put("suggested_type", r24);     // Catch: JSONException -> L5
    L31:
        if (TextUtils.isEmpty(r25) == true) goto L34;
        r14.put("request_id", r25);     // Catch: JSONException -> L5
    L34:
        if (TextUtils.isEmpty(r26) == true) goto L37;
        r14.put("rs_request_id", r26);     // Catch: JSONException -> L5
    L37:
        if (TextUtils.isEmpty(r27) == true) goto L40;
        r14.put("recommend_botid", r27);     // Catch: JSONException -> L5
    L40:
        if (TextUtils.isEmpty(r28) == true) goto L43;
        r14.put("recommend_bot_1sttype", r28);     // Catch: JSONException -> L5
    L43:
        if (TextUtils.isEmpty(r29) == true) goto L46;
        r14.put("recommend_bot_2ndtype", r29);     // Catch: JSONException -> L5
    L46:
        if (TextUtils.isEmpty(r30) == true) goto L48;
        r14.put("recommend_bot_3rdtype", r30);     // Catch: JSONException -> L5
    L48:
        if (r31 == null) goto L50;
        r14.put("show_from", r31);     // Catch: JSONException -> L5
    L50:
        if (r32 == null) goto L52;
        r14.put("action_name", r32);     // Catch: JSONException -> L5
    L52:
        r14.put("section_id", r33);     // Catch: JSONException -> L5
        if (r34 == null) goto L56;
        r14.put("item_id", r34);     // Catch: JSONException -> L5
    L56:
        if (r39 == null) goto L58;
        r14.put("item_type", r39);     // Catch: JSONException -> L5
    L5:
        JSONException e = e;
        JSONObject r1 = r14;
    L68:
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickSuggestedPrompt " + e.getLocalizedMessage());
    L69:
        TrackParams r0 = new TrackParams().merge(r1);
        by7.a r2 = new by7.a("click_suggested_prompt");
        r2.a.merge(r0);
        r2.b();
        return;
    L58:
        r1 = r14;
        if (r40 == null) goto L62;
        r1.put("agent_id", r40);     // Catch: JSONException -> L67
    L67:
        e = e;
    L62:
        if (Intrinsics.areEqual(r41, Boolean.TRUE) == false) goto L64;
        String r3 = "1";
    L65:
        r1.put("is_stream", r3);     // Catch: JSONException -> L67
        goto L69
    L64:
        r3 = "0";
        goto L65
    L71:
        r14.put("suggest_action_type", r35);     // Catch: JSONException -> L5
        goto L7
    }

    public static void i(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, Boolean r18, Integer r19, Boolean r20, String r21, String r22, String r23, String r24, String r25, Boolean r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, Boolean r34, TraceFragment r35) {
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.put("enter_method", r10);     // Catch: JSONException -> L56
        r7.put("if_auto_filled", r11);     // Catch: JSONException -> L56
        r7.put("if_has_voice", r12);     // Catch: JSONException -> L56
        r7.put("if_system_prompt_added", r13);     // Catch: JSONException -> L56
        if (r14 == null) goto L6;
        r7.put("previous_page", r14);     // Catch: JSONException -> L56
    L6:
        r7.put("profile_photo_type", r15);     // Catch: JSONException -> L56
        r7.put("create_way", r16);     // Catch: JSONException -> L56
        if (r17 == null) goto L9;
        r7.put("creation_id", r17);     // Catch: JSONException -> L56
    L9:
        String r0 = "1";
        if (r18 != null) goto L12;
    L16:
        if (r19 == null) goto L18;
        r7.put("sp_cnt", r19.intValue());     // Catch: JSONException -> L56
    L18:
        if (r20 != null) goto L20;
    L24:
        if (r21 == null) goto L26;
        r7.put("voice_id", r21);     // Catch: JSONException -> L56
    L26:
        if (r22 == null) goto L28;
        r7.put("voice_type", r22);     // Catch: JSONException -> L56
    L28:
        r7.put("image_type", r23);     // Catch: JSONException -> L56
        if (r26 != null) goto L31;
    L35:
        if (r24 == null) goto L37;
        r7.put("speaker_id", r24);     // Catch: JSONException -> L56
    L37:
        if (r25 == null) goto L40;
        r7.put("speaker_name", r25);     // Catch: JSONException -> L56
    L40:
        if (com.larus.utils.o0.d(r31) == false) goto L43;
        r7.put("suggested_prompt_add_type", r31);     // Catch: JSONException -> L56
    L43:
        if (com.larus.utils.o0.d(r32) == false) goto L46;
        r7.put("bio_add_type", r32);     // Catch: JSONException -> L56
    L46:
        if (com.larus.utils.o0.d(r33) == false) goto L48;
        r7.put("onboarding_add_type", r33);     // Catch: JSONException -> L56
    L48:
        if (r34 != null) goto L50;
    L54:
        r7.putOpt("name_add_type", r27).putOpt("sp_add_type", r28).putOpt("profile_photo_add_type", r29).putOpt("voice_add_type", r30);     // Catch: JSONException -> L56
    L58:
        TrackParams r1 = new TrackParams().merge(r7);
        by7.a r2 = new by7.a("click_create_bot_auto_fill");
        if (r35 == null) goto L61;
        r2.b = r35;
    L61:
        r2.a.merge(r1);
        r2.b();
        return;
    L50:
        if (r34.booleanValue() == true) goto L53;
        r0 = "0";
    L53:
        r7.put("if_has_bio", r0);     // Catch: JSONException -> L56
        goto L54
    L31:
        if (r26.booleanValue() == false) goto L33;
        Object r3 = "1";
    L34:
        r7.put("background_status", r3);     // Catch: JSONException -> L56
        goto L35
    L33:
        r3 = "0";
        goto L34
    L20:
        if (r20.booleanValue() == false) goto L22;
        Object r8 = "1";
    L23:
        r7.put("sp_status", r8);     // Catch: JSONException -> L56
        goto L24
    L22:
        r8 = "0";
        goto L23
    L12:
        if (r18.booleanValue() == false) goto L14;
        Object r9 = "1";
    L15:
        r7.put("if_has_onboarding", r9);     // Catch: JSONException -> L56
        goto L16
    L14:
        r9 = "0";
    L56:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCreateBotAutoFill " + e.getLocalizedMessage());
        goto L58
    }

    public static void u(String r34, String r35, Long r36, Long r37, Long r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, Integer r50, String r51, String r52, String r53, String r54, JSONObject r55, Integer r56, by7.e r57, String r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, int r68, int r69) {
        if ((r68 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r68 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r68 & 8) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r68 & 16) == 0) goto L17;
        Long r5 = null;
    L19:
        if ((r68 & 32) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r68 & 64) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r68 & 512) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r68 & 1024) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r68 & 2048) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r68 & 4096) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r68 & 8192) == 0) goto L45;
        String r12 = null;
    L47:
        if ((32768 & r68) == 0) goto L49;
        String r13 = null;
    L51:
        if ((65536 & r68) == 0) goto L53;
        String r14 = null;
    L55:
        if ((131072 & r68) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r68 & 262144) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r68 & 524288) == 0) goto L65;
        String r18 = null;
    L67:
        if ((r68 & 1048576) == 0) goto L69;
        Integer r17 = null;
    L71:
        if ((r68 & 2097152) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r68 & 4194304) == 0) goto L77;
        String r21 = null;
    L79:
        if ((r68 & 8388608) == 0) goto L81;
        String r22 = null;
    L83:
        if ((r68 & 16777216) == 0) goto L85;
        String r23 = null;
    L87:
        if ((r68 & 33554432) == 0) goto L89;
        JSONObject r16 = new JSONObject();
    L91:
        if ((r68 & 67108864) == 0) goto L93;
        Integer r19 = null;
    L95:
        if ((r68 & 134217728) == 0) goto L97;
        by7.e r25 = null;
    L99:
        if ((r68 & 268435456) == 0) goto L101;
        String r26 = null;
    L103:
        if ((r68 & 536870912) == 0) goto L105;
        String r27 = null;
    L107:
        if ((r68 & 1073741824) == 0) goto L109;
        String r28 = null;
    L111:
        if ((r68 & Integer.MIN_VALUE) == 0) goto L113;
        String r0 = null;
    L115:
        if ((r69 & 1) == 0) goto L117;
        String r29 = null;
    L119:
        if ((r69 & 2) == 0) goto L121;
        String r30 = null;
    L123:
        if ((r69 & 4) == 0) goto L125;
        String r31 = null;
    L127:
        if ((r69 & 8) == 0) goto L129;
        String r32 = null;
    L130:
        String r310 = r0;
        if ((r69 & 16) == 0) goto L133;
        String r24 = null;
    L135:
        if ((r69 & 32) == 0) goto L137;
        String r33 = null;
    L138:
        Intrinsics.checkNotNullParameter(r16, "params");
        if (r24 != null) goto L225;
    L143:
        if (r1 == null) goto L145;
        r16.put("bot_id", r1);     // Catch: JSONException -> L141
    L145:
        if (r3 == null) goto L147;
        r16.put("chat_type", r3);     // Catch: JSONException -> L141
    L147:
        if (r4 == null) goto L149;
        r16.put("click_position", r4.longValue());     // Catch: JSONException -> L141
    L149:
        if (r5 == null) goto L151;
        r16.put("click_position_row", r5.longValue());     // Catch: JSONException -> L141
    L151:
        if (r6 == null) goto L153;
        r16.put("conversation_id", r6.longValue());     // Catch: JSONException -> L141
    L153:
        if (r7 == null) goto L155;
        r16.put("current_page", r7);     // Catch: JSONException -> L141
    L155:
        if (r8 == null) goto L157;
        r16.put("message_id", r8);     // Catch: JSONException -> L141
    L157:
        if (r9 == null) goto L159;
        r16.put("onboarding_content_source", r9);     // Catch: JSONException -> L141
    L159:
        if (r10 == null) goto L161;
        r16.put("onboarding_question", r10);     // Catch: JSONException -> L141
    L161:
        if (r11 == null) goto L163;
        r16.put("onboarding_type", r11);     // Catch: JSONException -> L141
    L163:
        if (r12 == null) goto L165;
        r16.put("previous_page", r12);     // Catch: JSONException -> L141
    L165:
        if (r13 == null) goto L167;
        r16.put("show_way", r13);     // Catch: JSONException -> L141
    L167:
        if (r14 == null) goto L169;
        r16.put("prompt_type", r14);     // Catch: JSONException -> L141
    L169:
        if (r15 == 0) goto L171;
        r16.put("prompt_subtype", r15);     // Catch: JSONException -> L141
    L171:
        if (r2 == 0) goto L173;
        r16.put("url", r2);     // Catch: JSONException -> L141
    L173:
        String r70 = r18;
        if (r70 == null) goto L176;
        r16.put("title", r70);     // Catch: JSONException -> L141
    L176:
        if (r17 == null) goto L178;
        r16.put("is_new_fuction", r17.intValue());     // Catch: JSONException -> L141
    L178:
        String r71 = r20;
        if (r71 == null) goto L181;
        r16.put("reco_request_id", r71);     // Catch: JSONException -> L141
    L181:
        String r72 = r21;
        if (r72 == null) goto L184;
        r16.put("item_id", r72);     // Catch: JSONException -> L141
    L184:
        String r73 = r28;
        if (r73 == null) goto L187;
        r16.put("template_id", r73);     // Catch: JSONException -> L141
    L187:
        String r74 = r22;
        if (r74 == null) goto L190;
        r16.put("item_type", r74);     // Catch: JSONException -> L141
    L190:
        String r75 = r23;
        if (r75 == null) goto L193;
        r16.put("section_id", r75);     // Catch: JSONException -> L141
    L193:
        if (r19 == null) goto L195;
        r16.put("type", r19.intValue());     // Catch: JSONException -> L141
    L195:
        String r76 = r27;
        if (r76 == null) goto L198;
        r16.put("prompt_from", r76);     // Catch: JSONException -> L141
    L198:
        if (r310 == null) goto L200;
        r16.put("action_bar_template_id", r310);     // Catch: JSONException -> L141
    L200:
        String r77 = r29;
        if (r77 == null) goto L203;
        r16.put("visual_size", r77);     // Catch: JSONException -> L141
    L203:
        String r78 = r30;
        if (r78 == null) goto L206;
        r16.put("click_type", r78);     // Catch: JSONException -> L141
    L206:
        String r79 = r31;
        if (r79 == null) goto L209;
        r16.put("tag_code", r79);     // Catch: JSONException -> L141
    L209:
        String r80 = r26;
        if (r80 == null) goto L212;
        r16.put("scheme", r80);     // Catch: JSONException -> L141
    L212:
        String r81 = r33;
        if (r81 == null) goto L215;
        r16.put("template_version", r81);     // Catch: JSONException -> L141
    L215:
        String r82 = r32;
        if (r82 == null) goto L220;
        r16.put("lottery_status", r82);     // Catch: JSONException -> L141
    L141:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickOnboardingCard " + e.getLocalizedMessage());
    L220:
        TrackParams r83 = new TrackParams().merge(r16);
        by7.a r84 = new by7.a("click_onboarding_card");
        by7.e r85 = r25;
        if (r85 == null) goto L223;
        r84.b = r85;
    L223:
        r84.a.merge(r83);
        r84.b();
        return;
    L225:
        r16.put("onboarding_action_type", r24);     // Catch: JSONException -> L141
        goto L143
    L137:
        r33 = r67;
        goto L138
    L133:
        r24 = r66;
        goto L135
    L129:
        r32 = r65;
        goto L130
    L125:
        r31 = r64;
        goto L127
    L121:
        r30 = r63;
        goto L123
    L117:
        r29 = r62;
        goto L119
    L113:
        r0 = r61;
        goto L115
    L109:
        r28 = r60;
        goto L111
    L105:
        r27 = r59;
        goto L107
    L101:
        r26 = r58;
        goto L103
    L97:
        r25 = r57;
        goto L99
    L93:
        r19 = r56;
        goto L95
    L89:
        r16 = r55;
        goto L91
    L85:
        r23 = r54;
        goto L87
    L81:
        r22 = r53;
        goto L83
    L77:
        r21 = r52;
        goto L79
    L73:
        r20 = r51;
        goto L75
    L69:
        r17 = r50;
        goto L71
    L65:
        r18 = r49;
        goto L67
    L61:
        r2 = r48;
        goto L63
    L57:
        r15 = r47;
        goto L59
    L53:
        r14 = r46;
        goto L55
    L49:
        r13 = r45;
        goto L51
    L45:
        r12 = r44;
        goto L47
    L41:
        r11 = r43;
        goto L43
    L37:
        r10 = r42;
        goto L39
    L33:
        r9 = r41;
        goto L35
    L29:
        r8 = r40;
        goto L31
    L25:
        r7 = r39;
        goto L27
    L21:
        r6 = r38;
        goto L23
    L17:
        r5 = r37;
        goto L19
    L13:
        r4 = r36;
        goto L15
    L9:
        r3 = r35;
        goto L11
    L5:
        r1 = r34;
        goto L7
    }

    public static void j(String r34, String r35, String r36, String r37, String r38, String r39, Boolean r40, Boolean r41, Boolean r42, Integer r43, Boolean r44, Boolean r45, Boolean r46, Boolean r47, String r48, String r49, Boolean r50, Boolean r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, Boolean r63, Integer r64, String r65, String r66, Boolean r67, Boolean r68, JSONObject r69, by7.e r70, int r71, int r72) {
        if ((r71 & 2) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r71 & 4) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r71 & 8) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r71 & 16) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r71 & 32) == 0) goto L21;
        Object r6 = null;
    L23:
        if ((r71 & 64) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r71 & 128) == 0) goto L29;
        Boolean r8 = null;
    L31:
        if ((r71 & 256) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r71 & 512) == 0) goto L37;
        Boolean r10 = null;
    L39:
        if ((r71 & 1024) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r71 & 2048) == 0) goto L45;
        Boolean r12 = null;
    L47:
        if ((r71 & 4096) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r71 & 8192) == 0) goto L53;
        Boolean r14 = null;
    L55:
        if ((r71 & 16384) == 0) goto L57;
        Boolean r15 = null;
    L59:
        if ((r71 & 32768) == 0) goto L61;
        Object r2 = null;
    L62:
        Boolean r310 = r9;
        if ((r71 & 65536) == 0) goto L65;
        Object r16 = null;
    L67:
        if ((r71 & 131072) == 0) goto L69;
        Boolean r17 = null;
    L71:
        if ((r71 & 262144) == 0) goto L73;
        Boolean r18 = null;
    L75:
        if ((r71 & 524288) == 0) goto L77;
        Object r20 = null;
    L79:
        if ((r71 & 1048576) == 0) goto L81;
        Object r21 = null;
    L83:
        if ((r71 & 2097152) == 0) goto L85;
        Object r22 = null;
    L87:
        if ((r71 & 4194304) == 0) goto L89;
        Object r23 = null;
    L91:
        if ((r71 & 8388608) == 0) goto L93;
        Object r24 = null;
    L95:
        if ((r71 & 16777216) == 0) goto L97;
        Object r25 = null;
    L99:
        if ((r71 & 33554432) == 0) goto L101;
        Object r26 = null;
    L103:
        if ((r71 & 67108864) == 0) goto L105;
        Object r27 = null;
    L107:
        if ((r71 & 134217728) == 0) goto L109;
        String r311 = null;
    L111:
        if ((r71 & 268435456) == 0) goto L113;
        String r312 = null;
    L115:
        if ((r71 & 536870912) == 0) goto L117;
        String r313 = null;
    L119:
        if ((r71 & 1073741824) == 0) goto L121;
        Boolean r19 = null;
    L123:
        if ((r71 & Integer.MIN_VALUE) == 0) goto L125;
        Integer r0 = null;
    L127:
        if ((r72 & 1) == 0) goto L129;
        Object r29 = null;
    L131:
        if ((r72 & 2) == 0) goto L133;
        Object r30 = null;
    L135:
        if ((r72 & 4) == 0) goto L137;
        Boolean r28 = null;
    L139:
        if ((r72 & 8) == 0) goto L141;
        Boolean r31 = null;
    L143:
        if ((r72 & 16) == 0) goto L145;
        JSONObject r32 = new JSONObject();
    L147:
        if ((r72 & 32) == 0) goto L149;
        by7.e r33 = null;
    L150:
        Intrinsics.checkNotNullParameter(r32, "params");
        if (r1 != null) goto L284;
    L155:
        if (r4 == null) goto L157;
        r32.put("previous_page", r4);     // Catch: JSONException -> L153
    L157:
        if (r3 == null) goto L159;
        r32.put("creation_id", r3);     // Catch: JSONException -> L153
    L159:
        if (r5 == null) goto L161;
        r32.put("create_way", r5);     // Catch: JSONException -> L153
    L161:
        if (r6 == null) goto L163;
        r32.put("from_activity_name", r6);     // Catch: JSONException -> L153
    L163:
        if (r7 == null) goto L165;
        r32.put("from_activity_module", r7);     // Catch: JSONException -> L153
    L165:
        String r73 = "0";
        if (r8 != null) goto L168;
    L172:
        if (r10 != null) goto L174;
    L178:
        if (r11 == null) goto L180;
        r32.put("sp_cnt", r11.intValue());     // Catch: JSONException -> L153
    L180:
        if (r12 != null) goto L182;
    L186:
        if (r13 != null) goto L188;
    L192:
        if (r14 != null) goto L194;
    L198:
        if (r15 != null) goto L200;
    L204:
        if (r2 == null) goto L206;
        r32.put("profile_photo_type", r2);     // Catch: JSONException -> L153
    L206:
        if (r16 == 0) goto L208;
        r32.put("image_type", r16);     // Catch: JSONException -> L153
    L208:
        if (r17 != null) goto L210;
    L214:
        if (r18 != null) goto L216;
    L220:
        Object r74 = r20;
        if (r74 == null) goto L223;
        r32.put("voice_id", r74);     // Catch: JSONException -> L153
    L223:
        Object r75 = r21;
        if (r75 == null) goto L226;
        r32.put("voice_type", r75);     // Catch: JSONException -> L153
    L226:
        Object r76 = r22;
        if (r76 == null) goto L229;
        r32.put("speaker_id", r76);     // Catch: JSONException -> L153
    L229:
        Object r77 = r23;
        if (r77 == null) goto L233;
        r32.put("speaker_name", r77);     // Catch: JSONException -> L153
    L233:
        if (com.larus.utils.o0.d(r311) == false) goto L236;
        r32.put("suggested_prompt_add_type", r311);     // Catch: JSONException -> L153
    L236:
        if (com.larus.utils.o0.d(r312) == false) goto L239;
        r32.put("bio_add_type", r312);     // Catch: JSONException -> L153
    L239:
        if (com.larus.utils.o0.d(r313) == false) goto L241;
        r32.put("onboarding_add_type", r313);     // Catch: JSONException -> L153
    L241:
        if (r310 != null) goto L243;
    L247:
        if (r19 != null) goto L249;
    L253:
        if (r0 == 0) goto L255;
        r32.put("polish_cnt", String.valueOf(r0.intValue()));     // Catch: JSONException -> L153
    L255:
        Object r78 = r29;
        if (r78 == null) goto L258;
        r32.put("polish_status", r78);     // Catch: JSONException -> L153
    L258:
        Object r79 = r30;
        if (r79 == null) goto L261;
        r32.put("private_status", r79);     // Catch: JSONException -> L153
    L261:
        if (r28 == null) goto L269;
        boolean r80 = r28.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r78, "1") == false) goto L269;
        if (r80 == false) goto L267;
        Object r81 = "1";
    L268:
        r32.put("if_polish_use_internet", r81);     // Catch: JSONException -> L153
        goto L269
    L267:
        r81 = "0";
    L269:
        if (r31 == null) goto L276;
        boolean r82 = r31.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L276;
        if (r82 == false) goto L275;
        r73 = "1";
    L275:
        r32.put("if_auto_fill_use_internet", r73);     // Catch: JSONException -> L153
    L276:
        r32.putOpt("name_add_type", r24).putOpt("sp_add_type", r25).putOpt("profile_photo_add_type", r26).putOpt("voice_add_type", r27);     // Catch: JSONException -> L153
    L279:
        TrackParams r83 = new TrackParams().merge(r32);
        by7.a r84 = new by7.a("click_create_bot_complete");
        by7.e r85 = r33;
        if (r85 == null) goto L282;
        r84.b = r85;
    L282:
        r84.a.merge(r83);
        r84.b();
        return;
    L153:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper clickCreateBotAutoFill " + e.getLocalizedMessage());
        goto L279
    L249:
        if (r19.booleanValue() == false) goto L251;
        Object r86 = "1";
    L252:
        r32.put("if_polish", r86);     // Catch: JSONException -> L153
        goto L253
    L251:
        r86 = "0";
        goto L252
    L243:
        if (r310.booleanValue() == false) goto L245;
        Object r87 = "1";
    L246:
        r32.put("if_has_bio", r87);     // Catch: JSONException -> L153
        goto L247
    L245:
        r87 = "0";
        goto L246
    L216:
        if (r18.booleanValue() == false) goto L218;
        Object r88 = "1";
    L219:
        r32.put("if_system_prompt_added", r88);     // Catch: JSONException -> L153
        goto L220
    L218:
        r88 = "0";
        goto L219
    L210:
        if (r17.booleanValue() == false) goto L212;
        Object r89 = "1";
    L213:
        r32.put("background_status", r89);     // Catch: JSONException -> L153
        goto L214
    L212:
        r89 = "0";
        goto L213
    L200:
        if (r15.booleanValue() == false) goto L202;
        Object r90 = "1";
    L203:
        r32.put("is_edited", r90);     // Catch: JSONException -> L153
        goto L204
    L202:
        r90 = "0";
        goto L203
    L194:
        if (r14.booleanValue() == false) goto L196;
        Object r91 = "1";
    L197:
        r32.put("if_allow_search", r91);     // Catch: JSONException -> L153
        goto L198
    L196:
        r91 = "0";
        goto L197
    L188:
        if (r13.booleanValue() == false) goto L190;
        Object r92 = "1";
    L191:
        r32.put("if_generate_picture", r92);     // Catch: JSONException -> L153
        goto L192
    L190:
        r92 = "0";
        goto L191
    L182:
        if (r12.booleanValue() == false) goto L184;
        Object r93 = "1";
    L185:
        r32.put("sp_status", r93);     // Catch: JSONException -> L153
        goto L186
    L184:
        r93 = "0";
        goto L185
    L174:
        if (r10.booleanValue() == false) goto L176;
        Object r94 = "1";
    L177:
        r32.put("if_has_onboarding", r94);     // Catch: JSONException -> L153
        goto L178
    L176:
        r94 = "0";
        goto L177
    L168:
        if (r8.booleanValue() == false) goto L170;
        Object r95 = "1";
    L171:
        r32.put("if_auto_filled", r95);     // Catch: JSONException -> L153
        goto L172
    L170:
        r95 = "0";
        goto L171
    L284:
        r32.put("enter_method", r1);     // Catch: JSONException -> L153
        goto L155
    L149:
        r33 = r70;
        goto L150
    L145:
        r32 = r69;
        goto L147
    L141:
        r31 = r68;
        goto L143
    L137:
        r28 = r67;
        goto L139
    L133:
        r30 = r66;
        goto L135
    L129:
        r29 = r65;
        goto L131
    L125:
        r0 = r64;
        goto L127
    L121:
        r19 = r63;
        goto L123
    L117:
        r313 = r62;
        goto L119
    L113:
        r312 = r61;
        goto L115
    L109:
        r311 = r60;
        goto L111
    L105:
        r27 = r59;
        goto L107
    L101:
        r26 = r58;
        goto L103
    L97:
        r25 = r57;
        goto L99
    L93:
        r24 = r56;
        goto L95
    L89:
        r23 = r55;
        goto L91
    L85:
        r22 = r54;
        goto L87
    L81:
        r21 = r53;
        goto L83
    L77:
        r20 = r52;
        goto L79
    L73:
        r18 = r51;
        goto L75
    L69:
        r17 = r50;
        goto L71
    L65:
        r16 = r49;
        goto L67
    L61:
        r2 = r48;
        goto L62
    L57:
        r15 = r47;
        goto L59
    L53:
        r14 = r46;
        goto L55
    L49:
        r13 = r45;
        goto L51
    L45:
        r12 = r44;
        goto L47
    L41:
        r11 = r43;
        goto L43
    L37:
        r10 = r42;
        goto L39
    L33:
        r9 = r41;
        goto L35
    L29:
        r8 = r40;
        goto L31
    L25:
        r7 = r39;
        goto L27
    L21:
        r6 = r38;
        goto L23
    L17:
        r5 = r37;
        goto L19
    L13:
        r4 = r36;
        goto L15
    L9:
        r3 = r35;
        goto L11
    L5:
        r1 = r34;
        goto L7
    }
}
