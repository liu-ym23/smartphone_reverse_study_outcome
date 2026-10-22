package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(g.class, "LIVE_LINK_REV_RTC_DATA", "getLIVE_LINK_REV_RTC_DATA()Ljava/util/Map;", 1))};
        b = SpongePreferenceManager.a().a("live_link_rev_rtc_data", MapsKt.emptyMap(), ul3.a.m);
    }
}
