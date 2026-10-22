package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class j3 extends m3 {
    public final /* synthetic */ HashBiMap.Inverse f;

    public j3(HashBiMap.Inverse r5) {
        this.f = r5;
        super(r5.this$0);
    }

    @Override // com.google.common.collect.m3
    public final Object a(HashBiMap.BiEntry r5) {
        return new i3(this, r5);
    }
}
