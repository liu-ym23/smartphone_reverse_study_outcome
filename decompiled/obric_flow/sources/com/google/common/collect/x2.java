package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x2 extends z2 implements q7 {
    public x2() {
    }

    @Override // com.google.common.collect.q7
    public boolean containsEntry(Object r5, Object r10) {
        return delegate().containsEntry(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public boolean containsKey(Object r5) {
        return delegate().containsKey(r5);
    }

    @Override // com.google.common.collect.q7
    public boolean containsValue(Object r5) {
        return delegate().containsValue(r5);
    }

    @Override // com.google.common.collect.z2
    public abstract q7 delegate();

    @Override // com.google.common.collect.q7
    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r5) == true) goto L7;
        return false;
    }

    @Override // com.google.common.collect.q7
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.q7
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.q7
    public int size() {
        return delegate().size();
    }
}
