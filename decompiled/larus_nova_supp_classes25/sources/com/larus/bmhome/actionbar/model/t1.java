package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
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
public final class t1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] b = null;
    public final List<f1> a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<t1> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ParamFilterConf", r0, 1);
            r1.j("conf_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) t1.b[0].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r9) {
            Intrinsics.checkNotNullParameter(r9, "decoder");
            g2 r0 = b;
            muc.c r10 = r9.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = t1.b;
            int r3 = 1;
            List r5 = null;
            if (r10.decodeSequentially() == false) goto L5;
            List r2 = (List) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
        L15:
            r10.endStructure(r0);
            return new t1(r3, r2);
        L5:
            int r4 = 0;
        L6:
            if (r3 == 0) goto L14;
            int r6 = r10.decodeElementIndex(r0);
            if (r6 != (-1)) goto L9;
            r3 = 0;
            goto L6
        L9:
            if (r6 != 0) goto L12;
            r5 = (List) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
            r4 = r4 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r6);
        L14:
            r3 = r4;
            r2 = r5;
            goto L15
        }

        public final void serialize(muc.f r6, Object r7) {
            t1 r8 = (t1) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = t1.b;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            r9.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r8.a);
        L11:
            r9.endStructure(r0);
            return;
        L6:
            if (Intrinsics.areEqual(r8.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t1> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof t1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((t1) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<f1> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "ParamFilterConf(confList=" + this.a + ')';
    }

    static {
        Companion = new b();
        b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.s1())};
    }

    public t1() {
        this.a = new ArrayList();
    }

    public t1(int r2, List r3) {
        if ((r2 & 0) == 0) goto L5;
        nuc.b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.a = new ArrayList();
        return;
    L7:
        this.a = r3;
    }
}
