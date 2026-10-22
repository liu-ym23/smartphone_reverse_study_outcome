package com.larus.avlink.rtc;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class f$a implements m0<f> {
    public static final f$a a = null;
    public static final g2 b = null;

    public f$a() {
    }

    public final juc.d<?>[] childSerializers() {
        return new juc.d[]{kuc.a.d(i.a)};
    }

    public final f getDescriptor() {
        return b;
    }

    static {
        f$a r0 = new f$a();
        a = r0;
        g2 r1 = new g2("com.larus.avlink.rtc.MMTDowngradeConfig", r0, 1);
        r1.j("disable_mmt", true);
        b = r1;
    }

    public final juc.d<?>[] typeParametersSerializers() {
        return i2.a;
    }

    public final Object deserialize(muc.e r8) {
        Intrinsics.checkNotNullParameter(r8, "decoder");
        g2 r0 = b;
        c r9 = r8.beginStructure(r0);
        int r2 = 1;
        Boolean r4 = null;
        if (r9.decodeSequentially() == false) goto L5;
        Boolean r1 = (Boolean) r9.decodeNullableSerializableElement(r0, 0, i.a, null);
    L15:
        r9.endStructure(r0);
        return new f(r2, r1);
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
        r4 = (Boolean) r9.decodeNullableSerializableElement(r0, 0, i.a, r4);
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
        f r6 = (f) r5;
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r6, "value");
        g2 r0 = b;
        muc.d r7 = r4.beginStructure(r0);
        f.b r1 = f.Companion;
        if (r7.shouldEncodeElementDefault(r0, 0) == false) goto L6;
    L7:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r7.encodeNullableSerializableElement(r0, 0, i.a, r6.a);
    L11:
        r7.endStructure(r0);
        return;
    L6:
        if (r6.a != null) goto L7;
        r2 = false;
        goto L9
    }
}
