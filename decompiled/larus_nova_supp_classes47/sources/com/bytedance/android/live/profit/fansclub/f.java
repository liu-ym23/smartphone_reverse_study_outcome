package com.bytedance.android.live.profit.fansclub;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "LIVE_JOIN_FANS_CLUB_INCENTIVE_ANIM", "getLIVE_JOIN_FANS_CLUB_INCENTIVE_ANIM()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "FANS_CLUB_GUIDE_LAST_DATE", "getFANS_CLUB_GUIDE_LAST_DATE()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "FANS_CLUB_GUIDE_ANCHOR_LIST", "getFANS_CLUB_GUIDE_ANCHOR_LIST()Ljava/util/List;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "LIVE_FANS_GROUP_PANEL_HAS_OPENED_UID", "getLIVE_FANS_GROUP_PANEL_HAS_OPENED_UID()Ljava/util/List;", 1))};
        b = SpongePreferenceManager.a().a("live_join_fans_club_incentive_anim", new HashMap(), sl3.a.b);
        c = SpongePreferenceManager.a().a("fans_club_guide_last_date", 0L, Long.TYPE);
        d = SpongePreferenceManager.a().a("fans_club_guide_anchor_list", new ArrayList(), sl3.a.e);
        e = SpongePreferenceManager.a().a("live_fans_group_panel_has_opened_uid", new ArrayList(), sl3.a.d);
    }
}
