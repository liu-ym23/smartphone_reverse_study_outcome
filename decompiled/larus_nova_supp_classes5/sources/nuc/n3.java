package nuc;

import juc.d;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n3 implements d<Unit> {
    public static final n3 b = null;
    public final /* synthetic */ u1<Unit> a;

    static {
        b = new n3();
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.a.getDescriptor();
    }

    public n3() {
        this.a = new u1(Unit.INSTANCE);
    }

    @Override // juc.c
    public final Object deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        this.a.deserialize(r2);
        return Unit.INSTANCE;
    }

    @Override // juc.n
    public final void serialize(muc.f r2, Object r3) {
        Unit r4 = (Unit) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r4, "value");
        this.a.serialize(r2, r4);
    }
}
