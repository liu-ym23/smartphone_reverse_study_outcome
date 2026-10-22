package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class XmlSimpleList<T> implements Serializable, List<T> {
    private static final long serialVersionUID = 1;
    private final List<T> underlying;

    public XmlSimpleList(List<T> r3) {
        this.underlying = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ List access$000(XmlSimpleList r0) {
        return r0.underlying;
    }

    private String stringValue(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SimpleValue.class) == false) goto L7;
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getStringValue();
    L7:
        return r2.toString();
    }

    @Override // java.util.List
    public void add(int r1, Object r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int r1, Collection r2) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r1) {
        return this.underlying.contains(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.underlying.containsAll(r4);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, XmlSimpleList.class) == true) goto L8;
        return false;
    L8:
        List<T> r8 = ((XmlSimpleList) ZeusTransformUtils.preCheckCast(r7, XmlSimpleList.class, "com.obric.memorydata.plugin")).underlying;
        int r0 = this.underlying.size();
        if (r0 == r8.size()) goto L11;
        return false;
    L11:
        int r2 = 0;
    L12:
        if (r2 >= r0) goto L17;
        if (Objects.equals(this.underlying.get(r2), r8.get(r2)) == false) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    @Override // java.util.List
    public T get(int r1) {
        return this.underlying.get(r1);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        Iterator<T> r2 = this.underlying.iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = (r0 * 19) + r2.next().hashCode();
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        return this.underlying.indexOf(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.underlying.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r1) {
        return this.underlying.lastIndexOf(r1);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(final int r2) {
        return new AnonymousClass2(this, r2);
    }

    @Override // java.util.List
    public T remove(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public T set(int r1, T r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.underlying.size();
    }

    @Override // java.util.List
    public List<T> subList(int r2, int r3) {
        return new XmlSimpleList(this.underlying.subList(r2, r3));
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.underlying.toArray(new Object[0]);
    }

    @Override // java.util.List, java.util.Collection
    public <X> X[] toArray(X[] r1) {
        return (X[]) this.underlying.toArray(r1);
    }

    public String toString() {
        int r0 = this.underlying.size();
        if (r0 != 0) goto L6;
        return "";
    L6:
        String r1 = stringValue(this.underlying.get(0));
        int r2 = 1;
        if (r0 != 1) goto L9;
        return r1;
    L9:
        StringBuilder r3 = new StringBuilder(r1);
    L10:
        if (r2 >= r0) goto L13;
        r3.append(' ');
        r3.append(stringValue(this.underlying.get(r2)));
        r2 = r2 + 1;
        goto L10
    L13:
        return r3.toString();
    }
}
