package com.larus.business.arc.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class l {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] c = null;
    public final long a;
    public final List<y> b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<l> {
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
            g2 r1 = new g2("com.larus.business.arc.api.ArcCallStageSnapshot", r0, 2);
            r1.j("arcDurationMs", false);
            r1.j("stages", false);
            b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{g1.a, l.c[1].getValue()};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            muc.c r13 = r12.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = l.c;
            List r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            long r2 = r13.decodeLongElement(r0, 0);
            List r3 = (List) r13.decodeSerializableElement(r0, 1, (juc.c) r1[1].getValue(), null);
            int r4 = 3;
        L17:
            r13.endStructure(r0);
            return new l(r4, r2, r3);
        L5:
            long r6 = 0;
            int r7 = 0;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L16;
            int r9 = r13.decodeElementIndex(r0);
            if (r9 != (-1)) goto L9;
            r8 = false;
            goto L6
        L9:
            if (r9 != 0) goto L10;
            r6 = r13.decodeLongElement(r0, 0);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r9 != 1) goto L13;
            r5 = (List) r13.decodeSerializableElement(r0, 1, (juc.c) r1[1].getValue(), r5);
            r7 = r7 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r9);
        L16:
            r4 = r7;
            r3 = r5;
            r2 = r6;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            l r8 = (l) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = l.c;
            r9.encodeLongElement(r0, 0, r8.a);
            r9.encodeSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r8.b);
            r9.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ArcCallStageSnapshot(arcDurationMs=" + this.a + ", stages=" + this.b + ')';
    }

    static {
        Companion = new b();
        c = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new k())};
    }

    public l(long r9, List<y> r11) {
        Intrinsics.checkNotNullParameter(r11, "stages");
        this.a = r9;
        this.b = r11;
        if (r9 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L52;
        if (((ArrayList) r11).size() != ArcStage.values().length) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L50;
        Iterator<T> r13 = r11.iterator();
        Long r14 = null;
        int r15 = 0;
    L14:
        if (r13.hasNext() == false) goto L48;
        Object r0 = r13.next();
        int r1 = r15 + 1;
        if (r15 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        y r2 = (y) r0;
        if (r2.a.ordinal() != r15) goto L21;
        boolean r16 = true;
    L22:
        if (r16 == false) goto L47;
        if (r2.b() == false) goto L26;
    L29:
        boolean r17 = true;
    L30:
        if (r17 == false) goto L45;
        if (r2.a() == false) goto L43;
        if (r14 != null) goto L35;
    L38:
        boolean r18 = true;
    L39:
        if (r18 == false) goto L42;
        r14 = Long.valueOf(r2.c);
        goto L43
    L42:
        throw new IllegalArgumentException("executed Arc stages must be ordered and non-overlapping".toString());
    L35:
        if (r2.b >= r14.longValue()) goto L38;
        r18 = false;
    L43:
        r15 = r1;
        goto L14
    L45:
        throw new IllegalArgumentException("executed stage offsets must be within arcDurationMs".toString());
    L26:
        if (r2.c <= this.a) goto L29;
        r17 = false;
        goto L30
    L47:
        throw new IllegalArgumentException("stages must be unique and in fixed enum order".toString());
    L21:
        r16 = false;
        goto L22
    L48:
        return;
    L50:
        throw new IllegalArgumentException("stages must contain every fixed Arc stage exactly once".toString());
    L10:
        r12 = false;
        goto L11
    L52:
        throw new IllegalArgumentException("arcDurationMs must be non-negative".toString());
    L5:
        r10 = false;
        goto L6
    }

    public l(int r9, long r10, List r12) {
        Long r2 = null;
        if (3 != (r9 & 3)) goto L55;
        this.a = r10;
        this.b = r12;
        if (r10 < 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L54;
        if (r12.size() != ArcStage.values().length) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L52;
        Iterator r14 = r12.iterator();
        int r15 = 0;
    L16:
        if (r14.hasNext() == false) goto L50;
        Object r16 = r14.next();
        int r0 = r15 + 1;
        if (r15 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        y r17 = (y) r16;
        if (r17.a.ordinal() != r15) goto L23;
        boolean r18 = true;
    L24:
        if (r18 == false) goto L49;
        if (r17.b() == false) goto L28;
    L31:
        boolean r19 = true;
    L32:
        if (r19 == false) goto L47;
        if (r17.a() == false) goto L45;
        if (r2 != null) goto L37;
    L40:
        boolean r110 = true;
    L41:
        if (r110 == false) goto L44;
        r2 = Long.valueOf(r17.c);
        goto L45
    L44:
        throw new IllegalArgumentException("executed Arc stages must be ordered and non-overlapping".toString());
    L37:
        if (r17.b >= r2.longValue()) goto L40;
        r110 = false;
    L45:
        r15 = r0;
        goto L16
    L47:
        throw new IllegalArgumentException("executed stage offsets must be within arcDurationMs".toString());
    L28:
        if (r17.c <= this.a) goto L31;
        r19 = false;
        goto L32
    L49:
        throw new IllegalArgumentException("stages must be unique and in fixed enum order".toString());
    L23:
        r18 = false;
        goto L24
    L50:
        return;
    L52:
        throw new IllegalArgumentException("stages must contain every fixed Arc stage exactly once".toString());
    L12:
        r13 = false;
        goto L13
    L54:
        throw new IllegalArgumentException("arcDurationMs must be non-negative".toString());
    L7:
        r11 = false;
        goto L8
    L55:
        b2.b(r9, 3, a.b);
        throw null;
    }
}
