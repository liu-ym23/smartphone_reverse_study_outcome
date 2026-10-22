package com.ss.ugc.live.sdk.message.data;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LimitedSizeHashMap<K, V> extends LinkedHashMap<K, V> {
    private int mMaxSize;

    public LimitedSizeHashMap(int r1) {
        this.mMaxSize = r1;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r2) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }
}
