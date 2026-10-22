package com.bytedance.android.annie.scheme.helper;

import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r10, Object r11, CardParamVoNew r12) {
        b(r10, r11, r12);
        Boolean r1 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        Boolean r16 = null;
        Boolean r17 = null;
        PageType r18 = null;
        Boolean r19 = null;
        Boolean r20 = null;
        Boolean r21 = null;
        String r22 = null;
        Boolean r23 = null;
        String r24 = null;
        Boolean r25 = null;
        Boolean r26 = null;
        String r27 = null;
        Boolean r28 = null;
        switch(r10.hashCode()) {
            case -1786654558: goto L134;
            case -1763635643: goto L126;
            case -1547314257: goto L118;
            case -994846351: goto L110;
            case -12378297: goto L102;
            case 109254796: goto L94;
            case 143821548: goto L86;
            case 245002646: goto L78;
            case 513905088: goto L70;
            case 604333860: goto L62;
            case 732733489: goto L54;
            case 883893994: goto L46;
            case 1065093234: goto L38;
            case 1077502526: goto L30;
            case 1085069613: goto L22;
            case 1466602694: goto L14;
            case 1611307821: goto L6;
            default: goto L175;
        };
    L175:
        return;
    L6:
        if (r10.equals("wap_headers") == true) goto L9;
        return;
    L9:
        if ((r11 instanceof String) == false) goto L11;
        r13 = (String) r11;
    L11:
        if (r13 == null) goto L142;
        r12.e1(r13);
        return;
    L142:
        return;
    L14:
        if (r10.equals("forest_session_id") == true) goto L17;
        return;
    L17:
        if ((r11 instanceof String) == false) goto L19;
        r14 = (String) r11;
    L19:
        if (r14 == null) goto L144;
        r12.d1(r14);
        return;
    L144:
        return;
    L22:
        if (r10.equals("referer") == true) goto L25;
        return;
    L25:
        if ((r11 instanceof String) == false) goto L27;
        r15 = (String) r11;
    L27:
        if (r15 == null) goto L146;
        r12.o1(r15);
        return;
    L146:
        return;
    L30:
        if (r10.equals("screen_size_adaptation") == true) goto L33;
        return;
    L33:
        if ((r11 instanceof Boolean) == false) goto L35;
        r16 = (Boolean) r11;
    L35:
        if (r16 == null) goto L148;
        r12.s1(r16.booleanValue());
        return;
    L148:
        return;
    L38:
        if (r10.equals("create_view_sync") == true) goto L41;
        return;
    L41:
        if ((r11 instanceof Boolean) == false) goto L43;
        r17 = (Boolean) r11;
    L43:
        if (r17 == null) goto L150;
        r12.O0(r17.booleanValue());
        return;
    L150:
        return;
    L46:
        if (r10.equals(com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE) == true) goto L49;
        return;
    L49:
        if ((r11 instanceof PageType) == false) goto L51;
        r18 = (PageType) r11;
    L51:
        if (r18 == null) goto L152;
        r12.l1(r18);
        return;
    L152:
        return;
    L54:
        if (r10.equals("disable_thread_spread") == true) goto L57;
        return;
    L57:
        if ((r11 instanceof Boolean) == false) goto L59;
        r19 = (Boolean) r11;
    L59:
        if (r19 == null) goto L154;
        r12.S0(r19.booleanValue());
        return;
    L154:
        return;
    L62:
        if (r10.equals("hide_system_video_poster") == true) goto L65;
        return;
    L65:
        if ((r11 instanceof Boolean) == false) goto L67;
        r20 = (Boolean) r11;
    L67:
        if (r20 == null) goto L156;
        r12.f1(r20.booleanValue());
        return;
    L156:
        return;
    L70:
        if (r10.equals("bundle_load_no_cache") == true) goto L73;
        return;
    L73:
        if ((r11 instanceof Boolean) == false) goto L75;
        r21 = (Boolean) r11;
    L75:
        if (r21 == null) goto L158;
        r12.g1(r21.booleanValue());
        return;
    L158:
        return;
    L78:
        if (r10.equals("enable_font_scale") == true) goto L81;
        return;
    L81:
        if ((r11 instanceof String) == false) goto L83;
        r22 = (String) r11;
    L83:
        if (r22 == null) goto L160;
        r12.Z0(r22);
        return;
    L160:
        return;
    L86:
        if (r10.equals("enable_code_cache") == true) goto L89;
        return;
    L89:
        if ((r11 instanceof Boolean) == false) goto L91;
        r23 = (Boolean) r11;
    L91:
        if (r23 == null) goto L162;
        r12.X0(r23.booleanValue());
        return;
    L162:
        return;
    L94:
        if (r10.equals("scene") == true) goto L97;
        return;
    L97:
        if ((r11 instanceof String) == false) goto L99;
        r24 = (String) r11;
    L99:
        if (r24 == null) goto L164;
        r12.r1(r24);
        return;
    L164:
        return;
    L102:
        if (r10.equals("disable_host_jsb_method") == true) goto L105;
        return;
    L105:
        if ((r11 instanceof Boolean) == false) goto L107;
        r25 = (Boolean) r11;
    L107:
        if (r25 == null) goto L166;
        r12.R0(r25.booleanValue());
        return;
    L166:
        return;
    L110:
        if (r10.equals("enable_view_zoom") == true) goto L113;
        return;
    L113:
        if ((r11 instanceof Boolean) == false) goto L115;
        r26 = (Boolean) r11;
    L115:
        if (r26 == null) goto L168;
        r12.c1(r26.booleanValue());
        return;
    L168:
        return;
    L118:
        if (r10.equals("monitor_report_perf") == true) goto L121;
        return;
    L121:
        if ((r11 instanceof String) == false) goto L123;
        r27 = (String) r11;
    L123:
        if (r27 == null) goto L170;
        r12.h1(r27);
        return;
    L170:
        return;
    L126:
        if (r10.equals("bundle_enable_app_cache") == true) goto L129;
        return;
    L129:
        if ((r11 instanceof Boolean) == false) goto L131;
        r28 = (Boolean) r11;
    L131:
        if (r28 == null) goto L172;
        r12.T0(r28.booleanValue());
        return;
    L172:
        return;
    L134:
        if (r10.equals("lock_resource") == true) goto L137;
        return;
    L137:
        if ((r11 instanceof Boolean) == false) goto L139;
        r1 = (Boolean) r11;
    L139:
        if (r1 == null) goto L174;
        r12.b1(r1.booleanValue());
        return;
    }

    public static void b(String r10, Object r11, BaseHybridParamVoNew r12) {
        Boolean r13 = null;
        Integer r14 = null;
        String r15 = null;
        Boolean r16 = null;
        String r17 = null;
        String r18 = null;
        Integer r19 = null;
        Boolean r20 = null;
        String r21 = null;
        String r22 = null;
        Boolean r23 = null;
        String r24 = null;
        Boolean r25 = null;
        String r26 = null;
        Integer r27 = null;
        String r28 = null;
        switch(r10.hashCode()) {
            case -1896450665: goto L126;
            case -1880523916: goto L118;
            case -1787150207: goto L110;
            case -1782949230: goto L102;
            case -1458885277: goto L94;
            case 116079: goto L86;
            case 204103253: goto L78;
            case 285033136: goto L70;
            case 292113626: goto L62;
            case 393688809: goto L54;
            case 460826418: goto L46;
            case 515866351: goto L38;
            case 620959543: goto L30;
            case 1447687381: goto L22;
            case 1886447384: goto L14;
            case 2024053914: goto L6;
            default: goto L165;
        };
    L165:
        return;
    L6:
        if (r10.equals("gradient_color_percent") == true) goto L9;
        return;
    L9:
        if ((r11 instanceof Integer) == false) goto L11;
        r14 = (Integer) r11;
    L11:
        if (r14 == null) goto L134;
        r12.N(r14.intValue());
        return;
    L134:
        return;
    L14:
        if (r10.equals("gradient_bg_color") == true) goto L17;
        return;
    L17:
        if ((r11 instanceof String) == false) goto L19;
        r15 = (String) r11;
    L19:
        if (r15 == null) goto L136;
        r12.M(r15);
        return;
    L136:
        return;
    L22:
        if (r10.equals("live_enable_view_remove") == true) goto L25;
        return;
    L25:
        if ((r11 instanceof Boolean) == false) goto L27;
        r16 = (Boolean) r11;
    L27:
        if (r16 == null) goto L138;
        r12.J(r16.booleanValue());
        return;
    L138:
        return;
    L30:
        if (r10.equals("loader_name") == true) goto L33;
        return;
    L33:
        if ((r11 instanceof String) == false) goto L35;
        r17 = (String) r11;
    L35:
        if (r17 == null) goto L140;
        r12.R(r17);
        return;
    L140:
        return;
    L38:
        if (r10.equals("_open_container_id") == true) goto L41;
        return;
    L41:
        if ((r11 instanceof String) == false) goto L43;
        r18 = (String) r11;
    L43:
        if (r18 == null) goto L142;
        r12.S(r18);
        return;
    L142:
        return;
    L46:
        if (r10.equals("lynx_thread") == true) goto L49;
        return;
    L49:
        if ((r11 instanceof Integer) == false) goto L51;
        r19 = (Integer) r11;
    L51:
        if (r19 == null) goto L144;
        r12.D = r19.intValue();
        return;
    L144:
        return;
    L54:
        if (r10.equals("is_out_url") == true) goto L57;
        return;
    L57:
        if ((r11 instanceof Boolean) == false) goto L59;
        r20 = (Boolean) r11;
    L59:
        if (r20 == null) goto L146;
        r12.W(Boolean.valueOf(r20.booleanValue()));
        return;
    L146:
        return;
    L62:
        if (r10.equals("origin_schema") == true) goto L65;
        return;
    L65:
        if ((r11 instanceof String) == false) goto L67;
        r21 = (String) r11;
    L67:
        if (r21 == null) goto L148;
        r12.U(r21);
        return;
    L148:
        return;
    L70:
        if (r10.equals("error_page_theme") == true) goto L73;
        return;
    L73:
        if ((r11 instanceof String) == false) goto L75;
        r22 = (String) r11;
    L75:
        if (r22 == null) goto L150;
        r12.K(r22);
        return;
    L150:
        return;
    L78:
        if (r10.equals("pull_down_close") == true) goto L81;
        return;
    L81:
        if ((r11 instanceof Boolean) == false) goto L83;
        r23 = (Boolean) r11;
    L83:
        if (r23 == null) goto L152;
        r12.Y(r23.booleanValue());
        return;
    L152:
        return;
    L86:
        if (r10.equals(com.bytedance.android.ec.core.event.a.KEY_URL) == true) goto L89;
        return;
    L89:
        if ((r11 instanceof String) == false) goto L91;
        r24 = (String) r11;
    L91:
        if (r24 == null) goto L154;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r12.b = r24;
        return;
    L154:
        return;
    L94:
        if (r10.equals("hide_status_bar") == true) goto L97;
        return;
    L97:
        if ((r11 instanceof Boolean) == false) goto L99;
        r25 = (Boolean) r11;
    L99:
        if (r25 == null) goto L156;
        r12.O(r25.booleanValue());
        return;
    L156:
        return;
    L102:
        if (r10.equals("fallback_url") == true) goto L105;
        return;
    L105:
        if ((r11 instanceof String) == false) goto L107;
        r26 = (String) r11;
    L107:
        if (r26 == null) goto L158;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r12.c = r26;
        return;
    L158:
        return;
    L110:
        if (r10.equals("preset_width_px") == true) goto L113;
        return;
    L113:
        if ((r11 instanceof Integer) == false) goto L115;
        r27 = (Integer) r11;
    L115:
        if (r27 == null) goto L160;
        r12.y = r27.intValue();
        return;
    L160:
        return;
    L118:
        if (r10.equals("web_bg_color") == true) goto L121;
        return;
    L121:
        if ((r11 instanceof String) == false) goto L123;
        r28 = (String) r11;
    L123:
        if (r28 == null) goto L162;
        r12.a0(r28);
        return;
    L162:
        return;
    L126:
        if (r10.equals("_close_after_open_success") == true) goto L129;
        return;
    L129:
        if ((r11 instanceof Boolean) == false) goto L131;
        r13 = (Boolean) r11;
    L131:
        if (r13 == null) goto L164;
        r12.I(r13.booleanValue());
        return;
    }

    public static void c(String r10, Object r11, FragmentParamVoNew r12) {
        a(r10, r11, r12);
        Float r1 = null;
        Integer r13 = null;
        Boolean r14 = null;
        Integer r15 = null;
        Boolean r16 = null;
        Boolean r17 = null;
        Boolean r18 = null;
        Boolean r19 = null;
        String r20 = null;
        Boolean r21 = null;
        Boolean r22 = null;
        String r23 = null;
        Boolean r24 = null;
        String r25 = null;
        Boolean r26 = null;
        String r27 = null;
        Integer r28 = null;
        Boolean r29 = null;
        String r30 = null;
        String r31 = null;
        Boolean r32 = null;
        Boolean r33 = null;
        Boolean r34 = null;
        Boolean r35 = null;
        Boolean r36 = null;
        Boolean r37 = null;
        Boolean r38 = null;
        Boolean r39 = null;
        String r40 = null;
        Boolean r41 = null;
        Boolean r42 = null;
        switch(r10.hashCode()) {
            case -1933416097: goto L246;
            case -1907769275: goto L238;
            case -1903871767: goto L230;
            case -1707868953: goto L222;
            case -1377184773: goto L214;
            case -1344837085: goto L206;
            case -1120890771: goto L198;
            case -1102511297: goto L190;
            case -749844516: goto L182;
            case -672179027: goto L174;
            case -663792423: goto L166;
            case -518520834: goto L158;
            case -243025584: goto L150;
            case -230283601: goto L142;
            case -221187375: goto L134;
            case -153741693: goto L126;
            case 110371416: goto L118;
            case 290925818: goto L110;
            case 391608362: goto L102;
            case 575474545: goto L94;
            case 637387970: goto L86;
            case 798979869: goto L78;
            case 801943221: goto L70;
            case 859795946: goto L62;
            case 966266599: goto L54;
            case 1110780470: goto L46;
            case 1360639344: goto L38;
            case 1499312656: goto L30;
            case 1698019933: goto L22;
            case 1715384783: goto L14;
            case 1870141457: goto L6;
            default: goto L315;
        };
    L315:
        return;
    L6:
        if (r10.equals("bundle_web_bg_color") == true) goto L9;
        return;
    L9:
        if ((r11 instanceof Integer) == false) goto L11;
        r13 = (Integer) r11;
    L11:
        if (r13 == null) goto L254;
        r12.k2(r13.intValue());
        return;
    L254:
        return;
    L14:
        if (r10.equals("enable_card_cache") == true) goto L17;
        return;
    L17:
        if ((r11 instanceof Boolean) == false) goto L19;
        r14 = (Boolean) r11;
    L19:
        if (r14 == null) goto L256;
        r12.o2(r14.booleanValue());
        return;
    L256:
        return;
    L22:
        if (r10.equals("android_soft_input_mode") == true) goto L25;
        return;
    L25:
        if ((r11 instanceof Integer) == false) goto L27;
        r15 = (Integer) r11;
    L27:
        if (r15 == null) goto L258;
        r12.i2(r15.intValue());
        return;
    L258:
        return;
    L30:
        if (r10.equals("is_fullScreen") == true) goto L33;
        return;
    L33:
        if ((r11 instanceof Boolean) == false) goto L35;
        r16 = (Boolean) r11;
    L35:
        if (r16 == null) goto L260;
        r12.L(r16.booleanValue());
        return;
    L260:
        return;
    L38:
        if (r10.equals("is_real_full_screen") == true) goto L41;
        return;
    L41:
        if ((r11 instanceof Boolean) == false) goto L43;
        r17 = (Boolean) r11;
    L43:
        if (r17 == null) goto L262;
        r12.E2(r17.booleanValue());
        return;
    L262:
        return;
    L46:
        if (r10.equals("show_close") == true) goto L49;
        return;
    L49:
        if ((r11 instanceof Boolean) == false) goto L51;
        r18 = (Boolean) r11;
    L51:
        if (r18 == null) goto L264;
        r12.G2(r18.booleanValue());
        return;
    L264:
        return;
    L54:
        if (r10.equals("enable_pad_adapter") == true) goto L57;
        return;
    L57:
        if ((r11 instanceof Boolean) == false) goto L59;
        r19 = (Boolean) r11;
    L59:
        if (r19 == null) goto L266;
        r12.p2(r19.booleanValue());
        return;
    L266:
        return;
    L62:
        if (r10.equals("page_tag") == true) goto L65;
        return;
    L65:
        if ((r11 instanceof String) == false) goto L67;
        r20 = (String) r11;
    L67:
        if (r20 == null) goto L268;
        r12.A2(r20);
        return;
    L268:
        return;
    L70:
        if (r10.equals("forbid_right_back") == true) goto L73;
        return;
    L73:
        if ((r11 instanceof Boolean) == false) goto L75;
        r21 = (Boolean) r11;
    L75:
        if (r21 == null) goto L270;
        r12.r2(r21.booleanValue());
        return;
    L270:
        return;
    L78:
        if (r10.equals("support_exchange_theme") == true) goto L81;
        return;
    L81:
        if ((r11 instanceof Boolean) == false) goto L83;
        r22 = (Boolean) r11;
    L83:
        if (r22 == null) goto L272;
        r12.K2(r22.booleanValue());
        return;
    L272:
        return;
    L86:
        if (r10.equals("status_bar_bg_color") == true) goto L89;
        return;
    L89:
        if ((r11 instanceof String) == false) goto L91;
        r23 = (String) r11;
    L91:
        if (r23 == null) goto L274;
        r12.I2(r23);
        return;
    L274:
        return;
    L94:
        if (r10.equals("show_float_live") == true) goto L97;
        return;
    L97:
        if ((r11 instanceof Boolean) == false) goto L99;
        r24 = (Boolean) r11;
    L99:
        if (r24 == null) goto L276;
        r12.H2(r24.booleanValue());
        return;
    L276:
        return;
    L102:
        if (r10.equals("status_bar_color") == true) goto L105;
        return;
    L105:
        if ((r11 instanceof String) == false) goto L107;
        r25 = (String) r11;
    L107:
        if (r25 == null) goto L278;
        r12.J2(r25);
        return;
    L278:
        return;
    L110:
        if (r10.equals("hide_nav_bar") == true) goto L113;
        return;
    L113:
        if ((r11 instanceof Boolean) == false) goto L115;
        r26 = (Boolean) r11;
    L115:
        if (r26 == null) goto L280;
        r12.t2(r26.booleanValue());
        return;
    L280:
        return;
    L118:
        if (r10.equals("title") == true) goto L121;
        return;
    L121:
        if ((r11 instanceof String) == false) goto L123;
        r27 = (String) r11;
    L123:
        if (r27 == null) goto L282;
        r12.L2(r27);
        return;
    L282:
        return;
    L126:
        if (r10.equals("icon_theme") == true) goto L129;
        return;
    L129:
        if ((r11 instanceof Integer) == false) goto L131;
        r28 = (Integer) r11;
    L131:
        if (r28 == null) goto L284;
        r12.v2(r28.intValue());
        return;
    L284:
        return;
    L134:
        if (r10.equals("lazy_load") == true) goto L137;
        return;
    L137:
        if ((r11 instanceof Boolean) == false) goto L139;
        r29 = (Boolean) r11;
    L139:
        if (r29 == null) goto L286;
        r12.y2(r29.booleanValue());
        return;
    L286:
        return;
    L142:
        if (r10.equals("launch_mode") == true) goto L145;
        return;
    L145:
        if ((r11 instanceof String) == false) goto L147;
        r30 = (String) r11;
    L147:
        if (r30 == null) goto L288;
        r12.x2(r30);
        return;
    L288:
        return;
    L150:
        if (r10.equals("pull_down_indicator_color") == true) goto L153;
        return;
    L153:
        if ((r11 instanceof String) == false) goto L155;
        r31 = (String) r11;
    L155:
        if (r31 == null) goto L290;
        r12.w2(r31);
        return;
    L290:
        return;
    L158:
        if (r10.equals("is_pop_up") == true) goto L161;
        return;
    L161:
        if ((r11 instanceof Boolean) == false) goto L163;
        r32 = (Boolean) r11;
    L163:
        if (r32 == null) goto L292;
        r12.B2(r32.booleanValue());
        return;
    L292:
        return;
    L166:
        if (r10.equals("disable_input_scroll") == true) goto L169;
        return;
    L169:
        if ((r11 instanceof Boolean) == false) goto L171;
        r33 = (Boolean) r11;
    L171:
        if (r33 == null) goto L294;
        r12.n2(r33.booleanValue());
        return;
    L294:
        return;
    L174:
        if (r10.equals("close_position_right") == true) goto L177;
        return;
    L177:
        if ((r11 instanceof Boolean) == false) goto L179;
        r34 = (Boolean) r11;
    L179:
        if (r34 == null) goto L296;
        r12.l2(r34.booleanValue());
        return;
    L296:
        return;
    L182:
        if (r10.equals("pull_down_indicator_not_show") == true) goto L185;
        return;
    L185:
        if ((r11 instanceof Boolean) == false) goto L187;
        r35 = (Boolean) r11;
    L187:
        if (r35 == null) goto L298;
        r12.C2(r35.booleanValue());
        return;
    L298:
        return;
    L190:
        if (r10.equals("hide_loading") == true) goto L193;
        return;
    L193:
        if ((r11 instanceof Boolean) == false) goto L195;
        r36 = (Boolean) r11;
    L195:
        if (r36 == null) goto L300;
        r12.s2(r36.booleanValue());
        return;
    L300:
        return;
    L198:
        if (r10.equals("is_pull_up_popup") == true) goto L201;
        return;
    L201:
        if ((r11 instanceof Boolean) == false) goto L203;
        r37 = (Boolean) r11;
    L203:
        if (r37 == null) goto L302;
        r12.D2(r37.booleanValue());
        return;
    L302:
        return;
    L206:
        if (r10.equals("enable_share") == true) goto L209;
        return;
    L209:
        if ((r11 instanceof Boolean) == false) goto L211;
        r38 = (Boolean) r11;
    L211:
        if (r38 == null) goto L304;
        r12.q2(r38.booleanValue());
        return;
    L304:
        return;
    L214:
        if (r10.equals("bundle_user_webview_title") == true) goto L217;
        return;
    L217:
        if ((r11 instanceof Boolean) == false) goto L219;
        r39 = (Boolean) r11;
    L219:
        if (r39 == null) goto L306;
        r39.booleanValue();
        r12.M2(((Boolean) r11).booleanValue());
        return;
    L306:
        return;
    L222:
        if (r10.equals("container_bg_color") == true) goto L225;
        return;
    L225:
        if ((r11 instanceof String) == false) goto L227;
        r40 = (String) r11;
    L227:
        if (r40 == null) goto L308;
        r12.m2(r40);
        return;
    L308:
        return;
    L230:
        if (r10.equals("show_back") == true) goto L233;
        return;
    L233:
        if ((r11 instanceof Boolean) == false) goto L235;
        r41 = (Boolean) r11;
    L235:
        if (r41 == null) goto L310;
        r12.F2(r41.booleanValue());
        return;
    L310:
        return;
    L238:
        if (r10.equals("auto_show_nav_bar") == true) goto L241;
        return;
    L241:
        if ((r11 instanceof Boolean) == false) goto L243;
        r42 = (Boolean) r11;
    L243:
        if (r42 == null) goto L312;
        r12.j2(r42.booleanValue());
        return;
    L312:
        return;
    L246:
        if (r10.equals("pad_ratio") == true) goto L249;
        return;
    L249:
        if ((r11 instanceof Float) == false) goto L251;
        r1 = (Float) r11;
    L251:
        if (r1 == null) goto L314;
        r12.z2(r1.floatValue());
        return;
    }

    @JvmStatic
    public static final void d(Object r10, String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof PopupHybridParamVoNew) == false) goto L378;
        PopupHybridParamVoNew r13 = (PopupHybridParamVoNew) r10;
        c(r11, r12, r13);
        Integer r1 = null;
        Integer r14 = null;
        Boolean r15 = null;
        Integer r16 = null;
        Integer r17 = null;
        Integer r18 = null;
        Integer r19 = null;
        Boolean r20 = null;
        Integer r21 = null;
        Boolean r22 = null;
        Integer r23 = null;
        Integer r24 = null;
        Integer r25 = null;
        String r26 = null;
        Integer r27 = null;
        Integer r28 = null;
        Boolean r29 = null;
        Integer r30 = null;
        Boolean r31 = null;
        Boolean r32 = null;
        Boolean r33 = null;
        Boolean r34 = null;
        Integer r35 = null;
        Boolean r36 = null;
        Integer r37 = null;
        Boolean r38 = null;
        Integer r39 = null;
        Boolean r40 = null;
        Integer r41 = null;
        Integer r42 = null;
        Integer r43 = null;
        Integer r44 = null;
        Integer r45 = null;
        Integer r46 = null;
        Boolean r47 = null;
        Boolean r48 = null;
        Integer r49 = null;
        Boolean r50 = null;
        Integer r51 = null;
        Integer r52 = null;
        Float r53 = null;
        Integer r54 = null;
        String r55 = null;
        Integer r56 = null;
        Integer r57 = null;
        Boolean r58 = null;
        switch(r11.hashCode()) {
            case -2128941634: goto L370;
            case -2127967371: goto L362;
            case -2126242710: goto L354;
            case -2126048564: goto L346;
            case -1910873363: goto L338;
            case -1885576152: goto L330;
            case -1623508405: goto L322;
            case -1568900271: goto L314;
            case -1567020219: goto L306;
            case -1371838820: goto L298;
            case -1369693265: goto L290;
            case -1362024143: goto L282;
            case -1319382654: goto L274;
            case -1221029593: goto L266;
            case -1198034453: goto L258;
            case -1130592979: goto L250;
            case -1114657387: goto L242;
            case -1081309778: goto L234;
            case -938578798: goto L226;
            case -886443644: goto L218;
            case -783420964: goto L210;
            case -573966911: goto L202;
            case -544400728: goto L194;
            case -502662633: goto L186;
            case -444571151: goto L178;
            case -442641634: goto L170;
            case -370010644: goto L162;
            case -338507706: goto L154;
            case -44574367: goto L146;
            case 113126854: goto L138;
            case 261938237: goto L130;
            case 280523342: goto L122;
            case 372533818: goto L114;
            case 420873502: goto L106;
            case 512141380: goto L98;
            case 543502411: goto L90;
            case 656597358: goto L82;
            case 847235192: goto L74;
            case 1082642850: goto L66;
            case 1235178289: goto L58;
            case 1318783681: goto L50;
            case 1365093645: goto L42;
            case 1630340454: goto L34;
            case 1956605077: goto L26;
            case 1993474684: goto L18;
            case 2115344153: goto L10;
            default: goto L483;
        };
    L483:
        return;
    L10:
        if (r11.equals("y_offset") == true) goto L13;
        return;
    L13:
        if ((r12 instanceof Integer) == false) goto L15;
        r14 = (Integer) r12;
    L15:
        if (r14 == null) goto L388;
        r13.z4(r14.intValue());
        return;
    L388:
        return;
    L18:
        if (r11.equals("landscape_custom_width") == true) goto L21;
        return;
    L21:
        if ((r12 instanceof Boolean) == false) goto L23;
        r15 = (Boolean) r12;
    L23:
        if (r15 == null) goto L390;
        r13.W3(r15.booleanValue());
        return;
    L390:
        return;
    L26:
        if (r11.equals("use_player_bottom_height") == true) goto L29;
        return;
    L29:
        if ((r12 instanceof Integer) == false) goto L31;
        r16 = (Integer) r12;
    L31:
        if (r16 == null) goto L392;
        r13.t4(r16.intValue());
        return;
    L392:
        return;
    L34:
        if (r11.equals("rate_height") == true) goto L37;
        return;
    L37:
        if ((r12 instanceof Integer) == false) goto L39;
        r17 = (Integer) r12;
    L39:
        if (r17 == null) goto L394;
        r13.k4(r17.intValue());
        return;
    L394:
        return;
    L42:
        if (r11.equals("horizontal_radius") == true) goto L45;
        return;
    L45:
        if ((r12 instanceof Integer) == false) goto L47;
        r18 = (Integer) r12;
    L47:
        if (r18 == null) goto L396;
        r13.R3(r18.intValue());
        return;
    L396:
        return;
    L50:
        if (r11.equals("pad_use_player_bottom_height") == true) goto L53;
        return;
    L53:
        if ((r12 instanceof Integer) == false) goto L55;
        r19 = (Integer) r12;
    L55:
        if (r19 == null) goto L398;
        r13.c4(r19.intValue());
        return;
    L398:
        return;
    L58:
        if (r11.equals("landscape_custom_height") == true) goto L61;
        return;
    L61:
        if ((r12 instanceof Boolean) == false) goto L63;
        r20 = (Boolean) r12;
    L63:
        if (r20 == null) goto L400;
        r13.V3(r20.booleanValue());
        return;
    L400:
        return;
    L66:
        if (r11.equals("horizontal_height") == true) goto L69;
        return;
    L69:
        if ((r12 instanceof Integer) == false) goto L71;
        r21 = (Integer) r12;
    L71:
        if (r21 == null) goto L402;
        r13.P3(r21.intValue());
        return;
    L402:
        return;
    L74:
        if (r11.equals("up_full_screen") == true) goto L77;
        return;
    L77:
        if ((r12 instanceof Boolean) == false) goto L79;
        r22 = (Boolean) r12;
    L79:
        if (r22 == null) goto L404;
        r13.L3(r22.booleanValue());
        return;
    L404:
        return;
    L82:
        if (r11.equals("radius_bottom_left") == true) goto L85;
        return;
    L85:
        if ((r12 instanceof Integer) == false) goto L87;
        r23 = (Integer) r12;
    L87:
        if (r23 == null) goto L406;
        r13.g4(r23.intValue());
        return;
    L406:
        return;
    L90:
        if (r11.equals("margin_right") == true) goto L93;
        return;
    L93:
        if ((r12 instanceof Integer) == false) goto L95;
        r24 = (Integer) r12;
    L95:
        if (r24 == null) goto L408;
        r13.Z3(r24.intValue());
        return;
    L408:
        return;
    L98:
        if (r11.equals("is_already_adaptation_ui") == true) goto L101;
        return;
    L101:
        if ((r12 instanceof Integer) == false) goto L103;
        r25 = (Integer) r12;
    L103:
        if (r25 == null) goto L410;
        r13.I3(r25.intValue());
        return;
    L410:
        return;
    L106:
        if (r11.equals("up_status_bar_bg_color") == true) goto L109;
        return;
    L109:
        if ((r12 instanceof String) == false) goto L111;
        r26 = (String) r12;
    L111:
        if (r26 == null) goto L412;
        r13.q4(r26);
        return;
    L412:
        return;
    L114:
        if (r11.equals("x_offset") == true) goto L117;
        return;
    L117:
        if ((r12 instanceof Integer) == false) goto L119;
        r27 = (Integer) r12;
    L119:
        if (r27 == null) goto L414;
        r13.y4(r27.intValue());
        return;
    L414:
        return;
    L122:
        if (r11.equals("gravity") == true) goto L125;
        return;
    L125:
        if ((r12 instanceof Integer) == false) goto L127;
        r28 = (Integer) r12;
    L127:
        if (r28 == null) goto L416;
        r13.M3(r28.intValue());
        return;
    L416:
        return;
    L130:
        if (r11.equals("trans_status_bar") == true) goto L133;
        return;
    L133:
        if ((r12 instanceof Boolean) == false) goto L135;
        r29 = (Boolean) r12;
    L135:
        if (r29 == null) goto L418;
        r13.Z(r29.booleanValue());
        return;
    L418:
        return;
    L138:
        if (r11.equals("width") == true) goto L141;
        return;
    L141:
        if ((r12 instanceof Integer) == false) goto L143;
        r30 = (Integer) r12;
    L143:
        if (r30 == null) goto L420;
        r13.v4(r30.intValue());
        return;
    L420:
        return;
    L146:
        if (r11.equals("up_trans_status_bar") == true) goto L149;
        return;
    L149:
        if ((r12 instanceof Boolean) == false) goto L151;
        r31 = (Boolean) r12;
    L151:
        if (r31 == null) goto L422;
        r13.r4(r31.booleanValue());
        return;
    L422:
        return;
    L154:
        if (r11.equals("show_dim") == true) goto L157;
        return;
    L157:
        if ((r12 instanceof Boolean) == false) goto L159;
        r32 = (Boolean) r12;
    L159:
        if (r32 == null) goto L424;
        boolean r59 = r32.booleanValue();
        r13.l4(r59);
        r13.m4(r59);
        return;
    L424:
        return;
    L162:
        if (r11.equals("open_animate") == true) goto L165;
        return;
    L165:
        if ((r12 instanceof Boolean) == false) goto L167;
        r33 = (Boolean) r12;
    L167:
        if (r33 == null) goto L426;
        r13.b4(r33.booleanValue());
        return;
    L426:
        return;
    L170:
        if (r11.equals("mask_click_disable") == true) goto L173;
        return;
    L173:
        if ((r12 instanceof Boolean) == false) goto L175;
        r34 = (Boolean) r12;
    L175:
        if (r34 == null) goto L428;
        r13.J3(!r34.booleanValue());
        return;
    L428:
        return;
    L178:
        if (r11.equals("horizontal_width_percent") == true) goto L181;
        return;
    L181:
        if ((r12 instanceof Integer) == false) goto L183;
        r35 = (Integer) r12;
    L183:
        if (r35 == null) goto L430;
        r13.T3(r35.intValue());
        return;
    L430:
        return;
    L186:
        if (r11.equals("allowing_state_loss") == true) goto L189;
        return;
    L189:
        if ((r12 instanceof Boolean) == false) goto L191;
        r36 = (Boolean) r12;
    L191:
        if (r36 == null) goto L432;
        r13.H3(r36.booleanValue());
        return;
    L432:
        return;
    L194:
        if (r11.equals("horizontal_height_percent") == true) goto L197;
        return;
    L197:
        if ((r12 instanceof Integer) == false) goto L199;
        r37 = (Integer) r12;
    L199:
        if (r37 == null) goto L434;
        r13.Q3(r37.intValue());
        return;
    L434:
        return;
    L202:
        if (r11.equals("disable_nested_child_scroll") == true) goto L205;
        return;
    L205:
        if ((r12 instanceof Boolean) == false) goto L207;
        r38 = (Boolean) r12;
    L207:
        if (r38 == null) goto L436;
        r13.K3(r38.booleanValue());
        return;
    L436:
        return;
    L210:
        if (r11.equals("margin_bottom") == true) goto L213;
        return;
    L213:
        if ((r12 instanceof Integer) == false) goto L215;
        r39 = (Integer) r12;
    L215:
        if (r39 == null) goto L438;
        r13.Y3(r39.intValue());
        return;
    L438:
        return;
    L218:
        if (r11.equals("landscape_custom_gravity") == true) goto L221;
        return;
    L221:
        if ((r12 instanceof Boolean) == false) goto L223;
        r40 = (Boolean) r12;
    L223:
        if (r40 == null) goto L440;
        r13.U3(r40.booleanValue());
        return;
    L440:
        return;
    L226:
        if (r11.equals("radius") == true) goto L229;
        return;
    L229:
        if ((r12 instanceof Integer) == false) goto L231;
        r41 = (Integer) r12;
    L231:
        if (r41 == null) goto L442;
        r13.f4(r41.intValue());
        return;
    L442:
        return;
    L234:
        if (r11.equals("margin") == true) goto L237;
        return;
    L237:
        if ((r12 instanceof Integer) == false) goto L239;
        r42 = (Integer) r12;
    L239:
        if (r42 == null) goto L444;
        r13.X3(r42.intValue());
        return;
    L444:
        return;
    L242:
        if (r11.equals("radius_bottom_right") == true) goto L245;
        return;
    L245:
        if ((r12 instanceof Integer) == false) goto L247;
        r43 = (Integer) r12;
    L247:
        if (r43 == null) goto L446;
        r13.h4(r43.intValue());
        return;
    L446:
        return;
    L250:
        if (r11.equals("height_percent") == true) goto L253;
        return;
    L253:
        if ((r12 instanceof Integer) == false) goto L255;
        r44 = (Integer) r12;
    L255:
        if (r44 == null) goto L448;
        r13.O3(r44.intValue());
        return;
    L448:
        return;
    L258:
        if (r11.equals("horizontal_width") == true) goto L261;
        return;
    L261:
        if ((r12 instanceof Integer) == false) goto L263;
        r45 = (Integer) r12;
    L263:
        if (r45 == null) goto L450;
        r13.S3(r45.intValue());
        return;
    L450:
        return;
    L266:
        if (r11.equals("height") == true) goto L269;
        return;
    L269:
        if ((r12 instanceof Integer) == false) goto L271;
        r46 = (Integer) r12;
    L271:
        if (r46 == null) goto L452;
        r13.N3(r46.intValue());
        return;
    L452:
        return;
    L274:
        if (r11.equals("abandon_coordinate") == true) goto L277;
        return;
    L277:
        if ((r12 instanceof Boolean) == false) goto L279;
        r47 = (Boolean) r12;
    L279:
        if (r47 == null) goto L454;
        r13.G3(r47.booleanValue());
        return;
    L454:
        return;
    L282:
        if (r11.equals("use_real_screen_height") == true) goto L285;
        return;
    L285:
        if ((r12 instanceof Boolean) == false) goto L287;
        r48 = (Boolean) r12;
    L287:
        if (r48 == null) goto L456;
        r13.u4(r48.booleanValue());
        return;
    L456:
        return;
    L290:
        if (r11.equals("up_offset_height") == true) goto L293;
        return;
    L293:
        if ((r12 instanceof Integer) == false) goto L295;
        r49 = (Integer) r12;
    L295:
        if (r49 == null) goto L458;
        r13.p4(r49.intValue());
        return;
    L458:
        return;
    L298:
        if (r11.equals("use_bottom_close") == true) goto L301;
        return;
    L301:
        if ((r12 instanceof Boolean) == false) goto L303;
        r50 = (Boolean) r12;
    L303:
        if (r50 == null) goto L460;
        r13.s4(r50.booleanValue());
        return;
    L460:
        return;
    L306:
        if (r11.equals("radius_top_right") == true) goto L309;
        return;
    L309:
        if ((r12 instanceof Integer) == false) goto L311;
        r51 = (Integer) r12;
    L311:
        if (r51 == null) goto L462;
        r13.j4(r51.intValue());
        return;
    L462:
        return;
    L314:
        if (r11.equals("up_height_percent") == true) goto L317;
        return;
    L317:
        if ((r12 instanceof Integer) == false) goto L319;
        r52 = (Integer) r12;
    L319:
        if (r52 == null) goto L464;
        r13.o4(r52.intValue());
        return;
    L464:
        return;
    L322:
        if (r11.equals("mask_alpha") == true) goto L325;
        return;
    L325:
        if ((r12 instanceof Float) == false) goto L327;
        r53 = (Float) r12;
    L327:
        if (r53 == null) goto L466;
        r13.a4(r53.floatValue());
        return;
    L466:
        return;
    L330:
        if (r11.equals("close_icon_position") == true) goto L333;
        return;
    L333:
        if ((r12 instanceof Integer) == false) goto L335;
        r54 = (Integer) r12;
    L335:
        if (r54 == null) goto L468;
        r13.n4(r54.intValue());
        return;
    L468:
        return;
    L338:
        if (r11.equals("popup_type") == true) goto L341;
        return;
    L341:
        if ((r12 instanceof String) == false) goto L343;
        r55 = (String) r12;
    L343:
        if (r55 == null) goto L470;
        r13.d4(r55);
        return;
    L470:
        return;
    L346:
        if (r11.equals("width_percent") == true) goto L349;
        return;
    L349:
        if ((r12 instanceof Integer) == false) goto L351;
        r56 = (Integer) r12;
    L351:
        if (r56 == null) goto L472;
        r13.w4(r56.intValue());
        return;
    L472:
        return;
    L354:
        if (r11.equals("pull_down_height") == true) goto L357;
        return;
    L357:
        if ((r12 instanceof Integer) == false) goto L359;
        r57 = (Integer) r12;
    L359:
        if (r57 == null) goto L474;
        r13.e4(r57.intValue());
        return;
    L474:
        return;
    L362:
        if (r11.equals("window_floating") == true) goto L365;
        return;
    L365:
        if ((r12 instanceof Boolean) == false) goto L367;
        r58 = (Boolean) r12;
    L367:
        if (r58 == null) goto L476;
        r13.x4(r58.booleanValue());
        return;
    L476:
        return;
    L370:
        if (r11.equals("radius_top_left") == true) goto L373;
        return;
    L373:
        if ((r12 instanceof Integer) == false) goto L375;
        r1 = (Integer) r12;
    L375:
        if (r1 == null) goto L478;
        r13.i4(r1.intValue());
        return;
    L478:
        return;
    L378:
        if ((r10 instanceof FragmentParamVoNew) == false) goto L381;
        c(r11, r12, (FragmentParamVoNew) r10);
        return;
    L381:
        if ((r10 instanceof CardParamVoNew) == false) goto L384;
        a(r11, r12, (CardParamVoNew) r10);
        return;
    L384:
        if ((r10 instanceof BaseHybridParamVoNew) == false) goto L482;
        b(r11, r12, (BaseHybridParamVoNew) r10);
        return;
    }
}
