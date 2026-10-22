package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class k0 extends WeakReference implements v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f8725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile g0 f8726c;

    public k0(int r5, v0 r10, Object r11, ReferenceQueue r12) {
        super(r11, r12);
        this.f8726c = q0.f8743w;
        this.f8724a = r5;
        this.f8725b = r10;
    }

    public long getAccessTime() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.v0
    public final int getHash() {
        return this.f8724a;
    }

    @Override // com.google.common.cache.v0
    public final Object getKey() {
        return get();
    }

    @Override // com.google.common.cache.v0
    public final v0 getNext() {
        return this.f8725b;
    }

    public v0 getNextInAccessQueue() {
        throw new UnsupportedOperationException();
    }

    public v0 getNextInWriteQueue() {
        throw new UnsupportedOperationException();
    }

    public v0 getPreviousInAccessQueue() {
        throw new UnsupportedOperationException();
    }

    public v0 getPreviousInWriteQueue() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.v0
    public final g0 getValueReference() {
        return this.f8726c;
    }

    public long getWriteTime() {
        throw new UnsupportedOperationException();
    }

    public void setAccessTime(long r5) {
        throw new UnsupportedOperationException();
    }

    public void setNextInAccessQueue(v0 r5) {
        throw new UnsupportedOperationException();
    }

    public void setNextInWriteQueue(v0 r5) {
        throw new UnsupportedOperationException();
    }

    public void setPreviousInAccessQueue(v0 r5) {
        throw new UnsupportedOperationException();
    }

    public void setPreviousInWriteQueue(v0 r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.v0
    public final void setValueReference(g0 r5) {
        this.f8726c = r5;
    }

    public void setWriteTime(long r5) {
        throw new UnsupportedOperationException();
    }
}
