package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
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

    public static final boolean a() {
        return ((Boolean) e.getValue(null, a[3])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) r.getValue(null, a[15])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) j.getValue(null, a[8])).booleanValue();
    }

    public static final int d() {
        return ((Number) l.getValue(null, a[10])).intValue();
    }

    public static final int e() {
        return ((Number) p.getValue(null, a[13])).intValue();
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(i.class, "FANS_CLUB_LYNX_URL_GROUP", "getFANS_CLUB_LYNX_URL_GROUP()Lcom/bytedance/android/live/profit/fansclub/panel/setting/FansClubLynxUrlConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "FANS_SUBSCRIBE_LYNX_URL_CONFIG", "getFANS_SUBSCRIBE_LYNX_URL_CONFIG()Lcom/bytedance/android/live/profit/fansclub/panel/setting/FansSubscribeLynxUrlConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_SOCIAL_REVENUE_VIP_CONFIG", "getLIVE_SOCIAL_REVENUE_VIP_CONFIG()Lcom/bytedance/android/live/profit/fansclub/panel/setting/RevenueVipLynxUrlConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "FANSCLUB_VIP_SPLIT_TAB_ENABLE", "getFANSCLUB_VIP_SPLIT_TAB_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_SHOP_FANS_CLUB_ANCHOR_CLICK_ENABLE", "getLIVE_SHOP_FANS_CLUB_ANCHOR_CLICK_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_FIX_USERINFO_FOLLOW", "getLIVE_FIX_USERINFO_FOLLOW()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ACCESSIBILITY_TYPE_ANNOUNCEMENT_OPT", "getLIVE_ACCESSIBILITY_TYPE_ANNOUNCEMENT_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ECOM_FANS_CLUB_ENABLE", "getLIVE_ECOM_FANS_CLUB_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ENABLE_FOLLOW_STATUS_USE_LOCAL_DB", "getLIVE_ENABLE_FOLLOW_STATUS_USE_LOCAL_DB()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ENABLE_ANCHOR_INFO_COMMON_VIP", "getLIVE_ENABLE_ANCHOR_INFO_COMMON_VIP()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_FANSCLUB_API_OPT", "getLIVE_FANSCLUB_API_OPT()I", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_JOIN_FANSCLUB_GUIDE_AB", "getLIVE_JOIN_FANSCLUB_GUIDE_AB()I", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ENABLE_UPDATE_BALANCE_FANS_JOIN", "getLIVE_ENABLE_UPDATE_BALANCE_FANS_JOIN()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GUARD_HIGH_LEVEL", "getLIVE_GUARD_HIGH_LEVEL()I", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_FANS_CLUB_GROUP_PANEL", "getLIVE_FANS_CLUB_GROUP_PANEL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ANCHOR_VIP_UNINITIALIZED_ICON_OPTIMIZE_ENABLE", "getLIVE_ANCHOR_VIP_UNINITIALIZED_ICON_OPTIMIZE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_AUDIENCE_VIP_ICON_OPTIMIZE_CONFIG", "getLIVE_AUDIENCE_VIP_ICON_OPTIMIZE_CONFIG()Lcom/bytedance/android/live/profit/fansclub/panel/setting/RevenueVipAudienceIconOptConfig;", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("fans_club_lynx_url_group", new du0.a(), du0.a.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("fansclub_subscribe_lynx_url", new du0.b(), du0.b.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_social_revenue_vip_config", new du0.d(), du0.d.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.FALSE;
        Class r13 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("fansclub_vip_split_enable", r4, r13, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_shop_fans_club_anchor_click_enable", r4, r13, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        Boolean r7 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fix_userinfo_follow", r7, r13, false);
        g = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_accessibility_type_announcement_opt", r4, r13, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ecom_fansclub_enable", r4, r13, false);
        i = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_follow_status_use_local_db", r7, r13, false);
        j = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r14 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_anchor_info_common_vip", r7, r13, false);
        k = UltraSettingsManager.a().a(r14.a, r14.b, r14.getType(), r14.d, r0[9]);
        Class r15 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fansclub_api_opt", 0, r15, false);
        l = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[10]);
        m = new ClientABTestKey("live_fansclub_precision_key", r15, 0, 1);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_join_fansclub_guide", 0, r15, false);
        n = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_update_balance_fans_join", r4, r13, false);
        o = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_guard_high_level", 10, r15, false);
        p = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fansclub_group_panel", "", String.class, false);
        q = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_vip_icon_opt_enable", r4, r13, false);
        r = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vip_icon_audience_opt_config", new du0.c(), du0.c.class, false);
        s = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[16]);
    }
}
