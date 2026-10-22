package com.lynx.tasm.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LRUHashMap<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11157a;

    public LRUHashMap() {
        super(10, 0.75f, true);
        this.f11157a = 10;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry r5) {
        if (size() <= this.f11157a) goto L6;
        return true;
    L6:
        return false;
    }
}
