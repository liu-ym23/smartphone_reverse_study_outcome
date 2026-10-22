package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(k0.class, "LAST_SEND_CONFIRM_IDS", "getLAST_SEND_CONFIRM_IDS()Ljava/util/Set;", 1))};
        b = SpongePreferenceManager.a().a("last_send_confirm_ids", new LinkedHashSet(), ql3.a.j);
    }
}
