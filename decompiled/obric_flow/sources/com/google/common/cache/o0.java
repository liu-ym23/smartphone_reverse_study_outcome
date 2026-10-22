package com.google.common.cache;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8735b;

    public o0(int r5, v0 r10, Object r11, ReferenceQueue r12) {
        super(r12, r11, r10);
        this.f8735b = r5;
    }

    @Override // com.google.common.cache.l0, com.google.common.cache.g0
    public final int c() {
        return this.f8735b;
    }

    @Override // com.google.common.cache.l0, com.google.common.cache.g0
    public final g0 e(ReferenceQueue r5, Object r10, v0 r11) {
        return new o0(this.f8735b, r11, r10, r5);
    }
}
