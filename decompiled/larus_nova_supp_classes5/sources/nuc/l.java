package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l implements d<Byte> {
    public static final l a = null;
    public static final m2 b = null;

    public l() {
    }

    static {
        a = new l();
        b = new m2("kotlin.Byte", luc.e.b.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return Byte.valueOf(r2.decodeByte());
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        byte r4 = ((Number) r3).byteValue();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeByte(r4);
    }
}
