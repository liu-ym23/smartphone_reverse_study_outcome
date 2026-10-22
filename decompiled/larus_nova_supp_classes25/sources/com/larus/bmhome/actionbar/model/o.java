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
public final class o {
    public static final b Companion = null;
    public final Long a;
    public final int b;
    public final j0 c;
    public final j0 d;
    public final String e;
    public final String f;
    public final long g;
    public final long h;
    public final Long i;
    public final Integer j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<o> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarImageTemplateItem", r0, 9);
            r1.j("id", true);
            r1.j("type", true);
            r1.j("image_thumb", true);
            r1.j("image_ori", true);
            r1.j("display_text", true);
            r1.j("message_text", true);
            r1.j("ratio_id", true);
            r1.j("style_id", true);
            r1.j("template_primary_key", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            nuc.g1 r1 = nuc.g1.a;
            j0.a r2 = j0.a.a;
            v2 r3 = v2.a;
            return new juc.d[]{kuc.a.d(r1), nuc.w0.a, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), r1, r1, kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            int r3 = 8;
            int r5 = 5;
            int r6 = 6;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.g1 r2 = nuc.g1.a;
            Long r11 = (Long) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            int r10 = r0.decodeIntElement(r1, 1);
            j0.a r13 = j0.a.a;
            j0 r8 = (j0) r0.decodeNullableSerializableElement(r1, 2, r13, null);
            j0 r4 = (j0) r0.decodeNullableSerializableElement(r1, 3, r13, null);
            v2 r14 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 4, r14, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 5, r14, null);
            long r15 = r0.decodeLongElement(r1, 6);
            long r12 = r0.decodeLongElement(r1, 7);
            Long r22 = (Long) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            j0 r16 = r4;
            String r17 = r7;
            long r20 = r12;
            String r18 = r9;
            Long r19 = r11;
            long r110 = r15;
            int r111 = 511;
            j0 r112 = r8;
            int r113 = r10;
        L26:
            r0.endStructure(r1);
            return new o(r111, r19, r113, r112, r16, r18, r17, r110, r20, r22);
        L5:
            long r114 = 0;
            String r21 = null;
            String r23 = null;
            Long r115 = null;
            j0 r116 = null;
            r16 = null;
            Long r117 = null;
            long r25 = 0;
            int r26 = 0;
            int r118 = 0;
            boolean r27 = true;
        L6:
            if (r27 == false) goto L25;
            int r28 = r0.decodeElementIndex(r1);
            switch(r28) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r28);
        L24:
            r5 = 5;
            r6 = 6;
            r27 = false;
            goto L6
        L11:
            r115 = (Long) r0.decodeNullableSerializableElement(r1, r3, nuc.g1.a, r115);
            r26 = r26 | 256;
        L23:
            r3 = 8;
            r5 = 5;
            r6 = 6;
            goto L6
        L12:
            r114 = r0.decodeLongElement(r1, 7);
            r26 = r26 | 128;
            goto L23
        L13:
            r25 = r0.decodeLongElement(r1, r6);
            r26 = r26 | 64;
            goto L23
        L14:
            r23 = (String) r0.decodeNullableSerializableElement(r1, r5, v2.a, r23);
            r26 = r26 | 32;
            goto L23
        L15:
            r21 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r21);
            r26 = r26 | 16;
            goto L23
        L16:
            r16 = (j0) r0.decodeNullableSerializableElement(r1, 3, j0.a.a, r16);
            r26 = r26 | 8;
            goto L23
        L18:
            r116 = (j0) r0.decodeNullableSerializableElement(r1, 2, j0.a.a, r116);
            r26 = r26 | 4;
            goto L23
        L20:
            r118 = r0.decodeIntElement(r1, 1);
            r26 = r26 | 2;
            goto L23
        L22:
            r26 = r26 | 1;
            r117 = (Long) r0.decodeNullableSerializableElement(r1, 0, nuc.g1.a, r117);
            goto L23
        L25:
            Long r29 = r117;
            r18 = r21;
            r17 = r23;
            r22 = r115;
            r110 = r25;
            r20 = r114;
            r112 = r116;
            r113 = r118;
            r111 = r26;
            r19 = r29;
            goto L26
        }

        public final void serialize(muc.f r10, Object r11) {
            o r12 = (o) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            b r1 = o.Companion;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeNullableSerializableElement(r0, 0, nuc.g1.a, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r13.encodeIntElement(r0, 1, r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r13.encodeNullableSerializableElement(r0, 2, j0.a.a, r12.c);
        L30:
            if (r13.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r13.encodeNullableSerializableElement(r0, 3, j0.a.a, r12.d);
        L39:
            if (r13.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r13.encodeNullableSerializableElement(r0, 4, v2.a, r12.e);
        L48:
            if (r13.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r8 = true;
        L54:
            if (r8 == false) goto L57;
            r13.encodeNullableSerializableElement(r0, 5, v2.a, r12.f);
        L57:
            if (r13.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r9 = true;
        L63:
            if (r9 == false) goto L66;
            r13.encodeLongElement(r0, 6, r12.g);
        L66:
            if (r13.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r13.encodeLongElement(r0, 7, r12.h);
        L75:
            if (r13.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            r2 = true;
        L80:
            if (r2 == false) goto L82;
            r13.encodeNullableSerializableElement(r0, 8, nuc.g1.a, r12.i);
        L82:
            r13.endStructure(r0);
            return;
        L78:
            if (r12.i == null) goto L80;
        L69:
            if (r12.h != (-1)) goto L70;
            r14 = false;
            goto L72
        L60:
            if (r12.g != (-1)) goto L61;
            r9 = false;
            goto L63
        L51:
            if (r12.f != null) goto L52;
            r8 = false;
            goto L54
        L42:
            if (r12.e != null) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r12.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r12.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r12.b != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r12.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<o> serializer() {
            return a.a;
        }
    }

    public o() {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = -1;
        this.i = null;
        this.j = 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        j0 r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        j0 r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        long r16 = this.g;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = this.h;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        Long r20 = this.i;
        if (r20 != null) goto L25;
        int r21 = 0;
    L26:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.j;
        if (r23 == null) goto L31;
        r1 = r23.hashCode();
    L31:
        return r22 + r1;
    L25:
        r21 = r20.hashCode();
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
        return "ActionBarImageTemplateItem(id=" + this.a + ", type=" + this.b + ", imageThumb=" + this.c + ", imageOri=" + this.d + ", displayText=" + this.e + ", messageText=" + this.f + ", ratioId=" + this.g + ", styleId=" + this.h + ", templatePrimaryId=" + this.i + ", status=" + this.j + ')';
    }

    static {
        Companion = new b();
    }

    public final int getType() {
        return this.b;
    }

    public o(int r4, Long r5, int r6, j0 r7, j0 r8, String r9, String r10, long r11, long r13, Long r15) {
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
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r4 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r4 & 64) != 0) goto L31;
        this.g = -1;
    L33:
        if ((r4 & 128) != 0) goto L35;
        this.h = -1;
    L37:
        if ((r4 & 256) != 0) goto L39;
        this.i = null;
    L40:
        this.j = 0;
        return;
    L39:
        this.i = r15;
        goto L40
    L35:
        this.h = r13;
        goto L37
    L31:
        this.g = r11;
        goto L33
    L27:
        this.f = r10;
        goto L29
    L23:
        this.e = r9;
        goto L25
    L19:
        this.d = r8;
        goto L21
    L15:
        this.c = r7;
        goto L17
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
