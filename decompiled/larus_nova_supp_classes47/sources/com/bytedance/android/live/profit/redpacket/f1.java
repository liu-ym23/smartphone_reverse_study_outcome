package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f1 implements com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f {
    public final /* synthetic */ xr2.g a;
    public final /* synthetic */ RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 b;

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void a() {
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void c() {
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void onFallback() {
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void e(com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r2) {
        Intrinsics.checkNotNullParameter(r2, "sharer");
        Intrinsics.checkNotNullParameter(r2, "sharer");
    }

    public f1(xr2.g r1, RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f
    public final void b(String r2, LoadFailCode r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.CODE);
        this.b.m213invoke();
    }
}
