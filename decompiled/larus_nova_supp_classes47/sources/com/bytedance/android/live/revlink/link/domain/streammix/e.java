package com.bytedance.android.live.revlink.link.domain.streammix;

import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Comparator {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r8, Object r9) {
        IRegion r10 = (IRegion) r8;
        IRegion r12 = (IRegion) r9;
        Intrinsics.checkNotNullParameter(r10, "regionL");
        Intrinsics.checkNotNullParameter(r12, "regionR");
        if (r10.getY() == r12.getY()) goto L8;
        if (r10.getY() >= r12.getY()) goto L14;
    L6:
        return -1;
    L14:
        return 1;
    L8:
        if (r10.getX() != r12.getX()) goto L10;
        return 0;
    L10:
        if (r10.getX() < r12.getX()) goto L6;
        return 1;
    }
}
