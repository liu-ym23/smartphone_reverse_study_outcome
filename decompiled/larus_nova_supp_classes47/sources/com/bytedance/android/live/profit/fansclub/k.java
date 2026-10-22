package com.bytedance.android.live.profit.fansclub;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(k.class, "DH_LIVE_FANS_GROUP_URL", "getDH_LIVE_FANS_GROUP_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "DH_LIVE_FANS_GROUP_ANCHOR_URL", "getDH_LIVE_FANS_GROUP_ANCHOR_URL()Ljava/lang/String;", 1))};
        a = r0;
        KmpEnv r1 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        String r2 = "https://webcast.amemv.com/falcon/webcast_douyin/page/fansclub_2020/fansclub_user/index.html";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fans_group_url", r2, String.class, false);
        b = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[0]);
        if (KmpEnv.a() == false) goto L9;
        String r4 = "https://webcast.amemv.com/falcon/webcast_douyin/page/fansclub_2020/fansclub_anchor/index.html";
    L10:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fans_group_anchor_url", r4, String.class, false);
        c = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[1]);
        return;
    L9:
        r4 = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/fansclub_2020/fansclub_anchor/index.html";
        goto L10
    L5:
        r2 = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/fansclub_2020/fansclub_user/index.html";
        goto L6
    }
}
