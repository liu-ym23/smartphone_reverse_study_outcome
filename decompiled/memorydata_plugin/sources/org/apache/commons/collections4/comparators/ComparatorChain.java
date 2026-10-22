package org.apache.commons.collections4.comparators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ComparatorChain<E> implements Serializable, Comparator<E> {
    private static final long serialVersionUID = -721644942746081630L;
    private final List<Comparator<E>> comparatorChain;
    private boolean isLocked;
    private BitSet orderingBits;

    public ComparatorChain() {
        this(new ArrayList(), new BitSet());
    }

    public ComparatorChain(Comparator<E> r3) {
        this((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), false);
    }

    public ComparatorChain(Comparator<E> r4, boolean r5) {
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        this.orderingBits = null;
        this.isLocked = false;
        ArrayList r1 = new ArrayList(1);
        this.comparatorChain = r1;
        r1.add(r6);
        BitSet r7 = new BitSet(1);
        this.orderingBits = r7;
        if (r5 != true) goto L6;
        r7.set(0);
        return;
    }

    public ComparatorChain(List<Comparator<E>> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this(r4, new BitSet(r4.size()));
    }

    public ComparatorChain(List<Comparator<E>> r3, BitSet r4) {
        List<Comparator<E>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.orderingBits = null;
        this.isLocked = false;
        this.comparatorChain = r5;
        this.orderingBits = r4;
    }

    private void checkChainIntegrity() {
        if (this.comparatorChain.size() == 0) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
    }

    private void checkLocked() {
        if (this.isLocked == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
    }

    public void addComparator(Comparator<E> r3) {
        addComparator((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"), false);
    }

    public void addComparator(Comparator<E> r3, boolean r4) {
        Comparator<E> r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        checkLocked();
        this.comparatorChain.add(r5);
        if (r4 != true) goto L6;
        this.orderingBits.set(this.comparatorChain.size() - 1);
        return;
    }

    @Override // java.util.Comparator
    public int compare(E r8, E r9) {
        if (this.isLocked == true) goto L5;
        checkChainIntegrity();
        this.isLocked = true;
    L5:
        Iterator<Comparator<E>> r0 = this.comparatorChain.iterator();
        int r3 = 0;
    L7:
        if (r0.hasNext() == false) goto L17;
        int r4 = ((Comparator) ZeusTransformUtils.preCheckCast(r0.next(), Comparator.class, "com.obric.memorydata.plugin")).compare(r8, r9);
        if (r4 != 0) goto L11;
        r3 = r3 + 1;
        goto L7
    L11:
        if (this.orderingBits.get(r3) != true) goto L15;
        if (r4 <= 0) goto L20;
        return -1;
    L20:
        return 1;
    L15:
        return r4;
    L17:
        return 0;
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
        ComparatorChain r6 = (ComparatorChain) ZeusTransformUtils.preCheckCast(r5, ComparatorChain.class, "com.obric.memorydata.plugin");
        BitSet r2 = this.orderingBits;
        if (r2 != null) goto L16;
        if (r6.orderingBits != null) goto L26;
    L17:
        List<Comparator<E>> r4 = this.comparatorChain;
        if (r4 != null) goto L23;
        if (r6.comparatorChain != null) goto L26;
        return true;
    L23:
        if (r4.equals(r6.comparatorChain) == false) goto L26;
        return true;
    L26:
        return false;
    L16:
        if (r2.equals(r6.orderingBits) == false) goto L26;
    L27:
        return false;
    }

    public int hashCode() {
        List<Comparator<E>> r0 = this.comparatorChain;
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = 0 ^ r0.hashCode();
    L5:
        BitSet r2 = this.orderingBits;
        if (r2 != null) goto L8;
        return r1;
    L8:
        return r1 ^ r2.hashCode();
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setComparator(int r3, Comparator<E> r4) {
        setComparator(r3, (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin"), false);
    }

    public void setComparator(int r3, Comparator<E> r4, boolean r5) {
        Comparator<E> r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        checkLocked();
        this.comparatorChain.set(r3, r6);
        BitSet r2 = this.orderingBits;
        if (r5 != true) goto L5;
        r2.set(r3);
        return;
    L5:
        r2.clear(r3);
    }

    public void setForwardSort(int r1) {
        checkLocked();
        this.orderingBits.clear(r1);
    }

    public void setReverseSort(int r1) {
        checkLocked();
        this.orderingBits.set(r1);
    }

    public int size() {
        return this.comparatorChain.size();
    }
}
