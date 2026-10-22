package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class n extends o7 {
    public final transient Map d;
    public final /* synthetic */ AbstractMapBasedMultimap e;

    public n(AbstractMapBasedMultimap r5, Map r10) {
        this.e = r5;
        this.d = r10;
    }

    @Override // com.google.common.collect.o7
    public final Set a() {
        return new l(0, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        AbstractMapBasedMultimap r5 = this.e;
        Map r10 = AbstractMapBasedMultimap.access$000(r5);
        if (this.d != r10) goto L5;
        r5.clear();
        return;
    L5:
        p7.u(new m(this));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        return p7.k0(this.d, r5);
    }

    public final Map.Entry d(Map.Entry r5) {
        Object r10 = r5.getKey();
        Collection r11 = (Collection) r5.getValue();
        return new ImmutableEntry(r10, this.e.wrapCollection(r10, r11));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
    L7:
        return true;
    L4:
        if (this.d.equals(r5) == true) goto L7;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        Collection r10 = (Collection) p7.l0(this.d, r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return this.e.wrapCollection(r5, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.d.hashCode();
    }

    @Override // com.google.common.collect.o7, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return this.e.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        Collection r10 = (Collection) this.d.remove(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        AbstractMapBasedMultimap r11 = this.e;
        Collection r12 = r11.createCollection();
        r12.addAll(r10);
        AbstractMapBasedMultimap.access$220(r11, r10.size());
        r10.clear();
        return r12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.d.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.d.toString();
    }
}
