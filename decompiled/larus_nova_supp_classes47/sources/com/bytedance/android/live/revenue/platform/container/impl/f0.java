package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.platform.aio.ServiceHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0 implements com.bytedance.platform.aio.channel.d {
    public final /* synthetic */ RevenueJsDriver a;
    public final /* synthetic */ com.bytedance.platform.aio.c b;

    public final void onRegister(String r3) {
        Intrinsics.checkNotNullParameter(r3, "interfaceId");
        this.b.a(r3, this.a);
        jy0.b.d("RevenueJsDriver", "onRegister" + r3);
    }

    public f0(RevenueJsDriver r1, ServiceHub r2) {
        this.a = r1;
        this.b = r2;
    }
}
