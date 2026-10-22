package z98;

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
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class k {
    public static final b Companion = null;
    public final Long a;
    public final Integer b;
    public final Integer c;
    public final String d;
    public final String e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<k> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            v2 r2 = v2.a;
            return new juc.d[]{kuc.a.d(g1.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.avlink.model.TracerItem", r0, 5);
            r1.j("time", true);
            r1.j("value", true);
            r1.j("type", true);
            r1.j("event", true);
            r1.j("extra", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            Long r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Long r2 = (Long) r0.decodeNullableSerializableElement(r1, 0, g1.a, null);
            w0 r5 = w0.a;
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r5, null);
            Integer r3 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r5, null);
            v2 r7 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 3, r7, null);
            Long r16 = r2;
            Integer r18 = r3;
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 4, r7, null);
            Integer r17 = r6;
            String r19 = r9;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new k(r15, r16, r17, r18, r19, r20);
        L5:
            Integer r10 = null;
            Integer r11 = null;
            String r12 = null;
            String r13 = null;
            int r4 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L22;
            int r110 = r0.decodeElementIndex(r1);
            if (r110 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r110 != 0) goto L10;
            r8 = (Long) r0.decodeNullableSerializableElement(r1, 0, g1.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r110 != 1) goto L11;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 1, w0.a, r10);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r110 != 2) goto L12;
            r11 = (Integer) r0.decodeNullableSerializableElement(r1, 2, w0.a, r11);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r110 != 3) goto L13;
            r12 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r12);
            r4 = r4 | 8;
            goto L6
        L13:
            if (r110 != 4) goto L16;
            r13 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r13);
            r4 = r4 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r110);
        L22:
            r15 = r4;
            r16 = r8;
            r17 = r10;
            r18 = r11;
            r19 = r12;
            r20 = r13;
            goto L23
        }

        public final void serialize(muc.f r9, Object r10) {
            k r11 = (k) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = k.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Long r3 = r11.a;
            if (r3 == null) goto L10;
            if (r3.longValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r12.encodeNullableSerializableElement(r0, 0, g1.a, r11.a);
        L15:
            if (r12.shouldEncodeElementDefault(r0, 1) == true) goto L22;
            Integer r5 = r11.b;
            if (r5 == null) goto L22;
            if (r5.intValue() != 0) goto L22;
            boolean r6 = false;
        L24:
            if (r6 == false) goto L27;
            r12.encodeNullableSerializableElement(r0, 1, w0.a, r11.b);
        L27:
            if (r12.shouldEncodeElementDefault(r0, 2) == true) goto L34;
            Integer r7 = r11.c;
            if (r7 == null) goto L34;
            if (r7.intValue() != 0) goto L34;
            boolean r8 = false;
        L36:
            if (r8 == false) goto L39;
            r12.encodeNullableSerializableElement(r0, 2, w0.a, r11.c);
        L39:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L42;
        L43:
            boolean r13 = true;
        L45:
            if (r13 == false) goto L48;
            r12.encodeNullableSerializableElement(r0, 3, v2.a, r11.d);
        L48:
            if (r12.shouldEncodeElementDefault(r0, 4) == false) goto L51;
        L52:
            r2 = true;
        L53:
            if (r2 == false) goto L55;
            r12.encodeNullableSerializableElement(r0, 4, v2.a, r11.e);
        L55:
            r12.endStructure(r0);
            return;
        L51:
            if (Intrinsics.areEqual(r11.e, "") == true) goto L53;
        L42:
            if (Intrinsics.areEqual(r11.d, "") == false) goto L43;
            r13 = false;
        L34:
            r8 = true;
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

        public final juc.d<k> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
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
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "TracerItem(time=" + this.a + ", value=" + this.b + ", eventType=" + this.c + ", message=" + this.d + ", extra=" + this.e + ')';
    }

    static {
        Companion = new b();
    }

    public k() {
        this(0L, 0, 0, "", "");
    }

    public k(Long r1, Integer r2, Integer r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public k(int r4, Long r5, Integer r6, Integer r7, String r8, String r9) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        r5 = 0L;
    L7:
        this.a = r5;
        if ((r4 & 2) != 0) goto L10;
        this.b = 0;
    L12:
        if ((r4 & 4) != 0) goto L14;
        this.c = 0;
    L16:
        if ((r4 & 8) != 0) goto L18;
        this.d = "";
    L20:
        if ((r4 & 16) != 0) goto L22;
        this.e = "";
        return;
    L22:
        this.e = r9;
        return;
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
