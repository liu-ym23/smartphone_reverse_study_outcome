package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OrderedHashSet<T> extends LinkedHashSet<T> {
    protected ArrayList<T> elements;

    public OrderedHashSet() {
        this.elements = new ArrayList();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r5) {
        boolean r10 = super.add(r5);
        if (r10 == false) goto L5;
        this.elements.add(r5);
    L5:
        return r10;
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.elements.clear();
        super.clear();
    }

    @Override // java.util.HashSet
    public Object clone() {
        OrderedHashSet r5 = (OrderedHashSet) super.clone();
        r5.elements = new ArrayList(this.elements);
        return r5;
    }

    public List<T> elements() {
        return this.elements;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if ((r5 instanceof OrderedHashSet) == true) goto L5;
        return false;
    L5:
        ArrayList<T> r10 = this.elements;
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.equals(((OrderedHashSet) r5).elements) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public T get(int r5) {
        return this.elements.get(r5);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.elements.hashCode();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(int r5) {
        return super.remove(this.elements.remove(r5));
    }

    public T set(int r5, T r10) {
        T r11 = this.elements.get(r5);
        this.elements.set(r5, r10);
        super.remove(r11);
        super.add(r10);
        return r11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.elements.toString();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r5) {
        throw new UnsupportedOperationException();
    }
}
