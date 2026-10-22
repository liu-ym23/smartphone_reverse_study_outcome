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
public /* synthetic */ class b$a implements m0<b> {
    public static final b$a a = null;
    public static final g2 b = null;

    public b$a() {
    }

    public final juc.d<?>[] childSerializers() {
        i r1 = i.a;
        return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
    }

    public final f getDescriptor() {
        return b;
    }

    static {
        b$a r0 = new b$a();
        a = r0;
        g2 r1 = new g2("com.larus.avlink.rtc.DoraRtcDowngradeConfig", r0, 3);
        r1.j("downgrade_to_sami", true);
        r1.j("downgrade_conn", true);
        r1.j("disable_radio_quic", true);
        b = r1;
    }

    public final juc.d<?>[] typeParametersSerializers() {
        return i2.a;
    }

    public final Object deserialize(muc.e r12) {
        Intrinsics.checkNotNullParameter(r12, "decoder");
        g2 r0 = b;
        c r13 = r12.beginStructure(r0);
        Boolean r5 = null;
        if (r13.decodeSequentially() == false) goto L5;
        i r1 = i.a;
        Boolean r3 = (Boolean) r13.decodeNullableSerializableElement(r0, 0, r1, null);
        Boolean r4 = (Boolean) r13.decodeNullableSerializableElement(r0, 1, r1, null);
        Boolean r2 = (Boolean) r13.decodeNullableSerializableElement(r0, 2, r1, null);
        int r6 = 7;
    L19:
        r13.endStructure(r0);
        return new b(r6, r3, r4, r2);
    L5:
        Boolean r7 = null;
        Boolean r8 = null;
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
        r5 = (Boolean) r13.decodeNullableSerializableElement(r0, 0, i.a, r5);
        r9 = r9 | 1;
        goto L6
    L10:
        if (r11 != 1) goto L11;
        r7 = (Boolean) r13.decodeNullableSerializableElement(r0, 1, i.a, r7);
        r9 = r9 | 2;
        goto L6
    L11:
        if (r11 != 2) goto L14;
        r8 = (Boolean) r13.decodeNullableSerializableElement(r0, 2, i.a, r8);
        r9 = r9 | 4;
        goto L6
    L14:
        throw new UnknownFieldException(r11);
    L18:
        r6 = r9;
        r3 = r5;
        r4 = r7;
        r2 = r8;
        goto L19
    }

    public final void serialize(muc.f r6, Object r7) {
        b r8 = (b) r7;
        Intrinsics.checkNotNullParameter(r6, "encoder");
        Intrinsics.checkNotNullParameter(r8, "value");
        g2 r0 = b;
        muc.d r9 = r6.beginStructure(r0);
        b.b r1 = b.Companion;
        boolean r2 = false;
        if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
    L7:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        r9.encodeNullableSerializableElement(r0, 0, i.a, r8.a);
    L12:
        if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
    L16:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L21;
        r9.encodeNullableSerializableElement(r0, 1, i.a, r8.b);
    L21:
        if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
    L25:
        r2 = true;
    L26:
        if (r2 == false) goto L28;
        r9.encodeNullableSerializableElement(r0, 2, i.a, r8.c);
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
