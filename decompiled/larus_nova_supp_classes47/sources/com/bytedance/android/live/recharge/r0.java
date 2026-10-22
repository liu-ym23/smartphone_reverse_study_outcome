package com.bytedance.android.live.recharge;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a g = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_NOTICE_FREQUENCY", "getLIVE_RECHARGE_NOTICE_FREQUENCY()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_DIAMOND_API_CACHE", "getLIVE_RECHARGE_DIAMOND_API_CACHE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_DIAMOND_API_CACHE_DISABLE", "getLIVE_RECHARGE_DIAMOND_API_CACHE_DISABLE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_PREFETCH_DIAMOND_TIME", "getLIVE_RECHARGE_PREFETCH_DIAMOND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_BANNER_VALID_TIME", "getLIVE_RECHARGE_BANNER_VALID_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r0.class, "LIVE_RECHARGE_BANNER_LAST_HEIGHT", "getLIVE_RECHARGE_BANNER_LAST_HEIGHT()I", 1))};
        b = SpongePreferenceManager.a().a("live_recharge_notice_frequency_new", new HashMap(), tl3.a.a);
        c = SpongePreferenceManager.a().a("live_recharge_diamond_api_cache_map", new HashMap(), tl3.a.f);
        d = SpongePreferenceManager.a().a("live_recharge_diamond_api_cache_disable", Boolean.FALSE, Boolean.TYPE);
        e = SpongePreferenceManager.a().a("live_recharge_prefetch_diamond_time", new HashMap(), tl3.a.g);
        f = SpongePreferenceManager.a().a("live_recharge_banner_valid_time", 0L, Long.TYPE);
        g = SpongePreferenceManager.a().a("live_recharge_banner_last_height", 0, Integer.TYPE);
    }

    public static final HashMap<String, String> a() {
        return (HashMap) c.getValue(null, a[1]);
    }
}
