package org.apache.commons.collections4.comparators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class ComparableComparator<E extends Comparable<? super E>> implements Serializable, Comparator<E> {
    public static final ComparableComparator INSTANCE = null;
    private static final long serialVersionUID = -291439688585137865L;

    static {
        INSTANCE = new ComparableComparator();
    }

    public ComparableComparator() {
    }

    public static <E extends Comparable<? super E>> ComparableComparator<E> comparableComparator() {
        return INSTANCE;
    }

    public int compare(E r2, E r3) {
        return ((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(Object r3, Object r4) {
        return compare((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Comparator
    public boolean equals(Object r1) {
        if (this == r1) goto L8;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getClass().equals(getClass()) == false) goto L7;
    L8:
        return true;
    }

    public int hashCode() {
        return 1769708912;
    }
}
