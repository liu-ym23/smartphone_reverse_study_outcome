package com.larus.canvas.core.impl.sse;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public final String a;
    public final Boolean b;
    public final Long c;
    public final long d;
    public final String e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(v2.a), kuc.a.d(nuc.i.a), kuc.a.d(g1.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.canvas.core.impl.sse.CanvasGetInfoResponse", r0, 3);
            r1.j("content", true);
            r1.j("is_finish", true);
            r1.j("last_seq", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            c r13 = r12.beginStructure(r0);
            String r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            String r1 = (String) r13.decodeNullableSerializableElement(r0, 0, v2.a, null);
            Boolean r3 = (Boolean) r13.decodeNullableSerializableElement(r0, 1, nuc.i.a, null);
            Long r2 = (Long) r13.decodeNullableSerializableElement(r0, 2, g1.a, null);
            int r4 = 7;
        L19:
            r13.endStructure(r0);
            return new j(r4, r1, r3, r2);
        L5:
            Boolean r6 = null;
            Long r7 = null;
            int r8 = 0;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L18;
            int r10 = r13.decodeElementIndex(r0);
            if (r10 != (-1)) goto L9;
            r9 = false;
            goto L6
        L9:
            if (r10 != 0) goto L10;
            r5 = (String) r13.decodeNullableSerializableElement(r0, 0, v2.a, r5);
            r8 = r8 | 1;
            goto L6
        L10:
            if (r10 != 1) goto L11;
            r6 = (Boolean) r13.decodeNullableSerializableElement(r0, 1, nuc.i.a, r6);
            r8 = r8 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r7 = (Long) r13.decodeNullableSerializableElement(r0, 2, g1.a, r7);
            r8 = r8 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r10);
        L18:
            r4 = r8;
            r1 = r5;
            r3 = r6;
            r2 = r7;
            goto L19
        }

        public final void serialize(muc.f r6, Object r7) {
            j r8 = (j) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = j.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, v2.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r9.encodeNullableSerializableElement(r0, 1, nuc.i.a, r8.b);
        L21:
            if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r9.encodeNullableSerializableElement(r0, 2, g1.a, r8.c);
        L28:
            r9.endStructure(r0);
            return;
        L24:
            if (r8.c == null) goto L26;
        L15:
            if (r8.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<j> serializer() {
            return a.a;
        }
    }

    public j() {
        long r2 = 0;
        this(r2, null, 31);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
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
        Boolean r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        long r10 = this.d;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        String r12 = this.e;
        if (r12 == null) goto L19;
        r1 = r12.hashCode();
    L19:
        return r11 + r1;
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
        return "CanvasGetInfoResponse(content=" + this.a + ", isFinish=" + this.b + ", lastSeq=" + this.c + ", bizCode=" + this.d + ", bizMsg=" + this.e + ')';
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ j(long r8, String r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        r8 = 0;
    L5:
        long r4 = r8;
        if ((r11 & 16) == 0) goto L8;
        r10 = null;
    L8:
        this(null, null, null, r4, r10);
    }

    public j(int r3, String r4, Boolean r5, Long r6) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
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
    L16:
        this.d = 0;
        this.e = null;
        return;
    L15:
        this.c = r6;
        goto L16
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }

    public j(String r1, Boolean r2, Long r3, long r4, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
