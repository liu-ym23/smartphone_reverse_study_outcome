package nuc;

import java.util.Iterator;
import juc.d;
import kotlin.jvm.internal.Intrinsics;
import muc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class v<Element, Collection, Builder> extends a<Element, Collection, Builder> {
    public final d<Element> a;

    @Override // juc.d, juc.n, juc.c
    public abstract luc.f getDescriptor();

    public abstract void insert(Builder r1, int r2, Element r3);

    public v(d r1) {
        this.a = r1;
    }

    @Override // juc.n
    public void serialize(muc.f r7, Collection r8) {
        Intrinsics.checkNotNullParameter(r7, "encoder");
        int r0 = e(r8);
        luc.f r1 = getDescriptor();
        muc.d r9 = r7.beginCollection(r1, r0);
        Iterator<Element> r10 = d(r8);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r9.encodeSerializableElement(getDescriptor(), r2, this.a, r10.next());
        r2 = r2 + 1;
        goto L3
    L5:
        r9.endStructure(r1);
    }

    @Override // nuc.a
    public final void g(c r4, Builder r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "decoder");
        if (r7 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        int r2 = 0;
    L8:
        if (r2 >= r7) goto L10;
        h(r4, r6 + r2, r5, false);
        r2 = r2 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.a
    public void h(c r3, int r4, Builder r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        insert(r5, r4, r3.decodeSerializableElement(getDescriptor(), r4, this.a, null));
    }
}
