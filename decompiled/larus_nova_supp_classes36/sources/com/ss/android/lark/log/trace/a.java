package com.ss.android.lark.log.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public long a;
    public long b;

    public final long a() {
        long r0 = this.a;
        if (r0 <= 0) goto L7;
        long r4 = this.b;
        if (r4 <= 0) goto L7;
        return r4 - r0;
    L7:
        return -1;
    }

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "step");
        this.a = 0;
        this.b = -1;
    }
}
