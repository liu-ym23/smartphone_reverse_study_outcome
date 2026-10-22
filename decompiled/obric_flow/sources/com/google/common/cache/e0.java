package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public class e0 extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0 f8700c;
    public volatile g0 d;

    public e0(Object r5, int r10, v0 r11) {
        this.d = q0.f8743w;
        this.f8698a = r5;
        this.f8699b = r10;
        this.f8700c = r11;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final int getHash() {
        return this.f8699b;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final Object getKey() {
        return this.f8698a;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final v0 getNext() {
        return this.f8700c;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final g0 getValueReference() {
        return this.d;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public final void setValueReference(g0 r5) {
        this.d = r5;
    }
}
