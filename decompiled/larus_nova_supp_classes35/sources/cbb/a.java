package cbb;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public boolean a;
    public long b;
    public final Map<String, String> c;

    public a() {
        this(false, 0, 7);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.b;
        return (((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CleanResult(isSuccess=" + this.a + ", cleanSize=" + this.b + ", extra=" + this.c + ')';
    }

    public a(boolean r2, long r3, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        HashMap r6 = new HashMap();
    L12:
        Intrinsics.checkNotNullParameter(r6, "extra");
        this.a = r2;
        this.b = r3;
        this.c = r6;
        return;
    L11:
        r6 = null;
        goto L12
    }
}
