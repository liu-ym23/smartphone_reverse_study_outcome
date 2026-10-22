package org.apache.commons.collections4.bag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedSortedBag<E> extends SynchronizedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = 722374056718497858L;

    public SynchronizedSortedBag(Bag<E> r3, Object r4) {
        super((Bag) ZeusTransformUtils.wrapperContextForParams(r3, Bag.class, "com.obric.memorydata.plugin"), r4);
    }

    public SynchronizedSortedBag(SortedBag<E> r3) {
        super((SortedBag) ZeusTransformUtils.wrapperContextForParams(r3, SortedBag.class, "com.obric.memorydata.plugin"));
    }

    public static <E> SynchronizedSortedBag<E> synchronizedSortedBag(SortedBag<E> r2) {
        return new SynchronizedSortedBag((SortedBag) ZeusTransformUtils.wrapperContextForParams(r2, SortedBag.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.SortedBag
    public synchronized Comparator<? super E> comparator() {
        monitor-enter(this);
        Object r0 = this.lock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        Comparator<? super E> r1 = getSortedBag().comparator();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.SortedBag
    public synchronized E first() {
        monitor-enter(this);
        Object r0 = this.lock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        E r1 = getSortedBag().first();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public SortedBag<E> getSortedBag() {
        return (SortedBag) ZeusTransformUtils.preCheckCast(decorated(), SortedBag.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.SortedBag
    public synchronized E last() {
        monitor-enter(this);
        Object r0 = this.lock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        E r1 = getSortedBag().last();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
