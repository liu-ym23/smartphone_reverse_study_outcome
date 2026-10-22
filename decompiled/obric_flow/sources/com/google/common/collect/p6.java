package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class p6 extends c6 implements x6 {
    public volatile y6 d;

    public p6(Object r5, int r10, p6 r11) {
        super(r5, r10, r11);
        this.d = MapMakerInternalMap.unsetWeakValueReference();
    }

    @Override // com.google.common.collect.h6
    public final Object getValue() {
        return this.d.get();
    }

    @Override // com.google.common.collect.x6
    public final y6 getValueReference() {
        return this.d;
    }
}
