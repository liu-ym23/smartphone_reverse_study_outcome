package com.bytedance.android.live.profit.vip;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final List<Long> a;
    public long b;

    public b() {
        this(null, 3);
    }

    public b(List r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayList();
    L5:
        Intrinsics.checkNotNullParameter(r1, "exposedEmojiIdList");
        this.a = r1;
        this.b = 0;
    }
}
