package com.ss.android.lark.compose.foundation;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UDColorSchemeKt {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(UDColorSchemeKt$lightUDColorScheme$2.INSTANCE);
        b = LazyKt.lazy(UDColorSchemeKt$darkUDColorScheme$2.INSTANCE);
    }

    public static final n0 a(m0 r10) {
        long r2 = r10.a.a;
        a0 r1 = new a0();
        s r3 = new s();
        long r4 = r10.e.a;
        h0 r5 = new h0();
        long r6 = r10.b.a;
        v0 r7 = new v0();
        long r8 = r10.c.a;
        l r9 = new l();
        long r11 = r10.d.a;
        return new n0(r1, r3, r5, r7, r9, new x());
    }

    public static final p0 b(m0 r16, l0 r17, boolean r18) {
        ColorKt.Color(4294967295L);
        long r4 = r16.a.a;
        if (r18 == false) goto L5;
        long r5 = r17.c.b;
    L6:
        if (r18 == false) goto L8;
        long r6 = r17.c.c;
    L9:
        if (r18 == false) goto L11;
        long r7 = r17.c.d;
    L12:
        z r8 = new z();
        ColorKt.Color(4294967295L);
        long r9 = r16.e.a;
        long r10 = r17.c.f;
        g0 r11 = new g0();
        ColorKt.Color(4294967295L);
        long r12 = r16.c.a;
        long r13 = r17.c.e;
        k r14 = new k();
        ColorKt.Color(4294967295L);
        long r15 = r16.b.a;
        long r19 = r17.c.g;
        u0 r20 = new u0();
        ColorKt.Color(4294967295L);
        long r110 = r16.a.a;
        long r111 = r17.c.h;
        r r21 = new r();
        long r112 = r16.d.c;
        j0 r22 = new j0();
        long r113 = r17.a.a;
        u r114 = new u();
        ColorKt.Color(2365587456L);
        long r115 = r16.d.b;
        long r116 = r16.a.b;
        ColorKt.Color(4294507002L);
        long r117 = r17.a.b;
        long r0 = r17.b.a;
        a r118 = new a();
        ColorKt.Color(4294967295L);
        ColorKt.Color(452984831);
        ColorKt.Color(872415231);
        ColorKt.Color(4278190080L);
        ColorKt.Color(2365587456L);
        return new p0(r8, r11, r14, r20, r21, r22, r114, r118, new f0());
    L11:
        long r23 = r17.c.c;
        goto L12
    L8:
        long r24 = r17.c.b;
        goto L9
    L5:
        long r25 = r17.c.a;
        goto L6
    }
}
