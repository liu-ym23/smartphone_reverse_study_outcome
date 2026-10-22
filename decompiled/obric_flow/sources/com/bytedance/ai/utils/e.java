package com.bytedance.ai.utils;

import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache f2847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache f2848b = null;

    static {
        f2847a = new LruCache(10);
        f2848b = new LruCache(10);
    }
}
