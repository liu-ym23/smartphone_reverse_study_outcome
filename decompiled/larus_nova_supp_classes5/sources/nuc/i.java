package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements d<Boolean> {
    public static final i a = null;
    public static final m2 b = null;

    public i() {
    }

    static {
        a = new i();
        b = new m2("kotlin.Boolean", luc.e.a.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return Boolean.valueOf(r2.decodeBoolean());
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        boolean r4 = ((Boolean) r3).booleanValue();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeBoolean(r4);
    }
}
