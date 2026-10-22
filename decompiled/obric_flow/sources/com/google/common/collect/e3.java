package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e3 extends z2 implements l9 {
    public e3() {
    }

    @Override // com.google.common.collect.l9
    public boolean contains(Object r5, Object r10) {
        return delegate().contains(r5, r10);
    }

    @Override // com.google.common.collect.l9
    public boolean containsColumn(Object r5) {
        return delegate().containsColumn(r5);
    }

    @Override // com.google.common.collect.l9
    public boolean containsRow(Object r5) {
        return delegate().containsRow(r5);
    }

    @Override // com.google.common.collect.l9
    public boolean containsValue(Object r5) {
        return delegate().containsValue(r5);
    }

    @Override // com.google.common.collect.z2
    public abstract l9 delegate();

    @Override // com.google.common.collect.l9
    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r5) == true) goto L7;
        return false;
    }

    @Override // com.google.common.collect.l9
    public Object get(Object r5, Object r10) {
        return delegate().get(r5, r10);
    }

    @Override // com.google.common.collect.l9
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.l9
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.l9
    public int size() {
        return delegate().size();
    }
}
