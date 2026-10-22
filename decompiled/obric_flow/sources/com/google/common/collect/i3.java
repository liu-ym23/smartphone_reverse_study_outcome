package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class i3 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashBiMap.BiEntry f9021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j3 f9022b;

    public i3(j3 r5, HashBiMap.BiEntry r10) {
        this.f9022b = r5;
        this.f9021a = r10;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9021a.value;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9021a.key;
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final Object setValue(Object r10) {
        K r5 = this.f9021a.key;
        int r11 = p7.o0(r10);
        if (r11 == this.f9021a.keyHash) goto L5;
    L7:
        j3 r12 = this.f9022b;
        if (HashBiMap.access$300(r12.f.this$0, r10, r11) != null) goto L10;
        boolean r13 = true;
    L11:
        com.google.common.base.b0.h("value already present: %s", r13, r10);
        HashBiMap.access$200(r12.f.this$0, this.f9021a);
        HashBiMap.BiEntry r14 = this.f9021a;
        HashBiMap.BiEntry r15 = new HashBiMap.BiEntry(r10, r11, r14.value, r14.valueHash);
        this.f9021a = r15;
        HashBiMap.access$500(r12.f.this$0, r15, null);
        r12.f9071c = HashBiMap.access$100(r12.f.this$0);
        return r5;
    L10:
        r13 = false;
        goto L11
    L5:
        if (com.google.common.base.b0.w(r10, r5) == false) goto L7;
        return r10;
    }
}
