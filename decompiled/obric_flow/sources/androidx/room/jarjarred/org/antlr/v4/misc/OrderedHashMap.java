package androidx.room.jarjarred.org.antlr.v4.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OrderedHashMap<K, V> extends LinkedHashMap<K, V> {
    protected List<K> elements;

    public OrderedHashMap() {
        this.elements = new ArrayList();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.elements.clear();
        super.clear();
    }

    public V getElement(int r5) {
        return get(this.elements.get(r5));
    }

    public K getKey(int r5) {
        return this.elements.get(r5);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r5, V r10) {
        this.elements.add(r5);
        return (V) super.put(r5, r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Iterator<Map.Entry<? extends K, ? extends V>> r10 = r5.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r11 = r10.next();
        put(r11.getKey(), r11.getValue());
        goto L4
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        this.elements.remove(r5);
        return (V) super.remove(r5);
    }
}
