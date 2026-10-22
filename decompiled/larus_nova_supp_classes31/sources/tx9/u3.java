package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u3 {
    public static void c(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("content_type", r3);     // Catch: JSONException -> L5
        r0.putOpt("content", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("ai_creation_toast_show");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper mobAICreationToastShow " + e.getLocalizedMessage());
        goto L7
    }

    public static void f(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("action_type", r2);     // Catch: JSONException -> L5
        r0.putOpt("template_sub_type", r3);     // Catch: JSONException -> L5
        r0.putOpt("template_type", r4);     // Catch: JSONException -> L5
        r0.putOpt("recommend_from", r5);     // Catch: JSONException -> L5
    L7:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("edit_image_reference");
        r7.a.merge(r6);
        r7.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper mobEditImageReference " + e.getLocalizedMessage());
        goto L7
    }

    public static void o(String r2, Boolean r3, Integer r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("recommend_from", r2);     // Catch: JSONException -> L5
        r0.putOpt("is_image_reference_public", l3.f(r3));     // Catch: JSONException -> L5
        r0.putOpt("image_reference_cnt", r4);     // Catch: JSONException -> L5
        r0.putOpt("creator_id", r5);     // Catch: JSONException -> L5
        r0.putOpt("template_id", r6);     // Catch: JSONException -> L5
        r0.putOpt("show_from", r7);     // Catch: JSONException -> L5
        r0.putOpt("template_sub_type", r8);     // Catch: JSONException -> L5
        r0.putOpt("template_type", r9);     // Catch: JSONException -> L5
        r0.putOpt("template_use_tag", r10);     // Catch: JSONException -> L5
    L7:
        TrackParams r11 = new TrackParams().merge(r0);
        by7.a r12 = new by7.a("use_template_menu_show");
        r12.a.merge(r11);
        r12.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper use_template_menu_show " + e.getLocalizedMessage());
        goto L7
    }

    public static void m(String r2, Boolean r3, Integer r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, JSONObject r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = Boolean.FALSE;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r13 & 1024) == 0) goto L35;
        r12 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r12, "params");
        r12.putOpt("recommend_from", r2);     // Catch: JSONException -> L38
        r12.putOpt("is_image_reference_public", l3.f(r3));     // Catch: JSONException -> L38
        r12.putOpt("image_reference_cnt", r4);     // Catch: JSONException -> L38
        r12.putOpt("creator_id", r5);     // Catch: JSONException -> L38
        r12.putOpt("template_id", r6);     // Catch: JSONException -> L38
        r12.putOpt("show_from", r7);     // Catch: JSONException -> L38
        r12.putOpt("template_sub_type", r8);     // Catch: JSONException -> L38
        r12.putOpt("template_type", r9);     // Catch: JSONException -> L38
        r12.putOpt("template_use_tag", r10);     // Catch: JSONException -> L38
        r12.putOpt("button_type", r11);     // Catch: JSONException -> L38
    L40:
        TrackParams r14 = new TrackParams().merge(r12);
        by7.a r15 = new by7.a("use_template_menu_click");
        r15.a.merge(r14);
        r15.b();
        return;
    L38:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper use_template_menu_click " + e.getLocalizedMessage());
        goto L40
    }

    public static void n(String r2, Boolean r3, Integer r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, JSONObject r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = Boolean.FALSE;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r13 & 1024) == 0) goto L35;
        r12 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r12, "params");
        r12.putOpt("recommend_from", r2);     // Catch: JSONException -> L38
        r12.putOpt("is_image_reference_public", l3.f(r3));     // Catch: JSONException -> L38
        r12.putOpt("image_reference_cnt", r4);     // Catch: JSONException -> L38
        r12.putOpt("creator_id", r5);     // Catch: JSONException -> L38
        r12.putOpt("template_id", r6);     // Catch: JSONException -> L38
        r12.putOpt("show_from", r7);     // Catch: JSONException -> L38
        r12.putOpt("template_sub_type", r8);     // Catch: JSONException -> L38
        r12.putOpt("template_type", r9);     // Catch: JSONException -> L38
        r12.putOpt("template_use_tag", r10);     // Catch: JSONException -> L38
        r12.putOpt("button_type", r11);     // Catch: JSONException -> L38
    L40:
        TrackParams r14 = new TrackParams().merge(r12);
        by7.a r15 = new by7.a("use_template_menu_element_show");
        r15.a.merge(r14);
        r15.b();
        return;
    L38:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper use_template_menu_element_show " + e.getLocalizedMessage());
        goto L40
    }

    public static void d(String r2, String r3, String r4, String r5, Integer r6, Integer r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("bot_id", r14);     // Catch: JSONException -> L25
        r0.putOpt("ai_generate_tab_id", r11);     // Catch: JSONException -> L25
        r0.putOpt("ai_generate_tab_name", r13);     // Catch: JSONException -> L25
        r0.putOpt("ai_generate_tab_type", r12);     // Catch: JSONException -> L25
        if (r5 == null) goto L6;
        r0.put("creator_id", r5);     // Catch: JSONException -> L25
    L6:
        if (r7 == null) goto L8;
        r0.put("page_index", r7.intValue());     // Catch: JSONException -> L25
    L8:
        if (r6 == null) goto L10;
        r0.put("position", r6.intValue());     // Catch: JSONException -> L25
    L10:
        if (r9 == null) goto L12;
        r0.put("template_rec_req_id", r9);     // Catch: JSONException -> L25
    L12:
        if (r10 == null) goto L14;
        r0.put("recommend_from", r10);     // Catch: JSONException -> L25
    L14:
        r0.put("click_method", r8);     // Catch: JSONException -> L25
        if (r2 == null) goto L17;
        r0.put("template_id", r2);     // Catch: JSONException -> L25
    L17:
        r0.put("template_type", r3);     // Catch: JSONException -> L25
        if (r4.length() != 0) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L23;
        r4 = "default";
    L23:
        r0.put("template_source", r4);     // Catch: JSONException -> L25
    L27:
        TrackParams r16 = new TrackParams().merge(r0);
        by7.a r17 = new by7.a("click_template_download");
        r17.a.merge(r16);
        r17.b();
        return;
    L20:
        r15 = false;
    L25:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper use template " + e.getLocalizedMessage());
        goto L27
    }

    public static void i(String r16, String r17, String r18, Integer r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "params");
        b("session_click", r16, r17, r18, r19, r20, r21, r28, r22, r23, r24, r25, r26, r27, r14, null);
    }

    public static void j(String r16, String r17, String r18, Integer r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "params");
        b("session_slide", r16, r17, r18, r19, r20, r21, r28, r22, r23, r24, r25, r26, r27, r14, null);
    }

    public static void h(String r17, String r18, String r19, Integer r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, Long r29, String r30) {
        JSONObject r15 = new JSONObject();
        Intrinsics.checkNotNullParameter(r15, "params");
        a("feed_staytime", r17, r18, r19, r20, r21, r22, r30, r23, r24, r25, r26, r27, r28, r29, r15, null);
    }

    public static /* synthetic */ void b(String r17, String r18, String r19, String r20, Integer r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, JSONObject r31, by7.e r32) {
        a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, null, r31, r32);
    }

    public static final void a(String r15, String r16, String r17, String r18, Integer r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, Long r29, JSONObject r30, by7.e r31) {
        List r4 = CollectionsKt.mutableListOf(new Pair[]{TuplesKt.to("bot_id", r16), TuplesKt.to("current_page", r17), TuplesKt.to("enter_method", r18), TuplesKt.to("page_index", r19), TuplesKt.to("previous_page", r20), TuplesKt.to("recommend_from", r21), TuplesKt.to("click_from", r22)});
        List r5 = r4;
        CollectionsKt.addAll(r5, CollectionsKt.listOf(new Pair[]{TuplesKt.to("template_id", r23), TuplesKt.to("template_rec_extra", r24), TuplesKt.to("template_rec_req_id", r25), TuplesKt.to("template_source", r26), TuplesKt.to("template_sub_type", r27), TuplesKt.to("template_type", r28)}));
        if (Intrinsics.areEqual(r15, "feed_staytime") == false) goto L6;
        r5.add(TuplesKt.to("duration", r29));
    L6:
        if (Intrinsics.areEqual(r15, "feed_staytime") == false) goto L33;
        if (r29 == null) goto L33;
        if (r29.longValue() > 500) goto L33;
        FLogger.a.d("TemplateEventHelper", "skip " + r15 + ", duration must be greater than 500ms");
        return;
    L33:
        Iterator r0 = r4.iterator();     // Catch: JSONException -> L30
    L13:
        if (r0.hasNext() == false) goto L25;
        Pair r6 = (Pair) r0.next();     // Catch: JSONException -> L30
        String r7 = (String) r6.component1();     // Catch: JSONException -> L30
        Object r8 = r6.component2();     // Catch: JSONException -> L30
        if (r8 == null) goto L23;
        if ((r8 instanceof String) == false) goto L22;
        if (StringsKt.isBlank((CharSequence) r8) == true) goto L23;
    L22:
        r30.put(r7, r8);     // Catch: JSONException -> L30
    L23:
        r30.remove(r7);     // Catch: JSONException -> L30
        goto L13
    L25:
        by7.a r1 = new by7.a(r15);
        if (r31 == null) goto L28;
        r1.b = r31;
    L28:
        r1.a.merge(new TrackParams().merge(r30));
        r1.b();
        return;
    L30:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper " + r15 + ' ' + e.getLocalizedMessage());
    }

    public static void e(String r22, String r23, String r24, String r25, Long r26, Integer r27, Integer r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, Integer r42, String r43, String r44, int r45) {
        if ((r45 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r45 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r45 & 4) == 0) goto L13;
        String r4 = "default";
    L15:
        if ((r45 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r45 & 16) == 0) goto L21;
        Long r7 = null;
    L23:
        if ((r45 & 32) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r45 & 64) == 0) goto L29;
        Integer r9 = null;
    L31:
        if ((r45 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r45 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r45 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r45 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r45 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r45 & 4096) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r45 & 8192) == 0) goto L57;
        String r2 = null;
    L59:
        if ((r45 & 16384) == 0) goto L61;
        String r5 = null;
    L62:
        String r210 = r4;
        if ((r45 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r45 & 65536) == 0) goto L69;
        String r18 = null;
    L71:
        if ((r45 & 131072) == 0) goto L73;
        String r17 = null;
    L75:
        if ((r45 & 262144) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r45 & 524288) == 0) goto L81;
        String r21 = null;
    L82:
        String r211 = r17;
        if ((r45 & 1048576) == 0) goto L85;
        Integer r19 = null;
    L87:
        if ((r45 & 2097152) == 0) goto L89;
        JSONObject r46 = new JSONObject();
    L90:
        String r212 = r16;
        if ((r45 & 8388608) == 0) goto L93;
        String r47 = null;
    L95:
        if ((r45 & 16777216) == 0) goto L97;
        String r0 = null;
    L98:
        Intrinsics.checkNotNullParameter(r46, "params");
        r46.put("template_sub_type", r0);     // Catch: JSONException -> L144
        r46.putOpt("enter_method", r47);     // Catch: JSONException -> L144
        r46.putOpt("bot_id", r2);     // Catch: JSONException -> L144
        r46.putOpt("ai_generate_tab_id", r13);     // Catch: JSONException -> L144
        r46.putOpt("ai_generate_tab_name", r15);     // Catch: JSONException -> L144
        r46.putOpt("ai_generate_tab_type", r14);     // Catch: JSONException -> L144
        r46.putOpt("action_bar_template_id", r19);     // Catch: JSONException -> L144
        if (r6 == null) goto L102;
        r46.put("creator_id", r6);     // Catch: JSONException -> L144
    L102:
        if (r7 == null) goto L104;
        r46.put("use_template_uv", r7.longValue());     // Catch: JSONException -> L144
    L104:
        if (r9 == null) goto L106;
        r46.put("page_index", r9.intValue());     // Catch: JSONException -> L144
    L106:
        if (r8 == null) goto L108;
        r46.put("position", r8.intValue());     // Catch: JSONException -> L144
    L108:
        if (r11 == null) goto L110;
        r46.put("template_rec_req_id", r11);     // Catch: JSONException -> L144
    L110:
        if (r12 == null) goto L112;
        r46.put("recommend_from", r12);     // Catch: JSONException -> L144
    L112:
        if (r10 == null) goto L114;
        r46.put("click_method", r10);     // Catch: JSONException -> L144
    L114:
        if (r1 == 0) goto L116;
        r46.put("template_id", r1);     // Catch: JSONException -> L144
    L116:
        if (r212 == null) goto L118;
        r46.put("previous_page", r212);     // Catch: JSONException -> L144
    L118:
        if (r5 == 0) goto L120;
        r46.put("current_page", r5);     // Catch: JSONException -> L144
    L120:
        if (r211 == null) goto L122;
        r46.put("chat_type", r211);     // Catch: JSONException -> L144
    L122:
        if (r3 == 0) goto L124;
        r46.put("template_type", r3);     // Catch: JSONException -> L144
    L124:
        String r48 = r18;
        if (r48 == null) goto L128;
        r46.put("conversation_id", r48);     // Catch: JSONException -> L144
    L128:
        if (r210 != null) goto L130;
    L133:
        boolean r49 = true;
    L134:
        if (r49 == false) goto L136;
        String r50 = "default";
    L137:
        r46.put("template_source", r50);     // Catch: JSONException -> L144
        String r51 = r21;
        if (r51 == null) goto L140;
        r46.put("template_rec_extra", r51);     // Catch: JSONException -> L144
    L140:
        String r52 = r20;
        if (r52 == null) goto L146;
        r46.put("click_from", r52);     // Catch: JSONException -> L144
    L146:
        TrackParams r53 = new TrackParams().merge(r46);
        by7.a r54 = new by7.a("click_template_share");
        r54.a.merge(r53);
        r54.b();
        return;
    L136:
        r50 = r210;
        goto L137
    L130:
        if (r210.length() == 0) goto L133;
        r49 = false;
    L144:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper use template " + e.getLocalizedMessage());
        goto L146
    L97:
        r0 = r44;
        goto L98
    L93:
        r47 = r43;
        goto L95
    L89:
        r46 = null;
        goto L90
    L85:
        r19 = r42;
        goto L87
    L81:
        r21 = r41;
        goto L82
    L77:
        r20 = r40;
        goto L79
    L73:
        r17 = r39;
        goto L75
    L69:
        r18 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r5 = r36;
        goto L62
    L57:
        r2 = r35;
        goto L59
    L53:
        r15 = r34;
        goto L55
    L49:
        r14 = r33;
        goto L51
    L45:
        r13 = r32;
        goto L47
    L41:
        r12 = r31;
        goto L43
    L37:
        r11 = r30;
        goto L39
    L33:
        r10 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }

    public static void k(String r30, String r31, String r32, String r33, String r34, String r35, Long r36, String r37, String r38, String r39, String r40, String r41, Integer r42, String r43, Integer r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, boolean r53, Integer r54, String r55, String r56, String r57, String r58, String r59, int r60) {
        if ((r60 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r60 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r60 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r60 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r60 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r60 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r60 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r60 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r60 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r60 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r60 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r60 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r60 & 4096) == 0) goto L53;
        Integer r14 = null;
    L55:
        if ((r60 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r60 & 16384) == 0) goto L61;
        Integer r2 = null;
    L62:
        String r310 = r13;
        if ((r60 & 32768) == 0) goto L65;
        String r16 = null;
    L66:
        String r311 = r12;
        if ((r60 & 65536) == 0) goto L69;
        String r17 = null;
    L70:
        String r312 = r4;
        if ((r60 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r60 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r60 & 524288) == 0) goto L81;
        String r110 = null;
    L83:
        if ((r60 & 1048576) == 0) goto L85;
        String r20 = null;
    L87:
        if ((r60 & 2097152) == 0) goto L89;
        String r21 = null;
    L90:
        String r313 = r15;
        if ((r60 & 4194304) == 0) goto L93;
        String r111 = null;
    L95:
        if ((r60 & 8388608) == 0) goto L97;
        boolean r112 = false;
    L99:
        if ((r60 & 16777216) == 0) goto L101;
        Integer r23 = null;
    L103:
        if ((r60 & 33554432) == 0) goto L105;
        String r25 = null;
    L107:
        if ((r60 & 67108864) == 0) goto L109;
        String r22 = null;
    L111:
        if ((r60 & 134217728) == 0) goto L113;
        String r27 = null;
    L115:
        if ((r60 & 268435456) == 0) goto L117;
        String r28 = null;
    L119:
        if ((r60 & 536870912) == 0) goto L121;
        String r29 = null;
    L123:
        if ((r60 & 1073741824) == 0) goto L125;
        JSONObject r113 = new JSONObject();
    L126:
        String r114 = r1;
        Intrinsics.checkNotNullParameter(r113, "params");
        r113.putOpt("template_sub_type", r5);     // Catch: JSONException -> L187
        r113.putOpt("template_use_tag", r22);     // Catch: JSONException -> L187
        r113.putOpt("template_sub_type", r111);     // Catch: JSONException -> L187
        if (r112 == false) goto L130;
        int r24 = 1;
    L131:
        r113.putOpt("is_image_reference_public", Integer.valueOf(r24));     // Catch: JSONException -> L187
        r113.putOpt("action_bar_template_id", r2);     // Catch: JSONException -> L187
        r113.putOpt("ai_generate_tab_id", r16);     // Catch: JSONException -> L187
        r113.putOpt("ai_generate_tab_name", r18);     // Catch: JSONException -> L187
        r113.putOpt("ai_generate_tab_type", r17);     // Catch: JSONException -> L187
        if (r23 == null) goto L134;
        int r0 = r23.intValue();     // Catch: JSONException -> L187
    L135:
        r113.put("image_reference_cnt", r0);     // Catch: JSONException -> L187
        if (r14 == null) goto L138;
        r113.put("page_index", r14.intValue());     // Catch: JSONException -> L187
    L138:
        if (r6 == null) goto L140;
        r113.put("creator_id", r6);     // Catch: JSONException -> L187
    L140:
        if (r7 == null) goto L142;
        r113.put("template_source", r7);     // Catch: JSONException -> L187
    L142:
        if (r8 == null) goto L144;
        r113.put("use_template_uv", r8.longValue());     // Catch: JSONException -> L187
    L144:
        if (r9 == null) goto L146;
        r113.put("template_rec_req_id", r9);     // Catch: JSONException -> L187
    L146:
        if (r10 == null) goto L148;
        r113.put("recommend_from", r10);     // Catch: JSONException -> L187
    L148:
        if (r114 == null) goto L150;
        r113.put("bot_id", r114);     // Catch: JSONException -> L187
    L150:
        if (r11 == 0) goto L152;
        r113.put("show_from", r11);     // Catch: JSONException -> L187
    L152:
        if (r3 == 0) goto L154;
        r113.put("template_id", r3);     // Catch: JSONException -> L187
    L154:
        if (r313 == null) goto L156;
        r113.put("chat_type", r313);     // Catch: JSONException -> L187
    L156:
        if (r312 == null) goto L158;
        r113.put("template_type", r312);     // Catch: JSONException -> L187
    L158:
        if (r311 == null) goto L160;
        r113.put("current_page", r311);     // Catch: JSONException -> L187
    L160:
        if (r310 == null) goto L162;
        r113.put("position", r310);     // Catch: JSONException -> L187
    L162:
        String r26 = r19;
        if (r26 == null) goto L165;
        r113.put("previous_page", r26);     // Catch: JSONException -> L187
    L165:
        String r61 = r110;
        if (r61 == null) goto L168;
        r113.put("enter_method", r61);     // Catch: JSONException -> L187
    L168:
        String r62 = r20;
        if (r62 == null) goto L171;
        r113.put("conversation_id", r62);     // Catch: JSONException -> L187
    L171:
        String r63 = r21;
        if (r63 == null) goto L174;
        r113.put("template_rec_extra", r63);     // Catch: JSONException -> L187
    L174:
        String r64 = r25;
        if (r64 == null) goto L177;
        r113.put("current_page_key", r64);     // Catch: JSONException -> L187
    L177:
        String r65 = r27;
        if (r65 == null) goto L180;
        r113.put("prompt_type", r65);     // Catch: JSONException -> L187
    L180:
        String r66 = r28;
        if (r66 == null) goto L183;
        r113.put("prompt_from", r66);     // Catch: JSONException -> L187
    L183:
        String r67 = r29;
        if (r67 == null) goto L189;
        r113.put("visual_size", r67);     // Catch: JSONException -> L187
    L189:
        TrackParams r68 = new TrackParams().merge(r113);
        by7.a r69 = new by7.a("template_show");
        r69.a.merge(r68);
        r69.b();
        return;
    L134:
        r0 = 0;
        goto L135
    L130:
        r24 = 0;
    L187:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper template show " + e.getLocalizedMessage());
        goto L189
    L125:
        r113 = null;
        goto L126
    L121:
        r29 = r59;
        goto L123
    L117:
        r28 = r58;
        goto L119
    L113:
        r27 = r57;
        goto L115
    L109:
        r22 = r56;
        goto L111
    L105:
        r25 = r55;
        goto L107
    L101:
        r23 = r54;
        goto L103
    L97:
        r112 = r53;
        goto L99
    L93:
        r111 = r52;
        goto L95
    L89:
        r21 = r51;
        goto L90
    L85:
        r20 = r50;
        goto L87
    L81:
        r110 = r49;
        goto L83
    L77:
        r19 = r48;
        goto L79
    L73:
        r18 = r47;
        goto L75
    L69:
        r17 = r46;
        goto L70
    L65:
        r16 = r45;
        goto L66
    L61:
        r2 = r44;
        goto L62
    L57:
        r15 = r43;
        goto L59
    L53:
        r14 = r42;
        goto L55
    L49:
        r13 = r41;
        goto L51
    L45:
        r12 = r40;
        goto L47
    L41:
        r11 = r39;
        goto L43
    L37:
        r10 = r38;
        goto L39
    L33:
        r9 = r37;
        goto L35
    L29:
        r8 = r36;
        goto L31
    L25:
        r7 = r35;
        goto L27
    L21:
        r6 = r34;
        goto L23
    L17:
        r5 = r33;
        goto L19
    L13:
        r4 = r32;
        goto L15
    L9:
        r3 = r31;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }

    public static void g(String r31, String r32, String r33, String r34, String r35, String r36, Long r37, Integer r38, String r39, String r40, String r41, Integer r42, String r43, Integer r44, String r45, String r46, String r47, String r48, String r49, String r50, Boolean r51, String r52, String r53, Boolean r54, Integer r55, Boolean r56, String r57, String r58, String r59, String r60, String r61, String r62, int r63, int r64) {
        if ((r63 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r63 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r63 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r63 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r63 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r63 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r63 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r63 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r63 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r63 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r63 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r63 & 4096) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r63 & 8192) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r63 & 16384) == 0) goto L57;
        Integer r15 = null;
    L59:
        if ((r63 & 32768) == 0) goto L61;
        String r2 = null;
    L62:
        Integer r310 = r13;
        if ((r63 & 65536) == 0) goto L65;
        String r16 = null;
    L66:
        String r311 = r4;
        if ((r63 & 131072) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r63 & 262144) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r63 & 524288) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r63 & 1048576) == 0) goto L81;
        String r20 = null;
    L83:
        if ((r63 & 2097152) == 0) goto L85;
        Boolean r110 = null;
    L87:
        if ((r63 & 4194304) == 0) goto L89;
        String r22 = null;
    L90:
        String r312 = r14;
        if ((r63 & 8388608) == 0) goto L93;
        String r111 = null;
    L95:
        if ((r63 & 16777216) == 0) goto L97;
        Boolean r21 = Boolean.FALSE;
    L99:
        if ((r63 & 33554432) == 0) goto L101;
        Integer r23 = null;
    L103:
        if ((r63 & 67108864) == 0) goto L105;
        Boolean r24 = Boolean.FALSE;
    L106:
        String r313 = r12;
        if ((r63 & 134217728) == 0) goto L109;
        String r112 = null;
    L111:
        if ((r63 & 268435456) == 0) goto L113;
        String r26 = null;
    L115:
        if ((r63 & 536870912) == 0) goto L117;
        String r27 = null;
    L119:
        if ((r63 & 1073741824) == 0) goto L121;
        String r28 = null;
    L123:
        if ((r63 & Integer.MIN_VALUE) == 0) goto L125;
        String r0 = null;
    L127:
        if ((r64 & 1) == 0) goto L129;
        String r29 = null;
    L131:
        if ((r64 & 2) == 0) goto L133;
        JSONObject r113 = new JSONObject();
    L134:
        String r314 = r0;
        Integer r315 = r9;
        Intrinsics.checkNotNullParameter(r113, "params");
        r113.putOpt("template_sub_type", r5);     // Catch: JSONException -> L201
        r113.putOpt("template_use_tag", r112);     // Catch: JSONException -> L201
        r113.putOpt("template_sub_type", r111);     // Catch: JSONException -> L201
        Boolean r25 = Boolean.TRUE;     // Catch: JSONException -> L201
        int r30 = 0;
        int r114 = 1;
        if (Intrinsics.areEqual(r21, r25) == false) goto L138;
        int r65 = 1;
    L139:
        r113.putOpt("is_image_reference_public", Integer.valueOf(r65));     // Catch: JSONException -> L201
        if (Intrinsics.areEqual(r24, r25) == true) goto L143;
        r114 = 0;
    L143:
        r113.putOpt("is_has_caption", Integer.valueOf(r114));     // Catch: JSONException -> L201
        r113.putOpt("ai_generate_tab_id", r2);     // Catch: JSONException -> L201
        r113.putOpt("ai_generate_tab_name", r17);     // Catch: JSONException -> L201
        r113.putOpt("ai_generate_tab_type", r16);     // Catch: JSONException -> L201
        r113.putOpt("action_bar_template_id", r15);     // Catch: JSONException -> L201
        if (r11 == null) goto L146;
        r113.put("enter_method", r11);     // Catch: JSONException -> L201
    L146:
        if (r6 == null) goto L148;
        r113.put("creator_id", r6);     // Catch: JSONException -> L201
    L148:
        if (r7 == null) goto L150;
        r113.put("template_source", r7);     // Catch: JSONException -> L201
    L150:
        if (r8 == null) goto L152;
        r113.put("use_template_uv", r8.longValue());     // Catch: JSONException -> L201
    L152:
        if (r315 == null) goto L154;
        r113.put("page_index", r315.intValue());     // Catch: JSONException -> L201
    L154:
        if (r10 == 0) goto L156;
        r113.put("template_rec_req_id", r10);     // Catch: JSONException -> L201
    L156:
        if (r313 == null) goto L158;
        r113.put("recommend_from", r313);     // Catch: JSONException -> L201
    L158:
        if (r1 == 0) goto L160;
        r113.put("bot_id", r1);     // Catch: JSONException -> L201
    L160:
        if (r3 == 0) goto L162;
        r113.put("template_id", r3);     // Catch: JSONException -> L201
    L162:
        if (r312 == null) goto L164;
        r113.put("chat_type", r312);     // Catch: JSONException -> L201
    L164:
        if (r311 == null) goto L166;
        r113.put("template_type", r311);     // Catch: JSONException -> L201
    L166:
        if (r310 == null) goto L168;
        r113.put("position", r310.intValue());     // Catch: JSONException -> L201
    L168:
        String r66 = r19;
        if (r66 == null) goto L171;
        r113.put("previous_page", r66);     // Catch: JSONException -> L201
    L171:
        String r67 = r18;
        if (r67 == null) goto L174;
        r113.put("current_page", r67);     // Catch: JSONException -> L201
    L174:
        String r68 = r20;
        if (r68 == null) goto L177;
        r113.put("conversation_id", r68);     // Catch: JSONException -> L201
    L177:
        String r69 = r26;
        if (r69 == null) goto L180;
        r113.put("prompt_type", r69);     // Catch: JSONException -> L201
    L180:
        String r70 = r27;
        if (r70 == null) goto L183;
        r113.put("prompt_from", r70);     // Catch: JSONException -> L201
    L183:
        String r71 = r28;
        if (r71 == null) goto L187;
        r113.put("visual_size", r71);     // Catch: JSONException -> L201
    L187:
        if (r23 == null) goto L189;
        r30 = r23.intValue();     // Catch: JSONException -> L201
    L189:
        r113.putOpt("image_reference_cnt", Integer.valueOf(r30));     // Catch: JSONException -> L201
        if (r110 == null) goto L192;
        r113.put("success", r110.booleanValue() ? 1 : 0);     // Catch: JSONException -> L201
    L192:
        String r72 = r22;
        if (r72 == null) goto L195;
        r113.put("template_rec_extra", r72);     // Catch: JSONException -> L201
    L195:
        if (r314 == null) goto L197;
        r113.put("anchor_creation_id", r314);     // Catch: JSONException -> L201
    L197:
        String r73 = r29;
        if (r73 == null) goto L203;
        r113.put("douyin_gid", r73);     // Catch: JSONException -> L201
    L203:
        TrackParams r74 = new TrackParams().merge(r113);
        by7.a r75 = new by7.a("enter_template_detail");
        r75.a.merge(r74);
        r75.b();
        return;
    L138:
        r65 = 0;
    L201:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper template show " + e.getLocalizedMessage());
        goto L203
    L133:
        r113 = null;
        goto L134
    L129:
        r29 = r62;
        goto L131
    L125:
        r0 = r61;
        goto L127
    L121:
        r28 = r60;
        goto L123
    L117:
        r27 = r59;
        goto L119
    L113:
        r26 = r58;
        goto L115
    L109:
        r112 = r57;
        goto L111
    L105:
        r24 = r56;
        goto L106
    L101:
        r23 = r55;
        goto L103
    L97:
        r21 = r54;
        goto L99
    L93:
        r111 = r53;
        goto L95
    L89:
        r22 = r52;
        goto L90
    L85:
        r110 = r51;
        goto L87
    L81:
        r20 = r50;
        goto L83
    L77:
        r19 = r49;
        goto L79
    L73:
        r18 = r48;
        goto L75
    L69:
        r17 = r47;
        goto L71
    L65:
        r16 = r46;
        goto L66
    L61:
        r2 = r45;
        goto L62
    L57:
        r15 = r44;
        goto L59
    L53:
        r14 = r43;
        goto L55
    L49:
        r13 = r42;
        goto L51
    L45:
        r12 = r41;
        goto L47
    L41:
        r11 = r40;
        goto L43
    L37:
        r10 = r39;
        goto L39
    L33:
        r9 = r38;
        goto L35
    L29:
        r8 = r37;
        goto L31
    L25:
        r7 = r36;
        goto L27
    L21:
        r6 = r35;
        goto L23
    L17:
        r5 = r34;
        goto L19
    L13:
        r4 = r33;
        goto L15
    L9:
        r3 = r32;
        goto L11
    L5:
        r1 = r31;
        goto L7
    }

    public static void l(String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, Integer r43, Integer r44, String r45, Integer r46, String r47, String r48, String r49, String r50, String r51, String r52, Long r53, String r54, String r55, String r56, Boolean r57, Integer r58, Boolean r59, String r60, String r61, String r62, String r63, Boolean r64, String r65, String r66, String r67, String r68, String r69, int r70, int r71) {
        if ((r70 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r70 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r70 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r70 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r70 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r70 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r70 & 64) == 0) goto L29;
        String r8 = "default";
    L31:
        if ((r70 & 128) == 0) goto L33;
        JSONObject r10 = new JSONObject();
    L35:
        if ((r70 & 512) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r70 & 1024) == 0) goto L41;
        Integer r12 = null;
    L43:
        if ((r70 & 2048) == 0) goto L45;
        Integer r13 = null;
    L47:
        if ((r70 & 4096) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r70 & 8192) == 0) goto L53;
        Integer r15 = null;
    L55:
        if ((r70 & 16384) == 0) goto L57;
        String r2 = null;
    L59:
        if ((r70 & 32768) == 0) goto L61;
        String r9 = null;
    L62:
        String r310 = r8;
        if ((r70 & 65536) == 0) goto L65;
        String r16 = null;
    L66:
        String r311 = r6;
        if ((r70 & 131072) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r70 & 262144) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r70 & 524288) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r70 & 1048576) == 0) goto L81;
        Long r110 = null;
    L83:
        if ((r70 & 2097152) == 0) goto L85;
        String r21 = null;
    L87:
        if ((r70 & 4194304) == 0) goto L89;
        String r22 = null;
    L90:
        String r312 = r5;
        if ((r70 & 8388608) == 0) goto L93;
        String r20 = null;
    L95:
        if ((r70 & 16777216) == 0) goto L97;
        Boolean r23 = Boolean.FALSE;
    L99:
        if ((r70 & 33554432) == 0) goto L101;
        Integer r24 = null;
    L103:
        if ((r70 & 67108864) == 0) goto L105;
        Boolean r25 = Boolean.FALSE;
    L107:
        if ((r70 & 134217728) == 0) goto L109;
        String r26 = null;
    L111:
        if ((r70 & 268435456) == 0) goto L113;
        String r27 = null;
    L114:
        String r313 = r17;
        if ((r70 & 536870912) == 0) goto L117;
        String r28 = null;
    L119:
        if ((r70 & 1073741824) == 0) goto L121;
        String r29 = null;
    L123:
        if ((r70 & Integer.MIN_VALUE) == 0) goto L125;
        Boolean r0 = Boolean.FALSE;
    L127:
        if ((r71 & 1) == 0) goto L129;
        String r210 = null;
    L131:
        if ((r71 & 2) == 0) goto L133;
        String r30 = null;
    L135:
        if ((r71 & 4) == 0) goto L137;
        String r31 = null;
    L139:
        if ((r71 & 8) == 0) goto L141;
        String r32 = null;
    L143:
        if ((r71 & 16) == 0) goto L145;
        String r33 = null;
    L146:
        Integer r410 = r12;
        Intrinsics.checkNotNullParameter(r10, "params");
        r10.putOpt("template_sub_type", r7);     // Catch: JSONException -> L229
        Boolean r111 = Boolean.TRUE;     // Catch: JSONException -> L229
        boolean r112 = false;
        if (Intrinsics.areEqual(r0, r111) == false) goto L150;
        int r34 = 1;
    L151:
        r10.putOpt("is_has_replica", Integer.valueOf(r34));     // Catch: JSONException -> L229
        if (r29 != null) goto L154;
        r29 = "use_prompt";
    L154:
        r10.putOpt("button_type", r29);     // Catch: JSONException -> L229
        r10.putOpt("template_use_tag", r28);     // Catch: JSONException -> L229
        r10.putOpt("enter_method", r26);     // Catch: JSONException -> L229
        r10.putOpt("template_sub_type", r20);     // Catch: JSONException -> L229
        if (Intrinsics.areEqual(r23, r111) == false) goto L157;
        int r72 = 1;
    L158:
        r10.putOpt("is_image_reference_public", Integer.valueOf(r72));     // Catch: JSONException -> L229
        if (Intrinsics.areEqual(r25, r111) == false) goto L161;
        int r73 = 1;
    L162:
        r10.putOpt("is_has_caption", Integer.valueOf(r73));     // Catch: JSONException -> L229
        r10.putOpt("ai_generate_tab_id", r2);     // Catch: JSONException -> L229
        r10.putOpt("ai_generate_tab_name", r16);     // Catch: JSONException -> L229
        r10.putOpt("ai_generate_tab_type", r9);     // Catch: JSONException -> L229
        if (r11 == null) goto L165;
        r10.put("creator_id", r11);     // Catch: JSONException -> L229
    L165:
        r10.putOpt("action_bar_template_id", r15);     // Catch: JSONException -> L229
        if (r13 == null) goto L168;
        r10.put("page_index", r13.intValue());     // Catch: JSONException -> L229
    L168:
        if (r410 == null) goto L170;
        r10.put("position", r410.intValue());     // Catch: JSONException -> L229
    L170:
        if (r14 == 0) goto L172;
        r10.put("template_rec_req_id", r14);     // Catch: JSONException -> L229
    L172:
        if (r313 == null) goto L174;
        r10.put("recommend_from", r313);     // Catch: JSONException -> L229
    L174:
        if (r24 == null) goto L176;
        int r74 = r24.intValue();     // Catch: JSONException -> L229
    L177:
        r10.put("image_reference_cnt", r74);     // Catch: JSONException -> L229
        if (r1 == 0) goto L180;
        r10.put("bot_id", r1);     // Catch: JSONException -> L229
    L180:
        if (r4 == 0) goto L182;
        r10.put("enter_from", r4);     // Catch: JSONException -> L229
    L182:
        if (r3 == 0) goto L184;
        r10.put("template_id", r3);     // Catch: JSONException -> L229
    L184:
        if (r312 == null) goto L186;
        r10.put("chat_type", r312);     // Catch: JSONException -> L229
    L186:
        if (r311 == null) goto L188;
        r10.put("template_type", r311);     // Catch: JSONException -> L229
    L188:
        String r75 = r18;
        if (r75 == null) goto L191;
        r10.put("current_page", r75);     // Catch: JSONException -> L229
    L191:
        String r76 = r19;
        if (r76 == null) goto L194;
        r10.put("previous_page", r76);     // Catch: JSONException -> L229
    L194:
        if (r110 == null) goto L196;
        r10.put("use_template_uv", r110.longValue());     // Catch: JSONException -> L229
    L196:
        String r77 = r21;
        if (r77 == null) goto L200;
        r10.put("conversation_id", r77);     // Catch: JSONException -> L229
    L200:
        if (r310 != null) goto L202;
    L203:
        r112 = true;
    L204:
        if (r112 == false) goto L206;
        String r78 = "default";
    L207:
        r10.put("template_source", r78);     // Catch: JSONException -> L229
        String r79 = r22;
        if (r79 == null) goto L210;
        r10.put("template_rec_extra", r79);     // Catch: JSONException -> L229
    L210:
        String r80 = r27;
        if (r80 == null) goto L213;
        r10.put("current_page_key", r80);     // Catch: JSONException -> L229
    L213:
        String r81 = r210;
        if (r81 == null) goto L216;
        r10.put("prompt_type", r81);     // Catch: JSONException -> L229
    L216:
        String r82 = r30;
        if (r82 == null) goto L219;
        r10.put("prompt_from", r82);     // Catch: JSONException -> L229
    L219:
        String r83 = r31;
        if (r83 == null) goto L222;
        r10.put("visual_size", r83);     // Catch: JSONException -> L229
    L222:
        String r84 = r32;
        if (r84 == null) goto L225;
        r10.put("anchor_creation_id", r84);     // Catch: JSONException -> L229
    L225:
        String r85 = r33;
        if (r85 == null) goto L231;
        r10.put("douyin_gid", r85);     // Catch: JSONException -> L229
    L231:
        TrackParams r86 = new TrackParams().merge(r10);
        by7.a r87 = new by7.a("use_template");
        r87.a.merge(r86);
        r87.b();
        return;
    L206:
        r78 = r310;
        goto L207
    L202:
        if (r310.length() != 0) goto L204;
    L176:
        r74 = 0;
        goto L177
    L161:
        r73 = 0;
        goto L162
    L157:
        r72 = 0;
        goto L158
    L150:
        r34 = 0;
    L229:
        e = move-exception;
        FLogger.a.e("TemplateEventHelper", "error in TemplateEventHelper use template " + e.getLocalizedMessage());
        goto L231
    L145:
        r33 = r69;
        goto L146
    L141:
        r32 = r68;
        goto L143
    L137:
        r31 = r67;
        goto L139
    L133:
        r30 = r66;
        goto L135
    L129:
        r210 = r65;
        goto L131
    L125:
        r0 = r64;
        goto L127
    L121:
        r29 = r63;
        goto L123
    L117:
        r28 = r62;
        goto L119
    L113:
        r27 = r61;
        goto L114
    L109:
        r26 = r60;
        goto L111
    L105:
        r25 = r59;
        goto L107
    L101:
        r24 = r58;
        goto L103
    L97:
        r23 = r57;
        goto L99
    L93:
        r20 = r56;
        goto L95
    L89:
        r22 = r55;
        goto L90
    L85:
        r21 = r54;
        goto L87
    L81:
        r110 = r53;
        goto L83
    L77:
        r19 = r52;
        goto L79
    L73:
        r18 = r51;
        goto L75
    L69:
        r17 = r50;
        goto L71
    L65:
        r16 = r49;
        goto L66
    L61:
        r9 = r48;
        goto L62
    L57:
        r2 = r47;
        goto L59
    L53:
        r15 = r46;
        goto L55
    L49:
        r14 = r45;
        goto L51
    L45:
        r13 = r44;
        goto L47
    L41:
        r12 = r43;
        goto L43
    L37:
        r11 = r42;
        goto L39
    L33:
        r10 = null;
        goto L35
    L29:
        r8 = r41;
        goto L31
    L25:
        r7 = r40;
        goto L27
    L21:
        r6 = r39;
        goto L23
    L17:
        r5 = r38;
        goto L19
    L13:
        r4 = r37;
        goto L15
    L9:
        r3 = r36;
        goto L11
    L5:
        r1 = r35;
        goto L7
    }
}
