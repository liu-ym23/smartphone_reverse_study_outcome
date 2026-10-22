package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b3 extends t2 implements Set {
    public b3() {
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public abstract Set delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r5) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(Object r5) {
        return p7.A(this, r5);
    }

    public int standardHashCode() {
        return p7.J(this);
    }

    @Override // com.google.common.collect.t2
    public boolean standardRemoveAll(Collection<?> r5) {
        r5.getClass();
        return p7.i0(this, r5);
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }
}
