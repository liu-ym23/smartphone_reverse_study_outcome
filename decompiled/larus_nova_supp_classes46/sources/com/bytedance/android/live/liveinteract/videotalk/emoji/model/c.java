package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.livesdk.gift.model.h2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final String a;
    public final String b;
    public List<String> c;
    public final int d;
    public final boolean e;
    public final long f;
    public final int g;
    public final String h;
    public final long i;
    public final String j;
    public final h2 k;
    public final String l;
    public final s m;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L32;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.d) * 31;
        boolean r10 = this.e;
        ?? r11 = r10;
        if (r10 == false) goto L17;
        r11 = 1;
    L17:
        int r12 = (r9 + r11) * 31;
        long r13 = this.f;
        int r14 = (((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + this.g) * 31;
        String r15 = this.h;
        if (r15 == null) goto L20;
        int r16 = r15.hashCode();
    L21:
        int r17 = (r14 + r16) * 31;
        long r18 = this.i;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        String r20 = this.j;
        if (r20 == null) goto L24;
        int r21 = r20.hashCode();
    L25:
        int r22 = (r19 + r21) * 31;
        h2 r23 = this.k;
        if (r23 == null) goto L28;
        int r24 = r23.hashCode();
    L29:
        int r25 = (r22 + r24) * 31;
        String r26 = this.l;
        if (r26 == null) goto L32;
        int r27 = r26.hashCode();
    L33:
        int r28 = (r25 + r27) * 31;
        s r29 = this.m;
        if (r29 == null) goto L37;
        r1 = r29.hashCode();
    L37:
        return r28 + r1;
    L32:
        r27 = 0;
        goto L33
    L28:
        r24 = 0;
        goto L29
    L24:
        r21 = 0;
        goto L25
    L20:
        r16 = 0;
        goto L21
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "id:" + this.a + ",type:" + this.d + ",isFirst:" + this.e + ",micAnimIndex:" + this.g + ",scriptRelPath:" + this.h + ",duration:" + this.i;
    }

    public c(String r5, String r6, List<String> r7, int r8, boolean r9, long r10, int r12, String r13, long r14, String r16, h2 r17, String r18, s r19) {
        Intrinsics.checkNotNullParameter(r5, "animationId");
        Intrinsics.checkNotNullParameter(r7, "receiverUids");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
    }
}
