package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractBiMap<K, V> extends v2 implements c1, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Map f8784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient d f8785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient c f8786c;
    public transient c d;
    transient AbstractBiMap<V, K> inverse;

    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        public Inverse(Map<K, V> r5, AbstractBiMap<V, K> r10) {
            super(r5, r10, null);
        }

        private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
            r5.defaultReadObject();
            setInverse((AbstractBiMap) r5.readObject());
        }

        private void writeObject(ObjectOutputStream r5) throws IOException {
            r5.defaultWriteObject();
            r5.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K r5) {
            return this.inverse.checkValue(r5);
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V r5) {
            return this.inverse.checkKey(r5);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v2, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public AbstractBiMap(Map<K, V> r5, Map<V, K> r10) {
        setDelegates(r5, r10);
    }

    public static /* synthetic */ Map access$100(AbstractBiMap r5) {
        return r5.f8784a;
    }

    public static Object access$200(AbstractBiMap r5, Object r10) {
        Object r11 = r5.f8784a.remove(r10);
        r5.inverse.f8784a.remove(r11);
        return r11;
    }

    public static void access$500(AbstractBiMap r5, Object r10, boolean r11, Object r12, Object r13) {
        if (r11 == false) goto L4;
        r5.inverse.f8784a.remove(r12);
    L4:
        r5.inverse.f8784a.put(r13, r10);
    }

    public static void access$600(AbstractBiMap r5, Object r10) {
        r5.inverse.f8784a.remove(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(Object r5, Object r10, boolean r11) {
        checkKey(r5);
        checkValue(r10);
        boolean r12 = containsKey(r5);
        if (r12 == true) goto L5;
    L7:
        if (r11 == false) goto L9;
        inverse().remove(r10);
    L10:
        Object r13 = this.f8784a.put(r5, r10);
        if (r12 == false) goto L13;
        this.inverse.f8784a.remove(r13);
    L13:
        this.inverse.f8784a.put(r10, r5);
        return r13;
    L9:
        com.google.common.base.b0.h("value already present: %s", !containsValue(r10), r10);
        goto L10
    L5:
        if (com.google.common.base.b0.w(r10, get(r5)) == false) goto L7;
        return r10;
    }

    public K checkKey(K r5) {
        return r5;
    }

    public V checkValue(V r5) {
        return r5;
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public void clear() {
        this.f8784a.clear();
        this.inverse.f8784a.clear();
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public boolean containsValue(Object r5) {
        return this.inverse.containsKey(r5);
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        c r5 = this.d;
        if (r5 != null) goto L6;
        c r10 = new c(this, 0);
        this.d = r10;
        return r10;
    L6:
        return r5;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this, this.f8784a.entrySet().iterator());
    }

    @Override // com.google.common.collect.c1
    public V forcePut(K r5, V r10) {
        return (V) b(r5, r10, true);
    }

    @Override // com.google.common.collect.c1
    public c1 inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public Set<K> keySet() {
        d r5 = this.f8785b;
        if (r5 != null) goto L6;
        d r10 = new d(this, 0);
        this.f8785b = r10;
        return r10;
    L6:
        return r5;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> r5) {
        return new Inverse(r5, this);
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public V put(K r5, V r10) {
        return (V) b(r5, r10, false);
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Iterator<Map.Entry<? extends K, ? extends V>> r10 = r5.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r11 = r10.next();
        put(r11.getKey(), r11.getValue());
        goto L4
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public V remove(Object r5) {
        if (containsKey(r5) == false) goto L5;
        V r10 = (V) this.f8784a.remove(r5);
        this.inverse.f8784a.remove(r10);
        return r10;
    L5:
        return null;
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r10) {
        this.f8784a.replaceAll(r10);
        this.inverse.f8784a.clear();
        Iterator<Map.Entry<K, V>> r11 = this.f8784a.entrySet().iterator();
        Map.Entry<K, V> r5 = null;
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<K, V> r12 = r11.next();
        K r13 = r12.getKey();
        V r14 = r12.getValue();
        if (this.inverse.f8784a.putIfAbsent(r14, r13) == null) goto L4;
        r11.remove();
        r5 = r12;
        goto L4
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        String r15 = String.valueOf(r5.getValue());
        throw new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.l(r15.length() + 23, "value already present: ", r15));
    }

    public void setDelegates(Map<K, V> r5, Map<V, K> r10) {
        boolean r11 = false;
        if (this.f8784a != null) goto L5;
        boolean r12 = true;
    L6:
        com.google.common.base.b0.t(r12);
        if (this.inverse != null) goto L9;
        boolean r13 = true;
    L10:
        com.google.common.base.b0.t(r13);
        com.google.common.base.b0.i(r5.isEmpty());
        com.google.common.base.b0.i(r10.isEmpty());
        if (r5 == r10) goto L13;
        r11 = true;
    L13:
        com.google.common.base.b0.i(r11);
        this.f8784a = r5;
        this.inverse = makeInverse(r10);
        return;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public void setInverse(AbstractBiMap<V, K> r5) {
        this.inverse = r5;
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public Map<K, V> delegate() {
        return this.f8784a;
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public Set<V> values() {
        c r5 = this.f8786c;
        if (r5 != null) goto L6;
        c r10 = new c(this, 1);
        this.f8786c = r10;
        return r10;
    L6:
        return r5;
    }

    public AbstractBiMap(Map r5, AbstractBiMap r10, a r11) {
        this.f8784a = r5;
        this.inverse = r10;
    }
}
