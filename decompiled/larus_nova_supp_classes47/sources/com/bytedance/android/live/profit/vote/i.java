package com.bytedance.android.live.profit.vote;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "IS_KTV_VOTE_RED_DOT_SHOWN", "getIS_KTV_VOTE_RED_DOT_SHOWN()Z", 1))};
        b = SpongePreferenceManager.a().a("is_ktv_vote_red_dot_shown", Boolean.FALSE, Boolean.TYPE);
    }
}
