package com.larus.bmhome.actionbar.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class u1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] c = null;
    public final List<v1> a;
    public final Integer b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<u1> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ReasoningEffortConfig", r0, 2);
            r1.j("option_list", true);
            r1.j("default_level", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) u1.c[0].getValue()), kuc.a.d(nuc.w0.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = u1.c;
            List r5 = null;
            if (r12.decodeSequentially() == false) goto L5;
            List r2 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            Integer r3 = (Integer) r12.decodeNullableSerializableElement(r0, 1, nuc.w0.a, null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new u1(r4, r2, r3);
        L5:
            Integer r6 = null;
            int r7 = 0;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L16;
            int r9 = r12.decodeElementIndex(r0);
            if (r9 != (-1)) goto L9;
            r8 = false;
            goto L6
        L9:
            if (r9 != 0) goto L10;
            r5 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r9 != 1) goto L13;
            r6 = (Integer) r12.decodeNullableSerializableElement(r0, 1, nuc.w0.a, r6);
            r7 = r7 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r9);
        L16:
            r4 = r7;
            r2 = r5;
            r3 = r6;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            u1 r8 = (u1) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = u1.c;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (r8.b == null) goto L17;
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<u1> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r6 = (u1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<v1> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReasoningEffortConfig(optionList=" + this.a + ", defaultLevel=" + this.b + ')';
    }

    static {
        Companion = new b();
        c = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.t1()), null};
    }

    public u1() {
        this.a = null;
        this.b = null;
    }

    public u1(int r3, List r4, Integer r5) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
