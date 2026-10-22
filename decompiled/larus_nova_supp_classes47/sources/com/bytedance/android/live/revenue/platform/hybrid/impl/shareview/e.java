package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T, R> implements Function {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r3) {
        com.bytedance.android.live.revenue.platform.container.impl.core.h r4 = (com.bytedance.android.live.revenue.platform.container.impl.core.h) r3;
        Intrinsics.checkNotNullParameter(r4, "mgr");
        zy0.b r1 = r4.D();
        Intrinsics.checkNotNull(r1);
        return new d(r4, r1);
    }
}
