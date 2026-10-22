package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g5 {
    public static final /* synthetic */ int c = 0;
    public final long a;
    public final String b;

    public static final class a {
        public static g5 a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "reason");
            return new g5(i0.b(System.currentTimeMillis()), r3);
        }
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g5) == true) goto L8;
        return false;
    L8:
        g5 r9 = (g5) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "LabelingObserveRequest(earliestTimeMillis=" + this.a + ", reason=" + this.b + ')';
    }

    public static h5 a(g5 r5) {
        long r0 = System.currentTimeMillis();
        r5.getClass();
        long r3 = r5.a;
        return new h5(r3, RangesKt.coerceAtLeast(r0, r3));
    }

    public g5(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        this.a = r2;
        this.b = r4;
    }
}
