package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class o0 {
    public static final b Companion = null;
    public final Boolean a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<o0> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(nuc.i.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionControl", r0, 1);
            r1.j("disable_click", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r8) {
            Intrinsics.checkNotNullParameter(r8, "decoder");
            g2 r0 = b;
            muc.c r9 = r8.beginStructure(r0);
            int r2 = 1;
            Boolean r4 = null;
            if (r9.decodeSequentially() == false) goto L5;
            Boolean r1 = (Boolean) r9.decodeNullableSerializableElement(r0, 0, nuc.i.a, null);
        L15:
            r9.endStructure(r0);
            return new o0(r2, r1);
        L5:
            int r3 = 0;
        L6:
            if (r2 == 0) goto L14;
            int r5 = r9.decodeElementIndex(r0);
            if (r5 != (-1)) goto L9;
            r2 = 0;
            goto L6
        L9:
            if (r5 != 0) goto L12;
            r4 = (Boolean) r9.decodeNullableSerializableElement(r0, 0, nuc.i.a, r4);
            r3 = r3 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r5);
        L14:
            r2 = r3;
            r1 = r4;
            goto L15
        }

        public final void serialize(muc.f r4, Object r5) {
            o0 r6 = (o0) r5;
            Intrinsics.checkNotNullParameter(r4, "encoder");
            Intrinsics.checkNotNullParameter(r6, "value");
            g2 r0 = b;
            muc.d r7 = r4.beginStructure(r0);
            b r1 = o0.Companion;
            if (r7.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            r7.encodeNullableSerializableElement(r0, 0, nuc.i.a, r6.a);
        L11:
            r7.endStructure(r0);
            return;
        L6:
            if (r6.a != null) goto L7;
            r2 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<o0> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof o0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((o0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "ActionControl(disableClick=" + this.a + ')';
    }

    static {
        Companion = new b();
    }

    public o0() {
        this.a = null;
    }

    public o0(int r3, Boolean r4) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
        return;
    L7:
        this.a = r4;
    }
}
