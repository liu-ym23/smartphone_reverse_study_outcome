package nuc;

import juc.d;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j3 implements d<ULong> {
    public static final j3 a = null;
    public static final r0 b = null;

    public j3() {
    }

    static {
        a = new j3();
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        b = t0.a("kotlin.ULong", g1.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        return ULong.m200boximpl(ULong.m206constructorimpl(r3.decodeInline(b).decodeLong()));
    }

    @Override // juc.n
    public final void serialize(muc.f r3, Object r4) {
        long r0 = ((ULong) r4).m258unboximpl();
        Intrinsics.checkNotNullParameter(r3, "encoder");
        r3.encodeInline(b).encodeLong(r0);
    }
}
