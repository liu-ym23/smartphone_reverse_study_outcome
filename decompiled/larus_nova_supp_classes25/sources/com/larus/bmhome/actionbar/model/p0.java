package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class p0 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] p = null;
    public final Integer a;
    public final Integer b;
    public Integer c;
    public final a2 d;
    public final Integer e;
    public final Boolean f;
    public final o0 g;
    public final String h;
    public final Map<String, o1> i;
    public final s0 j;
    public final Boolean k;
    public final Map<String, q0> l;
    public final r0 m;
    public final Boolean n;
    public final w1 o;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<p0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActiveSwitchConf", r0, 15);
            r1.j("switch_type", true);
            r1.j("switch_memory_strategy", true);
            r1.j("default_status", true);
            r1.j("menu_conf", true);
            r1.j("auto_cot_close_status", true);
            r1.j("show_menu_guide", true);
            r1.j("action_control", true);
            r1.j("default_select_model_item_key", true);
            r1.j("default_select_model_map", true);
            r1.j("menu_conf_v2", true);
            r1.j("use_menu_conf_v2", true);
            r1.j("switch_memory", true);
            r1.j("switch_memory_v2", true);
            r1.j("new_active_switch_container", true);
            r1.j("reasoning_effort_section_conf", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = p0.p;
            nuc.w0 r2 = nuc.w0.a;
            nuc.i r3 = nuc.i.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(a2.a.a), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(o0.a.a), kuc.a.d(v2.a), kuc.a.d((juc.d) r0[8].getValue()), kuc.a.d(s0.a.a), kuc.a.d(r3), kuc.a.d((juc.d) r0[11].getValue()), kuc.a.d(r0.a.a), kuc.a.d(r3), kuc.a.d(w1.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r33) {
            Intrinsics.checkNotNullParameter(r33, "decoder");
            g2 r1 = b;
            muc.c r0 = r33.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = p0.p;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r3 = nuc.w0.a;
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            Integer r7 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r3, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r3, null);
            a2 r8 = (a2) r0.decodeNullableSerializableElement(r1, 3, a2.a.a, null);
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 4, r3, null);
            nuc.i r9 = nuc.i.a;
            Boolean r10 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, r9, null);
            o0 r11 = (o0) r0.decodeNullableSerializableElement(r1, 6, o0.a.a, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, null);
            Map r13 = (Map) r0.decodeNullableSerializableElement(r1, 8, (juc.c) r2[8].getValue(), null);
            s0 r14 = (s0) r0.decodeNullableSerializableElement(r1, 9, s0.a.a, null);
            Boolean r15 = (Boolean) r0.decodeNullableSerializableElement(r1, 10, r9, null);
            Map r16 = (Map) r0.decodeNullableSerializableElement(r1, 11, (juc.c) r2[11].getValue(), null);
            r0 r17 = (r0) r0.decodeNullableSerializableElement(r1, 12, r0.a.a, null);
            r0 r22 = r17;
            Boolean r23 = (Boolean) r0.decodeNullableSerializableElement(r1, 13, r9, null);
            w1 r24 = (w1) r0.decodeNullableSerializableElement(r1, 14, w1.a.a, null);
            String r18 = r12;
            Boolean r20 = r15;
            Map r21 = r16;
            int r19 = 32767;
            Integer r110 = r4;
            Boolean r111 = r10;
            s0 r112 = r14;
            Integer r113 = r6;
            Integer r114 = r5;
            Map r115 = r13;
            a2 r116 = r8;
            o0 r117 = r11;
            Integer r118 = r7;
        L41:
            r0.endStructure(r1);
            return new p0(r19, r113, r118, r110, r116, r114, r111, r117, r18, r115, r112, r20, r21, r22, r23, r24);
        L5:
            Integer r25 = null;
            a2 r26 = null;
            Boolean r27 = null;
            Integer r28 = null;
            r0 r29 = null;
            o0 r119 = null;
            Map r120 = null;
            Boolean r121 = null;
            w1 r122 = null;
            Boolean r123 = null;
            s0 r124 = null;
            Integer r210 = null;
            Integer r211 = null;
            Map r212 = null;
            String r213 = null;
            int r30 = 0;
            boolean r214 = true;
        L6:
            if (r214 == false) goto L40;
            int r31 = r0.decodeElementIndex(r1);
            switch(r31) {
                case -1: goto L39;
                case 0: goto L37;
                case 1: goto L35;
                case 2: goto L32;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L26;
                case 6: goto L24;
                case 7: goto L22;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L15;
                case 12: goto L13;
                case 13: goto L12;
                case 14: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r31);
        L39:
            r29 = r29;
            r25 = r25;
            r2 = r2;
            r211 = r211;
            r214 = false;
            goto L6
        L11:
            r122 = (w1) r0.decodeNullableSerializableElement(r1, 14, w1.a.a, r122);
            r30 = r30 | 16384;
        L16:
            r2 = r2;
            Map r32 = r212;
            String r34 = r213;
        L34:
            String r125 = r34;
            Integer r35 = r25;
            Map r36 = r32;
        L36:
            Integer r215 = r35;
        L38:
            r212 = r36;
            r213 = r125;
            r25 = r215;
            r2 = r2;
            goto L6
        L12:
            r25 = r25;
            r121 = (Boolean) r0.decodeNullableSerializableElement(r1, 13, nuc.i.a, r121);
            r30 = r30 | 8192;
            r29 = r29;
        L21:
            r212 = r212;
        L23:
            String r37 = r213;
        L27:
            String r38 = r37;
        L33:
            r34 = r38;
            r32 = r212;
            r29 = r29;
            goto L34
        L13:
            r29 = (r0) r0.decodeNullableSerializableElement(r1, 12, r0.a.a, r29);
            r30 = r30 | 4096;
            goto L16
        L15:
            r25 = r25;
            r120 = (Map) r0.decodeNullableSerializableElement(r1, 11, (juc.c) r2[11].getValue(), r120);
            r30 = r30 | 2048;
            goto L16
        L17:
            r123 = (Boolean) r0.decodeNullableSerializableElement(r1, 10, nuc.i.a, r123);
            r30 = r30 | 1024;
            goto L21
        L18:
            r124 = (s0) r0.decodeNullableSerializableElement(r1, 9, s0.a.a, r124);
            r30 = r30 | 512;
            goto L21
        L19:
            r212 = (Map) r0.decodeNullableSerializableElement(r1, 8, (juc.c) r2[8].getValue(), r212);
            r30 = r30 | 256;
            goto L21
        L22:
            r25 = r25;
            r29 = r29;
            r212 = r212;
            r2 = r2;
            r213 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r213);
            r30 = r30 | 128;
            goto L23
        L24:
            r2 = r2;
            r25 = r25;
            r29 = r29;
            r212 = r212;
            r37 = r213;
            r119 = (o0) r0.decodeNullableSerializableElement(r1, 6, o0.a.a, r119);
            r30 = r30 | 64;
            goto L27
        L26:
            r2 = r2;
            r25 = r25;
            r29 = r29;
            r212 = r212;
            r37 = r213;
            r27 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, r27);
            r30 = r30 | 32;
            goto L27
        L28:
            Integer r39 = r211;
            String r216 = r213;
            Integer r40 = (Integer) r0.decodeNullableSerializableElement(r1, 4, nuc.w0.a, r39);
            r30 = r30 | 16;
        L30:
            String r310 = r216;
            r211 = r40;
            r38 = r310;
            goto L33
        L29:
            r40 = r211;
            r216 = r213;
            r26 = (a2) r0.decodeNullableSerializableElement(r1, 3, a2.a.a, r26);
            r30 = r30 | 8;
            goto L30
        L32:
            r2 = r2;
            r25 = r25;
            r29 = r29;
            r212 = r212;
            r28 = (Integer) r0.decodeNullableSerializableElement(r1, 2, nuc.w0.a, r28);
            r30 = r30 | 4;
            r211 = r211;
            r38 = r213;
            goto L33
        L35:
            r2 = r2;
            r35 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, r25);
            r30 = r30 | 2;
            r36 = r212;
            r29 = r29;
            r125 = r213;
            r211 = r211;
            goto L36
        L37:
            r2 = r2;
            r215 = r25;
            r30 = r30 | 1;
            r210 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r210);
            r36 = r212;
            r29 = r29;
            r125 = r213;
            r211 = r211;
            goto L38
        L40:
            Integer r41 = r210;
            Integer r311 = r211;
            r115 = r212;
            r117 = r119;
            r21 = r120;
            r23 = r121;
            r112 = r124;
            r22 = r29;
            r118 = r25;
            r18 = r213;
            r113 = r41;
            r111 = r27;
            r19 = r30;
            r110 = r28;
            r24 = r122;
            r20 = r123;
            r114 = r311;
            r116 = r26;
            goto L41
        }

        public final void serialize(muc.f r8, Object r9) {
            p0 r10 = (p0) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = p0.p;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r10.a);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r11.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r10.b);
        L21:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r11.encodeNullableSerializableElement(r0, 2, nuc.w0.a, r10.c);
        L30:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r11.encodeNullableSerializableElement(r0, 3, a2.a.a, r10.d);
        L39:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r11.encodeNullableSerializableElement(r0, 4, nuc.w0.a, r10.e);
        L48:
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r11.encodeNullableSerializableElement(r0, 5, nuc.i.a, r10.f);
        L57:
            if (r11.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r11.encodeNullableSerializableElement(r0, 6, o0.a.a, r10.g);
        L66:
            if (r11.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r11.encodeNullableSerializableElement(r0, 7, v2.a, r10.h);
        L75:
            if (r11.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r11.encodeNullableSerializableElement(r0, 8, (juc.n) r1[8].getValue(), r10.i);
        L84:
            if (r11.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r11.encodeNullableSerializableElement(r0, 9, s0.a.a, r10.j);
        L93:
            if (r11.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            boolean r17 = true;
        L99:
            if (r17 == false) goto L102;
            r11.encodeNullableSerializableElement(r0, 10, nuc.i.a, r10.k);
        L102:
            if (r11.shouldEncodeElementDefault(r0, 11) == false) goto L105;
        L106:
            boolean r18 = true;
        L108:
            if (r18 == false) goto L111;
            r11.encodeNullableSerializableElement(r0, 11, (juc.n) r1[11].getValue(), r10.l);
        L111:
            if (r11.shouldEncodeElementDefault(r0, 12) == false) goto L114;
        L115:
            boolean r19 = true;
        L117:
            if (r19 == false) goto L120;
            r11.encodeNullableSerializableElement(r0, 12, r0.a.a, r10.m);
        L120:
            if (r11.shouldEncodeElementDefault(r0, 13) == false) goto L123;
        L124:
            boolean r20 = true;
        L126:
            if (r20 == false) goto L129;
            r11.encodeNullableSerializableElement(r0, 13, nuc.i.a, r10.n);
        L129:
            if (r11.shouldEncodeElementDefault(r0, 14) == false) goto L132;
        L133:
            r2 = true;
        L134:
            if (r2 == false) goto L136;
            r11.encodeNullableSerializableElement(r0, 14, w1.a.a, r10.o);
        L136:
            r11.endStructure(r0);
            return;
        L132:
            if (r10.o == null) goto L134;
        L123:
            if (r10.n != null) goto L124;
            r20 = false;
            goto L126
        L114:
            if (r10.m != null) goto L115;
            r19 = false;
            goto L117
        L105:
            if (r10.l != null) goto L106;
            r18 = false;
            goto L108
        L96:
            if (r10.k != null) goto L97;
            r17 = false;
            goto L99
        L87:
            if (r10.j != null) goto L88;
            r16 = false;
            goto L90
        L78:
            if (r10.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r10.h != null) goto L70;
            r14 = false;
            goto L72
        L60:
            if (r10.g != null) goto L61;
            r13 = false;
            goto L63
        L51:
            if (r10.f != null) goto L52;
            r12 = false;
            goto L54
        L42:
            if (r10.e != null) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r10.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r10.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r10.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r10.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<p0> serializer() {
            return a.a;
        }
    }

    public p0() {
        this(null, null, null, null, null, null, null, null, 32767);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r6 = (p0) r5;
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
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        a2 r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        o0 r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Map<String, o1> r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        s0 r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Map<String, q0> r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        r0 r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        w1 r43 = this.o;
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
        return "ActiveSwitchConf(switchType=" + this.a + ", switchMemoryStrategy=" + this.b + ", defaultStatus=" + this.c + ", menuConf=" + this.d + ", autoCotCloseStatus=" + this.e + ", showMenuGuide=" + this.f + ", actionControl=" + this.g + ", defaultSelectModelItemKey=" + this.h + ", defaultSelectModelMap=" + this.i + ", menuConfV2=" + this.j + ", useMenuConfV2=" + this.k + ", switchMemory=" + this.l + ", switchMemoryV2=" + this.m + ", newActiveSwitchContainer=" + this.n + ", reasoningEffortSectionConf=" + this.o + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        p = new Lazy[]{null, null, null, null, null, null, null, null, LazyKt.lazy(r1, new wa8.r0()), null, null, LazyKt.lazy(r1, new wa8.s0()), null, null, null};
    }

    public final ReplyOption a() {
        String r1 = null;
        Integer r2 = null;
        r2 = null;
        if (Intrinsics.areEqual(this.k, Boolean.TRUE) == false) goto L27;
        s0 r0 = this.j;
        if (r0 == null) goto L18;
        a2 r3 = r0.b;
        if (r3 == null) goto L18;
        ArrayList<b2> r4 = r3.a;
        if (r4 == null) goto L18;
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((b2) r6).o, this.h) == false) goto L12;
    L17:
        b2 r7 = (b2) r6;
    L19:
        if (r7 == null) goto L21;
        String r8 = r7.s;
    L22:
        if (r7 == null) goto L26;
        u1 r9 = r7.t;
        if (r9 == null) goto L26;
        r2 = r9.b;
    L26:
        Integer r10 = r2;
        r1 = r8;
        Integer r11 = r10;
    L29:
        return new ReplyOption(new ModelItemIdentity(this.h, this.c), r1, r11);
    L21:
        r8 = null;
        goto L22
    L16:
        r6 = null;
    L18:
        r7 = null;
        goto L19
    L27:
        r11 = null;
        goto L29
    }

    public final ReplyOption b() {
        r0 r0 = this.m;
        if (r0 == null) goto L19;
        String r1 = r0.a;
        if (r1 != null) goto L7;
    L17:
        return null;
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L17;
        return c(r1);
    L9:
        r2 = false;
        goto L10
    L19:
        return a();
    }

    public final a2 d() {
        if (Intrinsics.areEqual(this.k, Boolean.TRUE) == false) goto L9;
        s0 r0 = this.j;
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.b;
    L9:
        return this.d;
    }

    public final ReplyOption c(String r7) {
        r0 r0 = this.m;
        if (r0 == null) goto L32;
        Map<String, o1> r1 = r0.c;
        if (r1 != null) goto L7;
        r1 = MapsKt.emptyMap();
    L7:
        o1 r2 = r1.get(r7);
        Integer r3 = null;
        if (r2 != null) goto L10;
        return null;
    L10:
        s0 r4 = this.j;
        if (r4 == null) goto L24;
        a2 r5 = r4.b;
        if (r5 == null) goto L24;
        ArrayList<b2> r6 = r5.a;
        if (r6 == null) goto L24;
        Iterator<T> r8 = r6.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((b2) r9).o, r2.b) == false) goto L18;
    L23:
        b2 r10 = (b2) r9;
    L25:
        if (r10 == null) goto L30;
        u1 r11 = r10.t;
        if (r11 == null) goto L30;
        r3 = r11.b;
    L30:
        return new ReplyOption(r2.a(), r7, r3);
    L22:
        r9 = null;
    L24:
        r10 = null;
        goto L25
    L32:
        return a();
    }

    public p0(Integer r3, a2 r4, String r5, s0 r6, Boolean r7, Map r8, Boolean r9, w1 r10, int r11) {
        if ((r11 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 8) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 128) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 512) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 1024) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 2048) == 0) goto L21;
        r8 = null;
    L21:
        if ((r11 & 8192) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & 16384) == 0) goto L26;
        r10 = null;
    L26:
        this.a = null;
        this.b = null;
        this.c = r3;
        this.d = r4;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = r5;
        this.i = null;
        this.j = r6;
        this.k = r7;
        this.l = r8;
        this.m = null;
        this.n = r9;
        this.o = r10;
    }

    public p0(int r6, Integer r7, Integer r8, Integer r9, a2 r10, Integer r11, Boolean r12, o0 r13, String r14, Map r15, s0 r16, Boolean r17, Map r18, r0 r19, Boolean r20, w1 r21) {
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
