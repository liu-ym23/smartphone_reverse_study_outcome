package j7;

import android.net.Uri;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.android.annie.container.dialog.j;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.schema.param.GravityType;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.sdk.d;
import com.bytedance.ies.bullet.service.sdk.e;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w26.g;
import y36.i;
import y36.n;
import y36.p;
import y36.r;
import y36.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends e {

    /* JADX INFO: renamed from: j7.a$a, reason: collision with other inner class name */
    public static final class C0168a {
    }

    static {
    }

    public final String getName() {
        return "AnnieXLive";
    }

    public a() {
    }

    public final boolean b(d r26) {
        Intrinsics.checkNotNullParameter(r26, "schemaData");
        String r1 = r26.e;
        if (r1 != null) goto L5;
    L10:
        String r10 = (String) ((i) new p(r26, "loader_name", "")).b;
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        if ((!StringsKt.isBlank(r10)) == true) goto L16;
    L18:
        String r11 = (String) ((i) new p(r26, com.bytedance.android.ec.core.event.a.KEY_URL, "")).b;
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        boolean r12 = r26.g();
        if (r12 != true) goto L24;
        c(r26, d(r11, AnnieConfigSettingKeys.ANNIE_FOREST_LOADER_DISALLOW_LIST_WEB.a()));
    L26:
        Boolean r13 = Boolean.TRUE;
        r26.a("use_piper_data", new y36.a(r13), false);
        r26.a("web_over_scroll_mode", new y36.d(2), false);
        p r14 = new p(r26, com.bytedance.android.ec.core.event.a.KEY_URL, null);
        Map r15 = x26.a.a;
        g r16 = (g) x26.a.a(g.class);
        if (r16 == null) goto L31;
        w26.e r17 = (w26.e) r16.n0(w26.e.class);
        if (r17 == null) goto L31;
        boolean r18 = Intrinsics.areEqual(r17.e2(), Boolean.FALSE);
    L32:
        r26.a("annie_x_url", r14, !r18);
        r26.a("use_argb", new y36.a(r13), true);
        Boolean r19 = (Boolean) ((i) new y36.a(r26, "disable_back_press", null)).b;
        if (r19 == null) goto L35;
        r26.a("block_back_press", new y36.a(Boolean.valueOf(r19.booleanValue())), false);
    L35:
        Boolean r20 = (Boolean) ((i) new y36.a(r26, "forbid_right_back", null)).b;
        if (r20 == null) goto L38;
        r26.a("block_back_press", new y36.a(Boolean.valueOf(r20.booleanValue())), false);
    L38:
        String r21 = (String) ((i) new p(r26, com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, "")).b;
        if (r21 != null) goto L41;
    L46:
        Boolean r22 = (Boolean) ((i) new y36.a(r26, "auto_show_nav_bar", null)).b;
        String r110 = "hide_nav_bar";
        if (r22 == null) goto L49;
        r26.a("hide_nav_bar", new y36.a(Boolean.valueOf(!r22.booleanValue())), false);
    L49:
        Boolean r23 = (Boolean) ((i) new y36.a(r26, "ignore_cache_policy", null)).b;
        if (Intrinsics.areEqual(r23, r13) == false) goto L52;
        r26.a("bundle_load_no_cache", new y36.a(r13), false);
    L55:
        Boolean r24 = (Boolean) ((i) new y36.a(r26, "enable_pull_down_close", null)).b;
        if (r24 == null) goto L58;
        r26.a("pull_down_close", new y36.a(Boolean.valueOf(r24.booleanValue())), false);
    L58:
        Boolean r25 = (Boolean) ((i) new y36.a(r26, "hide_poster", null)).b;
        if (r25 == null) goto L61;
        r26.a("hide_system_video_poster", new y36.a(Boolean.valueOf(r25.booleanValue())), false);
    L61:
        Integer r27 = (Integer) ((i) new y36.d(r26, "lynx_thread", 0)).b;
        if (r27 == null) goto L64;
        r26.a("thread_strategy", new y36.d(Integer.valueOf(r27.intValue())), false);
    L64:
        String r28 = (String) ((i) new p(r26, com.bytedance.android.ec.core.event.a.KEY_BUSINESS_TYPE, "anniex-live-" + System.currentTimeMillis() + '-' + UUID.randomUUID())).b;
        if (r28 == null) goto L67;
        r26.a("group", new p(r28), false);
    L67:
        Boolean r29 = (Boolean) ((i) new y36.a(r26, "create_view_sync", Boolean.FALSE)).b;
        if (r29 == null) goto L70;
        r26.a("create_view_async", new y36.a(Boolean.valueOf(r29.booleanValue())), false);
    L70:
        Boolean r30 = (Boolean) ((i) new y36.a(r26, "bundle_live_webview_offline_enable", r13)).b;
        if (r30 == null) goto L73;
        r26.a("disable_offline", new y36.a(Boolean.valueOf(!r30.booleanValue())), false);
    L73:
        Integer r31 = (Integer) ((i) new y36.d(r26, "android_soft_input_mode", null)).b;
        if (r31 == null) goto L83;
        int r32 = r31.intValue();
        SoftInputMode.Companion.getClass();
        SoftInputMode[] r111 = SoftInputMode.values();
        int r112 = r111.length;
        int r113 = 0;
    L76:
        if (r113 >= r112) goto L81;
        SoftInputMode r114 = r111[r113];
        if (r114.getSystemValue() == r32) goto L79;
        r113 = r113 + 1;
        goto L76
    L79:
        SoftInputMode r33 = r114;
    L82:
        r26.a("soft_input_mode", new n(r33), false);
        goto L83
    L81:
        r33 = null;
    L83:
        Boolean r34 = Boolean.FALSE;
        Object r35 = ((i) new y36.a(r26, "create_by_router", r34)).b;
        Boolean r36 = Boolean.TRUE;
        if (Intrinsics.areEqual(r35, r36) == false) goto L86;
        r26.a("is_real_fullscreen", new y36.a(r36), false);
    L86:
        Boolean r37 = (Boolean) ((i) new y36.a(r26, "use_real_screen_height", r34)).b;
        if (r37 == null) goto L90;
        r26.a("use_screen_height", new y36.a(Boolean.valueOf(r37.booleanValue())), false);
    L90:
        if (Intrinsics.areEqual(((i) new y36.a(r26, "support_exchange_theme", r34)).b, r36) == false) goto L101;
        int r38 = com.bytedance.android.annie.container.fragment.n.a;
        String r39 = (String) ((i) new p(r26, "status_bar_color", "")).b;
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r40 = com.bytedance.android.annie.ng.e.a;
        String r41 = com.bytedance.android.annie.container.fragment.n.b(r39, r40.k);
        if (Intrinsics.areEqual(r41, IHostContextDepend.SKIN_TYPE_BLACK) == false) goto L95;
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.DARK), false);
    L98:
        com.bytedance.android.annie.ng.g.b().getClass();
        if (r40.k == false) goto L102;
        r26.a("is_host_status_bar_light", new y36.a(r36), true);
    L102:
        String r42 = (String) ((i) new p(r26, "status_bar_color", "")).b;
        if (Intrinsics.areEqual(r42, IHostContextDepend.SKIN_TYPE_BLACK) == false) goto L106;
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.DARK), false);
    L109:
        String r43 = (String) ((i) new p(r26, "status_font_mode", "")).b;
        if (Intrinsics.areEqual(r43, "dark") == false) goto L113;
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.DARK), false);
    L117:
        if (((i) new r(r26, "web_bg_color")).b == null) goto L119;
    L123:
        Boolean r44 = (Boolean) ((i) new y36.a(r26, "show_close", r34)).b;
        if (r44 == null) goto L126;
        r26.a("show_closeall", new y36.a(Boolean.valueOf(r44.booleanValue())), false);
    L126:
        Boolean r45 = (Boolean) ((i) new y36.a(r26, "bundle_user_webview_title", r34)).b;
        if (r45 == null) goto L129;
        r26.a("use_webview_title", new y36.a(Boolean.valueOf(r45.booleanValue())), false);
    L129:
        String r46 = (String) ((i) new p(r26, "page_tag", null)).b;
        if (r46 != null) goto L135;
        Uri r47 = (Uri) ((i) new s(r26, "annie_x_url")).b;
        if (r47 == null) goto L134;
        r46 = r47.getHost() + r47.getPath();
        goto L135
    L134:
        r46 = null;
    L135:
        if (r46 == null) goto L137;
        r26.a("bdx_tag", new p(r46), false);
    L137:
        String r48 = (String) ((i) new p(r26, "launch_mode", null)).b;
        if (r48 == null) goto L141;
        r26.a("bdx_launch_mode", new p(r48), false);
    L141:
        if (((i) new p26.a(r26, null)).b != GravityType.BOTTOM) goto L148;
        Integer r49 = (Integer) ((i) new y36.d(r26, "is_already_adaptation_ui", 0)).b;
        if (r49 == null) goto L148;
        if (r49.intValue() != 0) goto L148;
        com.bytedance.android.annie.util.p r50 = com.bytedance.android.annie.util.p.a;
        r26.a("width", new y36.d(Integer.valueOf((int) r50.h(r50.e()))), true);
    L148:
        Integer r51 = (Integer) ((i) new y36.d(r26, "use_player_bottom_height", 0)).b;
        if (r51 == null) goto L151;
        r26.a("use_player_bottom_height", new y36.d(Integer.valueOf(r51.intValue())), false);
    L151:
        Integer r52 = (Integer) ((i) new y36.d(r26, "use_player_bottom_height", 0)).b;
        if (r52 == null) goto L154;
        r26.a("pad_use_player_bottom_height", new y36.d(Integer.valueOf(r52.intValue())), false);
    L154:
        String r53 = (String) ((i) new p(r26, "show_from", "")).b;
        if (r53 == null) goto L157;
        r26.a("popup_type", new p(r53), false);
    L157:
        String r54 = (String) ((i) new p(r26, com.bytedance.android.ec.core.event.a.KEY_URL, "")).b;
        if (r54 != null) goto L160;
    L162:
        String r55 = (String) ((i) new p(r26, "width", "")).b;
        if (r55 != null) goto L165;
    L167:
        String r56 = (String) ((i) new p(r26, "height", "")).b;
        if (r56 != null) goto L170;
    L172:
        Integer r57 = (Integer) ((i) new y36.d(r26, "preset_width", null)).b;
        if (r57 == null) goto L175;
        r26.a("lynx_preset_width", new y36.d(Integer.valueOf(r57.intValue())), false);
    L175:
        Integer r58 = (Integer) ((i) new y36.d(r26, "preset_height", null)).b;
        if (r58 == null) goto L179;
        r26.a("lynx_preset_height", new y36.d(Integer.valueOf(r58.intValue())), false);
    L179:
        if (h.u() == false) goto L186;
        if (Intrinsics.areEqual(((i) new p(r26, "type", "")).b, "fullscreen") == true) goto L186;
        String r59 = r110;
        Boolean r60 = (Boolean) ((i) new y36.a(r26, r59, r36)).b;
        if (r60 == null) goto L186;
        r26.a(r59, new y36.a(Boolean.valueOf(r60.booleanValue())), false);
    L186:
        if (Intrinsics.areEqual(((i) new y36.a(r26, "up_full_screen", r34)).b, r36) == false) goto L203;
        Integer r61 = (Integer) ((i) new y36.d(r26, "close_icon_position", 0)).b;
        if (r61 != null) goto L191;
    L192:
        boolean r115 = true;
    L194:
        r26.a("show_closeall", new y36.a(Boolean.valueOf(r115)), true);
        if (r61 != null) goto L198;
    L200:
        boolean r62 = false;
    L201:
        r26.a("close_position_right", new y36.a(Boolean.valueOf(r62)), false);
        r26.a("is_pull_up_popup", new y36.a(r36), false);
        goto L203
    L198:
        if (r61.intValue() != 1) goto L200;
        r62 = true;
        goto L201
    L191:
        if (r61.intValue() != (-1)) goto L192;
        r115 = false;
    L203:
        if (Intrinsics.areEqual((String) ((i) new p(r26, "type", null)).b, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L220;
        Boolean r63 = (Boolean) ((i) new y36.a(r26, "pad_use_phone_size", r34)).b;
        if (r63 == null) goto L207;
        boolean r64 = r63.booleanValue();
    L208:
        if (r64 == true) goto L220;
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L214;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == true) goto L214;
    L215:
        r26.a("width_percent", new y36.d(0), true);
        if (h.d() == true) goto L218;
        r26.a("height_percent", new y36.d(0), true);
    L218:
        r26.a("popup_type", new p("right"), false);
    L214:
        if (com.bytedance.android.annie.ng.g.b().b.d == false) goto L220;
    L207:
        r64 = false;
    L220:
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ENABLE_WEBCAST_SCHEMA_REMOVE_SURL.a(), r36) == false) goto L226;
        r26.i("surl");
        return true;
    L226:
        return true;
    L170:
        if (StringsKt.contains$default(r56, "%", false, 2, null) == false) goto L172;
        r26.a("height_percent", new y36.d(Integer.valueOf(CastIntegerProtector.parseInt(StringsKt.replace$default(r56, "%", "", false, 4, null)))), false);
        goto L172
    L165:
        if (StringsKt.contains$default(r55, "%", false, 2, null) == false) goto L167;
        r26.a("width_percent", new y36.d(Integer.valueOf(CastIntegerProtector.parseInt(StringsKt.replace$default(r55, "%", "", false, 4, null)))), false);
        goto L167
    L160:
        if (j.a(r54) == false) goto L162;
        r26.a("pull_down_close", new y36.a(r36), false);
        goto L162
    L119:
        if (((i) new r(r26, "bundle_web_bg_color")).b == null) goto L123;
        Integer r65 = (Integer) ((i) new r(r26, "bundle_web_bg_color")).b;
        if (r65 == null) goto L123;
        r26.a("web_bg_color", new r(Integer.valueOf(r65.intValue())), false);
        goto L123
    L113:
        if (Intrinsics.areEqual(r43, "light") == false) goto L115;
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.LIGHT), false);
        goto L117
    L115:
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.DEFAULT), false);
        goto L117
    L106:
        if (Intrinsics.areEqual(r42, IHostContextDepend.SKIN_TYPE_WHITE) == false) goto L108;
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.LIGHT), false);
        goto L109
    L108:
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.DEFAULT), false);
        goto L109
    L95:
        if (Intrinsics.areEqual(r41, IHostContextDepend.SKIN_TYPE_WHITE) == false) goto L97;
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.LIGHT), false);
        goto L98
    L97:
        r26.a("status_font_mode", new com.bytedance.ies.bullet.service.sdk.param.a(StatusFontMode.DEFAULT), false);
        goto L98
    L101:
        r110 = "hide_nav_bar";
        goto L102
    L52:
        Boolean r116 = Boolean.FALSE;
        if (Intrinsics.areEqual(r23, r116) == false) goto L55;
        r26.a("bundle_enable_app_cache", new y36.a(r116), false);
        goto L55
    L41:
        if (Intrinsics.areEqual(r21, "deeplink") == true) goto L44;
        r21 = null;
    L44:
        if (r21 == null) goto L46;
        r26.a("is_out_url", new p("is_from_out_scene"), false);
    L31:
        r18 = false;
        goto L32
    L24:
        if (r12 == true) goto L26;
        c(r26, d(r11, AnnieConfigSettingKeys.ANNIE_FOREST_LOADER_DISALLOW_LIST_LYNX.a()));
        goto L26
    L16:
        if (Intrinsics.areEqual(r10, "forest") == true) goto L18;
    L5:
        if (StringsKt.contains$default(r1, "lynxview", false, 2, null) == false) goto L8;
        Intrinsics.checkNotNullParameter("lynxview", "path");
        r26.e = "lynxview";
        goto L10
    L8:
        if (StringsKt.contains$default(r1, "webview", false, 2, null) == false) goto L10;
        Intrinsics.checkNotNullParameter("webview", "path");
        r26.e = "webview";
        goto L10
    }

    public static void c(d r10, boolean r11) {
        String r1 = "";
        if (r11 == true) goto L5;
        r10.a("loader_name", new p("forest"), true);
        String r12 = (String) ((i) new p(r10, com.bytedance.android.ec.core.event.a.KEY_URL, "")).b;
        if (r12 == null) goto L12;
        r1 = r12;
    L12:
        if (d(r1, AnnieConfigSettingKeys.ANNIE_LOADER_TTNET_ENGINE_DISALLOW_LIST.a()) == false) goto L14;
        r10.a("forest_download_engine", new p("downloader"), true);
        return;
    L14:
        r10.a("forest_download_engine", new p("ttnet"), true);
        return;
    L5:
        if (Intrinsics.areEqual(((i) new p(r10, "loader_name", "")).b, "forest") == false) goto L16;
        r10.i("loader_name");
        return;
    }

    public static boolean d(String r10, List r11) {
        Iterator r12 = r11.iterator();
    L3:
        Object r13 = null;
        if (r12.hasNext() == false) goto L8;
        Object r0 = r12.next();
        if (StringsKt.contains$default(r10, (String) r0, false, 2, null) == false) goto L3;
        r13 = r0;
    L8:
        if (r13 == null) goto L14;
        return true;
    L14:
        return false;
    }
}
