package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class x1 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompactHashMap f9219c;

    public x1(CompactHashMap r5, int r10) {
        this.f9219c = r5;
        this.f9217a = CompactHashMap.access$100(r5, r10);
        this.f9218b = r10;
    }

    public final void a() {
        int r5 = this.f9218b;
        Object r10 = this.f9217a;
        CompactHashMap r11 = this.f9219c;
        if (r5 != (-1)) goto L5;
    L8:
        this.f9218b = CompactHashMap.access$700(r11, r10);
        return;
    L5:
        if (r5 >= r11.size()) goto L8;
        if (com.google.common.base.b0.w(r10, CompactHashMap.access$100(r11, this.f9218b)) == false) goto L8;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9217a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        CompactHashMap r5 = this.f9219c;
        Map r10 = r5.delegateOrNull();
        if (r10 != null) goto L5;
        a();
        int r11 = this.f9218b;
        if (r11 != (-1)) goto L10;
        return null;
    L10:
        return CompactHashMap.access$800(r5, r11);
    L5:
        return r10.get(this.f9217a);
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final Object setValue(Object r5) {
        CompactHashMap r10 = this.f9219c;
        Map r11 = r10.delegateOrNull();
        Object r12 = this.f9217a;
        if (r11 != null) goto L5;
        a();
        int r13 = this.f9218b;
        if (r13 != (-1)) goto L10;
        r10.put(r12, r5);
        return null;
    L10:
        Object r14 = CompactHashMap.access$800(r10, r13);
        CompactHashMap.access$1300(r10, this.f9218b, r5);
        return r14;
    L5:
        return r11.put(r12, r5);
    }
}
