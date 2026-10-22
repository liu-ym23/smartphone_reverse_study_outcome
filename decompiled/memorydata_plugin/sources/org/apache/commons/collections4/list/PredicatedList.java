package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedList<E> extends PredicatedCollection<E> implements List<E> {
    private static final long serialVersionUID = -5722039223898659102L;

    protected class PredicatedListIterator extends AbstractListIteratorDecorator<E> {
        final /* synthetic */ PredicatedList this$0;

        public PredicatedListIterator(PredicatedList r3, ListIterator<E> r4) {
            ListIterator r5 = (ListIterator) ZeusTransformUtils.wrapperContextForParams(r4, ListIterator.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E r2) {
            PredicatedList.access$000(this.this$0, r2);
            getListIterator().add(r2);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E r2) {
            PredicatedList.access$100(this.this$0, r2);
            getListIterator().set(r2);
        }
    }

    public PredicatedList(List<E> r3, Predicate<? super E> r4) {
        super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$000(PredicatedList r0, Object r1) {
        r0.validate(r1);
    }

    static /* synthetic */ void access$100(PredicatedList r0, Object r1) {
        r0.validate(r1);
    }

    public static <T> PredicatedList<T> predicatedList(List<T> r2, Predicate<? super T> r3) {
        return new PredicatedList((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.List
    public void add(int r1, E r2) {
        validate(r2);
        decorated().add(r1, r2);
    }

    @Override // java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Iterator<? extends E> r0 = r5.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        validate(r0.next());
        goto L4
    L7:
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
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r3) {
        return new PredicatedListIterator(this, decorated().listIterator(r3));
    }

    @Override // java.util.List
    public E remove(int r1) {
        return decorated().remove(r1);
    }

    @Override // java.util.List
    public E set(int r1, E r2) {
        validate(r2);
        return decorated().set(r1, r2);
    }

    @Override // java.util.List
    public List<E> subList(int r2, int r3) {
        return new PredicatedList(decorated().subList(r2, r3), this.predicate);
    }
}
