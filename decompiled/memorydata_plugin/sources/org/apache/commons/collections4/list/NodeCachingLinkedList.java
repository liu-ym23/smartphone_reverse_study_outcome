package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public class NodeCachingLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;
    private static final long serialVersionUID = 6897789178562232073L;
    private transient int cacheSize;
    private transient AbstractLinkedList.Node<E> firstCachedNode;
    private int maximumCacheSize;

    public NodeCachingLinkedList() {
        this(20);
    }

    public NodeCachingLinkedList(int r1) {
        this.maximumCacheSize = r1;
        init();
    }

    public NodeCachingLinkedList(Collection<? extends E> r3) {
        super((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        this.maximumCacheSize = 20;
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        doReadObject(r1);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
    }

    public void addNodeToCache(AbstractLinkedList.Node<E> r3) {
        if (isCacheFull() == false) goto L5;
        return;
    L5:
        AbstractLinkedList.Node<E> r0 = this.firstCachedNode;
        r3.previous = null;
        r3.next = r0;
        r3.setValue(null);
        this.firstCachedNode = r3;
        this.cacheSize++;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public AbstractLinkedList.Node<E> createNode(E r2) {
        AbstractLinkedList.Node<E> r0 = getNodeFromCache();
        if (r0 == null) goto L5;
        r0.setValue(r2);
        return r0;
    L5:
        return super.createNode(r2);
    }

    public int getMaximumCacheSize() {
        return this.maximumCacheSize;
    }

    public AbstractLinkedList.Node<E> getNodeFromCache() {
        if (this.cacheSize != 0) goto L5;
        return null;
    L5:
        AbstractLinkedList.Node<E> r0 = this.firstCachedNode;
        this.firstCachedNode = r0.next;
        r0.next = null;
        this.cacheSize--;
        return r0;
    }

    public boolean isCacheFull() {
        if (this.cacheSize < this.maximumCacheSize) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void removeAllNodes() {
        int r0 = Math.min(this.size, this.maximumCacheSize - this.cacheSize);
        AbstractLinkedList.Node<E> r1 = this.header.next;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        AbstractLinkedList.Node<E> r3 = r1.next;
        addNodeToCache(r1);
        r2 = r2 + 1;
        r1 = r3;
        goto L3
    L5:
        super.removeAllNodes();
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void removeNode(AbstractLinkedList.Node<E> r1) {
        super.removeNode(r1);
        addNodeToCache(r1);
    }

    public void setMaximumCacheSize(int r1) {
        this.maximumCacheSize = r1;
        shrinkCacheToMaximumSize();
    }

    public void shrinkCacheToMaximumSize() {
    L3:
        if (this.cacheSize <= this.maximumCacheSize) goto L5;
        getNodeFromCache();
        goto L3
    }
}
