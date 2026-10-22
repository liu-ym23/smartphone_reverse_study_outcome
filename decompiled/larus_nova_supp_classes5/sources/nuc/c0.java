package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c0 implements d<Duration> {
    public static final c0 a = null;
    public static final m2 b = null;

    public c0() {
    }

    static {
        a = new c0();
        b = new m2("kotlin.time.Duration", luc.e.i.a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        return Duration.m394boximpl(Duration.Companion.m516parseIsoStringUwyO8pc(r3.decodeString()));
    }

    @Override // juc.n
    public final void serialize(muc.f r3, Object r4) {
        long r0 = ((Duration) r4).m451unboximpl();
        Intrinsics.checkNotNullParameter(r3, "encoder");
        r3.encodeString(Duration.m441toIsoStringimpl(r0));
    }
}
