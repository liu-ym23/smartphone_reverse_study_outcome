package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.bytedance.android.live.base.model.message.n5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final long a(n5 r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$showDuration");
        n5.e r0 = r8.getDynamicConfig();
        if (r0 != null) goto L6;
        return 5000;
    L6:
        if (r0.endTimestamp > 0) goto L8;
        int r9 = r0.duration;
        if (r9 > 0) goto L15;
        return 5000;
    L15:
        return ((long) r9) * 1000;
    L8:
        if (r8.getShowTimestamp() <= 0) goto L10;
        long r1 = r0.endTimestamp;
        long r2 = r8.getShowTimestamp();
    L16:
        return r1 - r2;
    L10:
        r1 = r0.endTimestamp;
        r2 = System.currentTimeMillis();
        goto L16
    }
}
