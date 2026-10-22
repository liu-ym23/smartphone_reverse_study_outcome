package com.bytedance.android.live.profit.vote;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_VOTE_CONFIG", "getLIVE_VOTE_CONFIG()Lcom/bytedance/android/live/profit/vote/LiveVoteConfig;", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_GIFT_CLOSE_ANCHOR_BLOCK_SWITCH", "getLIVE_GIFT_CLOSE_ANCHOR_BLOCK_SWITCH()Z", 1))};
        a = r0;
        LiveVoteConfig.a.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_vote_config", (LiveVoteConfig) LiveVoteConfig.Companion.a.getValue(), LiveVoteConfig.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_close_anchor_block_switch", Boolean.TRUE, Boolean.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }

    public static final LiveVoteConfig a() {
        return (LiveVoteConfig) b.getValue(null, a[0]);
    }
}
