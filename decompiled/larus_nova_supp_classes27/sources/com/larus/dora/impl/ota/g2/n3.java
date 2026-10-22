package com.larus.dora.impl.ota.g2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n3 implements Function1 {
    public final /* synthetic */ CheckPurpose a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ e5 f;
    public final /* synthetic */ ManualOnlyReason g;
    public final /* synthetic */ d5 h;
    public final /* synthetic */ long i;
    public final /* synthetic */ q5 j;
    public final /* synthetic */ a5 k;

    public /* synthetic */ n3(CheckPurpose r1, boolean r2, boolean r3, boolean r4, boolean r5, e5 r6, ManualOnlyReason r7, d5 r8, long r9, q5 r11, a5 r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r11;
        this.k = r12;
    }

    public final Object invoke(Object r34) {
        CheckPurpose r1 = this.a;
        boolean r2 = this.b;
        boolean r3 = this.c;
        boolean r4 = this.d;
        boolean r5 = this.e;
        e5 r15 = this.f;
        ManualOnlyReason r13 = this.g;
        d5 r14 = this.h;
        long r9 = this.i;
        q5 r11 = this.j;
        a5 r12 = this.k;
        f r8 = (f) r34;
        Intrinsics.checkNotNullParameter(r8, "it");
        w4 r23 = new w4(0, null, false, null, 31);
        if (r1 != CheckPurpose.INSTALL) goto L6;
        if (r2 == false) goto L6;
        v4 r6 = new v4(null, null, 0, r8.f().e(), null, r8.f().c(), 16375);
    L7:
        List r7 = r8.k();
        ArrayList r10 = new ArrayList();
        Iterator r16 = r7.iterator();
    L9:
        if (r16.hasNext() == false) goto L14;
        Object r17 = r16.next();
        Iterator r35 = r16;
        if (Intrinsics.areEqual(((c5) r17).d().h(), r15.h()) == true) goto L13;
        r10.add(r17);
    L13:
        r16 = r35;
        goto L9
    L14:
        if (r3 == false) goto L16;
        f5 r18 = r8.l();
        r10 = r10;
        f r20 = r8;
        r11 = r11;
        r12 = r12;
        e5 r27 = r15;
    L22:
        j5 r21 = r20.m();
        e5 r0 = r20.l().h();
        d5 r22 = null;
        if (r0 == null) goto L25;
        d5 r24 = r0.h();
    L26:
        int r110 = 0;
        if (Intrinsics.areEqual(r24, r27.h()) == true) goto L29;
        int r25 = 0;
    L30:
        e5 r111 = r20.l().h();
        if (r111 == null) goto L34;
        r22 = r111.h();
    L34:
        if (Intrinsics.areEqual(r22, r27.h()) == false) goto L38;
        r110 = r20.m().e();
    L38:
        return f.a(r20, null, null, null, null, null, r23, r27, r18, r10, null, r6, null, null, j5.a(r21, 0, "", 0, r25, r110, 0, 36), r11, null, r12, 74815);
    L29:
        r25 = r20.m().b();
        goto L30
    L25:
        r24 = null;
        goto L26
    L16:
        if (r4 == true) goto L20;
        if (r5 == true) goto L20;
        r20 = r8;
        r27 = r15;
        f5 r26 = new f5(PackagePhase.PARTIAL, r15, r9, 0, r9 + j0.G2_OTA_PARTIAL_TTL_MS, 0, null, r13, r14, 104);
    L21:
        r18 = r26;
    L20:
        r20 = r8;
        r27 = r15;
        r26 = f5.a(r20.l(), null, r27, 0, 0, 0, null, r13, r14, 125);
    L6:
        r6 = r8.f();
        goto L7
    }
}
