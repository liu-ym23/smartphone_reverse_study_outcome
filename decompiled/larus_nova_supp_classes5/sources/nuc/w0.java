package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class w0 implements d<Integer> {
    public static final w0 a = null;
    public static final m2 b = null;

    public w0() {
    }

    static {
        a = new w0();
        b = new m2("kotlin.Int", luc.e.f.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return Integer.valueOf(r2.decodeInt());
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        int r4 = ((Number) r3).intValue();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeInt(r4);
    }
}
