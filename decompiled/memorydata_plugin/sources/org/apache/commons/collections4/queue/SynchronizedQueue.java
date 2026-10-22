package org.apache.commons.collections4.queue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Queue;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 1;

    public SynchronizedQueue(Queue<E> r3) {
        super((Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin"));
    }

    public SynchronizedQueue(Queue<E> r3, Object r4) {
        super((Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin"), r4);
    }

    public static <E> SynchronizedQueue<E> synchronizedQueue(Queue<E> r2) {
        return new SynchronizedQueue((Queue) ZeusTransformUtils.wrapperContextForParams(r2, Queue.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection
    public Queue<E> decorated() {
        return (Queue) ZeusTransformUtils.preCheckCast(super.decorated(), Queue.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Queue
    public E element() {
        Object r0 = this.lock;
        monitor-enter(r0);
        E r1 = decorated().element();     // Catch: Throwable -> L7
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
        boolean r1 = decorated().equals(r2);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
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

    @Override // java.util.Queue
    public boolean offer(E r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = decorated().offer(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Queue
    public E peek() {
        Object r0 = this.lock;
        monitor-enter(r0);
        E r1 = decorated().peek();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Queue
    public E poll() {
        Object r0 = this.lock;
        monitor-enter(r0);
        E r1 = decorated().poll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Queue
    public E remove() {
        Object r0 = this.lock;
        monitor-enter(r0);
        E r1 = decorated().remove();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
