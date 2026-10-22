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
public final class t0 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] s = null;
    public final String a;
    public final String b;
    public final g1 c;
    public final g1 d;
    public final g1 e;
    public final g1 f;
    public final String g;
    public final List<c2> h;
    public final Integer i;
    public final Integer j;
    public final String k;
    public final Boolean l;
    public final o1 m;
    public final List<o1> n;
    public final List<String> o;
    public final String p;
    public final Boolean q;
    public final a2 r;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<t0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActiveSwitchMenuMode", r0, 18);
            r1.j("mode_id", true);
            r1.j("name", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("active_icon", true);
            r1.j("active_dark_mode_icon", true);
            r1.j("sub_title_name", true);
            r1.j("tag_list", true);
            r1.j("show_task_tools", true);
            r1.j("agent_mode", true);
            r1.j("selected_name", true);
            r1.j("need_login", true);
            r1.j("default_model", true);
            r1.j("support_models", true);
            r1.j("conversation_mode_list", true);
            r1.j("default_conversation_mode", true);
            r1.j("show_reasoning_effort", true);
            r1.j("model_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = t0.s;
            v2 r2 = v2.a;
            g1.a r3 = g1.a.a;
            nuc.w0 r4 = nuc.w0.a;
            nuc.i r5 = nuc.i.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d((juc.d) r0[7].getValue()), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r2), kuc.a.d(r5), kuc.a.d(o1.a.a), kuc.a.d((juc.d) r0[13].getValue()), kuc.a.d((juc.d) r0[14].getValue()), kuc.a.d(r2), kuc.a.d(r5), kuc.a.d(a2.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r38) {
            Intrinsics.checkNotNullParameter(r38, "decoder");
            g2 r1 = b;
            muc.c r0 = r38.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = t0.s;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r3 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 1, r3, null);
            g1.a r10 = g1.a.a;
            g1 r11 = (g1) r0.decodeNullableSerializableElement(r1, 2, r10, null);
            g1 r13 = (g1) r0.decodeNullableSerializableElement(r1, 3, r10, null);
            g1 r5 = (g1) r0.decodeNullableSerializableElement(r1, 4, r10, null);
            g1 r12 = (g1) r0.decodeNullableSerializableElement(r1, 5, r10, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 6, r3, null);
            List r15 = (List) r0.decodeNullableSerializableElement(r1, 7, (juc.c) r2[7].getValue(), null);
            nuc.w0 r16 = nuc.w0.a;
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 8, r16, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 9, r16, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 10, r3, null);
            nuc.i r9 = nuc.i.a;
            Boolean r21 = (Boolean) r0.decodeNullableSerializableElement(r1, 11, r9, null);
            o1 r18 = (o1) r0.decodeNullableSerializableElement(r1, 12, o1.a.a, null);
            List r19 = (List) r0.decodeNullableSerializableElement(r1, 13, (juc.c) r2[13].getValue(), null);
            List r20 = (List) r0.decodeNullableSerializableElement(r1, 14, (juc.c) r2[14].getValue(), null);
            String r22 = (String) r0.decodeNullableSerializableElement(r1, 15, r3, null);
            String r25 = r22;
            Boolean r26 = (Boolean) r0.decodeNullableSerializableElement(r1, 16, r9, null);
            a2 r27 = (a2) r0.decodeNullableSerializableElement(r1, 17, a2.a.a, null);
            List r110 = r15;
            Integer r111 = r4;
            Integer r112 = r6;
            int r23 = 262143;
            List r24 = r20;
            g1 r113 = r11;
            o1 r28 = r18;
            String r114 = r8;
            String r29 = r17;
            g1 r115 = r12;
            String r116 = r7;
            String r117 = r14;
            g1 r118 = r5;
            List r210 = r19;
        L45:
            r0.endStructure(r1);
            return new t0(r23, r116, r114, r113, r13, r118, r115, r117, r110, r112, r111, r29, r21, r28, r210, r24, r25, r26, r27);
        L5:
            Integer r30 = null;
            a2 r31 = null;
            Boolean r32 = null;
            String r33 = null;
            g1 r34 = null;
            String r119 = null;
            List r120 = null;
            List r121 = null;
            String r122 = null;
            Integer r123 = null;
            o1 r124 = null;
            String r211 = null;
            g1 r212 = null;
            g1 r213 = null;
            g1 r35 = null;
            Boolean r36 = null;
            List r37 = null;
            String r39 = null;
            r23 = 0;
            boolean r310 = true;
        L6:
            if (r310 == false) goto L44;
            int r40 = r0.decodeElementIndex(r1);
            switch(r40) {
                case -1: goto L43;
                case 0: goto L40;
                case 1: goto L39;
                case 2: goto L36;
                case 3: goto L34;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r40);
        L43:
            r31 = r31;
            r30 = r30;
            r2 = r2;
            r310 = false;
            r213 = r213;
            goto L6
        L11:
            r31 = (a2) r0.decodeNullableSerializableElement(r1, 17, a2.a.a, r31);
            int r41 = 131072;
            r36 = r36;
        L14:
            int r42 = r41 | r23;
            List r43 = r37;
            r39 = r39;
        L20:
            List r311 = r43;
            r23 = r42;
            List r44 = r311;
        L21:
            List r125 = r44;
        L29:
            r2 = r2;
            r212 = r212;
            g1 r214 = r213;
            r30 = r30;
        L38:
            List r45 = r125;
            r30 = r30;
            r119 = r119;
            r213 = r214;
            g1 r312 = r35;
        L42:
            r37 = r45;
            r36 = r36;
            r39 = r39;
            r212 = r212;
            r2 = r2;
            r35 = r312;
            goto L6
        L12:
            int r46 = 65536 | r23;
            r36 = (Boolean) r0.decodeNullableSerializableElement(r1, 16, nuc.i.a, r36);
        L26:
            r23 = r46;
        L28:
            r125 = r37;
            r31 = r31;
            goto L29
        L13:
            r36 = r36;
            r39 = (String) r0.decodeNullableSerializableElement(r1, 15, v2.a, r39);
            r41 = 32768;
            r31 = r31;
            goto L14
        L15:
            r119 = r119;
            r36 = r36;
            r121 = (List) r0.decodeNullableSerializableElement(r1, 14, (juc.c) r2[14].getValue(), r121);
            r23 = r23 | 16384;
            r39 = r39;
            r31 = r31;
            r44 = r37;
            goto L21
        L16:
            r119 = r119;
            r36 = r36;
            r39 = r39;
            List r313 = (List) r0.decodeNullableSerializableElement(r1, 13, (juc.c) r2[13].getValue(), r37);
            r42 = r23 | 8192;
            r31 = r31;
            r43 = r313;
            goto L20
        L17:
            r119 = r119;
            r36 = r36;
            r39 = r39;
            r124 = (o1) r0.decodeNullableSerializableElement(r1, 12, o1.a.a, r124);
            r42 = r23 | 4096;
            r43 = r37;
            r31 = r31;
            goto L20
        L19:
            r119 = r119;
            r36 = r36;
            r39 = r39;
            r32 = (Boolean) r0.decodeNullableSerializableElement(r1, 11, nuc.i.a, r32);
            r42 = r23 | 2048;
            r43 = r37;
            r31 = r31;
            goto L20
        L22:
            r36 = r36;
            r33 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r33);
            r46 = r23 | 1024;
            goto L26
        L24:
            r31 = r31;
            r119 = r119;
            r36 = r36;
            r37 = r37;
            r39 = r39;
            r123 = (Integer) r0.decodeNullableSerializableElement(r1, 9, nuc.w0.a, r123);
            r46 = r23 | 512;
            goto L26
        L25:
            r31 = r31;
            r119 = r119;
            r36 = r36;
            r37 = r37;
            r39 = r39;
            r30 = (Integer) r0.decodeNullableSerializableElement(r1, 8, nuc.w0.a, r30);
            r46 = r23 | 256;
            goto L26
        L27:
            r31 = r31;
            r119 = r119;
            r36 = r36;
            r37 = r37;
            r39 = r39;
            r120 = (List) r0.decodeNullableSerializableElement(r1, 7, (juc.c) r2[7].getValue(), r120);
            r23 = r23 | 128;
            goto L28
        L30:
            r122 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r122);
            r23 = r23 | 64;
            g1 r47 = r213;
        L33:
            r214 = r47;
        L35:
            r212 = r212;
        L37:
            r125 = r37;
            r31 = r31;
            goto L38
        L31:
            r2 = r2;
            r31 = r31;
            r119 = r119;
            r36 = r36;
            r37 = r37;
            r39 = r39;
            r34 = (g1) r0.decodeNullableSerializableElement(r1, 5, g1.a.a, r34);
            r23 = r23 | 32;
            r214 = r213;
            r30 = r30;
            goto L35
        L32:
            r47 = (g1) r0.decodeNullableSerializableElement(r1, 4, g1.a.a, r213);
            r23 = r23 | 16;
            goto L33
        L34:
            r2 = r2;
            r31 = r31;
            r119 = r119;
            g1 r48 = r213;
            r36 = r36;
            r37 = r37;
            r39 = r39;
            r30 = r30;
            r214 = r48;
            r212 = (g1) r0.decodeNullableSerializableElement(r1, 3, g1.a.a, r212);
            r23 = r23 | 8;
            goto L35
        L36:
            r2 = r2;
            r31 = r31;
            r119 = r119;
            r214 = r213;
            r36 = r36;
            r37 = r37;
            r39 = r39;
            r30 = r30;
            r212 = r212;
            r35 = (g1) r0.decodeNullableSerializableElement(r1, 2, g1.a.a, r35);
            r23 = r23 | 4;
            goto L37
        L39:
            r312 = r35;
            r119 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r119);
            int r49 = r23 | 2;
        L41:
            r23 = r49;
            r45 = r37;
            r31 = r31;
            r30 = r30;
            r213 = r213;
            goto L42
        L40:
            r312 = r35;
            r211 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r211);
            r119 = r119;
            r49 = r23 | 1;
            goto L41
        L44:
            g1 r215 = r212;
            g1 r216 = r213;
            Integer r217 = r30;
            String r50 = r119;
            r116 = r211;
            r210 = r37;
            r21 = r32;
            r29 = r33;
            r111 = r123;
            r28 = r124;
            r27 = r31;
            r25 = r39;
            r118 = r216;
            r112 = r217;
            r115 = r34;
            r117 = r122;
            r26 = r36;
            r13 = r215;
            r110 = r120;
            r24 = r121;
            r113 = r35;
            r114 = r50;
            goto L45
        }

        public final void serialize(muc.f r8, Object r9) {
            t0 r10 = (t0) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = t0.s;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 0, v2.a, r10.a);
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
            r11.encodeNullableSerializableElement(r0, 2, g1.a.a, r10.c);
        L30:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r11.encodeNullableSerializableElement(r0, 3, g1.a.a, r10.d);
        L39:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r11.encodeNullableSerializableElement(r0, 4, g1.a.a, r10.e);
        L48:
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r11.encodeNullableSerializableElement(r0, 5, g1.a.a, r10.f);
        L57:
            if (r11.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r11.encodeNullableSerializableElement(r0, 6, v2.a, r10.g);
        L66:
            if (r11.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r11.encodeNullableSerializableElement(r0, 7, (juc.n) r1[7].getValue(), r10.h);
        L75:
            if (r11.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r11.encodeNullableSerializableElement(r0, 8, nuc.w0.a, r10.i);
        L84:
            if (r11.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r11.encodeNullableSerializableElement(r0, 9, nuc.w0.a, r10.j);
        L93:
            if (r11.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            boolean r17 = true;
        L99:
            if (r17 == false) goto L102;
            r11.encodeNullableSerializableElement(r0, 10, v2.a, r10.k);
        L102:
            if (r11.shouldEncodeElementDefault(r0, 11) == false) goto L105;
        L106:
            boolean r18 = true;
        L108:
            if (r18 == false) goto L111;
            r11.encodeNullableSerializableElement(r0, 11, nuc.i.a, r10.l);
        L111:
            if (r11.shouldEncodeElementDefault(r0, 12) == false) goto L114;
        L115:
            boolean r19 = true;
        L117:
            if (r19 == false) goto L120;
            r11.encodeNullableSerializableElement(r0, 12, o1.a.a, r10.m);
        L120:
            if (r11.shouldEncodeElementDefault(r0, 13) == false) goto L123;
        L124:
            boolean r20 = true;
        L126:
            if (r20 == false) goto L129;
            r11.encodeNullableSerializableElement(r0, 13, (juc.n) r1[13].getValue(), r10.n);
        L129:
            if (r11.shouldEncodeElementDefault(r0, 14) == false) goto L132;
        L133:
            boolean r21 = true;
        L135:
            if (r21 == false) goto L138;
            r11.encodeNullableSerializableElement(r0, 14, (juc.n) r1[14].getValue(), r10.o);
        L138:
            if (r11.shouldEncodeElementDefault(r0, 15) == false) goto L141;
        L142:
            boolean r22 = true;
        L144:
            if (r22 == false) goto L147;
            r11.encodeNullableSerializableElement(r0, 15, v2.a, r10.p);
        L147:
            if (r11.shouldEncodeElementDefault(r0, 16) == false) goto L150;
        L151:
            boolean r23 = true;
        L153:
            if (r23 == false) goto L156;
            r11.encodeNullableSerializableElement(r0, 16, nuc.i.a, r10.q);
        L156:
            if (r11.shouldEncodeElementDefault(r0, 17) == false) goto L159;
        L160:
            r2 = true;
        L161:
            if (r2 == false) goto L163;
            r11.encodeNullableSerializableElement(r0, 17, a2.a.a, r10.r);
        L163:
            r11.endStructure(r0);
            return;
        L159:
            if (r10.r == null) goto L161;
        L150:
            if (r10.q != null) goto L151;
            r23 = false;
            goto L153
        L141:
            if (r10.p != null) goto L142;
            r22 = false;
            goto L144
        L132:
            if (r10.o != null) goto L133;
            r21 = false;
            goto L135
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

        public final juc.d<t0> serializer() {
            return a.a;
        }
    }

    public t0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 262143);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r6 = (t0) r5;
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
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
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
        g1 r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        g1 r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        g1 r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        g1 r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<c2> r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        o1 r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<o1> r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        List<String> r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Boolean r49 = this.q;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        a2 r52 = this.r;
        if (r52 == null) goto L75;
        r1 = r52.hashCode();
    L75:
        return r51 + r1;
    L69:
        r50 = r49.hashCode();
        goto L70
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
        return "ActiveSwitchMenuMode(modeId=" + this.a + ", name=" + this.b + ", icon=" + this.c + ", darkModeIcon=" + this.d + ", activeIcon=" + this.e + ", activeDarkModeIcon=" + this.f + ", subTitleName=" + this.g + ", tagList=" + this.h + ", showTaskTools=" + this.i + ", agentMode=" + this.j + ", selectedName=" + this.k + ", needLogin=" + this.l + ", defaultModel=" + this.m + ", supportModels=" + this.n + ", conversationModeList=" + this.o + ", defaultConversationMode=" + this.p + ", showReasoningEffort=" + this.q + ", modelList=" + this.r + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        s = new Lazy[]{null, null, null, null, null, null, null, LazyKt.lazy(r1, new wa8.x0()), null, null, null, null, null, LazyKt.lazy(r1, new wa8.y0()), LazyKt.lazy(r1, new wa8.z0()), null, null, null};
    }

    public /* synthetic */ t0(String r23, String r24, g1 r25, g1 r26, g1 r27, g1 r28, Integer r29, String r30, o1 r31, List r32, Boolean r33, a2 r34, int r35) {
        if ((r35 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r35 & 4) == 0) goto L13;
        g1 r6 = null;
    L15:
        if ((r35 & 8) == 0) goto L17;
        g1 r7 = null;
    L19:
        if ((r35 & 16) == 0) goto L21;
        g1 r8 = null;
    L23:
        if ((r35 & 32) == 0) goto L25;
        g1 r9 = null;
    L27:
        if ((r35 & 512) == 0) goto L29;
        Integer r13 = null;
    L31:
        if ((r35 & 1024) == 0) goto L33;
        String r14 = null;
    L35:
        if ((r35 & 4096) == 0) goto L37;
        o1 r16 = null;
    L39:
        if ((r35 & 8192) == 0) goto L41;
        List r17 = null;
    L43:
        if ((65536 & r35) == 0) goto L45;
        Boolean r20 = null;
    L47:
        if ((r35 & 131072) == 0) goto L49;
        a2 r21 = null;
    L50:
        this(r4, r5, r6, r7, r8, r9, null, null, null, r13, r14, null, r16, r17, null, null, r20, r21);
        return;
    L49:
        r21 = r34;
        goto L50
    L45:
        r20 = r33;
        goto L47
    L41:
        r17 = r32;
        goto L43
    L37:
        r16 = r31;
        goto L39
    L33:
        r14 = r30;
        goto L35
    L29:
        r13 = r29;
        goto L31
    L25:
        r9 = r28;
        goto L27
    L21:
        r8 = r27;
        goto L23
    L17:
        r7 = r26;
        goto L19
    L13:
        r6 = r25;
        goto L15
    L9:
        r5 = r24;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }

    public t0(String r3, String r4, g1 r5, g1 r6, g1 r7, g1 r8, String r9, List<c2> r10, Integer r11, Integer r12, String r13, Boolean r14, o1 r15, List<o1> r16, List<String> r17, String r18, Boolean r19, a2 r20) {
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
        this.r = r20;
    }

    public t0(int r6, String r7, String r8, g1 r9, g1 r10, g1 r11, g1 r12, String r13, List r14, Integer r15, Integer r16, String r17, Boolean r18, o1 r19, List r20, List r21, String r22, Boolean r23, a2 r24) {
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
    L65:
        if ((32768 & r6) != 0) goto L67;
        this.p = null;
    L69:
        if ((65536 & r6) != 0) goto L71;
        this.q = null;
    L73:
        if ((r6 & 131072) != 0) goto L75;
        this.r = null;
        return;
    L75:
        this.r = r24;
        return;
    L71:
        this.q = r23;
        goto L73
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
