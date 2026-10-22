package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class x7 extends j6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Multimaps$MapMultimap f9225c;

    public x7(Multimaps$MapMultimap r5, Object r10) {
        this.f9225c = r5;
        this.f9224b = r10;
        super(1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new w7(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9225c.map.containsKey(this.f9224b) ? 1 : 0;
    }
}
