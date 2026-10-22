package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence<E> elementEquivalence;

    PairwiseEquivalence(Equivalence<E> r3) {
        this.elementEquivalence = (Equivalence) ZeusTransformUtils.preCheckCast(n.a(r3), Equivalence.class, "com.obric.memorydata.plugin");
    }

    public boolean doEquivalent(Iterable<T> r5, Iterable<T> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
        Iterator r10 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        if (r10.hasNext() == false) goto L11;
        Equivalence<E> r0 = this.elementEquivalence;
        Object r2 = r9.next();
        if (r0.equivalent((E) r2, (E) r10.next()) == true) goto L4;
        return false;
    L11:
        if (r9.hasNext() == false) goto L13;
        return false;
    L13:
        if (r10.hasNext() == true) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // com.google.common.base.Equivalence
    public /* synthetic */ boolean doEquivalent(Object r3, Object r4) {
        return doEquivalent((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public int doHash(Iterable<T> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 78721;
    L4:
        if (r5.hasNext() == false) goto L6;
        Object r1 = r5.next();
        r0 = (r0 * 24943) + this.elementEquivalence.hash((E) r1);
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.common.base.Equivalence
    public /* synthetic */ int doHash(Object r3) {
        return doHash((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, PairwiseEquivalence.class) == false) goto L6;
        PairwiseEquivalence r4 = (PairwiseEquivalence) ZeusTransformUtils.preCheckCast(r3, PairwiseEquivalence.class, "com.obric.memorydata.plugin");
        return this.elementEquivalence.equals(r4.elementEquivalence);
    L6:
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }
}
