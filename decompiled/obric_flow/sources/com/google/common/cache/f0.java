package com.google.common.cache;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public class f0 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8715a;

    public f0(Object r5) {
        this.f8715a = r5;
    }

    @Override // com.google.common.cache.g0
    public final v0 a() {
        return null;
    }

    @Override // com.google.common.cache.g0
    public final void b(Object r5) {
    }

    @Override // com.google.common.cache.g0
    public int c() {
        return 1;
    }

    @Override // com.google.common.cache.g0
    public final boolean d() {
        return false;
    }

    @Override // com.google.common.cache.g0
    public final g0 e(ReferenceQueue r5, Object r10, v0 r11) {
        return this;
    }

    @Override // com.google.common.cache.g0
    public final Object f() {
        return this.f8715a;
    }

    @Override // com.google.common.cache.g0
    public final Object get() {
        return this.f8715a;
    }

    @Override // com.google.common.cache.g0
    public final boolean isActive() {
        return true;
    }
}
