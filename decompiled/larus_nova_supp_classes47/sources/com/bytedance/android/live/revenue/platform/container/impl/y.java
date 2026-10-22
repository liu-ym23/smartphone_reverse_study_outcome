package com.bytedance.android.live.revenue.platform.container.impl;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y {
    public final String a;
    public final Method b;

    public y(String r2, Method r3) {
        Intrinsics.checkNotNullParameter(r2, "methodId");
        Intrinsics.checkNotNullParameter(r3, "methodInstance");
        this.a = r2;
        this.b = r3;
    }
}
