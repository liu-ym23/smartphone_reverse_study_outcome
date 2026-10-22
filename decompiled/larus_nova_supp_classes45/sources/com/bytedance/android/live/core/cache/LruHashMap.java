package com.bytedance.android.live.core.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
final class LruHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LruHashMap(int r3) {
        super(r3, 0.75f, true);
        this.capacity = r3;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry r2) {
        if (size() <= this.capacity) goto L5;
        return true;
    L5:
        return false;
    }
}
