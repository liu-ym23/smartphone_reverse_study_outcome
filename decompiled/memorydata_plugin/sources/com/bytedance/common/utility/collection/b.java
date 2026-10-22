package com.bytedance.common.utility.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<E, Object> f1979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f1980b;

    public b() {
        this.f1979a = new WeakHashMap();
        this.f1980b = new Object();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        ArrayList r0 = new ArrayList(this.f1979a.size());
        Iterator<E> r2 = this.f1979a.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        E r1 = r2.next();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0.iterator();
    }
}
