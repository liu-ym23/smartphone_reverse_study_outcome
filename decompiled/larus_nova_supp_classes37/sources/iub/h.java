package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final long a;
    public final String b;
    public final long c;
    public final y d;
    public final f e;
    public final e f;
    public final String g;
    public final boolean h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r9 = (h) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        long r3 = this.c;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        y r4 = this.d;
        int r5 = 0;
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = (r2 + r6) * 31;
        f r8 = this.e;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r7 + r9) * 31;
        e r11 = this.f;
        if (r11 == null) goto L14;
        r5 = r11.hashCode();
    L14:
        int r12 = (((r10 + r5) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L17;
        int r13 = 1231;
    L19:
        return r12 + r13;
    L17:
        r13 = 1237;
        goto L19
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r6 = r4.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAsrContent(seqID=" + this.a + ", targetContent=" + this.b + ", relativeTimeMs=" + this.c + ", speaker=" + this.d + ", markedSpeaker=" + this.e + ", displaySpeaker=" + this.f + ", clusterId=" + this.g + ", canEditSpeaker=" + this.h + ')';
    }

    public h(long r2, String r4, long r5, y r7, f r8, e r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r4, "targetContent");
        Intrinsics.checkNotNullParameter(r10, "clusterId");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
    }
}
