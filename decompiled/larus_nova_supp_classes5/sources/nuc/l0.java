package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l0 implements d<Float> {
    public static final l0 a = null;
    public static final m2 b = null;

    public l0() {
    }

    static {
        a = new l0();
        b = new m2("kotlin.Float", luc.e.C0025e.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return Float.valueOf(r2.decodeFloat());
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        float r4 = ((Number) r3).floatValue();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeFloat(r4);
    }
}
