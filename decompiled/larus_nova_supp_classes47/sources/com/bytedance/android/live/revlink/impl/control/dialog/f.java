package com.bytedance.android.live.revlink.impl.control.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final int a;
    public final String b;
    public final Throwable c;
    public final long d;
    public final long e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L16;
        f r7 = (f) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Throwable r5 = this.c;
        if (r5 == null) goto L9;
        r2 = r5.hashCode();
    L9:
        long r6 = this.d;
        int r7 = (((r4 + r2) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "RecommendFailCacheData(loadType=" + this.a + ", activityId=" + this.b + ", throwable=" + this.c + ", startLoadingTs=" + this.d + ", loadedTs=" + this.e + ")";
    }

    public f(int r2, String r3, Throwable r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r3, "activityId");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }
}
