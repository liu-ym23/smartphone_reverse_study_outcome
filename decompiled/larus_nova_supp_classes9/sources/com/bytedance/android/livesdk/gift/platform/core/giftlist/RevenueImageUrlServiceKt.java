package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RevenueImageUrlServiceKt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final Lazy c = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(RevenueImageUrlServiceKt.class, "LIVE_REVENUE_RICH_CONTENT_IMAGE_OPT", "getLIVE_REVENUE_RICH_CONTENT_IMAGE_OPT()Lcom/bytedance/android/livesdk/gift/platform/core/giftlist/RevRichContentImageOpt;", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_rich_content_image_opt", new q(), q.class, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
        c = LazyKt.lazy(RevenueImageUrlServiceKt$richContentImageOpt$2.INSTANCE);
    }
}
