package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class o3 extends a9 {
    public final /* synthetic */ HashBiMap d;

    public o3(HashBiMap r5) {
        this.d = r5;
        super(r5);
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new n3(this.d);
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        int r10 = p7.o0(r5);
        HashBiMap r11 = this.d;
        HashBiMap.BiEntry r12 = HashBiMap.access$300(r11, r5, r10);
        if (r12 != null) goto L6;
        return false;
    L6:
        HashBiMap.access$200(r11, r12);
        r12.prevInKeyInsertionOrder = null;
        r12.nextInKeyInsertionOrder = null;
        return true;
    }
}
