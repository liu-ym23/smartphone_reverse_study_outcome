package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v74, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v83, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v25, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v42, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ArrayList] */
    public static final b0 a(b0 r36) {
        Intrinsics.checkNotNullParameter(r36, "<this>");
        List<c0> r0 = r36.a;
        if (r0 == null) goto L269;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L239;
        c0 r4 = (c0) r3.next();
        if (r4.b == 9) goto L244;
        ?? r1 = CollectionsKt.listOf(r4);
    L237:
        CollectionsKt.addAll(r2, (Iterable) r1);
        goto L6
    L244:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        ouc.v r6 = xt7.d.b;     // Catch: Throwable -> L15
        juc.c r7 = b.Companion.serializer();     // Catch: Throwable -> L15
        String r8 = r4.c;     // Catch: Throwable -> L15
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        Object r9 = Result.constructor-impl((b) r6.c(r7, r8));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r9) == false) goto L20;
        r9 = null;
    L20:
        b r10 = (b) r9;
        if (r10 != null) goto L23;
        r1 = CollectionsKt.listOf(r4);
        goto L237
    L23:
        a0 r11 = r10.d();
        if (r11 == null) goto L228;
        List<f0> r12 = r11.c;
        if (r12 == null) goto L228;
        ?? r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L29:
        if (r14.hasNext() == false) goto L229;
        f0 r15 = (f0) r14.next();
        Integer r16 = r15.f();
        h r17 = r15.d();
        if (r17 == null) goto L187;
        List<w> r18 = r17.e;
        if (r18 != null) goto L35;
        r18 = CollectionsKt.emptyList();
    L35:
        List<w> r19 = r18;
        ArrayList r110 = new ArrayList();
        Iterator r111 = r19.iterator();
    L36:
        boolean r112 = false;
        if (r111.hasNext() == false) goto L47;
        Object r20 = r111.next();
        Integer r113 = ((w) r20).s;
        if (r113 != null) goto L42;
    L44:
        if (r112 == false) goto L36;
        r110.add(r20);
        goto L36
    L42:
        if (r113.intValue() != 1) goto L44;
        r112 = true;
        goto L44
    L47:
        if ((!r110.isEmpty()) == false) goto L53;
        ?? r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r114 = r110.iterator();
    L50:
        if (r114.hasNext() == false) goto L99;
        r21.add(b((w) r114.next(), r17));
    L99:
        if ((!((Collection) r21).isEmpty()) == false) goto L101;
        ?? r115 = r21;
    L102:
        if (r115 == 0) goto L225;
        Long r22 = r17.g;
        if (r22 != null) goto L107;
    L115:
        Integer r23 = r17.f;
        if (r23 != null) goto L118;
    L137:
        Long r24 = null;
    L138:
        Integer r116 = r17.b;
        if (r116 != null) goto L141;
        r116 = r16;
    L141:
        String r25 = r17.c;
        if (r25 != null) goto L144;
    L148:
        r25 = r15.h;
    L149:
        String r117 = r25;
        String r26 = r17.d;
        if (r26 != null) goto L152;
        String r118 = r15.i;
    L153:
        if (r24 == null) goto L170;
        r24.longValue();
        Iterator r27 = r115.iterator();
        int r119 = 0;
    L156:
        if (r27.hasNext() == false) goto L161;
        if (Intrinsics.areEqual(((w) r27.next()).a, r24) == true) goto L162;
        r119 = r119 + 1;
    L162:
        Integer r28 = Integer.valueOf(r119);
        if (r28.intValue() < 0) goto L165;
        r112 = true;
    L165:
        if (r112 == true) goto L168;
        r28 = null;
    L168:
        if (r28 == null) goto L170;
        int r29 = r28.intValue();
    L171:
        Integer r120 = Integer.valueOf(r29);
        if (r24 == null) goto L174;
        long r121 = r24.longValue();
    L175:
        h r30 = h.a(r17, r116, r117, r118, r115, r120, Long.valueOf(r121), 3969);
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L178
        Object r32 = Result.constructor-impl(xt7.d.b.a(h.Companion.serializer(), r30));     // Catch: Throwable -> L178
    L181:
        if (Result.isFailure-impl(r32) == false) goto L183;
        r32 = null;
    L183:
        String r33 = (String) r32;
        if (r33 == null) goto L225;
        c0 r34 = new c0(r30.b, 3, r33);
    L226:
        if (r34 == null) goto L29;
        r13.add(r34);
    L178:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L181
    L174:
        r121 = -1;
        goto L175
    L161:
        r119 = -1;
    L170:
        r29 = -1;
        goto L171
    L152:
        r118 = r26;
        goto L153
    L144:
        if ((!StringsKt.isBlank(r25)) == true) goto L147;
        r25 = null;
    L147:
        if (r25 != null) goto L149;
    L118:
        if (r23.intValue() < 0) goto L120;
        boolean r122 = true;
    L121:
        if (r122 == true) goto L124;
        r23 = null;
    L124:
        if (r23 == null) goto L137;
        int r37 = r23.intValue();
        List<w> r123 = r17.e;
        if (r123 == null) goto L137;
        w r38 = (w) CollectionsKt.getOrNull(r123, r37);
        if (r38 == null) goto L137;
        r24 = r38.a;
        if (r24 == null) goto L137;
        if (r24.longValue() < 0) goto L134;
        boolean r124 = true;
    L135:
        if (r124 == false) goto L137;
    L134:
        r124 = false;
        goto L135
    L120:
        r122 = false;
        goto L121
    L107:
        if (r22.longValue() < 0) goto L109;
        boolean r125 = true;
    L110:
        if (r125 == true) goto L113;
        r22 = null;
    L113:
        if (r22 == null) goto L115;
        r24 = Long.valueOf(r22.longValue());
        goto L138
    L109:
        r125 = false;
    L225:
        r34 = null;
        goto L226
    L101:
        r115 = 0;
        goto L102
    L53:
        if (Intrinsics.areEqual(r17.h, Boolean.TRUE) == false) goto L55;
        r21 = CollectionsKt.emptyList();
        goto L99
    L55:
        Long r39 = r17.g;
        if (r39 != null) goto L58;
    L81:
        Integer r40 = r17.f;
        if (r40 != null) goto L84;
    L97:
        r21 = CollectionsKt.emptyList();
        goto L99
    L84:
        if (r40.intValue() < 0) goto L86;
        boolean r126 = true;
    L87:
        if (r126 == true) goto L90;
        r40 = null;
    L90:
        if (r40 == null) goto L97;
        w r41 = (w) CollectionsKt.getOrNull(r18, r40.intValue());
        if (r41 == null) goto L94;
        r21 = CollectionsKt.listOf(b(r41, r17));
    L95:
        if (r21 != 0) goto L99;
        r21 = CollectionsKt.emptyList();
        goto L99
    L94:
        r21 = 0;
        goto L95
    L86:
        r126 = false;
        goto L87
    L58:
        if (r39.longValue() < 0) goto L60;
        boolean r127 = true;
    L61:
        if (r127 == true) goto L64;
        r39 = null;
    L64:
        if (r39 == null) goto L81;
        long r128 = r39.longValue();
        Iterator r42 = r19.iterator();
    L67:
        if (r42.hasNext() == false) goto L77;
        Object r129 = r42.next();
        Long r130 = ((w) r129).a;
        if (r130 != null) goto L72;
    L74:
        boolean r131 = false;
    L75:
        if (r131 == false) goto L67;
    L78:
        w r132 = (w) r129;
        if (r132 == null) goto L81;
        r21 = CollectionsKt.listOf(b(r132, r17));
        goto L99
    L72:
        if (r130.longValue() != r128) goto L74;
        r131 = true;
        goto L75
    L77:
        r129 = null;
        goto L78
    L60:
        r127 = false;
        goto L61
    L187:
        j r43 = r15.e();
        if (r43 == null) goto L225;
        Integer r133 = r43.i;
        if (r133 != null) goto L197;
        r133 = r43.h;
        if ((!Intrinsics.areEqual(r43.j, Boolean.TRUE)) == true) goto L196;
        r133 = null;
    L196:
        if (r133 == null) goto L225;
    L197:
        int r134 = r133.intValue();
        Integer r135 = r43.a;
        if (r135 != null) goto L200;
        Integer r136 = r16;
    L201:
        String r44 = r43.b;
        if (r44 != null) goto L204;
    L208:
        r44 = r15.h;
    L209:
        String r210 = r44;
        String r45 = r43.c;
        if (r45 != null) goto L212;
        String r211 = r15.i;
    L213:
        j r46 = new j(r136, r210, r211, r43.d, r43.e, r43.f, r43.g, r43.h, Integer.valueOf(r134), r43.j, r43.k, r43.l, r43.m, r43.n, r43.o, r43.p, r43.q);
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L216
        Object r48 = Result.constructor-impl(xt7.d.b.a(j.Companion.serializer(), r46));     // Catch: Throwable -> L216
    L219:
        if (Result.isFailure-impl(r48) == false) goto L221;
        r48 = null;
    L221:
        String r49 = (String) r48;
        if (r49 == null) goto L225;
        r34 = new c0(r46.a, 10, r49);
    L216:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L219
    L212:
        r211 = r45;
        goto L213
    L204:
        if ((!StringsKt.isBlank(r44)) == true) goto L207;
        r44 = null;
    L207:
        if (r44 != null) goto L209;
    L200:
        r136 = r135;
    L229:
        if (r13 != 0) goto L232;
        r13 = CollectionsKt.emptyList();
    L232:
        if ((!((Collection) r13).isEmpty()) == false) goto L234;
        r1 = r13;
    L235:
        if (r1 != 0) goto L237;
        r1 = CollectionsKt.listOf(r4);
        goto L237
    L234:
        r1 = 0;
    L228:
        r13 = 0;
    L15:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L239:
        return new b0(r2, r36.b);
    L269:
        return r36;
    }

    public static final w b(w r19, h r20) {
        boolean r10 = true;
        Long r4 = null;
        w r11 = w.a(r19, null, null, 1, null, null, null, 8126463);
        Long r0 = r20.g;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L18:
        Integer r2 = r20.f;
        if (r2 != null) goto L21;
    L51:
        if (r1 == true) goto L54;
        return r11;
    L54:
        return w.a(r11, "", null, null, "", null, null, 7340023);
    L21:
        if (r2.intValue() < 0) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L27;
        r2 = null;
    L27:
        if (r2 == null) goto L51;
        int r3 = r2.intValue();
        List<w> r6 = r20.e;
        if (r6 == null) goto L51;
        w r7 = (w) CollectionsKt.getOrNull(r6, r3);
        if (r7 == null) goto L51;
        Long r8 = r7.a;
        if (r8 != null) goto L36;
    L49:
        r10 = Intrinsics.areEqual(r7, r19);
    L50:
        r1 = r10;
        goto L51
    L36:
        if (r8.longValue() < 0) goto L38;
        boolean r9 = true;
    L39:
        if (r9 == false) goto L41;
        r4 = r8;
    L41:
        if (r4 == null) goto L49;
        long r12 = r4.longValue();
        Long r13 = r19.a;
        if (r13 != null) goto L46;
    L48:
        r10 = false;
        goto L50
    L46:
        if (r13.longValue() != r12) goto L48;
    L38:
        r9 = false;
        goto L39
    L23:
        r5 = false;
        goto L24
    L5:
        if (r0.longValue() < 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L18;
        long r15 = r0.longValue();
        Long r16 = r19.a;
        if (r16 == null) goto L48;
        if (r16.longValue() != r15) goto L48;
    L7:
        r14 = false;
        goto L8
    }
}
