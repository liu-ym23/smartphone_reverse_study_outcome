package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t2 extends z2 implements Collection {
    public boolean add(Object r5) {
        return delegate().add(r5);
    }

    public boolean addAll(Collection<Object> r5) {
        return delegate().addAll(r5);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object r5) {
        return delegate().contains(r5);
    }

    public boolean containsAll(Collection<?> r5) {
        return delegate().containsAll(r5);
    }

    @Override // com.google.common.collect.z2
    public abstract Collection delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<Object> iterator() {
        return delegate().iterator();
    }

    public boolean remove(Object r5) {
        return delegate().remove(r5);
    }

    public boolean removeAll(Collection<?> r5) {
        return delegate().removeAll(r5);
    }

    public boolean retainAll(Collection<?> r5) {
        return delegate().retainAll(r5);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<Object> r5) {
        return p7.j(this, r5.iterator());
    }

    public void standardClear() {
        p7.u(iterator());
    }

    public boolean standardContains(Object r5) {
        return p7.w(iterator(), r5);
    }

    public boolean standardContainsAll(Collection<?> r5) {
        return p7.x(this, r5);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(Object r5) {
        Iterator<Object> r10 = iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (com.google.common.base.b0.w(r10.next(), r5) == false) goto L4;
        r10.remove();
        return true;
    L9:
        return false;
    }

    public boolean standardRemoveAll(Collection<?> r5) {
        return p7.h0(r5, iterator());
    }

    public boolean standardRetainAll(Collection<?> r5) {
        Iterator<Object> r10 = iterator();
        r5.getClass();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r5.contains(r10.next()) == true) goto L4;
        r10.remove();
        r11 = true;
        goto L4
    L8:
        return r11;
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        int r5 = size();
        p7.q(r5, "size");
        StringBuilder r10 = new StringBuilder((int) Math.min(((long) r5) * 8, 1073741824));
        r10.append('[');
        Iterator r11 = iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        if (r12 == true) goto L8;
        r10.append(", ");
    L8:
        if (r13 != this) goto L10;
        r10.append("(this Collection)");
    L11:
        r12 = false;
        goto L4
    L10:
        r10.append(r13);
        goto L11
    L12:
        r10.append(']');
        return r10.toString();
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] r5) {
        return (T[]) delegate().toArray(r5);
    }

    public <T> T[] standardToArray(T[] r5) {
        return (T[]) p7.s0(this, r5);
    }
}
