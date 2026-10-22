package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m2 {
    public static void c(String r2, String r3, String r4, int r5) {
        JSONObject r1 = null;
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r1 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 != null) goto L27;
    L19:
        if (r3 == null) goto L21;
        r1.put("enter_method", r3);     // Catch: JSONException -> L17
    L21:
        if (r4 == null) goto L25;
        r1.put("tab_name", r4);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        FLogger.a.e("NavigationEventHelper", "error in NavigationEventHelper navigationTabShow " + e.getLocalizedMessage());
    L25:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("navigation_tab_show");
        r7.a.merge(r6);
        r7.b();
        return;
    L27:
        r1.put("current_page", r2);     // Catch: JSONException -> L17
        goto L19
    }

    public static void a(String r21, String r22, String r23, String r24, String r25, Integer r26, String r27, Integer r28, String r29, String r30, String r31, Integer r32, String r33, String r34, String r35, String r36, boolean r37, boolean r38, JSONObject r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r40 & 1024) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r40 & 2048) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r40 & 4096) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r40 & 8192) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r40 & 16384) == 0) goto L53;
        String r14 = null;
    L55:
        if ((32768 & r40) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r40 & 65536) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r40 & 131072) == 0) goto L65;
        String r18 = null;
    L66:
        boolean r17 = false;
        if ((r40 & 262144) == 0) goto L69;
        boolean r19 = false;
    L71:
        if ((r40 & 524288) == 0) goto L73;
        boolean r16 = false;
    L75:
        if ((r40 & 1048576) == 0) goto L77;
        JSONObject r20 = new JSONObject();
    L78:
        Intrinsics.checkNotNullParameter(r20, "params");
        if (r1 != null) goto L138;
    L83:
        if (r3 == null) goto L85;
        r20.put("previous_page", r3);     // Catch: JSONException -> L81
    L85:
        if (r4 == null) goto L87;
        r20.put("enter_method", r4);     // Catch: JSONException -> L81
    L87:
        if (r5 == null) goto L89;
        r20.put("show_from", r5);     // Catch: JSONException -> L81
    L89:
        if (r6 == null) goto L91;
        r20.put("tab_name", r6);     // Catch: JSONException -> L81
    L91:
        if (r7 == null) goto L93;
        r20.put("tab_position", r7.intValue());     // Catch: JSONException -> L81
    L93:
        if (r8 == null) goto L95;
        r20.put("cell_name", r8);     // Catch: JSONException -> L81
    L95:
        if (r9 == null) goto L97;
        r20.put("cell_position", r9.intValue());     // Catch: JSONException -> L81
    L97:
        if (r10 == null) goto L100;
        r20.put("bot_id", r10);     // Catch: JSONException -> L81
    L100:
        if (r11 != null) goto L102;
    L105:
        boolean r41 = true;
    L107:
        if (r41 == false) goto L109;
        r20.put("is_blue_highlight", "0");     // Catch: JSONException -> L81
    L110:
        if (r12 != null) goto L112;
    L113:
        r17 = true;
    L115:
        if (r17 == false) goto L117;
        r20.put("is_delete_icon", "0");     // Catch: JSONException -> L81
    L118:
        if (r13 == null) goto L120;
        r20.put("notice_cnt", r13.intValue());     // Catch: JSONException -> L81
    L120:
        if (r14 == null) goto L122;
        r20.put("notice_type", r14);     // Catch: JSONException -> L81
    L122:
        if (r15 == null) goto L124;
        r20.put("user_case_item_id", r15);     // Catch: JSONException -> L81
    L124:
        if (r2 == 0) goto L126;
        r20.put("user_case_reco_request_id", r2);     // Catch: JSONException -> L81
    L126:
        String r0 = r18;
        if (r0 == null) goto L129;
        r20.put("user_case_title", r0);     // Catch: JSONException -> L81
    L129:
        r20.put("if_check_box_show", r19 ? 1 : 0);     // Catch: JSONException -> L81
        if (r16 == false) goto L132;
        String r42 = "checked";
    L133:
        r20.put("check_box_status", r42);     // Catch: JSONException -> L81
    L136:
        TrackParams r43 = new TrackParams().merge(r20);
        by7.a r44 = new by7.a("navigation_tab_cell_show");
        r44.a.merge(r43);
        r44.b();
        return;
    L81:
        e = move-exception;
        FLogger.a.e("NavigationEventHelper", "error in NavigationEventHelper navigationTabShow " + e.getLocalizedMessage());
        goto L136
    L132:
        r42 = "unchecked";
        goto L133
    L117:
        r20.put("is_delete_icon", r12);     // Catch: JSONException -> L81
        goto L118
    L112:
        if (r12.length() != 0) goto L115;
    L109:
        r20.put("is_blue_highlight", r11);     // Catch: JSONException -> L81
        goto L110
    L102:
        if (r11.length() == 0) goto L105;
        r41 = false;
        goto L107
    L138:
        r20.put("current_page", r1);     // Catch: JSONException -> L81
        goto L83
    L77:
        r20 = r39;
        goto L78
    L73:
        r16 = r38;
        goto L75
    L69:
        r19 = r37;
        goto L71
    L65:
        r18 = r36;
        goto L66
    L61:
        r2 = r35;
        goto L63
    L57:
        r15 = r34;
        goto L59
    L53:
        r14 = r33;
        goto L55
    L49:
        r13 = r32;
        goto L51
    L45:
        r12 = r31;
        goto L47
    L41:
        r11 = r30;
        goto L43
    L37:
        r10 = r29;
        goto L39
    L33:
        r9 = r28;
        goto L35
    L29:
        r8 = r27;
        goto L31
    L25:
        r7 = r26;
        goto L27
    L21:
        r6 = r25;
        goto L23
    L17:
        r5 = r24;
        goto L19
    L13:
        r4 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r21;
        goto L7
    }

    public static void b(String r26, Long r27, String r28, String r29, String r30, String r31, String r32, Integer r33, String r34, Integer r35, String r36, String r37, String r38, String r39, Integer r40, String r41, String r42, String r43, String r44, String r45, boolean r46, boolean r47, String r48, JSONObject r49, MainTabFragment r50, int r51) {
        if ((r51 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r51 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r51 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r51 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r51 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r51 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r51 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r51 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r51 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r51 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r51 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r51 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r51 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r51 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r51 & 16384) == 0) goto L61;
        Integer r2 = null;
    L63:
        if ((r51 & 32768) == 0) goto L65;
        String r17 = null;
    L67:
        if ((r51 & 65536) == 0) goto L69;
        String r18 = null;
    L71:
        if ((r51 & 131072) == 0) goto L73;
        String r19 = null;
    L75:
        if ((r51 & 262144) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r51 & 524288) == 0) goto L81;
        String r21 = null;
    L82:
        boolean r22 = false;
        if ((r51 & 1048576) == 0) goto L85;
        boolean r23 = false;
    L87:
        if ((r51 & 2097152) == 0) goto L89;
        boolean r16 = false;
    L90:
        Integer r210 = r2;
        if ((r51 & 4194304) == 0) goto L93;
        String r24 = null;
    L95:
        if ((r51 & 8388608) == 0) goto L97;
        JSONObject r110 = new JSONObject();
    L99:
        if ((r51 & 16777216) == 0) goto L101;
        MainTabFragment r25 = null;
    L102:
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r1 != null) goto L180;
    L107:
        if (r3 == null) goto L110;
        r110.put("click_position", r3.longValue());     // Catch: JSONException -> L105
    L110:
        if (r4 == null) goto L112;
        r110.put("current_page", r4);     // Catch: JSONException -> L105
    L112:
        if (r5 == null) goto L114;
        r110.put("previous_page", r5);     // Catch: JSONException -> L105
    L114:
        if (r6 == null) goto L116;
        r110.put("enter_method", r6);     // Catch: JSONException -> L105
    L116:
        if (r7 == null) goto L118;
        r110.put("show_from", r7);     // Catch: JSONException -> L105
    L118:
        if (r8 == null) goto L120;
        r110.put("tab_name", r8);     // Catch: JSONException -> L105
    L120:
        if (r9 == null) goto L122;
        r110.put("tab_position", r9.intValue());     // Catch: JSONException -> L105
    L122:
        if (r10 == null) goto L124;
        r110.put("cell_name", r10);     // Catch: JSONException -> L105
    L124:
        if (r11 == null) goto L126;
        r110.put("cell_position", r11.intValue());     // Catch: JSONException -> L105
    L126:
        if (r12 == null) goto L128;
        r110.put("click_type", r12);     // Catch: JSONException -> L105
    L128:
        if (r13 == null) goto L130;
        r110.put("bot_id", r13);     // Catch: JSONException -> L105
    L130:
        if (r24 == 0) goto L133;
        r110.put("camera_status", r24);     // Catch: JSONException -> L105
    L133:
        if (r14 != null) goto L135;
    L138:
        boolean r52 = true;
    L140:
        if (r52 == false) goto L142;
        r110.put("is_blue_highlight", "0");     // Catch: JSONException -> L105
    L143:
        if (r15 != 0) goto L145;
    L146:
        r22 = true;
    L148:
        if (r22 == false) goto L150;
        r110.put("is_delete_icon", "0");     // Catch: JSONException -> L105
    L151:
        if (r210 == null) goto L153;
        r110.put("notice_cnt", r210.intValue());     // Catch: JSONException -> L105
    L153:
        String r0 = r17;
        if (r0 == null) goto L156;
        r110.put("notice_type", r0);     // Catch: JSONException -> L105
    L156:
        String r53 = r18;
        if (r53 == null) goto L159;
        r110.put("show_cnt", r53);     // Catch: JSONException -> L105
    L159:
        String r54 = r19;
        if (r54 == null) goto L162;
        r110.put("user_case_item_id", r54);     // Catch: JSONException -> L105
    L162:
        String r55 = r20;
        if (r55 == null) goto L165;
        r110.put("user_case_reco_request_id", r55);     // Catch: JSONException -> L105
    L165:
        String r56 = r21;
        if (r56 == null) goto L168;
        r110.put("user_case_title", r56);     // Catch: JSONException -> L105
    L168:
        r110.put("if_check_box_show", r23 ? 1 : 0);     // Catch: JSONException -> L105
        if (r16 == false) goto L171;
        String r57 = "checked";
    L172:
        r110.put("check_box_status", r57);     // Catch: JSONException -> L105
    L175:
        TrackParams r58 = new TrackParams().merge(r110);
        by7.a r59 = new by7.a("navigation_tab_click");
        MainTabFragment r60 = r25;
        if (r60 == null) goto L178;
        r59.b = r60;
    L178:
        r59.a.merge(r58);
        r59.b();
        return;
    L105:
        e = move-exception;
        FLogger.a.e("NavigationEventHelper", "error in NavigationEventHelper navigationTabClick " + e.getLocalizedMessage());
        goto L175
    L171:
        r57 = "unchecked";
        goto L172
    L150:
        r110.put("is_delete_icon", r15);     // Catch: JSONException -> L105
        goto L151
    L145:
        if (r15.length() != 0) goto L148;
    L142:
        r110.put("is_blue_highlight", r14);     // Catch: JSONException -> L105
        goto L143
    L135:
        if (r14.length() == 0) goto L138;
        r52 = false;
        goto L140
    L180:
        r110.put("click_from", r1);     // Catch: JSONException -> L105
        goto L107
    L101:
        r25 = r50;
        goto L102
    L97:
        r110 = r49;
        goto L99
    L93:
        r24 = r48;
        goto L95
    L89:
        r16 = r47;
        goto L90
    L85:
        r23 = r46;
        goto L87
    L81:
        r21 = r45;
        goto L82
    L77:
        r20 = r44;
        goto L79
    L73:
        r19 = r43;
        goto L75
    L69:
        r18 = r42;
        goto L71
    L65:
        r17 = r41;
        goto L67
    L61:
        r2 = r40;
        goto L63
    L57:
        r15 = r39;
        goto L59
    L53:
        r14 = r38;
        goto L55
    L49:
        r13 = r37;
        goto L51
    L45:
        r12 = r36;
        goto L47
    L41:
        r11 = r35;
        goto L43
    L37:
        r10 = r34;
        goto L39
    L33:
        r9 = r33;
        goto L35
    L29:
        r8 = r32;
        goto L31
    L25:
        r7 = r31;
        goto L27
    L21:
        r6 = r30;
        goto L23
    L17:
        r5 = r29;
        goto L19
    L13:
        r4 = r28;
        goto L15
    L9:
        r3 = r27;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }
}
