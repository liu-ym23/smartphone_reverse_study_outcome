package com.bytedance.gkfs.cdc;

import ai.j0;
import com.bytedance.gkfs.io.n;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f4825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4827c;
    public final Map d;
    public final Map e;
    public final long f;

    static {
        g = new c(null, 0, 63);
    }

    public c(n r10, long r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r10 = n.d;
    L5:
        n r5 = r10;
        Map r13 = MapsKt.emptyMap();
        Map r14 = MapsKt.emptyMap();
        if ((r12 & 32) == 0) goto L8;
        r11 = 0;
    L8:
        this(r5, 0, 0, r13, r14, r11);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L18;
        c r10 = (c) r5;
        n r11 = r10.f4825a;
        if (Intrinsics.areEqual(this.f4825a, r11) == true) goto L8;
        return false;
    L8:
        if (this.f4826b == r10.f4826b) goto L10;
        return false;
    L10:
        if (this.f4827c == r10.f4827c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r10.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        n r10 = this.f4825a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = ((((r11 * 31) + this.f4826b) * 31) + this.f4827c) * 31;
        Map r13 = this.d;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        Map r16 = this.e;
        if (r16 == null) goto L13;
        r5 = r16.hashCode();
    L13:
        long r17 = this.f;
        return ((r15 + r5) * 31) + ((int) (r17 ^ (r17 >>> 32)));
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GkFSCDCStatistics(status=");
        r5.append(this.f4825a);
        r5.append(", minSizeSuppress=");
        r5.append(this.f4826b);
        r5.append(", maxSizeSuppress=");
        r5.append(this.f4827c);
        r5.append(", chunkCDCTimeCost=");
        r5.append(this.d);
        r5.append(", chunkTimeCost=");
        r5.append(this.e);
        r5.append(", totalTimeCost=");
        return j0.o(r5, this.f, ")");
    }

    public c(n r5, int r10, int r11, Map r12, Map r13, long r14) {
        this.f4825a = r5;
        this.f4826b = r10;
        this.f4827c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
