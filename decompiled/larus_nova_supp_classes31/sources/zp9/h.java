package zp9;

import kotlin.jvm.internal.Intrinsics;
import nuc.m2;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements juc.d<String> {
    public static final h a = null;
    public static final m2 b = null;

    public h() {
    }

    static {
        a = new h();
        b = luc.n.a("FlexibleStringSerializer", luc.e.i.a);
    }

    public final luc.f getDescriptor() {
        return b;
    }

    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        String r1 = null;
        if ((r3 instanceof ouc.h) == false) goto L5;
        ouc.h r0 = (ouc.h) r3;
    L6:
        if (r0 == null) goto L19;
        g0 r4 = r0.a();
        if (Intrinsics.areEqual(r4, ouc.a0.INSTANCE) == true) goto L18;
        if ((r4 instanceof g0) == false) goto L16;
        g0 r5 = r4;
        r1 = ouc.k.g(r5);
        if (r1 != null) goto L18;
        r1 = r5.toString();
        goto L18
    L16:
        r1 = r4.toString();
    L18:
        return r1;
    L19:
        return r3.decodeString();
    L5:
        r0 = null;
        goto L6
    }

    public final void serialize(muc.f r2, Object r3) {
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        if (r4 != null) goto L5;
        r2.encodeNull();
        return;
    L5:
        r2.encodeString(r4);
    }
}
