package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a7 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MapMakerInternalMap f8895c;

    public a7(MapMakerInternalMap r5, Object r10, Object r11) {
        this.f8895c = r5;
        this.f8893a = r10;
        this.f8894b = r11;
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final boolean equals(Object r5) {
        if ((r5 instanceof Map.Entry) == false) goto L10;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        if (this.f8893a.equals(r11) == true) goto L7;
        return false;
    L7:
        if (this.f8894b.equals(r10.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8893a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f8894b;
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final int hashCode() {
        int r5 = this.f8893a.hashCode();
        return this.f8894b.hashCode() ^ r5;
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final Object setValue(Object r5) {
        Object r10 = this.f8895c.put(this.f8893a, r5);
        this.f8894b = r5;
        return r10;
    }
}
