package com.bytedance.android.live.profit.livepet.container;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public static final String a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$describe");
        return r4 + " [" + r4.getLeft() + ", " + r4.getTop() + ", " + r4.getRight() + ", " + r4.getBottom() + "] " + b(r4);
    }

    public static final RectF b(a r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$toNormalizedRect");
        a r0 = r8.getRoot();
        Intrinsics.checkNotNullParameter(r0, "$this$getWidth");
        float r1 = Math.max(0, r0.getRight() - r0.getLeft());
        Intrinsics.checkNotNullParameter(r0, "$this$getHeight");
        float r2 = Math.max(0, r0.getBottom() - r0.getTop());
        float r3 = 0.0f;
        if (r1 != 0.0f) goto L5;
        float r5 = 0.0f;
    L7:
        if (r2 != 0.0f) goto L9;
        float r7 = 0.0f;
    L10:
        if (r1 != 0.0f) goto L12;
        float r4 = 0.0f;
    L13:
        if (r2 == 0.0f) goto L17;
        r3 = r8.getBottom() / r2;
    L17:
        return new RectF(r5, r7, r4, r3);
    L12:
        r4 = r8.getRight() / r1;
        goto L13
    L9:
        r7 = r8.getTop() / r2;
        goto L10
    L5:
        r5 = r8.getLeft() / r1;
        goto L7
    }
}
