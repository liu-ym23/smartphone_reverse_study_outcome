package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class f3 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashBiMap.BiEntry f8968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g3 f8969b;

    public f3(g3 r5, HashBiMap.BiEntry r10) {
        this.f8969b = r5;
        this.f8968a = r10;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8968a.key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f8968a.value;
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final Object setValue(Object r10) {
        V r5 = this.f8968a.value;
        int r11 = p7.o0(r10);
        if (r11 == this.f8968a.valueHash) goto L5;
    L7:
        g3 r12 = this.f8969b;
        if (HashBiMap.access$400(r12.f, r10, r11) != null) goto L10;
        boolean r13 = true;
    L11:
        com.google.common.base.b0.h("value already present: %s", r13, r10);
        HashBiMap.access$200(r12.f, this.f8968a);
        HashBiMap.BiEntry r14 = this.f8968a;
        HashBiMap.BiEntry r15 = new HashBiMap.BiEntry(r14.key, r14.keyHash, r10, r11);
        HashBiMap.access$500(r12.f, r15, this.f8968a);
        HashBiMap.BiEntry r16 = this.f8968a;
        r16.prevInKeyInsertionOrder = null;
        r16.nextInKeyInsertionOrder = null;
        r12.f9071c = HashBiMap.access$100(r12.f);
        if (r12.f9070b != this.f8968a) goto L14;
        r12.f9070b = r15;
    L14:
        this.f8968a = r15;
        return r5;
    L10:
        r13 = false;
        goto L11
    L5:
        if (com.google.common.base.b0.w(r10, r5) == false) goto L7;
        return r10;
    }
}
