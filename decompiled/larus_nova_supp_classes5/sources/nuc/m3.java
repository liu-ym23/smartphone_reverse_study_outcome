package nuc;

import juc.d;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m3 implements d<UShort> {
    public static final m3 a = null;
    public static final r0 b = null;

    public m3() {
    }

    static {
        a = new m3();
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        b = t0.a("kotlin.UShort", u2.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return UShort.m277boximpl(UShort.m283constructorimpl(r2.decodeInline(b).decodeShort()));
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        short r4 = ((UShort) r3).m333unboximpl();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeInline(b).encodeShort(r4);
    }
}
