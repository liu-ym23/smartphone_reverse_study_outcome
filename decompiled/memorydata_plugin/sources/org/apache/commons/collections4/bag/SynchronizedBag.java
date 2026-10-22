package org.apache.commons.collections4.bag;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedBag<E> extends SynchronizedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 8084674570753837109L;

    class SynchronizedBagSet extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 2990565892366827855L;
        final /* synthetic */ SynchronizedBag this$0;

        SynchronizedBagSet(SynchronizedBag r3, Set<E> r4, Object r5) {
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r6, r5);
        }
    }

    public SynchronizedBag(Bag<E> r3) {
        super((Bag) ZeusTransformUtils.wrapperContextForParams(r3, Bag.class, "com.obric.memorydata.plugin"));
    }

    public SynchronizedBag(Bag<E> r3, Object r4) {
        super((Bag) ZeusTransformUtils.wrapperContextForParams(r3, Bag.class, "com.obric.memorydata.plugin"), r4);
    }

    public static <E> SynchronizedBag<E> synchronizedBag(Bag<E> r2) {
        return new SynchronizedBag((Bag) ZeusTransformUtils.wrapperContextForParams(r2, Bag.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E r2, int r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = getBag().add(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public boolean equals(Object r2) {
        if (r2 != this) goto L5;
        return true;
    L5:
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = getBag().equals(r2);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public Bag<E> getBag() {
        return (Bag) ZeusTransformUtils.preCheckCast(decorated(), Bag.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = getBag().getCount(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public int hashCode() {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = getBag().hashCode();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object r2, int r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = getBag().remove(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        Object r0 = this.lock;
        monitor-enter(r0);
        SynchronizedBagSet r2 = new SynchronizedBagSet(this, getBag().uniqueSet(), this.lock);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }
}
