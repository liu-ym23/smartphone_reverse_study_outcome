package pea;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int d = 0;
    public final int a;
    public final c b;
    public final pea.a c;

    public static final class a {
        public static b a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "pic");
            int r1 = c.e;
            return new b(c.a.a(r2, r3, null), 5);
        }
    }

    static {
    }

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        c r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        pea.a r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "BigIslandImageTextInfo(type=" + this.a + ", picInfo=" + this.b + ", textInfo=" + this.c + ')';
    }

    public final int getType() {
        return this.a;
    }

    public b(c r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        int r0 = 1;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        this.a = r0;
        this.b = r3;
        this.c = null;
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
