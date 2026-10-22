package com.bytedance.android.live.recharge.deal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    public k() {
    }

    static {
    }

    public static s a(i r25, List r26, Long r27, Long r28, Map r29, Map r30, int r32) {
        Map r2 = null;
        if ((r32 & 2) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r32 & 8) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r32 & 16) == 0) goto L13;
        Long r4 = null;
    L15:
        if ((r32 & 32) == 0) goto L17;
        Map r5 = null;
    L19:
        if ((r32 & 64) != 0) goto L22;
        r2 = r30;
    L22:
        Intrinsics.checkNotNullParameter(r25, "original");
        if ((r25 instanceof s) == false) goto L25;
        i r8 = ((s) r25).a;
    L26:
        if (r1 != null) goto L28;
        r1 = r25.c();
    L28:
        List r6 = r1;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L30:
        if (r7.hasNext() == false) goto L32;
        u r10 = (u) r7.next();
        long r12 = r10.b;
        long r13 = r10.c;
        int r15 = r10.d;
        int r14 = r10.e;
        String r16 = r10.f;
        String r0 = r10.g;
        Iterator r210 = r7;
        boolean r17 = r10.h;
        i r211 = r8;
        int r18 = r10.i;
        Map r212 = r2;
        int r19 = r10.j;
        Map r24 = r5;
        String r20 = r10.k;
        int r22 = r10.l;
        Intrinsics.checkNotNullParameter(r16, "description");
        Intrinsics.checkNotNullParameter(r0, "iapProductId");
        Intrinsics.checkNotNullParameter(r20, "diamondSignInfo");
        r9.add(new u(r12, r13, r15, r14, r16, r0, r17, r18, r19, r20, r22));
        r7 = r210;
        r8 = r211;
        r2 = r212;
        r5 = r24;
        goto L30
    L32:
        Map r213 = r2;
        Map r214 = r5;
        i r215 = r8;
        List<d> r23 = r25.k();
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r33 = r23.iterator();
    L34:
        if (r33.hasNext() == false) goto L36;
        r110.add(d.j((d) r33.next(), 0, false, 1023));
        goto L34
    L36:
        if (r3 == null) goto L38;
        long r34 = r3.longValue();
    L39:
        long r111 = r34;
        if (r4 == null) goto L42;
        long r35 = r4.longValue();
    L43:
        long r112 = r35;
        if (r214 != null) goto L46;
        Map r113 = r25.j();
    L47:
        if (r213 != null) goto L49;
        Map r114 = r25.getPanelExtraInfo();
    L51:
        return new s(r215, r9, r110, r111, r112, r113, r114);
    L49:
        r114 = r213;
        goto L51
    L46:
        r113 = r214;
        goto L47
    L42:
        r35 = r25.l();
        goto L43
    L38:
        r34 = r25.d();
        goto L39
    L25:
        r8 = r25;
        goto L26
    L17:
        r5 = r29;
        goto L19
    L13:
        r4 = r28;
        goto L15
    L9:
        r3 = r27;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }
}
