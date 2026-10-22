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
public final class q0 {
    public static final b Companion = null;
    public final String a;
    public final o1 b;
    public final Integer c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<q0> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.a), kuc.a.d(o1.a.a), kuc.a.d(nuc.w0.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActiveSwitchMemory", r0, 3);
            r1.j("mode_id", true);
            r1.j("model", true);
            r1.j("reasoning_effort", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            muc.c r13 = r12.beginStructure(r0);
            String r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            String r1 = (String) r13.decodeNullableSerializableElement(r0, 0, v2.a, null);
            o1 r3 = (o1) r13.decodeNullableSerializableElement(r0, 1, o1.a.a, null);
            Integer r2 = (Integer) r13.decodeNullableSerializableElement(r0, 2, nuc.w0.a, null);
            int r4 = 7;
        L19:
            r13.endStructure(r0);
            return new q0(r4, r1, r3, r2);
        L5:
            o1 r6 = null;
            Integer r7 = null;
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
            r6 = (o1) r13.decodeNullableSerializableElement(r0, 1, o1.a.a, r6);
            r8 = r8 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r7 = (Integer) r13.decodeNullableSerializableElement(r0, 2, nuc.w0.a, r7);
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
            q0 r8 = (q0) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = q0.Companion;
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
            r9.encodeNullableSerializableElement(r0, 1, o1.a.a, r8.b);
        L21:
            if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r9.encodeNullableSerializableElement(r0, 2, nuc.w0.a, r8.c);
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

        public final juc.d<q0> serializer() {
            return a.a;
        }
    }

    public q0() {
        this(null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r6 = (q0) r5;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        o1 r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
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
        return "ActiveSwitchMemory(modeId=" + this.a + ", model=" + this.b + ", reasoningEffort=" + this.c + ')';
    }

    static {
        Companion = new b();
    }

    public q0(String r1, o1 r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public q0(int r3, String r4, o1 r5, Integer r6) {
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
