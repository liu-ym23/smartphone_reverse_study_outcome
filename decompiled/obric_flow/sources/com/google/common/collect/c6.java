package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c6 implements h6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h6 f8925c;

    public c6(Object r5, int r10, h6 r11) {
        this.f8923a = r5;
        this.f8924b = r10;
        this.f8925c = r11;
    }

    @Override // com.google.common.collect.h6
    public final int getHash() {
        return this.f8924b;
    }

    @Override // com.google.common.collect.h6
    public final Object getKey() {
        return this.f8923a;
    }

    @Override // com.google.common.collect.h6
    public final h6 getNext() {
        return this.f8925c;
    }
}
