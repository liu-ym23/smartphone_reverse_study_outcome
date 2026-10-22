package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h7 extends AbstractMap {
    public h7() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        p7.u(entryIterator());
    }

    public abstract Iterator entryIterator();

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return new l(3, this);
    }

    public Spliterator<Map.Entry<Object, Object>> entrySpliterator() {
        return Spliterators.spliterator(entryIterator(), size(), 65);
    }

    public void forEachEntry(Consumer<? super Map.Entry<Object, Object>> r5) {
        entryIterator().forEachRemaining(r5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public abstract int size();
}
