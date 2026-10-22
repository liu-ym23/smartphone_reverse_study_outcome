package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class ArrayListWrapper extends ArrayList<MessageQueue.IdleHandler> {
    private ArrayList<MessageQueue.IdleHandler> mOriginalArrayList;

    public ArrayListWrapper(ArrayList<MessageQueue.IdleHandler> r1) {
        this.mOriginalArrayList = r1;
    }

    public void add(int r1, MessageQueue.IdleHandler r2) {
        MessageQueue.IdleHandler r0 = (MessageQueue.IdleHandler) ZeusTransformUtils.wrapperContextForParams(r2, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method add");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        add(r3, (MessageQueue.IdleHandler) ZeusTransformUtils.preCheckCast(r4, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin"));
    }

    public boolean add(MessageQueue.IdleHandler r3) {
        MessageQueue.IdleHandler r4 = (MessageQueue.IdleHandler) ZeusTransformUtils.wrapperContextForParams(r3, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r4, c.class) == true) goto L9;
        return this.mOriginalArrayList.add(new c(r4));
    L9:
        return this.mOriginalArrayList.add(r4);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean add(Object r3) {
        return add((MessageQueue.IdleHandler) ZeusTransformUtils.preCheckCast(r3, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r1, Collection<? extends MessageQueue.IdleHandler> r2) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends MessageQueue.IdleHandler> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        throw new RuntimeException("Reach method clear");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        throw new RuntimeException("Reach method contains");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method containsAll");
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int r1) {
        throw new RuntimeException("Reach method ensureCapacity");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    public void finalize() {
        super.finalize();
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super MessageQueue.IdleHandler> r2) {
        Consumer r1 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method forEach");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler get(int r1) {
        throw new RuntimeException("Reach method get");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object r1) {
        throw new RuntimeException("Reach method indexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        throw new RuntimeException("Reach method isEmpty");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<MessageQueue.IdleHandler> iterator() {
        return this.mOriginalArrayList.iterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r1) {
        throw new RuntimeException("Reach method lastIndexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator() {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator(int r1) {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> parallelStream() {
        throw new RuntimeException("Reach method parallelStream");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MessageQueue.IdleHandler remove(int r2) {
        return (MessageQueue.IdleHandler) ZeusTransformUtils.preCheckCast(this.mOriginalArrayList.remove(r2), MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r6) {
        if (this.mOriginalArrayList.remove(r6) == false) goto L6;
        return true;
    L6:
        c r0 = null;
        Iterator<MessageQueue.IdleHandler> r1 = this.mOriginalArrayList.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        MessageQueue.IdleHandler r2 = (MessageQueue.IdleHandler) ZeusTransformUtils.preCheckCast(r1.next(), MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L8;
        if (((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).a() != r6) goto L8;
        r0 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin");
    L14:
        if (r0 != null) goto L16;
        return false;
    L16:
        return this.mOriginalArrayList.remove(r0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method removeAll");
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super MessageQueue.IdleHandler> r2) {
        Predicate r1 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method removeIf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int r1, int r2) {
        throw new RuntimeException("Reach method removeRange");
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<MessageQueue.IdleHandler> r2) {
        UnaryOperator r1 = (UnaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, UnaryOperator.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method replaceAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method retainAll");
    }

    public MessageQueue.IdleHandler set(int r1, MessageQueue.IdleHandler r2) {
        MessageQueue.IdleHandler r0 = (MessageQueue.IdleHandler) ZeusTransformUtils.wrapperContextForParams(r2, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method set");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return set(r3, (MessageQueue.IdleHandler) ZeusTransformUtils.preCheckCast(r4, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mOriginalArrayList.size();
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super MessageQueue.IdleHandler> r2) {
        Comparator r1 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Reach method sort");
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<MessageQueue.IdleHandler> spliterator() {
        throw new RuntimeException("Reach method spliterator");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> stream() {
        throw new RuntimeException("Reach method stream");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<MessageQueue.IdleHandler> subList(int r1, int r2) {
        throw new RuntimeException("Reach method subList");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        throw new RuntimeException("Reach method toArray");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.mOriginalArrayList.toArray(r1);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        throw new RuntimeException("Reach method trimToSize");
    }
}
