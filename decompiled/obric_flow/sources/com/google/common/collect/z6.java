package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class z6 extends WeakReference implements y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h6 f9247a;

    public z6(ReferenceQueue r5, Object r10, h6 r11) {
        super(r10, r5);
        this.f9247a = r11;
    }

    @Override // com.google.common.collect.y6
    public final h6 a() {
        return this.f9247a;
    }

    @Override // com.google.common.collect.y6
    public final y6 b(ReferenceQueue r5, x6 r10) {
        return new z6(r5, get(), r10);
    }
}
