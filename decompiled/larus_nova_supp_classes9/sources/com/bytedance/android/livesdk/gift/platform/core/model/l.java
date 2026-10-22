package com.bytedance.android.livesdk.gift.platform.core.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> a;
    public final long b;
    public final int c;
    public final long d;
    public final String e;

    public final List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> a() {
        return this.a;
    }

    public l(List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r2, long r3, int r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r2, "giftPages");
        Intrinsics.checkNotNullParameter(r8, "logId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
    }
}
