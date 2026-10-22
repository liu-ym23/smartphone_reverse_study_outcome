package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes6.dex */
public class CursorableLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    private transient List<WeakReference<Cursor<E>>> cursors;

    public static class Cursor<E> extends AbstractLinkedList.LinkedListIterator<E> {
        boolean currentRemovedByAnother;
        boolean nextIndexValid;
        boolean valid;

        public Cursor(CursorableLinkedList<E> r1, int r2) {
            super(r1, r2);
            this.valid = true;
            this.nextIndexValid = true;
            this.currentRemovedByAnother = false;
            this.valid = true;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E r1) {
            super.add(r1);
            this.next = this.next.next;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator
        public void checkModCount() {
            if (this.valid == false) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException("Cursor closed");
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ boolean hasNext() {
            return super.hasNext();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ boolean hasPrevious() {
            return super.hasPrevious();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return super.next();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            if (this.nextIndexValid == true) goto L14;
            if (this.next != this.parent.header) goto L8;
            int r0 = this.parent.size();
        L7:
            this.nextIndex = r0;
            this.nextIndexValid = true;
            goto L14
        L8:
            r0 = 0;
            AbstractLinkedList.Node<E> r1 = this.parent.header;
        L9:
            r1 = r1.next;
            if (r1 == this.next) goto L7;
            r0 = r0 + 1;
        L14:
            return this.nextIndex;
        }

        public void nodeChanged(AbstractLinkedList.Node<E> r1) {
        }

        public void nodeInserted(AbstractLinkedList.Node<E> r3) {
            if (r3.previous != this.current) goto L6;
        L4:
            this.next = r3;
            return;
        L6:
            if (this.next.previous == r3) goto L4;
            this.nextIndexValid = false;
        }

        public void nodeRemoved(AbstractLinkedList.Node<E> r5) {
            if (r5 != this.next) goto L8;
            if (r5 != this.current) goto L8;
            this.next = r5.next;
            this.current = null;
            this.currentRemovedByAnother = true;
            return;
        L8:
            if (r5 != this.next) goto L12;
            this.next = r5.next;
        L10:
            this.currentRemovedByAnother = false;
            return;
        L12:
            if (r5 != this.current) goto L14;
            this.current = null;
            this.currentRemovedByAnother = true;
            this.nextIndex--;
            return;
        L14:
            this.nextIndexValid = false;
            goto L10
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ Object previous() {
            return super.previous();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ int previousIndex() {
            return super.previousIndex();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.current == null) goto L5;
        L7:
            checkModCount();
            this.parent.removeNode(getLastNodeReturned());
        L8:
            this.currentRemovedByAnother = false;
            return;
        L5:
            if (this.currentRemovedByAnother == false) goto L7;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object r1) {
            super.set(r1);
        }
    }

    protected static class SubCursor<E> extends Cursor<E> {
        protected final AbstractLinkedList.LinkedSubList<E> sub;

        public SubCursor(AbstractLinkedList.LinkedSubList<E> r4, int r5) {
            super((CursorableLinkedList) ZeusTransformUtils.preCheckCast(r4.parent, CursorableLinkedList.class, "com.obric.memorydata.plugin"), r5 + r4.offset);
            this.sub = r4;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E r2) {
            super.add(r2);
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size++;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (nextIndex() >= this.sub.size) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public boolean hasPrevious() {
            if (previousIndex() < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size--;
        }
    }

    public CursorableLinkedList() {
        init();
    }

    public CursorableLinkedList(Collection<? extends E> r3) {
        super((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        doReadObject(r1);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void addNode(AbstractLinkedList.Node<E> r1, AbstractLinkedList.Node<E> r2) {
        super.addNode(r1, r2);
        broadcastNodeInserted(r1);
    }

    public void broadcastNodeChanged(AbstractLinkedList.Node<E> r4) {
        Iterator<WeakReference<Cursor<E>>> r3 = this.cursors.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Cursor.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.nodeChanged(r4);
        goto L4
    L7:
        r3.remove();
        goto L4
    }

    public void broadcastNodeInserted(AbstractLinkedList.Node<E> r4) {
        Iterator<WeakReference<Cursor<E>>> r3 = this.cursors.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Cursor.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.nodeInserted(r4);
        goto L4
    L7:
        r3.remove();
        goto L4
    }

    public void broadcastNodeRemoved(AbstractLinkedList.Node<E> r4) {
        Iterator<WeakReference<Cursor<E>>> r3 = this.cursors.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Cursor.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.nodeRemoved(r4);
        goto L4
    L7:
        r3.remove();
        goto L4
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public ListIterator<E> createSubListListIterator(AbstractLinkedList.LinkedSubList<E> r2, int r3) {
        SubCursor r0 = new SubCursor(r2, r3);
        registerCursor(r0);
        return r0;
    }

    public Cursor<E> cursor() {
        return cursor(0);
    }

    public Cursor<E> cursor(int r2) {
        Cursor<E> r0 = new Cursor(this, r2);
        registerCursor(r0);
        return r0;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void init() {
        super.init();
        this.cursors = new ArrayList();
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return super.listIterator(0);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List
    public ListIterator<E> listIterator() {
        return cursor(0);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List
    public ListIterator<E> listIterator(int r1) {
        return cursor(r1);
    }

    public void registerCursor(Cursor<E> r5) {
        Iterator<WeakReference<Cursor<E>>> r0 = this.cursors.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin")).get() != null) goto L4;
        r0.remove();
        goto L4
    L8:
        this.cursors.add(new WeakReference(r5));
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void removeAllNodes() {
        if (size() <= 0) goto L8;
        Iterator<E> r1 = iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next();
        r1.remove();
        goto L6
    L10:
        return;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void removeNode(AbstractLinkedList.Node<E> r1) {
        super.removeNode(r1);
        broadcastNodeRemoved(r1);
    }

    public void unregisterCursor(Cursor<E> r5) {
        Iterator<WeakReference<Cursor<E>>> r4 = this.cursors.iterator();
    L4:
        if (r4.hasNext() == false) goto L18;
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(r4.next(), WeakReference.class, "com.obric.memorydata.plugin");
        Cursor<E> r1 = (Cursor) ZeusTransformUtils.preCheckCast(r0.get(), Cursor.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        if (r1 != r5) goto L4;
        r0.clear();
        r4.remove();
        return;
    L7:
        r4.remove();
        goto L4
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void updateNode(AbstractLinkedList.Node<E> r1, E r2) {
        super.updateNode(r1, r2);
        broadcastNodeChanged(r1);
    }
}
