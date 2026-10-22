package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1706a;

    public CachedHashCodeArrayMap() {
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final void clear() {
        this.f1706a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final int hashCode() {
        if (this.f1706a != 0) goto L6;
        this.f1706a = super.hashCode();
    L6:
        return this.f1706a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final Object put(Object r5, Object r10) {
        this.f1706a = 0;
        return super.put(r5, r10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final void putAll(SimpleArrayMap r5) {
        this.f1706a = 0;
        super.putAll(r5);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object removeAt(int r5) {
        this.f1706a = 0;
        return super.removeAt(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap
    public final Object setValueAt(int r5, Object r10) {
        this.f1706a = 0;
        return super.setValueAt(r5, r10);
    }
}
