package com.bytedance.pia.core.misc;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7041a;

    public LRUCache() {
        super(16, 1.0f, true);
        this.f7041a = 16;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry r5) {
        if (size() <= this.f7041a) goto L6;
        return true;
    L6:
        return false;
    }
}
