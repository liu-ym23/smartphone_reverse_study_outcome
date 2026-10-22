package i12;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final long a;
    public final int b;
    public final int c;
    public final Map<String, String> d;
    public final String e;
    public final String f;

    public c() {
        this(null);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L18;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31;
        Map<String, String> r2 = this.d;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.e;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.f;
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        return r8 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftLocationInfo(giftId=" + this.a + ", pageType=" + this.b + ", buffLevel=" + this.c + ", logExtra=" + this.d + ", giftSendExtra=" + this.e + ", args=" + this.f + ")";
    }

    public c(Object r3) {
        this.a = -1;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
    }
}
