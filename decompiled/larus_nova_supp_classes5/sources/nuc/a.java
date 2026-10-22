package nuc;

import java.util.Iterator;
import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import muc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public abstract class a<Element, Collection, Builder> implements d<Collection> {
    public abstract Builder a();

    public abstract int b(Builder r1);

    public abstract void c(Builder r1, int r2);

    public abstract Iterator<Element> d(Collection r1);

    public abstract int e(Collection r1);

    public abstract void g(c r1, Builder r2, int r3, int r4);

    public abstract void h(c r1, int r2, Builder r3, boolean r4);

    public abstract Builder i(Collection r1);

    public abstract Collection j(Builder r1);

    public a() {
    }

    @Override // juc.c
    public Collection deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return (Collection) f(r2);
    }

    @InternalSerializationApi
    public final Object f(muc.e r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Builder r0 = a();
        int r1 = b(r0);
        c r6 = r5.beginStructure(getDescriptor());
        if (r6.decodeSequentially() == false) goto L5;
        int r2 = r6.decodeCollectionSize(getDescriptor());
        c(r0, r2);
        g(r6, r0, r1, r2);
    L8:
        r6.endStructure(getDescriptor());
        return j(r0);
    L5:
        int r3 = r6.decodeElementIndex(getDescriptor());
        if (r3 == (-1)) goto L8;
        h(r6, r3 + r1, r0, true);
        goto L5
    }
}
