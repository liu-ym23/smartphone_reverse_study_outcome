package com.larus.bmhome.actionbar.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] r = null;
    public Integer a;
    public String b;
    public String c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Boolean g;
    public final Integer h;
    public Integer i;
    public final Boolean j;
    public final Boolean k;
    public c2 l;
    public final Integer m;
    public List<c2> n;
    public z1 o;
    public final String p;
    public final String q;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<j> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarDurationSeekBarSelector", r0, 17);
            r1.j("id", true);
            r1.j("label", true);
            r1.j("key", true);
            r1.j("lower_bound", true);
            r1.j("upper_bound", true);
            r1.j("step_length", true);
            r1.j("should_show_dots", true);
            r1.j("default_selected_duration", true);
            r1.j("selected_duration", true);
            r1.j("can_be_empty", true);
            r1.j("need_save", true);
            r1.j("tag", true);
            r1.j("tag_starting_duration", true);
            r1.j("tags", true);
            r1.j("subscribe_config", true);
            r1.j("display_starling", true);
            r1.j("message_starling", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = j.r;
            nuc.w0 r2 = nuc.w0.a;
            v2 r3 = v2.a;
            nuc.i r4 = nuc.i.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r4), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r1.a), kuc.a.d(r2), kuc.a.d((juc.d) r0[13].getValue()), kuc.a.d(z1.a.a), kuc.a.d(r3), kuc.a.d(r3)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r36) {
            Intrinsics.checkNotNullParameter(r36, "decoder");
            g2 r1 = b;
            muc.c r0 = r36.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = j.r;
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r3 = nuc.w0.a;
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            v2 r9 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 1, r9, null);
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 2, r9, null);
            Integer r12 = (Integer) r0.decodeNullableSerializableElement(r1, 3, r3, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 4, r3, null);
            Integer r13 = (Integer) r0.decodeNullableSerializableElement(r1, 5, r3, null);
            nuc.i r10 = nuc.i.a;
            Boolean r14 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, r10, null);
            Integer r15 = (Integer) r0.decodeNullableSerializableElement(r1, 7, r3, null);
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 8, r3, null);
            Boolean r16 = (Boolean) r0.decodeNullableSerializableElement(r1, 9, r10, null);
            Boolean r17 = (Boolean) r0.decodeNullableSerializableElement(r1, 10, r10, null);
            c2 r18 = (c2) r0.decodeNullableSerializableElement(r1, 11, r1.a, null);
            Integer r19 = (Integer) r0.decodeNullableSerializableElement(r1, 12, r3, null);
            List r20 = (List) r0.decodeNullableSerializableElement(r1, 13, (juc.c) r2[13].getValue(), null);
            z1 r21 = (z1) r0.decodeNullableSerializableElement(r1, 14, z1.a.a, null);
            String r110 = (String) r0.decodeNullableSerializableElement(r1, 15, r9, null);
            int r22 = 131071;
            c2 r23 = r18;
            Integer r111 = r5;
            String r25 = (String) r0.decodeNullableSerializableElement(r1, 16, r9, null);
            String r24 = r110;
            Integer r26 = r6;
            Boolean r112 = r17;
            Integer r27 = r19;
            String r113 = r7;
            Integer r114 = r15;
            Boolean r115 = r14;
            Integer r116 = r13;
            Integer r117 = r4;
            z1 r28 = r21;
            List r29 = r20;
            Boolean r118 = r16;
        L43:
            r0.endStructure(r1);
            return new j(r22, r26, r113, r11, r12, r117, r116, r115, r114, r111, r118, r112, r23, r27, r29, r28, r24, r25);
        L5:
            Boolean r30 = null;
            String r31 = null;
            Boolean r32 = null;
            Integer r33 = null;
            Integer r34 = null;
            Integer r119 = null;
            Integer r120 = null;
            c2 r121 = null;
            Integer r122 = null;
            z1 r123 = null;
            Boolean r124 = null;
            String r210 = null;
            Integer r211 = null;
            List r212 = null;
            String r213 = null;
            Integer r35 = null;
            int r37 = 0;
            boolean r38 = true;
        L6:
            if (r38 == false) goto L42;
            int r39 = r0.decodeElementIndex(r1);
            switch(r39) {
                case -1: goto L41;
                case 0: goto L38;
                case 1: goto L37;
                case 2: goto L35;
                case 3: goto L33;
                case 4: goto L30;
                case 5: goto L28;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L22;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L14;
                case 15: goto L12;
                case 16: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r39);
        L41:
            Integer r214 = r211;
            Boolean r215 = r32;
            r2 = r2;
            r38 = false;
            r210 = r210;
            r37 = r37;
            r30 = r30;
            r119 = r119;
            r32 = r215;
            r211 = r214;
            goto L6
        L11:
            r8 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, r8);
            int r40 = 65536;
        L13:
            int r41 = r40 | r37;
            String r310 = r31;
        L15:
            r2 = r2;
            int r42 = r41;
            Integer r125 = r211;
            String r43 = r310;
            Boolean r216 = r32;
        L24:
            r31 = r43;
            r32 = r216;
            int r44 = r42;
            r211 = r125;
            r119 = r119;
        L34:
            Boolean r217 = r30;
            int r45 = r44;
            r31 = r31;
        L36:
            r37 = r45;
            r30 = r217;
            String r46 = r213;
        L40:
            r213 = r46;
            r2 = r2;
            goto L6
        L12:
            r31 = (String) r0.decodeNullableSerializableElement(r1, 15, v2.a, r31);
            r40 = 32768;
            goto L13
        L14:
            r119 = r119;
            int r126 = r37;
            r310 = r31;
            r123 = (z1) r0.decodeNullableSerializableElement(r1, 14, z1.a.a, r123);
            r41 = r126 | 16384;
            goto L15
        L16:
            r212 = (List) r0.decodeNullableSerializableElement(r1, 13, (juc.c) r2[13].getValue(), r212);
            int r47 = r37 | 8192;
        L21:
            Integer r48 = r211;
            r216 = r32;
        L23:
            r125 = r48;
            r42 = r47;
            r43 = r31;
            goto L24
        L17:
            r122 = (Integer) r0.decodeNullableSerializableElement(r1, 12, nuc.w0.a, r122);
            r47 = r37 | 4096;
            goto L21
        L18:
            r121 = (c2) r0.decodeNullableSerializableElement(r1, 11, r1.a, r121);
            r47 = r37 | 2048;
            goto L21
        L19:
            r32 = (Boolean) r0.decodeNullableSerializableElement(r1, 10, nuc.i.a, r32);
            r47 = r37 | 1024;
            goto L21
        L20:
            r124 = (Boolean) r0.decodeNullableSerializableElement(r1, 9, nuc.i.a, r124);
            r47 = r37 | 512;
            goto L21
        L22:
            r2 = r2;
            r119 = r119;
            int r127 = r37;
            r31 = r31;
            Integer r49 = r211;
            r216 = r32;
            r48 = (Integer) r0.decodeNullableSerializableElement(r1, 8, nuc.w0.a, r49);
            r47 = r127 | 256;
            goto L23
        L25:
            r34 = (Integer) r0.decodeNullableSerializableElement(r1, 7, nuc.w0.a, r34);
            r44 = r37 | 128;
        L31:
            r32 = r32;
            r119 = r119;
            r211 = r211;
            goto L34
        L26:
            r30 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, nuc.i.a, r30);
            r44 = r37 | 64;
            goto L31
        L28:
            r2 = r2;
            r119 = r119;
            r211 = r211;
            int r128 = r37;
            r31 = r31;
            r32 = r32;
            r33 = (Integer) r0.decodeNullableSerializableElement(r1, 5, nuc.w0.a, r33);
            r44 = r128 | 32;
            goto L31
        L30:
            r2 = r2;
            r119 = r119;
            r211 = r211;
            int r129 = r37;
            r31 = r31;
            r32 = r32;
            r120 = (Integer) r0.decodeNullableSerializableElement(r1, 4, nuc.w0.a, r120);
            r44 = r129 | 16;
            goto L31
        L33:
            r2 = r2;
            Integer r311 = r119;
            Integer r50 = r211;
            int r130 = r37;
            r31 = r31;
            Boolean r218 = r32;
            int r51 = r130 | 8;
            r119 = (Integer) r0.decodeNullableSerializableElement(r1, 3, nuc.w0.a, r311);
            r44 = r51;
            r32 = r218;
            r211 = r50;
            goto L34
        L35:
            r2 = r2;
            Integer r219 = r211;
            Boolean r220 = r32;
            Integer r52 = r119;
            int r131 = r37;
            r217 = r30;
            r213 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r213);
            r45 = r131 | 4;
            r119 = r52;
            r32 = r220;
            r31 = r31;
            r211 = r219;
            goto L36
        L37:
            Boolean r221 = r32;
            String r53 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r210);
            int r54 = r37 | 2;
            r119 = r119;
            r46 = r213;
            r32 = r221;
        L39:
            r210 = r53;
            r30 = r30;
            r211 = r211;
            r37 = r54;
            r31 = r31;
            goto L40
        L38:
            r53 = r210;
            Boolean r222 = r32;
            r54 = r37 | 1;
            r35 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r35);
            r119 = r119;
            r46 = r213;
            r32 = r222;
            goto L39
        L42:
            Boolean r223 = r30;
            Integer r224 = r211;
            Boolean r225 = r32;
            Integer r55 = r119;
            r114 = r34;
            r23 = r121;
            r27 = r122;
            r28 = r123;
            r118 = r124;
            r115 = r223;
            r111 = r224;
            r112 = r225;
            r29 = r212;
            r24 = r31;
            r26 = r35;
            r12 = r55;
            r116 = r33;
            r25 = r8;
            r22 = r37;
            r117 = r120;
            r11 = r213;
            r113 = r210;
            goto L43
        }

        public final void serialize(muc.f r8, Object r9) {
            j r10 = (j) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = j.r;
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
            r11.encodeNullableSerializableElement(r0, 1, v2.a, r10.b);
        L21:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r11.encodeNullableSerializableElement(r0, 2, v2.a, r10.c);
        L30:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r11.encodeNullableSerializableElement(r0, 3, nuc.w0.a, r10.d);
        L39:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r11.encodeNullableSerializableElement(r0, 4, nuc.w0.a, r10.e);
        L48:
            if (r11.shouldEncodeElementDefault(r0, 5) == true) goto L55;
            Integer r12 = r10.f;
            if (r12 == null) goto L55;
            if (r12.intValue() != 1) goto L55;
            boolean r13 = false;
        L57:
            if (r13 == false) goto L60;
            r11.encodeNullableSerializableElement(r0, 5, nuc.w0.a, r10.f);
        L60:
            if (r11.shouldEncodeElementDefault(r0, 6) == false) goto L63;
        L64:
            boolean r14 = true;
        L66:
            if (r14 == false) goto L69;
            r11.encodeNullableSerializableElement(r0, 6, nuc.i.a, r10.g);
        L69:
            if (r11.shouldEncodeElementDefault(r0, 7) == false) goto L72;
        L73:
            boolean r15 = true;
        L75:
            if (r15 == false) goto L78;
            r11.encodeNullableSerializableElement(r0, 7, nuc.w0.a, r10.h);
        L78:
            if (r11.shouldEncodeElementDefault(r0, 8) == false) goto L81;
        L82:
            boolean r16 = true;
        L84:
            if (r16 == false) goto L87;
            r11.encodeNullableSerializableElement(r0, 8, nuc.w0.a, r10.i);
        L87:
            if (r11.shouldEncodeElementDefault(r0, 9) == false) goto L90;
        L91:
            boolean r17 = true;
        L93:
            if (r17 == false) goto L96;
            r11.encodeNullableSerializableElement(r0, 9, nuc.i.a, r10.j);
        L96:
            if (r11.shouldEncodeElementDefault(r0, 10) == false) goto L99;
        L100:
            boolean r18 = true;
        L102:
            if (r18 == false) goto L105;
            r11.encodeNullableSerializableElement(r0, 10, nuc.i.a, r10.k);
        L105:
            if (r11.shouldEncodeElementDefault(r0, 11) == false) goto L108;
        L109:
            boolean r19 = true;
        L111:
            if (r19 == false) goto L114;
            r11.encodeNullableSerializableElement(r0, 11, r1.a, r10.l);
        L114:
            if (r11.shouldEncodeElementDefault(r0, 12) == false) goto L117;
        L118:
            boolean r20 = true;
        L120:
            if (r20 == false) goto L123;
            r11.encodeNullableSerializableElement(r0, 12, nuc.w0.a, r10.m);
        L123:
            if (r11.shouldEncodeElementDefault(r0, 13) == false) goto L126;
        L127:
            boolean r21 = true;
        L129:
            if (r21 == false) goto L132;
            r11.encodeNullableSerializableElement(r0, 13, (juc.n) r1[13].getValue(), r10.n);
        L132:
            if (r11.shouldEncodeElementDefault(r0, 14) == false) goto L135;
        L136:
            boolean r22 = true;
        L138:
            if (r22 == false) goto L141;
            r11.encodeNullableSerializableElement(r0, 14, z1.a.a, r10.o);
        L141:
            if (r11.shouldEncodeElementDefault(r0, 15) == false) goto L144;
        L145:
            boolean r23 = true;
        L147:
            if (r23 == false) goto L150;
            r11.encodeNullableSerializableElement(r0, 15, v2.a, r10.p);
        L150:
            if (r11.shouldEncodeElementDefault(r0, 16) == false) goto L153;
        L154:
            r2 = true;
        L155:
            if (r2 == false) goto L157;
            r11.encodeNullableSerializableElement(r0, 16, v2.a, r10.q);
        L157:
            r11.endStructure(r0);
            return;
        L153:
            if (r10.q == null) goto L155;
        L144:
            if (r10.p != null) goto L145;
            r23 = false;
            goto L147
        L135:
            if (r10.o != null) goto L136;
            r22 = false;
            goto L138
        L126:
            if (r10.n != null) goto L127;
            r21 = false;
            goto L129
        L117:
            if (r10.m != null) goto L118;
            r20 = false;
            goto L120
        L108:
            if (r10.l != null) goto L109;
            r19 = false;
            goto L111
        L99:
            if (Intrinsics.areEqual(r10.k, Boolean.FALSE) == false) goto L100;
            r18 = false;
            goto L102
        L90:
            if (Intrinsics.areEqual(r10.j, Boolean.FALSE) == false) goto L91;
            r17 = false;
            goto L93
        L81:
            if (r10.i != null) goto L82;
            r16 = false;
            goto L84
        L72:
            if (r10.h != null) goto L73;
            r15 = false;
            goto L75
        L63:
            if (r10.g != null) goto L64;
            r14 = false;
        L55:
            r13 = true;
            goto L57
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
            if (Intrinsics.areEqual(r10.b, "") == false) goto L16;
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

        public final juc.d<j> serializer() {
            return a.a;
        }
    }

    public j() {
        Boolean r11 = Boolean.FALSE;
        this(null, "", null, null, null, 1, null, null, null, r11, r11, null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        c2 r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<c2> r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        z1 r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.q;
        if (r49 == null) goto L71;
        r1 = r49.hashCode();
    L71:
        return r48 + r1;
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
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
        return "ActionBarDurationSeekBarSelector(id=" + this.a + ", label=" + this.b + ", key=" + this.c + ", lowerBound=" + this.d + ", upperBound=" + this.e + ", stepLength=" + this.f + ", shouldShowDots=" + this.g + ", defaultSelectedDuration=" + this.h + ", selectedDuration=" + this.i + ", canBeEmpty=" + this.j + ", needSave=" + this.k + ", tag=" + this.l + ", tagStartingDuration=" + this.m + ", tags=" + this.n + ", subscribeConfig=" + this.o + ", displayStarling=" + this.p + ", messageStarling=" + this.q + ')';
    }

    static {
        Companion = new b();
        r = new Lazy[]{null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.m()), null, null, null};
    }

    public final String a(Integer r10) {
        if (r10 == null) goto L13;
        r10.intValue();
        String r1 = this.p;
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r1)) == false) goto L9;
        String r3 = r1;
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        return StringsKt.replace$default(r3, "{s_duration}", String.valueOf(r10.intValue()), false, 4, null);
    L9:
        r3 = null;
        goto L10
    L13:
        return null;
    }

    public final String b(Integer r10) {
        if (r10 == null) goto L16;
        r10.intValue();
        if (Intrinsics.areEqual(r10, this.h) == false) goto L7;
        return null;
    L7:
        String r1 = this.q;
        if (r1 != null) goto L10;
        return null;
    L10:
        if ((!StringsKt.isBlank(r1)) == false) goto L12;
        String r3 = r1;
    L13:
        if (r3 != null) goto L15;
        return null;
    L15:
        return StringsKt.replace$default(r3, "{s_duration}", String.valueOf(r10.intValue()), false, 4, null);
    L12:
        r3 = null;
        goto L13
    L16:
        return null;
    }

    public j(Integer r3, String r4, String r5, Integer r6, Integer r7, Integer r8, Boolean r9, Integer r10, Integer r11, Boolean r12, Boolean r13, c2 r14, Integer r15, List<c2> r16, z1 r17, String r18, String r19) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
    }

    public j(int r6, Integer r7, String r8, String r9, Integer r10, Integer r11, Integer r12, Boolean r13, Integer r14, Integer r15, Boolean r16, Boolean r17, c2 r18, Integer r19, List r20, z1 r21, String r22, String r23) {
        if ((r6 & 0) == 0) goto L5;
        nuc.b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r6 & 2) != 0) goto L11;
        String r2 = "";
    L12:
        this.b = r2;
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
        Integer r3 = 1;
    L28:
        this.f = r3;
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
        Boolean r4 = Boolean.FALSE;
    L44:
        this.j = r4;
        if ((r6 & 1024) != 0) goto L47;
        Boolean r5 = Boolean.FALSE;
    L48:
        this.k = r5;
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
    L65:
        if ((32768 & r6) != 0) goto L67;
        this.p = null;
    L69:
        if ((r6 & 65536) != 0) goto L71;
        this.q = null;
        return;
    L71:
        this.q = r23;
        return;
    L67:
        this.p = r22;
        goto L69
    L63:
        this.o = r21;
        goto L65
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
        r5 = r17;
        goto L48
    L43:
        r4 = r16;
        goto L44
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
        r3 = r12;
        goto L28
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
        r2 = r8;
        goto L12
    L7:
        this.a = r7;
        goto L9
    }
}
