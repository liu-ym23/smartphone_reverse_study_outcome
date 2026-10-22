package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends e0 {
    public volatile long e;
    public v0 f;
    public v0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f8695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v0 f8696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v0 f8697j;

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final long getAccessTime() {
        return this.e;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final v0 getNextInAccessQueue() {
        return this.f;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final v0 getNextInWriteQueue() {
        return this.f8696i;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final v0 getPreviousInAccessQueue() {
        return this.g;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final v0 getPreviousInWriteQueue() {
        return this.f8697j;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final long getWriteTime() {
        return this.f8695h;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final void setAccessTime(long r5) {
        this.e = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final void setNextInAccessQueue(v0 r5) {
        this.f = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final void setNextInWriteQueue(v0 r5) {
        this.f8696i = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final void setPreviousInAccessQueue(v0 r5) {
        this.g = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final void setPreviousInWriteQueue(v0 r5) {
        this.f8697j = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final void setWriteTime(long r5) {
        this.f8695h = r5;
    }
}
