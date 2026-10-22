package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v2 extends z2 implements Map {
    public v2() {
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r5) {
        return delegate().containsKey(r5);
    }

    public boolean containsValue(Object r5) {
        return delegate().containsValue(r5);
    }

    @Override // com.google.common.collect.z2
    public abstract Map delegate();

    public Set<Map.Entry<Object, Object>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r5) == true) goto L7;
        return false;
    }

    @Override // java.util.Map
    public Object get(Object r5) {
        return delegate().get(r5);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<Object> keySet() {
        return delegate().keySet();
    }

    public Object put(Object r5, Object r10) {
        return delegate().put(r5, r10);
    }

    public void putAll(Map<Object, Object> r5) {
        delegate().putAll(r5);
    }

    public Object remove(Object r5) {
        return delegate().remove(r5);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        p7.u(entrySet().iterator());
    }

    public boolean standardContainsKey(Object r5) {
        return p7.w(new c7(entrySet().iterator()), r5);
    }

    public boolean standardContainsValue(Object r5) {
        return p7.w(new q0(entrySet().iterator(), 1), r5);
    }

    public boolean standardEquals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if ((r5 instanceof Map) == true) goto L10;
        return false;
    L10:
        return entrySet().equals(((Map) r5).entrySet());
    }

    public int standardHashCode() {
        return p7.J(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<Object, Object> r5) {
        Iterator<Map.Entry<Object, Object>> r10 = r5.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<Object, Object> r11 = r10.next();
        put(r11.getKey(), r11.getValue());
        goto L4
    }

    public Object standardRemove(Object r5) {
        Iterator<Map.Entry<Object, Object>> r10 = entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<Object, Object> r11 = r10.next();
        if (com.google.common.base.b0.w(r11.getKey(), r5) == false) goto L4;
        Object r12 = r11.getValue();
        r10.remove();
        return r12;
    L9:
        return null;
    }

    public String standardToString() {
        return p7.v0(this);
    }

    public Collection<Object> values() {
        return delegate().values();
    }
}
