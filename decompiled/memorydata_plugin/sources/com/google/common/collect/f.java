package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
abstract class f<C extends Comparable> implements at<C> {
    f() {
    }

    @Override // com.google.common.collect.at
    public void add(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    public void addAll(at<C> r3) {
        addAll(((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin")).asRanges());
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C r3) {
        if (rangeContaining((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin")) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.at
    public abstract boolean encloses(Range<C> r1);

    public boolean enclosesAll(at<C> r3) {
        return a(((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin")).asRanges());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, at.class) == false) goto L9;
        at r4 = (at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.memorydata.plugin");
        return asRanges().equals(r4.asRanges());
    L9:
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public boolean intersects(Range<C> r1) {
        return !subRangeSet(r1).isEmpty();
    }

    @Override // com.google.common.collect.at
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C r1);

    @Override // com.google.common.collect.at
    public void remove(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.at
    public void removeAll(at<C> r3) {
        removeAll(((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin")).asRanges());
    }

    public final String toString() {
        return asRanges().toString();
    }
}
