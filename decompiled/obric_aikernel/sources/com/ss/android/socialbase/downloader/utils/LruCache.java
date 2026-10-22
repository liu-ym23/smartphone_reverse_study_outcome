package com.ss.android.socialbase.downloader.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LruCache<K, T> extends LinkedHashMap<K, T> {
    private static final int DEFAULT_SIZE = 4;
    private int mMaxSize;

    public LruCache() {
        this(4, 4);
    }

    public LruCache(int r10, int r11) {
        this(r10, r11, true);
    }

    public LruCache(int r10, int r11, boolean r12) {
        super(r10, 0.75f, r12);
        setMaxSize(r11);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> r10) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public void setMaxSize(int r10) {
        this.mMaxSize = r10;
    }
}
