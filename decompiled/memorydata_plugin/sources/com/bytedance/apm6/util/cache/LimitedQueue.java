package com.bytedance.apm6.util.cache;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class LimitedQueue<T> {
    private final int cacheSize;
    private EvictListener<T> evictListener;
    private ConcurrentLinkedQueue<T> queue;

    public interface EvictListener<T> {
        void onEvict(T r1);
    }

    public LimitedQueue(int r2) {
        this.queue = new ConcurrentLinkedQueue();
        this.cacheSize = r2;
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

    public void push(T r2) {
        this.queue.add(r2);
        if (this.queue.size() <= this.cacheSize) goto L8;
        T r3 = this.queue.poll();
        EvictListener<T> r1 = this.evictListener;
        if (r1 == null) goto L9;
        r1.onEvict(r3);
        return;
    L9:
        return;
    }

    public void setEvictListener(EvictListener<T> r3) {
        this.evictListener = (EvictListener) ZeusTransformUtils.wrapperContextForParams(r3, EvictListener.class, "com.obric.memorydata.plugin");
    }
}
