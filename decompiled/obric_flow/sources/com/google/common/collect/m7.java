package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class m7 extends t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection f9077a;

    public m7(Collection r5) {
        this.f9077a = r5;
    }

    @Override // com.google.common.collect.z2
    public final Object delegate() {
        return this.f9077a;
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new d5(this.f9077a.iterator(), 1);
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public final Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public final Collection delegate() {
        return this.f9077a;
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] r5) {
        return standardToArray(r5);
    }
}
