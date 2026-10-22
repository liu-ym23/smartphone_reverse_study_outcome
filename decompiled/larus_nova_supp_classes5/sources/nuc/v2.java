package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v2 implements d<String> {
    public static final v2 a = null;
    public static final m2 b = null;

    public v2() {
    }

    static {
        a = new v2();
        b = new m2("kotlin.String", luc.e.i.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return r2.decodeString();
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.encodeString(r4);
    }
}
