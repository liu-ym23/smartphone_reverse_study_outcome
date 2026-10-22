package com.larus.bmhome.actionbar.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class z {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] p = null;
    public final String a;
    public final List<String> b;
    public final Integer c;
    public final String d;
    public final Double e;
    public final Integer f;
    public final String g;
    public final Long h;
    public final Long i;
    public final String j;
    public final Double k;
    public final Double l;
    public final Double m;
    public final Double n;
    public final Long o;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<z> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarModelInputRule", r0, 15);
            r1.j("type", true);
            r1.j("sub_type", true);
            r1.j("max_count", true);
            r1.j("max_count_display_text", true);
            r1.j("max_total_duration", true);
            r1.j("max_total_show_duration", true);
            r1.j("max_total_duration_display_text", true);
            r1.j("max_resolution", true);
            r1.j("min_resolution", true);
            r1.j("max_resolution_display_text", true);
            r1.j("min_ratio", true);
            r1.j("max_ratio", true);
            r1.j("min_single_duration", true);
            r1.j("max_single_duration", true);
            r1.j("max_file_size", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = z.p;
            v2 r2 = v2.a;
            nuc.w0 r1 = nuc.w0.a;
            nuc.b0 r3 = nuc.b0.a;
            nuc.g1 r4 = nuc.g1.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d((juc.d) r0[1].getValue()), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r4)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r35) {
            Intrinsics.checkNotNullParameter(r35, "decoder");
            g2 r1 = b;
            muc.c r0 = r35.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = z.p;
            Double r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r3 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            List r4 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), null);
            nuc.w0 r6 = nuc.w0.a;
            Integer r14 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r6, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 3, r3, null);
            nuc.b0 r8 = nuc.b0.a;
            Double r15 = (Double) r0.decodeNullableSerializableElement(r1, 4, r8, null);
            Integer r10 = (Integer) r0.decodeNullableSerializableElement(r1, 5, r6, null);
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 6, r3, null);
            nuc.g1 r12 = nuc.g1.a;
            Long r13 = (Long) r0.decodeNullableSerializableElement(r1, 7, r12, null);
            Long r16 = (Long) r0.decodeNullableSerializableElement(r1, 8, r12, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 9, r3, null);
            Double r18 = (Double) r0.decodeNullableSerializableElement(r1, 10, r8, null);
            Double r19 = (Double) r0.decodeNullableSerializableElement(r1, 11, r8, null);
            Double r20 = (Double) r0.decodeNullableSerializableElement(r1, 12, r8, null);
            Double r29 = (Double) r0.decodeNullableSerializableElement(r1, 13, r8, null);
            String r25 = r17;
            Long r24 = r16;
            String r110 = r5;
            Integer r21 = r10;
            Long r30 = (Long) r0.decodeNullableSerializableElement(r1, 14, r12, null);
            String r22 = r11;
            Long r23 = r13;
            Double r26 = r18;
            Double r27 = r15;
            Double r28 = r20;
            Double r210 = r19;
            List r111 = r4;
            int r112 = 32767;
            String r113 = r9;
            Integer r114 = r14;
        L38:
            r0.endStructure(r1);
            return new z(r112, r110, r111, r114, r113, r27, r21, r22, r23, r24, r25, r26, r210, r28, r29, r30);
        L5:
            int r31 = 14;
            Long r32 = null;
            List r33 = null;
            String r34 = null;
            Double r36 = null;
            Double r115 = null;
            Double r116 = null;
            String r117 = null;
            String r118 = null;
            Double r119 = null;
            String r211 = null;
            Integer r212 = null;
            Integer r213 = null;
            Long r37 = null;
            Long r38 = null;
            int r39 = 0;
            boolean r310 = true;
        L6:
            if (r310 == false) goto L37;
            int r120 = r0.decodeElementIndex(r1);
            switch(r120) {
                case -1: goto L35;
                case 0: goto L33;
                case 1: goto L31;
                case 2: goto L29;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L19;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                case 13: goto L12;
                case 14: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r120);
        L12:
            r7 = (Double) r0.decodeNullableSerializableElement(r1, 13, nuc.b0.a, r7);
            r39 = r39 | 8192;
            Long r40 = r37;
        L20:
            r38 = r38;
        L25:
            Long r121 = r40;
            Integer r41 = r213;
        L23:
            String r214 = r34;
        L30:
            r34 = r214;
            r212 = r212;
            Long r42 = r121;
        L32:
            r213 = r41;
            r38 = r38;
            r31 = 14;
            Long r311 = r32;
            r37 = r42;
            r32 = r311;
            goto L6
        L13:
            r115 = (Double) r0.decodeNullableSerializableElement(r1, 12, nuc.b0.a, r115);
            r39 = r39 | 4096;
            r31 = 14;
            goto L6
        L14:
            r119 = (Double) r0.decodeNullableSerializableElement(r1, 11, nuc.b0.a, r119);
            r39 = r39 | 2048;
        L17:
            r41 = r213;
            r121 = r37;
            r38 = r38;
            r32 = r32;
            goto L23
        L15:
            r116 = (Double) r0.decodeNullableSerializableElement(r1, 10, nuc.b0.a, r116);
            r39 = r39 | 1024;
            goto L17
        L16:
            r117 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r117);
            r39 = r39 | 512;
            goto L17
        L19:
            r40 = (Long) r0.decodeNullableSerializableElement(r1, 8, nuc.g1.a, r37);
            r39 = r39 | 256;
            goto L20
        L21:
            Long r43 = r37;
            r32 = r32;
            r39 = r39 | 128;
            r121 = r43;
            r7 = r7;
            r41 = r213;
            r38 = (Long) r0.decodeNullableSerializableElement(r1, 7, nuc.g1.a, r38);
            goto L23
        L22:
            Long r44 = r37;
            r32 = r32;
            r118 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r118);
            r39 = r39 | 64;
            r38 = r38;
            r121 = r44;
            r7 = r7;
            r41 = r213;
            goto L23
        L24:
            r40 = r37;
            r32 = r32;
            r38 = r38;
            r213 = (Integer) r0.decodeNullableSerializableElement(r1, 5, nuc.w0.a, r213);
            r39 = r39 | 32;
            r7 = r7;
            goto L25
        L26:
            r36 = (Double) r0.decodeNullableSerializableElement(r1, 4, nuc.b0.a, r36);
            r39 = r39 | 16;
            r121 = r37;
        L28:
            r41 = r213;
            r7 = r7;
            goto L23
        L27:
            r34 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r34);
            r39 = r39 | 8;
            r121 = r37;
            goto L28
        L29:
            Long r45 = r37;
            r38 = r38;
            r32 = r32;
            Integer r46 = r212;
            r214 = r34;
            r212 = (Integer) r0.decodeNullableSerializableElement(r1, 2, nuc.w0.a, r46);
            r39 = r39 | 4;
            r121 = r45;
            r41 = r213;
            r7 = r7;
            goto L30
        L31:
            Long r47 = r37;
            r38 = r38;
            r32 = r32;
            Integer r48 = r212;
            r33 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), r33);
            r39 = r39 | 2;
            r34 = r34;
            r212 = r48;
            r42 = r47;
            r41 = r213;
            r7 = r7;
            goto L32
        L11:
            r39 = r39 | 16384;
            Long r312 = (Long) r0.decodeNullableSerializableElement(r1, r31, nuc.g1.a, r32);
        L36:
            r2 = r2;
            r213 = r213;
            r211 = r211;
            r34 = r34;
            r38 = r38;
        L34:
            r7 = r7;
            r212 = r212;
            r32 = r312;
            r37 = r37;
            r31 = 14;
            goto L6
        L33:
            r7 = r7;
            r37 = r37;
            r312 = r32;
            r212 = r212;
            r211 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r211);
            r39 = r39 | 1;
            r2 = r2;
            r34 = r34;
            goto L34
        L35:
            r312 = r32;
            r310 = false;
            goto L36
        L37:
            String r122 = r211;
            Long r49 = r37;
            r30 = r32;
            r114 = r212;
            r111 = r33;
            r21 = r213;
            r24 = r49;
            r27 = r36;
            r25 = r117;
            r110 = r122;
            r210 = r119;
            r113 = r34;
            r23 = r38;
            r29 = r7;
            r112 = r39;
            r28 = r115;
            r26 = r116;
            r22 = r118;
            goto L38
        }

        public final void serialize(muc.f r7, Object r8) {
            z r9 = (z) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = z.p;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, nuc.w0.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, nuc.b0.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, nuc.w0.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeNullableSerializableElement(r0, 7, nuc.g1.a, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeNullableSerializableElement(r0, 8, nuc.g1.a, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r10.encodeNullableSerializableElement(r0, 9, v2.a, r9.j);
        L93:
            if (r10.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            boolean r17 = true;
        L99:
            if (r17 == false) goto L102;
            r10.encodeNullableSerializableElement(r0, 10, nuc.b0.a, r9.k);
        L102:
            if (r10.shouldEncodeElementDefault(r0, 11) == false) goto L105;
        L106:
            boolean r18 = true;
        L108:
            if (r18 == false) goto L111;
            r10.encodeNullableSerializableElement(r0, 11, nuc.b0.a, r9.l);
        L111:
            if (r10.shouldEncodeElementDefault(r0, 12) == false) goto L114;
        L115:
            boolean r19 = true;
        L117:
            if (r19 == false) goto L120;
            r10.encodeNullableSerializableElement(r0, 12, nuc.b0.a, r9.m);
        L120:
            if (r10.shouldEncodeElementDefault(r0, 13) == false) goto L123;
        L124:
            boolean r20 = true;
        L126:
            if (r20 == false) goto L129;
            r10.encodeNullableSerializableElement(r0, 13, nuc.b0.a, r9.n);
        L129:
            if (r10.shouldEncodeElementDefault(r0, 14) == false) goto L132;
        L133:
            r2 = true;
        L134:
            if (r2 == false) goto L136;
            r10.encodeNullableSerializableElement(r0, 14, nuc.g1.a, r9.o);
        L136:
            r10.endStructure(r0);
            return;
        L132:
            if (r9.o == null) goto L134;
        L123:
            if (r9.n != null) goto L124;
            r20 = false;
            goto L126
        L114:
            if (r9.m != null) goto L115;
            r19 = false;
            goto L117
        L105:
            if (r9.l != null) goto L106;
            r18 = false;
            goto L108
        L96:
            if (r9.k != null) goto L97;
            r17 = false;
            goto L99
        L87:
            if (r9.j != null) goto L88;
            r16 = false;
            goto L90
        L78:
            if (r9.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r9.h != null) goto L70;
            r14 = false;
            goto L72
        L60:
            if (r9.g != null) goto L61;
            r13 = false;
            goto L63
        L51:
            if (r9.f != null) goto L52;
            r12 = false;
            goto L54
        L42:
            if (r9.e != null) goto L43;
            r11 = false;
            goto L45
        L33:
            if (r9.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<z> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L8;
        return false;
    L8:
        z r6 = (z) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Double r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Double r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Double r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Double r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Double r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Long r43 = this.o;
        if (r43 == null) goto L63;
        r1 = r43.hashCode();
    L63:
        return r42 + r1;
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarModelInputRule(type=" + this.a + ", subTypes=" + this.b + ", maxCount=" + this.c + ", maxCountDisplayText=" + this.d + ", maxTotalDuration=" + this.e + ", maxTotalShowDuration=" + this.f + ", maxTotalDurationDisplayText=" + this.g + ", maxResolution=" + this.h + ", minResolution=" + this.i + ", maxResolutionDisplayText=" + this.j + ", minRatio=" + this.k + ", maxRatio=" + this.l + ", minSingleDuration=" + this.m + ", maxSingleDuration=" + this.n + ", maxFileSize=" + this.o + ')';
    }

    static {
        Companion = new b();
        p = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.e0()), null, null, null, null, null, null, null, null, null, null, null, null, null};
    }

    public z() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public final String getType() {
        return this.a;
    }

    public z(int r6, String r7, List r8, Integer r9, String r10, Double r11, Integer r12, String r13, Long r14, Long r15, String r16, Double r17, Double r18, Double r19, Double r20, Long r21) {
        if ((r6 & 0) == 0) goto L5;
        nuc.b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r6 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r6 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r6 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r6 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r6 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r6 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r6 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r6 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r6 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r6 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r6 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r6 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r6 & 8192) != 0) goto L59;
        this.n = null;
    L61:
        if ((r6 & 16384) != 0) goto L63;
        this.o = null;
        return;
    L63:
        this.o = r21;
        return;
    L59:
        this.n = r20;
        goto L61
    L55:
        this.m = r19;
        goto L57
    L51:
        this.l = r18;
        goto L53
    L47:
        this.k = r17;
        goto L49
    L43:
        this.j = r16;
        goto L45
    L39:
        this.i = r15;
        goto L41
    L35:
        this.h = r14;
        goto L37
    L31:
        this.g = r13;
        goto L33
    L27:
        this.f = r12;
        goto L29
    L23:
        this.e = r11;
        goto L25
    L19:
        this.d = r10;
        goto L21
    L15:
        this.c = r9;
        goto L17
    L11:
        this.b = r8;
        goto L13
    L7:
        this.a = r7;
        goto L9
    }
}
