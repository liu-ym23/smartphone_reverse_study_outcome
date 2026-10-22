package com.lynx.tasm.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LRUHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public int getCapacity() {
        return this.capacity;
    }

    public LRUHashMap(int r3) {
        super(r3, 0.75f, true);
        this.capacity = r3;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r2) {
        if (size() <= this.capacity) goto L5;
        return true;
    L5:
        return false;
    }
}
