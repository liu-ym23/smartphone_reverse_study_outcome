package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class q9 extends r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9138c;

    public q9(Object r5, Object r10, Object r11) {
        com.google.common.base.b0.n(r5, "row");
        this.f9136a = r5;
        com.google.common.base.b0.n(r10, "column");
        this.f9137b = r10;
        com.google.common.base.b0.n(r11, "value");
        this.f9138c = r11;
    }

    @Override // com.google.common.collect.k9
    public final Object getColumnKey() {
        return this.f9137b;
    }

    @Override // com.google.common.collect.k9
    public final Object getRowKey() {
        return this.f9136a;
    }

    @Override // com.google.common.collect.k9
    public final Object getValue() {
        return this.f9138c;
    }
}
