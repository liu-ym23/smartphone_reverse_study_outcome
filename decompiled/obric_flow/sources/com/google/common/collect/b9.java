package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class b9 extends o7 {
    public final Object d;
    public final /* synthetic */ StandardTable e;

    public b9(StandardTable r5, Object r10) {
        this.e = r5;
        r10.getClass();
        this.d = r10;
    }

    @Override // com.google.common.collect.o7
    public final Set a() {
        return new a9(this, 0);
    }

    @Override // com.google.common.collect.o7
    public final Set b() {
        return new o(this, 2);
    }

    @Override // com.google.common.collect.o7
    public final Collection c() {
        return new y1(this, 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        return this.e.contains(r5, this.d);
    }

    public final boolean d(com.google.common.base.z r10) {
        Iterator r5 = this.e.backingMap.entrySet().iterator();
        boolean r11 = false;
    L4:
        if (r5.hasNext() == false) goto L13;
        Map.Entry r12 = (Map.Entry) r5.next();
        Map r13 = (Map) r12.getValue();
        Object r14 = this.d;
        Object r15 = r13.get(r14);
        if (r15 == null) goto L4;
        if (r10.apply(new ImmutableEntry(r12.getKey(), r15)) == false) goto L4;
        r13.remove(r14);
        if (r13.isEmpty() == false) goto L12;
        r5.remove();
    L12:
        r11 = true;
        goto L4
    L13:
        return r11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        return this.e.get(r5, this.d);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object r5, Object r10) {
        return this.e.put(r5, this.d, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        return this.e.remove(r5, this.d);
    }
}
