package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final m a;
    public final i b;
    public final long c;

    public a(m r4, i r5) {
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r4, "requestParams");
        Intrinsics.checkNotNullParameter(r5, "dealSet");
        this.a = r4;
        this.b = r5;
        this.c = r1;
    }
}
