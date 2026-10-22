package jv0;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "LIVE_SUBSCRIBE_EMOJI_CACHE", "getLIVE_SUBSCRIBE_EMOJI_CACHE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "LIVE_ANCHOR_HAS_VIP_CACHE", "getLIVE_ANCHOR_HAS_VIP_CACHE()Ljava/util/Map;", 1))};
        b = SpongePreferenceManager.a().a("live_subscribe_emoji_cache", new HashMap(), pl3.a.a);
        c = SpongePreferenceManager.a().a("live_anchor_has_vip_cache_v2", MapsKt.emptyMap(), pl3.a.c);
    }
}
