package com.bytedance.android.live.core.feature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<K, V> {
    public final Map<K, V> a;
    public final ConcurrentLinkedQueue<K> b;
    public final int c;
    public final boolean d;

    public a(int r3) {
        this.c = r3;
        this.d = false;
        this.a = new ConcurrentHashMap(r3, 0.9f);
        this.b = new ConcurrentLinkedQueue();
    }

    public final void a(K r4, V r5) {
        if (r4 == null) goto L19;
        if (r5 != null) goto L6;
        return;
    L6:
        if (((ConcurrentHashMap) this.a).get(r4) == null) goto L9;
        this.b.remove(r4);
        this.b.add(r4);
        ((ConcurrentHashMap) this.a).put(r4, r5);
        return;
    L9:
        if (((ConcurrentHashMap) this.a).size() >= (this.c * 0.8f)) goto L11;
        ((ConcurrentHashMap) this.a).put(r4, r5);
        this.b.add(r4);
        return;
    L11:
        if (this.d == false) goto L13;
        this.b.clear();
        ((ConcurrentHashMap) this.a).clear();
    L16:
        ((ConcurrentHashMap) this.a).put(r4, r5);
        this.b.add(r4);
        return;
    L13:
        K r0 = this.b.poll();
        if (r0 == null) goto L16;
        ((ConcurrentHashMap) this.a).remove(r0);
        goto L16
    }
}
