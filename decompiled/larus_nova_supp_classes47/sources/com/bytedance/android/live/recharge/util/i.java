package com.bytedance.android.live.recharge.util;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "SHOW_CASH_EXCHANGE_DIAMOND_RED_DOT", "getSHOW_CASH_EXCHANGE_DIAMOND_RED_DOT()Z", 1))};
        b = SpongePreferenceManager.a().a("show_cash_exchange_diamond_red_dot", Boolean.FALSE, Boolean.TYPE);
    }
}
