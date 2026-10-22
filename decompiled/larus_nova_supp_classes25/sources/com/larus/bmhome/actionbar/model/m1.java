package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class m1 {
    public static final b Companion = null;
    public final Long a;
    public final Integer b;
    public final l1 c;
    public MediaAttachment d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<m1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(nuc.g1.a), kuc.a.d(nuc.w0.a), kuc.a.d(l1.a.a), kuc.a.d(MediaAttachment.a.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.MediaSelectorContainerTemplate", r0, 4);
            r1.j("id", true);
            r1.j("media_type", true);
            r1.j("media_info", true);
            r1.j("media_attachment", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            Long r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Long r2 = (Long) r0.decodeNullableSerializableElement(r1, 0, nuc.g1.a, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, null);
            Long r14 = r2;
            l1 r16 = (l1) r0.decodeNullableSerializableElement(r1, 2, l1.a.a, null);
            Integer r15 = r4;
            MediaAttachment r17 = (MediaAttachment) r0.decodeNullableSerializableElement(r1, 3, MediaAttachment.a.a, null);
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new m1(r13, r14, r15, r16, r17);
        L5:
            Integer r8 = null;
            l1 r9 = null;
            MediaAttachment r10 = null;
            int r3 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r7 = (Long) r0.decodeNullableSerializableElement(r1, 0, nuc.g1.a, r7);
            r3 = r3 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, r8);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r9 = (l1) r0.decodeNullableSerializableElement(r1, 2, l1.a.a, r9);
            r3 = r3 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r10 = (MediaAttachment) r0.decodeNullableSerializableElement(r1, 3, MediaAttachment.a.a, r10);
            r3 = r3 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r13 = r3;
            r14 = r7;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            goto L21
        }

        public final void serialize(muc.f r9, Object r10) {
            m1 r11 = (m1) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = m1.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Long r3 = r11.a;
            if (r3 == null) goto L10;
            if (r3.longValue() != (-1)) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r12.encodeNullableSerializableElement(r0, 0, nuc.g1.a, r11.a);
        L15:
            if (r12.shouldEncodeElementDefault(r0, 1) == true) goto L22;
            Integer r5 = r11.b;
            if (r5 == null) goto L22;
            if (r5.intValue() != 0) goto L22;
            boolean r6 = false;
        L24:
            if (r6 == false) goto L27;
            r12.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r11.b);
        L27:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L30;
        L31:
            boolean r7 = true;
        L33:
            if (r7 == false) goto L36;
            r12.encodeNullableSerializableElement(r0, 2, l1.a.a, r11.c);
        L36:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L39;
        L40:
            r2 = true;
        L41:
            if (r2 == false) goto L43;
            r12.encodeNullableSerializableElement(r0, 3, MediaAttachment.a.a, r11.d);
        L43:
            r12.endStructure(r0);
            return;
        L39:
            if (r11.d == null) goto L41;
        L30:
            if (r11.c != null) goto L31;
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

        public final juc.d<m1> serializer() {
            return a.a;
        }
    }

    public m1() {
        this(null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m1) == true) goto L8;
        return false;
    L8:
        m1 r6 = (m1) r5;
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
        l1 r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        MediaAttachment r10 = this.d;
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
        return "MediaSelectorContainerTemplate(id=" + this.a + ", mediaType=" + this.b + ", mediaInfo=" + this.c + ", mediaAttachment=" + this.d + ')';
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ m1(Integer r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        Long r0 = -1L;
    L7:
        if ((r6 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        this(r0, r5, null, null);
        return;
    L5:
        r0 = null;
        goto L7
    }

    public static m1 a(m1 r3, MediaAttachment r4) {
        return new m1(r3.a, r3.b, r3.c, r4);
    }

    public m1(Long r1, Integer r2, l1 r3, MediaAttachment r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public m1(int r6, Long r7, Integer r8, l1 r9, MediaAttachment r10) {
        if ((r6 & 0) == 0) goto L5;
        nuc.b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        r7 = -1L;
    L7:
        this.a = r7;
        if ((r6 & 2) != 0) goto L10;
        this.b = 0;
    L12:
        if ((r6 & 4) != 0) goto L14;
        this.c = null;
    L16:
        if ((r6 & 8) != 0) goto L18;
        this.d = null;
        return;
    L18:
        this.d = r10;
        return;
    L14:
        this.c = r9;
        goto L16
    L10:
        this.b = r8;
        goto L12
    }
}
