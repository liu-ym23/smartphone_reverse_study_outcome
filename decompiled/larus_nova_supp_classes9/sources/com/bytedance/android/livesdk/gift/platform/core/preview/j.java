package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(j.class, "INTERACT_GIFT_PANEL_SET_TOP_SHOW_RED_DOT", "getINTERACT_GIFT_PANEL_SET_TOP_SHOW_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(j.class, "INTERACT_GIFT_PANEL_SHOW_NOTICE", "getINTERACT_GIFT_PANEL_SHOW_NOTICE()Z", 1))};
        com.bytedance.tools.kcp.spongepreference.runtime.b r0 = SpongePreferenceManager.a();
        Boolean r1 = Boolean.TRUE;
        Class r2 = Boolean.TYPE;
        b = r0.a("interace_gift_panel_set_top_show_red_dot", r1, r2);
        c = SpongePreferenceManager.a().a("interace_gift_panel_show_notice", r1, r2);
    }
}
