package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface at<C extends Comparable> {
    default boolean a(Iterable<Range<C>> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (encloses((Range) ZeusTransformUtils.preCheckCast(r5.next(), Range.class, "com.obric.memorydata.plugin")) == true) goto L4;
        return false;
    L9:
        return true;
    }

    void add(Range<C> r1);

    default void addAll(Iterable<Range<C>> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        add((Range) ZeusTransformUtils.preCheckCast(r5.next(), Range.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    Set<Range<C>> asRanges();

    at<C> complement();

    boolean encloses(Range<C> r1);

    boolean isEmpty();

    void remove(Range<C> r1);

    void removeAll(at<C> r1);

    default void removeAll(Iterable<Range<C>> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        remove((Range) ZeusTransformUtils.preCheckCast(r5.next(), Range.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    at<C> subRangeSet(Range<C> r1);
}
