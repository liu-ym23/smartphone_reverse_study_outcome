package com.bytedance.apm6.util.cache;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class LimitedQueue<T> {
    private final int cacheSize;
    private EvictListener<T> evictListener;
    private ConcurrentLinkedQueue<T> queue;

    public interface EvictListener<T> {
        void onEvict(T r10);
    }

    public LimitedQueue(int r10) {
        this.queue = new ConcurrentLinkedQueue();
        this.cacheSize = r10;
    }

    public void clear() {
        this.queue.clear();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public T peek() {
        return this.queue.peek();
    }

    public T pop() {
        return this.queue.poll();
    }

    public void push(T r10) {
        this.queue.add(r10);
        if (this.queue.size() <= this.cacheSize) goto L8;
        T r11 = this.queue.poll();
        EvictListener<T> r12 = this.evictListener;
        if (r12 == null) goto L9;
        r12.onEvict(r11);
        return;
    L9:
        return;
    }

    public void setEvictListener(EvictListener<T> r10) {
        this.evictListener = r10;
    }
}
