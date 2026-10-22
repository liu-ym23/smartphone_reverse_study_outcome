package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i3 {
    public static void d(String r2, int r3, long r4, int r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("success", r3);     // Catch: JSONException -> L5
        r0.put("scene", r2);     // Catch: JSONException -> L5
        r0.put("duration", r4);     // Catch: JSONException -> L5
        r0.put("count", r6);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("search_message_result");
        r7.a.merge(r5);
        r7.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper mobConversationSearchResult " + e.getLocalizedMessage());
        goto L7
    }

    public static void g(Long r3, String r4, String r5, String r6, by7.e r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r8 & 64) == 0) goto L15;
        r6 = null;
    L15:
        if ((r8 & 256) == 0) goto L17;
        JSONObject r0 = new JSONObject();
    L19:
        if ((r8 & 512) == 0) goto L21;
        r7 = null;
    L21:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L39;
    L26:
        if (r4 == null) goto L28;
        r0.put("query", r4);     // Catch: JSONException -> L24
    L28:
        if (r5 == null) goto L30;
        r0.put("query_id", r5);     // Catch: JSONException -> L24
    L30:
        if (r6 == null) goto L34;
        r0.put("search_id", r6);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchStayDetailPage " + e.getLocalizedMessage());
    L34:
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("search_stay_detail_page");
        if (r7 == null) goto L37;
        r10.b = r7;
    L37:
        r10.a.merge(r9);
        r10.b();
        return;
    L39:
        r0.put("duration", r3.longValue());     // Catch: JSONException -> L24
        goto L26
    L17:
        r0 = null;
        goto L19
    }

    public static void a(String r2, String r3, String r4, String r5, JSONObject r6, by7.e r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 32) == 0) goto L18;
        r6 = new JSONObject();
    L18:
        if ((r8 & 64) == 0) goto L20;
        r7 = null;
    L20:
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r2 != null) goto L38;
    L25:
        if (r3 == null) goto L27;
        r6.put("previous_page", r3);     // Catch: JSONException -> L23
    L27:
        if (r4 == null) goto L29;
        r6.put("click_from", r4);     // Catch: JSONException -> L23
    L29:
        if (r5 == null) goto L33;
        r6.put("search_domain", r5);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchBarClick " + e.getLocalizedMessage());
    L33:
        TrackParams r9 = new TrackParams().merge(r6);
        by7.a r10 = new by7.a("search_bar_click");
        if (r7 == null) goto L36;
        r10.b = r7;
    L36:
        r10.a.merge(r9);
        r10.b();
        return;
    L38:
        r6.put("current_page", r2);     // Catch: JSONException -> L23
        goto L25
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, JSONObject r8, by7.e r9, int r10) {
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
        r8.put("enter_from", r3);     // Catch: JSONException -> L29
    L33:
        if (r4 == null) goto L35;
        r8.put("previous_page", r4);     // Catch: JSONException -> L29
    L35:
        if (r5 == null) goto L37;
        r8.put("show_method", r5);     // Catch: JSONException -> L29
    L37:
        if (r6 == null) goto L39;
        r8.put("function_type", r6);     // Catch: JSONException -> L29
    L39:
        if (r7 == null) goto L43;
        r8.put("search_domain", r7);     // Catch: JSONException -> L29
    L29:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchBarShow " + e.getLocalizedMessage());
    L43:
        TrackParams r11 = new TrackParams().merge(r8);
        by7.a r12 = new by7.a("search_bar_show");
        if (r9 == null) goto L46;
        r12.b = r9;
    L46:
        r12.a.merge(r11);
        r12.b();
        return;
    L48:
        r8.put("current_page", r2);     // Catch: JSONException -> L29
        goto L31
    }

    public static void h(String r2, String r3, Long r4, String r5, String r6, String r7, String r8, String r9, String r10, by7.e r11, int r12) {
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
        if ((r12 & 128) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 256) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 512) == 0) goto L30;
        r10 = null;
    L30:
        if ((r12 & 1024) == 0) goto L32;
        JSONObject r0 = new JSONObject();
    L34:
        if ((r12 & 2048) == 0) goto L36;
        r11 = null;
    L36:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L64;
    L41:
        if (r3 == null) goto L43;
        r0.put("current_page", r3);     // Catch: JSONException -> L39
    L43:
        if (r4 == null) goto L45;
        r0.put("duration", r4.longValue());     // Catch: JSONException -> L39
    L45:
        if (r5 == null) goto L47;
        r0.put("query", r5);     // Catch: JSONException -> L39
    L47:
        if (r6 == null) goto L49;
        r0.put("query_id", r6);     // Catch: JSONException -> L39
    L49:
        if (r7 == null) goto L51;
        r0.put("rank", r7);     // Catch: JSONException -> L39
    L51:
        if (r8 == null) goto L53;
        r0.put("search_id", r8);     // Catch: JSONException -> L39
    L53:
        if (r9 == null) goto L55;
        r0.put("search_request_id", r9);     // Catch: JSONException -> L39
    L55:
        if (r10 == null) goto L59;
        r0.put("search_result_id", r10);     // Catch: JSONException -> L39
    L39:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchStayListPage " + e.getLocalizedMessage());
    L59:
        TrackParams r13 = new TrackParams().merge(r0);
        by7.a r14 = new by7.a("search_stay_list_page");
        if (r11 == null) goto L62;
        r14.b = r11;
    L62:
        r14.a.merge(r13);
        r14.b();
        return;
    L64:
        r0.put("bot_id", r2);     // Catch: JSONException -> L39
        goto L41
    L32:
        r0 = null;
        goto L34
    }

    public static void c(String r2, String r3, String r4, Long r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, by7.e r13, int r14) {
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
        if ((r14 & 128) == 0) goto L24;
        r8 = null;
    L24:
        if ((r14 & 256) == 0) goto L27;
        r9 = null;
    L27:
        if ((r14 & 512) == 0) goto L30;
        r10 = null;
    L30:
        if ((r14 & 1024) == 0) goto L33;
        r11 = null;
    L33:
        if ((r14 & 2048) == 0) goto L36;
        r12 = null;
    L36:
        if ((r14 & 4096) == 0) goto L38;
        JSONObject r0 = new JSONObject();
    L40:
        if ((r14 & 8192) == 0) goto L42;
        r13 = null;
    L42:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L74;
    L47:
        if (r3 == null) goto L49;
        r0.put("enter_method", r3);     // Catch: JSONException -> L45
    L49:
        if (r4 == null) goto L51;
        r0.put("err_code", r4);     // Catch: JSONException -> L45
    L51:
        if (r5 == null) goto L53;
        r0.put("is_result_cnt", r5.longValue());     // Catch: JSONException -> L45
    L53:
        if (r6 == null) goto L55;
        r0.put("query", r6);     // Catch: JSONException -> L45
    L55:
        if (r7 == null) goto L57;
        r0.put("query_id", r7);     // Catch: JSONException -> L45
    L57:
        if (r8 == null) goto L59;
        r0.put("search_id", r8);     // Catch: JSONException -> L45
    L59:
        if (r9 == null) goto L61;
        r0.put("search_request_id", r9);     // Catch: JSONException -> L45
    L61:
        if (r10 == null) goto L63;
        r0.put("recommend_from", r10);     // Catch: JSONException -> L45
    L63:
        if (r11 == null) goto L65;
        r0.put("req_id", r11);     // Catch: JSONException -> L45
    L65:
        if (r12 == null) goto L69;
        r0.put("success", r12);     // Catch: JSONException -> L45
    L45:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchButtonResult " + e.getLocalizedMessage());
    L69:
        TrackParams r15 = new TrackParams().merge(r0);
        by7.a r16 = new by7.a("search_button_result");
        if (r13 == null) goto L72;
        r16.b = r13;
    L72:
        r16.a.merge(r15);
        r16.b();
        return;
    L74:
        r0.put("current_page", r2);     // Catch: JSONException -> L45
        goto L47
    L38:
        r0 = null;
        goto L40
    }

    public static void e(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, Boolean r13, TraceFragment r14, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r15 & 32) == 0) goto L15;
        r6 = null;
    L15:
        if ((r15 & 128) == 0) goto L18;
        r7 = null;
    L18:
        if ((r15 & 256) == 0) goto L21;
        r8 = null;
    L21:
        if ((r15 & 512) == 0) goto L24;
        r9 = null;
    L24:
        if ((r15 & 1024) == 0) goto L27;
        r10 = null;
    L27:
        if ((r15 & 2048) == 0) goto L30;
        r11 = null;
    L30:
        if ((r15 & 4096) == 0) goto L33;
        r12 = null;
    L33:
        if ((r15 & 8192) == 0) goto L36;
        r13 = null;
    L36:
        if ((r15 & 16384) == 0) goto L38;
        JSONObject r0 = new JSONObject();
    L40:
        if ((r15 & 32768) == 0) goto L42;
        r14 = null;
    L42:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L78;
    L47:
        if (r4 == null) goto L49;
        r0.put("chat_type", r4);     // Catch: JSONException -> L45
    L49:
        if (r5 == null) goto L51;
        r0.put("query", r5);     // Catch: JSONException -> L45
    L51:
        if (r6 == null) goto L53;
        r0.put("rank", r6);     // Catch: JSONException -> L45
    L53:
        if (r7 == null) goto L55;
        r0.put("search_id", r7);     // Catch: JSONException -> L45
    L55:
        if (r8 == null) goto L57;
        r0.put("search_request_id", r8);     // Catch: JSONException -> L45
    L57:
        if (r9 == null) goto L59;
        r0.put("search_result_id", r9);     // Catch: JSONException -> L45
    L59:
        if (r10 == null) goto L61;
        r0.put("query_type", r10);     // Catch: JSONException -> L45
    L61:
        if (r11 == null) goto L63;
        r0.put("user_type", r11);     // Catch: JSONException -> L45
    L63:
        if (r12 == null) goto L65;
        r0.put("function_type", r12);     // Catch: JSONException -> L45
    L65:
        if (r13 != null) goto L67;
    L73:
        TrackParams r16 = new TrackParams().merge(r0);
        by7.a r17 = new by7.a("search_result_click");
        if (r14 == null) goto L76;
        r17.b = r14;
    L76:
        r17.a.merge(r16);
        r17.b();
        return;
    L67:
        if (r13.booleanValue() == false) goto L69;
        int r18 = 1;
    L70:
        r0.put("if_have_query", r18);     // Catch: JSONException -> L45
    L45:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchResultClick " + e.getLocalizedMessage());
        goto L73
    L69:
        r18 = 0;
        goto L70
    L78:
        r0.put("bot_id", r3);     // Catch: JSONException -> L45
        goto L47
    L38:
        r0 = null;
        goto L40
    }

    public static void f(String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Boolean r27, by7.e r28, int r29) {
        by7.e r2 = null;
        if ((r29 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r29 & 8) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r29 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r29 & 32) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r29 & 128) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r29 & 256) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r29 & 512) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r29 & 1024) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r29 & 2048) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r29 & 4096) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r29 & 8192) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r29 & 16384) == 0) goto L53;
        JSONObject r14 = new JSONObject();
    L55:
        if ((r29 & 32768) != 0) goto L58;
        r2 = r28;
    L58:
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r1 != null) goto L96;
    L63:
        if (r3 == null) goto L65;
        r14.put("chat_type", r3);     // Catch: JSONException -> L61
    L65:
        if (r4 == null) goto L67;
        r14.put("query", r4);     // Catch: JSONException -> L61
    L67:
        if (r5 == null) goto L69;
        r14.put("query_id", r5);     // Catch: JSONException -> L61
    L69:
        if (r6 == null) goto L71;
        r14.put("rank", r6);     // Catch: JSONException -> L61
    L71:
        if (r7 == null) goto L73;
        r14.put("search_id", r7);     // Catch: JSONException -> L61
    L73:
        if (r8 == null) goto L75;
        r14.put("search_request_id", r8);     // Catch: JSONException -> L61
    L75:
        if (r9 == null) goto L77;
        r14.put("search_result_id", r9);     // Catch: JSONException -> L61
    L77:
        if (r10 == null) goto L79;
        r14.put("query_type", r10);     // Catch: JSONException -> L61
    L79:
        if (r12 == null) goto L81;
        r14.put("user_type", r12);     // Catch: JSONException -> L61
    L81:
        if (r11 == null) goto L83;
        r14.put("function_type", r11);     // Catch: JSONException -> L61
    L83:
        if (r13 != null) goto L85;
    L91:
        TrackParams r0 = new TrackParams().merge(r14);
        by7.a r15 = new by7.a("search_result_show");
        if (r2 == null) goto L94;
        r15.b = r2;
    L94:
        r15.a.merge(r0);
        r15.b();
        return;
    L85:
        if (r13.booleanValue() == false) goto L87;
        int r30 = 1;
    L88:
        r14.put("if_have_query", r30);     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchResultShow " + e.getLocalizedMessage());
        goto L91
    L87:
        r30 = 0;
        goto L88
    L96:
        r14.put("bot_id", r1);     // Catch: JSONException -> L61
        goto L63
    L53:
        r14 = null;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
