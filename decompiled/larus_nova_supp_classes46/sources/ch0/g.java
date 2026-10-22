package ch0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public final String a;
    public int b;
    public int c;
    public int d;
    public int e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L16;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "RtcLocalUserInfo(interactId=" + this.a + ", videoCaptureStatus=" + this.b + ", audioCaptureStatus=" + this.c + ", videoPublishStatus=" + this.d + ", audioPublishStatus=" + this.e + ")";
    }

    public static g a(g r6) {
        String r1 = r6.a;
        int r2 = r6.b;
        int r3 = r6.c;
        int r4 = r6.d;
        int r5 = r6.e;
        Intrinsics.checkNotNullParameter(r1, "interactId");
        return new g(r1, r2, r3, r4, r5);
    }

    public g(String r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
