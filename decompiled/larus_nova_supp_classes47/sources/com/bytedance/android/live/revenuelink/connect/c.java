package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class c implements i {
    public c() {
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void Z2(fy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "finishParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void h3(fy.f r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "joinChannelParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void i3(fy.d r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "finishParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void k3(fy.h r1, ExtraResponse<n0, Extra> r2) {
        Intrinsics.checkNotNullParameter(r1, "leaveParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void m2(fy.h r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "leaveParams");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.i
    public void m3(fy.f r2, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r3) {
        Intrinsics.checkNotNullParameter(r2, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r3, "response");
    }
}
