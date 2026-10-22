package com.bytedance.android.ec.core.opt.ab;

import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ColdLaunchExpFilter {
    public static final /* synthetic */ KProperty[] a = null;
    public static boolean b;
    public static final Lazy c = null;
    public static final i d = null;
    public static final ColdLaunchExpFilter e = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ColdLaunchExpFilter.class, "configs", "getConfigs()Ljava/util/HashSet;", 0))};
        e = new ColdLaunchExpFilter();
        c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ColdLaunchExpFilter$enable$2.INSTANCE);
        HashSet r0 = new HashSet();
        ColdLaunchExpFilter$configs$2 r1 = ColdLaunchExpFilter$configs$2.INSTANCE;
        KProperty[] r10 = h.a;
        LazyHostSettingsKt$lazyOptHostSettingsOrNull$3 r11 = new LazyHostSettingsKt$lazyOptHostSettingsOrNull$3(null);
        Intrinsics.checkNotNullParameter("ec_exp_whitelist_filter_cold_launch_config", "configKey");
        Intrinsics.checkNotNullParameter(r0, "defaultConfig");
        Intrinsics.checkNotNullParameter(r1, "isEnable");
        Intrinsics.checkNotNullParameter(r11, "onConfigReady");
        d = h.b("ec_exp_whitelist_filter_cold_launch_config", r0, null, r1, r11);
    }

    public ColdLaunchExpFilter() {
    }

    public static boolean a() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (a() == true) goto L5;
        return false;
    L5:
        if ((!Intrinsics.areEqual(r10, "ec_exp_whitelist_filter_cold_launch_config")) == true) goto L7;
        return false;
    L7:
        if (b == true) goto L16;
        HashSet r0 = (HashSet) d.getValue(this, a[0]);
        if (r0 != null) goto L11;
        return false;
    L11:
        if (r0.contains(r10) != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }
}
