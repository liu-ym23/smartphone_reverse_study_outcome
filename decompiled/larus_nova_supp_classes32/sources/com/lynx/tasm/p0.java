package com.lynx.tasm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p0 {
    public final long a;
    public final LynxMemoryCollectionStatus b;
    public final long c;
    public final long d;
    public final int e;
    public final int f;
    public final long g;
    public final long h;
    public final double i;
    public final long j;
    public final long k;
    public final long l;
    public final long m;
    public final long n;
    public final List<r0> o;

    public static p0 a(long r28, LynxMemoryCollectionStatus r30, long r31, long r33, int r35, long r36, List<r0> r38) {
        HashMap r0 = new HashMap();
        Iterator<r0> r1 = r38.iterator();
        long r4 = 0;
        long r16 = 0;
        long r18 = 0;
        long r20 = 0;
        long r22 = 0;
    L4:
        if (r1.hasNext() == false) goto L17;
        r0 r6 = r1.next();
        r16 = r16 + r6.e;
        r18 = r18 + r6.f;
        r20 = r20 + r6.g;
        r22 = r22 + r6.i;
        String r7 = r6.k;
        if (r7 == null) goto L16;
        if (r7.isEmpty() == true) goto L16;
        if ("-1".equals(r7) == true) goto L16;
        if (r0.containsKey(r7) == false) goto L14;
        long r8 = ((Long) r0.get(r7)).longValue();
    L15:
        r0.put(r7, Long.valueOf(Math.max(r8, r6.j)));
        goto L4
    L14:
        r8 = 0;
    L16:
        r4 = r4 + r6.j;
        goto L4
    L17:
        Iterator r2 = r0.values().iterator();
        long r24 = r4;
    L19:
        if (r2.hasNext() == false) goto L21;
        r24 = r24 + ((Long) r2.next()).longValue();
        goto L19
    L21:
        long r10 = ((r16 + r20) + r22) + r24;
        if (r36 <= 0) goto L24;
        double r3 = r10 / r36;
    L26:
        return new p0(r28, r30, r31, r33, r35, r38.size(), r10, r36, r3, r16, r18, r20, r22, r24, r38);
    L24:
        r3 = 0.0d;
        goto L26
    }

    public p0(long r4, LynxMemoryCollectionStatus r6, long r7, long r9, int r11, int r12, long r13, long r15, double r17, long r19, long r21, long r23, long r25, long r27, List<r0> r29) {
        this.a = r4;
        this.b = r6;
        this.c = r7;
        this.d = r9;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r15;
        this.i = r17;
        this.j = r19;
        this.k = r21;
        this.l = r23;
        this.m = r25;
        this.n = r27;
        ArrayList r1 = new ArrayList(r29);
        Collections.sort(r1, new o0());
        this.o = Collections.unmodifiableList(r1);
    }
}
