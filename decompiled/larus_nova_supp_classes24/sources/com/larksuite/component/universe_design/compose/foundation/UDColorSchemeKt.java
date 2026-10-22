package com.larksuite.component.universe_design.compose.foundation;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDColorSchemeKt {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(UDColorSchemeKt$lightUDColorScheme$2.INSTANCE);
        b = LazyKt.lazy(UDColorSchemeKt$darkUDColorScheme$2.INSTANCE);
    }

    public static final f0 a(e0 r10) {
        long r2 = r10.a.a;
        s r1 = new s();
        k r3 = new k();
        long r4 = r10.e.a;
        z r5 = new z();
        long r6 = r10.b.a;
        o0 r7 = new o0();
        long r8 = r10.c.a;
        f r9 = new f();
        o r11 = r10.d;
        long r12 = r11.a;
        return new f0(r1, r3, r5, r7, r9, new p(r11.i));
    }

    public static final h0 b(e0 r29, d0 r30, boolean r31) {
        long r12 = ColorKt.Color(4294967295L);
        c r4 = r29.a;
        long r5 = r4.a;
        long r6 = r4.b;
        long r7 = r4.c;
        long r14 = r4.d;
        if (r31 == true) goto L6;
        r7 = r14;
    L6:
        if (r31 == false) goto L8;
        long r16 = r6;
    L9:
        if (r31 == false) goto L11;
        long r8 = r30.c.b;
    L12:
        if (r31 == false) goto L14;
        long r9 = r30.c.c;
    L15:
        if (r31 == false) goto L17;
        long r10 = r30.c.d;
    L18:
        r r11 = new r(r12, r7, r16);
        ColorKt.Color(4294967295L);
        g r13 = r29.e;
        long r15 = r13.a;
        long r17 = r13.b;
        long r19 = r30.c.f;
        y r20 = new y(r17, r15);
        ColorKt.Color(4294967295L);
        v r21 = r29.c;
        long r22 = r21.a;
        long r110 = r21.b;
        long r111 = r30.c.e;
        e r23 = new e(r110, r22);
        ColorKt.Color(4294967295L);
        q r24 = r29.b;
        long r112 = r24.a;
        long r25 = r24.b;
        long r113 = r30.c.g;
        n0 r26 = new n0(r25, r112);
        ColorKt.Color(4294967295L);
        c r27 = r29.a;
        long r114 = r27.a;
        long r115 = r27.d;
        long r2 = r30.c.h;
        j r32 = new j(r115, r114);
        o r3 = r29.d;
        b0 r33 = new b0(r3.k, r3.i, r3.h, r3.g);
        if (r31 == false) goto L21;
        long r34 = r30.a.d;
    L22:
        long r116 = r34;
        if (r31 == false) goto L25;
        long r35 = r30.a.c;
    L26:
        long r210 = r35;
        if (r31 == false) goto L29;
        long r36 = r30.a.c;
    L30:
        long r211 = r36;
        if (r31 == false) goto L33;
        ColorKt.Color(4278190080L);
    L34:
        m r37 = new m(r116, r210, r211);
        ColorKt.Color(2365587456L);
        ColorKt.Color(2566914048L);
        if (r31 == false) goto L37;
        long r117 = r29.d.a;
    L38:
        if (r31 == false) goto L40;
        long r118 = r29.d.b;
    L41:
        long r119 = r118;
        if (r31 == false) goto L44;
        long r120 = r29.d.c;
    L45:
        o r38 = r29.d;
        long r121 = r38.d;
        if (r31 == false) goto L48;
        long r122 = r38.c;
    L49:
        long r212 = r122;
        long r123 = r29.a.b;
        if (r31 == false) goto L52;
        ColorKt.Color(4280690214L);
    L52:
        if (r31 == false) goto L54;
        long r124 = 4279374354L;
    L55:
        ColorKt.Color(r124);
        if (r31 == false) goto L58;
        long r125 = r30.a.e;
    L59:
        long r126 = r30.b.a;
        if (r31 == false) goto L62;
        long r0 = r30.a.f;
    L63:
        a r39 = new a(r119, r212, r0);
        ColorKt.Color(4294967295L);
        ColorKt.Color(452984831);
        ColorKt.Color(872415231);
        ColorKt.Color(4278190080L);
        ColorKt.Color(2365587456L);
        return new h0(r11, r20, r23, r26, r32, r33, r37, r39, new x());
    L62:
        r0 = r29.d.a;
        goto L63
    L58:
        long r127 = r30.a.g;
        goto L59
    L54:
        r124 = 4294507002L;
        goto L55
    L48:
        r122 = r38.a;
        goto L49
    L44:
        long r128 = r29.d.b;
        goto L45
    L40:
        r118 = r29.d.a;
        goto L41
    L37:
        long r129 = r29.d.c;
        goto L38
    L33:
        long r130 = r30.a.c;
        goto L34
    L29:
        r36 = r3.f;
        goto L30
    L25:
        r35 = r3.e;
        goto L26
    L21:
        r34 = r30.a.c;
        goto L22
    L17:
        long r40 = r30.c.c;
        goto L18
    L14:
        long r41 = r30.c.b;
        goto L15
    L11:
        long r42 = r30.c.a;
        goto L12
    L8:
        r16 = r14;
        goto L9
    }
}
