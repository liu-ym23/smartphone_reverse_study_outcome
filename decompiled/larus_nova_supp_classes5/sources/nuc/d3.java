package nuc;

import juc.d;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d3 implements d<UByte> {
    public static final d3 a = null;
    public static final r0 b = null;

    public d3() {
    }

    static {
        a = new d3();
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        b = t0.a("kotlin.UByte", l.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return UByte.m48boximpl(UByte.m54constructorimpl(r2.decodeInline(b).decodeByte()));
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        byte r4 = ((UByte) r3).m104unboximpl();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeInline(b).encodeByte(r4);
    }
}
