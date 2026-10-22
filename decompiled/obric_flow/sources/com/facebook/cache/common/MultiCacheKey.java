package com.facebook.cache.common;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class MultiCacheKey implements CacheKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f7576a;

    public MultiCacheKey(LinkedList r5) {
        this.f7576a = r5;
    }

    @Override // com.facebook.cache.common.CacheKey
    public final String a() {
        return ((CacheKey) this.f7576a.get(0)).a();
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof MultiCacheKey) == true) goto L8;
        return false;
    L8:
        return this.f7576a.equals(((MultiCacheKey) r5).f7576a);
    }

    public final int hashCode() {
        return this.f7576a.hashCode();
    }

    public final String toString() {
        return "MultiCacheKey:" + this.f7576a.toString();
    }
}
