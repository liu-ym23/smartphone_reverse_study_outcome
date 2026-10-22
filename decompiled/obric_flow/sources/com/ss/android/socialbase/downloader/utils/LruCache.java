package com.ss.android.socialbase.downloader.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LruCache<K, T> extends LinkedHashMap<K, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16201a;

    public LruCache() {
        super(4, 0.75f, false);
        this.f16201a = 16;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry r5) {
        if (size() <= this.f16201a) goto L6;
        return true;
    L6:
        return false;
    }

    public LruCache(int r5, int r10) {
        super(r5, 0.75f, true);
        this.f16201a = r10;
    }
}
