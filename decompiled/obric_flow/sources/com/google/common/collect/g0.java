package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Collection f8983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Set f8984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient z7 f8985c;
    public transient Collection d;
    public transient Map e;

    public g0() {
    }

    @Override // com.google.common.collect.q7
    public Map<Object, Collection<Object>> asMap() {
        Map<Object, Collection<Object>> r5 = this.e;
        if (r5 != null) goto L6;
        Map<Object, Collection<Object>> r10 = createAsMap();
        this.e = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public boolean containsEntry(Object r5, Object r10) {
        Collection<Object> r11 = asMap().get(r5);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.contains(r10) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.q7
    public boolean containsValue(Object r5) {
        Iterator<Collection<Object>> r10 = asMap().values().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r10.next().contains(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public abstract Map createAsMap();

    public abstract Set createKeySet();

    public abstract z7 createKeys();

    public abstract Collection createValues();

    public abstract Iterator entryIterator();

    public Spliterator<Map.Entry<Object, Object>> entrySpliterator() {
        return Spliterators.spliterator(entryIterator(), size(), this instanceof s8 ? 1 : 0);
    }

    @Override // com.google.common.collect.q7
    public boolean equals(Object r5) {
        if (r5 != this) goto L5;
        return true;
    L5:
        if ((r5 instanceof q7) == true) goto L10;
        return false;
    L10:
        return asMap().equals(((q7) r5).asMap());
    }

    @Override // com.google.common.collect.q7
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.q7
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.q7
    public Set<Object> keySet() {
        Set<Object> r5 = this.f8984b;
        if (r5 != null) goto L6;
        Set<Object> r10 = createKeySet();
        this.f8984b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public z7 keys() {
        z7 r5 = this.f8985c;
        if (r5 != null) goto L6;
        z7 r10 = createKeys();
        this.f8985c = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public boolean putAll(q7 r5) {
        Iterator r10 = r5.entries().iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r10.next();
        r11 = r11 | put(r12.getKey(), r12.getValue());
        goto L4
    L6:
        return r11;
    }

    @Override // com.google.common.collect.q7
    public boolean remove(Object r5, Object r10) {
        Collection<Object> r11 = asMap().get(r5);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.remove(r10) == false) goto L7;
        return true;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<Object> valueIterator() {
        return new q0(entries().iterator(), 1);
    }

    public Spliterator<Object> valueSpliterator() {
        return Spliterators.spliterator(valueIterator(), size(), 0);
    }

    @Override // com.google.common.collect.q7
    public Collection<Object> values() {
        Collection<Object> r5 = this.d;
        if (r5 != null) goto L6;
        Collection<Object> r10 = createValues();
        this.d = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.q7
    public boolean putAll(Object r5, Iterable<Object> r10) {
        r10.getClass();
        if ((r10 instanceof Collection) == false) goto L10;
        Collection r11 = (Collection) r10;
        if (r11.isEmpty() == false) goto L7;
        return false;
    L7:
        if (get(r5).addAll(r11) == true) goto L9;
        return false;
    L9:
        return true;
    L10:
        Iterator<Object> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L13;
        return false;
    L13:
        if (p7.j(get(r5), r12) == true) goto L15;
        return false;
    L15:
        return true;
    }
}
