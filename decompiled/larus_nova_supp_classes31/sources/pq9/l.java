package pq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Long d;
    public final String e;
    public final String f;

    public l() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoTranscodeParam(transVideoWidth=" + this.a + ", transVideoHeight=" + this.b + ", transVideoFps=" + this.c + ", transVideoBitrate=" + this.d + ", transVideoCodec=" + this.e + ", transVideoType=" + this.f + ')';
    }

    public static l a(l r7, Integer r8, Integer r9, String r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        Integer r1 = r8;
        if ((r11 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        Integer r2 = r9;
        if ((r11 & 4) == 0) goto L11;
        Integer r3 = r7.c;
    L13:
        if ((r11 & 8) == 0) goto L15;
        Long r4 = r7.d;
    L17:
        if ((r11 & 16) == 0) goto L19;
        r10 = r7.e;
    L19:
        String r5 = r10;
        if ((r11 & 32) == 0) goto L22;
        String r6 = r7.f;
    L24:
        return new l(r1, r2, r3, r4, r5, r6);
    L22:
        r6 = null;
        goto L24
    L15:
        r4 = null;
        goto L17
    L11:
        r3 = null;
        goto L13
    }

    public l(Integer r1, Integer r2, Integer r3, Long r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
