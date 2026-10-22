package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public static final Map a(List r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L50
        String r2 = null;
        if (r7 == null) goto L21;
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L50
    L6:
        if (r8.hasNext() == false) goto L16;
        Object r3 = r8.next();     // Catch: Throwable -> L50
        Integer r4 = ((u) r3).b;     // Catch: Throwable -> L50
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L6;
    L17:
        u r6 = (u) r3;     // Catch: Throwable -> L50
        if (r6 == null) goto L21;
        String r9 = r6.d;     // Catch: Throwable -> L50
    L22:
        String r10 = "";
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        List<c0> r11 = ((b0) xt7.d.b.c(b0.Companion.serializer(), r9)).a;     // Catch: Throwable -> L50
        if (r11 == null) goto L38;
        Iterator<T> r12 = r11.iterator();     // Catch: Throwable -> L50
    L29:
        if (r12.hasNext() == false) goto L36;
        Object r13 = r12.next();     // Catch: Throwable -> L50
        if (((c0) r13).b != 9) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == false) goto L29;
    L37:
        c0 r15 = (c0) r13;     // Catch: Throwable -> L50
    L39:
        ouc.v r16 = xt7.d.b;     // Catch: Throwable -> L50
        juc.c r1 = b.Companion.serializer();     // Catch: Throwable -> L50
        if (r15 == null) goto L42;
        r2 = r15.c;     // Catch: Throwable -> L50
    L42:
        if (r2 == null) goto L45;
        r10 = r2;
    L45:
        Map<String, a0> r17 = ((b) r16.c(r1, r10)).a;     // Catch: Throwable -> L50
        if (r17 != null) goto L48;
        r17 = MapsKt.emptyMap();     // Catch: Throwable -> L50
    L48:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L50
    L52:
        Map r19 = MapsKt.emptyMap();
        if (Result.isFailure-impl(r18) == false) goto L56;
        r18 = r19;
    L56:
        return (Map) r18;
    L33:
        r14 = false;
        goto L34
    L36:
        r13 = null;
        goto L37
    L38:
        r15 = null;
        goto L39
    L11:
        if (r4.intValue() != 8) goto L13;
        r5 = true;
        goto L14
    L16:
        r3 = null;
    L21:
        r9 = null;
    L50:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    }

    public static final w0 b(Map r30, long r31) {
        a0 r0 = (a0) r30.get(String.valueOf(r31));
        if (r0 == null) goto L256;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        int r1 = v0.a;
        Intrinsics.checkNotNullParameter(r0, "config");
        List<f0> r2 = r0.c;
        if (r2 != null) goto L7;
        r2 = CollectionsKt.emptyList();
    L7:
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L8:
        int r5 = 3;
        char r6 = 0;
        char r7 = 1;
        if (r4.hasNext() == false) goto L16;
        Object r8 = r4.next();
        if (((f0) r8).getType() != 3) goto L13;
        r6 = 1;
    L13:
        if (r6 == 0) goto L8;
        r3.add(r8);
        goto L8
    L16:
        if (r3.size() != 1) goto L34;
        String r9 = ((f0) CollectionsKt.single(r3)).b;
        if (r9 == null) goto L34;
        if ((!StringsKt.isBlank(r9)) == true) goto L24;
        r9 = null;
    L24:
        if (r9 == null) goto L34;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L28
        Object r11 = Result.constructor-impl((n1) xt7.d.b.c(n1.Companion.serializer(), r9));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r11) == false) goto L33;
        r11 = null;
    L33:
        n1 r12 = (n1) r11;
    L35:
        if (r12 == null) goto L236;
        LinkedHashMap r13 = new LinkedHashMap();
        ArrayList r14 = new ArrayList();
        List<z> r15 = r12.c;
        if (r15 != null) goto L40;
        r15 = CollectionsKt.emptyList();
    L40:
        Iterator r16 = r15.iterator();
    L42:
        if (r16.hasNext() == false) goto L149;
        z r17 = (z) r16.next();
        String r18 = r17.getType();
        if (r18 == null) goto L48;
        String r19 = StringsKt.trim(r18).toString();
        if (r19 == null) goto L48;
        String r110 = r19.toLowerCase(Locale.ROOT);
    L50:
        if (Intrinsics.areEqual(r110, "mixed") == false) goto L52;
        r14.add(r17);
        r12 = r12;
        r14 = r14;
        r16 = r16;
    L148:
        r16 = r16;
        r12 = r12;
        r14 = r14;
        r5 = 3;
        r6 = 0;
        r7 = 1;
        goto L42
    L52:
        CreationReferenceMediaType.Companion.getClass();
        if (CreationReferenceMediaType.a.a(r110) == null) goto L236;
        CreationReferenceMediaType r111 = CreationReferenceMediaType.a.a(r17.getType());
        if (r111 == null) goto L143;
        Integer r112 = r17.c;
        if (r112 == null) goto L140;
        Long[] r113 = new Long[4];
        r113[r6] = Long.valueOf(r112.intValue());
        r113[r7] = r17.h;
        r113[2] = r17.i;
        r113[r5] = r17.o;
        List r114 = CollectionsKt.listOfNotNull(r113);
        if ((r114 instanceof Collection) == true) goto L63;
    L65:
        Iterator r115 = r114.iterator();
    L67:
        if (r115.hasNext() == false) goto L74;
        if (((Number) r115.next()).longValue() >= 0) goto L71;
        boolean r116 = true;
    L72:
        if (r116 == false) goto L67;
        boolean r117 = true;
    L75:
        if (r117 == true) goto L140;
        Double[] r118 = new Double[r5];
        r118[r6] = r17.m;
        r118[r7] = r17.n;
        r118[2] = r17.e;
        List r119 = CollectionsKt.listOfNotNull(r118);
        if ((r119 instanceof Collection) == true) goto L80;
    L82:
        Iterator r120 = r119.iterator();
    L84:
        if (r120.hasNext() == false) goto L99;
        double r121 = ((Number) r120.next()).doubleValue();
        if (Double.isInfinite(r121) == false) goto L88;
    L90:
        boolean r122 = false;
    L91:
        if (r122 == true) goto L93;
    L96:
        boolean r123 = true;
    L97:
        if (r123 == false) goto L84;
        boolean r124 = true;
    L100:
        if (r124 == true) goto L140;
        Double[] r125 = new Double[2];
        r125[r6] = r17.k;
        r125[r7] = r17.l;
        List r126 = CollectionsKt.listOfNotNull(r125);
        if ((r126 instanceof Collection) == true) goto L105;
    L107:
        Iterator r127 = r126.iterator();
    L109:
        if (r127.hasNext() == false) goto L124;
        double r128 = ((Number) r127.next()).doubleValue();
        if (Double.isInfinite(r128) == false) goto L113;
    L115:
        boolean r129 = false;
    L116:
        if (r129 == true) goto L118;
    L121:
        boolean r130 = true;
    L122:
        if (r130 == false) goto L109;
        boolean r20 = true;
    L125:
        if (r20 == true) goto L140;
        Double r21 = r17.k;
        if (r21 != null) goto L130;
    L134:
        Double r22 = r17.m;
        if (r22 != null) goto L137;
    L141:
        boolean r23 = true;
    L142:
        if (r23 == false) goto L143;
        wa8.g1 r24 = new wa8.g1(r111, r17.c, r17.d, r17.e, r17.f, r17.g, r17.h, r17.i, r17.j, r17.k, r17.l, r17.m, r17.n, r17.o);
    L145:
        if (r24 == null) goto L236;
        r13.put(r24.getType(), r24);
        goto L148
    L137:
        if (r17.n == null) goto L141;
        if (r22.doubleValue() <= r17.n.doubleValue()) goto L141;
    L130:
        if (r17.l == null) goto L134;
        if (r21.doubleValue() <= r17.l.doubleValue()) goto L134;
    L118:
        if (r128 < 0.0d) goto L121;
        r130 = false;
        goto L122
    L113:
        if (Double.isNaN(r128) == true) goto L115;
        r129 = true;
    L124:
        r20 = false;
        goto L125
    L105:
        if (r126.isEmpty() == false) goto L107;
    L93:
        if (r121 < 0.0d) goto L96;
        r123 = false;
        goto L97
    L88:
        if (Double.isNaN(r121) == true) goto L90;
        r122 = true;
    L99:
        r124 = false;
        goto L100
    L80:
        if (r119.isEmpty() == false) goto L82;
    L71:
        r116 = false;
    L74:
        r117 = false;
        goto L75
    L63:
        if (r114.isEmpty() == false) goto L65;
    L140:
        r23 = false;
    L143:
        r24 = null;
    L48:
        r110 = null;
        goto L50
    L149:
        n1 r28 = r12;
        ArrayList r29 = r14;
        if (r13.isEmpty() == true) goto L236;
        ArrayList r25 = new ArrayList();
        Iterator r26 = r29.iterator();
    L154:
        if (r26.hasNext() == false) goto L239;
        z r27 = (z) r26.next();
        List<String> r32 = r27.b;
        if (r32 != null) goto L159;
        r32 = CollectionsKt.emptyList();
    L159:
        if (r32.isEmpty() == false) goto L161;
        Object r33 = v0.a.C0031a.a;
    L215:
        if (Intrinsics.areEqual(r33, v0.a.C0031a.a) == true) goto L236;
        if (Intrinsics.areEqual(r33, v0.a.b.a) == true) goto L236;
        if ((r33 instanceof v0.a.c) == false) goto L238;
        v0.a.c r34 = (v0.a.c) r33;
        List<CreationReferenceMediaType> r35 = r34.a.a;
        if ((r35 instanceof Collection) == true) goto L225;
    L227:
        Iterator<T> r36 = r35.iterator();
    L229:
        if (r36.hasNext() == false) goto L233;
        if (r13.containsKey((CreationReferenceMediaType) r36.next()) == true) goto L229;
        boolean r37 = false;
    L234:
        if (r37 == false) goto L236;
        r25.add(r34.a);
    L233:
        r37 = true;
        goto L234
    L225:
        if (r35.isEmpty() == false) goto L227;
    L238:
        throw new NoWhenBranchMatchedException();
    L161:
        List<String> r38 = r32;
        ArrayList r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        Iterator<T> r40 = r38.iterator();
    L163:
        if (r40.hasNext() == false) goto L169;
        String r41 = (String) r40.next();
        CreationReferenceMediaType.Companion.getClass();
        CreationReferenceMediaType r42 = CreationReferenceMediaType.a.a(r41);
        if (r42 == null) goto L166;
        r39.add(r42);
        goto L163
    L166:
        r33 = v0.a.b.a;
        goto L215
    L169:
        List r43 = CollectionsKt.distinct(r39);
        if (r43.isEmpty() == true) goto L213;
        Integer r44 = r27.c;
        if (r44 != null) goto L174;
    L180:
        boolean r45 = false;
    L181:
        if (r45 == true) goto L208;
        Double r46 = r27.e;
        if (r46 == null) goto L199;
        double r47 = r46.doubleValue();
        if (Double.isInfinite(r47) == false) goto L187;
    L189:
        boolean r48 = false;
    L190:
        if (r48 == true) goto L192;
    L195:
        boolean r49 = true;
        boolean r50 = true;
    L196:
        if (r50 != r49) goto L199;
        boolean r51 = true;
    L200:
        if (r51 == true) goto L208;
        if (r27.c == null) goto L205;
    L206:
        boolean r52 = true;
    L209:
        if (r52 == false) goto L213;
        r33 = new v0.a.c(new wa8.h1(CollectionsKt.toList(r43), r27.c, r27.d, r27.e, r27.f, r27.g));
        goto L215
    L205:
        if (r27.e == null) goto L208;
    L192:
        if (r47 < 0.0d) goto L195;
        r49 = true;
        r50 = false;
        goto L196
    L187:
        if (Double.isNaN(r47) == true) goto L189;
        r48 = true;
    L199:
        r51 = false;
    L208:
        r52 = false;
        goto L209
    L174:
        if (r44.intValue() >= 0) goto L176;
        boolean r53 = true;
    L178:
        if (r53 != true) goto L180;
        r45 = true;
        goto L181
    L176:
        r53 = false;
    L213:
        r33 = v0.a.C0031a.a;
        goto L215
    L239:
        String r54 = r28.a;
        l1 r55 = r28.b;
        if (r55 == null) goto L250;
        g1 r56 = r55.a;
        if (r56 == null) goto L244;
        wa8.e1 r131 = new wa8.e1(r56.a, r56.b, r56.c, r56.d, r56.e);
    L245:
        g1 r57 = r55.b;
        if (r57 == null) goto L248;
        wa8.e1 r132 = new wa8.e1(r57.a, r57.b, r57.c, r57.d, r57.e);
    L249:
        wa8.f1 r58 = new wa8.f1(r131, r132, r55.c);
    L251:
        wa8.d1 r59 = new wa8.d1(r54, r58, MapsKt.toMap(r13), CollectionsKt.toList(r25));
    L252:
        if (r59 == null) goto L256;
        return new w0.a(r59);
    L248:
        r132 = null;
        goto L249
    L244:
        r131 = null;
        goto L245
    L250:
        r58 = null;
    L236:
        r59 = null;
    L28:
        th = move-exception;
        Result.Companion r60 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        r12 = null;
    L256:
        return w0.b.a;
    }
}
