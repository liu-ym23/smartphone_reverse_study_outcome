package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SHOW_NOW_URGENT_DOWNLOAD", "getLIVE_GIFT_SHOW_NOW_URGENT_DOWNLOAD()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BIG_GIFT_ENABLE_LONG_CLICK", "getLIVE_GIFT_BIG_GIFT_ENABLE_LONG_CLICK()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "carnivalComboTrayLynxInfo", "getCarnivalComboTrayLynxInfo()Lcom/bytedance/android/livesdk/gift/biggift/configmodel/GiftCarnivalComboTrayViewConfig;", 1))};
        a = r0;
        Boolean r4 = Boolean.TRUE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_show_now_urgent_download", r4, r6, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_big_gift_enable_long_click", Boolean.FALSE, r6, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_carnival_combo_tray_lynx_info", new dy1.a(), dy1.a.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
    }
}
