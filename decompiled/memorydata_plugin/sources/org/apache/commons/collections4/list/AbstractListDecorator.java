package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractListDecorator<E> extends AbstractCollectionDecorator<E> implements List<E> {
    private static final long serialVersionUID = 4500739654952315623L;

    public AbstractListDecorator() {
    }

    public AbstractListDecorator(List<E> r3) {
        super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.List
    public void add(int r1, E r2) {
        decorated().add(r1, r2);
    }

    @Override // java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        return decorated().addAll(r3, r5);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) ZeusTransformUtils.preCheckCast(super.decorated(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (decorated().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.List
    public E get(int r1) {
        return decorated().get(r1);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        return decorated().indexOf(r1);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r1) {
        return decorated().lastIndexOf(r1);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return decorated().listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r1) {
        return decorated().listIterator(r1);
    }

    @Override // java.util.List
    public E remove(int r1) {
        return decorated().remove(r1);
    }

    @Override // java.util.List
    public E set(int r1, E r2) {
        return decorated().set(r1, r2);
    }

    @Override // java.util.List
    public List<E> subList(int r1, int r2) {
        return decorated().subList(r1, r2);
    }
}
