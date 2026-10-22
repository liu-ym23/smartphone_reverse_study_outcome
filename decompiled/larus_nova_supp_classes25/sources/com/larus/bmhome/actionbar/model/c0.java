package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class c0 implements k1 {
    public static final b Companion = null;
    public final Integer a;
    public final int b;
    public String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<c0> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.w0 r1 = nuc.w0.a;
            return new juc.d[]{kuc.a.d(r1), r1, kuc.a.d(v2.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarMultiSelectorItem", r0, 3);
            r1.j("id", true);
            r1.j("item_type", true);
            r1.j("template", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            muc.c r13 = r12.beginStructure(r0);
            if (r13.decodeSequentially() == false) goto L5;
            Integer r1 = (Integer) r13.decodeNullableSerializableElement(r0, 0, nuc.w0.a, null);
            int r3 = r13.decodeIntElement(r0, 1);
            String r2 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, null);
            int r4 = 7;
        L19:
            r13.endStructure(r0);
            return new c0(r4, r1, r3, r2);
        L5:
            Integer r6 = null;
            String r7 = null;
            int r5 = 0;
            int r8 = 0;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L18;
            int r10 = r13.decodeElementIndex(r0);
            if (r10 != (-1)) goto L9;
            r9 = false;
            goto L6
        L9:
            if (r10 != 0) goto L10;
            r6 = (Integer) r13.decodeNullableSerializableElement(r0, 0, nuc.w0.a, r6);
            r8 = r8 | 1;
            goto L6
        L10:
            if (r10 != 1) goto L11;
            r5 = r13.decodeIntElement(r0, 1);
            r8 = r8 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r7 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, r7);
            r8 = r8 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r10);
        L18:
            r3 = r5;
            r4 = r8;
            r1 = r6;
            r2 = r7;
            goto L19
        }

        public final void serialize(muc.f r6, Object r7) {
            c0 r8 = (c0) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = c0.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r9.encodeIntElement(r0, 1, r8.b);
        L21:
            if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r9.encodeNullableSerializableElement(r0, 2, v2.a, r8.c);
        L28:
            r9.endStructure(r0);
            return;
        L24:
            if (r8.c == null) goto L26;
        L15:
            if (r8.b != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c0> serializer() {
            return a.a;
        }
    }

    public c0() {
        this(null, 0, null);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r6 = (c0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarMultiSelectorItem(id=" + this.a + ", itemType=" + this.b + ", template=" + this.c + ')';
    }

    static {
        Companion = new b();
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        int r0 = this.b;
        String r4 = "";
        if (r0 != 3) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L77
        ouc.v r2 = xt7.d.b;     // Catch: Throwable -> L77
        juc.c r3 = h.Companion.serializer();     // Catch: Throwable -> L77
        String r7 = this.c;     // Catch: Throwable -> L77
        if (r7 == null) goto L75;
        r4 = r7;
    L75:
        Object r5 = Result.constructor-impl((h) r2.c(r3, r4));     // Catch: Throwable -> L77
    L80:
        if (Result.exceptionOrNull-impl(r5) != null) goto L114;
        h r6 = (h) r5;
        if (r6 == null) goto L115;
        ArrayList r8 = new ArrayList();
        String r9 = r6.c;
        if (r9 == null) goto L86;
        r8.add(r9);
    L86:
        List<w> r10 = r6.e;
        if (r10 == null) goto L96;
        List<w> r11 = r10;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L90:
        if (r13.hasNext() == false) goto L92;
        r12.add(((w) r13.next()).b);
        goto L90
    L92:
        String r14 = CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);
        if (r14 == null) goto L96;
        r8.add(r14);
    L96:
        if ((!r8.isEmpty()) == true) goto L98;
        return null;
    L98:
        return CollectionsKt.joinToString$default(r8, ";", null, null, 0, null, null, 62, null);
    L115:
        return null;
    L114:
        return null;
    L77:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L5:
        if (r0 != 7) goto L7;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L49
        ouc.v r17 = xt7.d.b;     // Catch: Throwable -> L49
        juc.c r18 = com.larus.bmhome.actionbar.model.a.Companion.serializer();     // Catch: Throwable -> L49
        String r19 = this.c;     // Catch: Throwable -> L49
        if (r19 == null) goto L47;
        r4 = r19;
    L47:
        Object r20 = Result.constructor-impl((com.larus.bmhome.actionbar.model.a) r17.c(r18, r4));     // Catch: Throwable -> L49
    L52:
        if (Result.exceptionOrNull-impl(r20) != null) goto L111;
        com.larus.bmhome.actionbar.model.a r21 = (com.larus.bmhome.actionbar.model.a) r20;
        if (r21 == null) goto L112;
        ArrayList r22 = new ArrayList();
        String r23 = r21.b;
        if (r23 == null) goto L58;
        r22.add(r23);
    L58:
        List<w> r24 = r21.j;
        if (r24 == null) goto L68;
        List<w> r25 = r24;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<T> r27 = r25.iterator();
    L62:
        if (r27.hasNext() == false) goto L64;
        r26.add(((w) r27.next()).b);
        goto L62
    L64:
        String r28 = CollectionsKt.joinToString$default(r26, ",", null, null, 0, null, null, 62, null);
        if (r28 == null) goto L68;
        r22.add(r28);
    L68:
        if ((!r22.isEmpty()) == true) goto L70;
        return null;
    L70:
        return CollectionsKt.joinToString$default(r22, ";", null, null, 0, null, null, 62, null);
    L112:
        return null;
    L111:
        return null;
    L49:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L7:
        if (r0 == 9) goto L105;
        if (r0 == 10) goto L103;
        return null;
    L103:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L16
        ouc.v r31 = xt7.d.b;     // Catch: Throwable -> L16
        juc.c r32 = j.Companion.serializer();     // Catch: Throwable -> L16
        String r33 = this.c;     // Catch: Throwable -> L16
        if (r33 == null) goto L14;
        r4 = r33;
    L14:
        Object r34 = Result.constructor-impl((j) r31.c(r32, r4));     // Catch: Throwable -> L16
    L19:
        if (Result.exceptionOrNull-impl(r34) != null) goto L109;
        j r35 = (j) r34;
        String r36 = r35.a(r35.i);
        String[] r37 = new String[2];
        String r38 = r35.b;
        if (r38 != null) goto L23;
    L25:
        r38 = null;
    L26:
        r37[0] = r38;
        r37[1] = r36;
        String r39 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r37), ";", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r39)) == true) goto L29;
        return null;
    L29:
        return r39;
    L23:
        if ((!StringsKt.isBlank(r38)) == false) goto L25;
    L109:
        return null;
    L16:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L105:
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L36
        ouc.v r42 = xt7.d.b;     // Catch: Throwable -> L36
        juc.c r43 = com.larus.bmhome.actionbar.model.b.Companion.serializer();     // Catch: Throwable -> L36
        String r44 = this.c;     // Catch: Throwable -> L36
        if (r44 == null) goto L34;
        r4 = r44;
    L34:
        Object r45 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b) r42.c(r43, r4));     // Catch: Throwable -> L36
    L39:
        if (Result.exceptionOrNull-impl(r45) == null) goto L41;
        return null;
    L41:
        return ((com.larus.bmhome.actionbar.model.b) r45).a();
    L36:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    public final int d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r13, List<String> r14) {
        int r0 = this.b;
        String r3 = "";
        if (r0 != 3) goto L5;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L84
        ouc.v r16 = xt7.d.b;     // Catch: Throwable -> L84
        juc.c r17 = h.Companion.serializer();     // Catch: Throwable -> L84
        String r1 = this.c;     // Catch: Throwable -> L84
        if (r1 == null) goto L82;
        r3 = r1;
    L82:
        Object r18 = Result.constructor-impl((h) r16.c(r17, r3));     // Catch: Throwable -> L84
    L87:
        if (Result.exceptionOrNull-impl(r18) != null) goto L117;
        h r19 = (h) r18;
        if (r19 == null) goto L118;
        List<w> r110 = r19.e;
        if (r110 == null) goto L119;
        List<w> r111 = r110;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L94:
        if (r112.hasNext() == false) goto L97;
        r4.add(((w) r112.next()).d);
        goto L94
    L97:
        return CollectionsKt.joinToString$default(r4, wa8.h.a(), null, null, 0, null, null, 62, null);
    L119:
        return null;
    L118:
        return null;
    L117:
        return null;
    L84:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L87
    L5:
        if (r0 != 6) goto L7;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L64
        ouc.v r115 = xt7.d.b;     // Catch: Throwable -> L64
        juc.c r116 = h.Companion.serializer();     // Catch: Throwable -> L64
        String r2 = this.c;     // Catch: Throwable -> L64
        if (r2 == null) goto L62;
        r3 = r2;
    L62:
        Object r117 = Result.constructor-impl((h) r115.c(r116, r3));     // Catch: Throwable -> L64
    L67:
        if (Result.exceptionOrNull-impl(r117) != null) goto L114;
        h r118 = (h) r117;
        if (r118 == null) goto L115;
        List<w> r119 = r118.e;
        if (r119 == null) goto L116;
        List<w> r120 = r119;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator<T> r121 = r120.iterator();
    L74:
        if (r121.hasNext() == false) goto L77;
        r5.add(((w) r121.next()).d);
        goto L74
    L77:
        return CollectionsKt.joinToString$default(r5, wa8.h.a(), null, null, 0, null, null, 62, null);
    L116:
        return null;
    L115:
        return null;
    L114:
        return null;
    L64:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r117 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    L7:
        if (r0 != 7) goto L9;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L44
        ouc.v r124 = xt7.d.b;     // Catch: Throwable -> L44
        juc.c r125 = com.larus.bmhome.actionbar.model.a.Companion.serializer();     // Catch: Throwable -> L44
        String r6 = this.c;     // Catch: Throwable -> L44
        if (r6 == null) goto L42;
        r3 = r6;
    L42:
        Object r126 = Result.constructor-impl((com.larus.bmhome.actionbar.model.a) r124.c(r125, r3));     // Catch: Throwable -> L44
    L47:
        if (Result.exceptionOrNull-impl(r126) != null) goto L111;
        com.larus.bmhome.actionbar.model.a r127 = (com.larus.bmhome.actionbar.model.a) r126;
        if (r127 == null) goto L112;
        List<w> r128 = r127.j;
        if (r128 == null) goto L113;
        List<w> r129 = r128;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator<T> r130 = r129.iterator();
    L54:
        if (r130.hasNext() == false) goto L57;
        r7.add(((w) r130.next()).d);
        goto L54
    L57:
        return CollectionsKt.joinToString$default(r7, wa8.h.a(), null, null, 0, null, null, 62, null);
    L113:
        return null;
    L112:
        return null;
    L111:
        return null;
    L44:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r126 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L9:
        if (r0 == 9) goto L106;
        if (r0 == 10) goto L102;
        return null;
    L102:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L18
        ouc.v r133 = xt7.d.b;     // Catch: Throwable -> L18
        juc.c r134 = j.Companion.serializer();     // Catch: Throwable -> L18
        String r8 = this.c;     // Catch: Throwable -> L18
        if (r8 == null) goto L16;
        r3 = r8;
    L16:
        Object r135 = Result.constructor-impl((j) r133.c(r134, r3));     // Catch: Throwable -> L18
    L21:
        if (Result.exceptionOrNull-impl(r135) != null) goto L24;
        j r136 = (j) r135;
        return r136.b(r136.i);
    L24:
        return null;
    L18:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r135 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L106:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L31
        ouc.v r10 = xt7.d.b;     // Catch: Throwable -> L31
        juc.c r11 = com.larus.bmhome.actionbar.model.b.Companion.serializer();     // Catch: Throwable -> L31
        String r12 = this.c;     // Catch: Throwable -> L31
        if (r12 == null) goto L29;
        r3 = r12;
    L29:
        Object r20 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b) r10.c(r11, r3));     // Catch: Throwable -> L31
    L34:
        if (Result.exceptionOrNull-impl(r20) == null) goto L36;
        return null;
    L36:
        return ((com.larus.bmhome.actionbar.model.b) r20).c(r13, r14);
    L31:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }

    public c0(Integer r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public c0(int r4, Integer r5, int r6, String r7) {
        if ((r4 & 0) == 0) goto L5;
        nuc.b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = 0;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = null;
        return;
    L15:
        this.c = r7;
        return;
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
