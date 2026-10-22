package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes7.dex */
public class IntMapper<T> implements Iterable<T> {
    private final List<T> elements;
    private final Map<T, Integer> valueKeyMap;

    public IntMapper() {
        this(10);
    }

    public IntMapper(int r2) {
        this.elements = new ArrayList(r2);
        this.valueKeyMap = new HashMap(r2);
    }

    public boolean add(T r3) {
        int r0 = this.elements.size();
        this.elements.add(r3);
        this.valueKeyMap.put(r3, Integer.valueOf(r0));
        return true;
    }

    public T get(int r1) {
        return this.elements.get(r1);
    }

    public List<T> getElements() {
        return this.elements;
    }

    public int getIndex(T r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(this.valueKeyMap.getOrDefault(r2, -1), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    public int size() {
        return this.elements.size();
    }

    @Override // java.lang.Iterable
    public Spliterator<T> spliterator() {
        return this.elements.spliterator();
    }
}
