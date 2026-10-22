package nuc;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import muc.d;
import nuc.j2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class l2<Element, Array, Builder extends j2<Array>> extends v<Element, Array, Builder> {
    public final k2 b;

    public abstract Array k();

    public abstract void l(d r1, Array r2, int r3);

    @Override // nuc.a
    public final Object a() {
        return i(k());
    }

    @Override // nuc.v, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.b;
    }

    public l2(juc.d<Element> r2) {
        Intrinsics.checkNotNullParameter(r2, "primitiveSerializer");
        super(r2);
        this.b = new k2(r2.getDescriptor());
    }

    @Override // nuc.a
    public final int b(Object r2) {
        j2 r3 = (j2) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.d();
    }

    @Override // nuc.a
    public final Iterator<Element> d(Array r2) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // nuc.a, juc.c
    public final Array deserialize(muc.e r2) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        return (Array) f(r2);
    }

    @Override // nuc.a
    public final Object j(Object r2) {
        j2 r3 = (j2) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.a();
    }

    @Override // nuc.a
    public final void c(Object r2, int r3) {
        j2 r4 = (j2) r2;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.b(r3);
    }

    @Override // nuc.v, juc.n
    public final void serialize(muc.f r3, Array r4) {
        Intrinsics.checkNotNullParameter(r3, "encoder");
        int r0 = e(r4);
        k2 r1 = this.b;
        d r5 = r3.beginCollection(r1, r0);
        l(r5, r4, r0);
        r5.endStructure(r1);
    }

    public final void insert(Builder r1, int r2, Element r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.v
    public /* bridge */ /* synthetic */ void insert(Object r1, int r2, Object r3) {
        insert((j2) r1, r2, r3);
    }
}
