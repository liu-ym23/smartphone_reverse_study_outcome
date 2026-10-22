package com.larus.bmhome.chat.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p0 {
    public final boolean a;
    public final long b;
    public final long c;
    public final String d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r9 = (p0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.b;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L11:
        return r4 + r6;
    L9:
        r6 = r5.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SpeakInfo(isSpeakHandsFree=" + this.a + ", speakDuration=" + this.b + ", handsfreeSpeakDuration=" + this.c + ", handsfreeEnterMethod=" + this.d + ')';
    }

    public final String a() {
        return this.d;
    }

    public final long b() {
        return this.c;
    }

    public final long c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public p0(boolean r1, long r2, long r4, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }
}
