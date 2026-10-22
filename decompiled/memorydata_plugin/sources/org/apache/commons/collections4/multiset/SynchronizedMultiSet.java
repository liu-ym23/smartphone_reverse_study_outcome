package org.apache.commons.collections4.multiset;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedMultiSet<E> extends SynchronizedCollection<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150629;

    static class SynchronizedSet<T> extends SynchronizedCollection<T> implements Set<T> {
        private static final long serialVersionUID = 20150629;

        SynchronizedSet(Set<T> r3, Object r4) {
            super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    public SynchronizedMultiSet(MultiSet<E> r3) {
        super((MultiSet) ZeusTransformUtils.wrapperContextForParams(r3, MultiSet.class, "com.obric.memorydata.plugin"));
    }

    public SynchronizedMultiSet(MultiSet<E> r3, Object r4) {
        super((MultiSet) ZeusTransformUtils.wrapperContextForParams(r3, MultiSet.class, "com.obric.memorydata.plugin"), r4);
    }

    public static <E> SynchronizedMultiSet<E> synchronizedMultiSet(MultiSet<E> r2) {
        return new SynchronizedMultiSet((MultiSet) ZeusTransformUtils.wrapperContextForParams(r2, MultiSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E r2, int r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = decorated().add(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection
    public MultiSet<E> decorated() {
        return (MultiSet) ZeusTransformUtils.preCheckCast(super.decorated(), MultiSet.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        Object r0 = this.lock;
        monitor-enter(r0);
        SynchronizedSet r2 = new SynchronizedSet(decorated().entrySet(), this.lock);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
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
        boolean r1 = decorated().equals(r2);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = decorated().getCount(r2);     // Catch: Throwable -> L7
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
        int r1 = decorated().hashCode();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object r2, int r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = decorated().remove(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E r2, int r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = decorated().setCount(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        Object r0 = this.lock;
        monitor-enter(r0);
        SynchronizedSet r2 = new SynchronizedSet(decorated().uniqueSet(), this.lock);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }
}
