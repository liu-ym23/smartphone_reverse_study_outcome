package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s0 implements m0<Object> {
    public final /* synthetic */ d<Object> a;

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        return new d[]{this.a};
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // nuc.m0
    public final d<?>[] typeParametersSerializers() {
        return i2.a;
    }

    public s0(d<Object> r1) {
        this.a = r1;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // juc.n
    public final void serialize(muc.f r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "encoder");
        throw new IllegalStateException("unsupported".toString());
    }
}
