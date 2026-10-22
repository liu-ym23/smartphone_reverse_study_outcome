package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g1 implements d<Long> {
    public static final g1 a = null;
    public static final m2 b = null;

    public g1() {
    }

    static {
        a = new g1();
        b = new m2("kotlin.Long", luc.e.g.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        return Long.valueOf(r3.decodeLong());
    }

    @Override // juc.n
    public final void serialize(muc.f r3, Object r4) {
        long r0 = ((Number) r4).longValue();
        Intrinsics.checkNotNullParameter(r3, "encoder");
        r3.encodeLong(r0);
    }
}
