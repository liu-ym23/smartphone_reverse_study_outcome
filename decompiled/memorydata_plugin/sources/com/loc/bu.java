package com.loc;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class bu extends bt {
    public bu() {
        super(2048);
    }

    private int a(long r19, List<db> r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        b(r1);
        int r3 = r1.size();
        if (r3 <= 0) goto L14;
        int[] r4 = new int[r3];
        int r6 = 0;
    L5:
        if (r6 >= r3) goto L19;
        db r7 = (db) ZeusTransformUtils.preCheckCast(r1.get(r6), db.class, "com.obric.memorydata.plugin");
        int r15 = this.f5380a.a(r7.f5429b);
        if (r7.f5428a == r19) goto L9;
    L11:
        boolean r11 = false;
    L12:
        r4[r6] = cr.a(this.f5380a, r11, r7.f5428a, (short) r7.c, r15, r7.g, (short) r7.d);
        r6 = r6 + 1;
        goto L5
    L9:
        if (r7.f5428a == (-1)) goto L11;
        r11 = true;
        goto L12
    L19:
        return cq.a(this.f5380a, cq.a(this.f5380a, r4));
    L14:
        return -1;
    }

    private int a(bx.a r23) {
        a(r23.f);
        int r2 = r23.f.size();
        int[] r3 = new int[r2];
        int r5 = 0;
    L3:
        byte r6 = 2;
        if (r5 >= r2) goto L29;
        dv r9 = (dv) ZeusTransformUtils.preCheckCast(r23.f.get(r5), dv.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, dx.class) == false) goto L13;
        dx r7 = (dx) ZeusTransformUtils.preCheckCast(r9, dx.class, "com.obric.memorydata.plugin");
        if (r7.i == true) goto L10;
        int r8 = cl.a(this.f5380a, r7.j, r7.k, r7.c, r7.l);
    L11:
        int r15 = r8;
        int r4 = -1;
        byte r14 = 1;
    L26:
        if (r15 == r4) goto L28;
        r3[r5] = ci.a(this.f5380a, r9.h ? 1 : 0, r9.i ? 1 : 0, (short) r9.g, r14, r15);
        r5 = r5 + 1;
        goto L3
    L28:
        return r4;
    L10:
        r8 = cl.a(this.f5380a, r7.b(), r7.c(), r7.j, r7.k, r7.c, r7.m, r7.n, r7.d, r7.l);
        goto L11
    L13:
        if (ZeusTransformUtils.instanceOf(r9, dy.class) == false) goto L17;
        r6 = 3;
        dy r10 = (dy) ZeusTransformUtils.preCheckCast(r9, dy.class, "com.obric.memorydata.plugin");
        int r11 = cm.a(this.f5380a, r10.b(), r10.c(), r10.j, r10.k, r10.l, r10.c, r10.m, r10.d);
    L15:
        r15 = r11;
        r14 = r6;
        r4 = -1;
        goto L26
    L17:
        if (ZeusTransformUtils.instanceOf(r9, dw.class) == false) goto L23;
        dw r12 = (dw) ZeusTransformUtils.preCheckCast(r9, dw.class, "com.obric.memorydata.plugin");
        boolean r13 = r12.i;
        bv r16 = this.f5380a;
        int r17 = r12.j;
        int r18 = r12.k;
        int r19 = r12.l;
        int r110 = r12.m;
        int r111 = r12.n;
        if (r13 == true) goto L21;
        r11 = cf.a(r16, r17, r18, r19, r110, r111, r12.c);
        goto L15
    L21:
        r11 = cf.a(r16, r17, r18, r19, r110, r111, r12.c, r12.d);
        goto L15
    L23:
        if (ZeusTransformUtils.instanceOf(r9, dz.class) == false) goto L25;
        r6 = 4;
        dz r20 = (dz) ZeusTransformUtils.preCheckCast(r9, dz.class, "com.obric.memorydata.plugin");
        r11 = cp.a(this.f5380a, r20.b(), r20.c(), r20.j, r20.k, r20.l, r20.c, r20.m, r20.d);
        goto L15
    L25:
        r4 = -1;
        r14 = 0;
        r15 = -1;
        goto L26
    L29:
        int r21 = this.f5380a.a(r23.f5386b);
        int r22 = cg.a(this.f5380a, r3);
        int r24 = r23.g.size();
        int[] r25 = new int[r24];
        int r26 = 0;
    L30:
        if (r26 >= r24) goto L52;
        dv r27 = (dv) ZeusTransformUtils.preCheckCast(r23.g.get(r26), dv.class, "com.obric.memorydata.plugin");
        long r112 = (SystemClock.elapsedRealtime() - r27.e) / 1000;
        if (r112 <= 32767) goto L34;
    L35:
        r112 = 32767;
    L37:
        if (ZeusTransformUtils.instanceOf(r27, dx.class) == false) goto L41;
        dx r28 = (dx) ZeusTransformUtils.preCheckCast(r27, dx.class, "com.obric.memorydata.plugin");
        bv r113 = this.f5380a;
        int r114 = r28.j;
        int r29 = r28.k;
    L39:
        int r30 = co.a(r113, r114, r29, (short) r112);
        int r115 = 1;
    L50:
        r25[r26] = ch.a(this.f5380a, (byte) r115, r30);
        r26 = r26 + 1;
        goto L30
    L41:
        if (ZeusTransformUtils.instanceOf(r27, dy.class) == false) goto L44;
        dy r31 = (dy) ZeusTransformUtils.preCheckCast(r27, dy.class, "com.obric.memorydata.plugin");
        r113 = this.f5380a;
        r114 = r31.j;
        r29 = r31.k;
        goto L39
    L44:
        if (ZeusTransformUtils.instanceOf(r27, dw.class) == false) goto L47;
        dw r32 = (dw) ZeusTransformUtils.preCheckCast(r27, dw.class, "com.obric.memorydata.plugin");
        r30 = cn.a(this.f5380a, r32.j, r32.k, r32.l, (short) r112);
        r115 = 2;
        goto L50
    L47:
        if (ZeusTransformUtils.instanceOf(r27, dz.class) == false) goto L49;
        dz r33 = (dz) ZeusTransformUtils.preCheckCast(r27, dz.class, "com.obric.memorydata.plugin");
        r113 = this.f5380a;
        r114 = r33.j;
        r29 = r33.k;
        goto L39
    L49:
        r30 = 0;
        r115 = 0;
        goto L50
    L34:
        if (r112 >= 0) goto L37;
    L52:
        return cg.a(this.f5380a, r21, r23.f5385a, r22, cg.b(this.f5380a, r25));
    }

    private int a(da r13) {
        long r3 = r13.k;
        return ck.a(this.f5380a, r13.c, r3, (int) (r13.e * 1000000.0d), (int) (r13.d * 1000000.0d), (int) r13.f, (int) r13.i, (int) r13.g, (short) r13.h, r13.l);
    }

    private static void a(List<dv> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.size() == 0) goto L32;
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L33;
        dv r0 = (dv) ZeusTransformUtils.preCheckCast(r6.next(), dv.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, dx.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r0, dy.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r0, dz.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r0, dw.class) == false) goto L9;
        dw r2 = (dw) ZeusTransformUtils.preCheckCast(r0, dw.class, "com.obric.memorydata.plugin");
        int r3 = r2.k;
        int r7 = r2.l;
    L13:
        r0.g = cu.a(cu.a(r3, r7));
        goto L9
    L19:
        dz r8 = (dz) ZeusTransformUtils.preCheckCast(r0, dz.class, "com.obric.memorydata.plugin");
        r3 = r8.j;
        r7 = r8.k;
        goto L13
    L16:
        dy r9 = (dy) ZeusTransformUtils.preCheckCast(r0, dy.class, "com.obric.memorydata.plugin");
        r3 = r9.j;
        r7 = r9.k;
        goto L13
    L12:
        dx r10 = (dx) ZeusTransformUtils.preCheckCast(r0, dx.class, "com.obric.memorydata.plugin");
        r3 = r10.j;
        r7 = r10.k;
        goto L13
    L33:
        return;
    }

    private static void b(List<db> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        db r0 = (db) ZeusTransformUtils.preCheckCast(r5.next(), db.class, "com.obric.memorydata.plugin");
        r0.g = cu.b(r0.f5428a);
        goto L4
    }

    public final byte[] a(da r3, bx.a r4, long r5, List<db> r7) {
        List<db> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        super.a();
        int r6 = a(r3);     // Catch: Throwable -> L22
        int r0 = -1;
        if (r4 != null) goto L6;
    L10:
        int r9 = -1;
    L11:
        if (r8 != null) goto L13;
    L15:
        cd.a(this.f5380a);     // Catch: Throwable -> L22
        cd.a(this.f5380a, r6);     // Catch: Throwable -> L22
        if (r9 <= 0) goto L18;
        cd.c(this.f5380a, r9);     // Catch: Throwable -> L22
    L18:
        if (r0 <= 0) goto L20;
        cd.b(this.f5380a, r0);     // Catch: Throwable -> L22
    L20:
        this.f5380a.c(cd.b(this.f5380a));     // Catch: Throwable -> L22
        return this.f5380a.c();
    L13:
        if (r8.size() <= 0) goto L15;
        r0 = a(r5, r8);     // Catch: Throwable -> L22
        goto L15
    L6:
        if (r4.f == null) goto L10;
        if (r4.f.size() <= 0) goto L10;
        r9 = a(r4);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        de.a(th);
        return null;
    }
}
