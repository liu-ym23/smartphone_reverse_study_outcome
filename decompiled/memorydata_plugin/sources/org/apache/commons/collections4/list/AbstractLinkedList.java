package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;
import org.apache.commons.collections4.OrderedIterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractLinkedList<E> implements List<E> {
    transient Node<E> header;
    transient int modCount;
    transient int size;

    protected static class LinkedListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        protected Node<E> current;
        protected int expectedModCount;
        protected Node<E> next;
        protected int nextIndex;
        protected final AbstractLinkedList<E> parent;

        public LinkedListIterator(AbstractLinkedList<E> r2, int r3) {
            this.parent = r2;
            this.expectedModCount = r2.modCount;
            this.next = r2.getNode(r3, true);
            this.nextIndex = r3;
        }

        @Override // java.util.ListIterator
        public void add(E r3) {
            checkModCount();
            this.parent.addNodeBefore(this.next, r3);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }

        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        public Node<E> getLastNodeReturned() {
            Node<E> r0 = this.current;
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.next == this.parent.header) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.next.previous == this.parent.header) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (hasNext() == false) goto L7;
            E r0 = this.next.getValue();
            Node<E> r1 = this.next;
            this.current = r1;
            this.next = r1.next;
            this.nextIndex++;
            return r0;
        L7:
            throw new NoSuchElementException("No element at index " + this.nextIndex + ".");
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkModCount();
            if (hasPrevious() == false) goto L7;
            Node<E> r0 = this.next.previous;
            this.next = r0;
            E r1 = r0.getValue();
            this.current = this.next;
            this.nextIndex--;
            return r1;
        L7:
            throw new NoSuchElementException("Already at start of list.");
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            Node<E> r0 = this.current;
            Node<E> r1 = this.next;
            if (r0 != r1) goto L5;
            this.next = r1.next;
            this.parent.removeNode(getLastNodeReturned());
        L6:
            this.current = null;
            this.expectedModCount++;
            return;
        L5:
            this.parent.removeNode(getLastNodeReturned());
            this.nextIndex--;
            goto L6
        }

        @Override // java.util.ListIterator
        public void set(E r1) {
            checkModCount();
            getLastNodeReturned().setValue(r1);
        }
    }

    protected static class LinkedSubList<E> extends AbstractList<E> {
        int expectedModCount;
        int offset;
        AbstractLinkedList<E> parent;
        int size;

        public LinkedSubList(AbstractLinkedList<E> r2, int r3, int r4) {
            if (r3 < 0) goto L14;
            if (r4 > r2.size()) goto L12;
            if (r3 > r4) goto L10;
            this.parent = r2;
            this.offset = r3;
            this.size = r4 - r3;
            this.expectedModCount = r2.modCount;
            return;
        L10:
            throw new IllegalArgumentException("fromIndex(" + r3 + ") > toIndex(" + r4 + ")");
        L12:
            throw new IndexOutOfBoundsException("toIndex = " + r4);
        L14:
            throw new IndexOutOfBoundsException("fromIndex = " + r3);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int r3, E r4) {
            rangeCheck(r3, this.size + 1);
            checkModCount();
            this.parent.add(r3 + this.offset, r4);
            this.expectedModCount = this.parent.modCount;
            this.size++;
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int r5, Collection<? extends E> r6) {
            Collection<? extends E> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            rangeCheck(r5, this.size + 1);
            int r0 = r7.size();
            if (r0 != 0) goto L6;
            return false;
        L6:
            checkModCount();
            this.parent.addAll(this.offset + r5, r7);
            this.expectedModCount = this.parent.modCount;
            this.size += r0;
            this.modCount++;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> r3) {
            Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return addAll(this.size, r4);
        }

        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkModCount();
            Iterator<E> r1 = iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next();
            r1.remove();
            goto L4
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r2) {
            rangeCheck(r2, this.size);
            checkModCount();
            return this.parent.get(r2 + this.offset);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            checkModCount();
            return this.parent.createSubListIterator(this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int r2) {
            rangeCheck(r2, this.size + 1);
            checkModCount();
            return this.parent.createSubListListIterator(this, r2);
        }

        public void rangeCheck(int r3, int r4) {
            if (r3 < 0) goto L6;
            if (r3 >= r4) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("Index '" + r3 + "' out of bounds for size '" + this.size + "'");
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int r3) {
            rangeCheck(r3, this.size);
            checkModCount();
            E r4 = this.parent.remove(r3 + this.offset);
            this.expectedModCount = this.parent.modCount;
            this.size--;
            this.modCount++;
            return r4;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int r2, E r3) {
            rangeCheck(r2, this.size);
            checkModCount();
            return this.parent.set(r2 + this.offset, r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            checkModCount();
            return this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int r3, int r4) {
            AbstractLinkedList<E> r1 = this.parent;
            int r2 = this.offset;
            return new LinkedSubList(r1, r3 + r2, r4 + r2);
        }
    }

    protected static class LinkedSubListIterator<E> extends LinkedListIterator<E> {
        protected final LinkedSubList<E> sub;

        public LinkedSubListIterator(LinkedSubList<E> r3, int r4) {
            super(r3.parent, r4 + r3.offset);
            this.sub = r3;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E r2) {
            super.add(r2);
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size++;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (nextIndex() >= this.sub.size) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public boolean hasPrevious() {
            if (previousIndex() < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size--;
        }
    }

    protected static class Node<E> {
        protected Node<E> next;
        protected Node<E> previous;
        protected E value;

        public Node() {
            this.previous = this;
            this.next = this;
        }

        public Node(E r1) {
            this.value = r1;
        }

        public E getValue() {
            return this.value;
        }

        public void setValue(E r1) {
            this.value = r1;
        }
    }

    public AbstractLinkedList() {
    }

    public AbstractLinkedList(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        init();
        addAll(r4);
    }

    @Override // java.util.List
    public void add(int r2, E r3) {
        addNodeBefore(getNode(r2, true), r3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E r1) {
        addLast(r1);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Node<E> r6 = getNode(r3, true);
        Iterator<E> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        addNodeBefore(r6, r7.next());
        goto L4
    L6:
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return addAll(this.size, r4);
    }

    public boolean addFirst(E r2) {
        addNodeAfter(this.header, r2);
        return true;
    }

    public boolean addLast(E r2) {
        addNodeBefore(this.header, r2);
        return true;
    }

    public void addNode(Node<E> r2, Node<E> r3) {
        r2.next = r3;
        r2.previous = r3.previous;
        r3.previous.next = r2;
        r3.previous = r2;
        this.size++;
        this.modCount++;
    }

    public void addNodeAfter(Node<E> r1, E r2) {
        addNode(createNode(r2), r1.next);
    }

    public void addNodeBefore(Node<E> r1, E r2) {
        addNode(createNode(r2), r1);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        removeAllNodes();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Iterator<E> r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (contains(r4.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public Node<E> createHeaderNode() {
        return new Node();
    }

    public Node<E> createNode(E r1) {
        return new Node(r1);
    }

    public Iterator<E> createSubListIterator(LinkedSubList<E> r2) {
        return createSubListListIterator(r2, 0);
    }

    public ListIterator<E> createSubListListIterator(LinkedSubList<E> r1, int r2) {
        return new LinkedSubListIterator(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream r4) {
        init();
        int r0 = r4.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        add(r4.readObject());
        r1 = r1 + 1;
        goto L3
    }

    public void doWriteObject(ObjectOutputStream r2) {
        r2.writeInt(size());
        Iterator<E> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        goto L4
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, List.class) == true) goto L8;
        return false;
    L8:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        if (r6.size() == size()) goto L11;
        return false;
    L11:
        ListIterator<E> r4 = listIterator();
        ListIterator<E> r7 = r6.listIterator();
    L13:
        if (r4.hasNext() == false) goto L24;
        if (r7.hasNext() == false) goto L24;
        E r1 = r4.next();
        E r3 = r7.next();
        if (r1 == null) goto L18;
        if (r1.equals(r3) == true) goto L13;
    L22:
        return false;
    L18:
        if (r3 != null) goto L22;
    L24:
        if (r4.hasNext() == true) goto L29;
        if (r7.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    @Override // java.util.List
    public E get(int r2) {
        return getNode(r2, false).getValue();
    }

    public E getFirst() {
        Node<E> r0 = this.header.next;
        if (r0 == this.header) goto L7;
        return r0.getValue();
    L7:
        throw new NoSuchElementException();
    }

    public E getLast() {
        Node<E> r0 = this.header.previous;
        if (r0 == this.header) goto L7;
        return r0.getValue();
    L7:
        throw new NoSuchElementException();
    }

    public Node<E> getNode(int r3, boolean r4) {
        if (r3 < 0) goto L23;
        if (r4 == false) goto L6;
    L10:
        int r5 = this.size;
        if (r3 > r5) goto L21;
        int r0 = r5 / 2;
        Node<E> r2 = this.header;
        if (r3 >= r0) goto L17;
        r2 = r2.next;
        int r6 = 0;
    L15:
        if (r6 >= r3) goto L19;
        r2 = r2.next;
        r6 = r6 + 1;
    L19:
        return r2;
    L17:
        if (r5 <= r3) goto L19;
        r2 = r2.previous;
        r5 = r5 - 1;
        goto L17
    L21:
        throw new IndexOutOfBoundsException("Couldn't get the node: index (" + r3 + ") greater than the size of the list (" + this.size + ").");
    L6:
        if (r3 != this.size) goto L10;
        throw new IndexOutOfBoundsException("Couldn't get the node: index (" + r3 + ") is the size of the list.");
    L23:
        throw new IndexOutOfBoundsException("Couldn't get the node: index (" + r3 + ") less than zero.");
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        Iterator<E> r2 = iterator();
        int r0 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        E r1 = r2.next();
        int r3 = r0 * 31;
        if (r1 != null) goto L8;
        int r4 = 0;
    L9:
        r0 = r3 + r4;
        goto L4
    L8:
        r4 = r1.hashCode();
        goto L9
    L10:
        return r0;
    }

    @Override // java.util.List
    public int indexOf(Object r4) {
        Node<E> r0 = this.header.next;
        int r1 = 0;
    L4:
        if (r0 == this.header) goto L9;
        if (isEqualValue(r0.getValue(), r4) == true) goto L7;
        r1 = r1 + 1;
        r0 = r0.next;
        goto L4
    L7:
        return r1;
    L9:
        return -1;
    }

    public void init() {
        this.header = createHeaderNode();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqualValue(Object r1, Object r2) {
        if (r1 == r2) goto L8;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals(r2) == false) goto L7;
    L8:
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r4) {
        int r0 = this.size - 1;
        Node<E> r1 = this.header;
    L3:
        r1 = r1.previous;
        if (r1 == this.header) goto L9;
        if (isEqualValue(r1.getValue(), r4) == true) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new LinkedListIterator(this, 0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r2) {
        return new LinkedListIterator(this, r2);
    }

    @Override // java.util.List
    public E remove(int r2) {
        Node<E> r3 = getNode(r2, false);
        E r0 = r3.getValue();
        removeNode(r3);
        return r0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r3) {
        Node<E> r0 = this.header;
    L3:
        r0 = r0.next;
        if (r0 == this.header) goto L9;
        if (isEqualValue(r0.getValue(), r3) == false) goto L3;
        removeNode(r0);
        return true;
    L9:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Iterator<E> r2 = iterator();
        boolean r0 = false;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r4.contains(r2.next()) == false) goto L4;
        r2.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public void removeAllNodes() {
        Node<E> r0 = this.header;
        r0.next = r0;
        Node<E> r1 = this.header;
        r1.previous = r1;
        this.size = 0;
        this.modCount++;
    }

    public E removeFirst() {
        Node<E> r0 = this.header.next;
        if (r0 == this.header) goto L7;
        E r1 = r0.getValue();
        removeNode(r0);
        return r1;
    L7:
        throw new NoSuchElementException();
    }

    public E removeLast() {
        Node<E> r0 = this.header.previous;
        if (r0 == this.header) goto L7;
        E r1 = r0.getValue();
        removeNode(r0);
        return r1;
    L7:
        throw new NoSuchElementException();
    }

    public void removeNode(Node<E> r3) {
        r3.previous.next = r3.next;
        r3.next.previous = r3.previous;
        this.size--;
        this.modCount++;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Iterator<E> r2 = iterator();
        boolean r0 = false;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r4.contains(r2.next()) == true) goto L4;
        r2.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    @Override // java.util.List
    public E set(int r2, E r3) {
        Node<E> r4 = getNode(r2, false);
        E r0 = r4.getValue();
        updateNode(r4, r3);
        return r0;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public List<E> subList(int r2, int r3) {
        return new LinkedSubList(this, r2, r3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r4) {
        if (r4.length >= this.size) goto L5;
        r4 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4.getClass().getComponentType(), this.size), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
    L5:
        int r0 = 0;
        Node<E> r1 = this.header.next;
    L7:
        if (r1 == this.header) goto L9;
        T[] r5 = r4;
        r5[r0] = r1.getValue();
        r1 = r1.next;
        r0 = r0 + 1;
        goto L7
    L9:
        int r2 = r4.length;
        int r3 = this.size;
        if (r2 <= r3) goto L12;
        r4[r3] = null;
    L12:
        return r4;
    }

    public String toString() {
        if (size() != 0) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r0 = new StringBuilder(size() * 16);
        r0.append('[');
        Iterator<E> r1 = iterator();
        boolean r2 = r1.hasNext();
    L7:
        if (r2 == false) goto L14;
        Object r3 = r1.next();
        if (r3 != this) goto L11;
        r3 = "(this Collection)";
    L11:
        r0.append(r3);
        r2 = r1.hasNext();
        if (r2 == false) goto L7;
        r0.append(", ");
        goto L7
    L14:
        r0.append(']');
        return r0.toString();
    }

    public void updateNode(Node<E> r1, E r2) {
        r1.setValue(r2);
    }
}
