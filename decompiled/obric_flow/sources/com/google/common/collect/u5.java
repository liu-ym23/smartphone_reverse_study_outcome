package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class u5 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u5 f9184c;
    public u5 d;
    public u5 e;
    public u5 f;

    public u5(Object r5, Object r10) {
        this.f9182a = r5;
        this.f9183b = r10;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9182a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9183b;
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final Object setValue(Object r5) {
        Object r10 = this.f9183b;
        this.f9183b = r5;
        return r10;
    }
}
