package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedSet<E> extends TransformedCollection<E> implements Set<E> {
    private static final long serialVersionUID = 306127383500410386L;

    public TransformedSet(Set<E> r3, Transformer<? super E, ? extends E> r4) {
        super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Set<E> transformedSet(Set<E> r5, Transformer<? super E, ? extends E> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Transformer r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        TransformedSet r0 = new TransformedSet(r7, r8);
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

    public static <E> TransformedSet<E> transformingSet(Set<E> r2, Transformer<? super E, ? extends E> r3) {
        return new TransformedSet((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (decorated().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return decorated().hashCode();
    }
}
