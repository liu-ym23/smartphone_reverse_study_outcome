package com.larus.community.impl.api;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public final int a;
    public final long b;
    public final long c;
    public final boolean d;
    public final Long e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {
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
            g2 r1 = new g2("com.larus.community.impl.api.CreationRecommendRequest", r0, 10);
            r1.j("recommend_type", true);
            r1.j("page_index", true);
            r1.j("page_size", true);
            r1.j("cold_start", true);
            r1.j("random_seed", true);
            r1.j("tab_id", true);
            r1.j("scene", true);
            r1.j("creation_id", true);
            r1.j("related_recommendation", true);
            r1.j("recent_enter_feed_from", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            g1 r1 = g1.a;
            v2 r2 = v2.a;
            return new juc.d[]{w0.a, r1, r1, nuc.i.a, kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r27) {
            Intrinsics.checkNotNullParameter(r27, "decoder");
            g2 r1 = b;
            muc.c r0 = r27.beginStructure(r1);
            int r3 = 8;
            int r6 = 6;
            if (r0.decodeSequentially() == false) goto L5;
            int r2 = r0.decodeIntElement(r1, 0);
            long r10 = r0.decodeLongElement(r1, 1);
            long r14 = r0.decodeLongElement(r1, 2);
            boolean r4 = r0.decodeBooleanElement(r1, 3);
            Long r8 = (Long) r0.decodeNullableSerializableElement(r1, 4, g1.a, null);
            v2 r9 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 5, r9, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 6, r9, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 7, r9, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 8, r9, null);
            boolean r13 = r4;
            String r16 = r7;
            String r110 = (String) r0.decodeNullableSerializableElement(r1, 9, r9, null);
            long r11 = r10;
            String r17 = r12;
            long r15 = r14;
            int r20 = 1023;
            String r111 = r5;
            Long r112 = r8;
            int r21 = r2;
        L31:
            r0.endStructure(r1);
            return new j(r20, r21, r11, r15, r13, r112, r111, r16, r17, r18, r110);
        L5:
            String r22 = null;
            String r23 = null;
            String r24 = null;
            String r113 = null;
            String r114 = null;
            Long r25 = null;
            long r26 = 0;
            int r28 = 0;
            r13 = false;
            boolean r210 = true;
            long r115 = 0;
            int r116 = 0;
        L6:
            if (r210 == false) goto L30;
            int r30 = r0.decodeElementIndex(r1);
            switch(r30) {
                case -1: goto L29;
                case 0: goto L27;
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L16;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r30);
        L29:
            r3 = 8;
            r6 = 6;
            r210 = false;
            goto L6
        L11:
            r22 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r22);
            int r31 = r116 | 512;
        L14:
            r116 = r31;
            Long r32 = r25;
        L28:
            r25 = r32;
            r28 = r28;
            r3 = 8;
            r6 = 6;
            goto L6
        L12:
            r113 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r113);
            r31 = r116 | 256;
            goto L14
        L13:
            r23 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r23);
            r31 = r116 | 128;
            goto L14
        L16:
            r24 = (String) r0.decodeNullableSerializableElement(r1, r6, v2.a, r24);
            int r33 = r116 | 64;
        L17:
            r32 = r25;
        L20:
            r116 = r33;
        L26:
            r115 = r115;
            goto L28
        L18:
            r114 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r114);
            r33 = r116 | 32;
            goto L17
        L19:
            r32 = (Long) r0.decodeNullableSerializableElement(r1, 4, g1.a, r25);
            r33 = r116 | 16;
            goto L20
        L21:
            r32 = r25;
            r13 = r0.decodeBooleanElement(r1, 3);
            r116 = r116 | 8;
            goto L26
        L24:
            r32 = r25;
            r26 = r0.decodeLongElement(r1, 2);
            r116 = r116 | 4;
            goto L26
        L25:
            r32 = r25;
            r115 = r0.decodeLongElement(r1, 1);
            r116 = r116 | 2;
            goto L26
        L27:
            r32 = r25;
            r28 = r0.decodeIntElement(r1, 0);
            r116 = r116 | 1;
            goto L28
        L30:
            r110 = r22;
            r17 = r23;
            r18 = r113;
            r20 = r116;
            r21 = r28;
            r112 = r25;
            long r211 = r115;
            r16 = r24;
            r111 = r114;
            r11 = r211;
            r15 = r26;
            goto L31
        }

        public final void serialize(muc.f r10, Object r11) {
            j r12 = (j) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            b r1 = j.Companion;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeIntElement(r0, 0, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r13.encodeLongElement(r0, 1, r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r13.encodeLongElement(r0, 2, r12.c);
        L30:
            if (r13.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r13.encodeBooleanElement(r0, 3, r12.d);
        L39:
            if (r13.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r13.encodeNullableSerializableElement(r0, 4, g1.a, r12.e);
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
            r13.encodeNullableSerializableElement(r0, 6, v2.a, r12.g);
        L66:
            if (r13.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r13.encodeNullableSerializableElement(r0, 7, v2.a, r12.h);
        L75:
            if (r13.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r13.encodeNullableSerializableElement(r0, 8, v2.a, r12.i);
        L84:
            if (r13.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            r2 = true;
        L89:
            if (r2 == false) goto L91;
            r13.encodeNullableSerializableElement(r0, 9, v2.a, r12.j);
        L91:
            r13.endStructure(r0);
            return;
        L87:
            if (r12.j == null) goto L89;
        L78:
            if (r12.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r12.h != null) goto L70;
            r14 = false;
            goto L72
        L60:
            if (r12.g != null) goto L61;
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
            if (r12.d != true) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r12.c != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r12.b != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r12.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.a;
        }
    }

    public j() {
        this(0, 0, 0, true, null, null, null, null, null, null);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
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
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
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
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.d == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r4 + r5) * 31;
        Long r7 = this.e;
        int r8 = 0;
        if (r7 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r6 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L13;
        int r12 = 0;
    L14:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L17;
        int r15 = 0;
    L18:
        int r16 = (r13 + r15) * 31;
        String r17 = this.h;
        if (r17 != null) goto L21;
        int r18 = 0;
    L22:
        int r20 = (r16 + r18) * 31;
        String r21 = this.i;
        if (r21 != null) goto L25;
        int r22 = 0;
    L26:
        int r23 = (r20 + r22) * 31;
        String r24 = this.j;
        if (r24 == null) goto L31;
        r8 = r24.hashCode();
    L31:
        return r23 + r8;
    L25:
        r22 = r21.hashCode();
        goto L26
    L21:
        r18 = r17.hashCode();
        goto L22
    L17:
        r15 = r14.hashCode();
        goto L18
    L13:
        r12 = r11.hashCode();
        goto L14
    L9:
        r9 = r7.hashCode();
        goto L10
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationRecommendRequest(recommendType=" + this.a + ", pageIndex=" + this.b + ", pageSize=" + this.c + ", coldStart=" + this.d + ", randomSeed=" + this.e + ", tabId=" + this.f + ", scene=" + this.g + ", creationId=" + this.h + ", relatedRecommendation=" + this.i + ", recentEnterFeedFrom=" + this.j + ')';
    }

    static {
        Companion = new b();
    }

    public j(int r1, long r2, long r4, boolean r6, Long r7, String r8, String r9, String r10, String r11, String r12) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }

    public j(int r8, int r9, long r10, long r12, boolean r14, Long r15, String r16, String r17, String r18, String r110, String r20) {
        if ((r8 & 0) == 0) goto L5;
        b2.b(r8, 0, a.b);
        throw null;
    L5:
        if ((r8 & 1) != 0) goto L7;
        this.a = 0;
    L8:
        long r5 = 0;
        if ((r8 & 2) != 0) goto L11;
        this.b = 0;
    L13:
        if ((r8 & 4) == 0) goto L16;
        r5 = r12;
    L16:
        this.c = r5;
        if ((r8 & 8) != 0) goto L19;
        boolean r2 = true;
    L20:
        this.d = r2;
        if ((r8 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r8 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r8 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r8 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r8 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r8 & 512) != 0) goto L43;
        this.j = null;
        return;
    L43:
        this.j = r20;
        return;
    L39:
        this.i = r110;
        goto L41
    L35:
        this.h = r18;
        goto L37
    L31:
        this.g = r17;
        goto L33
    L27:
        this.f = r16;
        goto L29
    L23:
        this.e = r15;
        goto L25
    L19:
        r2 = r14;
        goto L20
    L11:
        this.b = r10;
        goto L13
    L7:
        this.a = r9;
        goto L8
    }
}
