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
public final class f2 {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<f2> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            nuc.w0 r2 = nuc.w0.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.VideoUploadCoverInfo", r0, 4);
            r1.j("url", true);
            r1.j("local_path", true);
            r1.j("height", true);
            r1.j("width", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            String r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            nuc.w0 r5 = nuc.w0.a;
            String r15 = r3;
            Integer r16 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r5, null);
            String r14 = r4;
            Integer r17 = (Integer) r0.decodeNullableSerializableElement(r1, 3, r5, null);
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new f2(r13, r14, r15, r16, r17);
        L5:
            String r8 = null;
            Integer r9 = null;
            Integer r10 = null;
            int r6 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r7 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r7);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r8);
            r6 = r6 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r9 = (Integer) r0.decodeNullableSerializableElement(r1, 2, nuc.w0.a, r9);
            r6 = r6 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 3, nuc.w0.a, r10);
            r6 = r6 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r13 = r6;
            r14 = r7;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            f2 r9 = (f2) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = f2.Companion;
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
        L41:
            if (r2 == false) goto L43;
            r10.encodeNullableSerializableElement(r0, 3, nuc.w0.a, r9.d);
        L43:
            r10.endStructure(r0);
            return;
        L40:
            r2 = true;
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

        public final juc.d<f2> serializer() {
            return a.a;
        }
    }

    public f2() {
        this(null, null, 0, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f2) == true) goto L8;
        return false;
    L8:
        f2 r6 = (f2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
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
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "VideoUploadCoverInfo(url=" + this.a + ", localPath=" + this.b + ", height=" + this.c + ", width=" + this.d + ')';
    }

    static {
        Companion = new b();
    }

    public f2(String r1, String r2, Integer r3, Integer r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public f2(int r5, String r6, String r7, Integer r8, Integer r9) {
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
        return;
    L19:
        this.d = r9;
        return;
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
