package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.android.livesdk.gift.configmodel.g0;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPreloadSettingsKt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final Lazy c = null;
    public static final ReadOnlyProperty d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(GiftPreloadSettingsKt.class, "panelUIPreloadConfig", "getPanelUIPreloadConfig()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelUIPreloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(GiftPreloadSettingsKt.class, "giftNewPreloaderConfig", "getGiftNewPreloaderConfig()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPreloaderConfig;", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_ui_preload_config", new a(), a.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        c = LazyKt.lazy(GiftPreloadSettingsKt$prefetchImageOpt$2.INSTANCE);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_new_preloader_config", new d(0), d.class, false);
        d = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        e = LazyKt.lazy(GiftPreloadSettingsKt$giftPreloaderConfig$2.INSTANCE);
        f = LazyKt.lazy(GiftPreloadSettingsKt$enableNewGiftPreloader$2.INSTANCE);
    }

    public static final d a() {
        return (d) d.getValue(null, a[1]);
    }

    public static final g0 b() {
        return (g0) c.getValue();
    }
}
