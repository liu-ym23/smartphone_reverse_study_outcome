package com.google.common.collect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableClassToInstanceMap<B> extends v2 implements Map, Serializable {
    private final Map<Class<? extends B>, B> delegate;

    public static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        public SerializedForm(Map<Class<? extends B>, B> r5) {
            this.backingMap = r5;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    public MutableClassToInstanceMap(Map r5) {
        r5.getClass();
        this.delegate = r5;
    }

    public static Object access$000(Class r5, Object r10) {
        Map r11 = com.google.common.primitives.h.f9340a;
        r5.getClass();
        Class r12 = (Class) com.google.common.primitives.h.f9340a.get(r5);
        if (r12 == null) goto L7;
        r5 = r12;
    L7:
        return r5.cast(r10);
    }

    public static Map.Entry access$100(Map.Entry r5) {
        return new d8(r5, 0);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new d(this, 2);
    }

    public <T extends B> T getInstance(Class<T> r5) {
        Object r10 = get(r5);
        Map r11 = com.google.common.primitives.h.f9340a;
        r5.getClass();
        Class<T> r12 = (Class) com.google.common.primitives.h.f9340a.get(r5);
        if (r12 == null) goto L7;
        r5 = r12;
    L7:
        return r5.cast(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r5, Object r10) {
        return put((Class) r5, r10);
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> r5) {
        LinkedHashMap r10 = new LinkedHashMap(r5);
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();
        Class r13 = (Class) r12.getKey();
        Object r14 = r12.getValue();
        Map r15 = com.google.common.primitives.h.f9340a;
        r13.getClass();
        Class r16 = (Class) com.google.common.primitives.h.f9340a.get(r13);
        if (r16 == null) goto L9;
        r13 = r16;
    L9:
        r13.cast(r14);
        goto L4
    L10:
        super.putAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> r5, T r10) {
        B r11 = put(r5, r10);
        Map r12 = com.google.common.primitives.h.f9340a;
        r5.getClass();
        Class r13 = (Class) com.google.common.primitives.h.f9340a.get(r5);
        Class r14 = r5;
        if (r13 == null) goto L7;
        r14 = (Class<T>) r13;
    L7:
        return (T) r14.cast(r11);
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> r5) {
        return new MutableClassToInstanceMap(r5);
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    public B put(Class<? extends B> r5, B r10) {
        Map r11 = com.google.common.primitives.h.f9340a;
        r5.getClass();
        Class<? extends B> r12 = (Class) com.google.common.primitives.h.f9340a.get(r5);
        if (r12 != null) goto L6;
        r12 = r5;
    L6:
        return (B) super.put(r5, r12.cast(r10));
    }
}
