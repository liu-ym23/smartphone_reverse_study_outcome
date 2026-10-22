package org.apache.commons.collections4.comparators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformingComparator<I, O> implements Serializable, Comparator<I> {
    private static final long serialVersionUID = 3456940356043606220L;
    private final Comparator<O> decorated;
    private final Transformer<? super I, ? extends O> transformer;

    public TransformingComparator(Transformer<? super I, ? extends O> r3) {
        this((Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"), ComparatorUtils.NATURAL_COMPARATOR);
    }

    public TransformingComparator(Transformer<? super I, ? extends O> r3, Comparator<O> r4) {
        Transformer<? super I, ? extends O> r5 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        this.decorated = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        this.transformer = r5;
    }

    @Override // java.util.Comparator
    public int compare(I r2, I r3) {
        O r4 = this.transformer.transform(r2);
        O r5 = this.transformer.transform(r3);
        return this.decorated.compare(r4, r5);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getClass().equals(getClass()) == false) goto L27;
        TransformingComparator r6 = (TransformingComparator) ZeusTransformUtils.preCheckCast(r5, TransformingComparator.class, "com.obric.memorydata.plugin");
        Comparator<O> r2 = this.decorated;
        if (r2 != null) goto L16;
        if (r6.decorated != null) goto L26;
    L17:
        Transformer<? super I, ? extends O> r4 = this.transformer;
        if (r4 != null) goto L23;
        if (r6.transformer != null) goto L26;
        return true;
    L23:
        if (r4.equals(r6.transformer) == false) goto L26;
        return true;
    L26:
        return false;
    L16:
        if (r2.equals(r6.decorated) == false) goto L26;
    L27:
        return false;
    }

    public int hashCode() {
        Comparator<O> r0 = this.decorated;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (629 + r2) * 37;
        Transformer<? super I, ? extends O> r4 = this.transformer;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
