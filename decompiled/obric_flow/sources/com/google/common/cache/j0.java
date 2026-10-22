package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends k0 {
    public volatile long d;
    public v0 e;
    public v0 f;
    public volatile long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v0 f8722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v0 f8723i;

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final long getAccessTime() {
        return this.d;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final v0 getNextInAccessQueue() {
        return this.e;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final v0 getNextInWriteQueue() {
        return this.f8722h;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final v0 getPreviousInAccessQueue() {
        return this.f;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final v0 getPreviousInWriteQueue() {
        return this.f8723i;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final long getWriteTime() {
        return this.g;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final void setAccessTime(long r5) {
        this.d = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final void setNextInAccessQueue(v0 r5) {
        this.e = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final void setNextInWriteQueue(v0 r5) {
        this.f8722h = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final void setPreviousInAccessQueue(v0 r5) {
        this.f = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final void setPreviousInWriteQueue(v0 r5) {
        this.f8723i = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public final void setWriteTime(long r5) {
        this.g = r5;
    }
}
