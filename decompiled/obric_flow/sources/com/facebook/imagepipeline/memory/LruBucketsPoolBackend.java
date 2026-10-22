package com.facebook.imagepipeline.memory;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LruBucketsPoolBackend<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f8225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BucketMap f8226b;

    public LruBucketsPoolBackend() {
        this.f8225a = new HashSet();
        this.f8226b = new BucketMap();
    }

    public final Object a(Object r5) {
        if (r5 == null) goto L10;
        monitor-enter(this);
        this.f8225a.remove(r5);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r5;
    L7:
        th = move-exception;
        throw th;
    L10:
        return r5;
    }
}
