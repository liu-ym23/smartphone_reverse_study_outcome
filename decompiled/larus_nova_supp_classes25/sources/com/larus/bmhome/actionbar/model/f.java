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
public final class f {
    public static final b Companion = null;
    public final long a;
    public final String b;
    public final String c;
    public final Long d;
    public final g1 e;
    public final g1 f;
    public final g1 g;
    public Integer h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<f> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.g1 r1 = nuc.g1.a;
            v2 r2 = v2.a;
            g1.a r3 = g1.a.a;
            return new juc.d[]{r1, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarDigitalAvatarTemplateItem", r0, 7);
            r1.j("id", true);
            r1.j("display_text", true);
            r1.j("message_text", true);
            r1.j("avatar_id", true);
            r1.j("icon", true);
            r1.j("icon_ori", true);
            r1.j("preview_icon", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            g1 r10 = null;
            if (r0.decodeSequentially() == false) goto L5;
            long r11 = r0.decodeLongElement(r1, 0);
            v2 r2 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            Long r4 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, null);
            g1.a r6 = g1.a.a;
            g1 r7 = (g1) r0.decodeNullableSerializableElement(r1, 4, r6, null);
            g1 r8 = (g1) r0.decodeNullableSerializableElement(r1, 5, r6, null);
            Long r13 = r4;
            g1 r14 = r7;
            g1 r16 = (g1) r0.decodeNullableSerializableElement(r1, 6, r6, null);
            g1 r15 = r8;
            long r9 = r11;
            int r12 = 127;
            String r17 = r3;
            String r18 = r5;
        L21:
            r0.endStructure(r1);
            return new f(r12, r9, r18, r17, r13, r14, r15, r16);
        L5:
            String r19 = null;
            String r110 = null;
            Long r111 = null;
            long r112 = 0;
            int r20 = 0;
            boolean r113 = true;
            g1 r114 = null;
            g1 r115 = null;
        L6:
            if (r113 == false) goto L20;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L19;
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L18:
            r112 = r0.decodeLongElement(r1, 0);
            r20 = r20 | 1;
            goto L6
        L19:
            r113 = false;
            goto L6
        L11:
            r20 = r20 | 64;
            r115 = (g1) r0.decodeNullableSerializableElement(r1, 6, g1.a.a, r115);
            goto L6
        L12:
            r20 = r20 | 32;
            r114 = (g1) r0.decodeNullableSerializableElement(r1, 5, g1.a.a, r114);
            goto L6
        L13:
            r20 = r20 | 16;
            r10 = (g1) r0.decodeNullableSerializableElement(r1, 4, g1.a.a, r10);
            goto L6
        L14:
            r20 = r20 | 8;
            r111 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, r111);
            goto L6
        L15:
            r20 = r20 | 4;
            r110 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r110);
            goto L6
        L16:
            r20 = r20 | 2;
            r19 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r19);
            goto L6
        L20:
            r12 = r20;
            String r116 = r110;
            r14 = r10;
            r9 = r112;
            r16 = r115;
            r17 = r116;
            Long r23 = r111;
            r15 = r114;
            r18 = r19;
            r13 = r23;
            goto L21
        }

        public final void serialize(muc.f r13, Object r14) {
            f r15 = (f) r14;
            Intrinsics.checkNotNullParameter(r13, "encoder");
            Intrinsics.checkNotNullParameter(r15, "value");
            g2 r0 = b;
            muc.d r16 = r13.beginStructure(r0);
            b r1 = f.Companion;
            boolean r2 = false;
            if (r16.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r16.encodeLongElement(r0, 0, r15.a);
        L12:
            if (r16.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r16.encodeNullableSerializableElement(r0, 1, v2.a, r15.b);
        L21:
            if (r16.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r16.encodeNullableSerializableElement(r0, 2, v2.a, r15.c);
        L30:
            if (r16.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r16.encodeNullableSerializableElement(r0, 3, nuc.g1.a, r15.d);
        L39:
            if (r16.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r16.encodeNullableSerializableElement(r0, 4, g1.a.a, r15.e);
        L48:
            if (r16.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r8 = true;
        L54:
            if (r8 == false) goto L57;
            r16.encodeNullableSerializableElement(r0, 5, g1.a.a, r15.f);
        L57:
            if (r16.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            r2 = true;
        L62:
            if (r2 == false) goto L64;
            r16.encodeNullableSerializableElement(r0, 6, g1.a.a, r15.g);
        L64:
            r16.endStructure(r0);
            return;
        L60:
            if (Intrinsics.areEqual(r15.g, new g1("", "", null, null, 28)) == true) goto L62;
        L51:
            if (Intrinsics.areEqual(r15.f, new g1("", "", null, null, 28)) == false) goto L52;
            r8 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r15.e, new g1("", "", null, null, 28)) == false) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r15.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r15.c, "") == false) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r15.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r15.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.a;
        }
    }

    public f() {
        this(0, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        Long r9 = this.d;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        g1 r12 = this.e;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        g1 r15 = this.f;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        g1 r18 = this.g;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.h;
        if (r21 == null) goto L31;
        r3 = r21.hashCode();
    L31:
        return r20 + r3;
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarDigitalAvatarTemplateItem(id=" + this.a + ", displayText=" + this.b + ", messageText=" + this.c + ", avatarId=" + this.d + ", thumbIcon=" + this.e + ", originIcon=" + this.f + ", previewIcon=" + this.g + ", status=" + this.h + ')';
    }

    static {
        Companion = new b();
    }

    public f(long r16, String r18, g1 r19, g1 r20, g1 r21, Integer r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r2 = 0;
    L6:
        String r6 = "";
        if ((r23 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r23 & 4) != 0) goto L15;
        r6 = r18;
    L15:
        if ((r23 & 16) == 0) goto L17;
        g1 r7 = new g1("", "", null, null, 28);
    L19:
        if ((r23 & 32) == 0) goto L21;
        g1 r8 = new g1("", "", null, null, 28);
    L23:
        if ((r23 & 64) == 0) goto L25;
        g1 r9 = new g1("", "", null, null, 28);
    L27:
        if ((r23 & 128) == 0) goto L29;
        Integer r1 = 0;
    L30:
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = null;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r1;
        return;
    L29:
        r1 = r22;
        goto L30
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = r16;
        goto L6
    }

    public f(int r10, long r11, String r13, String r14, Long r15, g1 r16, g1 r17, g1 r18) {
        if ((r10 & 0) == 0) goto L5;
        nuc.b2.b(r10, 0, a.b);
        throw null;
    L5:
        if ((r10 & 1) != 0) goto L7;
        long r5 = 0;
    L8:
        this.a = r5;
        if ((r10 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r10 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r10 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r10 & 16) != 0) goto L23;
        g1 r2 = new g1("", "", null, null, 28);
    L24:
        this.e = r2;
        if ((r10 & 32) != 0) goto L27;
        g1 r3 = new g1("", "", null, null, 28);
    L28:
        this.f = r3;
        if ((r10 & 64) != 0) goto L31;
        g1 r1 = new g1("", "", null, null, 28);
    L32:
        this.g = r1;
        this.h = 0;
        return;
    L31:
        r1 = r18;
        goto L32
    L27:
        r3 = r17;
        goto L28
    L23:
        r2 = r16;
        goto L24
    L19:
        this.d = r15;
        goto L21
    L15:
        this.c = r14;
        goto L17
    L11:
        this.b = r13;
        goto L13
    L7:
        r5 = r11;
        goto L8
    }
}
