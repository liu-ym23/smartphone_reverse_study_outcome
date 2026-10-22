package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends v2 implements Map, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImmutableClassToInstanceMap f8815a = null;
    private final ImmutableMap<Class<? extends B>, B> delegate;

    static {
        f8815a = new ImmutableClassToInstanceMap(ImmutableMap.of());
    }

    public /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap r5, q3 r10) {
        this(r5);
    }

    public static <B> r3 builder() {
        r3 r5 = new r3();
        ImmutableMap.builder();
        return r5;
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> r5) {
        if ((r5 instanceof ImmutableClassToInstanceMap) == true) goto L5;
        x3 r10 = ImmutableMap.builder();
        Iterator<Map.Entry<? extends Class<? extends S>, ? extends S>> r11 = r5.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<? extends Class<? extends S>, ? extends S> r12 = r11.next();
        Class<? extends S> r13 = r12.getKey();
        S r14 = r12.getValue();
        Map r15 = com.google.common.primitives.h.f9340a;
        r13.getClass();
        Class<? extends S> r16 = (Class) com.google.common.primitives.h.f9340a.get(r13);
        if (r16 != null) goto L12;
        r16 = r13;
    L12:
        r10.g(r13, r16.cast(r14));
        goto L8
    L13:
        ImmutableMap r17 = r10.d();
        if (r17.isEmpty() == false) goto L17;
        return of();
    L17:
        return new ImmutableClassToInstanceMap(r17, null);
    L5:
        return (ImmutableClassToInstanceMap) r5;
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return f8815a;
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public <T extends B> T getInstance(Class<T> r5) {
        ImmutableMap<Class<? extends B>, B> r10 = this.delegate;
        r5.getClass();
        return r10.get(r5);
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> r5, T r10) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return of();
    }

    public ImmutableClassToInstanceMap(ImmutableMap r5) {
        this.delegate = r5;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> r5, T r10) {
        return new ImmutableClassToInstanceMap(ImmutableMap.of(r5, r10));
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
