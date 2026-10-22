package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y0 f9202b;

    public w0(y0 r5, int r10) {
        this.f9202b = r5;
        this.f9201a = r10;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        y0 r5 = this.f9202b;
        int r10 = this.f9201a;
        return r5.f9227a.keySet().asList().get(r10);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9202b.b(this.f9201a);
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final Object setValue(Object r5) {
        return this.f9202b.c(this.f9201a, r5);
    }
}
