package wa8;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nuc.m2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 implements juc.d<Integer> {
    public static final r1 a = null;
    public static final m2 b = null;

    public r1() {
    }

    static {
        a = new r1();
        b = luc.n.a("NullableIntAsStringSerializer", luc.e.f.a);
    }

    public final luc.f getDescriptor() {
        return b;
    }

    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        Integer r1 = null;
        if ((r3 instanceof ouc.h) == false) goto L5;
        ouc.h r0 = (ouc.h) r3;
    L6:
        if (r0 == null) goto L8;
        ouc.g0 r4 = r0.a();
        if (Intrinsics.areEqual(r4, ouc.a0.INSTANCE) == true) goto L23;
        if ((r4 instanceof ouc.g0) == false) goto L23;
        ouc.g0 r5 = r4;
        Integer r2 = ouc.k.l(r5);
        if (r2 != null) goto L21;
        String r6 = ouc.k.g(r5);
        if (r6 == null) goto L23;
        r1 = StringsKt.toIntOrNull(r6);
        goto L23
    L21:
        r1 = r2;
    L23:
        return r1;
    L8:
        if (r3.decodeNotNullMark() == false) goto L25;
        return Integer.valueOf(r3.decodeInt());
    L25:
        return (Integer) r3.decodeNull();
    L5:
        r0 = null;
        goto L6
    }

    public final void serialize(muc.f r2, Object r3) {
        Integer r4 = (Integer) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        if (r4 != null) goto L5;
        r2.encodeNull();
        return;
    L5:
        r2.encodeInt(r4.intValue());
    }
}
