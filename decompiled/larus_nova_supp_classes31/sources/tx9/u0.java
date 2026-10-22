package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u0 {
    public static void b(String r3, by7.e r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        JSONObject r0 = new JSONObject();
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        Intrinsics.checkNotNullParameter(r3, "failReason");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("fail_reason", r3);     // Catch: JSONException -> L12
    L14:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("doc_offline_id_not_synced");
        if (r4 == null) goto L17;
        r7.b = r4;
    L17:
        r7.a.merge(r6);
        r7.b();
        return;
    L12:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobDocOfflineIdNotSynced: " + e.getLocalizedMessage());
        goto L14
    L5:
        r0 = null;
        goto L7
    }

    public static void i(boolean r2, String r3, String r4, Integer r5, String r6, by7.e r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L24;
    L7:
        if (r4 == null) goto L9;
        r0.put("artifact_meta_id", r4);     // Catch: JSONException -> L5
    L9:
        if (r5 == null) goto L11;
        r0.put("resource_type", r5.intValue());     // Catch: JSONException -> L5
    L11:
        if (r6 == null) goto L15;
        r0.put("current_page", r6);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobSecurityReviewRejected: " + e.getLocalizedMessage());
    L15:
        TrackParams r8 = new TrackParams().merge(r0);
        if (r2 == false) goto L18;
        String r9 = "doc_security_review_rejected_click";
    L19:
        by7.a r10 = new by7.a(r9);
        if (r7 == null) goto L22;
        r10.b = r7;
    L22:
        r10.a.merge(r8);
        r10.b();
        return;
    L18:
        r9 = "doc_security_review_rejected_show";
        goto L19
    L24:
        r0.put("page_token", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r2, boolean r3, Boolean r4, Boolean r5, Boolean r6, Boolean r7, by7.e r8) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "failReason");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("fail_reason", r2);     // Catch: JSONException -> L13
        r0.put("has_offline_doc_created", r3);     // Catch: JSONException -> L13
        if (r4 == null) goto L6;
        r0.put("is_compensate_create", r4.booleanValue());     // Catch: JSONException -> L13
    L6:
        if (r5 == null) goto L8;
        r0.put("has_real_token", r5.booleanValue());     // Catch: JSONException -> L13
    L8:
        if (r6 == null) goto L10;
        r0.put("has_user_changes", r6.booleanValue());     // Catch: JSONException -> L13
    L10:
        if (r7 == null) goto L15;
        r0.put("has_frontend_linked", r7.booleanValue());     // Catch: JSONException -> L13
    L15:
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("doc_offline_compensate_create");
        if (r8 == null) goto L18;
        r10.b = r8;
    L18:
        r10.a.merge(r9);
        r10.b();
        return;
    L13:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobDocOfflineCompensateCreate: " + e.getLocalizedMessage());
        goto L15
    }

    public static void c(String r2, String r3, String r4, Long r5, String r6, Integer r7, JSONObject r8, int r9) {
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
        if ((r9 & 64) == 0) goto L23;
        r8 = new JSONObject();
    L23:
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r3 != null) goto L42;
    L28:
        if (r2 == null) goto L30;
        r8.put("success", r2);     // Catch: JSONException -> L26
    L30:
        if (r4 == null) goto L32;
        r8.put("export_type", r4);     // Catch: JSONException -> L26
    L32:
        if (r5 == null) goto L34;
        r8.put("duration", r5.longValue());     // Catch: JSONException -> L26
    L34:
        if (r7 == null) goto L36;
        r8.put("resource_type", r7.intValue());     // Catch: JSONException -> L26
    L36:
        if (r6 == null) goto L40;
        r8.put("error_msg", r6);     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionStatus: " + e.getLocalizedMessage());
    L40:
        TrackParams r10 = new TrackParams().merge(r8);
        by7.a r11 = new by7.a("doc_export_result");
        r11.a.merge(r10);
        r11.b();
        return;
    L42:
        r8.put("page_token", r3);     // Catch: JSONException -> L26
        goto L28
    }

    public static void f(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, String r9, JSONObject r10, by7.e r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = new JSONObject();
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = null;
    L32:
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r2 != null) goto L58;
    L37:
        if (r5 == null) goto L39;
        r10.put("button_name", r5);     // Catch: JSONException -> L35
    L39:
        if (r6 == null) goto L41;
        r10.put("page_token", r6);     // Catch: JSONException -> L35
    L41:
        if (r7 == null) goto L43;
        r10.put("artifact_meta_id", r7);     // Catch: JSONException -> L35
    L43:
        if (r8 == null) goto L45;
        r10.put("resource_type", r8.intValue());     // Catch: JSONException -> L35
    L45:
        if (r9 == null) goto L47;
        r10.put("current_page", r9);     // Catch: JSONException -> L35
    L47:
        if (r3 == null) goto L49;
        r10.put("success", r3);     // Catch: JSONException -> L35
    L49:
        if (r4 == null) goto L53;
        r10.put("error_code", r4);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionStatus: " + e.getLocalizedMessage());
    L53:
        TrackParams r13 = new TrackParams().merge(r10);
        by7.a r14 = new by7.a("file_function_status");
        if (r11 == null) goto L56;
        r14.b = r11;
    L56:
        r14.a.merge(r13);
        r14.b();
        return;
    L58:
        r10.put("show_from", r2);     // Catch: JSONException -> L35
        goto L37
    }

    public static /* synthetic */ void h(boolean r15, String r16, Integer r17, String r18, String r19, String r20, String r21, String r22, String r23, JSONObject r24, int r25) {
        if ((r25 & 2) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r25 & 4) == 0) goto L9;
        Integer r5 = null;
    L11:
        if ((r25 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r25 & 16) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r25 & 32) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r25 & 64) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r25 & 128) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r25 & 256) == 0) goto L33;
        String r11 = null;
    L35:
        if ((r25 & 2048) == 0) goto L37;
        JSONObject r14 = new JSONObject();
    L38:
        g(r15, r4, r5, r6, r7, r8, r9, r10, r11, null, null, r14);
        return;
    L37:
        r14 = r24;
        goto L38
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public static final void g(boolean r3, String r4, Integer r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r4 != null) goto L61;
    L7:
        if (r5 == null) goto L9;
        r14.put("resource_type", r5.intValue());     // Catch: JSONException -> L5
    L9:
        if (r6 == null) goto L11;
        r14.put("canvas_type", r6);     // Catch: JSONException -> L5
    L11:
        if (r7 == null) goto L13;
        r14.put("page_token", r7);     // Catch: JSONException -> L5
    L13:
        if (r8 == null) goto L15;
        r14.put("artifact_meta_id", r8);     // Catch: JSONException -> L5
    L15:
        if (r9 == null) goto L17;
        r14.put("button_name_level_one", r9);     // Catch: JSONException -> L5
    L17:
        if (r11 == null) goto L19;
        r14.put("enter_method", r11);     // Catch: JSONException -> L5
    L19:
        if (r10 == null) goto L21;
        r14.put("button_name_level_two", r10);     // Catch: JSONException -> L5
    L21:
        String r15 = r14.optString("is_general_agent");     // Catch: JSONException -> L5
        Intrinsics.checkNotNull(r15);     // Catch: JSONException -> L5
        boolean r16 = false;
        if (r15.length() <= 0) goto L24;
        boolean r17 = true;
    L25:
        String r18 = null;
        if (r17 == true) goto L29;
        r15 = null;
    L29:
        if (r15 != null) goto L43;
        if (r12 != null) goto L32;
    L35:
        boolean r19 = true;
    L37:
        if ((!r19) == true) goto L40;
        r12 = null;
    L40:
        if (r12 != null) goto L42;
        r15 = "0";
        goto L43
    L42:
        r15 = r12;
        goto L43
    L32:
        if (r12.length() == 0) goto L35;
        r19 = false;
    L43:
        String r20 = r14.optString("chat_id");     // Catch: JSONException -> L5
        Intrinsics.checkNotNull(r20);     // Catch: JSONException -> L5
        if (r20.length() <= 0) goto L46;
        r16 = true;
    L46:
        if (r16 == false) goto L48;
        r18 = r20;
    L48:
        if (r18 != null) goto L51;
        if (r13 != null) goto L52;
        r13 = "";
    L52:
        r14.put("is_general_agent", r15);     // Catch: JSONException -> L5
        r14.put("chat_id", r13);     // Catch: JSONException -> L5
    L55:
        TrackParams r21 = new TrackParams().merge(r14);
        if (r3 == false) goto L58;
        String r22 = "output_preview_tool_show";
    L59:
        by7.a r23 = new by7.a(r22);
        r23.a.merge(r21);
        r23.b();
        return;
    L58:
        r22 = "output_preview_tool_click";
    L5:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper reportOutputPreviewToolShow: " + e.getLocalizedMessage());
        goto L55
    L51:
        r13 = r18;
        goto L52
    L24:
        r17 = false;
        goto L25
    L61:
        r14.put("current_page", r4);     // Catch: JSONException -> L5
        goto L7
    }

    public static void e(String r2, String r3, String r4, Integer r5, String r6, String r7, String r8, String r9, String r10, String r11, JSONObject r12, by7.e r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r14 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r14 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r14 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r14 & 1024) == 0) goto L36;
        r12 = new JSONObject();
    L36:
        if ((r14 & 2048) == 0) goto L38;
        r13 = null;
    L38:
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r2 != null) goto L68;
    L43:
        if (r3 == null) goto L45;
        r12.put("page_token", r3);     // Catch: JSONException -> L41
    L45:
        if (r4 == null) goto L47;
        r12.put("artifact_meta_id", r4);     // Catch: JSONException -> L41
    L47:
        if (r5 == null) goto L49;
        r12.put("resource_type", r5.intValue());     // Catch: JSONException -> L41
    L49:
        if (r6 == null) goto L51;
        r12.put("current_page", r6);     // Catch: JSONException -> L41
    L51:
        if (r7 == null) goto L53;
        r12.put("previous_page", r7);     // Catch: JSONException -> L41
    L53:
        if (r8 == null) goto L55;
        r12.put("collection_id", r8);     // Catch: JSONException -> L41
    L55:
        if (r9 == null) goto L57;
        r12.put("collection_name", r9);     // Catch: JSONException -> L41
    L57:
        if (r10 == null) goto L59;
        r12.put("content_type", r10);     // Catch: JSONException -> L41
    L59:
        if (r11 == null) goto L63;
        r12.put("content_sec_type", r11);     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionShow: " + e.getLocalizedMessage());
    L63:
        TrackParams r15 = new TrackParams().merge(r12);
        by7.a r16 = new by7.a("file_function_show");
        if (r13 == null) goto L66;
        r16.b = r13;
    L66:
        r16.a.merge(r15);
        r16.b();
        return;
    L68:
        r12.put("show_from", r2);     // Catch: JSONException -> L41
        goto L43
    }

    public static void d(String r15, String r16, String r17, String r18, Integer r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, JSONObject r27, by7.e r28, int r29) {
        by7.e r2 = null;
        if ((r29 & 1) == 0) goto L5;
        Object r1 = null;
    L7:
        if ((r29 & 2) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r29 & 4) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r29 & 8) == 0) goto L17;
        Object r5 = null;
    L19:
        if ((r29 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r29 & 32) == 0) goto L25;
        Object r7 = null;
    L27:
        if ((r29 & 64) == 0) goto L29;
        Object r8 = null;
    L31:
        if ((r29 & 128) == 0) goto L33;
        Object r9 = null;
    L35:
        if ((r29 & 256) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r29 & 512) == 0) goto L41;
        Object r11 = null;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        Object r12 = null;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        Object r13 = null;
    L51:
        if ((r29 & 4096) == 0) goto L53;
        JSONObject r14 = new JSONObject();
    L55:
        if ((r29 & 8192) != 0) goto L58;
        r2 = r28;
    L58:
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r1 != null) goto L92;
    L63:
        if (r3 == null) goto L65;
        r14.put("button_name", r3);     // Catch: JSONException -> L61
    L65:
        if (r4 == null) goto L67;
        r14.put("page_token", r4);     // Catch: JSONException -> L61
    L67:
        if (r5 == null) goto L69;
        r14.put("artifact_meta_id", r5);     // Catch: JSONException -> L61
    L69:
        if (r6 == null) goto L71;
        r14.put("resource_type", r6.intValue());     // Catch: JSONException -> L61
    L71:
        if (r7 == null) goto L73;
        r14.put("current_page", r7);     // Catch: JSONException -> L61
    L73:
        if (r8 == null) goto L75;
        r14.put("previous_page", r8);     // Catch: JSONException -> L61
    L75:
        if (r9 == null) goto L77;
        r14.put("collection_id", r9);     // Catch: JSONException -> L61
    L77:
        if (r10 == null) goto L79;
        r14.put("collection_name", r10);     // Catch: JSONException -> L61
    L79:
        if (r11 == null) goto L81;
        r14.put("content_type", r11);     // Catch: JSONException -> L61
    L81:
        if (r12 == null) goto L83;
        r14.put("content_sec_type", r12);     // Catch: JSONException -> L61
    L83:
        if (r13 == null) goto L87;
        r14.put("if_multiple_choose", r13);     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobFileFunctionClick: " + e.getLocalizedMessage());
    L87:
        TrackParams r0 = new TrackParams().merge(r14);
        by7.a r30 = new by7.a("file_function_click");
        if (r2 == null) goto L90;
        r30.b = r2;
    L90:
        r30.a.merge(r0);
        r30.b();
        return;
    L92:
        r14.put("show_from", r1);     // Catch: JSONException -> L61
        goto L63
    L53:
        r14 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
