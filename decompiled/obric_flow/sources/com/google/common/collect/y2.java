package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y2 extends t2 implements z7 {
    public y2() {
    }

    public int add(Object r5, int r10) {
        return delegate().add(r5, r10);
    }

    @Override // com.google.common.collect.z7
    public int count(Object r5) {
        return delegate().count(r5);
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public abstract z7 delegate();

    @Override // java.util.Collection, com.google.common.collect.z7
    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r5) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, com.google.common.collect.z7
    public int hashCode() {
        return delegate().hashCode();
    }

    public int remove(Object r5, int r10) {
        return delegate().remove(r5, r10);
    }

    public int setCount(Object r5, int r10) {
        return delegate().setCount(r5, r10);
    }

    public boolean standardAdd(Object r5) {
        add(r5, 1);
        return true;
    }

    @Override // com.google.common.collect.t2
    public boolean standardAddAll(Collection<Object> r5) {
        return p7.k(this, r5);
    }

    @Override // com.google.common.collect.t2
    public void standardClear() {
        p7.u(entrySet().iterator());
    }

    @Override // com.google.common.collect.t2
    public boolean standardContains(Object r5) {
        if (count(r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int standardCount(Object r5) {
        Iterator r10 = entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        y7 r11 = (y7) r10.next();
        if (com.google.common.base.b0.w(r11.getElement(), r5) == false) goto L4;
        return r11.getCount();
    L9:
        return 0;
    }

    public boolean standardEquals(Object r5) {
        return p7.z(this, r5);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<Object> standardIterator() {
        return p7.O(this);
    }

    @Override // com.google.common.collect.t2
    public boolean standardRemove(Object r5) {
        if (remove(r5, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.common.collect.t2
    public boolean standardRemoveAll(Collection<?> r5) {
        if ((r5 instanceof z7) == false) goto L6;
        r5 = ((z7) r5).elementSet();
    L6:
        return elementSet().removeAll(r5);
    }

    @Override // com.google.common.collect.t2
    public boolean standardRetainAll(Collection<?> r5) {
        r5.getClass();
        if ((r5 instanceof z7) == false) goto L6;
        r5 = ((z7) r5).elementSet();
    L6:
        return elementSet().retainAll(r5);
    }

    public int standardSetCount(Object r5, int r10) {
        p7.q(r10, "count");
        int r11 = count(r5);
        int r12 = r10 - r11;
        if (r12 <= 0) goto L5;
        add(r5, r12);
    L7:
        return r11;
    L5:
        if (r12 >= 0) goto L7;
        remove(r5, -r12);
        goto L7
    }

    public int standardSize() {
        Iterator r5 = entrySet().iterator();
        long r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        r10 = r10 + ((long) ((y7) r5.next()).getCount());
        goto L4
    L7:
        return dn.a.U(r10);
    }

    @Override // com.google.common.collect.t2
    public String standardToString() {
        return entrySet().toString();
    }

    public boolean setCount(Object r5, int r10, int r11) {
        return delegate().setCount(r5, r10, r11);
    }

    public boolean standardSetCount(Object r5, int r10, int r11) {
        p7.q(r10, "oldCount");
        p7.q(r11, "newCount");
        if (count(r5) != r10) goto L5;
        setCount(r5, r11);
        return true;
    L5:
        return false;
    }
}
