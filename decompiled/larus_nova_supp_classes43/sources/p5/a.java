package p5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final long b;
    public final String c;
    public final String d;
    public final b e;
    public final String f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r10 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31;
        String r11 = this.d;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        b r15 = this.e;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return ((r14 + r12) * 31) + this.f.hashCode();
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletResponse(response=" + this.a + ", version=" + this.b + ", resFrom=" + this.c + ", filePath=" + this.d + ", byteArray=" + this.e + ", uri=" + this.f + ')';
    }

    public a(String r10, long r11, String r12, String r13, b r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "response");
        Intrinsics.checkNotNullParameter(r12, "resFrom");
        Intrinsics.checkNotNullParameter(r15, "uri");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }
}
