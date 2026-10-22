package k11;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final Map<String, String> a;
    public final long b;
    public final Map<String, String> c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L12;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Map<String, String> r5 = this.c;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicLinkInfo(logMap=" + this.a + ", channelId=" + this.b + ", battleParams=" + this.c + ")";
    }

    public c(Map<String, String> r1, long r2, Map<String, String> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
