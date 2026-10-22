package tx9;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p3 {
    public static final void a(String r1, JSONObject r2, by7.e r3) {
        by7.a r0 = new by7.a(r1);
        if (r3 == null) goto L5;
        r0.b = r3;
    L5:
        TrackParams r4 = new TrackParams().merge(r2);
        r0.a.merge(r4);
        r0.b();
    }

    public static void d(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter("archive_project_confirm", "popupType");
        Intrinsics.checkNotNullParameter(r5, "buttonName");
        Intrinsics.checkNotNullParameter(r6, "projectId");
        if (Intrinsics.areEqual("archive_project_confirm", "archive_project_confirm") == false) goto L5;
        String r0 = "archive_project_confirm_popup_click";
    L6:
        JSONObject r2 = new JSONObject();
        if (r4 == null) goto L9;
        r2.put("current_page", r4);
    L9:
        r2.put("popup_type", "archive_project_confirm");
        r2.put("button_name", r5);
        r2.put("project_id", r6);
        a(r0, r2, null);
        return;
    L5:
        r0 = "popup_click";
        goto L6
    }

    public static /* synthetic */ void c(String r10, String r11, String r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r14 & 16) == 0) goto L9;
        String r6 = null;
    L10:
        b(r2, r11, null, null, r6, null, r13, null);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r2 = r10;
        goto L7
    }

    public static void i(String r3, String r4, String r5, String r6, by7.e r7) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "projectId");
        Intrinsics.checkNotNullParameter(r6, "moveResult");
        Intrinsics.checkNotNullParameter("long_press_panel", "moveMethod");
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L5;
        r0.put("current_page", r3);
    L5:
        r0.put("conversation_id", r4);
        if (r5.length() != 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        r5 = "-";
    L11:
        r0.put("project_id", r5);
        r0.put("move_result", r6);
        r0.put("move_method", "long_press_panel");
        a("move_chat_to_project", r0, r7);
        return;
    L8:
        r8 = false;
        goto L9
    }

    public static void e(String r3, String r4, String r5, String r6, by7.e r7, int r8) {
        String r1 = null;
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r4, "popupType");
        if (Intrinsics.areEqual(r4, "archive_chat_toast") == false) goto L18;
        String r9 = "archive_chat_toast_show";
    L21:
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L24;
        r0.put("current_page", r3);
    L24:
        r0.put("popup_type", r4);
        boolean r10 = false;
        if (r5 != null) goto L27;
    L35:
        if (r6 != null) goto L37;
    L43:
        a(r9, r0, r7);
        return;
    L37:
        if (r6.length() <= 0) goto L39;
        r10 = true;
    L39:
        if (r10 == false) goto L41;
        r1 = r6;
    L41:
        if (r1 == null) goto L43;
        r0.put("project_id", r1);
        goto L43
    L27:
        if (r5.length() <= 0) goto L29;
        boolean r2 = true;
    L30:
        if (r2 == true) goto L33;
        r5 = null;
    L33:
        if (r5 == null) goto L35;
        r0.put("conversation_id", r5);
        goto L35
    L29:
        r2 = false;
        goto L30
    L18:
        if (Intrinsics.areEqual(r4, "archive_project_confirm") == false) goto L20;
        r9 = "archive_project_confirm_popup_show";
        goto L21
    L20:
        r9 = "popup_show";
        goto L21
    }

    public static void f(String r4, String r5, String r6, String r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r6 = null;
    L9:
        if ((r9 & 8) == 0) goto L11;
        r7 = null;
    L11:
        Intrinsics.checkNotNullParameter(r5, "collapseType");
        JSONObject r10 = new JSONObject();
        if (r4 == null) goto L14;
        r10.put("current_page", r4);
    L14:
        boolean r11 = false;
        String r2 = "-";
        if (r6 != null) goto L17;
    L24:
        r6 = "-";
    L25:
        r10.put("tab_name", r6);
        if (r7 != null) goto L28;
    L36:
        r10.put("project_id", r2);
        r10.put("collapse_type", r5);
        r10.put("is_collapse", r8);
        a("collapse_group", r10, null);
        return;
    L28:
        if (r7.length() <= 0) goto L30;
        r11 = true;
    L30:
        if (r11 == true) goto L33;
        r7 = null;
    L33:
        if (r7 == null) goto L36;
        r2 = r7;
        goto L36
    L17:
        if (r6.length() <= 0) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == true) goto L23;
        r6 = null;
    L23:
        if (r6 != null) goto L25;
    L19:
        r3 = false;
        goto L20
    }

    public static void g(String r2, String r3, boolean r4, String r5, by7.e r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r5, "createResult");
        JSONObject r8 = new JSONObject();
        if (r2 == null) goto L14;
        r8.put("current_page", r2);
    L14:
        if (r3 == null) goto L16;
        r8.put("enter_method", r3);
    L16:
        r8.put("is_bind_folder", r4);
        r8.put("create_result", r5);
        a("create_project", r8, r6);
    }

    public static void h(String r2, String r3, String r4, String r5, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 16) == 0) goto L14;
        r6 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "settingType");
        JSONObject r8 = new JSONObject();
        if (r2 == null) goto L17;
        r8.put("current_page", r2);
    L17:
        r8.put("setting_type", r3);
        if (r4 != null) goto L20;
        r4 = "-";
    L20:
        r8.put("group_by", r4);
        if (r5 != null) goto L23;
        r5 = "-";
    L23:
        r8.put("sort_type", r5);
        if (r6 == null) goto L26;
        r8.put("to_status", r6);
    L26:
        a("group_panel_click", r8, null);
    }

    public static final void j(String r5, String r6, String r7, String r8, String r9, by7.e r10) {
        Intrinsics.checkNotNullParameter("chat", "objectType");
        Intrinsics.checkNotNullParameter(r9, "clickFrom");
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L5;
        r0.put("current_page", r5);
    L5:
        r0.put("object_type", "chat");
        boolean r11 = false;
        String r3 = "-";
        if (r6 != null) goto L8;
    L15:
        r6 = "-";
    L16:
        r0.put("conversation_id", r6);
        if (r7 != null) goto L19;
    L26:
        r7 = "-";
    L27:
        r0.put("bot_id", r7);
        if (r8 != null) goto L30;
    L38:
        r0.put("project_id", r3);
        r0.put("click_from", r9);
        a("unarchive_chat", r0, r10);
        return;
    L30:
        if (r8.length() <= 0) goto L32;
        r11 = true;
    L32:
        if (r11 == true) goto L35;
        r8 = null;
    L35:
        if (r8 == null) goto L38;
        r3 = r8;
        goto L38
    L19:
        if (r7.length() <= 0) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == true) goto L25;
        r7 = null;
    L25:
        if (r7 != null) goto L27;
    L21:
        r12 = false;
        goto L22
    L8:
        if (r6.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r6 = null;
    L14:
        if (r6 != null) goto L16;
    L10:
        r4 = false;
        goto L11
    }

    public static final void b(String r4, String r5, String r6, String r7, String r8, String r9, String r10, by7.e r11) {
        Intrinsics.checkNotNullParameter(r5, "objectType");
        Intrinsics.checkNotNullParameter(r10, "clickFrom");
        JSONObject r0 = new JSONObject();
        if (r4 == null) goto L5;
        r0.put("current_page", r4);
    L5:
        r0.put("object_type", r5);
        boolean r12 = false;
        String r2 = "-";
        if (r6 != null) goto L8;
    L15:
        r6 = "-";
    L16:
        r0.put("conversation_id", r6);
        if (r7 != null) goto L19;
    L26:
        r7 = "-";
    L27:
        r0.put("bot_id", r7);
        if (r8 != null) goto L30;
    L37:
        r8 = "-";
    L38:
        r0.put("project_id", r8);
        if (r9 != null) goto L41;
    L49:
        r0.put("chat_type", r2);
        r0.put("click_from", r10);
        a("archive_chat", r0, r11);
        return;
    L41:
        if (r9.length() <= 0) goto L43;
        r12 = true;
    L43:
        if (r12 == true) goto L46;
        r9 = null;
    L46:
        if (r9 == null) goto L49;
        r2 = r9;
        goto L49
    L30:
        if (r8.length() <= 0) goto L32;
        boolean r13 = true;
    L33:
        if (r13 == true) goto L36;
        r8 = null;
    L36:
        if (r8 != null) goto L38;
    L32:
        r13 = false;
        goto L33
    L19:
        if (r7.length() <= 0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == true) goto L25;
        r7 = null;
    L25:
        if (r7 != null) goto L27;
    L21:
        r14 = false;
        goto L22
    L8:
        if (r6.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r6 = null;
    L14:
        if (r6 != null) goto L16;
    L10:
        r3 = false;
        goto L11
    }
}
