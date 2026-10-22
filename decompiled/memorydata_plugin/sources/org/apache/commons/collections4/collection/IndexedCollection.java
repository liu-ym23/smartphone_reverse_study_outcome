package org.apache.commons.collections4.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;

/* JADX INFO: loaded from: classes6.dex */
public class IndexedCollection<K, C> extends AbstractCollectionDecorator<C> {
    private static final long serialVersionUID = -5512610452568370038L;
    private final MultiMap<K, C> index;
    private final Transformer<C, K> keyTransformer;
    private final boolean uniqueIndex;

    public IndexedCollection(Collection<C> r3, Transformer<C, K> r4, MultiMap<K, C> r5, boolean r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Transformer<C, K> r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        MultiMap<K, C> r9 = (MultiMap) ZeusTransformUtils.wrapperContextForParams(r5, MultiMap.class, "com.obric.memorydata.plugin");
        super(r7);
        this.keyTransformer = r8;
        this.index = r9;
        this.uniqueIndex = r6;
        reindex();
    }

    private void addToIndex(C r3) {
        K r0 = this.keyTransformer.transform(r3);
        if (this.uniqueIndex == true) goto L5;
    L9:
        this.index.put(r0, r3);
        return;
    L5:
        if (this.index.containsKey(r0) == false) goto L9;
        throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
    }

    public static <K, C> IndexedCollection<K, C> nonUniqueIndexedCollection(Collection<C> r3, Transformer<C, K> r4) {
        return new IndexedCollection((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"), MultiValueMap.multiValueMap(new HashMap()), false);
    }

    private void removeFromIndex(C r2) {
        this.index.remove(this.keyTransformer.transform(r2));
    }

    public static <K, C> IndexedCollection<K, C> uniqueIndexedCollection(Collection<C> r3, Transformer<C, K> r4) {
        return new IndexedCollection((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"), MultiValueMap.multiValueMap(new HashMap()), true);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean add(C r2) {
        boolean r0 = super.add(r2);
        if (r0 == false) goto L5;
        addToIndex(r2);
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends C> r3) {
        Iterator r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | add(r4.next());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        super.clear();
        this.index.clear();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean contains(Object r2) {
        return this.index.containsKey(this.keyTransformer.transform(r2));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Iterator r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (contains(r4.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public C get(K r2) {
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(this.index.get(r2), Collection.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return (C) r1.iterator().next();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reindex() {
        this.index.clear();
        Iterator r0 = decorated().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        addToIndex(r0.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean remove(Object r2) {
        boolean r0 = super.remove(r2);
        if (r0 == false) goto L5;
        removeFromIndex(r2);
    L5:
        return r0;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> r3) {
        Iterator r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | remove(r4.next());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super C> r4) {
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (Objects.isNull(r5) == false) goto L5;
        return false;
    L5:
        Iterator<C> r0 = iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        if (r5.test(r0.next()) == false) goto L7;
        r0.remove();
        r1 = true;
        goto L7
    L11:
        if (r1 == false) goto L13;
        reindex();
    L13:
        return r1;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> r3) {
        boolean r4 = super.retainAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        if (r4 == false) goto L5;
        reindex();
    L5:
        return r4;
    }

    public Collection<C> values(K r2) {
        return (Collection) ZeusTransformUtils.preCheckCast(this.index.get(r2), Collection.class, "com.obric.memorydata.plugin");
    }
}
