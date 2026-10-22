package jx9;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import ic8.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final String a;
    public final int b;
    public final k0 c;
    public final String d;
    public final long e;
    public long f;
    public long g;
    public long h;
    public NexPulseResponseData i;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.f;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.g;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.h;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        NexPulseResponseData r9 = this.i;
        if (r9 != null) goto L5;
        int r10 = 0;
    L7:
        return r8 + r10;
    L5:
        r10 = r9.hashCode();
        goto L7
    }

    public final String toString() {
        return "WcbTraceData(conversationId=" + this.a + ", nexPulseScene=" + this.b + ", params=" + this.c + ", reqSrc=" + this.d + ", apiStartTs=" + this.e + ", apiFinishTs=" + this.f + ", msgFinishTs=" + this.g + ", lastWcbUpdateTime=" + this.h + ", response=" + this.i + ')';
    }

    public a(String r2, int r3, k0 r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
    }
}
