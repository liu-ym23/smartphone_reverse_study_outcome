package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(v.class, "GIFT_ICON_TOUCH_MAP", "getGIFT_ICON_TOUCH_MAP()Ljava/util/HashMap;", 1))};
        b = SpongePreferenceManager.a().a("gift_icon_touch_map", new HashMap(), ql3.a.z);
    }
}
