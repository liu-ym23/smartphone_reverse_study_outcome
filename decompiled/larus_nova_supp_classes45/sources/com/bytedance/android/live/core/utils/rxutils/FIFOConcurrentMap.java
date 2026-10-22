package com.bytedance.android.live.core.utils.rxutils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/core/utils/rxutils/FIFOConcurrentMap;", "K", "V", "", "maxSize", "", "clearCacheOptimize", "", "(IZ)V", "map", "", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "clearCache", "", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "()Ljava/lang/Object;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FIFOConcurrentMap<K, V> {
    private final boolean clearCacheOptimize;
    private final Map<K, V> map;
    private final int maxSize;
    private final ConcurrentLinkedQueue<K> queue;

    public final void clearCache() {
        this.queue.clear();
        this.map.clear();
    }

    public final V remove() {
        K r0 = this.queue.poll();
        if (r0 != null) goto L7;
        return null;
    L7:
        return this.map.remove(r0);
    }

    public final V get(K r2) {
        return this.map.get(r2);
    }

    public FIFOConcurrentMap(int r2, boolean r3) {
        this.maxSize = r2;
        this.clearCacheOptimize = r3;
        this.map = new ConcurrentHashMap(r2, 0.9f);
        this.queue = new ConcurrentLinkedQueue();
    }

    public final void put(K r4, V r5) {
        if (r4 == null) goto L14;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.map.size() >= (this.maxSize * 0.8f)) goto L8;
        this.map.put(r4, r5);
        this.queue.add(r4);
        return;
    L8:
        if (this.clearCacheOptimize == false) goto L10;
        clearCache();
    L11:
        this.map.put(r4, r5);
        this.queue.add(r4);
        return;
    L10:
        remove();
        goto L11
    }

    public /* synthetic */ FIFOConcurrentMap(int r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }
}
