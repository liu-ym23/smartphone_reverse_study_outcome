package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class w6 extends d6 implements x6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile y6 f9209c;

    public w6(ReferenceQueue r5, Object r10, int r11, w6 r12) {
        super(r5, r10, r11, r12);
        this.f9209c = MapMakerInternalMap.unsetWeakValueReference();
    }

    @Override // com.google.common.collect.h6
    public final Object getValue() {
        return this.f9209c.get();
    }

    @Override // com.google.common.collect.x6
    public final y6 getValueReference() {
        return this.f9209c;
    }
}
