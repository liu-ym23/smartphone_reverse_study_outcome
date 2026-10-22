package com.larus.canvas.core.impl.sse;

import cy8.c;
import cy8.d;
import cy8.e;
import cy8.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final LinkedHashMap<String, cy8.b> a;
    public final Map<String, Long> b;
    public Long c;

    public a() {
        this(0);
    }

    public a(List<cy8.b> r5) {
        Intrinsics.checkNotNullParameter(r5, "originBlocks");
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        Iterator<T> r6 = r5.iterator();
        int r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r1 = r6.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        cy8.b r3 = (cy8.b) r1;
        this.a.put(a(r3, r0), r3);
        r0 = r2;
        goto L4
    }

    public final c c(String r4) {
        return new c(CollectionsKt.toList(this.a.values()), this.c, r4);
    }

    public /* synthetic */ a(int r1) {
        this(CollectionsKt.emptyList());
    }

    public static String a(cy8.b r1, int r2) {
        String r0 = r1.b;
        if (r0 != null) goto L12;
        Integer r3 = r1.c;
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        String r5 = r4;
        if (r5 == null) goto L11;
        return r5;
    L11:
        return "idx_" + r2;
    L7:
        r4 = null;
        goto L8
    L12:
        return r0;
    }

    public final c b(List<cy8.b> r42, Long r43, boolean r44, String r45) {
        Long r1 = r43;
        Intrinsics.checkNotNullParameter(r42, "patchBlocks");
        Iterator r0 = r42.iterator();
        a r5 = this;
        Long r4 = r1;
        int r6 = 0;
    L4:
        if (r0.hasNext() == false) goto L121;
        Object r7 = r0.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        cy8.b r9 = (cy8.b) r7;
        String r10 = a(r9, r6);
        Long r11 = (Long) ((LinkedHashMap) r5.b).get(r10);
        if (r44 == true) goto L15;
        if (r4 == null) goto L15;
        if (r11 == null) goto L15;
        if (r43.longValue() > r11.longValue()) goto L15;
        r0 = r0;
        Long r2 = r1;
        r8 = r8;
    L119:
        r1 = r2;
        r0 = r0;
        r6 = r8;
    L15:
        cy8.b r12 = r5.a.get(r10);
        LinkedHashMap<String, cy8.b> r13 = r5.a;
        if (r12 != null) goto L22;
        String r14 = r9.f;
        if (r14 != null) goto L20;
        String r15 = r45;
    L21:
        cy8.b r16 = new cy8.b(r9.a, r9.b, r9.c, r9.d, r9.e, r15);
        r0 = r0;
        LinkedHashMap<String, cy8.b> r3 = r13;
        String r17 = r10;
        r8 = r8;
    L115:
        r3.put(r17, r16);
        r2 = r43;
        if (r2 == null) goto L118;
        this.b.put(r17, r2);
    L118:
        r4 = r2;
        r5 = this;
        goto L119
    L20:
        r15 = r14;
        goto L21
    L22:
        Integer r18 = r9.a;
        if (r18 != null) goto L25;
        r18 = r12.a;
    L25:
        Integer r19 = r18;
        String r20 = r9.b;
        if (r20 != null) goto L28;
        r20 = r12.b;
    L28:
        String r110 = r20;
        Integer r21 = r9.c;
        if (r21 != null) goto L31;
        r21 = r12.c;
    L31:
        Integer r111 = r21;
        if (r12.d == false) goto L34;
    L37:
        boolean r112 = true;
    L38:
        cy8.a r22 = r12.e;
        cy8.a r113 = r9.e;
        if (r22 == null) goto L41;
        if (r113 != null) goto L44;
        r113 = r22;
        goto L41
    L44:
        cy8.k r23 = r22.a;
        cy8.k r114 = r113.a;
        if (r23 != null) goto L48;
        cy8.k r115 = r114;
    L54:
        cy8.i r24 = r113.b;
        if (r24 != null) goto L57;
        r24 = r22.b;
    L57:
        cy8.i r25 = r24;
        n r26 = r113.c;
        if (r26 != null) goto L60;
        r26 = r22.c;
    L60:
        n r27 = r26;
        cy8.h r28 = r22.d;
        cy8.h r29 = r113.d;
        if (r28 != null) goto L63;
        cy8.h r210 = r29;
    L104:
        e r30 = r113.e;
        if (r30 != null) goto L107;
        r30 = r22.e;
    L107:
        r113 = new cy8.a(r115, r25, r27, r210, r30);
    L108:
        String r31 = r9.f;
        if (r31 != null) goto L113;
        if (r45 != null) goto L112;
        r31 = r12.f;
        goto L113
    L112:
        String r116 = r45;
    L114:
        r16 = new cy8.b(r19, r110, r111, r112, r113, r116);
        r3 = r13;
        r17 = r10;
    L113:
        r116 = r31;
        goto L114
    L63:
        if (r29 == null) goto L103;
        String r32 = r29.a;
        if (r32 != null) goto L68;
    L71:
        boolean r33 = true;
    L72:
        List<cy8.j> r34 = null;
        if (r33 == false) goto L76;
        r32 = null;
    L76:
        if (r32 != null) goto L78;
        r32 = r28.a;
    L78:
        String r211 = r32;
        String r35 = r29.b;
        if (r35 != null) goto L81;
    L84:
        boolean r36 = true;
    L85:
        if (r36 == false) goto L88;
        r35 = null;
    L88:
        if (r35 != null) goto L90;
        r35 = r28.b;
    L90:
        String r212 = r35;
        List<cy8.j> r37 = r29.c;
        List<cy8.j> r38 = r37;
        if (r38 != null) goto L93;
    L96:
        boolean r117 = true;
    L97:
        if (r117 == true) goto L99;
        r34 = r37;
    L99:
        if (r34 != null) goto L101;
        List<cy8.j> r213 = r28.c;
    L102:
        r28 = new cy8.h(r211, r212, r213, r29.d, r29.e);
        goto L103
    L101:
        r213 = r34;
        goto L102
    L93:
        if (r38.isEmpty() == true) goto L96;
        r117 = false;
        goto L97
    L81:
        if (r35.length() == 0) goto L84;
        r36 = false;
        goto L85
    L68:
        if (r32.length() == 0) goto L71;
        r33 = false;
    L103:
        r210 = r28;
        goto L104
    L48:
        if (r114 != null) goto L50;
        r115 = r23;
        goto L54
    L50:
        r0 = r0;
        d r39 = r114.j;
        if (r39 != null) goto L53;
        r39 = r23.j;
    L53:
        r8 = r8;
        r13 = r13;
        r10 = r10;
        r12 = r12;
        r115 = new cy8.k(r114.a, r114.b, r114.c, r114.d, r114.e, r114.f, r114.g, r114.h, r114.i, r39, r114.k, r114.l, r114.m);
    L41:
        r19 = r19;
        r110 = r110;
        r111 = r111;
        r112 = r112;
        goto L108
    L34:
        if (r9.d == true) goto L37;
        r112 = false;
        goto L38
    L121:
        if (r4 == null) goto L124;
        r5.c = r4;
    L124:
        return r5.c(r45);
    }
}
