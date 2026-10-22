package com.larus.commercemembership.impl.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public e() {
    }

    public static void b(String r3, String r4, String r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r5 = "meet_quota_limit";
    L6:
        if ((r6 & 16) == 0) goto L8;
        String r0 = "pc_guide_link_click";
    L10:
        if ((r6 & 32) == 0) goto L12;
        JSONObject r7 = new JSONObject();
    L13:
        Intrinsics.checkNotNullParameter(r0, "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.remove("growth_deepevent");     // Catch: JSONException -> L22
        if (r3 == null) goto L17;
        r7.put("pc_guide_scene", r3);     // Catch: JSONException -> L22
    L17:
        r7.put("pc_guide_position", r4);     // Catch: JSONException -> L22
        if (Intrinsics.areEqual(r3, "ug_free_subs_download_pc") == false) goto L24;
        if (r5 == null) goto L24;
        r7.put("ug_free_subs_download_pc_source", r5);     // Catch: JSONException -> L22
    L24:
        TrackParams r8 = new TrackParams().merge(r7);
        by7.a r9 = new by7.a(r0);
        r9.a.merge(r8);
        r9.b();
        com.larus.platform.service.g.a.monitorEventForSlardar(r0, r7, new JSONObject(), null);
        return;
    L22:
        e = move-exception;
        FLogger.a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper mobPcGuideLinkClick " + e.getLocalizedMessage());
        goto L24
    L12:
        r7 = null;
        goto L13
    L8:
        r0 = null;
        goto L10
    }

    public static void c(String r3, String r4, String r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r5 = "meet_quota_limit";
    L6:
        if ((r6 & 16) == 0) goto L8;
        String r0 = "pc_guide_link_show";
    L10:
        if ((r6 & 32) == 0) goto L12;
        JSONObject r7 = new JSONObject();
    L13:
        Intrinsics.checkNotNullParameter(r0, "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.remove("growth_deepevent");     // Catch: JSONException -> L22
        if (r3 == null) goto L17;
        r7.put("pc_guide_scene", r3);     // Catch: JSONException -> L22
    L17:
        r7.put("pc_guide_position", r4);     // Catch: JSONException -> L22
        if (Intrinsics.areEqual(r3, "ug_free_subs_download_pc") == false) goto L24;
        if (r5 == null) goto L24;
        r7.put("ug_free_subs_download_pc_source", r5);     // Catch: JSONException -> L22
    L24:
        TrackParams r8 = new TrackParams().merge(r7);
        by7.a r9 = new by7.a(r0);
        r9.a.merge(r8);
        r9.b();
        com.larus.platform.service.g.a.monitorEventForSlardar(r0, r7, new JSONObject(), null);
        return;
    L22:
        e = move-exception;
        FLogger.a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper mobPcGuideLinkShow " + e.getLocalizedMessage());
        goto L24
    L12:
        r7 = null;
        goto L13
    L8:
        r0 = null;
        goto L10
    }

    public static void a(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, int r33) {
        if ((r33 & 4) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r33 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r33 & 16) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r33 & 32) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r33 & 64) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r33 & 128) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r33 & 256) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r33 & 512) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r33 & 1024) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r33 & 2048) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r33 & 4096) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r33 & 8192) == 0) goto L49;
        String r14 = null;
    L51:
        if ((32768 & r33) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r33 & 65536) == 0) goto L57;
        String r3 = "click_subs_guidance";
    L59:
        if ((r33 & 131072) == 0) goto L61;
        JSONObject r1 = new JSONObject();
    L62:
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r18 != null) goto L138;
    L67:
        r1.put("current_page", r19);     // Catch: JSONException -> L65
        if (r2 == null) goto L70;
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r2);     // Catch: JSONException -> L65
    L70:
        if (r4 == null) goto L72;
        r1.put("trigger_scene", r4);     // Catch: JSONException -> L65
    L72:
        if (r5 == null) goto L74;
        r1.put("feature_key", r5);     // Catch: JSONException -> L65
    L74:
        if (r6 != null) goto L76;
    L81:
        if (r7 == null) goto L83;
        r1.put("subs_purchase_id", r7);     // Catch: JSONException -> L65
    L83:
        if (r8 != null) goto L85;
    L90:
        if (r9 != null) goto L92;
    L97:
        if (r10 != null) goto L99;
    L104:
        if (r11 != null) goto L106;
    L111:
        if (r12 != null) goto L113;
    L118:
        if (r13 != null) goto L120;
    L125:
        if (r14 != null) goto L127;
    L132:
        if (r15 == 0) goto L136;
        r1.put("menu_id", r15);     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper receiveStream " + e.getLocalizedMessage());
    L136:
        TrackParams r0 = new TrackParams().merge(r1);
        by7.a r16 = new by7.a(r3);
        r16.a.merge(r0);
        r16.b();
        com.larus.platform.service.g.a.monitorEventForSlardar(r3, r1, new JSONObject(), null);
        return;
    L127:
        if ((!StringsKt.isBlank(r14)) == true) goto L130;
        r14 = null;
    L130:
        if (r14 == null) goto L132;
        r1.put("com_window_gap_intent_id", r14);     // Catch: JSONException -> L65
        goto L132
    L120:
        if ((!StringsKt.isBlank(r13)) == true) goto L123;
        r13 = null;
    L123:
        if (r13 == null) goto L125;
        r1.put("com_window_gap_req_id", r13);     // Catch: JSONException -> L65
        goto L125
    L113:
        if ((!StringsKt.isBlank(r12)) == true) goto L116;
        r12 = null;
    L116:
        if (r12 == null) goto L118;
        r1.put("com_quota_cost_fk_id", r12);     // Catch: JSONException -> L65
        goto L118
    L106:
        if ((!StringsKt.isBlank(r11)) == true) goto L109;
        r11 = null;
    L109:
        if (r11 == null) goto L111;
        r1.put("com_quota_cost_req_id", r11);     // Catch: JSONException -> L65
        goto L111
    L99:
        if ((!StringsKt.isBlank(r10)) == true) goto L102;
        r10 = null;
    L102:
        if (r10 == null) goto L104;
        r1.put("is_backend_callback", r10);     // Catch: JSONException -> L65
        goto L104
    L92:
        if ((!StringsKt.isBlank(r9)) == true) goto L95;
        r9 = null;
    L95:
        if (r9 == null) goto L97;
        r1.put("threshold_value", r9);     // Catch: JSONException -> L65
        goto L97
    L85:
        if ((!StringsKt.isBlank(r8)) == true) goto L88;
        r8 = null;
    L88:
        if (r8 == null) goto L90;
        r1.put("threshold_type", r8);     // Catch: JSONException -> L65
        goto L90
    L76:
        if ((!StringsKt.isBlank(r6)) == true) goto L79;
        r6 = null;
    L79:
        if (r6 == null) goto L81;
        r1.put("feature_detail", r6);     // Catch: JSONException -> L65
        goto L81
    L138:
        r1.put("enter_method", r18);     // Catch: JSONException -> L65
        goto L67
    L61:
        r1 = null;
        goto L62
    L57:
        r3 = null;
        goto L59
    L53:
        r15 = r32;
        goto L55
    L49:
        r14 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L29:
        r9 = r26;
        goto L31
    L25:
        r8 = r25;
        goto L27
    L21:
        r7 = r24;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r5 = r22;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r20;
        goto L7
    }

    public static void d(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, int r33) {
        if ((r33 & 4) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r33 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r33 & 16) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r33 & 32) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r33 & 64) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r33 & 128) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r33 & 256) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r33 & 512) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r33 & 1024) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r33 & 2048) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r33 & 4096) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r33 & 8192) == 0) goto L49;
        String r14 = null;
    L51:
        if ((32768 & r33) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r33 & 65536) == 0) goto L57;
        String r3 = "show_subs_guidance";
    L59:
        if ((r33 & 131072) == 0) goto L61;
        JSONObject r1 = new JSONObject();
    L62:
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r18 != null) goto L138;
    L67:
        r1.put("current_page", r19);     // Catch: JSONException -> L65
        if (r2 == null) goto L70;
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r2);     // Catch: JSONException -> L65
    L70:
        if (r4 == null) goto L72;
        r1.put("trigger_scene", r4);     // Catch: JSONException -> L65
    L72:
        if (r5 == null) goto L74;
        r1.put("feature_key", r5);     // Catch: JSONException -> L65
    L74:
        if (r6 != null) goto L76;
    L81:
        if (r7 == null) goto L83;
        r1.put("subs_purchase_id", r7);     // Catch: JSONException -> L65
    L83:
        if (r8 != null) goto L85;
    L90:
        if (r9 != null) goto L92;
    L97:
        if (r10 != null) goto L99;
    L104:
        if (r11 != null) goto L106;
    L111:
        if (r12 != null) goto L113;
    L118:
        if (r13 != null) goto L120;
    L125:
        if (r14 != null) goto L127;
    L132:
        if (r15 == 0) goto L136;
        r1.put("menu_id", r15);     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper receiveStream " + e.getLocalizedMessage());
    L136:
        TrackParams r0 = new TrackParams().merge(r1);
        by7.a r16 = new by7.a(r3);
        r16.a.merge(r0);
        r16.b();
        com.larus.platform.service.g.a.monitorEventForSlardar(r3, r1, new JSONObject(), null);
        return;
    L127:
        if ((!StringsKt.isBlank(r14)) == true) goto L130;
        r14 = null;
    L130:
        if (r14 == null) goto L132;
        r1.put("com_window_gap_intent_id", r14);     // Catch: JSONException -> L65
        goto L132
    L120:
        if ((!StringsKt.isBlank(r13)) == true) goto L123;
        r13 = null;
    L123:
        if (r13 == null) goto L125;
        r1.put("com_window_gap_req_id", r13);     // Catch: JSONException -> L65
        goto L125
    L113:
        if ((!StringsKt.isBlank(r12)) == true) goto L116;
        r12 = null;
    L116:
        if (r12 == null) goto L118;
        r1.put("com_quota_cost_fk_id", r12);     // Catch: JSONException -> L65
        goto L118
    L106:
        if ((!StringsKt.isBlank(r11)) == true) goto L109;
        r11 = null;
    L109:
        if (r11 == null) goto L111;
        r1.put("com_quota_cost_req_id", r11);     // Catch: JSONException -> L65
        goto L111
    L99:
        if ((!StringsKt.isBlank(r10)) == true) goto L102;
        r10 = null;
    L102:
        if (r10 == null) goto L104;
        r1.put("is_backend_callback", r10);     // Catch: JSONException -> L65
        goto L104
    L92:
        if ((!StringsKt.isBlank(r9)) == true) goto L95;
        r9 = null;
    L95:
        if (r9 == null) goto L97;
        r1.put("threshold_value", r9);     // Catch: JSONException -> L65
        goto L97
    L85:
        if ((!StringsKt.isBlank(r8)) == true) goto L88;
        r8 = null;
    L88:
        if (r8 == null) goto L90;
        r1.put("threshold_type", r8);     // Catch: JSONException -> L65
        goto L90
    L76:
        if ((!StringsKt.isBlank(r6)) == true) goto L79;
        r6 = null;
    L79:
        if (r6 == null) goto L81;
        r1.put("feature_detail", r6);     // Catch: JSONException -> L65
        goto L81
    L138:
        r1.put("enter_method", r18);     // Catch: JSONException -> L65
        goto L67
    L61:
        r1 = null;
        goto L62
    L57:
        r3 = null;
        goto L59
    L53:
        r15 = r32;
        goto L55
    L49:
        r14 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L29:
        r9 = r26;
        goto L31
    L25:
        r8 = r25;
        goto L27
    L21:
        r7 = r24;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r5 = r22;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r20;
        goto L7
    }
}
