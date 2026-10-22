package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public final int a;
    public final int b;
    public final int c;

    public m(List<Integer> r2) {
        this.a = a(r2, 0);
        this.b = a(r2, 1);
        this.c = a(r2, 2);
    }

    public final int b(PSMessagePriority r2) {
        Intrinsics.checkNotNullParameter(r2, "priority");
        int r3 = l.a[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return this.b;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return this.c;
    L13:
        return this.a;
    }

    public static int a(List r1, int r2) {
        if (r1 == null) goto L9;
        if (r2 >= 0) goto L5;
        return 1;
    L5:
        if (r2 < r1.size()) goto L8;
        return 1;
    L8:
        return ((Number) ListProtector.get(r1, r2)).intValue();
    L9:
        return 1;
    }
}
