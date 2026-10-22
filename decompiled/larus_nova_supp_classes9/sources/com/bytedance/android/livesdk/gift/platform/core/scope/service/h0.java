package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 extends lq2.b {
    public final /* synthetic */ g0 a;

    public h0(g0 r1) {
        this.a = r1;
    }

    public final void b(Map r2, lq2.c r3) {
        Intrinsics.checkNotNullParameter(r2, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        this.a.b.setValue(Boolean.FALSE);
    }

    public final boolean a(int r1, Map r2, lq2.c r3) {
        Intrinsics.checkNotNullParameter(r2, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        this.a.b.setValue(Boolean.TRUE);
        return false;
    }
}
