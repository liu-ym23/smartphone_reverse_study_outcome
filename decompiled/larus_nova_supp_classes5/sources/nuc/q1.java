package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class q1 implements d {
    public static final q1 a = null;
    public static final p1 b = null;

    public q1() {
    }

    static {
        a = new q1();
        b = p1.a;
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        throw new SerializationException("'kotlin.Nothing' does not have instances");
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter((Void) r3, "value");
        throw new SerializationException("'kotlin.Nothing' cannot be serialized");
    }
}
