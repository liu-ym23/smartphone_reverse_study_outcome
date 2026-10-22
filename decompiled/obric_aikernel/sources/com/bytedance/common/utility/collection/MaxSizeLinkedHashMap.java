package com.bytedance.common.utility.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float FACTOR = 0.75f;
    private static final long serialVersionUID = 3805937866184666407L;
    final int mMaxSize;

    public MaxSizeLinkedHashMap(int r10, int r11) {
        this(r10, r11, false);
    }

    public MaxSizeLinkedHashMap(int r10, int r11, boolean r12) {
        super(r11, 0.75f, true);
        this.mMaxSize = r10;
        if (r10 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> r10) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }
}
