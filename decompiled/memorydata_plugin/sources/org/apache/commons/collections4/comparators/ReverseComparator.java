package org.apache.commons.collections4.comparators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ReverseComparator<E> implements Serializable, Comparator<E> {
    private static final long serialVersionUID = 2858887242028539265L;
    private final Comparator<? super E> comparator;

    public ReverseComparator() {
        this(null);
    }

    public ReverseComparator(Comparator<? super E> r3) {
        Comparator<? super E> r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = ComparatorUtils.NATURAL_COMPARATOR;
    L5:
        this.comparator = r4;
    }

    @Override // java.util.Comparator
    public int compare(E r1, E r2) {
        return this.comparator.compare(r2, r1);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r4.getClass().equals(getClass()) == false) goto L12;
        ReverseComparator r5 = (ReverseComparator) ZeusTransformUtils.preCheckCast(r4, ReverseComparator.class, "com.obric.memorydata.plugin");
        return this.comparator.equals(r5.comparator);
    L12:
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode() ^ 175311160;
    }
}
