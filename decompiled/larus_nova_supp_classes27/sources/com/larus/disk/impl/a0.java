package com.larus.disk.impl;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a0 {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final Map<DiskFileType, Long> b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "DiskFileTypeSummary(status=" + this.a + ", sizeBytes=" + this.b + ", unreadablePathCount=" + this.c + ')';
    }

    public final long a() {
        Iterator<T> r0 = this.b.values().iterator();
        long r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        long r5 = RangesKt.coerceAtLeast(((Number) r0.next()).longValue(), 0);
        if ((com.larus.dora.impl.ota.g2.j0.G2_OTA_RECOVERY_BLOCK_FOREVER - r3) < r5) goto L7;
        r3 = r3 + r5;
        goto L4
    L7:
        r3 = Long.MAX_VALUE;
        goto L4
    L9:
        return r3;
    }

    public final long b(DiskFileType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Long r4 = this.b.get(r3);
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.longValue();
    }

    public a0(String r2, Map<DiskFileType, Long> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "sizeBytes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
