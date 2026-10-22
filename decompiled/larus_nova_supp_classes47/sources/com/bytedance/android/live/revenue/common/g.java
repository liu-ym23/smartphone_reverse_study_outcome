package com.bytedance.android.live.revenue.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final String a;
    public final String b;

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        int r0 = v.a;
        v.a(this.b, e(r2));
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        int r0 = v.a;
        v.e(this.b, e(r2));
    }

    public final void c(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        int r0 = v.a;
        v.b(this.b, this.a, r3);
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        int r0 = v.a;
        v.h(this.b, e(r2));
    }

    public final String e(String r3) {
        return this.a + ' ' + r3;
    }

    public g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.b = r2;
        if (r3 != null) goto L5;
        r3 = "[" + Integer.toHexString(hashCode()) + ']';
    L5:
        this.a = r3;
    }
}
