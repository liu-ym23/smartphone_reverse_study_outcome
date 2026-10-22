package com.bytedance.android.live.recharge.utils;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "RECHARGE_APP_ASYNC_NOTICE", "getRECHARGE_APP_ASYNC_NOTICE()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "LIVE_RECHARGE_SELECT_COMBINE_PAY", "getLIVE_RECHARGE_SELECT_COMBINE_PAY()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "LIVE_LAST_CUSTOM_RECHARGE_PRICE", "getLIVE_LAST_CUSTOM_RECHARGE_PRICE()Ljava/util/HashMap;", 1))};
        b = SpongePreferenceManager.a().a("recharge_app_async_notice", 0L, Long.TYPE);
        c = SpongePreferenceManager.a().a("live_recharge_select_combine_pay", Boolean.FALSE, Boolean.TYPE);
        d = SpongePreferenceManager.a().a("live_last_custom_recharge_price", new HashMap(), tl3.a.b);
    }
}
