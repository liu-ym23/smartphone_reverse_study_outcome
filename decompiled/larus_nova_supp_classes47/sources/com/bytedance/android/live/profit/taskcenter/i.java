package com.bytedance.android.live.profit.taskcenter;

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

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "TASK_CENTER_PANEL_DAILY_LIMIT", "getTASK_CENTER_PANEL_DAILY_LIMIT()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "TASK_CENTER_PANEL_LIFETIME_LIMIT", "getTASK_CENTER_PANEL_LIFETIME_LIMIT()Ljava/util/HashMap;", 1))};
        b = SpongePreferenceManager.a().a("task_center_panel_daily_limit", new HashMap(), sl3.a.a);
        c = SpongePreferenceManager.a().a("task_center_panel_lifetime_limit", new HashMap(), sl3.a.f);
    }
}
