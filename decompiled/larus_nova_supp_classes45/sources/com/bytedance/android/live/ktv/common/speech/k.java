package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.livesdk.message.model.MusicInterval;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public final int a;
    public final String b;
    public final String c;
    public final double d;
    public final int e;
    public final int f;
    public final long g;
    public final String h;
    public final int i;
    public final String j;
    public final String k;
    public final List<MusicInterval> l;
    public final String m;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L32;
        k r7 = (k) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.d, r7.d) == 0) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        long r7 = Double.doubleToLongBits(this.d);
        int r8 = (((((((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.e) * 31) + this.f) * 31;
        long r9 = this.g;
        int r11 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        String r12 = this.h;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (((r11 + r13) * 31) + this.i) * 31;
        String r15 = this.j;
        if (r15 == null) goto L17;
        int r16 = r15.hashCode();
    L18:
        int r17 = (r14 + r16) * 31;
        String r18 = this.k;
        if (r18 == null) goto L21;
        int r19 = r18.hashCode();
    L22:
        int r21 = (r17 + r19) * 31;
        List<MusicInterval> r22 = this.l;
        if (r22 == null) goto L25;
        int r23 = r22.hashCode();
    L26:
        int r24 = (r21 + r23) * 31;
        String r25 = this.m;
        if (r25 == null) goto L30;
        r2 = r25.hashCode();
    L30:
        return r24 + r2;
    L25:
        r23 = 0;
        goto L26
    L21:
        r19 = 0;
        goto L22
    L17:
        r16 = 0;
        goto L18
    L13:
        r13 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "RecognitionResult(type=" + this.a + ", songId=" + this.b + ", songUrl=" + this.c + ", matchEndTime=" + this.d + ", songDuration=" + this.e + ", similarity=" + this.f + ", startTime=" + this.g + ", songName=" + this.h + ", lyricType=" + this.i + ", artistName=" + this.j + ", songEmoTag=" + this.k + ", musicClimax=" + this.l + ", fontInfo=" + this.m + ")";
    }

    public final int getType() {
        return this.a;
    }

    public k(int r7, String r8, String r9, double r11, int r12, int r13, long r14, String r16, int r17, String r18, String r19, List<MusicInterval> r21, String r22) {
        Intrinsics.checkNotNullParameter(r8, "songId");
        Intrinsics.checkNotNullParameter(r9, "songUrl");
        Intrinsics.checkNotNullParameter(r16, "songName");
        Intrinsics.checkNotNullParameter(r18, "artistName");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r21;
        this.m = r22;
    }
}
