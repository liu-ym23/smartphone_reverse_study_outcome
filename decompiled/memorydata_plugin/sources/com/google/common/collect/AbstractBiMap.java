package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractBiMap<K, V> extends y<K, V> implements k<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        Inverse(Map<K, V> r3, AbstractBiMap<V, K> r4) {
            super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4, null);
        }

        private void readObject(ObjectInputStream r3) {
            r3.defaultReadObject();
            setInverse((AbstractBiMap) ZeusTransformUtils.preCheckCast(r3.readObject(), AbstractBiMap.class, "com.obric.memorydata.plugin"));
        }

        private void writeObject(ObjectOutputStream r1) {
            r1.defaultWriteObject();
            r1.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        K checkKey(K r1) {
            return this.inverse.checkValue(r1);
        }

        @Override // com.google.common.collect.AbstractBiMap
        V checkValue(V r1) {
            return this.inverse.checkKey(r1);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.y, java.util.Map, com.google.common.collect.k
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    class a extends z<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractBiMap f4360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map.Entry<K, V> f4361b;

        a(AbstractBiMap r3, Map.Entry<K, V> r4) {
            Map.Entry<K, V> r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            this.f4360a = r3;
            this.f4361b = r5;
        }

        @Override // com.google.common.collect.z
        public Map.Entry<K, V> a() {
            return this.f4361b;
        }

        @Override // com.google.common.collect.z, com.google.common.collect.ac
        public /* synthetic */ Object delegate() {
            return a();
        }

        @Override // com.google.common.collect.z, java.util.Map.Entry
        public V setValue(V r6) {
            this.f4360a.checkValue(r6);
            com.google.common.base.n.b(this.f4360a.entrySet().contains(this), "entry no longer in map");
            if (com.google.common.base.k.a(r6, getValue()) == false) goto L5;
            return r6;
        L5:
            com.google.common.base.n.a(!this.f4360a.containsValue(r6), "value already present: %s", r6);
            V r0 = this.f4361b.setValue(r6);
            com.google.common.base.n.b(com.google.common.base.k.a(r6, this.f4360a.get(getKey())), "entry no longer in map");
            AbstractBiMap.access$500(this.f4360a, getKey(), true, r0, r6);
            return r0;
        }
    }

    private class b extends ae<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set<Map.Entry<K, V>> f4362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractBiMap f4363b;

        private b(AbstractBiMap r1) {
            this.f4363b = r1;
            this.f4362a = AbstractBiMap.access$100(r1).entrySet();
        }

        /* synthetic */ b(AbstractBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public void clear() {
            this.f4363b.clear();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return Maps.a(delegate(), r1);
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r3) {
            return standardContainsAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public Set<Map.Entry<K, V>> delegate() {
            return this.f4362a;
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.f4363b.entrySetIterator();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if (this.f4362a.contains(r3) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L11;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            AbstractBiMap.access$100(this.f4363b.inverse).remove(r4.getValue());
            this.f4362a.remove(r4);
            return true;
        L11:
            return false;
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r3) {
            return standardRemoveAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r3) {
            return standardRetainAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }
    }

    private class c extends ae<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractBiMap f4364a;

        private c(AbstractBiMap r1) {
            this.f4364a = r1;
        }

        /* synthetic */ c(AbstractBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public void clear() {
            this.f4364a.clear();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public Set<K> delegate() {
            return AbstractBiMap.access$100(this.f4364a).keySet();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.a(this.f4364a.entrySet().iterator());
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            if (contains(r2) == true) goto L6;
            return false;
        L6:
            AbstractBiMap.access$200(this.f4364a, r2);
            return true;
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r3) {
            return standardRemoveAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r3) {
            return standardRetainAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }
    }

    private class d extends ae<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set<V> f4365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractBiMap f4366b;

        private d(AbstractBiMap r1) {
            this.f4366b = r1;
            this.f4365a = r1.inverse.keySet();
        }

        /* synthetic */ d(AbstractBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public Set<V> delegate() {
            return this.f4365a;
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.b(this.f4366b.entrySet().iterator());
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }

        @Override // com.google.common.collect.ac
        public String toString() {
            return standardToString();
        }
    }

    private AbstractBiMap(Map<K, V> r3, AbstractBiMap<V, K> r4) {
        this.delegate = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.inverse = r4;
    }

    /* synthetic */ AbstractBiMap(Map r2, AbstractBiMap r3, AnonymousClass1 r4) {
        this((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), r3);
    }

    AbstractBiMap(Map<K, V> r3, Map<V, K> r4) {
        setDelegates((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Map access$100(AbstractBiMap r0) {
        return r0.delegate;
    }

    static /* synthetic */ Object access$200(AbstractBiMap r0, Object r1) {
        return r0.removeFromBothMaps(r1);
    }

    static /* synthetic */ void access$500(AbstractBiMap r0, Object r1, boolean r2, Object r3, Object r4) {
        r0.updateInverseMap(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$600(AbstractBiMap r0, Object r1) {
        r0.removeFromInverseMap(r1);
    }

    private V putInBothMaps(K r3, V r4, boolean r5) {
        checkKey(r3);
        checkValue(r4);
        boolean r0 = containsKey(r3);
        if (r0 == true) goto L5;
    L7:
        if (r5 == false) goto L9;
        inverse().remove(r4);
    L10:
        V r6 = this.delegate.put(r3, r4);
        updateInverseMap(r3, r0, r6, r4);
        return r6;
    L9:
        com.google.common.base.n.a(!containsValue(r4), "value already present: %s", r4);
        goto L10
    L5:
        if (com.google.common.base.k.a(r4, get(r3)) == false) goto L7;
        return r4;
    }

    private V removeFromBothMaps(Object r2) {
        V r3 = (V) ao.a(this.delegate.remove(r2));
        removeFromInverseMap(r3);
        return r3;
    }

    private void removeFromInverseMap(V r1) {
        this.inverse.delegate.remove(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateInverseMap(K r1, boolean r2, V r3, V r4) {
        if (r2 == false) goto L4;
        removeFromInverseMap(ao.a(r3));
    L4:
        this.inverse.delegate.put(r4, r1);
    }

    K checkKey(K r1) {
        return r1;
    }

    V checkValue(V r1) {
        return r1;
    }

    @Override // com.google.common.collect.y, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.y, java.util.Map
    public boolean containsValue(Object r1) {
        return this.inverse.containsKey(r1);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.y, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        b r1 = new b(this, null);
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        final Iterator<Map.Entry<K, V>> r0 = this.delegate.entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.k
    public V forcePut(K r2, V r3) {
        return putInBothMaps(r2, r3, true);
    }

    @Override // com.google.common.collect.k
    public k<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.y, java.util.Map
    public Set<K> keySet() {
        Set<K> r0 = this.keySet;
        if (r0 != null) goto L6;
        c r1 = new c(this, null);
        this.keySet = r1;
        return r1;
    L6:
        return r0;
    }

    AbstractBiMap<V, K> makeInverse(Map<V, K> r3) {
        return new Inverse((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), this);
    }

    @Override // com.google.common.collect.y, java.util.Map
    public V put(K r2, V r3) {
        return putInBothMaps(r2, r3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.y, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Iterator<Map.Entry<K, V>> r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // com.google.common.collect.y, java.util.Map
    public V remove(Object r2) {
        if (containsKey(r2) == true) goto L7;
        return null;
    L7:
        return removeFromBothMaps(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r7) {
        this.delegate.replaceAll((BiFunction) ZeusTransformUtils.wrapperContextForParams(r7, BiFunction.class, "com.obric.memorydata.plugin"));
        this.inverse.delegate.clear();
        Iterator<Map.Entry<K, V>> r8 = this.delegate.entrySet().iterator();
        Map.Entry r0 = null;
    L4:
        if (r8.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getKey();
        if (this.inverse.delegate.putIfAbsent((K) r2.getValue(), (V) r3) == null) goto L4;
        r8.remove();
        r0 = r2;
        goto L4
    L8:
        if (r0 != null) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("value already present: " + r0.getValue());
    }

    void setDelegates(Map<K, V> r4, Map<V, K> r5) {
        Map<K, V> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<V, K> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (this.delegate != null) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.b(r0);
        if (this.inverse != null) goto L9;
        boolean r2 = true;
    L10:
        com.google.common.base.n.b(r2);
        com.google.common.base.n.a(r6.isEmpty());
        com.google.common.base.n.a(r7.isEmpty());
        if (r6 != r7) goto L14;
        r1 = false;
    L14:
        com.google.common.base.n.a(r1);
        this.delegate = r6;
        this.inverse = makeInverse(r7);
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    void setInverse(AbstractBiMap<V, K> r1) {
        this.inverse = r1;
    }

    @Override // com.google.common.collect.y, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.y, java.util.Map, com.google.common.collect.k
    public Set<V> values() {
        Set<V> r0 = this.valueSet;
        if (r0 != null) goto L6;
        d r1 = new d(this, null);
        this.valueSet = r1;
        return r1;
    L6:
        return r0;
    }
}
