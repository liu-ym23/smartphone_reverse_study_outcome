package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u2 implements d<Short> {
    public static final u2 a = null;
    public static final m2 b = null;

    public u2() {
    }

    static {
        a = new u2();
        b = new m2("kotlin.Short", luc.e.h.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return Short.valueOf(r2.decodeShort());
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        short r4 = ((Number) r3).shortValue();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeShort(r4);
    }
}
