package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class q6 extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9135b;

    public /* synthetic */ q6(Object r5, int r10) {
        this.f9134a = r10;
        this.f9135b = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch(this.f9134a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        ((Map) this.f9135b).clear();
        return;
    L6:
        ((s0) this.f9135b).clear();
        return;
    L8:
        ((g0) this.f9135b).clear();
        return;
    L10:
        ((MapMakerInternalMap) this.f9135b).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r5) {
        switch(this.f9134a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return ((Map) this.f9135b).containsValue(r5);
    L7:
        return ((s0) this.f9135b).containsValue(r5);
    L9:
        return ((g0) this.f9135b).containsValue(r5);
    L11:
        return ((MapMakerInternalMap) this.f9135b).containsValue(r5);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer r5) {
        switch(this.f9134a) {
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        super.forEach(r5);
        return;
    L6:
        r5.getClass();
        a4 r10 = new a4(r5, 3);
        ((Map) this.f9135b).forEach(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch(this.f9134a) {
            case 0: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return super.isEmpty();
    L7:
        return ((Map) this.f9135b).isEmpty();
    L9:
        return ((MapMakerInternalMap) this.f9135b).isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        switch(this.f9134a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return new q0(((Map) this.f9135b).entrySet().iterator(), 1);
    L7:
        return ((s0) this.f9135b).valuesIterator();
    L9:
        return ((g0) this.f9135b).valueIterator();
    L11:
        return new e6((MapMakerInternalMap) this.f9135b, 2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object r5) {
        switch(this.f9134a) {
            case 3: goto L16;
            default: goto L5;
        };
    L16:
        return super.remove(r5);
    L8:
        Map r10 = (Map) this.f9135b;
        Iterator r11 = r10.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (com.google.common.base.b0.w(r5, r12.getValue()) == false) goto L10;
        r10.remove(r12.getKey());
        return true;
    L14:
        return false;
    L5:
        return super.remove(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection r5) {
        switch(this.f9134a) {
            case 3: goto L16;
            default: goto L5;
        };
    L16:
        r5.getClass();     // Catch: UnsupportedOperationException -> L8
        return super.removeAll(r5);
    L8:
        HashSet r10 = new HashSet();
        Map r11 = (Map) this.f9135b;
        Iterator r12 = r11.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r5.contains(r13.getValue()) == false) goto L10;
        r10.add(r13.getKey());
        goto L10
    L15:
        return r11.keySet().removeAll(r10);
    L5:
        return super.removeAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection r5) {
        switch(this.f9134a) {
            case 3: goto L16;
            default: goto L5;
        };
    L16:
        r5.getClass();     // Catch: UnsupportedOperationException -> L8
        return super.retainAll(r5);
    L8:
        HashSet r10 = new HashSet();
        Map r11 = (Map) this.f9135b;
        Iterator r12 = r11.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r5.contains(r13.getValue()) == false) goto L10;
        r10.add(r13.getKey());
        goto L10
    L15:
        return r11.keySet().retainAll(r10);
    L5:
        return super.retainAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch(this.f9134a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return ((Map) this.f9135b).size();
    L7:
        return ((s0) this.f9135b).size();
    L9:
        return ((g0) this.f9135b).size();
    L11:
        return ((MapMakerInternalMap) this.f9135b).size();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator spliterator() {
        switch(this.f9134a) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.spliterator();
    L7:
        return ((s0) this.f9135b).valuesSpliterator();
    L9:
        return ((g0) this.f9135b).valueSpliterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        switch(this.f9134a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toArray();
    L7:
        return MapMakerInternalMap.access$900(this).toArray();
    }

    public q6(Map r5) {
        this.f9134a = 3;
        r5.getClass();
        this.f9135b = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] r5) {
        switch(this.f9134a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toArray(r5);
    L7:
        return MapMakerInternalMap.access$900(this).toArray(r5);
    }
}
