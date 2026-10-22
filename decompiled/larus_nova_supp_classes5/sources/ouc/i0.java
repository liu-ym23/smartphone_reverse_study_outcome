package ouc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class i0<T> implements d<T> {
    public final d<T> a;

    public abstract i a(i r1);

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.a.getDescriptor();
    }

    public i0(d<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "tSerializer");
        this.a = r2;
    }

    @Override // juc.c
    public final T deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        h r4 = t.a(r3);
        i r0 = r4.a();
        return (T) r4.getJson().b(this.a, a(r0));
    }

    @Override // juc.n
    public final void serialize(muc.f r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "encoder");
        Intrinsics.checkNotNullParameter(r4, "value");
        u r5 = t.b(r3);
        i r6 = r0.a(r5.getJson(), r4, this.a);
        Intrinsics.checkNotNullParameter(r6, "element");
        r5.a(r6);
    }
}
