package m39;

import com.ixigua.lib.track.TrackParams;
import com.larus.doc.api.IDocService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static String a;
    public static String b;
    public static Integer c;
    public static String d;
    public static String e;
    public static boolean f;
    public static String g;

    public a() {
    }

    static {
        d = "";
    }

    public static /* synthetic */ void b(String r1, String r2, JSONObject r3) {
        a(r1, "", r2, r3);
    }

    public static /* synthetic */ void d(String r1, String r2, JSONObject r3) {
        c(r1, "", r2, r3);
    }

    public static void e(String r8, String r9, String r10) {
        if (Intrinsics.areEqual(a, g) == false) goto L5;
        return;
    L5:
        String r0 = e;
        if (r0 != null) goto L8;
    L42:
        String r1 = null;
    L43:
        if (r1 == null) goto L69;
        String r2 = a;
        g = r2;
        String r3 = e;
        Integer r4 = c;
        String r5 = b;
        Integer r6 = Integer.valueOf(IDocService.a.K9());
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "params");
        if (r3 != null) goto L67;
    L47:
        r7.put("create_way", r1);     // Catch: JSONException -> L63
        if (r6 == null) goto L50;
        r7.put("is_deep_thinking_switch_on", r6.intValue());     // Catch: JSONException -> L63
    L50:
        if (r2 == null) goto L52;
        r7.put("page_token", r2);     // Catch: JSONException -> L63
    L52:
        if (r5 == null) goto L54;
        r7.put("artifact_meta_id", r5);     // Catch: JSONException -> L63
    L54:
        if (r4 == null) goto L56;
        r7.put("resource_type", r4.intValue());     // Catch: JSONException -> L63
    L56:
        if (r8 == null) goto L58;
        r7.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r8);     // Catch: JSONException -> L63
    L58:
        if (r9 == null) goto L60;
        r7.put("current_page", r9);     // Catch: JSONException -> L63
    L60:
        if (r10 == null) goto L65;
        r7.put("meeting_record_message_create_platform", r10);     // Catch: JSONException -> L63
    L63:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobCreateAiDoc: " + e.getLocalizedMessage());
    L65:
        TrackParams r11 = new TrackParams().merge(r7);
        by7.a r12 = new by7.a("create_ai_doc");
        r12.a.merge(r11);
        r12.b();
        return;
    L67:
        r7.put("click_from", r3);     // Catch: JSONException -> L63
        goto L47
    L69:
        return;
    L8:
        switch(r0.hashCode()) {
            case -2076524031: goto L39;
            case -1248423846: goto L36;
            case -793435082: goto L32;
            case -730520822: goto L29;
            case -476376399: goto L26;
            case 463237240: goto L23;
            case 759707860: goto L20;
            case 808416715: goto L17;
            case 991866259: goto L14;
            case 1673246730: goto L11;
            default: goto L42;
        };
    L11:
        if (r0.equals("click_answer_action_button_create") == false) goto L42;
    L30:
        r1 = "chat_response";
        goto L43
    L14:
        if (r0.equals("long_press_message_create") == true) goto L30;
    L17:
        if (r0.equals("send_message_create") == false) goto L42;
    L34:
        r1 = "send_message";
        goto L43
    L20:
        if (r0.equals("answer_manual_create") == true) goto L34;
    L23:
        if (r0.equals("ai_doc_card_download_button") == true) goto L34;
    L26:
        if (r0.equals("ai_doc_list_blank_file_create") == false) goto L42;
    L41:
        r1 = "blank_file";
        goto L43
    L29:
        if (r0.equals("long_press_meeting_record_create_button") == false) goto L42;
    L32:
        if (r0.equals("ai_doc_card_edit_button") == true) goto L34;
    L36:
        if (r0.equals("ai_space_create_blank_doc") == true) goto L41;
    L39:
        if (r0.equals("ai_doc_list_speak_input_create") == true) goto L41;
        goto L41
    }

    public static void a(String r12, String r13, String r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r15, "extParams");
        u0.h(false, "ai_doc_detail", c, "ai_doc", a, b, r12, r13, r14, r15, 1536);
    }

    public static void c(String r12, String r13, String r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r15, "params");
        u0.h(true, "ai_doc_detail", c, "ai_doc", a, b, r12, r13, r14, r15, 1536);
    }
}
