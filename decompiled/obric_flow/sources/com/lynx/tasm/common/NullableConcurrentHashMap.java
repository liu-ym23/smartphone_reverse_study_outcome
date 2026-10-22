package com.lynx.tasm.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kn.d;

/* JADX INFO: loaded from: classes2.dex */
public class NullableConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f10824a = null;

    static {
        f10824a = new Object();
    }

    public NullableConcurrentHashMap() {
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return new d(super.entrySet());
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        if (r5 != null) goto L4;
        r5 = f10824a;
    L4:
        Object r10 = super.get(r5);
        if (r10 != f10824a) goto L8;
        return null;
    L8:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object r5, Object r10) {
        if (r5 != null) goto L4;
        r5 = f10824a;
    L4:
        if (r10 != null) goto L6;
        r10 = f10824a;
    L6:
        Object r11 = super.put(r5, r10);
        if (r11 != f10824a) goto L10;
        return null;
    L10:
        return r11;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map r5) {
        if (r5 == null) goto L8;
        Iterator<Map.Entry<K, V>> r10 = r5.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        Map.Entry<K, V> r11 = r10.next();
        put(r11.getKey(), r11.getValue());
        goto L6
    L10:
        return;
    }
}
