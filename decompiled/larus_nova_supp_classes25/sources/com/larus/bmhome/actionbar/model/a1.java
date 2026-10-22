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
public final class a1 {
    public static final b Companion = null;
    public final Long a;
    public final String b;
    public final h0 c;
    public final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<a1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(nuc.g1.a), kuc.a.d(r1), kuc.a.d(h0.a.a), kuc.a.d(r1)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.CustomActionBarOpResult", r0, 4);
            r1.j("item_id", true);
            r1.j("action_bar_key", true);
            r1.j("switch_conf", true);
            r1.j("biz_extra", true);
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
            v2 r4 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r4, null);
            Long r14 = r2;
            h0 r16 = (h0) r0.decodeNullableSerializableElement(r1, 2, h0.a.a, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 3, r4, null);
            String r15 = r5;
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new a1(r13, r14, r15, r16, r17);
        L5:
            String r8 = null;
            h0 r9 = null;
            String r10 = null;
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
            r8 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r8);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r9 = (h0) r0.decodeNullableSerializableElement(r1, 2, h0.a.a, r9);
            r3 = r3 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r10);
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
            a1 r11 = (a1) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = a1.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Long r3 = r11.a;
            if (r3 == null) goto L10;
            if (r3.longValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r12.encodeNullableSerializableElement(r0, 0, nuc.g1.a, r11.a);
        L15:
            if (r12.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r12.encodeNullableSerializableElement(r0, 1, v2.a, r11.b);
        L24:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r12.encodeNullableSerializableElement(r0, 2, h0.a.a, r11.c);
        L33:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            r2 = true;
        L38:
            if (r2 == false) goto L40;
            r12.encodeNullableSerializableElement(r0, 3, v2.a, r11.d);
        L40:
            r12.endStructure(r0);
            return;
        L36:
            if (r11.d == null) goto L38;
        L27:
            if (Intrinsics.areEqual(r11.c, new h0(Boolean.FALSE)) == false) goto L28;
            r6 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r11.b, "") == false) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a1> serializer() {
            return a.a;
        }
    }

    public a1() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a1) == true) goto L8;
        return false;
    L8:
        a1 r6 = (a1) r5;
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
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        h0 r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
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
        return "CustomActionBarOpResult(itemId=" + this.a + ", actionBarKey=" + this.b + ", switchSyncConf=" + this.c + ", bizExtra=" + this.d + ')';
    }

    static {
        Companion = new b();
    }

    public a1(int r5, Long r6, String r7, h0 r8, String r9) {
        if ((r5 & 0) == 0) goto L5;
        nuc.b2.b(r5, 0, a.b);
        throw null;
    L5:
        if ((r5 & 1) != 0) goto L7;
        r6 = 0L;
    L7:
        this.a = r6;
        if ((r5 & 2) != 0) goto L10;
        this.b = "";
    L12:
        if ((r5 & 4) != 0) goto L14;
        this.c = new h0(Boolean.FALSE);
    L16:
        if ((r5 & 8) != 0) goto L18;
        this.d = null;
        return;
    L18:
        this.d = r9;
        return;
    L14:
        this.c = r8;
        goto L16
    L10:
        this.b = r7;
        goto L12
    }

    public a1(Long r3, String r4, h0 r5, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0L;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = new h0(Boolean.FALSE);
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
