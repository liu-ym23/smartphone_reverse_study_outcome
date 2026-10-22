package nuc;

import juc.d;
import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g3 implements d<UInt> {
    public static final g3 a = null;
    public static final r0 b = null;

    public g3() {
    }

    static {
        a = new g3();
        kuc.a.e(IntCompanionObject.INSTANCE);
        b = t0.a("kotlin.UInt", w0.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return UInt.m123boximpl(UInt.m129constructorimpl(r2.decodeInline(b).decodeInt()));
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        int r4 = ((UInt) r3).m181unboximpl();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeInline(b).encodeInt(r4);
    }
}
