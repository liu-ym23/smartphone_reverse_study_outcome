package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y0 extends h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap f9227a;

    public y0(ImmutableMap r5) {
        this.f9227a = r5;
    }

    public abstract String a();

    public abstract Object b(int r5);

    public abstract Object c(int r5, Object r10);

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        return this.f9227a.containsKey(r5);
    }

    @Override // com.google.common.collect.h7
    public final Iterator entryIterator() {
        return new x0(this.f9227a.size(), 0, this);
    }

    @Override // com.google.common.collect.h7
    public final Spliterator entrySpliterator() {
        return p7.N(this.f9227a.size(), 16, new w1(this, 4), null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        Integer r10 = (Integer) this.f9227a.get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return b(r10.intValue());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return this.f9227a.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f9227a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object r5, Object r10) {
        ImmutableMap r11 = this.f9227a;
        Integer r12 = (Integer) r11.get(r5);
        if (r12 != null) goto L5;
        String r13 = a();
        String r14 = String.valueOf(r5);
        String r15 = String.valueOf(r11.keySet());
        int r16 = r13.length() + 9;
        int r17 = r14.length() + r16;
        StringBuilder r18 = new StringBuilder(r15.length() + r17);
        r18.append(r13);
        r18.append(" ");
        r18.append(r14);
        r18.append(" not in ");
        r18.append(r15);
        throw new IllegalArgumentException(r18.toString());
    L5:
        return c(r12.intValue(), r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f9227a.size();
    }
}
