package nuc;

import java.lang.annotation.Annotation;
import java.util.List;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import muc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u1<T> implements d<T> {
    public final T a;
    public final List<? extends Annotation> b;
    public final Lazy c;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return (luc.f) this.c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u1(Unit r3) {
        Intrinsics.checkNotNullParameter("kotlin.Unit", "serialName");
        Intrinsics.checkNotNullParameter(r3, "objectInstance");
        this.a = r3;
        this.b = CollectionsKt.emptyList();
        this.c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s1(this));
    }

    @Override // juc.c
    public final T deserialize(muc.e r4) {
        Intrinsics.checkNotNullParameter(r4, "decoder");
        luc.f r0 = getDescriptor();
        c r5 = r4.beginStructure(r0);
        if (r5.decodeSequentially() == true) goto L7;
        int r1 = r5.decodeElementIndex(getDescriptor());
        if (r1 == (-1)) goto L7;
        throw new SerializationException("Unexpected index " + r1);
    L7:
        Unit r2 = Unit.INSTANCE;
        r5.endStructure(r0);
        return this.a;
    }

    @Override // juc.n
    public final void serialize(muc.f r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r3, "value");
        r2.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }
}
