package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public static final l c = null;
    public final String a;
    public final f3.a b;

    public static final class a {
        public static l a(String r1, f3.a r10) {
            Intrinsics.checkNotNullParameter(r1, "errorMessage");
            Intrinsics.checkNotNullParameter(r10, "errNo");
            return new l(r1, r10);
        }
    }

    public l() {
        this(null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof l) == true) goto L8;
        return false;
    L8:
        l r11 = (l) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String toString() {
        return "LocationActionResult(errorMessage=" + this.a + ", errNo=" + this.b + ')';
    }

    static {
        c = new l(null, null);
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        f3.a r12 = this.b;
        if (r12 == null) goto L11;
        r1 = r12.a;
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public l(String r1, f3.a r10) {
        this.a = r1;
        this.b = r10;
    }
}
