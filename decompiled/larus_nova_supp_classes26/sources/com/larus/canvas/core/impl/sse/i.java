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
public final class i {
    public static final b Companion = null;
    public final Long a;
    public final Long b;
    public final String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<i> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            g1 r1 = g1.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(v2.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.canvas.core.impl.sse.CanvasGetInfoRequest", r0, 3);
            r1.j("canvas_id", true);
            r1.j("canvas_sub_id", true);
            r1.j("local_id", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            c r13 = r12.beginStructure(r0);
            Long r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            g1 r1 = g1.a;
            Long r3 = (Long) r13.decodeNullableSerializableElement(r0, 0, r1, null);
            Long r2 = (Long) r13.decodeNullableSerializableElement(r0, 1, r1, null);
            String r4 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, null);
            int r6 = 7;
        L19:
            r13.endStructure(r0);
            return new i(r6, r3, r2, r4);
        L5:
            Long r7 = null;
            String r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r13.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r5 = (Long) r13.decodeNullableSerializableElement(r0, 0, g1.a, r5);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (Long) r13.decodeNullableSerializableElement(r0, 1, g1.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r6 = r9;
            r3 = r5;
            r2 = r7;
            r4 = r8;
            goto L19
        }

        public final void serialize(muc.f r6, Object r7) {
            i r8 = (i) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = i.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, g1.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r9.encodeNullableSerializableElement(r0, 1, g1.a, r8.b);
        L21:
            if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r9.encodeNullableSerializableElement(r0, 2, v2.a, r8.c);
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

        public final d<i> serializer() {
            return a.a;
        }
    }

    public i() {
        this(null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasGetInfoRequest(canvasId=" + this.a + ", canvasSubId=" + this.b + ", localId=" + this.c + ')';
    }

    static {
        Companion = new b();
    }

    public i(Long r1, Long r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public i(int r3, Long r4, Long r5, String r6) {
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
        return;
    L15:
        this.c = r6;
        return;
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
