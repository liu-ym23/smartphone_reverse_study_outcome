package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class ba extends t2 implements Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection f8911a;

    public ba(Collection r5) {
        this.f8911a = r5;
    }

    @Override // com.google.common.collect.z2
    public final Object delegate() {
        return this.f8911a;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object r5) {
        return p7.A(this, r5);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return p7.J(this);
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public final Collection delegate() {
        return this.f8911a;
    }
}
