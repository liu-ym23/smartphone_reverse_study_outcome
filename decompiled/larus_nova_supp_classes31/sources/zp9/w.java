package zp9;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Serializable
public final class w {
    public static final b Companion = null;
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<w> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{g1.a, kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.TabTag", r0, 6);
            r1.j("tag_id", true);
            r1.j("tag_name", true);
            r1.j("tag_icon", true);
            r1.j("tag_dark_icon", true);
            r1.j("tag_color", true);
            r1.j("tag_dark_color", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            String r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            long r10 = r0.decodeLongElement(r1, 0);
            v2 r2 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r12 = r3;
            String r14 = r4;
            String r13 = r6;
            long r11 = r10;
            int r8 = 63;
            String r16 = r5;
        L20:
            r0.endStructure(r1);
            return new w(r8, r11, r16, r12, r13, r14, r15);
        L5:
            r12 = null;
            r13 = null;
            long r17 = 0;
            int r7 = 0;
            boolean r18 = true;
            String r19 = null;
            r16 = null;
        L6:
            if (r18 == false) goto L19;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L17:
            r17 = r0.decodeLongElement(r1, 0);
            r7 = r7 | 1;
            goto L6
        L18:
            r18 = false;
            goto L6
        L11:
            r7 = r7 | 32;
            r19 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r19);
            goto L6
        L12:
            r7 = r7 | 16;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r9);
            goto L6
        L13:
            r7 = r7 | 8;
            r13 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r13);
            goto L6
        L14:
            r7 = r7 | 4;
            r12 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r12);
            goto L6
        L15:
            r7 = r7 | 2;
            r16 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r16);
            goto L6
        L19:
            r8 = r7;
            long r110 = r17;
            r14 = r9;
            r15 = r19;
            r11 = r110;
            goto L20
        }

        public final void serialize(muc.f r9, Object r10) {
            w r11 = (w) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = w.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r12.encodeLongElement(r0, 0, r11.a);
        L12:
            if (r12.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r12.encodeNullableSerializableElement(r0, 1, v2.a, r11.b);
        L21:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r12.encodeNullableSerializableElement(r0, 2, v2.a, r11.c);
        L30:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r12.encodeNullableSerializableElement(r0, 3, v2.a, r11.d);
        L39:
            if (r12.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r12.encodeNullableSerializableElement(r0, 4, v2.a, r11.e);
        L48:
            if (r12.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            r2 = true;
        L53:
            if (r2 == false) goto L55;
            r12.encodeNullableSerializableElement(r0, 5, v2.a, r11.f);
        L55:
            r12.endStructure(r0);
            return;
        L51:
            if (r11.f == null) goto L53;
        L42:
            if (r11.e != null) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r11.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r11.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r11.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r11.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<w> serializer() {
            return a.a;
        }
    }

    public w() {
        long r2 = 0;
        this(r2, null, 63);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w) == true) goto L8;
        return false;
    L8:
        w r9 = (w) r8;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
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
        String r9 = this.d;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.e;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.f;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        return r14 + r3;
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
        return "TabTag(id=" + this.a + ", name=" + this.b + ", iconUrl=" + this.c + ", darkIconUrl=" + this.d + ", tagColor=" + this.e + ", tagDarkColor=" + this.f + ')';
    }

    static {
        Companion = new b();
    }

    public final boolean a() {
        if (this.a != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ w(long r9, String r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r9 = 0;
    L5:
        long r1 = r9;
        if ((r12 & 2) == 0) goto L8;
        r11 = "";
    L8:
        this(r1, r11, null, null, null, null);
    }

    public w(long r1, String r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public w(int r3, long r4, String r6, String r7, String r8, String r9, String r10) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = 0;
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = "";
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = null;
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = null;
    L20:
        if ((r3 & 16) != 0) goto L22;
        this.e = null;
    L24:
        if ((r3 & 32) != 0) goto L26;
        this.f = null;
        return;
    L26:
        this.f = r10;
        return;
    L22:
        this.e = r9;
        goto L24
    L18:
        this.d = r8;
        goto L20
    L14:
        this.c = r7;
        goto L16
    L10:
        this.b = r6;
        goto L12
    }
}
