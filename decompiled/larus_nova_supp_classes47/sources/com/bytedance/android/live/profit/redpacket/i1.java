package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i1 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final ReadOnlyProperty k = null;
    public static final ReadOnlyProperty l = null;
    public static final ClientABTestKey<Integer> m = null;
    public static final ReadOnlyProperty n = null;
    public static final ReadOnlyProperty o = null;
    public static final ReadOnlyProperty p = null;
    public static final ReadOnlyProperty q = null;
    public static final ReadOnlyProperty r = null;
    public static final ReadOnlyProperty s = null;

    public static final int a() {
        return ((Number) j.getValue(null, a[8])).intValue();
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_ENVELOPE_LYNX_SCHEMA", "getLIVE_RED_ENVELOPE_LYNX_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_ENVELOPE_LYNX_OPTIMIZE_STRATEGY", "getLIVE_RED_ENVELOPE_LYNX_OPTIMIZE_STRATEGY()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_DEFAULT_AVATAR_URLS", "getLIVE_DEFAULT_AVATAR_URLS()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "SEND_RED_ENVELOPE_URL", "getSEND_RED_ENVELOPE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_PACKET_RULE_PAGE", "getLIVE_RED_PACKET_RULE_PAGE()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "RED_PACKET_COUNT_DOWN_BEHAVIOR", "getRED_PACKET_COUNT_DOWN_BEHAVIOR()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "RED_PACKET_OPT_STYLE", "getRED_PACKET_OPT_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_BAN_USER_CARD_ENABLE", "getLIVE_BAN_USER_CARD_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_PACKET_RUSH_OPTIMIZE", "getLIVE_RED_PACKET_RUSH_OPTIMIZE()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_SEND_LYNX_RED_ENVELOPE_ENABLE", "getLIVE_SEND_LYNX_RED_ENVELOPE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_SEND_LYNX_RED_ENVELOPE_URL", "getLIVE_SEND_LYNX_RED_ENVELOPE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "REVENUE_LUCKY_BOX_SHORT_TOUCH_SCHEMA", "getREVENUE_LUCKY_BOX_SHORT_TOUCH_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "REVENUE_LUCKY_BOX_SHORT_TOUCH_SHARE_VIEW_URL", "getREVENUE_LUCKY_BOX_SHORT_TOUCH_SHARE_VIEW_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "REVENUE_LUCKY_BOX_SHORT_TOUCH_ANI_SCHEMA", "getREVENUE_LUCKY_BOX_SHORT_TOUCH_ANI_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_REDPACKET_SERVICE_LAZY_LOAD", "getLIVE_REDPACKET_SERVICE_LAZY_LOAD()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_REDPACKET_SHORT_TOUCH_ENTRY_VIEW_NATIVE", "getLIVE_REDPACKET_SHORT_TOUCH_ENTRY_VIEW_NATIVE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_REDPACKET_SHORT_TOUCH_USE_SHARE_VIEW", "getLIVE_REDPACKET_SHORT_TOUCH_USE_SHARE_VIEW()Z", 1))};
        a = r0;
        String r13 = "";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_envelope_lynx_schema", "", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r15 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_envelope_lynx_optimize_strategy", 1, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_default_avatar_urls", new ArrayList(), un3.a.a, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        KmpEnv r4 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        String r5 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/h5/h5_revenue_red_packet_douyin/template/pages/index.html?web_bg_color=#ffffff00&appType=douyin&radius=8&background_color=161823&rate_height=488&type=popup&gravity=bottom&horizontal_width=400";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_red_envelope_url", r5, String.class, false);
        e = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[3]);
        if (KmpEnv.a() == false) goto L9;
        r13 = "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Fh5_revenue_red_packet_douyin%2Ftemplate%2Fpages%2Findex.html%3Fweb_bg_color%3D%23ffffff00%26appType%3ddouyin%26open_type%3Drules%26radius%3d8%26background_color%3d161823&rate_height=488&type=popup&gravity=bottom&horizontal_width=400";
    L9:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_packet_rule_page", r13, String.class, false);
        f = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("red_packet_count_down_behavior", 0, r15, false);
        g = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("red_packet_opt_style_2", 0, r15, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        Boolean r10 = Boolean.TRUE;
        Class r12 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r14 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ban_user_card_enable", r10, r12, false);
        i = UltraSettingsManager.a().a(r14.a, r14.b, r14.getType(), r14.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_packet_rush_optimize", 0, r15, false);
        j = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[8]);
        Boolean r17 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_lynx_red_envelope_enable", r17, r12, true);
        k = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_lynx_red_envelope_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_short_touch_lynx_douyin%2Fpages%2Fsend_lucky_box%2Ftemplate.js&rate_height=532&type=popup&gravity=bottom&horizontal_width=400&radius=8&web_bg_color=ff161823", String.class, true);
        l = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[10]);
        m = new ClientABTestKey("live_red_envelope_precision_key", r15, 0, 1);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_short_touch_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_short_touch_lynx_douyin%2Fpages%2Fred_envelope_shorttouch%2Ftemplate.js&group=webcast_revenue&use_storage_group=1", String.class, false);
        n = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_short_touch_share_view_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_short_touch_lynx_douyin/pages/red_envelope_shorttouch_rl3/template.js?forest_sync_load=1", String.class, false);
        o = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_short_touch_ani_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_short_touch_lynx_douyin%2Fpages%2Fred_envelope_ani_shorttouch%2Ftemplate.js&group=webcast_revenue&use_storage_group=1", String.class, false);
        p = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_service_lazy_load", 0, r15, false);
        q = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_short_touch_entry_view_native", r10, r12, false);
        r = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_short_touch_use_share_view", r17, r12, false);
        s = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[16]);
        return;
    L5:
        r5 = "https://webcast.ixigua.com/falcon/webcast_xigua/page/red_packet/index.html?web_bg_color=%23ff16171c&appType=toutiao&radius=8&background_color=16171c&height=470&type=popup&gravity=bottom";
        goto L6
    }
}
