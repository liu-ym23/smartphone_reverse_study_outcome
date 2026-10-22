package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_ERROR_CONFIRM_NEXT_CHECK", "getFAST_GIFT_ERROR_CONFIRM_NEXT_CHECK()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_HIDE_CONFIRM_GIFT_DATE", "getFAST_GIFT_HIDE_CONFIRM_GIFT_DATE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_HIDE_CONFIRM_GIFT_BY_PRICE", "getFAST_GIFT_HIDE_CONFIRM_GIFT_BY_PRICE()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "FAST_GIFT_HIDE_CONFIRM_GIFT_BY_ID", "getFAST_GIFT_HIDE_CONFIRM_GIFT_BY_ID()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(c.class, "DAY_OF_EXCLUSIVE_POP_UP_GIFT_SHOWN", "getDAY_OF_EXCLUSIVE_POP_UP_GIFT_SHOWN()Ljava/util/HashMap;", 1))};
        b = SpongePreferenceManager.a().a("fast_gift_error_confirm_next_check", Boolean.FALSE, Boolean.TYPE);
        c = SpongePreferenceManager.a().a("fast_gift_hide_confirm_gift_date", new HashMap(), ql3.a.J);
        d = SpongePreferenceManager.a().a("fast_gift_hide_confirm_gift_by_price", new HashSet(), ql3.a.L);
        e = SpongePreferenceManager.a().a("fast_gift_hide_confirm_gift_by_id", new HashSet(), ql3.a.w);
        f = SpongePreferenceManager.a().a("day_of_exclusive_pop_up_gift_shown", new HashMap(), ql3.a.K);
    }
}
