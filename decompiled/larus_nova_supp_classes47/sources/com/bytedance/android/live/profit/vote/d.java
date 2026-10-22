package com.bytedance.android.live.profit.vote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final boolean a(com.bytedance.android.live.profit.vote.model.c r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$isActive");
        VoteState r0 = (VoteState) r6.a.d;
        int r1 = c.a[r0.ordinal()];
        if (r1 == 1) goto L8;
        if (r1 == 2) goto L8;
    L10:
        return false;
    L8:
        if (r6.a() <= 0) goto L10;
        return true;
    }
}
