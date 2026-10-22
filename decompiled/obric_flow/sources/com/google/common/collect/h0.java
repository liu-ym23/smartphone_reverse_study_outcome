package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends g7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f9001c;

    public h0(j0 r5) {
        this.f9001c = r5;
        super(1);
    }

    @Override // com.google.common.collect.g7
    public final z7 c() {
        return this.f9001c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.f9001c.elementIterator();
    }
}
