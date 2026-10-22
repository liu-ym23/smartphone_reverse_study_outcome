package ns9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s {
    public final int a;
    public final Long b;
    public final String c;

    /* JADX WARN: Multi-variable type inference failed */
    public s() {
        int r2 = 0;
        Object[] r0 = 0 == true ? 1 : 0;
        this(r2, null, r0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Long r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachPolicy(priority=" + this.a + ", durationMs=" + this.b + ", dismissal=" + this.c + ')';
    }

    public s(int r1, Long r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public /* synthetic */ s(int r3, Long r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        this(r3, r4, r5);
    }
}
