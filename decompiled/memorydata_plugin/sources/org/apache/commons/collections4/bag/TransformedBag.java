package org.apache.commons.collections4.bag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.set.TransformedSet;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedBag<E> extends TransformedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 5421170911299074185L;

    public TransformedBag(Bag<E> r3, Transformer<? super E, ? extends E> r4) {
        super((Bag) ZeusTransformUtils.wrapperContextForParams(r3, Bag.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Bag<E> transformedBag(Bag<E> r5, Transformer<? super E, ? extends E> r6) {
        Bag r7 = (Bag) ZeusTransformUtils.wrapperContextForParams(r5, Bag.class, "com.obric.memorydata.plugin");
        Transformer r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        TransformedBag r0 = new TransformedBag(r7, r8);
        if (r7.size() <= 0) goto L7;
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r7.toArray(), Object[].class, "com.obric.memorydata.plugin");
        r7.clear();
        int r9 = r1.length;
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L7;
        Object r3 = r1[r2];
        r0.decorated().add(r8.transform(r3));
        r2 = r2 + 1;
    L7:
        return r0;
    }

    public static <E> Bag<E> transformingBag(Bag<E> r2, Transformer<? super E, ? extends E> r3) {
        return new TransformedBag((Bag) ZeusTransformUtils.wrapperContextForParams(r2, Bag.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E r2, int r3) {
        return getBag().add(transform(r2), r3);
    }

    @Override // java.util.Collection
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (decorated().equals(r1) == true) goto L7;
        return false;
    }

    public Bag<E> getBag() {
        return (Bag) ZeusTransformUtils.preCheckCast(decorated(), Bag.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object r1) {
        return getBag().getCount(r1);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object r1, int r2) {
        return getBag().remove(r1, r2);
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return TransformedSet.transformingSet(getBag().uniqueSet(), this.transformer);
    }
}
