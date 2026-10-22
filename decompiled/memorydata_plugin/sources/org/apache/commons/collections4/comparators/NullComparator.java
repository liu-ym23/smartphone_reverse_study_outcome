package org.apache.commons.collections4.comparators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.ComparatorUtils;

/* JADX INFO: loaded from: classes6.dex */
public class NullComparator<E> implements Serializable, Comparator<E> {
    private static final long serialVersionUID = -5820772575483504339L;
    private final Comparator<? super E> nonNullComparator;
    private final boolean nullsAreHigh;

    public NullComparator() {
        this(ComparatorUtils.NATURAL_COMPARATOR, true);
    }

    public NullComparator(Comparator<? super E> r3) {
        this((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), true);
    }

    public NullComparator(Comparator<? super E> r3, boolean r4) {
        Comparator<? super E> r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        this.nonNullComparator = r5;
        this.nullsAreHigh = r4;
        Objects.requireNonNull(r5, "null nonNullComparator");
    }

    public NullComparator(boolean r2) {
        this(ComparatorUtils.NATURAL_COMPARATOR, r2);
    }

    @Override // java.util.Comparator
    public int compare(E r3, E r4) {
        if (r3 != r4) goto L6;
        return 0;
    L6:
        if (r3 == null) goto L8;
        if (r4 != null) goto L18;
        if (this.nullsAreHigh == true) goto L16;
        return 1;
    L16:
        return -1;
    L18:
        return this.nonNullComparator.compare(r3, r4);
    L8:
        if (this.nullsAreHigh == false) goto L11;
        return 1;
    L11:
        return -1;
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if (r5.getClass().equals(getClass()) == true) goto L11;
        return false;
    L11:
        NullComparator r6 = (NullComparator) ZeusTransformUtils.preCheckCast(r5, NullComparator.class, "com.obric.memorydata.plugin");
        if (this.nullsAreHigh == r6.nullsAreHigh) goto L14;
        return false;
    L14:
        if (this.nonNullComparator.equals(r6.nonNullComparator) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public int hashCode() {
        if (this.nullsAreHigh == false) goto L5;
        int r0 = -1;
    L7:
        return r0 * this.nonNullComparator.hashCode();
    L5:
        r0 = 1;
        goto L7
    }
}
