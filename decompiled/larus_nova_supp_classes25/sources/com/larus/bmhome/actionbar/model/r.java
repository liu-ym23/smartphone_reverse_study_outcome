package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
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
public final class r {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] m = null;
    public final Integer a;
    public List<u> b;
    public h1 c;
    public final Boolean d;
    public final j1 e;
    public final String f;
    public final String g;
    public final Boolean h;
    public final y i;
    public final Boolean j;
    public final Integer k;
    public final i1 l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<r> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionConf", r0, 12);
            r1.j("instruction_type", true);
            r1.j("instruction_item_list", true);
            r1.j("input_box_content", true);
            r1.j("persistent", true);
            r1.j("ext", true);
            r1.j("use_template_id", true);
            r1.j("starling_name", true);
            r1.j("enter_independent_page", true);
            r1.j("menu_conf", true);
            r1.j("template_enhance", true);
            r1.j("input_type", true);
            r1.j("input_box_settings", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = r.m;
            nuc.w0 r2 = nuc.w0.a;
            nuc.i r1 = nuc.i.a;
            v2 r3 = v2.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d((juc.d) r0[1].getValue()), kuc.a.d(h1.a.a), kuc.a.d(r1), kuc.a.d(j1.a.a), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r1), kuc.a.d(y.a.a), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(i1.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r29) {
            Intrinsics.checkNotNullParameter(r29, "decoder");
            g2 r1 = b;
            muc.c r0 = r29.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = r.m;
            int r10 = 9;
            int r13 = 8;
            Boolean r4 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r3 = nuc.w0.a;
            Integer r14 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            List r5 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), null);
            h1 r11 = (h1) r0.decodeNullableSerializableElement(r1, 2, h1.a.a, null);
            nuc.i r15 = nuc.i.a;
            Boolean r6 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, r15, null);
            j1 r7 = (j1) r0.decodeNullableSerializableElement(r1, 4, j1.a.a, null);
            v2 r12 = v2.a;
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 5, r12, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 6, r12, null);
            Boolean r16 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, r15, null);
            y r17 = (y) r0.decodeNullableSerializableElement(r1, 8, y.a.a, null);
            Boolean r18 = (Boolean) r0.decodeNullableSerializableElement(r1, 9, r15, null);
            Integer r19 = (Integer) r0.decodeNullableSerializableElement(r1, 10, r3, null);
            List r110 = r5;
            Integer r22 = r19;
            i1 r23 = (i1) r0.decodeNullableSerializableElement(r1, 11, i1.a.a, null);
            j1 r111 = r7;
            Boolean r112 = r6;
            String r113 = r8;
            String r114 = r9;
            Boolean r115 = r16;
            Boolean r21 = r18;
            y r20 = r17;
            Integer r116 = r14;
            h1 r117 = r11;
            int r118 = 4095;
        L34:
            r0.endStructure(r1);
            return new r(r118, r116, r110, r117, r112, r111, r113, r114, r115, r20, r21, r22, r23);
        L5:
            int r24 = 11;
            h1 r25 = null;
            Boolean r26 = null;
            Integer r27 = null;
            Boolean r119 = null;
            y r120 = null;
            String r121 = null;
            i1 r122 = null;
            j1 r28 = null;
            String r210 = null;
            Integer r211 = null;
            List r212 = null;
            int r30 = 0;
            boolean r213 = true;
        L6:
            if (r213 == false) goto L33;
            int r31 = r0.decodeElementIndex(r1);
            switch(r31) {
                case -1: goto L30;
                case 0: goto L29;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L11;
                default: goto L10;
            };
        L11:
            r30 = r30 | 2048;
            r122 = (i1) r0.decodeNullableSerializableElement(r1, r24, i1.a.a, r122);
            r28 = r28;
            r210 = r210;
        L12:
            List r32 = r212;
        L32:
            r210 = r210;
            r212 = r32;
            r28 = r28;
            r2 = r2;
            r24 = 11;
            r10 = 9;
            r13 = 8;
            goto L6
        L13:
            r27 = (Integer) r0.decodeNullableSerializableElement(r1, 10, nuc.w0.a, r27);
            r30 = r30 | 1024;
        L18:
            j1 r33 = r28;
            r210 = r210;
        L27:
            r28 = r33;
            goto L12
        L14:
            r26 = (Boolean) r0.decodeNullableSerializableElement(r1, r10, nuc.i.a, r26);
            r30 = r30 | 512;
            goto L18
        L15:
            r120 = (y) r0.decodeNullableSerializableElement(r1, r13, y.a.a, r120);
            r30 = r30 | 256;
            goto L18
        L17:
            r119 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, nuc.i.a, r119);
            r30 = r30 | 128;
            goto L18
        L20:
            r121 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r121);
            r30 = r30 | 64;
        L22:
            r33 = r28;
            r210 = r210;
            goto L27
        L21:
            r210 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r210);
            r30 = r30 | 32;
            goto L22
        L23:
            r210 = r210;
            r33 = (j1) r0.decodeNullableSerializableElement(r1, 4, j1.a.a, r28);
            r30 = r30 | 16;
            goto L27
        L25:
            r210 = r210;
            r4 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, nuc.i.a, r4);
            r30 = r30 | 8;
            r33 = r28;
            goto L27
        L26:
            r210 = r210;
            r25 = (h1) r0.decodeNullableSerializableElement(r1, 2, h1.a.a, r25);
            r30 = r30 | 4;
            r33 = r28;
            goto L27
        L28:
            r28 = r28;
            r210 = r210;
            r212 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), r212);
            r30 = r30 | 2;
            goto L12
        L29:
            Integer r34 = r211;
            List r214 = r212;
            Integer r35 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r34);
            r30 = r30 | 1;
        L31:
            List r215 = r214;
            r211 = r35;
            r32 = r215;
            goto L32
        L30:
            r35 = r211;
            r214 = r212;
            r213 = false;
            goto L31
        L10:
            throw new UnknownFieldException(r31);
        L33:
            r113 = r210;
            r21 = r26;
            r22 = r27;
            r111 = r28;
            r115 = r119;
            r20 = r120;
            r114 = r121;
            r23 = r122;
            r110 = r212;
            r112 = r4;
            r117 = r25;
            r118 = r30;
            r116 = r211;
            goto L34
        }

        public final void serialize(muc.f r7, Object r8) {
            r r9 = (r) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = r.m;
            int r2 = 0;
            if (r10.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r9.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r10.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r9.a);
        L15:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r10.encodeNullableSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r9.b);
        L24:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r10.encodeNullableSerializableElement(r0, 2, h1.a.a, r9.c);
        L33:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r11 = true;
        L39:
            if (r11 == false) goto L42;
            r10.encodeNullableSerializableElement(r0, 3, nuc.i.a, r9.d);
        L42:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            boolean r12 = true;
        L48:
            if (r12 == false) goto L51;
            r10.encodeNullableSerializableElement(r0, 4, j1.a.a, r9.e);
        L51:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L54;
        L55:
            boolean r13 = true;
        L57:
            if (r13 == false) goto L60;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L60:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L63;
        L64:
            boolean r14 = true;
        L66:
            if (r14 == false) goto L69;
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L69:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L72;
        L73:
            boolean r15 = true;
        L75:
            if (r15 == false) goto L78;
            r10.encodeNullableSerializableElement(r0, 7, nuc.i.a, r9.h);
        L78:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L81;
        L82:
            boolean r16 = true;
        L84:
            if (r16 == false) goto L87;
            r10.encodeNullableSerializableElement(r0, 8, y.a.a, r9.i);
        L87:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L90;
        L91:
            boolean r17 = true;
        L93:
            if (r17 == false) goto L96;
            r10.encodeNullableSerializableElement(r0, 9, nuc.i.a, r9.j);
        L96:
            if (r10.shouldEncodeElementDefault(r0, 10) == false) goto L99;
        L100:
            boolean r18 = true;
        L102:
            if (r18 == false) goto L105;
            r10.encodeNullableSerializableElement(r0, 10, nuc.w0.a, r9.k);
        L105:
            if (r10.shouldEncodeElementDefault(r0, 11) == false) goto L108;
        L109:
            r2 = 1;
        L110:
            if (r2 == 0) goto L112;
            r10.encodeNullableSerializableElement(r0, 11, i1.a.a, r9.l);
        L112:
            r10.endStructure(r0);
            return;
        L108:
            if (r9.l == null) goto L110;
        L99:
            if (r9.k != null) goto L100;
            r18 = false;
            goto L102
        L90:
            if (r9.j != null) goto L91;
            r17 = false;
            goto L93
        L81:
            if (Intrinsics.areEqual(r9.i, new y(r2)) == false) goto L82;
            r16 = false;
            goto L84
        L72:
            if (r9.h != null) goto L73;
            r15 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r9.g, "") == false) goto L64;
            r14 = false;
            goto L66
        L54:
            if (r9.f != null) goto L55;
            r13 = false;
            goto L57
        L45:
            if (r9.e != null) goto L46;
            r12 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r9.d, Boolean.FALSE) == false) goto L37;
            r11 = false;
            goto L39
        L27:
            if (r9.c != null) goto L28;
            r6 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r9.b, new ArrayList()) == false) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<r> serializer() {
            return a.a;
        }
    }

    public r() {
        this(null, null, null, null, null, null, null, null, 4095);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
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
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<u> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        h1 r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        j1 r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        y r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        i1 r34 = this.l;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
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
        return "ActionBarInstructionConf(instructionType=" + this.a + ", instructionItems=" + this.b + ", inputBoxContent=" + this.c + ", persistent=" + this.d + ", ext=" + this.e + ", useTemplateId=" + this.f + ", starlingName=" + this.g + ", enterIndependentPage=" + this.h + ", menuConf=" + this.i + ", templateEnhance=" + this.j + ", inputType=" + this.k + ", inputBoxSettings=" + this.l + ')';
    }

    static {
        Companion = new b();
        m = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.v()), null, null, null, null, null, null, null, null, null, null};
    }

    public final String b() {
        Integer r0 = this.a;
        if (r0 != null) goto L6;
    L7:
        if (r0 != null) goto L10;
    L12:
        if (r0 != null) goto L15;
    L17:
        if (r0 == null) goto L24;
        r0.intValue();
        return "ai_generate_feed_image";
    L24:
        return "ai_generate_feed_image";
    L15:
        if (r0.intValue() != 18) goto L17;
        return "ai_generate_feed_video";
    L10:
        if (r0.intValue() != 16) goto L12;
        return "ai_generate_feed_image";
    L6:
        if (r0.intValue() != 4) goto L7;
        return "ai_generate_feed_image";
    }

    public final boolean f() {
        Boolean r0 = this.h;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.j, r1) == true) goto L8;
        return false;
    }

    public final List<u> c() {
        return this.b;
    }

    public final Integer d() {
        return this.a;
    }

    public final String e() {
        return this.g;
    }

    public static r a(r r17, List r18, h1 r19, j1 r20, y r21, int r22) {
        i1 r3 = null;
        if ((r22 & 1) == 0) goto L5;
        Integer r5 = r17.a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        List r6 = r17.b;
    L11:
        if ((r22 & 4) == 0) goto L13;
        h1 r7 = r17.c;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Boolean r8 = r17.d;
    L19:
        if ((r22 & 16) == 0) goto L21;
        j1 r9 = r17.e;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r10 = r17.f;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r11 = r17.g;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Boolean r12 = r17.h;
    L35:
        if ((r22 & 256) == 0) goto L37;
        y r13 = r17.i;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Boolean r14 = r17.j;
    L43:
        if ((r22 & 1024) == 0) goto L45;
        Integer r15 = r17.k;
    L47:
        if ((r22 & 2048) == 0) goto L50;
        r3 = r17.l;
    L50:
        return new r(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3);
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = r21;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ r(Integer r17, List r18, h1 r19, j1 r20, String r21, String r22, Boolean r23, y r24, int r25) {
        int r2 = 0;
        if ((r25 & 1) == 0) goto L5;
        Integer r4 = 0;
    L7:
        if ((r25 & 2) == 0) goto L9;
        List r5 = new ArrayList();
    L11:
        if ((r25 & 4) == 0) goto L13;
        h1 r6 = null;
    L15:
        if ((r25 & 8) == 0) goto L17;
        Boolean r7 = Boolean.FALSE;
    L19:
        if ((r25 & 16) == 0) goto L21;
        j1 r8 = null;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r25 & 128) == 0) goto L33;
        Boolean r11 = null;
    L35:
        if ((r25 & 256) == 0) goto L37;
        y r12 = new y(r2);
    L38:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, null, null, null);
        return;
    L37:
        r12 = r24;
        goto L38
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public r(Integer r1, List<u> r2, h1 r3, Boolean r4, j1 r5, String r6, String r7, Boolean r8, y r9, Boolean r10, Integer r11, i1 r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }

    public r(int r6, Integer r7, List r8, h1 r9, Boolean r10, j1 r11, String r12, String r13, Boolean r14, y r15, Boolean r16, Integer r17, i1 r18) {
        int r3 = 0;
        if ((r6 & 0) == 0) goto L5;
        nuc.b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        Integer r2 = 0;
    L8:
        this.a = r2;
        if ((r6 & 2) != 0) goto L11;
        List r4 = new ArrayList();
    L12:
        this.b = r4;
        if ((r6 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r6 & 8) != 0) goto L19;
        Boolean r5 = Boolean.FALSE;
    L20:
        this.d = r5;
        if ((r6 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r6 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r6 & 64) != 0) goto L31;
        String r19 = "";
    L32:
        this.g = r19;
        if ((r6 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r6 & 256) != 0) goto L39;
        y r20 = new y(r3);
    L40:
        this.i = r20;
        if ((r6 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r6 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r6 & 2048) != 0) goto L51;
        this.l = null;
        return;
    L51:
        this.l = r18;
        return;
    L47:
        this.k = r17;
        goto L49
    L43:
        this.j = r16;
        goto L45
    L39:
        r20 = r15;
        goto L40
    L35:
        this.h = r14;
        goto L37
    L31:
        r19 = r13;
        goto L32
    L27:
        this.f = r12;
        goto L29
    L23:
        this.e = r11;
        goto L25
    L19:
        r5 = r10;
        goto L20
    L15:
        this.c = r9;
        goto L17
    L11:
        r4 = r8;
        goto L12
    L7:
        r2 = r7;
        goto L8
    }
}
