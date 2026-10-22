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
public final class e2 {
    public static final b Companion = null;
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Long d;
    public final Integer e;
    public final l1 f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<e2> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.w0 r1 = nuc.w0.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(nuc.g1.a), kuc.a.d(r1), kuc.a.d(l1.a.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.VideoModelExtInfo", r0, 6);
            r1.j("ref_media_type", true);
            r1.j("max_ref_video_count", true);
            r1.j("max_ref_image_count", true);
            r1.j("max_ref_video_duration", true);
            r1.j("ref_user_avatar_mode", true);
            r1.j("media_info", true);
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
            l1 r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r2 = nuc.w0.a;
            Integer r7 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            Long r8 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, null);
            Integer r14 = (Integer) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            Integer r12 = r4;
            l1 r15 = (l1) r0.decodeNullableSerializableElement(r1, 5, l1.a.a, null);
            Integer r11 = r6;
            Integer r10 = r7;
            Long r13 = r8;
            int r16 = 63;
        L21:
            r0.endStructure(r1);
            return new e2(r16, r10, r11, r12, r13, r14, r15);
        L5:
            r10 = null;
            Long r17 = null;
            r12 = null;
            Integer r19 = null;
            r14 = null;
            int r5 = 0;
            boolean r110 = true;
        L6:
            if (r110 == false) goto L20;
            int r20 = r0.decodeElementIndex(r1);
            switch(r20) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r20);
        L19:
            r3 = 2;
            r110 = false;
            goto L6
        L11:
            r9 = (l1) r0.decodeNullableSerializableElement(r1, 5, l1.a.a, r9);
            r5 = r5 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (Integer) r0.decodeNullableSerializableElement(r1, 4, nuc.w0.a, r14);
            r5 = r5 | 16;
            goto L18
        L13:
            r17 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, r17);
            r5 = r5 | 8;
            goto L18
        L14:
            r12 = (Integer) r0.decodeNullableSerializableElement(r1, r3, nuc.w0.a, r12);
            r5 = r5 | 4;
            goto L18
        L15:
            r19 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, r19);
            r5 = r5 | 2;
            goto L18
        L17:
            r5 = r5 | 1;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r10);
            goto L18
        L20:
            r15 = r9;
            r16 = r5;
            Integer r111 = r19;
            r13 = r17;
            r11 = r111;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            e2 r9 = (e2) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = e2.Companion;
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
            r10.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, nuc.w0.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, nuc.g1.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, nuc.w0.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            r2 = true;
        L53:
            if (r2 == false) goto L55;
            r10.encodeNullableSerializableElement(r0, 5, l1.a.a, r9.f);
        L55:
            r10.endStructure(r0);
            return;
        L51:
            if (r9.f == null) goto L53;
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

        public final juc.d<e2> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e2) == true) goto L8;
        return false;
    L8:
        e2 r6 = (e2) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
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
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        l1 r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "VideoModelExtInfo(refMediaType=" + this.a + ", maxRefVideoCount=" + this.b + ", maxRefImageCount=" + this.c + ", maxVideoDuration=" + this.d + ", refUserAvatarMode=" + this.e + ", mediaInfo=" + this.f + ')';
    }

    static {
        Companion = new b();
    }

    public e2() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public e2(int r3, Integer r4, Integer r5, Integer r6, Long r7, Integer r8, l1 r9) {
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
        return;
    L27:
        this.f = r9;
        return;
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
