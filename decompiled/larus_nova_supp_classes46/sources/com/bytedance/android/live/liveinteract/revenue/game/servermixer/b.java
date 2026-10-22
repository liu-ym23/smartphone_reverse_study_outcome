package com.bytedance.android.live.liveinteract.revenue.game.servermixer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ti6.f;
import uf2.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static a a;

    static {
    }

    public static void a(List r12, f r13) {
        Intrinsics.checkNotNullParameter(r12, "list");
        Intrinsics.checkNotNullParameter(r13, "gameRegion");
        if (je0.d.r() == false) goto L61;
        a r0 = a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.b() != true) goto L63;
        List r1 = r12;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((f) r2.next()).o = 2;
        goto L10
    L12:
        Iterator r3 = r1.iterator();
    L13:
        String r4 = null;
        if (r3.hasNext() == false) goto L18;
        Object r5 = r3.next();
        if (Intrinsics.areEqual(((f) r5).b, tc0.c.h().f) == false) goto L13;
    L19:
        f r6 = (f) r5;
        if (r6 != null) goto L22;
    L48:
        a r7 = a;
        if (r7 == null) goto L51;
        String r8 = r7.a();
    L52:
        r13.b(r8);
        a r9 = a;
        if (r9 == null) goto L55;
        r4 = r9.d();
    L55:
        r13.a(r4);
        r13.o = 0;
        ListProtector.add(r12, 0, r13);
        return;
    L51:
        r8 = null;
        goto L52
    L22:
        if (r6.n == true) goto L48;
        a r10 = a;
        if (r10 == null) goto L28;
        m1.b r11 = r10.c();
        if (r11 == null) goto L28;
        Number r14 = Float.valueOf(r11.getLeft());
    L29:
        double r15 = r14.doubleValue();
        a r16 = a;
        if (r16 == null) goto L34;
        m1.b r17 = r16.c();
        if (r17 == null) goto L34;
        Number r18 = Float.valueOf(r17.getTop());
    L35:
        double r19 = r18.doubleValue();
        a r20 = a;
        if (r20 == null) goto L40;
        m1.b r21 = r20.c();
        if (r21 == null) goto L40;
        Number r22 = Float.valueOf(r21.getRight());
    L41:
        double r110 = r22.doubleValue();
        a r23 = a;
        if (r23 == null) goto L46;
        m1.b r24 = r23.c();
        if (r24 == null) goto L46;
        Number r25 = Float.valueOf(r24.getBottom());
    L47:
        double r26 = r25.doubleValue();
        r6.d = r15;
        r6.e = r19;
        r6.f = r110 - r15;
        r6.g = r26 - r19;
        r6.o = 1;
    L46:
        r25 = Double.valueOf(0.0d);
    L40:
        r22 = Double.valueOf(0.0d);
    L34:
        r18 = Double.valueOf(0.0d);
    L28:
        r14 = Double.valueOf(0.0d);
        goto L29
    L18:
        r5 = null;
        goto L19
    L63:
        return;
    }

    public static void b(List r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "gameRegion");
        if (je0.d.r() == false) goto L17;
        a r0 = a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.b() != true) goto L19;
        a r1 = a;
        String r4 = null;
        if (r1 == null) goto L11;
        String r5 = r1.a();
    L12:
        r3.b(r5);
        a r6 = a;
        if (r6 == null) goto L15;
        r4 = r6.d();
    L15:
        r3.a(r4);
        ListProtector.add(r2, 0, r3);
        return;
    L11:
        r5 = null;
        goto L12
    L19:
        return;
    }

    public static void c(List r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "gameRegion");
        if (je0.d.r() == false) goto L17;
        a r0 = a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.b() != true) goto L19;
        a r1 = a;
        String r4 = null;
        if (r1 == null) goto L11;
        String r5 = r1.a();
    L12:
        r3.b(r5);
        a r6 = a;
        if (r6 == null) goto L15;
        r4 = r6.d();
    L15:
        r3.a(r4);
        ListProtector.add(r2, 0, r3);
        return;
    L11:
        r5 = null;
        goto L12
    L19:
        return;
    }
}
