package nuc;

import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r1<T> implements d<T> {
    public final d<T> a;
    public final p2 b;

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.b;
    }

    public r1(d<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serializer");
        this.a = r2;
        this.b = new p2(r2.getDescriptor());
    }

    @Override // juc.c
    public final T deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        if (r2.decodeNotNullMark() == false) goto L6;
        return (T) r2.decodeSerializableValue(this.a);
    L6:
        return (T) r2.decodeNull();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (r1.class != r5.getClass()) goto L14;
        if (Intrinsics.areEqual(this.a, ((r1) r5).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // juc.n
    public final void serialize(muc.f r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "encoder");
        if (r3 == null) goto L5;
        r2.encodeNotNullMark();
        r2.encodeSerializableValue(this.a, r3);
        return;
    L5:
        r2.encodeNull();
    }
}
