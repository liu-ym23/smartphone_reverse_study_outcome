package com.larus.community.impl.api;

import com.larus.platform.api.creation.UserCreation;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Serializable
public final class m {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final boolean a;
    public final Map<String, String> b;
    public final List<UserCreation> c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<m> {
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
            g2 r1 = new g2("com.larus.community.impl.api.CreationRecommendResponse", r0, 3);
            r1.j("has_more", true);
            r1.j("trace_map", true);
            r1.j("creation_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = m.d;
            return new juc.d[]{nuc.i.a, kuc.a.d((juc.d) r0[1].getValue()), kuc.a.d((juc.d) r0[2].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = m.d;
            if (r14.decodeSequentially() == false) goto L5;
            boolean r2 = r14.decodeBooleanElement(r0, 0);
            Map r4 = (Map) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), null);
            List r3 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new m(r5, r2, r4, r3);
        L5:
            Map r7 = null;
            List r8 = null;
            r2 = false;
            int r6 = 0;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L18;
            int r10 = r14.decodeElementIndex(r0);
            if (r10 != (-1)) goto L9;
            r9 = false;
            goto L6
        L9:
            if (r10 != 0) goto L10;
            r2 = r14.decodeBooleanElement(r0, 0);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r10 != 1) goto L11;
            r7 = (Map) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), r7);
            r6 = r6 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r8 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), r8);
            r6 = r6 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r10);
        L18:
            r5 = r6;
            r4 = r7;
            r3 = r8;
            goto L19
        }

        public final void serialize(muc.f r7, Object r8) {
            m r9 = (m) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = m.d;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeBooleanElement(r0, 0, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r10.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r9.c);
        L28:
            r10.endStructure(r0);
            return;
        L24:
            if (r9.c == null) goto L26;
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a == true) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<m> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Map<String, String> r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        List<UserCreation> r6 = this.c;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationRecommendResponse(hasMore=" + this.a + ", traceMap=" + this.b + ", creationList=" + this.c + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        d = new Lazy[]{null, LazyKt.lazy(r1, new k()), LazyKt.lazy(r1, new l())};
    }

    public m() {
        this.a = false;
        this.b = null;
        this.c = null;
    }

    public m(int r4, boolean r5, Map r6, List r7) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = false;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = null;
        return;
    L15:
        this.c = r7;
        return;
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
