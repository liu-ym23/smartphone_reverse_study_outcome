package com.bytedance.android.live.revenue.platform.network.impl;

import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b implements INetworkService {
    public final ConcurrentHashMap<INetworkService.Biz, List<com.bytedance.android.livesdk.revenue.network.a>> a;

    public b() {
        this.a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.INetworkService
    public final void K0(INetworkService.Biz r3, com.bytedance.android.livesdk.revenue.network.a r4) {
        Intrinsics.checkNotNullParameter(r3, "biz");
        Intrinsics.checkNotNullParameter(r4, "middleware");
        List<com.bytedance.android.livesdk.revenue.network.a> r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        this.a.put(r3, CollectionsKt.minus(r0, r4));
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.INetworkService
    public final void s(INetworkService.Biz r3, com.bytedance.android.livesdk.revenue.network.a r4) {
        Intrinsics.checkNotNullParameter(r3, "biz");
        Intrinsics.checkNotNullParameter(r4, "middleware");
        List<com.bytedance.android.livesdk.revenue.network.a> r0 = this.a.get(r3);
        ConcurrentHashMap<INetworkService.Biz, List<com.bytedance.android.livesdk.revenue.network.a>> r1 = this.a;
        if (r0 == null) goto L5;
        List<com.bytedance.android.livesdk.revenue.network.a> r5 = CollectionsKt.plus(r0, r4);
    L6:
        r1.put(r3, r5);
        return;
    L5:
        r5 = CollectionsKt.listOf(r4);
        goto L6
    }
}
