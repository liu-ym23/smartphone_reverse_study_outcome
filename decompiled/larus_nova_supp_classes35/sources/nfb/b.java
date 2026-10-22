package nfb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final String a;
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;
    public final String h;
    public final String i;

    public static final class a {
        public long a;
        public final int b;
        public final int c;

        public a() {
            this.b = 1;
            this.c = 1;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        String r5 = this.g;
        int r6 = 0;
        if (r5 != null) goto L5;
        int r7 = 0;
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.h;
        if (r9 != null) goto L9;
        int r10 = 0;
    L10:
        int r11 = (r8 + r10) * 31;
        String r12 = this.i;
        if (r12 == null) goto L15;
        r6 = r12.hashCode();
    L15:
        return r11 + r6;
    L9:
        r10 = r9.hashCode();
        goto L10
    L5:
        r7 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "FolderPreviewLoadParams(key=" + this.a + ", start=" + this.b + ", step=" + this.c + ", orderType=" + this.d + ", orderDirection=" + this.e + ", downloadFileScene=" + this.f + ", previewId=" + this.g + ", authFileKey=" + this.h + ", msgLinkToken=" + this.i + ')';
    }

    public b(String r2, long r3, long r5, int r7, int r8, int r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
    }
}
