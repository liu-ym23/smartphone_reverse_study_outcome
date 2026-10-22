package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_RECHARGE_PATH_OPT", "getLIVE_RECHARGE_PATH_OPT()I", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_SEND_GIFT_CHECK_DIAMOND", "getLIVE_SEND_GIFT_CHECK_DIAMOND()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "VS_SEND_GIFT_FAIL_DIALOG_URL", "getVS_SEND_GIFT_FAIL_DIALOG_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "SEND_GIFT_FAIL_DIALOG_URL", "getSEND_GIFT_FAIL_DIALOG_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "SEND_GIFT_NOTFANS_DIALOG_ISOPEN", "getSEND_GIFT_NOTFANS_DIALOG_ISOPEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "GIFT_PANEL_INCOME_TO_COIN_OPTIMIZE", "getGIFT_PANEL_INCOME_TO_COIN_OPTIMIZE()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_path_opt", 0, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r8 = Boolean.FALSE;
        Class r9 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_check_diamond", r8, r9, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        KmpEnv r5 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        String r6 = "https://s3.bytecdn.cn/ies/live/webcast_lynx_douyin/h5/pages/fansclub_vs/popup/index.html";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("vs_send_gift_failed_not_fans_url", r6, String.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        if (KmpEnv.a() == false) goto L9;
        String r4 = "https://webcast.amemv.com/falcon/webcast_douyin/page/fansclub_2020/fansclub_popup/index.html";
    L10:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_failed_not_fans_url", r4, String.class, false);
        e = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_notfans_dialog_isopen", Boolean.TRUE, r9, false);
        f = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r11 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_income_to_coin_optimize", r8, r9, false);
        g = UltraSettingsManager.a().a(r11.a, r11.b, r11.getType(), r11.d, r0[5]);
        return;
    L9:
        r4 = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/fansclub_popup/index.html";
        goto L10
    L5:
        r6 = "https://s3.bytecdn.cn/ies/live/webcast_lynx_huoshan/h5/pages/fansclub_vs/popup/index.html";
        goto L6
    }
}
