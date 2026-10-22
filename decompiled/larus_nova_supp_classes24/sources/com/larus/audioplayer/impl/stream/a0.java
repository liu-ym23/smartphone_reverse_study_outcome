package com.larus.audioplayer.impl.stream;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0 {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final short f;
    public final short g;
    public final int h;
    public final int i;
    public final short j;
    public final short k;
    public final String l;
    public final int m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l.hashCode()) * 31) + this.m;
    }

    public final String toString() {
        return "WavHeader(chunkId=" + this.a + ", chunkSize=" + this.b + ", format=" + this.c + ", subchunk1Id=" + this.d + ", subchunk1Size=" + this.e + ", audioFormat=" + this.f + ", channels=" + this.g + ", sampleRate=" + this.h + ", byteRate=" + this.i + ", blockAlign=" + this.j + ", bitsPerSample=" + this.k + ", subchunk2Id=" + this.l + ", subchunk2Size=" + this.m + ')';
    }

    public a0(String r2, int r3, String r4, String r5, int r6, short r7, short r8, int r9, int r10, short r11, short r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r2, "chunkId");
        Intrinsics.checkNotNullParameter(r4, "format");
        Intrinsics.checkNotNullParameter(r5, "subchunk1Id");
        Intrinsics.checkNotNullParameter(r13, "subchunk2Id");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
