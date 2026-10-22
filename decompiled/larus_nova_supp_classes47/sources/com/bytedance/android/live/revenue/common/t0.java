package com.bytedance.android.live.revenue.common;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0 {
    public static u0 a;

    static {
        u0 r0 = u0.f;
        a = u0.f;
        new u0(500);
    }

    public static final u0 b() {
        Intrinsics.checkNotNullParameter(u0.l, "$this$now");
        i97.a r0 = i97.a.a;
        return new u0(System.currentTimeMillis());
    }

    public static final boolean a(KMutableProperty0<u0> r2, u0 r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "minInterval");
        u0 r0 = u0.f;
        u0 r1 = b();
        u0 r4 = r1.b((u0) r2.get());
        r2.set(r1);
        if (r4.a(r3) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
