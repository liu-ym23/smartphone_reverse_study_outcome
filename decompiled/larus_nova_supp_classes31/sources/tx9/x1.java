package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x1 {
    public static void a(Long r4, String r5, Long r6, Long r7, Long r8, int r9) {
        JSONObject r1 = null;
        if ((r9 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r9 & 32) == 0) goto L20;
        r1 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r4 != null) goto L37;
    L25:
        if (r5 == null) goto L27;
        r1.put("node_type_list", r5);     // Catch: JSONException -> L23
    L27:
        if (r6 == null) goto L29;
        r1.put("markwonCreateDuration", r6.longValue());     // Catch: JSONException -> L23
    L29:
        if (r7 == null) goto L31;
        r1.put("markwonParseDuration", r7.longValue());     // Catch: JSONException -> L23
    L31:
        if (r8 == null) goto L35;
        r1.put("markwonRenderDuration", r8.longValue());     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobFlowMarkdownRender " + e.getLocalizedMessage());
    L35:
        TrackParams r10 = new TrackParams().merge(r1);
        by7.a r11 = new by7.a("flow_markdown_render");
        r11.a.merge(r10);
        r11.b();
        return;
    L37:
        r1.put("parse_char_count", r4.longValue());     // Catch: JSONException -> L23
        goto L25
    }

    public static void e(String r2, String r3, String r4, String r5, String r6, JSONObject r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = "meet_quota_limit";
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.remove("growth_deepevent");     // Catch: JSONException -> L35
        if (r2 == null) goto L24;
        r7.put("pc_guide_scene", r2);     // Catch: JSONException -> L35
    L24:
        if (r3 == null) goto L26;
        r7.put("pc_guide_position", r3);     // Catch: JSONException -> L35
    L26:
        if (r4 == null) goto L28;
        r7.put("pc_guide_style", r4);     // Catch: JSONException -> L35
    L28:
        if (r5 == null) goto L31;
        r7.put("pc_guide_content", r5);     // Catch: JSONException -> L35
    L31:
        if (Intrinsics.areEqual(r2, "ug_free_subs_download_pc") == false) goto L37;
        if (r6 == null) goto L37;
        r7.put("ug_free_subs_download_pc_source", r6);     // Catch: JSONException -> L35
    L37:
        TrackParams r9 = new TrackParams().merge(r7);
        by7.a r10 = new by7.a("pc_guide_link_click");
        r10.a.merge(r9);
        r10.b();
        return;
    L35:
        e = move-exception;
        FLogger.a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper pcGuideLinkClick " + e.getLocalizedMessage());
        goto L37
    }

    public static void f(String r2, String r3, String r4, String r5, String r6, JSONObject r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = "meet_quota_limit";
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.remove("growth_deepevent");     // Catch: JSONException -> L35
        if (r2 == null) goto L24;
        r7.put("pc_guide_scene", r2);     // Catch: JSONException -> L35
    L24:
        if (r3 == null) goto L26;
        r7.put("pc_guide_position", r3);     // Catch: JSONException -> L35
    L26:
        if (r4 == null) goto L28;
        r7.put("pc_guide_style", r4);     // Catch: JSONException -> L35
    L28:
        if (r5 == null) goto L31;
        r7.put("pc_guide_content", r5);     // Catch: JSONException -> L35
    L31:
        if (Intrinsics.areEqual(r2, "ug_free_subs_download_pc") == false) goto L37;
        if (r6 == null) goto L37;
        r7.put("ug_free_subs_download_pc_source", r6);     // Catch: JSONException -> L35
    L37:
        TrackParams r9 = new TrackParams().merge(r7);
        by7.a r10 = new by7.a("pc_guide_link_show");
        r10.a.merge(r9);
        r10.b();
        return;
    L35:
        e = move-exception;
        FLogger.a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper pcGuideLinkShow " + e.getLocalizedMessage());
        goto L37
    }

    public static void d(String r2, Long r3, Long r4, Long r5, Long r6, Long r7, Long r8, Long r9, Long r10, Long r11) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("node_type_list", r2);     // Catch: JSONException -> L23
        if (r3 == null) goto L6;
        r0.put("create_view_duration", r3.longValue());     // Catch: JSONException -> L23
    L6:
        if (r4 == null) goto L8;
        r0.put("set_listener_duration", r4.longValue());     // Catch: JSONException -> L23
    L8:
        if (r5 == null) goto L10;
        r0.put("before_set_text_duration", r5.longValue());     // Catch: JSONException -> L23
    L10:
        if (r6 == null) goto L12;
        r0.put("real_set_text_duration", r6.longValue());     // Catch: JSONException -> L23
    L12:
        if (r7 == null) goto L14;
        r0.put("after_set_text_duration", r7.longValue());     // Catch: JSONException -> L23
    L14:
        if (r8 == null) goto L16;
        r0.put("set_markdown_duration", r8.longValue());     // Catch: JSONException -> L23
    L16:
        if (r9 == null) goto L18;
        r0.put("set_stream_alpha_duration", r9.longValue());     // Catch: JSONException -> L23
    L18:
        if (r10 == null) goto L20;
        r0.put("set_add_view_duration", r10.longValue());     // Catch: JSONException -> L23
    L20:
        if (r11 == null) goto L25;
        r0.put("total_duration", r11.longValue());     // Catch: JSONException -> L23
    L25:
        TrackParams r12 = new TrackParams().merge(r0);
        by7.a r13 = new by7.a("flow_md_text_view_widget_render");
        r13.a.merge(r12);
        r13.b();
        return;
    L23:
        e = move-exception;
        FLogger.a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobMdTextViewWidgetRender " + e.getLocalizedMessage());
        goto L25
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r8 != null) goto L36;
    L7:
        r0.put("current_page", r2);     // Catch: JSONException -> L5
        if (r3 == null) goto L10;
        r0.put("previous_page", r3);     // Catch: JSONException -> L5
    L10:
        if (r7 == null) goto L12;
        r0.put("chat_type", r7);     // Catch: JSONException -> L5
    L12:
        if (r6 == null) goto L14;
        r0.put("bot_id", r6);     // Catch: JSONException -> L5
    L14:
        if (r5 == null) goto L16;
        r0.put("conversation_id", r5);     // Catch: JSONException -> L5
    L16:
        if (r4 == null) goto L18;
        r0.put("message_id", r4);     // Catch: JSONException -> L5
    L18:
        if (r9 == null) goto L20;
        r0.put("url", r9);     // Catch: JSONException -> L5
    L20:
        if (r10 == null) goto L22;
        r0.put("inline_type", r10);     // Catch: JSONException -> L5
    L22:
        if (r14 == null) goto L24;
        r0.put("deep_research_id", r14);     // Catch: JSONException -> L5
    L24:
        if (r15 == null) goto L26;
        r0.put("doc_id", r15);     // Catch: JSONException -> L5
    L26:
        if (r11 == null) goto L28;
        r0.put("inline_display_position", r11);     // Catch: JSONException -> L5
    L28:
        if (r12 == null) goto L30;
        r0.put("inline_text", r12);     // Catch: JSONException -> L5
    L30:
        if (r13 == null) goto L34;
        r0.put("doc_position", r13);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobInlineCitationSpanClick " + e.getLocalizedMessage());
    L34:
        TrackParams r16 = new TrackParams().merge(r0);
        by7.a r17 = new by7.a("inline_click");
        r17.a.merge(r16);
        r17.b();
        return;
    L36:
        r0.put("reply_id", r8);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r8 != null) goto L36;
    L7:
        r0.put("current_page", r2);     // Catch: JSONException -> L5
        if (r3 == null) goto L10;
        r0.put("previous_page", r3);     // Catch: JSONException -> L5
    L10:
        if (r7 == null) goto L12;
        r0.put("chat_type", r7);     // Catch: JSONException -> L5
    L12:
        if (r6 == null) goto L14;
        r0.put("bot_id", r6);     // Catch: JSONException -> L5
    L14:
        if (r5 == null) goto L16;
        r0.put("conversation_id", r5);     // Catch: JSONException -> L5
    L16:
        if (r4 == null) goto L18;
        r0.put("message_id", r4);     // Catch: JSONException -> L5
    L18:
        if (r9 == null) goto L20;
        r0.put("url", r9);     // Catch: JSONException -> L5
    L20:
        if (r10 == null) goto L22;
        r0.put("inline_type", r10);     // Catch: JSONException -> L5
    L22:
        if (r14 == null) goto L24;
        r0.put("deep_research_id", r14);     // Catch: JSONException -> L5
    L24:
        if (r15 == null) goto L26;
        r0.put("doc_id", r15);     // Catch: JSONException -> L5
    L26:
        if (r11 == null) goto L28;
        r0.put("inline_display_position", r11);     // Catch: JSONException -> L5
    L28:
        if (r12 == null) goto L30;
        r0.put("inline_text", r12);     // Catch: JSONException -> L5
    L30:
        if (r13 == null) goto L34;
        r0.put("doc_position", r13);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobInlineCitationSpanShow " + e.getLocalizedMessage());
    L34:
        TrackParams r16 = new TrackParams().merge(r0);
        by7.a r17 = new by7.a("inline_show");
        r17.a.merge(r16);
        r17.b();
        return;
    L36:
        r0.put("reply_id", r8);     // Catch: JSONException -> L5
        goto L7
    }
}
