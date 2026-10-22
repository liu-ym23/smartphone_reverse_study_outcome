package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.model.ChatDraftItem;
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
public final class c2 {
    public static final b Companion = null;
    public final Integer a;
    public final String b;
    public final g1 c;
    public final g1 d;
    public final String e;
    public final String f;
    public final Long g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<c2> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            g1.a r2 = g1.a.a;
            return new juc.d[]{kuc.a.d(nuc.w0.a), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(nuc.g1.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.SwitchMenuItemTag", r0, 7);
            r1.j("type", true);
            r1.j(ChatDraftItem.TYPE_TEXT, true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("tag_background_color", true);
            r1.j("tag_dark_mode_background_color", true);
            r1.j("tag_expire_time", true);
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
            Integer r2 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, null);
            v2 r6 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 1, r6, null);
            g1.a r11 = g1.a.a;
            g1 r4 = (g1) r0.decodeNullableSerializableElement(r1, 2, r11, null);
            g1 r9 = (g1) r0.decodeNullableSerializableElement(r1, 3, r11, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 4, r6, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 5, r6, null);
            r10 = r2;
            g1 r12 = r4;
            String r14 = r5;
            Long r16 = (Long) r0.decodeNullableSerializableElement(r1, 6, nuc.g1.a, null);
            String r15 = r8;
            String r13 = r7;
            g1 r17 = r9;
            int r19 = 127;
        L23:
            r0.endStructure(r1);
            return new c2(r19, r10, r13, r12, r17, r14, r15, r16);
        L5:
            String r20 = null;
            r13 = null;
            Long r110 = null;
            g1 r111 = null;
            String r112 = null;
            g1 r113 = null;
            int r21 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L22;
            int r22 = r0.decodeElementIndex(r1);
            switch(r22) {
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
            throw new UnknownFieldException(r22);
        L21:
            r3 = 2;
            r114 = false;
            goto L6
        L11:
            r110 = (Long) r0.decodeNullableSerializableElement(r1, 6, nuc.g1.a, r110);
            r21 = r21 | 64;
        L20:
            r3 = 2;
            goto L6
        L12:
            r112 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r112);
            r21 = r21 | 32;
            goto L20
        L13:
            r20 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r20);
            r21 = r21 | 16;
            goto L20
        L14:
            r113 = (g1) r0.decodeNullableSerializableElement(r1, 3, g1.a.a, r113);
            r21 = r21 | 8;
            goto L20
        L15:
            r111 = (g1) r0.decodeNullableSerializableElement(r1, r3, g1.a.a, r111);
            r21 = r21 | 4;
            goto L20
        L17:
            r13 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r13);
            r21 = r21 | 2;
            goto L20
        L19:
            r21 = r21 | 1;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r10);
            goto L20
        L22:
            r19 = r21;
            r16 = r110;
            r12 = r111;
            r17 = r113;
            r15 = r112;
            r14 = r20;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            c2 r9 = (c2) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = c2.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, g1.a.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, g1.a.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            r2 = true;
        L62:
            if (r2 == false) goto L64;
            r10.encodeNullableSerializableElement(r0, 6, nuc.g1.a, r9.g);
        L64:
            r10.endStructure(r0);
            return;
        L60:
            if (r9.g == null) goto L62;
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

        public final juc.d<c2> serializer() {
            return a.a;
        }
    }

    public c2() {
        this(null, null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c2) == true) goto L8;
        return false;
    L8:
        c2 r6 = (c2) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
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
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.g;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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
        return "SwitchMenuItemTag(type=" + this.a + ", text=" + this.b + ", icon=" + this.c + ", darkModeIcon=" + this.d + ", tagBackgroundColor=" + this.e + ", tagDarkModeBackgroundColor=" + this.f + ", tagExpireTime=" + this.g + ')';
    }

    static {
        Companion = new b();
    }

    public final Integer getType() {
        return this.a;
    }

    public c2(Integer r3, String r4, g1 r5, g1 r6, Long r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r8 & 64) == 0) goto L17;
        r7 = null;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = null;
        this.g = r7;
    }

    public c2(int r3, Integer r4, String r5, g1 r6, g1 r7, String r8, String r9, Long r10) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r3 & 64) != 0) goto L31;
        this.g = null;
        return;
    L31:
        this.g = r10;
        return;
    L27:
        this.f = r9;
        goto L29
    L23:
        this.e = r8;
        goto L25
    L19:
        this.d = r7;
        goto L21
    L15:
        this.c = r6;
        goto L17
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
