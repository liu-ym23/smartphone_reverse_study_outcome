package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final b c = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "LIVE_GIFT_VOTE_PB_ENABLE", "getLIVE_GIFT_VOTE_PB_ENABLE()Z", 0))};
        a = r0;
        c = new b();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_vote_pb_enable", Boolean.FALSE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
    }

    public b() {
    }

    public static Observable a(long r10, String r12) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r13 = Long.valueOf(r10).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r13 == null) goto L5;
        r2.put("room_id", r13);
    L5:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r2.put("request_source", r12);
        b r14 = c;
        r14.getClass();
        x.a(r1, ((Boolean) b.getValue(r14, a[0])).booleanValue());
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/gift/vote/list/", TypesJVMKt.getJavaType(Reflection.typeOf(a.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }
}
