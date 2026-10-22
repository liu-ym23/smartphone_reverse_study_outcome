package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig;
import com.bytedance.android.live.recharge.config.DynamicRechargePanelConfig;
import com.bytedance.android.live.recharge.config.GemExchangeCouponConfig;
import com.bytedance.android.live.recharge.model.NoPasswordFansConfig;
import com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t {
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
    public static final ReadOnlyProperty m = null;
    public static final ReadOnlyProperty n = null;
    public static final ReadOnlyProperty o = null;
    public static final ReadOnlyProperty p = null;
    public static final ReadOnlyProperty q = null;

    public static final CustomRechargeOneStepConfig a() {
        return (CustomRechargeOneStepConfig) m.getValue(null, a[11]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_DYNAMIC_CONFIG", "getLIVE_RECHARGE_DYNAMIC_CONFIG()Lcom/bytedance/android/live/recharge/model/RechargePanelDynamicConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_MSG_NOTICE_TIME", "getLIVE_RECHARGE_PK_MSG_NOTICE_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_MSG_NOTICE_SWITCH", "getLIVE_RECHARGE_PK_MSG_NOTICE_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_MSG_LEFT_TIME", "getLIVE_RECHARGE_PK_MSG_LEFT_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_DIAMOND_LIMIT", "getLIVE_RECHARGE_PK_DIAMOND_LIMIT()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_NO_PASSWORD_SWITCH", "getLIVE_RECHARGE_PK_NO_PASSWORD_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_DIAMOND_UPPER_LIMIT", "getLIVE_RECHARGE_PK_DIAMOND_UPPER_LIMIT()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_AUTO_SEND_GIFT_NEW", "getLIVE_RECHARGE_PK_AUTO_SEND_GIFT_NEW()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_FANSCLUB_NO_PASSWORD_CONFIG", "getLIVE_RECHARGE_FANSCLUB_NO_PASSWORD_CONFIG()Lcom/bytedance/android/live/recharge/model/NoPasswordFansConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_SUPPORT_ONE_STEP_PAY", "getLIVE_RECHARGE_SUPPORT_ONE_STEP_PAY()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_API_CHECKER_ENABLE", "getLIVE_RECHARGE_API_CHECKER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_CUSTOM_RECHARGE_ONE_STEP_CONFIG", "getLIVE_CUSTOM_RECHARGE_ONE_STEP_CONFIG()Lcom/bytedance/android/live/recharge/config/CustomRechargeOneStepConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_NO_PASSWD_MOCK", "getLIVE_RECHARGE_PK_NO_PASSWD_MOCK()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_DYLITE_COUPON_WITHOUT_COMBINED_PAY", "getLIVE_DYLITE_COUPON_WITHOUT_COMBINED_PAY()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_GEM_EXCHANGE_COUPON_CONFIG", "getLIVE_GEM_EXCHANGE_COUPON_CONFIG()Lcom/bytedance/android/live/recharge/config/GemExchangeCouponConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_DYNAMIC_RECHARGE_PANEL_CONFIG", "getLIVE_DYNAMIC_RECHARGE_PANEL_CONFIG()Lcom/bytedance/android/live/recharge/config/DynamicRechargePanelConfig;", 1))};
        a = r0;
        RechargePanelDynamicConfig.f.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_dynamic_config", (RechargePanelDynamicConfig) RechargePanelDynamicConfig.Companion.a.getValue(), RechargePanelDynamicConfig.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r14 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_msg_notice_time", 120L, r14, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r5 = Boolean.TRUE;
        Class r13 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_msg_notice_switch", r5, r13, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_msg_left_time", 20L, r14, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_diamond_limit", 1L, r14, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_no_password_switch", r5, r13, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_diamond_upper_limit", 5000L, r14, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_auto_send_gift_new", r5, r13, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        NoPasswordFansConfig.e.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_fansclub_no_password_config", (NoPasswordFansConfig) NoPasswordFansConfig.Companion.a.getValue(), NoPasswordFansConfig.class, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        Boolean r12 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_support_one_step_pay", r12, r13, false);
        k = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_api_checker_enable", r5, r13, false);
        l = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[10]);
        CustomRechargeOneStepConfig.b.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_custom_recharge_one_step_config", (CustomRechargeOneStepConfig) CustomRechargeOneStepConfig.Companion.a.getValue(), CustomRechargeOneStepConfig.class, false);
        m = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_no_passwd_mock", r12, r13, false);
        n = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_dylite_coupon_without_combined_pay_new", r12, r13, false);
        o = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[13]);
        GemExchangeCouponConfig.d.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gem_exchange_coupon_config", (GemExchangeCouponConfig) GemExchangeCouponConfig.Companion.a.getValue(), GemExchangeCouponConfig.class, false);
        p = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[14]);
        DynamicRechargePanelConfig.c.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_dynamic_recharge_panel_config", (DynamicRechargePanelConfig) DynamicRechargePanelConfig.Companion.a.getValue(), DynamicRechargePanelConfig.class, false);
        q = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[15]);
    }
}
