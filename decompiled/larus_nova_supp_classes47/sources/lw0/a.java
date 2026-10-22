package lw0;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "LIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_TIME", "getLIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "LIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_DIALOG", "getLIVE_RECHARGE_EXCHANGE_CONFIRM_SHOW_DIALOG()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "CASH_EXCHANGE_GIFT_GUIDE_SHOWN", "getCASH_EXCHANGE_GIFT_GUIDE_SHOWN()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "CASH_EXCHANGE_GIFT_SEND_CHECKED", "getCASH_EXCHANGE_GIFT_SEND_CHECKED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "SHOW_CASH_EXCHANGE_DIAMOND_CONFIRM_DIALOG", "getSHOW_CASH_EXCHANGE_DIAMOND_CONFIRM_DIALOG()Z", 1))};
        b = SpongePreferenceManager.a().a("live_recharge_exchange_confirm_show_time", 0L, Long.TYPE);
        com.bytedance.tools.kcp.spongepreference.runtime.b r0 = SpongePreferenceManager.a();
        Boolean r1 = Boolean.TRUE;
        Class r2 = Boolean.TYPE;
        c = r0.a("live_recharge_exchange_confirm_show_dialog", r1, r2);
        com.bytedance.tools.kcp.spongepreference.runtime.b r3 = SpongePreferenceManager.a();
        Boolean r4 = Boolean.FALSE;
        d = r3.a("cash_exchange_gift_guide_shown", r4, r2);
        e = SpongePreferenceManager.a().a("cash_exchange_gift_send_checked", r4, r2);
        SpongePreferenceManager.a().a("show_cash_exchange_diamond_confirm_dialog", r1, r2);
    }
}
