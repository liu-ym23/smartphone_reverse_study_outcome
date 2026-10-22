package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u0 implements Comparable<u0> {
    public static final long b = 0;
    public static final long c = 0;
    public static final long d = 0;
    public static final long e = 0;
    public static final u0 f = null;
    public static final u0 g = null;
    public static final u0 h = null;
    public static final u0 i = null;
    public static final u0 j = null;
    public static final u0 k = null;
    public static final a l = null;
    public final long a;

    public static final class a {
        public a() {
        }

        public static u0 a(long r3) {
            return new u0(r3 * u0.b);
        }
    }

    public /* synthetic */ u0() {
        throw null;
    }

    static {
        l = new a();
        long r0 = WebcastRedirectException.UNKNOWN;
        b = r0;
        long r2 = 60000;
        c = r2;
        long r4 = 3600000;
        d = r4;
        long r6 = 86400000;
        e = r6;
        f = new u0(0);
        g = new u0(r0);
        h = new u0(r2);
        i = new u0(r4);
        j = new u0(r6);
        k = new u0(r6 * ((long) 7));
    }

    public final int hashCode() {
        long r0 = this.a;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        long r0 = this.a;
        long r2 = 0;
        if (r0 != r2) goto L5;
        return "0s";
    L5:
        long r4 = d;
        if ((r0 % r4) != r2) goto L8;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.a / r4);
        r1.append('h');
        return r1.toString();
    L8:
        long r5 = c;
        if ((r0 % r5) != r2) goto L11;
        StringBuilder r3 = new StringBuilder();
        r3.append(this.a / r5);
        r3.append('m');
        return r3.toString();
    L11:
        long r6 = b;
        if ((r0 % r6) != r2) goto L15;
        StringBuilder r7 = new StringBuilder();
        r7.append(this.a / r6);
        r7.append('s');
        return r7.toString();
    L15:
        return this.a + "ms";
    }

    public u0(long r1) {
        this.a = r1;
    }

    public final int a(u0 r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return (this.a > r5.a ? 1 : (this.a == r5.a ? 0 : -1));
    }

    public final u0 b(u0 r6) {
        Intrinsics.checkNotNullParameter(r6, "rhs");
        return new u0(this.a - r6.a);
    }

    public final u0 c(u0 r6) {
        Intrinsics.checkNotNullParameter(r6, "rhs");
        return new u0(this.a + r6.a);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(u0 r1) {
        return a(r1);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof u0) == true) goto L7;
        return super.equals(r5);
    L7:
        if (this.a != ((u0) r5).a) goto L9;
        return true;
    L9:
        return false;
    }
}
