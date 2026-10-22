package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedList<E> extends TransformedCollection<E> implements List<E> {
    private static final long serialVersionUID = 1077193035000013141L;

    protected class TransformedListIterator extends AbstractListIteratorDecorator<E> {
        final /* synthetic */ TransformedList this$0;

        public TransformedListIterator(TransformedList r3, ListIterator<E> r4) {
            ListIterator r5 = (ListIterator) ZeusTransformUtils.wrapperContextForParams(r4, ListIterator.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E r2) {
            Object r3 = TransformedList.access$000(this.this$0, r2);
            getListIterator().add(r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E r2) {
            Object r3 = TransformedList.access$100(this.this$0, r2);
            getListIterator().set(r3);
        }
    }

    public TransformedList(List<E> r3, Transformer<? super E, ? extends E> r4) {
        super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object access$000(TransformedList r0, Object r1) {
        return r0.transform(r1);
    }

    static /* synthetic */ Object access$100(TransformedList r0, Object r1) {
        return r0.transform(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> TransformedList<E> transformedList(List<E> r5, Transformer<? super E, ? extends E> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Transformer r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        TransformedList<E> r0 = new TransformedList(r7, r8);
        if (r7.size() <= 0) goto L7;
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r7.toArray(), Object[].class, "com.obric.memorydata.plugin");
        r7.clear();
        int r9 = r1.length;
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L7;
        Object r3 = r1[r2];
        r0.decorated().add(r8.transform(r3));
        r2 = r2 + 1;
    L7:
        return r0;
    }

    public static <E> TransformedList<E> transformingList(List<E> r2, Transformer<? super E, ? extends E> r3) {
        return new TransformedList((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.List
    public void add(int r1, E r2) {
        E r3 = transform(r2);
        getList().add(r1, r3);
    }

    @Override // java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Collection<E> r5 = transform((Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"));
        return getList().addAll(r3, r5);
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
        return getList().get(r1);
    }

    public List<E> getList() {
        return (List) ZeusTransformUtils.preCheckCast(decorated(), List.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        return getList().indexOf(r1);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r1) {
        return getList().lastIndexOf(r1);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r3) {
        return new TransformedListIterator(this, getList().listIterator(r3));
    }

    @Override // java.util.List
    public E remove(int r1) {
        return getList().remove(r1);
    }

    @Override // java.util.List
    public E set(int r1, E r2) {
        E r3 = transform(r2);
        return getList().set(r1, r3);
    }

    @Override // java.util.List
    public List<E> subList(int r2, int r3) {
        return new TransformedList(getList().subList(r2, r3), this.transformer);
    }
}
