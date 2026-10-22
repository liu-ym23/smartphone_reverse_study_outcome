package com.google.common.cache;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8733b;

    public m0(int r5, v0 r10, Object r11, ReferenceQueue r12) {
        super(r12, r11, r10);
        this.f8733b = r5;
    }

    @Override // com.google.common.cache.b0, com.google.common.cache.g0
    public final int c() {
        return this.f8733b;
    }

    @Override // com.google.common.cache.b0, com.google.common.cache.g0
    public final g0 e(ReferenceQueue r5, Object r10, v0 r11) {
        return new m0(this.f8733b, r11, r10, r5);
    }
}
