package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r implements d<Character> {
    public static final r a = null;
    public static final m2 b = null;

    public r() {
    }

    static {
        a = new r();
        b = new m2("kotlin.Char", luc.e.c.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return Character.valueOf(r2.decodeChar());
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        char r4 = ((Character) r3).charValue();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeChar(r4);
    }
}
