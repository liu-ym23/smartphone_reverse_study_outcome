package com.bytedance.android.live.ktv.common.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v {
    public final String a;
    public final c b;
    public final k c;

    public v(String r2, c r3, k r4) {
        Intrinsics.checkNotNullParameter(r2, "viewName");
        Intrinsics.checkNotNullParameter(r3, "viewStatistics");
        Intrinsics.checkNotNullParameter(r4, "statisticsHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
