package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class TypeRegistry<V> implements Map<Class<?>, V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<Class<?>, V> backingStore;
    private final Map<Class<?>, Class<?>> cache;

    public TypeRegistry() {
        this.backingStore = new HashMap();
        this.cache = new HashMap();
    }

    @Override // java.util.Map
    public void clear() {
        this.backingStore.clear();
        this.cache.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r5) {
        if (this.cache.containsKey(r5) == false) goto L6;
        return true;
    L6:
        if ((r5 instanceof Class) == true) goto L9;
        return false;
    L9:
        if (get((Class) r5) == null) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r5) {
        return values().contains(r5);
    }

    @Override // java.util.Map
    public Set<Map.Entry<Class<?>, V>> entrySet() {
        return Collections.unmodifiableSet(this.backingStore.entrySet());
    }

    @Override // java.util.Map
    public V get(Object r10) {
        V r5 = this.backingStore.get(r10);
        if (r5 == null) goto L5;
        return r5;
    L5:
        Class<?> r11 = this.cache.get(r10);
        if (r11 == null) goto L13;
        if (r11 != Void.TYPE) goto L11;
        return null;
    L11:
        return this.backingStore.get(r11);
    L13:
        if ((r10 instanceof Class) == true) goto L15;
        return null;
    L15:
        Class<?> r12 = (Class) r10;
        ArrayList r13 = new ArrayList();
        Iterator<Class<?>> r14 = this.backingStore.keySet().iterator();
    L17:
        if (r14.hasNext() == false) goto L22;
        Class<?> r15 = r14.next();
        if (r15.isAssignableFrom(r12) == false) goto L17;
        r13.add(r15);
        goto L17
    L22:
        if (r13.isEmpty() == false) goto L25;
        this.cache.put(r12, Void.TYPE);
        return null;
    L25:
        int r16 = 0;
        if (r13.size() != 1) goto L29;
        this.cache.put(r12, (Class<?>) r13.get(0));
        return this.backingStore.get(r13.get(0));
    L29:
        int r17 = 0;
    L31:
        if (r17 >= (r13.size() - 1)) goto L46;
        if (r13.get(r17) == null) goto L45;
        int r18 = r17 + 1;
    L37:
        if (r18 >= r13.size()) goto L45;
        if (((Class) r13.get(r17)).isAssignableFrom((Class) r13.get(r18)) == true) goto L40;
        if (((Class) r13.get(r18)).isAssignableFrom((Class) r13.get(r17)) == false) goto L44;
        r13.set(r18, null);
    L44:
        r18 = r18 + 1;
        goto L37
    L40:
        r13.set(r17, null);
    L45:
        r17 = r17 + 1;
        goto L31
    L46:
        int r19 = 0;
        int r20 = 0;
    L48:
        if (r19 >= r13.size()) goto L56;
        Class r21 = (Class) r13.get(r19);
        if (r21 == null) goto L55;
        if (r19 == r20) goto L54;
        r13.set(r20, r21);
    L54:
        r20 = r20 + 1;
    L55:
        r19 = r19 + 1;
        goto L48
    L56:
        if (r20 == 1) goto L62;
        StringBuilder r22 = new StringBuilder();
        r22.append(String.format("The class '%s' does not match a single item in the registry. The %d ambiguous matches are:", new Object[]{r12.getName(), Integer.valueOf(r20)}));
    L58:
        if (r16 >= r20) goto L61;
        r22.append(String.format("%n    %s", new Object[]{((Class) r13.get(r20)).getName()}));
        r16 = r16 + 1;
        goto L58
    L61:
        throw new AmbiguousMatchException(r22.toString());
    L62:
        this.cache.put(r12, (Class<?>) r13.get(0));
        return this.backingStore.get(r13.get(0));
    }

    public void handleAlteration(Class<?> r5) {
        Iterator<Map.Entry<Class<?>, Class<?>>> r10 = this.cache.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<Class<?>, Class<?>> r11 = r10.next();
        if (r5.isAssignableFrom(r11.getKey()) == false) goto L4;
        r11.setValue(null);
        goto L4
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.backingStore.isEmpty();
    }

    @Override // java.util.Map
    public Set<Class<?>> keySet() {
        return Collections.unmodifiableSet(this.backingStore.keySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Class<?> r5, Object r10) {
        return put2(r5, r10);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Class<?>, ? extends V> r5) {
        Iterator<Map.Entry<? extends Class<?>, ? extends V>> r10 = r5.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<? extends Class<?>, ? extends V> r11 = r10.next();
        put2(r11.getKey(), r11.getValue());
        goto L4
    }

    @Override // java.util.Map
    public V remove(Object r5) {
        if ((r5 instanceof Class) == true) goto L6;
        return null;
    L6:
        Class<?> r10 = (Class) r5;
        V r11 = get(r10);
        if (this.backingStore.remove(r10) == null) goto L9;
        handleAlteration(r10);
    L9:
        return r11;
    }

    @Override // java.util.Map
    public int size() {
        return this.backingStore.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return Collections.unmodifiableCollection(this.backingStore.values());
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Class<?> r5, V r10) {
        V r11 = get(r5);
        this.backingStore.put(r5, r10);
        handleAlteration(r5);
        return r11;
    }
}
