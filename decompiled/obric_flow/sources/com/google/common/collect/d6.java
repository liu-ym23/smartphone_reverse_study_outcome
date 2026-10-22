package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d6 extends WeakReference implements h6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h6 f8939b;

    public d6(ReferenceQueue r5, Object r10, int r11, h6 r12) {
        super(r10, r5);
        this.f8938a = r11;
        this.f8939b = r12;
    }

    @Override // com.google.common.collect.h6
    public final int getHash() {
        return this.f8938a;
    }

    @Override // com.google.common.collect.h6
    public final Object getKey() {
        return get();
    }

    @Override // com.google.common.collect.h6
    public final h6 getNext() {
        return this.f8939b;
    }
}
