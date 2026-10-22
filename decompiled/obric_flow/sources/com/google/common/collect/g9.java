package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
public class g9 extends h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f8998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StandardTable f8999c;

    public g9(StandardTable r5, Object r10) {
        this.f8999c = r5;
        r10.getClass();
        this.f8997a = r10;
    }

    public Map a() {
        return (Map) this.f8999c.backingMap.get(this.f8997a);
    }

    public void b() {
        c();
        Map r5 = this.f8998b;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == false) goto L9;
        this.f8999c.backingMap.remove(this.f8997a);
        this.f8998b = null;
        return;
    }

    public final void c() {
        Map r5 = this.f8998b;
        if (r5 != null) goto L5;
    L8:
        this.f8998b = a();
        return;
    L5:
        if (r5.isEmpty() == true) goto L7;
        return;
    L7:
        if (this.f8999c.backingMap.containsKey(this.f8997a) == true) goto L8;
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final void clear() {
        c();
        Map r5 = this.f8998b;
        if (r5 == null) goto L5;
        r5.clear();
    L5:
        b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        c();
        if (r5 == null) goto L9;
        Map r10 = this.f8998b;
        if (r10 == null) goto L9;
        if (p7.k0(r10, r5) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.collect.h7
    public final Iterator entryIterator() {
        c();
        Map r5 = this.f8998b;
        if (r5 != null) goto L7;
        return Iterators$EmptyModifiableIterator.INSTANCE;
    L7:
        return new com.google.common.base.k(this, r5.entrySet().iterator());
    }

    @Override // com.google.common.collect.h7
    public final Spliterator entrySpliterator() {
        c();
        Map r5 = this.f8998b;
        if (r5 != null) goto L7;
        return Spliterators.emptySpliterator();
    L7:
        return p7.R(r5.entrySet().spliterator(), new z8(this, 3));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        c();
        if (r5 == null) goto L7;
        Map r10 = this.f8998b;
        if (r10 == null) goto L7;
        return p7.l0(r10, r5);
    L7:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object r5, Object r10) {
        r5.getClass();
        r10.getClass();
        Map r11 = this.f8998b;
        if (r11 == null) goto L9;
        if (r11.isEmpty() == true) goto L9;
        return this.f8998b.put(r5, r10);
    L9:
        return this.f8999c.put(this.f8997a, r5, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        c();
        Map r10 = this.f8998b;
        Object r11 = null;
        if (r10 != null) goto L9;
        return null;
    L9:
        r11 = r10.remove(r5);     // Catch: Throwable -> L8
    L6:
        b();
        return r11;
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final int size() {
        c();
        Map r5 = this.f8998b;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.size();
    }
}
