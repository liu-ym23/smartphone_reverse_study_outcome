package n4a;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.dv;
import com.loc.dw;
import com.loc.dx;
import com.loc.dy;
import com.loc.dz;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o1 extends n1 {
    public o1() {
        super(2048);
    }

    public final int b(r1.a r20) {
        List<dv> r2 = r20.f;
        if (r2 == null) goto L30;
        ArrayList r3 = (ArrayList) r2;
        if (r3.size() == 0) goto L30;
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L30;
        dv r5 = (dv) r4.next();
        if ((r5 instanceof dx) == true) goto L12;
        if ((r5 instanceof dy) == true) goto L15;
        if ((r5 instanceof dz) == true) goto L18;
        if ((r5 instanceof dw) == false) goto L9;
        dw r6 = (dw) r5;
        int r7 = r6.k;
        int r8 = r6.l;
    L22:
        long r9 = (4294967295L & ((long) r8)) | ((((long) r7) & 4294967295L) << 32);
        monitor-enter(p2.class);
        short r10 = o2.b(o2.a().a, r9);     // Catch: Throwable -> L27
        monitor-exit(p2.class);
        r5.g = r10;
    L27:
        th = move-exception;
        throw th;
    L18:
        dz r11 = (dz) r5;
        r7 = r11.j;
        r8 = r11.k;
        goto L22
    L15:
        dy r12 = (dy) r5;
        r7 = r12.j;
        r8 = r12.k;
        goto L22
    L12:
        dx r13 = (dx) r5;
        r7 = r13.j;
        r8 = r13.k;
    L30:
        int r14 = ((ArrayList) r20.f).size();
        int[] r15 = new int[r14];
        int r16 = 0;
    L32:
        if (r16 >= r14) goto L59;
        dv r17 = (dv) ListProtector.get(r20.f, r16);
        if ((r17 instanceof dx) == false) goto L40;
        dx r18 = (dx) r17;
        if (r18.i == true) goto L38;
        p1 r19 = this.a;
        int r21 = r18.j;
        int r110 = r18.k;
        int r22 = r18.c;
        int r111 = r18.l;
        int r112 = g2.a;
        r19.l(9);
        r19.f(4, r22);
        r19.f(3, r110);
        r19.f(2, r21);
        r19.f(8, r111);
        int r23 = r19.k();
    L39:
        byte r24 = 1;
    L55:
        if (r23 == (-1)) goto L57;
        byte r25 = r17.h ? 1 : 0;
        byte r26 = r17.i ? 1 : 0;
        p1 r27 = this.a;
        short r28 = (short) r17.g;
        int r113 = d2.a;
        r27.l(5);
        r27.m(4, r23);
        r27.i(2, r28);
        r27.e(3, r24);
        r27.e(1, r26);
        r27.e(0, r25);
        r15[r16] = r27.k();
        r16 = r16 + 1;
        r14 = r14;
        goto L32
    L57:
        return -1;
    L38:
        p1 r29 = this.a;
        int r30 = r18.b();
        int r114 = r18.c();
        int r31 = r18.j;
        int r32 = r18.k;
        int r115 = r18.c;
        int r33 = r18.m;
        int r116 = r18.n;
        int r117 = r18.d;
        int r118 = r18.l;
        int r119 = g2.a;
        r29.l(9);
        r29.f(8, r118);
        r29.f(7, r117);
        r29.f(6, r116);
        r29.f(5, r33);
        r29.f(4, r115);
        r29.f(3, r32);
        r29.f(2, r31);
        r29.f(1, r114);
        r29.f(0, r30);
        r23 = r29.k();
        goto L39
    L40:
        r14 = r14;
        if ((r17 instanceof dy) == false) goto L44;
        dy r34 = (dy) r17;
        p1 r35 = this.a;
        int r36 = r34.b();
        int r37 = r34.c();
        int r38 = r34.j;
        int r39 = r34.k;
        int r120 = r34.l;
        int r121 = r34.c;
        int r122 = r34.m;
        int r40 = r34.d;
        int r123 = h2.a;
        r35.l(8);
        r35.f(7, r40);
        r35.f(6, r122);
        r35.f(5, r121);
        r35.f(4, r120);
        r35.f(3, r39);
        r35.f(2, r38);
        r35.f(1, r37);
        r35.f(0, r36);
        r23 = r35.k();
        r24 = 3;
        goto L55
    L44:
        if ((r17 instanceof dw) == false) goto L51;
        dw r41 = (dw) r17;
        if (r41.i == true) goto L48;
        p1 r42 = this.a;
        int r43 = r41.j;
        int r44 = r41.k;
        int r45 = r41.l;
        int r46 = r41.m;
        int r124 = r41.n;
        int r47 = r41.c;
        int r125 = a2.a;
        r42.l(7);
        r42.f(5, r47);
        r42.f(4, r124);
        r42.f(3, r46);
        r42.f(2, r45);
        r42.f(1, r44);
        r42.f(0, r43);
        r23 = r42.k();
    L49:
        r24 = 2;
        goto L55
    L48:
        p1 r48 = this.a;
        int r49 = r41.j;
        int r50 = r41.k;
        int r51 = r41.l;
        int r52 = r41.m;
        int r126 = r41.n;
        int r127 = r41.c;
        int r53 = r41.d;
        int r128 = a2.a;
        r48.l(7);
        r48.f(6, r53);
        r48.f(5, r127);
        r48.f(4, r126);
        r48.f(3, r52);
        r48.f(2, r51);
        r48.f(1, r50);
        r48.f(0, r49);
        r23 = r48.k();
        goto L49
    L51:
        if ((r17 instanceof dz) == false) goto L53;
        dz r54 = (dz) r17;
        p1 r55 = this.a;
        int r56 = r54.b();
        int r57 = r54.c();
        int r58 = r54.j;
        int r59 = r54.k;
        int r129 = r54.l;
        int r130 = r54.c;
        int r131 = r54.m;
        int r60 = r54.d;
        int r132 = k2.a;
        r55.l(8);
        r55.f(7, r60);
        r55.f(6, r131);
        r55.f(5, r130);
        r55.f(4, r129);
        r55.f(3, r59);
        r55.f(2, r58);
        r55.f(1, r57);
        r55.f(0, r56);
        r23 = r55.k();
        r24 = 4;
        goto L55
    L53:
        r23 = -1;
        r24 = 0;
        goto L55
    L59:
        int r133 = r14;
        int r61 = this.a.b(r20.b);
        p1 r62 = this.a;
        int r63 = b2.a;
        r62.g(4, r133, 4);
        int r64 = r133 - 1;
    L60:
        if (r64 < 0) goto L62;
        r62.d(r15[r64]);
        r64 = r64 - 1;
        goto L60
    L62:
        int r65 = r62.a();
        int r66 = ((ArrayList) r20.g).size();
        int[] r67 = new int[r66];
        int r68 = 0;
    L63:
        if (r68 >= r66) goto L84;
        dv r69 = (dv) ListProtector.get(r20.g, r68);
        long r70 = (SystemClock.elapsedRealtime() - r69.e) / 1000;
        if (r70 <= 32767) goto L67;
    L68:
        r70 = 32767;
    L70:
        if ((r69 instanceof dx) == false) goto L73;
        dx r71 = (dx) r69;
        p1 r134 = this.a;
        int r135 = r71.j;
        int r72 = r71.k;
    L75:
        int r73 = j2.a(r134, r135, r72, (short) r70);
        int r74 = 1;
    L83:
        p1 r75 = this.a;
        int r136 = c2.a;
        r75.l(2);
        r75.m(1, r73);
        r75.e(0, (byte) r74);
        r67[r68] = r75.k();
        r68 = r68 + 1;
        goto L63
    L73:
        if ((r69 instanceof dy) == false) goto L77;
        dy r76 = (dy) r69;
        r134 = this.a;
        r135 = r76.j;
        r72 = r76.k;
        goto L75
    L77:
        if ((r69 instanceof dw) == false) goto L80;
        dw r77 = (dw) r69;
        p1 r137 = this.a;
        int r138 = r77.j;
        int r139 = r77.k;
        int r78 = r77.l;
        int r79 = i2.a;
        r137.l(5);
        r137.f(3, r78);
        r137.f(2, r139);
        r137.f(1, r138);
        r137.i(4, (short) r70);
        r137.e(0, (byte) 2);
        r73 = r137.k();
        r74 = 2;
        goto L83
    L80:
        if ((r69 instanceof dz) == false) goto L82;
        dz r80 = (dz) r69;
        r73 = j2.a(this.a, r80.j, r80.k, (short) r70);
        r74 = 1;
        goto L83
    L82:
        r74 = 0;
        r73 = 0;
        goto L83
    L67:
        if (r70 >= 0) goto L70;
    L84:
        p1 r81 = this.a;
        r81.g(4, r66, 4);
        int r82 = r66 - 1;
    L85:
        if (r82 < 0) goto L87;
        r81.d(r67[r82]);
        r82 = r82 - 1;
        goto L85
    L87:
        int r83 = r81.a();
        p1 r84 = this.a;
        byte r0 = r20.a;
        r84.l(4);
        r84.m(3, r83);
        r84.m(2, r65);
        r84.m(0, r61);
        r84.e(1, r0);
        return r84.k();
    }

    public final int c(u2 r13) {
        long r0 = r13.h;
        long r2 = r13.a;
        int r4 = (int) (r13.c * 1000000.0d);
        int r5 = (int) (r13.b * 1000000.0d);
        int r6 = (int) r13.d;
        int r7 = (int) r13.g;
        int r8 = (int) r13.e;
        short r9 = (short) r13.f;
        byte r14 = r13.i;
        p1 r10 = this.a;
        int r11 = f2.a;
        r10.l(10);
        r10.h(1, r0);
        r10.h(0, r2);
        r10.f(6, r8);
        r10.f(5, r7);
        r10.f(4, r6);
        r10.f(3, r5);
        r10.f(2, r4);
        r10.i(7, r9);
        r10.e(8, r14);
        return r10.k();
    }

    public final int a(long r18, List<v2> r20) {
        Iterator<v2> r0 = r20.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        v2 r2 = r0.next();
        long r3 = r2.a;
        monitor-enter(p2.class);
        short r4 = o2.b(o2.a().c, r3);     // Catch: Throwable -> L10
        monitor-exit(p2.class);
        r2.g = r4;
    L10:
        th = move-exception;
        throw th;
    L13:
        int r1 = r20.size();
        if (r1 <= 0) goto L33;
        int[] r5 = new int[r1];
        int r6 = 0;
    L17:
        if (r6 >= r1) goto L28;
        v2 r9 = (v2) ListProtector.get(r20, r6);
        int r10 = this.a.b(r9.b);
        long r11 = r9.a;
        if (r11 == r18) goto L21;
    L23:
        int r13 = 0;
    L24:
        p1 r14 = this.a;
        short r15 = (short) r9.c;
        short r7 = r9.g;
        short r12 = (short) r9.d;
        int r16 = m2.a;
        r14.l(6);
        r14.h(1, r11);
        r14.m(3, r10);
        r14.i(5, r12);
        r14.i(4, r7);
        r14.i(2, r15);
        if (r13 == 0) goto L27;
        r14.p(1, 0);
        ByteBuffer r8 = r14.a;
        int r17 = r14.b - 1;
        r14.b = r17;
        r8.put(r17, (byte) r13);
        r14.s(0);
    L27:
        r5[r6] = r14.k();
        r6 = r6 + 1;
        goto L17
    L21:
        if (r11 == (-1)) goto L23;
        r13 = 1;
        goto L24
    L28:
        p1 r19 = this.a;
        int r21 = l2.a;
        r19.g(4, r1, 4);
        int r22 = r1 - 1;
    L29:
        if (r22 < 0) goto L31;
        r19.d(r5[r22]);
        r22 = r22 - 1;
        goto L29
    L31:
        int r23 = r19.a();
        p1 r24 = this.a;
        r24.l(1);
        r24.m(0, r23);
        return r24.k();
    L33:
        return -1;
    }
}
