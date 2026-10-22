package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final String a;
    public final int b;
    public final String c;
    public final long d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;
    public final ConflictStrategy i;
    public final ConflictStrategy j;
    public final ConflictStrategy k;
    public final boolean l;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L30;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
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
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.d;
        int r8 = (((((((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        long r9 = this.h;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        ConflictStrategy r11 = this.i;
        if (r11 == null) goto L13;
        int r13 = r11.hashCode();
    L14:
        int r14 = (r10 + r13) * 31;
        ConflictStrategy r15 = this.j;
        if (r15 == null) goto L17;
        int r16 = r15.hashCode();
    L18:
        int r17 = (r14 + r16) * 31;
        ConflictStrategy r18 = this.k;
        if (r18 == null) goto L21;
        r1 = r18.hashCode();
    L21:
        int r19 = (r17 + r1) * 31;
        boolean r20 = this.l;
        ?? r21 = r20;
        if (r20 == false) goto L25;
        r21 = 1;
    L25:
        return r19 + r21;
    L17:
        r16 = 0;
        goto L18
    L13:
        r13 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "InsertPSTopViewEvent(id=" + this.a + ", priority=" + this.b + ", content=" + this.c + ", startTimestamp=" + this.d + ", allowExceedTime=" + this.e + ", delayTime=" + this.f + ", duration=" + this.g + ", endTimestamp=" + this.h + ", priorityLowerStrategy=" + this.i + ", priorityEqualStrategy=" + this.j + ", priorityHigherStrategy=" + this.k + ", isAssemble=" + this.l + ")";
    }

    public c() {
        ConflictStrategy r0 = ConflictStrategy.QUEUE;
        ConflictStrategy r1 = ConflictStrategy.INTERRUPT;
        Intrinsics.checkNotNullParameter(r0, "priorityLowerStrategy");
        Intrinsics.checkNotNullParameter(r0, "priorityEqualStrategy");
        Intrinsics.checkNotNullParameter(r1, "priorityHigherStrategy");
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 30;
        this.h = 0;
        this.i = r0;
        this.j = r0;
        this.k = r1;
        this.l = false;
    }
}
