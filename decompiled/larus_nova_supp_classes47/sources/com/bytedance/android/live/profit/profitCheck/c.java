package com.bytedance.android.live.profit.profitCheck;

import com.bytedance.android.live.profit.privilege.model.ReportType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final d a;
    public final ReportType b;
    public final long c;
    public final Map<String, String> d;
    public final Map<String, Object> e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L16;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        d r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ReportType r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        Map<String, String> r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r12 = (r8 + r10) * 31;
        Map<String, Object> r13 = this.e;
        if (r13 == null) goto L18;
        r1 = r13.hashCode();
    L18:
        return r12 + r1;
    L13:
        r10 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProfitCheckTask(type=" + this.a + ", reportType=" + this.b + ", expireTime=" + this.c + ", traceMetaData=" + this.d + ", traceIndexData=" + this.e + ")";
    }

    public final d getType() {
        return this.a;
    }

    public c(d r2, ReportType r3, long r4, Map<String, String> r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "reportType");
        Intrinsics.checkNotNullParameter(r6, "traceMetaData");
        Intrinsics.checkNotNullParameter(r7, "traceIndexData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
