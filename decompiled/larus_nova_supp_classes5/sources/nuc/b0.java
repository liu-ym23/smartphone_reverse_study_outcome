package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b0 implements d<Double> {
    public static final b0 a = null;
    public static final m2 b = null;

    public b0() {
    }

    static {
        a = new b0();
        b = new m2("kotlin.Double", luc.e.d.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        return Double.valueOf(r3.decodeDouble());
    }

    @Override // juc.n
    public final void serialize(muc.f r3, Object r4) {
        double r0 = ((Number) r4).doubleValue();
        Intrinsics.checkNotNullParameter(r3, "encoder");
        r3.encodeDouble(r0);
    }
}
