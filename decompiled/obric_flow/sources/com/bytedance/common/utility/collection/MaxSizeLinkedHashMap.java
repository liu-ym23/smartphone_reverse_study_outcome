package com.bytedance.common.utility.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 3805937866184666407L;
    final int mMaxSize;

    public MaxSizeLinkedHashMap(int r5, int r10) {
        this(r5, r10, false);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r5) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public MaxSizeLinkedHashMap(int r5, int r10, boolean r11) {
        super(r10, 0.75f, true);
        this.mMaxSize = r5;
        if (r5 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("maxSize <= 0");
    }
}
