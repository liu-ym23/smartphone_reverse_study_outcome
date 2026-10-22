package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public final RevenueJsDriver a;
    public final zy0.b b;
    public String c;

    public l(RevenueJsDriver r3, zy0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "impl");
        Intrinsics.checkNotNullParameter("0.0.0.0", Constants.Keys.VERSION);
        this.a = r3;
        this.b = r4;
        this.c = "0.0.0.0";
    }
}
