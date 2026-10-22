package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class l3 extends a9 {
    public final /* synthetic */ HashBiMap.Inverse d;

    public l3(HashBiMap.Inverse r5) {
        this.d = r5;
        super(r5);
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new k3(this.d.this$0);
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        HashBiMap.Inverse r10 = this.d;
        HashBiMap.BiEntry r11 = HashBiMap.access$400(r10.this$0, r5, p7.o0(r5));
        if (r11 != null) goto L6;
        return false;
    L6:
        HashBiMap.access$200(r10.this$0, r11);
        return true;
    }
}
