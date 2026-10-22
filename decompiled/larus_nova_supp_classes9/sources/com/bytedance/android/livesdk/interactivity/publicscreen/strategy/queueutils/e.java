package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final m a;
    public final m b;
    public final m c;

    public final m a(PSMessageHeatState r2) {
        Intrinsics.checkNotNullParameter(r2, "heatState");
        int r3 = d.a[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return this.c;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return this.b;
    L13:
        return this.a;
    }

    public e(m r2, m r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "hotPollConfig");
        Intrinsics.checkNotNullParameter(r3, "normalPollConfig");
        Intrinsics.checkNotNullParameter(r4, "coldPollConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
