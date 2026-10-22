package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m2 implements Function1 {
    public final /* synthetic */ b5 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ m2(b5 r1, boolean r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r37) {
        b5 r1 = this.a;
        boolean r2 = this.b;
        boolean r3 = this.c;
        boolean r4 = this.d;
        f r5 = (f) r37;
        Intrinsics.checkNotNullParameter(r5, "it");
        d r7 = new d(true, false, 6);
        o5 r6 = o5.a(r5.o(), r1.f(), null, 0, null, 14);
        if (r2 == false) goto L6;
        q5 r8 = r5.q();
    L5:
        q5 r20 = r8;
        if (r3 == false) goto L15;
        e5 r12 = null;
    L16:
        if (r3 == false) goto L20;
        if (r4 == true) goto L20;
        if (r2 == true) goto L20;
        f5 r9 = new f5(null, null, 0, 0, 0, 0, null, null, null, 511);
    L21:
        f5 r13 = r9;
        if (r3 == false) goto L24;
        l r10 = new l(null, 0, null, null, false, false, null, null, 4095);
    L25:
        l r15 = r10;
        if (r3 == false) goto L29;
        if (r2 == true) goto L29;
        v4 r11 = new v4(null, null, 0, null, null, false, 32767);
    L30:
        v4 r16 = r11;
        if (r3 == false) goto L34;
        if (r2 == true) goto L34;
        j5 r14 = new j5(0);
    L36:
        return f.a(r5, r6, r7, null, null, null, null, r12, r13, null, r15, r16, null, null, r14, r20, null, null, 209529);
    L34:
        r14 = r5.m();
    L29:
        r11 = r5.f();
        goto L30
    L24:
        r10 = r5.c();
    L20:
        r9 = r5.l();
        goto L21
    L15:
        r12 = r5.h();
        goto L16
    L6:
        q5 r17 = r5.q();
        String r18 = r1.p().e();
        if (r1.p().i() == true) goto L10;
        r18 = null;
    L10:
        if (r18 != null) goto L12;
        r18 = "";
    L12:
        r8 = q5.a(r17, null, r18, null, 5);
        goto L5
    }
}
