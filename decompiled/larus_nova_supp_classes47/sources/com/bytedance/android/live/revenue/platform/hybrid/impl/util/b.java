package com.bytedance.android.live.revenue.platform.hybrid.impl.util;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final HybridType a(IHybridComponent.HybridType r1) {
        Intrinsics.checkNotNullParameter(r1, "annieHybridType");
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return HybridType.LYNX;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return HybridType.H5;
    }
}
