package com.bytedance.android.live.recharge.util;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
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

    public static final f a() {
        return (f) b.getValue(null, a[0]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_WALLET_OPEN_CJ_COUNTER_OPT_CONFIG", "getLIVE_WALLET_OPEN_CJ_COUNTER_OPT_CONFIG()Lcom/bytedance/android/live/recharge/util/RechargeCounterOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_RECOMMEND_DIALOG_URL", "getLIVE_RECHARGE_RECOMMEND_DIALOG_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "H5_DIALOG_EXCHANGE", "getH5_DIALOG_EXCHANGE()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_DISABLE_OLD_CONTAINER_RECHARGE", "getLIVE_DISABLE_OLD_CONTAINER_RECHARGE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "RECHARGE_PANEL_ADAPT_FOLD_SCREEN", "getRECHARGE_PANEL_ADAPT_FOLD_SCREEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_DIAMOND_NOTICE_CONFIG", "getLIVE_DIAMOND_NOTICE_CONFIG()Lcom/bytedance/android/live/recharge/model/RechargeNoticeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_COUPON_LIST_SCHEMA", "getLIVE_COUPON_LIST_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_FAIL_SERVER_EXCEPTION_CODE_LIST", "getLIVE_RECHARGE_FAIL_SERVER_EXCEPTION_CODE_LIST()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_SECURITY_CONFIRM_RETRY_BEHAVIOR", "getLIVE_RECHARGE_SECURITY_CONFIRM_RETRY_BEHAVIOR()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_FIX_CJ_COMPONENT_HEIGHT", "getLIVE_RECHARGE_FIX_CJ_COMPONENT_HEIGHT()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wallet_open_cj_counter_opt", new f(0), f.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        String r14 = "";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_recommend_dialog_url", "", String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        KmpEnv r12 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        r14 = "sslocal://webcast_webview?type=popup&gravity=bottom&height=260&status_bar_color=white&url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fwallet%2Fincome_2_diamond%2Findex.html%3Fhalf_screen%3D1%26request_page%3Dlive_detail";
    L5:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("h5_dialog_exchange", r14, String.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.TRUE;
        Class r13 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_old_container_recharge", r4, r13, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_adapt_fold_screen", r4, r13, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_diamond_notice_config", new com.bytedance.android.live.recharge.model.e(), com.bytedance.android.live.recharge.model.e.class, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_coupon_list_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_wallet_douyin%2Fpages%2Fcoupon_list%2Ftemplate.js&type=popup&gravity=bottom&rate_height=480", String.class, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_fail_server_exception_code_list", CollectionsKt.listOf(4005198), wn3.a.b, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_security_confirm_retry_behavior", 1, Integer.TYPE, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_fix_cj_component_height", r4, r13, false);
        k = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[9]);
    }
}
