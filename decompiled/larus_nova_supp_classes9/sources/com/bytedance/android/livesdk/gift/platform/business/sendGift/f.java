package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.livesdk.gift.model.h3;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final Set<Long> a;
    public final long b;
    public final boolean c;
    public final Exception d;
    public final h3 e;

    public f(Set<Long> r2, long r3, boolean r5, Exception r6, h3 r7) {
        Intrinsics.checkNotNullParameter(r2, "giftIds");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
