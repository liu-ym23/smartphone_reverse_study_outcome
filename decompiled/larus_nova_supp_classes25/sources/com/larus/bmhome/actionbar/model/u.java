package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class u {
    public static final b Companion = null;
    public final Integer a;
    public final Integer b;
    public final String c;
    public String d;
    public k1 e;
    public final Boolean f;
    public final Boolean g;
    public final Integer h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<u> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.w0 r1 = nuc.w0.a;
            v2 r2 = v2.a;
            nuc.i r3 = nuc.i.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r1)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionItem", r0, 7);
            r1.j("id", true);
            r1.j("instruction_item_type", true);
            r1.j("sub_title", true);
            r1.j("template", true);
            r1.j("enable_bottom_line", true);
            r1.j("cancel_top_margin", true);
            r1.j("margin_top", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            int r3 = 2;
            Integer r10 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r2 = nuc.w0.a;
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Integer r7 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            v2 r11 = v2.a;
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 2, r11, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 3, r11, null);
            nuc.i r12 = nuc.i.a;
            Boolean r5 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, r12, null);
            Boolean r8 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, r12, null);
            Integer r16 = (Integer) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r13 = r4;
            Boolean r14 = r5;
            r10 = r6;
            Integer r15 = r7;
            Boolean r17 = r8;
            String r19 = r9;
            int r20 = 127;
        L23:
            r0.endStructure(r1);
            return new u(r20, r10, r15, r13, r19, r14, r17, r16);
        L5:
            Boolean r21 = null;
            r15 = null;
            Integer r110 = null;
            String r111 = null;
            Boolean r112 = null;
            String r113 = null;
            int r22 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L22;
            int r23 = r0.decodeElementIndex(r1);
            switch(r23) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r23);
        L21:
            r3 = 2;
            r114 = false;
            goto L6
        L11:
            r110 = (Integer) r0.decodeNullableSerializableElement(r1, 6, nuc.w0.a, r110);
            r22 = r22 | 64;
        L20:
            r3 = 2;
            goto L6
        L12:
            r112 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, r112);
            r22 = r22 | 32;
            goto L20
        L13:
            r21 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, nuc.i.a, r21);
            r22 = r22 | 16;
            goto L20
        L14:
            r113 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r113);
            r22 = r22 | 8;
            goto L20
        L15:
            r111 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r111);
            r22 = r22 | 4;
            goto L20
        L17:
            r15 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, r15);
            r22 = r22 | 2;
            goto L20
        L19:
            r22 = r22 | 1;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r10);
            goto L20
        L22:
            r20 = r22;
            r16 = r110;
            r13 = r111;
            r19 = r113;
            r17 = r112;
            r14 = r21;
            goto L23
        }

        public final void serialize(muc.f r8, Object r9) {
            u r10 = (u) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            b r1 = u.Companion;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r10.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r11.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r10.a);
        L15:
            if (r11.shouldEncodeElementDefault(r0, 1) == true) goto L22;
            Integer r5 = r10.b;
            if (r5 == null) goto L22;
            if (r5.intValue() != 0) goto L22;
            boolean r6 = false;
        L24:
            if (r6 == false) goto L27;
            r11.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r10.b);
        L27:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L30;
        L31:
            boolean r7 = true;
        L33:
            if (r7 == false) goto L36;
            r11.encodeNullableSerializableElement(r0, 2, v2.a, r10.c);
        L36:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L39;
        L40:
            boolean r12 = true;
        L42:
            if (r12 == false) goto L45;
            r11.encodeNullableSerializableElement(r0, 3, v2.a, r10.d);
        L45:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L48;
        L49:
            boolean r13 = true;
        L51:
            if (r13 == false) goto L54;
            r11.encodeNullableSerializableElement(r0, 4, nuc.i.a, r10.f);
        L54:
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L57;
        L58:
            boolean r14 = true;
        L60:
            if (r14 == false) goto L63;
            r11.encodeNullableSerializableElement(r0, 5, nuc.i.a, r10.g);
        L63:
            if (r11.shouldEncodeElementDefault(r0, 6) == true) goto L70;
            Integer r15 = r10.h;
            if (r15 == null) goto L70;
            if (r15.intValue() != 0) goto L70;
        L71:
            if (r2 == false) goto L73;
            r11.encodeNullableSerializableElement(r0, 6, nuc.w0.a, r10.h);
        L73:
            r11.endStructure(r0);
            return;
        L70:
            r2 = true;
            goto L71
        L57:
            if (Intrinsics.areEqual(r10.g, Boolean.FALSE) == false) goto L58;
            r14 = false;
            goto L60
        L48:
            if (Intrinsics.areEqual(r10.f, Boolean.FALSE) == false) goto L49;
            r13 = false;
            goto L51
        L39:
            if (Intrinsics.areEqual(r10.d, "") == false) goto L40;
            r12 = false;
            goto L42
        L30:
            if (Intrinsics.areEqual(r10.c, "") == false) goto L31;
            r7 = false;
        L22:
            r6 = true;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<u> serializer() {
            return a.a;
        }
    }

    public u() {
        this(null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        k1 r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f;
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
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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
        return "ActionBarInstructionItem(id=" + this.a + ", instructionItemType=" + this.b + ", subTitle=" + this.c + ", template=" + this.d + ", templateObject=" + this.e + ", enableBottomLine=" + this.f + ", cancelTopMargin=" + this.g + ", marginTop=" + this.h + ')';
    }

    static {
        Companion = new b();
    }

    public final Integer b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public static u a(u r11, String r12, int r13) {
        Integer r1 = null;
        if ((r13 & 1) == 0) goto L5;
        Integer r3 = r11.a;
    L7:
        if ((r13 & 2) == 0) goto L9;
        Integer r4 = r11.b;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r5 = r11.c;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r12 = r11.d;
    L17:
        String r6 = r12;
        if ((r13 & 16) == 0) goto L20;
        k1 r7 = r11.e;
    L22:
        if ((r13 & 32) == 0) goto L24;
        Boolean r8 = r11.f;
    L26:
        if ((r13 & 64) == 0) goto L28;
        Boolean r9 = r11.g;
    L30:
        if ((r13 & 128) == 0) goto L32;
        r1 = r11.h;
    L32:
        r11.getClass();
        return new u(r3, r4, r5, r6, r7, r8, r9, r1);
    L28:
        r9 = null;
        goto L30
    L24:
        r8 = null;
        goto L26
    L20:
        r7 = null;
        goto L22
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public u(int r5, Integer r6, Integer r7, String r8, String r9, Boolean r10, Boolean r11, Integer r12) {
        if ((r5 & 0) == 0) goto L5;
        nuc.b2.b(r5, 0, a.b);
        throw null;
    L5:
        if ((r5 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r5 & 2) != 0) goto L11;
        this.b = 0;
    L13:
        if ((r5 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r5 & 8) != 0) goto L19;
        this.d = "";
    L20:
        this.e = null;
        if ((r5 & 16) != 0) goto L23;
        this.f = Boolean.FALSE;
    L25:
        if ((r5 & 32) != 0) goto L27;
        this.g = Boolean.FALSE;
    L29:
        if ((r5 & 64) != 0) goto L31;
        this.h = 0;
        return;
    L31:
        this.h = r12;
        return;
    L27:
        this.g = r11;
        goto L29
    L23:
        this.f = r10;
        goto L25
    L19:
        this.d = r9;
        goto L20
    L15:
        this.c = r8;
        goto L17
    L11:
        this.b = r7;
        goto L13
    L7:
        this.a = r6;
        goto L9
    }

    public /* synthetic */ u(Integer r13, Integer r14, String r15, String r16, Boolean r17, Boolean r18, Integer r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        Integer r4 = 0;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Integer r5 = 0;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r20 & 32) == 0) goto L21;
        Boolean r9 = Boolean.FALSE;
    L23:
        if ((r20 & 64) == 0) goto L25;
        Boolean r10 = Boolean.FALSE;
    L27:
        if ((r20 & 128) == 0) goto L29;
        Integer r11 = 0;
    L30:
        this(r4, r5, r6, r7, null, r9, r10, r11);
        return;
    L29:
        r11 = r19;
        goto L30
    L25:
        r10 = r18;
        goto L27
    L21:
        r9 = r17;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public u(Integer r1, Integer r2, String r3, String r4, k1 r5, Boolean r6, Boolean r7, Integer r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
