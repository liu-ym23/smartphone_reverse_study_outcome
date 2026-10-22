package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class b0 extends SoftReference implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f8693a;

    public b0(ReferenceQueue r5, Object r10, v0 r11) {
        super(r10, r5);
        this.f8693a = r11;
    }

    @Override // com.google.common.cache.g0
    public final v0 a() {
        return this.f8693a;
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
    public g0 e(ReferenceQueue r5, Object r10, v0 r11) {
        return new b0(r5, r10, r11);
    }

    @Override // com.google.common.cache.g0
    public final Object f() {
        return get();
    }

    @Override // com.google.common.cache.g0
    public final boolean isActive() {
        return true;
    }
}
