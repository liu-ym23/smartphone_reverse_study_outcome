package ay1;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a g = null;
    public static final cd6.b.a h = null;
    public static final cd6.b.c i = null;
    public static final cd6.b.d j = null;
    public static final cd6.b.b k = null;

    public static final boolean a() {
        return ((Boolean) e.getValue(null, a[6])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) d.getValue(null, a[5])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) f.getValue(null, a[7])).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) g.getValue(null, a[8])).booleanValue();
    }

    public static final void e(boolean r3) {
        e.setValue(null, a[6], Boolean.valueOf(r3));
    }

    public static final void f(boolean r3) {
        f.setValue(null, a[7], Boolean.valueOf(r3));
    }

    public static final void g(boolean r3) {
        g.setValue(null, a[8], Boolean.valueOf(r3));
    }

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "ASSETS_CACHE_LAST_CHECK_TIME", "getASSETS_CACHE_LAST_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "ASSETS_CACHE_DATA", "getASSETS_CACHE_DATA()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_GIFT_RESOURCE_USE_TIME", "getLIVE_GIFT_RESOURCE_USE_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_GIFT_RESOURCE_CACHE_INIT", "getLIVE_GIFT_RESOURCE_CACHE_INIT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "REQUEST_USER_CONSUME_INFO_LEVEL", "getREQUEST_USER_CONSUME_INFO_LEVEL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_GIFT_OPEN_VALUE", "getLIVE_SETTING_ANCHOR_GIFT_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_EFFECT_GAME_VALUE", "getLIVE_SETTING_ANCHOR_EFFECT_GAME_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_ROLE_SKILL_EFFECT_VALUE", "getLIVE_SETTING_ANCHOR_ROLE_SKILL_EFFECT_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_SETTING_ANCHOR_STICKER_GIFT_OPEN_VALUE", "getLIVE_SETTING_ANCHOR_STICKER_GIFT_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(d.class, "LIVE_GIFT_AUDIENCE_SEND_GIFT_ENABLED_ANCHOR_SWITCH", "getLIVE_GIFT_AUDIENCE_SEND_GIFT_ENABLED_ANCHOR_SWITCH()J", 1))};
        com.bytedance.tools.kcp.spongepreference.runtime.b r0 = SpongePreferenceManager.a();
        Long r1 = Long.valueOf(0);
        Class r2 = Long.TYPE;
        r0.a("assets_cache_last_check_time", r1, r2);
        SpongePreferenceManager.a().a("assets_cache_data", BuildConfig.FLAVOR, String.class);
        b = SpongePreferenceManager.a().a("live_gift_resources_use_time", new HashMap(), rl3.a.d);
        com.bytedance.tools.kcp.spongepreference.runtime.b r3 = SpongePreferenceManager.a();
        Boolean r4 = Boolean.FALSE;
        Class r5 = Boolean.TYPE;
        c = r3.a("live_gift_resourece_cache_init", r4, r5);
        SpongePreferenceManager.a().a("request_user_consume_info_level", -1, Integer.TYPE);
        com.bytedance.tools.kcp.spongepreference.runtime.b r6 = SpongePreferenceManager.a();
        Boolean r7 = Boolean.TRUE;
        d = r6.a("live_setting_anchor_gift_open_value", r7, r5);
        e = SpongePreferenceManager.a().a("live_setting_anchor_effect_game_value", r7, r5);
        f = SpongePreferenceManager.a().a("live_setting_anchor_character_effect_value", r7, r5);
        g = SpongePreferenceManager.a().a("live_setting_sticker_gift_open_value", r7, r5);
        h = cd6.b.c;
        i = cd6.b.e;
        j = cd6.b.g;
        k = cd6.b.i;
        SpongePreferenceManager.a().a("live_gift_audience_send_gift_enabled_anchor_switch", 2L, r2);
    }
}
