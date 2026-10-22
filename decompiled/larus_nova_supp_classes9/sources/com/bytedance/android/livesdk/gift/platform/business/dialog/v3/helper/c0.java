package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a c;
    public static final c0 d = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(c0.class, "giftPanelUILoadOptConfig", "getGiftPanelUILoadOptConfig()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelUILoadOptConfig;", 0))};
        a = r0;
        d = new c0();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_ui_load_opt_config", new f0(), f0.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        c = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a) GiftPreloadSettingsKt.b.getValue(null, GiftPreloadSettingsKt.a[0]);
    }

    public c0() {
    }

    public static boolean a() {
        return c.g();
    }
}
