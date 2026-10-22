package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public class k7 extends h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f7 f9058b;

    public k7(Map r5, f7 r10) {
        r5.getClass();
        this.f9057a = r5;
        r10.getClass();
        this.f9058b = r10;
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f9057a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        return this.f9057a.containsKey(r5);
    }

    @Override // com.google.common.collect.h7
    public final Iterator entryIterator() {
        Iterator r5 = this.f9057a.entrySet().iterator();
        f7 r10 = this.f9058b;
        r10.getClass();
        return new d7(r5, new e9(r10, 2), 1);
    }

    @Override // com.google.common.collect.h7
    public final Spliterator entrySpliterator() {
        Spliterator r5 = this.f9057a.entrySet().spliterator();
        f7 r10 = this.f9058b;
        r10.getClass();
        return p7.R(r5, new e9(r10, 2));
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer r5) {
        r5.getClass();
        j1 r10 = new j1(2, this, r5);
        this.f9057a.forEach(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        return getOrDefault(r5, null);
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object r5, Object r10) {
        Map r11 = this.f9057a;
        Object r12 = r11.get(r5);
        if (r12 != null) goto L9;
        if (r11.containsKey(r5) == true) goto L9;
        return r10;
    L9:
        return ((com.google.common.base.q) this.f9058b.f8976a).apply(r12);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f9057a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        Map r10 = this.f9057a;
        if (r10.containsKey(r5) == false) goto L5;
        Object r11 = r10.remove(r5);
        return ((com.google.common.base.q) this.f9058b.f8976a).apply(r11);
    L5:
        return null;
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f9057a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        return new q6(this);
    }
}
