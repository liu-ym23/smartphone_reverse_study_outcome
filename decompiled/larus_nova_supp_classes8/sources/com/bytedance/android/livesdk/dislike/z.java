package com.bytedance.android.livesdk.dislike;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z extends n {
    public final pt1.a c;
    public final com.bytedance.android.livesdk.dislike.action.y d;

    public z(pt1.a r2, com.bytedance.android.livesdk.dislike.action.y r3, ItemType r4) {
        Intrinsics.checkNotNullParameter(r2, "shareFansHelper");
        Intrinsics.checkNotNullParameter(r3, "shareFansAction");
        Intrinsics.checkNotNullParameter(r4, "identity");
        super(r4, r3);
        this.c = r2;
        this.d = r3;
    }
}
