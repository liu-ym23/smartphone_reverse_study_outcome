package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "DSAssetShowTimes", "getDSAssetShowTimes()Ljava/util/Set;", 1))};
        b = SpongePreferenceManager.a().a("ds_asset_show_times", SetsKt.emptySet(), ql3.a.I);
    }
}
