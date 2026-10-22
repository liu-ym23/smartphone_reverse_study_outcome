package com.bytedance.android.live.recharge.util;

import com.bytedance.android.live.revenue.common.HybridPropertyUtilsKt;
import com.bytedance.android.live.revenue.common.m;
import com.bytedance.android.live.revenue.common.w0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final m b = null;
    public static final m c = null;
    public static final m d = null;
    public static final m e = null;
    public static final m f = null;
    public static final m g = null;
    public static final m h = null;
    public static final a i = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "CASH_EXCHANGE_GIFT_SEND_AUTO", "getCASH_EXCHANGE_GIFT_SEND_AUTO()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "INCOME_BALANCE_VISIBLE_AUTHORITY", "getINCOME_BALANCE_VISIBLE_AUTHORITY()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "TOOLBAR_TREASURE_BOX_COUNT_DOWN", "getTOOLBAR_TREASURE_BOX_COUNT_DOWN()Ljava/util/Map;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_INCENTIVE_EXCHANGE_DIAMOND_OPT_CACHE", "getLIVE_INCENTIVE_EXCHANGE_DIAMOND_OPT_CACHE()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_FANSCLUB_BASE_DATA_CACHE", "getLIVE_FANSCLUB_BASE_DATA_CACHE()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_TASK_LIST_DATA_CACHE", "getLIVE_TASK_LIST_DATA_CACHE()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_TASK_CENTER_DATA_CACHE", "getLIVE_TASK_CENTER_DATA_CACHE()Ljava/lang/String;", 0))};
        i = new a();
        Intrinsics.checkNotNullParameter("cash_exchange_gift_send_auto", "key");
        Boolean r3 = Boolean.FALSE;
        w0<Boolean> r4 = HybridPropertyUtilsKt.c;
        b = new m("cash_exchange_gift_send_auto", r3, r4);
        Intrinsics.checkNotNullParameter("income_balance_visible_authority", "key");
        c = new m("income_balance_visible_authority", r3, r4);
        d = HybridPropertyUtilsKt.c("webcast.excitation.douyin.daily_box_task.storage_key_v2", new LinkedHashMap());
        e = HybridPropertyUtilsKt.b("live_incentive_exchange_diamond_opt_cache", "0_0");
        f = HybridPropertyUtilsKt.b("live_fansclub_base_data_cache", "");
        g = HybridPropertyUtilsKt.b("live_task_list_data_cache", "");
        h = HybridPropertyUtilsKt.b("live_task_center_data_cache_v2", "");
    }

    public a() {
    }

    public final Map<String, String> a() {
        return (Map) d.getValue(this, a[2]);
    }
}
