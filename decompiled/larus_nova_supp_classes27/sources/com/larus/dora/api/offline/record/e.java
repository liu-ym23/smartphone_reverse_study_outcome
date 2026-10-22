package com.larus.dora.api.offline.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public final String a;
    public final String b;
    public final int c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final String h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final String m;
    public final long n;
    public final String o;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.c) * 31;
        long r4 = this.d;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.e;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.f;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.g;
        int r11 = (((((((((((((r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m.hashCode()) * 31;
        long r12 = this.n;
        return ((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.o.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraOfflineSyncedRecording(vuiId=" + this.a + ", onlineRecordId=" + this.b + ", segmentType=" + this.c + ", startTimeMs=" + this.d + ", endTimeMs=" + this.e + ", durationMs=" + this.f + ", fileSize=" + this.g + ", fileFormat=" + this.h + ", sampleRate=" + this.i + ", channels=" + this.j + ", bitrateBps=" + this.k + ", frameMs=" + this.l + ", checksum=" + this.m + ", createdAtMs=" + this.n + ", localFilePath=" + this.o + ')';
    }

    public e(String r8, String r9, int r10, long r11, long r13, long r15, long r17, String r110, int r20, int r21, int r22, int r23, String r24, long r25, String r27) {
        Intrinsics.checkNotNullParameter(r8, "vuiId");
        Intrinsics.checkNotNullParameter(r110, "fileFormat");
        Intrinsics.checkNotNullParameter(r24, "checksum");
        Intrinsics.checkNotNullParameter(r27, "localFilePath");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r13;
        this.f = r15;
        this.g = r17;
        this.h = r110;
        this.i = r20;
        this.j = r21;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = r25;
        this.o = r27;
    }
}
