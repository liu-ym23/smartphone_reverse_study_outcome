package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final String a;
    public final LiveTracingMonitorKt.EventModule b;
    public final Map<String, Object> c;
    public final int d;
    public final String e;
    public final String f;
    public final long g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof g) == false) goto L20;
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r6.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LiveTracingMonitorKt.EventModule r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.d) * 31;
        String r10 = this.e;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.f;
        if (r14 == null) goto L21;
        r1 = r14.hashCode();
    L21:
        int r15 = (r13 + r1) * 31;
        long r16 = this.g;
        return r15 + ((int) (r16 ^ (r16 >>> 32)));
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkMonitorMeta(event=" + this.a + ", module=" + this.b + ", index=" + this.c + ", statusCode=" + this.d + ", statusMsg=" + this.e + ", logId=" + this.f + ", channelId=" + this.g + ")";
    }

    public g(String r2, LiveTracingMonitorKt.EventModule r3, Map<String, Object> r4, int r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "index");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
