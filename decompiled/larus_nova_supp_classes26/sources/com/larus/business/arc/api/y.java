package com.larus.business.arc.api;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
public final class y {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final ArcStage a;
    public final long b;
    public final long c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<y> {
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
            g2 r1 = new g2("com.larus.business.arc.api.ArcStageSnapshot", r0, 3);
            r1.j("stage", false);
            r1.j("startOffsetMs", true);
            r1.j("endOffsetMs", true);
            b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final juc.d<?>[] childSerializers() {
            g1 r0 = g1.a;
            return new juc.d[]{y.d[0].getValue(), r0, r0};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r21) {
            Intrinsics.checkNotNullParameter(r21, "decoder");
            g2 r1 = b;
            muc.c r0 = r21.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = y.d;
            if (r0.decodeSequentially() == false) goto L5;
            ArcStage r3 = (ArcStage) r0.decodeSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            long r5 = r0.decodeLongElement(r1, 1);
            ArcStage r15 = r3;
            long r18 = r0.decodeLongElement(r1, 2);
            long r16 = r5;
            int r14 = 7;
        L19:
            r0.endStructure(r1);
            return new y(r14, r15, r16, r18);
        L5:
            long r8 = 0;
            ArcStage r4 = null;
            long r10 = 0;
            int r7 = 0;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L18;
            int r13 = r0.decodeElementIndex(r1);
            if (r13 != (-1)) goto L9;
            r12 = false;
            goto L6
        L9:
            if (r13 != 0) goto L10;
            r4 = (ArcStage) r0.decodeSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r4);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r10 = r0.decodeLongElement(r1, 1);
            r7 = r7 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L14;
            r8 = r0.decodeLongElement(r1, 2);
            r7 = r7 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r13);
        L18:
            r15 = r4;
            r14 = r7;
            r18 = r8;
            r16 = r10;
            goto L19
        }

        public final void serialize(muc.f r10, Object r11) {
            y r12 = (y) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            boolean r2 = false;
            r13.encodeSerializableElement(r0, 0, (juc.n) y.d[0].getValue(), r12.a);
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeLongElement(r0, 1, r12.b);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r13.encodeLongElement(r0, 2, r12.c);
        L19:
            r13.endStructure(r0);
            return;
        L15:
            if (r12.c == (-1)) goto L17;
        L6:
            if (r12.b != (-1)) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<y> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof y) == true) goto L8;
        return false;
    L8:
        y r9 = (y) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "ArcStageSnapshot(stage=" + this.a + ", startOffsetMs=" + this.b + ", endOffsetMs=" + this.c + ')';
    }

    static {
        Companion = new b();
        d = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new x()), null, null};
    }

    public final boolean a() {
        long r0 = this.b;
        if (r0 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.c < r0) goto L7;
        return true;
    }

    public final boolean b() {
        if (this.b == (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.c != (-1)) goto L7;
        return true;
    }

    public y(ArcStage r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        if (b() == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Arc stage offsets must be -1/-1 or a non-negative ordered window".toString());
    L5:
        if (a() == true) goto L8;
        r4 = false;
        goto L9
    }

    public y(int r5, ArcStage r6, long r7, long r9) {
        boolean r1 = true;
        if (1 != (r5 & 1)) goto L22;
        this.a = r6;
        if ((r5 & 2) != 0) goto L7;
        this.b = -1;
    L9:
        if ((r5 & 4) != 0) goto L11;
        this.c = -1;
    L13:
        if (b() == false) goto L15;
    L18:
        if (r1 == false) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("Arc stage offsets must be -1/-1 or a non-negative ordered window".toString());
    L15:
        if (a() == true) goto L18;
        r1 = false;
        goto L18
    L11:
        this.c = r9;
        goto L13
    L7:
        this.b = r7;
        goto L9
    L22:
        b2.b(r5, 1, a.b);
        throw null;
    }
}
