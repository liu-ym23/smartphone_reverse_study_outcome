package qa;

import android.os.SystemClock;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o1 extends c1 {
    public o1() {
        super(2048);
    }

    public final int d(long r18, ArrayList r20) {
        Iterator r8 = r20.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        n2 r10 = (n2) r8.next();
        long r11 = r10.f10851a;
        monitor-enter(d2.class);
        short r12 = c2.b(c2.a().f10258c, r11);     // Catch: Throwable -> L10
        monitor-exit(d2.class);
        r10.f10857g = r12;
    L10:
        th = move-exception;
        throw th;
    L13:
        int r13 = r20.size();
        if (r13 <= 0) goto L33;
        int[] r14 = new int[r13];
        int r15 = 0;
    L17:
        if (r15 >= r13) goto L28;
        n2 r16 = (n2) r20.get(r15);
        int r17 = ((p1) this.f10252a).b(r16.f10852b);
        long r19 = r16.f10851a;
        if (r19 == r18) goto L21;
    L23:
        int r110 = 0;
    L24:
        p1 r111 = (p1) this.f10252a;
        short r112 = (short) r16.f10853c;
        short r21 = r16.f10857g;
        short r22 = (short) r16.f10854d;
        int r113 = a2.f10204a;
        r111.l(6);
        r111.h(1, r19);
        r111.m(3, r17);
        r111.i(5, r22);
        r111.i(4, r21);
        r111.i(2, r112);
        if (r110 == 0) goto L27;
        r111.p(1, 0);
        ByteBuffer r23 = r111.f10207a;
        int r24 = r111.f10208b - 1;
        r111.f10208b = r24;
        r23.put(r24, (byte) r110);
        r111.s(0);
    L27:
        r14[r15] = r111.k();
        r15 = r15 + 1;
        goto L17
    L21:
        if (r19 == (-1)) goto L23;
        r110 = 1;
        goto L24
    L28:
        p1 r25 = (p1) this.f10252a;
        int r26 = z1.f11249a;
        r25.g(4, r13, 4);
        int r27 = r13 - 1;
    L29:
        if (r27 < 0) goto L31;
        r25.e(r14[r27]);
        r27 = r27 - 1;
        goto L29
    L31:
        int r28 = r25.a();
        p1 r29 = (p1) this.f10252a;
        r29.l(1);
        r29.m(0, r28);
        return r29.k();
    L33:
        return -1;
    }

    public final int e(r1.a r21) {
        ArrayList r8 = r21.f10973f;
        if (r8 != null) goto L5;
    L30:
        ArrayList r10 = r21.f10973f;
        int r11 = r10.size();
        int[] r12 = new int[r11];
        int r13 = 0;
    L31:
        Object r14 = this.f10252a;
        if (r13 >= r11) goto L83;
        f2 r15 = (f2) r10.get(r13);
        if ((r15 instanceof h2) == false) goto L48;
        h2 r16 = (h2) r15;
        if (r16.f10410s == true) goto L38;
        p1 r17 = (p1) r14;
        int r18 = r16.f10498t;
        int r19 = r16.f10499u;
        int r110 = r16.f10404m;
        int r111 = r16.f10500v;
        int r112 = a2.f10204a;
        r17.l(9);
        r17.f(4, r110);
        r17.f(3, r19);
        r17.f(2, r18);
        r17.f(8, r111);
        int r20 = r17.k();
    L47:
        byte r22 = 1;
    L79:
        if (r20 == (-1)) goto L82;
        byte r23 = r15.f10409r ? 1 : 0;
        byte r24 = r15.f10410s ? 1 : 0;
        p1 r25 = (p1) r14;
        short r26 = (short) r15.f10408q;
        int r27 = a2.f10204a;
        r25.l(5);
        r25.m(4, r20);
        r25.i(2, r26);
        r25.d(r22, 3);
        r25.d(r24, 1);
        r25.d(r23, 0);
        r12[r13] = r25.k();
        r13 = r13 + 1;
        r10 = r10;
        r11 = r11;
        goto L31
    L82:
        return -1;
    L38:
        p1 r28 = (p1) r14;
        int r29 = Integer.parseInt(r16.f10402a);     // Catch: Exception -> L41
    L115:
        int r113 = Integer.parseInt(r16.f10403b);     // Catch: Exception -> L45
    L46:
        int r114 = r16.f10498t;
        int r115 = r16.f10499u;
        int r116 = r16.f10404m;
        int r30 = r16.f10501w;
        int r31 = r16.f10502x;
        int r32 = r16.f10405n;
        int r117 = r16.f10500v;
        int r118 = a2.f10204a;
        r28.l(9);
        r28.f(8, r117);
        r28.f(7, r32);
        r28.f(6, r31);
        r28.f(5, r30);
        r28.f(4, r116);
        r28.f(3, r115);
        r28.f(2, r114);
        r28.f(1, r113);
        r28.f(0, r29);
        r20 = r28.k();
    L45:
        r113 = 0;
    L41:
        r29 = 0;
        goto L115
    L48:
        r10 = r10;
        r11 = r11;
        if ((r15 instanceof i2) == false) goto L60;
        i2 r33 = (i2) r15;
        p1 r34 = (p1) r14;
        int r35 = Integer.parseInt(r33.f10402a);     // Catch: Exception -> L53
    L113:
        int r36 = Integer.parseInt(r33.f10403b);     // Catch: Exception -> L57
    L58:
        int r37 = r33.f10520t;
        int r38 = r33.f10521u;
        int r119 = r33.f10522v;
        int r120 = r33.f10404m;
        int r121 = r33.f10523w;
        int r39 = r33.f10405n;
        int r122 = y1.f11230a;
        r34.l(8);
        r34.f(7, r39);
        r34.f(6, r121);
        r34.f(5, r120);
        r34.f(4, r119);
        r34.f(3, r38);
        r34.f(2, r37);
        r34.f(1, r36);
        r34.f(0, r35);
        r20 = r34.k();
        r22 = 3;
    L57:
        r36 = 0;
    L53:
        r35 = 0;
        goto L113
    L60:
        if ((r15 instanceof g2) == false) goto L67;
        g2 r40 = (g2) r15;
        if (r40.f10410s == true) goto L64;
        p1 r41 = (p1) r14;
        int r42 = r40.f10446t;
        int r43 = r40.f10447u;
        int r44 = r40.f10448v;
        int r45 = r40.f10449w;
        int r123 = r40.f10450x;
        int r46 = r40.f10404m;
        int r124 = a2.f10204a;
        r41.l(7);
        r41.f(5, r46);
        r41.f(4, r123);
        r41.f(3, r45);
        r41.f(2, r44);
        r41.f(1, r43);
        r41.f(0, r42);
        r20 = r41.k();
    L65:
        r22 = 2;
        goto L79
    L64:
        p1 r47 = (p1) r14;
        int r48 = r40.f10446t;
        int r49 = r40.f10447u;
        int r50 = r40.f10448v;
        int r51 = r40.f10449w;
        int r125 = r40.f10450x;
        int r126 = r40.f10404m;
        int r52 = r40.f10405n;
        int r127 = a2.f10204a;
        r47.l(7);
        r47.f(6, r52);
        r47.f(5, r126);
        r47.f(4, r125);
        r47.f(3, r51);
        r47.f(2, r50);
        r47.f(1, r49);
        r47.f(0, r48);
        r20 = r47.k();
        goto L65
    L67:
        if ((r15 instanceof j2) == false) goto L77;
        j2 r53 = (j2) r15;
        p1 r54 = (p1) r14;
        int r55 = Integer.parseInt(r53.f10402a);     // Catch: Exception -> L71
    L117:
        int r56 = Integer.parseInt(r53.f10403b);     // Catch: Exception -> L75
    L76:
        int r57 = r53.f10624t;
        int r58 = r53.f10625u;
        int r128 = r53.f10626v;
        int r129 = r53.f10404m;
        int r130 = r53.f10627w;
        int r59 = r53.f10405n;
        int r131 = y1.f11230a;
        r54.l(8);
        r54.f(7, r59);
        r54.f(6, r130);
        r54.f(5, r129);
        r54.f(4, r128);
        r54.f(3, r58);
        r54.f(2, r57);
        r54.f(1, r56);
        r54.f(0, r55);
        r20 = r54.k();
        r22 = 4;
    L75:
        r56 = 0;
    L71:
        r55 = 0;
        goto L117
    L77:
        r20 = -1;
        r22 = 0;
        goto L79
    L83:
        int r132 = r11;
        p1 r60 = (p1) r14;
        int r61 = r60.b(r21.f10969b);
        int r62 = y1.f11230a;
        r60.g(4, r132, 4);
        int r63 = r132 - 1;
    L84:
        if (r63 < 0) goto L86;
        r60.e(r12[r63]);
        r63 = r63 - 1;
        goto L84
    L86:
        int r64 = r60.a();
        ArrayList r65 = r21.f10974g;
        int r66 = r65.size();
        int[] r67 = new int[r66];
        int r68 = 0;
    L87:
        if (r68 >= r66) goto L108;
        f2 r69 = (f2) r65.get(r68);
        long r70 = (SystemClock.elapsedRealtime() - r69.f10406o) / 1000;
        if (r70 <= 32767) goto L91;
    L92:
        r70 = 32767;
    L94:
        if ((r69 instanceof h2) == false) goto L97;
        h2 r71 = (h2) r69;
        int r133 = r71.f10498t;
        int r72 = r71.f10499u;
    L99:
        int r73 = a2.a(r60, r133, r72, (short) r70);
        int r74 = 1;
    L107:
        int r134 = z1.f11249a;
        r60.l(2);
        r60.m(1, r73);
        r60.d((byte) r74, 0);
        r67[r68] = r60.k();
        r68 = r68 + 1;
        goto L87
    L97:
        if ((r69 instanceof i2) == false) goto L101;
        i2 r75 = (i2) r69;
        r133 = r75.f10520t;
        r72 = r75.f10521u;
        goto L99
    L101:
        if ((r69 instanceof g2) == false) goto L104;
        g2 r76 = (g2) r69;
        int r135 = r76.f10446t;
        int r136 = r76.f10447u;
        int r77 = r76.f10448v;
        int r137 = z1.f11249a;
        r60.l(5);
        r60.f(3, r77);
        r60.f(2, r136);
        r60.f(1, r135);
        r60.i(4, (short) r70);
        r60.d((byte) 2, 0);
        r73 = r60.k();
        r74 = 2;
        goto L107
    L104:
        if ((r69 instanceof j2) == false) goto L106;
        j2 r78 = (j2) r69;
        r73 = a2.a(r60, r78.f10624t, r78.f10625u, (short) r70);
        r74 = 1;
        goto L107
    L106:
        r74 = 0;
        r73 = 0;
        goto L107
    L91:
        if (r70 >= 0) goto L94;
    L108:
        r60.g(4, r66, 4);
        int r79 = r66 - 1;
    L109:
        if (r79 < 0) goto L111;
        r60.e(r67[r79]);
        r79 = r79 - 1;
        goto L109
    L111:
        int r80 = r60.a();
        byte r81 = r21.f10968a;
        r60.l(4);
        r60.m(3, r80);
        r60.m(2, r64);
        r60.m(0, r61);
        r60.d(r81, 1);
        return r60.k();
    L5:
        if (r8.size() == 0) goto L30;
        Iterator r82 = r8.iterator();
    L9:
        if (r82.hasNext() == false) goto L30;
        f2 r83 = (f2) r82.next();
        if ((r83 instanceof h2) == true) goto L12;
        if ((r83 instanceof i2) == true) goto L15;
        if ((r83 instanceof j2) == true) goto L18;
        if ((r83 instanceof g2) == false) goto L9;
        g2 r84 = (g2) r83;
        int r85 = r84.f10447u;
        int r86 = r84.f10448v;
    L22:
        long r87 = (QesdkUtils.LIMITS.UINT_32_UPPER & ((long) r86)) | ((((long) r85) & QesdkUtils.LIMITS.UINT_32_UPPER) << 32);
        monitor-enter(d2.class);
        short r88 = c2.b(c2.a().f10256a, r87);     // Catch: Throwable -> L27
        monitor-exit(d2.class);
        r83.f10408q = r88;
    L27:
        th = move-exception;
        throw th;
    L18:
        j2 r89 = (j2) r83;
        r85 = r89.f10624t;
        r86 = r89.f10625u;
        goto L22
    L15:
        i2 r90 = (i2) r83;
        r85 = r90.f10520t;
        r86 = r90.f10521u;
        goto L22
    L12:
        h2 r91 = (h2) r83;
        r85 = r91.f10498t;
        r86 = r91.f10499u;
        goto L22
    }

    public final int f(m2 r12) {
        long r8 = r12.f10825h;
        long r10 = r12.f10785a;
        int r11 = (int) (r12.f10787c * 1000000.0d);
        int r13 = (int) (r12.f10786b * 1000000.0d);
        int r14 = (int) r12.f10788d;
        int r15 = (int) r12.f10791g;
        int r16 = (int) r12.f10789e;
        short r17 = (short) r12.f10790f;
        byte r18 = r12.f10826i;
        p1 r19 = (p1) this.f10252a;
        int r110 = z1.f11249a;
        r19.l(10);
        r19.h(1, r8);
        r19.h(0, r10);
        r19.f(6, r16);
        r19.f(5, r15);
        r19.f(4, r14);
        r19.f(3, r13);
        r19.f(2, r11);
        r19.i(7, r17);
        r19.d(r18, 8);
        return r19.k();
    }
}
