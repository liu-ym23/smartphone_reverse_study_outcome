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
public final class g1 {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final Integer e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<g1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            nuc.w0 r2 = nuc.w0.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.Icon", r0, 5);
            r1.j("uri", true);
            r1.j("url", true);
            r1.j("width", true);
            r1.j("height", true);
            r1.j("radius", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            nuc.w0 r6 = nuc.w0.a;
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r6, null);
            Integer r7 = (Integer) r0.decodeNullableSerializableElement(r1, 3, r6, null);
            String r17 = r3;
            Integer r18 = r4;
            Integer r20 = (Integer) r0.decodeNullableSerializableElement(r1, 4, r6, null);
            String r16 = r5;
            Integer r19 = r7;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new g1(r15, r16, r17, r18, r19, r20);
        L5:
            String r9 = null;
            Integer r10 = null;
            Integer r11 = null;
            Integer r12 = null;
            int r13 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L22;
            int r110 = r0.decodeElementIndex(r1);
            if (r110 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r110 != 0) goto L10;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r8);
            r13 = r13 | 1;
            goto L6
        L10:
            if (r110 != 1) goto L11;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r9);
            r13 = r13 | 2;
            goto L6
        L11:
            if (r110 != 2) goto L12;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 2, nuc.w0.a, r10);
            r13 = r13 | 4;
            goto L6
        L12:
            if (r110 != 3) goto L13;
            r11 = (Integer) r0.decodeNullableSerializableElement(r1, 3, nuc.w0.a, r11);
            r13 = r13 | 8;
            goto L6
        L13:
            if (r110 != 4) goto L16;
            r12 = (Integer) r0.decodeNullableSerializableElement(r1, 4, nuc.w0.a, r12);
            r13 = r13 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r110);
        L22:
            r15 = r13;
            r16 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            g1 r9 = (g1) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = g1.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == true) goto L28;
            Integer r5 = r9.c;
            if (r5 == null) goto L28;
            if (r5.intValue() != 0) goto L28;
            boolean r6 = false;
        L30:
            if (r6 == false) goto L33;
            r10.encodeNullableSerializableElement(r0, 2, nuc.w0.a, r9.c);
        L33:
            if (r10.shouldEncodeElementDefault(r0, 3) == true) goto L40;
            Integer r11 = r9.d;
            if (r11 == null) goto L40;
            if (r11.intValue() != 0) goto L40;
            boolean r12 = false;
        L42:
            if (r12 == false) goto L45;
            r10.encodeNullableSerializableElement(r0, 3, nuc.w0.a, r9.d);
        L45:
            if (r10.shouldEncodeElementDefault(r0, 4) == true) goto L52;
            Integer r13 = r9.e;
            if (r13 == null) goto L52;
            if (r13.intValue() != 4) goto L52;
        L53:
            if (r2 == false) goto L55;
            r10.encodeNullableSerializableElement(r0, 4, nuc.w0.a, r9.e);
        L55:
            r10.endStructure(r0);
            return;
        L52:
            r2 = true;
        L40:
            r12 = true;
        L28:
            r6 = true;
            goto L30
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

        public final juc.d<g1> serializer() {
            return a.a;
        }
    }

    public g1() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r6 = (g1) r5;
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
        Integer r7 = this.c;
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
        return "Icon(uri=" + this.a + ", url=" + this.b + ", width=" + this.c + ", height=" + this.d + ", radius=" + this.e + ')';
    }

    static {
        Companion = new b();
    }

    public g1(String r4, String r5, Integer r6, Integer r7, int r8) {
        Integer r1 = null;
        if ((r8 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r7 = 0;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r1 = 4;
    L17:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r1;
    }

    public g1(int r5, String r6, String r7, Integer r8, Integer r9, Integer r10) {
        if ((r5 & 0) == 0) goto L5;
        nuc.b2.b(r5, 0, a.b);
        throw null;
    L5:
        if ((r5 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r5 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r5 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r5 & 8) != 0) goto L19;
        this.d = 0;
    L21:
        if ((r5 & 16) != 0) goto L23;
        this.e = 4;
        return;
    L23:
        this.e = r10;
        return;
    L19:
        this.d = r9;
        goto L21
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
}
