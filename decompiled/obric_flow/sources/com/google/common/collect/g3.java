package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class g3 extends m3 {
    public final /* synthetic */ HashBiMap f;

    public g3(HashBiMap r5) {
        this.f = r5;
        super(r5);
    }

    @Override // com.google.common.collect.m3
    public final Object a(HashBiMap.BiEntry r5) {
        return new f3(this, r5);
    }
}
