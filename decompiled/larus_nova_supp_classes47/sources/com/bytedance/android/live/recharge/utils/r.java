package com.bytedance.android.live.recharge.utils;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a g = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a h = null;

    public static final int a() {
        return ((Number) c.getValue(null, a[1])).intValue();
    }

    public static final boolean b() {
        return ((Boolean) g.getValue(null, a[6])).booleanValue();
    }

    public static final int c() {
        return ((Number) f.getValue(null, a[5])).intValue();
    }

    public static final void d(HashMap<String, Long> r3) {
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        h.setValue(null, a[7], r3);
    }

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "CASH_EXCHANGE_FREQUENCY_CONTROL", "getCASH_EXCHANGE_FREQUENCY_CONTROL()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "CASH_EXCHANGE_GIFT_SEND_SHOWN_NUMBER", "getCASH_EXCHANGE_GIFT_SEND_SHOWN_NUMBER()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "ROOM_WALLET_INFO_REQUEST_TIME_UID", "getROOM_WALLET_INFO_REQUEST_TIME_UID()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "CASH_EXCHANGE_TOOLBAR_POPUP_SHOWN", "getCASH_EXCHANGE_TOOLBAR_POPUP_SHOWN()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "RECHARGE_PANEL_REAL_HEIGHT", "getRECHARGE_PANEL_REAL_HEIGHT()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "EXCHANGE_DIAMONDS_FOR_SEND_GIFTS_SUCCESS_TIMES", "getEXCHANGE_DIAMONDS_FOR_SEND_GIFTS_SUCCESS_TIMES()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "EXCHANGE_DIAMONDS_DIALOG_NO_MORE_REMIND", "getEXCHANGE_DIAMONDS_DIALOG_NO_MORE_REMIND()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "LIVE_INCENTIVE_EXCHANGE_DIAMOND_CACHE", "getLIVE_INCENTIVE_EXCHANGE_DIAMOND_CACHE()Ljava/util/HashMap;", 1))};
        b = SpongePreferenceManager.a().a("cash_exchange_frequency_control", MapsKt.emptyMap(), tl3.a.c);
        com.bytedance.tools.kcp.spongepreference.runtime.b r0 = SpongePreferenceManager.a();
        Class r1 = Integer.TYPE;
        c = r0.a("cash_exchange_gift_send_shown_number", 0, r1);
        d = SpongePreferenceManager.a().a("room_wallet_info_request_time_uid", new HashMap(), tl3.a.d);
        com.bytedance.tools.kcp.spongepreference.runtime.b r2 = SpongePreferenceManager.a();
        Boolean r3 = Boolean.FALSE;
        Class r4 = Boolean.TYPE;
        r2.a("cash_exchange_toolbar_popup_shown", r3, r4);
        e = SpongePreferenceManager.a().a("recharge_panel_real_height", 0, r1);
        f = SpongePreferenceManager.a().a("exchange_diamonds_for_send_gifts_success_times", 0, r1);
        g = SpongePreferenceManager.a().a("exchange_diamonds_dialog_no_more_remind", r3, r4);
        h = SpongePreferenceManager.a().a("live_incentive_exchange_diamond_cache", new HashMap(), tl3.a.e);
    }
}
