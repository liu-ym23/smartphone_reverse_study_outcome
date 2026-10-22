package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g1 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(g1.class, "HAS_SHOWN_LOTTERY_RED_DOT", "getHAS_SHOWN_LOTTERY_RED_DOT()Z", 1))};
        b = SpongePreferenceManager.a().a("has_shown_lottery_red_dot", Boolean.FALSE, Boolean.TYPE);
    }
}
