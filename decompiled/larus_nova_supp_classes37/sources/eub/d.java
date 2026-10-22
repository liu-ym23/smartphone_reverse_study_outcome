package eub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final int f;

    public d() {
        this(null, null, null, 0, 0, 0, 63);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.e;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.f;
    }

    public final String toString() {
        return "MmMinutesFileUploadFileParam(localPath=" + this.a + ", uriStr=" + this.b + ", fileName=" + this.c + ", fileSizeBytes=" + this.d + ", fileDurationMs=" + this.e + ", fileIndexInMinutes=" + this.f + ')';
    }

    public final String b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public static d a(d r10, String r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r11 = r10.a;
    L5:
        String r1 = r11;
        if ((r13 & 2) == 0) goto L8;
        String r2 = r10.b;
    L10:
        if ((r13 & 4) == 0) goto L12;
        String r3 = r10.c;
    L13:
        long r4 = 0;
        if ((r13 & 8) == 0) goto L16;
        long r6 = r10.d;
    L18:
        if ((r13 & 16) == 0) goto L20;
        r4 = r10.e;
    L20:
        long r8 = r4;
        if ((r13 & 32) == 0) goto L23;
        r12 = r10.f;
    L23:
        Intrinsics.checkNotNullParameter(r1, "localPath");
        Intrinsics.checkNotNullParameter(r2, "uriStr");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        return new d(r1, r2, r3, r6, r8, r12);
    L16:
        r6 = 0;
        goto L18
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    }

    public d(String r2, String r3, String r4, long r5, long r7, int r9) {
        Intrinsics.checkNotNullParameter(r2, "localPath");
        Intrinsics.checkNotNullParameter(r3, "uriStr");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
    }

    public /* synthetic */ d(String r9, String r10, String r11, long r12, long r14, int r16, int r17) {
        String r1 = "";
        if ((r17 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r17 & 4) != 0) goto L14;
        r1 = r11;
    L14:
        long r4 = 0;
        if ((r17 & 8) == 0) goto L17;
        long r6 = 0;
    L19:
        if ((r17 & 16) != 0) goto L23;
        r4 = r14;
    L23:
        if ((r17 & 32) == 0) goto L25;
        int r3 = 1;
    L26:
        this(r0, r2, r1, r6, r4, r3);
        return;
    L25:
        r3 = r16;
        goto L26
    L17:
        r6 = r12;
        goto L19
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r9;
        goto L7
    }
}
